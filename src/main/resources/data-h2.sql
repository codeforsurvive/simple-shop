-- These values are mapped to Enum class. Changing these might require to change mapped enum class (es).
insert into `enum_groups`(`id`, `name`) values
(10000, 'ROLE'),
(20000, 'ACCESS_LEVEL'),
(30000, 'BANKING_SERVICE_PROVIDER'),
(40000, 'CONTACT_TYPE'),
(50000, 'RESOURCE_GROUP'),
(60000, 'CATEGORY');

-- These values are mapped to Enum class. Changing these might requires to change mapped enum class (es).
insert into `enums` (`id`, `group_id`, `name`) values
-- ROLE
(10001, 10000, 'ADMINISTRATOR'),
(10002, 10000, 'CUSTOMER'),
(10003, 10000, 'SELLER'),

-- ACCESS_LEVEL
(20001, 20000, 'READ'),
(20002, 20000, 'WRITE'),
(20003, 20000, 'DELETE'),
(20004, 20000, 'READ_WRITE'),
(20005, 20000, 'READ_DELETE'),
(20006, 20000, 'FULL'),

-- BANKING_SERVICE_PROVIDER
(30001, 30000, 'BRI'),
(30002, 30000, 'BNI'),
(30003, 30000, 'BCA'),
(30004, 30000, 'MUAMALAT'),
(30005, 30000, 'BSI'),
(30006, 30000, 'BLU'),
(30007, 30000, 'JAGO'),
(30008, 30000, 'JENIUS'),

-- CONTACT_TYPE
(40001, 40000, 'ADDRESS'),
(40002, 40000, 'PHONE'),
(40003, 40000, 'EMAIL'),

-- RESOURCE_GROUP
(50001, 50000, 'HOME'),
(50002, 50000, 'PRODUCT'),
(50003, 50000, 'ORDER'),
(50004, 50000, 'PROFILE'),
(50005, 50000, 'USER_MANAGEMENT')
;


-- Seeding Data
insert into `people` (`name`, `registration_number`) values
('John Doe', '123456789'),
('Jean Doe', '987654321');

insert into `users` (`username`, `password`, `locked`, `role`, `owner_id`) values
('sa', '$2a$12$Mh3IUPUwLbtomFYd7mFyCebs4PkB1TB/q31Qcon7mpgVbJkqYyHre', false, 'ADMINISTRATOR', 1);

insert into `resource_access_controls` (`role`, `access_level`, `resource_group`) values
('ADMINISTRATOR', 'READ', 'HOME'),
('ADMINISTRATOR', 'FULL', 'USER_MANAGEMENT'),
('ADMINISTRATOR', 'FULL', 'PROFILE'),
('ADMINISTRATOR', 'DELETE', 'PRODUCT'),
('SELLER', 'READ', 'HOME'),
('SELLER', 'FULL', 'PRODUCT'),
('SELLER', 'FULL', 'PROFILE'),
('SELLER', 'READ_WRITE', 'ORDER'),
('CUSTOMER', 'READ', 'HOME'),
('CUSTOMER', 'READ', 'PRODUCT'),
('CUSTOMER', 'FULL', 'PROFILE'),
('CUSTOMER', 'READ_WRITE', 'ORDER');













