DROP TABLE bank_system.operations;

DROP TABLE bank_system.operation_points;

DROP TABLE bank_system.checking_accounts;

DROP TABLE bank_system.ATMs;

DROP TABLE bank_system.users;

DROP TABLE bank_system.user_statuses;

DROP TABLE bank_system.currencies;

CREATE TABLE bank_system.currencies (
  id_currency SERIAL  NOT NULL ,
  currency_name VARCHAR(50)      ,
PRIMARY KEY(id_currency));




CREATE TABLE bank_system.user_statuses (
  id_status SERIAL  NOT NULL ,
  status_name VARCHAR(45)    ,
  description TEXT      ,
PRIMARY KEY(id_status));


CREATE TYPE hash_algo_t as ENUM('md5', 'sha512', 'sha256', 'sha128');

CREATE TABLE bank_system.users (
  user_id SERIAL  NOT NULL ,
  id_status INTEGER   NOT NULL ,
  first_name VARCHAR(45)    ,
  last_name VARCHAR(45)    ,
  email VARCHAR(45)    ,
  phone_number VARCHAR(20)    ,
  password_hash VARCHAR(255)    ,
  password_salt VARCHAR(255)    ,
  hashing_algorithm hash_algo_t    ,
  passport_number VARCHAR(20)      ,
PRIMARY KEY(user_id)      ,
  FOREIGN KEY(id_status)
    REFERENCES bank_system.user_statuses(id_status)) INHERITS (bank_system.creation_times);


CREATE INDEX users_FKIndex1 ON bank_system.users (id_status);
CREATE INDEX users_full_name_index ON bank_system.users (last_name, first_name);
CREATE INDEX users_phone_number_index ON bank_system.users (phone_number);


CREATE INDEX IFK_Rel_01 ON bank_system.users (id_status);


CREATE TABLE bank_system.ATMs (
  id_atm SERIAL  NOT NULL ,
  id_currency INTEGER   NOT NULL ,
  position_address VARCHAR(255)    ,
  total_money INTEGER      ,
PRIMARY KEY(id_atm)    ,
  FOREIGN KEY(id_currency)
    REFERENCES bank_system.currencies(id_currency)) INHERITS (bank_system.creation_times);


CREATE INDEX ATMs_FKIndex2 ON bank_system.ATMs (id_currency);
CREATE INDEX ATMs_position_address_index ON bank_system.ATMs (position_address);


CREATE INDEX IFK_Rel_06 ON bank_system.ATMs (id_currency);


CREATE TABLE bank_system.checking_accounts (
  account_id SERIAL  NOT NULL ,
  id_currency INTEGER   NOT NULL ,
  user_id INTEGER   NOT NULL ,
  title TEXT    ,
  card_number VARCHAR(16)    ,
  balance INTEGER      ,
PRIMARY KEY(account_id)      ,
  FOREIGN KEY(user_id)
    REFERENCES bank_system.users(user_id),
  FOREIGN KEY(id_currency)
    REFERENCES bank_system.currencies(id_currency)) INHERITS (bank_system.creation_times);


CREATE INDEX checking_accounts_FKIndex1 ON bank_system.checking_accounts (user_id);
CREATE INDEX checking_accounts_FKIndex2 ON bank_system.checking_accounts (id_currency);
CREATE INDEX checking_accounts_user_index ON bank_system.checking_accounts (user_id);


CREATE INDEX IFK_Rel_02 ON bank_system.checking_accounts (user_id);
CREATE INDEX IFK_Rel_09 ON bank_system.checking_accounts (id_currency);


CREATE TABLE bank_system.operation_points (
  id_operation_point SERIAL  NOT NULL ,
  checking_accounts_account_id INTEGER   NOT NULL ,
  ATMs_id_atm INTEGER   NOT NULL   ,
PRIMARY KEY(id_operation_point)    ,
  FOREIGN KEY(ATMs_id_atm)
    REFERENCES bank_system.ATMs(id_atm),
  FOREIGN KEY(checking_accounts_account_id)
    REFERENCES bank_system.checking_accounts(account_id));


CREATE INDEX operation_points_FKIndex1 ON bank_system.operation_points (ATMs_id_atm);
CREATE INDEX operation_points_FKIndex2 ON bank_system.operation_points (checking_accounts_account_id);


CREATE INDEX IFK_Rel_03 ON bank_system.operation_points (ATMs_id_atm);
CREATE INDEX IFK_Rel_04 ON bank_system.operation_points (checking_accounts_account_id);


CREATE TABLE bank_system.operations (
  id_operation SERIAL  NOT NULL ,
  dst_point INTEGER   NOT NULL ,
  src_point INTEGER   NOT NULL ,
  forward_sum INTEGER    ,
  comission INTEGER      ,
PRIMARY KEY(id_operation)    ,
  FOREIGN KEY(src_point)
    REFERENCES bank_system.operation_points(id_operation_point),
  FOREIGN KEY(dst_point)
    REFERENCES bank_system.operation_points(id_operation_point)) INHERITS (bank_system.creation_times);


CREATE INDEX operations_FKIndex1 ON bank_system.operations (src_point);
CREATE INDEX operations_FKIndex2 ON bank_system.operations (dst_point);


CREATE INDEX IFK_Rel_07 ON bank_system.operations (src_point);
CREATE INDEX IFK_Rel_08 ON bank_system.operations (dst_point);



