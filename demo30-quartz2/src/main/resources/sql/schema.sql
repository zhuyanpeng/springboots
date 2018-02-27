DROP TABLE IF EXISTS config;
create table config(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  c_name varchar(40),
  `c_group` varchar(40),
  c_class_path VARCHAR(240),
  c_method_name VARCHAR(40),
  c_status varchar(3),
  c_cron varchar(40),
  primary key(id)
);