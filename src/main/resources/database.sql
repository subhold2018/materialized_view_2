drop table customer;
CREATE TABLE customer
(
  empl_id varchar2(15) NOT NULL,
  source_name varchar2(10) NOT NULL,
  constituent_id varchar2(40),
  CONSTRAINT customers_pk PRIMARY KEY (empl_id,source_name)
);


drop table customer_lookup;
CREATE TABLE customer_lookup
(
  empl_id varchar2(15) NOT NULL,
  source_name varchar2(10) NOT NULL,
  scc_uid varchar2(40),
  CONSTRAINT customer_lookup_pk PRIMARY KEY (empl_id,source_name)
);

drop table email_lookup;
CREATE TABLE email_lookup
(
  source_id varchar2(15) NOT NULL,
  source_name varchar2(10) NOT NULL,
  constituent_id varchar2(40),
  email_type varchar2(50) NOT NULL,
  email varchar2(50) NOT NULL,
  CONSTRAINT email_lookup_pk PRIMARY KEY (source_id,source_name,email_type)
);

drop table email_lookup_identity;
CREATE TABLE email_lookup_identity
(
  source_id varchar2(15) NOT NULL,
  source_name varchar2(10) NOT NULL,
  constituent_id varchar2(40),
  email_type varchar2(50) NOT NULL,
  email varchar2(50) NOT NULL,
  ucb_uuid varchar2(30),
  ucb_identity_key varchar2(30),
  CONSTRAINT email_lookup_identity_pk PRIMARY KEY (source_id,source_name,email_type)
);



select * from customer;
select * from customer_lookup;
select * from email_lookup;
select * from email_lookup_identity;