INSERT INTO `building` (`id`, `name`, `street`, `ward`, `structure`, `numberofbasement`, `floorarea`, `direction`, `level`, `rentprice`, `rentpricedescription`, `servicefee`, `carfee`, `motorbikefee`, `overtimefee`, `waterfee`, `electricityfee`, `deposit`, `payment`, `renttime`, `decorationtime`, `brokeragefee`, `note`, `linkofbuilding`, `map`, `image`, `managerName`, `managerPhone`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
(1, 'Nam Giao Building Tower', '59 phan xích long', 'Phường 2', NULL, 2, 500, 'Dong', 'A', 15, '15 triệu/m2', '4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0.70', NULL, NULL, NULL, NULL, 'Nguyen Van A', '0909090900', '2022-11-19 23:45:01', NULL, NULL, NULL),
(2, 'ACM Tower', '96 cao thắng', 'Phường 4', NULL, 2, 650, NULL, NULL, 18, '18 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Alpha 2 Building Tower', '153 nguyễn đình chiểu', 'Phường 6', NULL, 1, 200, 'Tây bắc', 'C', 20, '20 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'IDD 1 Building', '111 Lý Chính Thắng', 'Phường 7', 3, NULL, 200, NULL, NULL, 12, '12 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);


INSERT INTO `rentarea` (`id`, `value`, `buildingid`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
(1, 100, 1, NULL, NULL, NULL, NULL),
(2, 200, 1, NULL, NULL, NULL, NULL),
(3, 200, 2, NULL, NULL, NULL, NULL),
(4, 300, 2, NULL, NULL, NULL, NULL),
(5, 400, 2, NULL, NULL, NULL, NULL),
(6, 300, 3, NULL, NULL, NULL, NULL),
(7, 400, 3, NULL, NULL, NULL, NULL),
(8, 500, 3, NULL, NULL, NULL, NULL),
(9, 100, 4, NULL, NULL, NULL, NULL),
(10, 400, 4, NULL, NULL, NULL, NULL),
(11, 250, 4, NULL, NULL, NULL, NULL);

INSERT INTO `role` (`id`, `name`, `code`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
(1, 'Quản lý', 'manager', NULL, NULL, NULL, NULL),
(2, 'Nhân viên', 'staff', NULL, NULL, NULL, NULL),
(3, 'Quản trị hệ thống', 'ADMIN', NULL, NULL, NULL, NULL),
(4, 'người dùng', 'USER', NULL, NULL, NULL, NULL),
(5, 'Quản trị hệ thống', 'ADMIN', NULL, NULL, NULL, NULL),
(6, 'người dùng', 'USER', NULL, NULL, NULL, NULL);

INSERT INTO `user` (`id`, `username`, `password`, `fullname`, `phone`, `email`, `status`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
(1, 'nguyenvana', '123456', 'nguyen van a', '0902920090, 0962915348', NULL, 1, NULL, NULL, NULL, NULL),
(2, 'nguyenvanb', '123456', 'nguyen van b', '0909000123', NULL, 1, NULL, NULL, NULL, NULL),
(3, 'nguyenvanc', '123456', 'nguyen van c', NULL, NULL, 1, NULL, NULL, NULL, NULL),
(4, 'nguyenvand', '123456', 'nguyen van d', NULL, NULL, 1, NULL, NULL, NULL, NULL),
(5, 'admin', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 'admin', NULL, NULL, 1, NULL, NULL, NULL, NULL);

INSERT INTO `user_role` (`id`, `roleid`, `userid`) VALUES
(1, 3, 5),
(2, 5, 5);