CREATE TABLE  authorities(
    authid int not null PRIMARY KEY AUTO_INCREMENT,
    name varchar(255)
);

insert into  authorities (authority) values ('ROLE_ADMIN'), ('ROLE_USER');

