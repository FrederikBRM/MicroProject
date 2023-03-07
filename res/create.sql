use master;
if exists (select * from sys.databases where name='miniproject')
	drop database miniproject;
go

create database miniproject;
go

use miniproject;

create table groups (
	id int primary key identity(1,1),
	name varchar(64),
	description varchar(255)
)

create table persons (
	id int primary key identity(1,1),
	name varchar(50),
	email varchar(120),
	phone varchar(25),
	birth_date date,
	groups_id int not null foreign key references groups(id) on delete cascade on update cascade
)
-- goups_id is "not null" thus implementing the [Group] -1---*- [Person] class diagram requirment

insert into groups values('friends', 'all my buddies');
insert into groups values('family', 'my dear beloved family');
insert into persons values('Joe', 'joe@email.com', '12121212', '1995-05-05', 1);
insert into persons values('Mom', 'mom@email.com', '1234567', '1965-05-07', 2);
insert into persons values('Dad', 'dad@email.com', '1234567', '1963-03-03', 2);

select * from groups, persons where groups.id = persons.groups_id;
