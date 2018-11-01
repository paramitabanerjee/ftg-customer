

CREATE TABLE `Customer` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Email` varchar(45) NOT NULL,
  `Phone` varchar(45) NOT NULL,
  `Address1` varchar(45) DEFAULT NULL,
  `Address2` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` char(2) DEFAULT NULL,
  `Zip` int(11) NOT NULL,
  `PIN` int(11) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  `StripeCustomerID` varchar(45) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `LastUpdated` datetime DEFAULT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  UNIQUE KEY `Phone_UNIQUE` (`Phone`),
  KEY `ZIP_Index` (`Zip`)
);

CREATE TABLE `Listings` (
  `ListingID` int(11) NOT NULL,
  `MenuId` int(11) DEFAULT NULL,
  `MealType` tinyint(4) DEFAULT NULL,
  `OfferDate` datetime DEFAULT NULL,
  `Count` tinyint(4) DEFAULT NULL,
  `SoldCount` tinyint(4) DEFAULT NULL,
  `Price` decimal(10,0) DEFAULT NULL,
  `Currency` char(3) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `Expired` datetime DEFAULT NULL,
  `Geo` varchar(45) DEFAULT NULL,
  `Addr1` varchar(45) DEFAULT NULL,
  `Addr2` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` char(2) DEFAULT NULL,
  `Zip` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ListingID`)
) ;

CREATE TABLE `MealType` (
  `MealTypeID` int(1) NOT NULL,
  `MealType` varchar(10) NOT NULL,
  PRIMARY KEY (`MealTypeID`),
  UNIQUE KEY `MealTypeID_UNIQUE` (`MealTypeID`)
) ;

CREATE TABLE `Menu` (
  `MenuID` int(11) NOT NULL AUTO_INCREMENT,
  `MenuName` varchar(45) DEFAULT NULL,
  `SupplierId` int(11) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `LastUpdated` datetime DEFAULT NULL,
  PRIMARY KEY (`MenuID`),
  UNIQUE KEY `MenuID_UNIQUE` (`MenuID`)
);

CREATE TABLE `Order` (
  `OrderID` bigint(20) NOT NULL,
  `CustomerId` varchar(45) DEFAULT NULL,
  `PaymentID` varchar(15) DEFAULT NULL,
  `OrderItemsJSON` varchar(255) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  PRIMARY KEY (`OrderID`)
) ;
CREATE TABLE `OrderStatusType` (
  `OrderStatusTypeID` tinyint(4) NOT NULL,
  `OrderStatus` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`OrderStatusTypeID`)
);
CREATE TABLE `PaymentHistory` (
  `PaymentID` bigint(20) NOT NULL AUTO_INCREMENT,
  `OrderID` bigint(20) DEFAULT NULL,
  `Amount` decimal(10,0) DEFAULT NULL,
  `Currency` char(3) DEFAULT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `PaymentMethodID` int(11) DEFAULT NULL,
  `PaymentStatus` tinyint(4) DEFAULT NULL,
  `PaymentError` varchar(255) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  PRIMARY KEY (`PaymentID`)
) ;
CREATE TABLE `PaymentStatusType` (
  `PaymentStatusTypeId` tinyint(4) NOT NULL,
  `PaymentStatus` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`PaymentStatusTypeId`)
);
CREATE TABLE `PaymentType` (
  `PaymentTypeId` tinyint(4) NOT NULL,
  `PaymentType` varchar(15) NOT NULL,
  PRIMARY KEY (`PaymentTypeId`),
  UNIQUE KEY `PaymentTypeId_UNIQUE` (`PaymentTypeId`)
);
CREATE TABLE `Roles` (
  `RoleID` int(11) NOT NULL,
  `RoleName` varchar(15) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`RoleID`),
  UNIQUE KEY `RoleID_UNIQUE` (`RoleID`)
);
CREATE TABLE `Supplier` (
  `SupplierId` int(11) NOT NULL AUTO_INCREMENT,
  `FisrtName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Email` varchar(45) NOT NULL,
  `Phone` varchar(45) NOT NULL,
  `Address1` varchar(45) DEFAULT NULL,
  `Address2` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` char(2) DEFAULT NULL,
  `Zip` int(11) NOT NULL,
  `PIN` int(11) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `LastUpdated` datetime DEFAULT NULL,
  `SSN` varchar(45) DEFAULT NULL,
  `License` varchar(45) DEFAULT NULL,
  `LicenseState` char(2) DEFAULT NULL,
  PRIMARY KEY (`SupplierId`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  UNIQUE KEY `Phone_UNIQUE` (`Phone`),
  UNIQUE KEY `SupplierId_UNIQUE` (`SupplierId`),
  KEY `ZIP_Index` (`Zip`)
) ;
CREATE TABLE `SupplierPaymentInfo` (
  `SupplierId` int(11) NOT NULL,
  `AccountNo` bigint(20) DEFAULT NULL,
  `RoutingNo` bigint(20) DEFAULT NULL,
  `BankName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SupplierId`),
  CONSTRAINT `Supplier_FK` FOREIGN KEY (`SupplierId`) REFERENCES `supplier` (`supplierid`)
);
