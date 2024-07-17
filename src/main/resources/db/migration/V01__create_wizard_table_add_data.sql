create table if not exists wizard(
    id varchar(8) not null,
    name varchar(50) not null,
    house varchar(10) not null,
    is_student TINYINT(1) not null,
    primary key(id)
);

insert into wizard (id, name, house, is_student) values('t811825', 'Harry Potter', 'Grifinória', 1);
insert into wizard (id, name, house, is_student) values('x1285016', 'Tom Riddle', 'Sonserina', 0);