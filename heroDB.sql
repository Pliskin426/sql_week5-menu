create database if not exists heros;

use heros;

drop table if exists hero;
drop table if exists power;
drop table if exists teams;


create table teams (
	id int(11) not null auto_increment,
	team_name varchar(20) not null, 
	primary key (id)
);

create table hero (
	id int(11) not null auto_increment, 
	name varchar(25) not null,
	power_class varchar(40) not null,
	ability varchar(40) not null,
	power_index int(200) not null,
	team_id int(11) not null,
	primary key (id),
	foreign key (team_id) references teams(id)
);
