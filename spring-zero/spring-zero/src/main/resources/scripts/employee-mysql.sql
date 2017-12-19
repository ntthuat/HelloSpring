-- TABLE EMPLOYEE --
DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  ID int(11) NOT NULL,
  NAME varchar(11) NOT NULL
);
INSERT INTO employee (ID, `NAME`) VALUES
(1, 'Robert'),
(2, 'Max'),
(3, 'Thuat'),
(4, 'Nick');

ALTER TABLE employee
  ADD PRIMARY KEY (ID);
  
ALTER TABLE employee
ADD COLUMN salary_level varchar(11) AFTER NAME;

UPDATE employee SET salary_level='ASE' WHERE id=1;
UPDATE employee SET salary_level='PSE' WHERE id=2;
UPDATE employee SET salary_level='SE' WHERE id=3;
UPDATE employee SET salary_level='SSE' WHERE id=4;
/*
ALTER TABLE employee
ADD COLUMN salary_net int(11) AFTER salary_level;
UPDATE employee
SET salary_net = (
  SELECT salary_net
  FROM salary
  WHERE salary_level = employee.salary_level
);
*/

--TABLE SALARY
DROP TABLE IF EXISTS salary;
CREATE TABLE salary (
  SALARY_LEVEL varchar(11) NOT NULL,
  SALARY_NET int(11) NOT NULL
);
INSERT INTO salary (SALARY_LEVEL, SALARY_NET) VALUES
('ASE', 500),
('SE', 1000),
('SSE', 1500),
('PSE', 2000);
ALTER TABLE salary
  ADD PRIMARY KEY (SALARY_LEVEL);


-- TABLE STUDENT --
DROP TABLE IF EXISTS student;
CREATE TABLE student (
  ID INT NOT NULL,
  NAME VARCHAR(45) NOT NULL
 );
 
 INSERT INTO student (ID, `NAME`) VALUES
(1, 'John'),
(2, 'Max'),
(3, 'Thuat'),
(4, 'Alistair');
ALTER TABLE student
  ADD PRIMARY KEY (ID);
