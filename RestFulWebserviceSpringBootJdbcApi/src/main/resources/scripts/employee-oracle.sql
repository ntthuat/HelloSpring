CREATE TABLE EMPLOYEE (	
	UNIQUE_NUMBER NUMBER(19,0) NOT NULL,  --data_default = (null)
	NAME NVARCHAR2(50) DEFAULT chr(0) NOT NULL,  --data_default = char(0)
	PRIMARY KEY (UNIQUE_NUMBER)
);
commit;
CREATE SEQUENCE EMPLOYEE_SEQUENCE START WITH 1;
commit;
