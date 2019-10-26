CREATE DATABASE HumanResource_payroll;

--Admin 
use HumanResource_payroll;

CREATE TABLE admininfo(
 adminid int identity(1,1) primary key,
 username varchar(30),
 password varchar(30)

);

INSERT INTO ADMININFO VALUES('zakia','1234');
INSERT INTO ADMININFO VALUES('shimul','5678');

select * from admininfo;

--Employee
use HumanResource_payroll;
CREATE TABLE employee
( 
  EmployeeId int identity(1,1)PRIMARY KEY,
  FirstName varchar(20) NOT NULL,
  LastName varchar(20)NOT NULL,
  Gender varchar(10) NOT NULL,
  DOB date NOT NULL,
  MobileNoPersonal VARCHAR(15)NOT NULL,
  MobileNoOffice VARCHAR(15)NOT NULL,
  Email VARCHAR(50) NOT NULL,
  Designation VARCHAR(20) NOT NULL,
  Department VARCHAR(20)NOT NULL,
  EmployeeJoiningDate DATE NOT NULL,
  EmployeeLeavingDate DATE NULL,
  Pass varchar(50) Not Null
);

--Adress_location

use HumanResource_payroll;
CREATE TABLE ADDRESS_LOCATION
(
  
  EmployeeId int NOT NULL FOREIGN KEY REFERENCES employee (EmployeeId ) primary key, 
  Village varchar(30) not null,
  PostOffice varchar(30) not null,
  District varchar (30) not null
);

select * from employee;
select * from ADDRESS_LOCATION;


select employee.*,ADDRESS_LOCATION.* from employee  FULL JOIN ADDRESS_LOCATION  ON employee.EmployeeId=ADDRESS_LOCATION.EmployeeId where employee.EmployeeId='1'


use HumanResource_payroll;
CREATE TABLE user_profiles
(
  
  EmployeeId int  NOT NULL FOREIGN KEY REFERENCES employee (EmployeeId) primary key, 
  Email VARCHAR(50) NOT NULL,
  Pass Varchar(50) Not Null
);

select * from user_profiles;

use HumanResource_payroll;
create Table employee_salary(
  EmployeeId int  NOT NULL FOREIGN KEY REFERENCES employee (EmployeeId) primary key,
  BasicSalary int NOT NULL ,
  MedicalAllownce int NOT NULL,
  HourlyRate int Not NULL,

   
);
select * from employee_salary

use HumanResource_payroll;
create Table Salary(
	SalaryId int NOT NULL IDENTITY(1000,1),
	SalaryCatagory varchar(20) NOT NULL,
	Salary int Not NULL,
	PRIMARY KEY(SalaryId,SalaryCatagory)
)
INSERT INTO Salary values ('CEO',100000);
INSERT INTO Salary values('Budget analyst',20000);
INSERT INTO Salary values('Cash manager',25000);
INSERT INTO Salary values('Controller',30000);
INSERT INTO Salary values('Auditor',35000);
INSERT INTO Salary values('Software developer',45000);


select * from Salary;


select employee.FirstName  from employee  full join user_profiles on employee.EmployeeId=user_profiles.EmployeeId where user_profiles.EmployeeId ='1';


create table Employee_Working_Hours(
ID int NOT NULL IDENTITY(10,1) , 
EmployeeId int  NOT NULL FOREIGN KEY REFERENCES employee (EmployeeId) ,
WorkingHours  int Not NUll ,
DateOfWork Date Not Null
)
Alter Table Employee_Working_Hours add primary key (ID);
insert into Employee_Working_Hours values (1,4000,'2019-04-05');
select * from Employee_Working_Hours;





select sum(WorkingHours) from Employee_Working_Hours where DateOfWork like '2019-04-%' and EmployeeId=1

Select BasicSalary,MedicalAllownce,HourlyRate from employee_salary where EmployeeId='4'

