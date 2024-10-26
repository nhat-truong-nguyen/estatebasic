insert into role(code,name) values('ADMIN','Quản trị hệ thống');
insert into role(code,name) values('USER','người dùng');

insert into users(username,password,fullname,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','admin',1),
('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van a',1),
('nguyen van b','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 'nguyenvanb',1),
('nguyen van c','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 'nguyenvanc',1),
('nguyen van d','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 'nguyenvand',1);

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);
INSERT INTO user_role(user_id,role_id) VALUES (3,2);
INSERT INTO user_role(user_id,role_id) VALUES (4,2);
INSERT INTO user_role(user_id,role_id) VALUES (5,2);

INSERT INTO `building` (`createdby`, `createddate`, `modifiedby`, `modifieddate`, `brokeragefee`, `carfee`, `decorationtime`, `deposit`, `direction`, `district`, `electricityfee`, `floorarea`, `image`, `level`, `linkofbuilding`, `managername`, `managerphone`, `map`, `motorbikefee`, `name`, `note`, `numberofbasement`, `overtimefee`, `payment`, `rentareadescription`, `rentprice`, `rentpricedescription`, `renttime`, `servicefee`, `street`, `structure`, `type`, `ward`, `waterfee`) VALUES
(NULL, NULL, NULL, NULL, 0.7, '', '', '', '', 'QUAN_1', '', 500, NULL, '', NULL, 'nguyen van b', '01234567890', NULL, '', 'Nam Giao Building Tower', '', 2, '4', '', '290m2(lầu lừng), 150m2(lầu 4)', 15, '15 triệu/m2', '', '4', '59 phan xích long', '', 'TANG_TRET,NGUYEN_CAN', 'Phường 2', NULL),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'QUAN_2', NULL, 650, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ACM Tower', NULL, 2, NULL, NULL, NULL, 18, '18 triệu/m2', NULL, NULL, '96 cao thắng', NULL, 'NGUYEN_CAN', 'Phường 4', NULL),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'QUAN_1', NULL, 200, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Alpha 2 Building Tower', NULL, 1, NULL, NULL, NULL, 20, '20 triệu/m2', NULL, NULL, '153 nguyễn đình chiểu', NULL, 'NOI_THAT', 'Phường 6', NULL),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'QUAN_1', NULL, 500, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Nam Giao Building Tower', NULL, 2, NULL, NULL, NULL, 15, '15 triệu/m2', NULL, NULL, '59 phan xích long', NULL, 'TANG_TRET,NGUYEN_CAN', 'Phường 2', NULL),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'QUAN_2', NULL, 650, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ACM Tower', NULL, 2, NULL, NULL, NULL, 18, '18 triệu/m2', NULL, NULL, '96 cao thắng', NULL, 'NGUYEN_CAN', 'Phường 4', NULL);







