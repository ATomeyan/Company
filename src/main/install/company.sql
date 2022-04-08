create table if not exists position (
    id int not null auto_increment primary key,
    name varchar(255) not null
);

create table if not exists department (
    id int not null auto_increment primary key,
    name varchar(255) not null
);

create table if not exists employee (
    id int not null auto_increment primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    date_of_birth date not null,
    email varchar(255) not null,
    gender enum('M', 'F') not null,
    isActive boolean not null,

    position_id int not null,
    department_id int not null,
    constraint foreign key (position_id) references position (id),
    constraint foreign key (department_id) references department(id)
);

create table if not exists attendance_record (
    id int not null auto_increment primary key,
    entrance_time datetime not null,
    exit_time datetime not null,

    employee_id int not null,
    constraint foreign key (employee_id) references employee(id)
)