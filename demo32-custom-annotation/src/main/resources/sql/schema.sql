DROP TABLE  IF EXISTS permissions;
create table permissions(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_id varchar(40),
  `permission` int(40),
  primary key(id)
);