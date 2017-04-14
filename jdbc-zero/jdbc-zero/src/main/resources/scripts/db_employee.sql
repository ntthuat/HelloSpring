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
