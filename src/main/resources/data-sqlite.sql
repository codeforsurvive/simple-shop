-- These values are mapped to Enum class. Changing these might require to change mapped enum class (es).
insert into `enum_groups`(`id`, `name`) values
(10000, 'ROLE'),
(20000, 'ACCESS_LEVEL')
(30000, 'MENU')
(40000, 'BANKING_SERVICE_PROVIDER')
;

-- These values are mapped to Enum class. Changing these might requires to change mapped enum class (es).
insert into `enums` (`id`, `group_id`, `name`) values
(10001, 10000, 'ADMINISTRATOR'), (10002, 10000, 'CUSTOMER'), (10003, 10000, 'SELLER');

insert into `enums` (`id`, `group_id`, `name`) values
(20001, 20000, 'READ'), (20002, 20000, 'WRITE'), (20003, 20000, 'DELETE'),
(20004, 20000, 'READ_WRITE'),(20005, 20000, 'FULL');
















