create database `hb_student_tracker`;
create table users(
	id int not null primary key auto_increment,
    user_name varchar(255) not null,
    password varchar(255) not null,
    full_name varchar(255) not null,
    email varchar(255) not null,
    address varchar(255) not null,
    phone_number varchar(255) not null,
    note varchar(255),
    status int(11) not null,
    role_id int(11) not null,

    foreign key (role_id) references roles(id)
    )ENGINE=InnoDB;
    
insert into users(id, user_name, password, full_name, email, address, phone_number, note, status, role_id)
values (1, "Khach hang A", "123", "A", "@gmail", "Dia chi A", "12345", "Note A", 1, 1);
insert into users(user_name, password, full_name, email, address, phone_number, note, status, role_id)
values ("Khach hang B", "123", "B", "@gmail", "Dia chi B", "12345", "Note B", 1, 1);
delete from users;
select * from users;

create table roles(
	id int not null primary key,
    role_name varchar(255) not null);
insert into roles values (1, "ADMIN"), (2, "USER");
select * from roles;
    
create table donations(
	id int not null primary key auto_increment,
    code varchar(255) not null,
    name varchar(255) not null,
    description varchar(255) not null,
    money int(11) not null,
    start_date date not null,
    end_date date not null,
    status int(11),
    organization_name varchar(255) not null,
    phone_number varchar(255) not null,
    created_at datetime default now());
insert into donations values (1, "123", "Khách hàng A", "Quyên góp", 100000, now(), now(), 1, "To chuc A", "01234567890", now());
select * from donations;

create table users_donations(
	id int not null primary key auto_increment,
    user_id int(11) not null,
    donation_id int(11) not null,
    money int(11) not null,
    name varchar(255) not null,
    status int(11) not null,
    text varchar(255),
    created_at datetime default now(),
    foreign key (user_id) references users(id) on delete cascade,
    foreign key (donation_id) references donations(id) on delete cascade);
drop table users_donations;