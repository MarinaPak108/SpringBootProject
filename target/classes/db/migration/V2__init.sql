CREATE TABLE members(
                     memberid int not null PRIMARY KEY AUTO_INCREMENT,
                     memberlogin varchar (255) UNIQUE not null,
                     memberpassword varchar(255),
                     memberrole int references  authorities(authid)

);

insert into members(memberlogin, memberpassword, memberrole) VALUES
('admin1', 'adminpwd1', 1),('user1', 'userpwd1', 2), ('user2', 'userpwd2', 2);

