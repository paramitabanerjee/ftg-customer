
INSERT INTO `Roles` (`RoleID`,`RoleName`,`Description`) VALUES (1,'Admin','Account verification and admin activities');
INSERT INTO `Roles` (`RoleID`,`RoleName`,`Description`) VALUES (2,'Customer','Buyers');
INSERT INTO `Roles` (`RoleID`,`RoleName`,`Description`) VALUES (3,'Supplier','Sellers');

INSERT INTO `PaymentStatusType` (`PaymentStatusTypeId`,`PaymentStatus`) VALUES (1,'SUCCESS');
INSERT INTO `PaymentStatusType` (`PaymentStatusTypeId`,`PaymentStatus`) VALUES (2,'DECLINE');
INSERT INTO `PaymentStatusType` (`PaymentStatusTypeId`,`PaymentStatus`) VALUES (3,'FAILED');

INSERT INTO `OrderStatusType` (`OrderStatusTypeID`,`OrderStatus`) VALUES (1,'SUBMITTED');
INSERT INTO `OrderStatusType` (`OrderStatusTypeID`,`OrderStatus`) VALUES (2,'PROCESSING');
INSERT INTO `OrderStatusType` (`OrderStatusTypeID`,`OrderStatus`) VALUES (3,'FAILED');
INSERT INTO `OrderStatusType` (`OrderStatusTypeID`,`OrderStatus`) VALUES (4,'COMPLETED');
INSERT INTO `OrderStatusType` (`OrderStatusTypeID`,`OrderStatus`) VALUES (5,'DISPUTED');

INSERT INTO `MealType` (`MealTypeID`,`MealType`) VALUES (1,'Breakfast');
INSERT INTO `MealType` (`MealTypeID`,`MealType`) VALUES (2,'Lunch');
INSERT INTO `MealType` (`MealTypeID`,`MealType`) VALUES (3,'Dinner');
