
INSERT INTO `Roles` (`RoleID`,`RoleName`,`Description`) VALUES (1,'Admin','Account verification and admin activities');
INSERT INTO `Roles` (`RoleID`,`RoleName`,`Description`) VALUES (2,'Customer','Buyers');
INSERT INTO `Roles` (`RoleID`,`RoleName`,`Description`) VALUES (3,'Supplier','Sellers');

INSERT INTO `PaymentType` (`PaymentTypeId`,`PaymentType`) VALUES (1,'CREDIT');
INSERT INTO `PaymentType` (`PaymentTypeId`,`PaymentType`) VALUES (2,'DEBIT');
INSERT INTO `PaymentType` (`PaymentTypeId`,`PaymentType`) VALUES (3,'PAYPAL');
INSERT INTO `PaymentType` (`PaymentTypeId`,`PaymentType`) VALUES (4,'APPLEPAY');
INSERT INTO `PaymentType` (`PaymentTypeId`,`PaymentType`) VALUES (5,'CRYPTO');

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
