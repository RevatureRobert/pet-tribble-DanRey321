-- Script Did not have time to implement changed erd.


create table Tribble(
	ID serial primary key,
	name varchar(255),
	color varchar(255),
	noise varchar(255),
	description varchar(255)
);


select * from tribble ;
--delete from tribble where id = 2;
--update tribble set name = 'Rocky Balboa' where id = 1;


insert into Tribble (name, color, noise, description)
values ( 'Rocky', 'Grey', 'Squek' , 'Furry and large');

insert into Tribble (name, color, noise, description)
values ( 'BuilderMcGee', 'White', 'Squek' , 'Furry and large');

insert into Tribble (name, color, noise, description)
values ( 'RocksALot', 'Tan', 'coo' , 'Spikes and Medium');



create table Labs(
	LabId serial,
	labName varchar(255),
	tribbleID int,
	constraint tribble_fk foreign key(tribbleID) references Tribble(ID)
);

--Did not have time to fix with these next two tables
--create table Lab(
--	LabId serial primary Key,
--	labName varchar(255)
--);

--create table Tribble_labs(
--	tribbleID int,
--	labID int,
--	constraint tribble_fk foreign key(tribbleID) references Tribble(ID),
--	constraint lab_fk foreign key(labID) references Lab(labID)
--)
--

--drop table Lab;
--select * from labs;
--select tribble.name from labs , tribble where tribble.id = labs.labid and labid = 1;


insert into Labs(labId, labname, tribbleID )
values (1, 'Lab 1', 1);

insert into Labs(labId, labname, tribbleID )
values (1, 'Lab 1', 3);

insert into Labs(labId, labname, tribbleID )
values (2, 'Lab 2', 4);
