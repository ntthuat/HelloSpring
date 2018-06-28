CREATE OR REPLACE PROCEDURE "QRE"."SP_RESET_UNIQUE_NUMBER" (p_SchemaName IN VARCHAR2, p_TableName VARCHAR2)
    IS
    query_str 			CLOB;
	v_min_gap_number 	NUMBER(19,0);
BEGIN
	
	-- 1. Disable triggers on input table.
	query_str := 'ALTER TABLE '||p_SchemaName||'."'||p_TableName||'" DISABLE ALL TRIGGERS';
    
	EXECUTE IMMEDIATE query_str;
	
	query_str := '';
	
	-- 2. Identify the minimum value in a sequence is missing.
	query_str := 
		'select min(startVal) ' ||
		'from ( ' ||
				'select (m.UNIQUE_NUMBER + 1) startVal, ' ||
				'(select (min(UNIQUE_NUMBER) - 1) from ' || p_SchemaName||'.'|| p_TableName|| ' x where x.UNIQUE_NUMBER > m.UNIQUE_NUMBER) stopVal ' ||
				 'from ' || p_SchemaName||'.'|| p_TableName|| ' m ' ||
				 'left outer join ' || p_SchemaName||'.'|| p_TableName|| ' r ' ||
				 'on m.UNIQUE_NUMBER = (r.UNIQUE_NUMBER - 1) ' ||
				 'where r.UNIQUE_NUMBER is null ' ||
			') x ' ||
		'where stopVal is not null';
    
	EXECUTE IMMEDIATE query_str INTO v_min_gap_number;

	query_str := '';
	
	-- 3. Create the TMP_SEQ sequence with min value is v_min_gap_number
	query_str := 	'CREATE SEQUENCE ' || p_SchemaName || '."TMP_SEQ"  MINVALUE ' || v_min_gap_number || ' MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 ' ||
					'START WITH ' || v_min_gap_number || ' CACHE 20 NOORDER  NOCYCLE';
    
    EXECUTE IMMEDIATE query_str;
	
	query_str := '';
	
	-- 4. Create the temporary table with additional ID column. 
	-- This column holds only sequence values with start value is the minimum value in a sequence is missing.
	query_str := 	'CREATE TABLE ' || p_SchemaName ||'.'|| p_TableName|| '_TMP' || ' AS ' ||
					'SELECT ' || p_SchemaName || '."TMP_SEQ".NEXTVAL ID, x.* ' ||
					'from (select * from ' || p_SchemaName ||'.'|| p_TableName || ' WHERE UNIQUE_NUMBER > ' || v_min_gap_number ||
					' ORDER BY UNIQUE_NUMBER) x';

    EXECUTE IMMEDIATE query_str;
	
	-- 5. Add ID column into the original table.
	query_str := 'ALTER TABLE ' || p_SchemaName ||'.'|| p_TableName|| ' ADD ID NUMBER';
	EXECUTE IMMEDIATE query_str;
	
    query_str := '';
    
    -- 6. Update ID in the original table by using the temporary table.
    query_str := 
        'MERGE /*+ first_rows parallel(' || p_SchemaName ||'.'|| p_TableName|| ') parallel(' || p_SchemaName ||'.'|| p_TableName|| '_TMP' || ') */ ' || 
        ' INTO ' || p_SchemaName ||'.'|| p_TableName ||
        ' USING ' || p_SchemaName ||'.'|| p_TableName|| '_TMP' || ' new ' ||
        ' ON (' || p_SchemaName ||'.'|| p_TableName || '.UNIQUE_NUMBER = new.UNIQUE_NUMBER)' ||
        ' WHEN MATCHED THEN ' ||
            ' UPDATE SET ID = new.ID';
    
    EXECUTE IMMEDIATE query_str; 
    COMMIT;
    
    query_str := '';
    
    -- 7. Update UNIQUE_NUMBER in the original table by using ID in the temporary table.
    query_str :=
        'MERGE /*+ first_rows parallel(' || p_SchemaName ||'.'|| p_TableName|| ') parallel(' || p_SchemaName ||'.'|| p_TableName|| '_TMP' || ') */ ' ||
        ' INTO ' || p_SchemaName ||'.'|| p_TableName ||
        ' USING ' || p_SchemaName ||'.'|| p_TableName|| '_TMP' || ' new ' || 
        ' ON (' || p_SchemaName ||'.'|| p_TableName || '.ID = new.ID)' ||
        ' WHEN MATCHED THEN ' ||
            ' UPDATE SET UNIQUE_NUMBER = new.ID';
    
    EXECUTE IMMEDIATE query_str; 
    COMMIT;
    
    query_str := '';
    
    -- 8. Drop ID column from the original table.
	query_str := 'ALTER TABLE ' || p_SchemaName ||'.'|| p_TableName|| ' DROP COLUMN ID';
	EXECUTE IMMEDIATE query_str;
    
    query_str := '';
    
    -- 9. Enable triggers on the original table.
	query_str := 'ALTER TABLE '||p_SchemaName||'."'||p_TableName||'" ENABLE ALL TRIGGERS';
    
	EXECUTE IMMEDIATE query_str;
	
	query_str := '';
    
    -- 10. Drop temporary sequence.
    query_str := 'DROP SEQUENCE '|| p_SchemaName ||'."TMP_SEQ"';
    
	EXECUTE IMMEDIATE query_str;
	
	query_str := '';
    
    -- 11. Drop the temporary table.
    query_str := 'DROP TABLE '|| p_SchemaName ||'.' || p_TableName || '_TMP' || ' PURGE'; 
    EXECUTE IMMEDIATE query_str;
    
    query_str := '';
    
End SP_RESET_UNIQUE_NUMBER;
/