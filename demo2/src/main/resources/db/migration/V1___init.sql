CREATE  TABLE application_user (
  user_name VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (user_name));

CREATE TABLE user_role (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_name varchar(255) NOT NULL,
  role varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uni_user_name_role (role,user_name),
  KEY fk_user_name_idx (user_name),
CONSTRAINT fk_user_name FOREIGN KEY (user_name) REFERENCES application_user (user_name));
insert into application_user VALUES ('admin', '$2a$10$710JPn0Q79jGRiyCdZ153.PWfQZxW5l3XOisOsCVC85oP681ZLbTW', true);
insert into user_role (user_name, role) VALUES ('admin','ADMIN');
insert into user_role (user_name, role) VALUES ('admin','USER');