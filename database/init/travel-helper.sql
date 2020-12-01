/*
Created		11/29/2020
Modified		11/30/2020
Project		
Model		
Company		
Author		Truongkyle
Version		
Database		MS SQL 7 
*/

USE master
GO


DROP DATABASE TRAVELHELPER
--========== TẠO DATABASE  ==========--
CREATE DATABASE TRAVELHELPER
GO

USE TRAVELHELPER
GO


-- GENERATE QUERY IN HERE

Create table [events] (
	[eventID] Integer Identity NOT NULL UNIQUE,
	[eventTypeID] Integer NOT NULL,
	[value] Char(60) NOT NULL,
Primary Key  ([eventID])
) 
go

Create table [rules] (
	[ruleID] Integer Identity NOT NULL UNIQUE,
	[ruleGroupID] Integer NOT NULL,
Primary Key  ([ruleID])
) 
go

Create table [eventTypes] (
	[eventTypeID] Integer Identity NOT NULL UNIQUE,
	[name] Char(60) NULL,
Primary Key  ([eventTypeID])
) 
go

Create table [ruleGroups] (
	[ruleGroupID] Integer Identity NOT NULL UNIQUE,
	[right] Integer NOT NULL,
	[left1] Integer NOT NULL,
	[left2] Integer NOT NULL,
Primary Key  ([ruleGroupID])
) 
go


Alter table [ruleGroups] add  foreign key([left1]) references [events] ([eventID]) 
go
Alter table [ruleGroups] add  foreign key([left2]) references [events] ([eventID]) 
go
Alter table [ruleGroups] add  foreign key([right]) references [events] ([eventID]) 
go
Alter table [events] add  foreign key([eventTypeID]) references [eventTypes] ([eventTypeID]) 
go
Alter table [rules] add  foreign key([ruleGroupID]) references [ruleGroups] ([ruleGroupID]) 
go


Set quoted_identifier on
go


Set quoted_identifier off
go


/* Roles permissions */


/* Users permissions */



-- INSERT DATA

-- EVENT TYPE

INSERT INTO eventTypes(name)
VALUES ('Tinh thanh')

INSERT INTO eventTypes(name)
VALUES ('Thoi luong')

INSERT INTO eventTypes(name)
VALUES ('Hang muc du lich')

INSERT INTO eventTypes(name)
VALUES ('Mua')

INSERT INTO eventTypes(name)
VALUES ('Chi phi')

INSERT INTO eventTypes(name)
VALUES ('So luong nguoi')

INSERT INTO eventTypes(name)
VALUES ('Dac diem cac dia danh')

INSERT INTO eventTypes(name)
VALUES ('Su kien cac dia danh')

-- EVENT

INSERT INTO events(value, eventTypeID)
VALUES ('Ha Noi',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Ha Giang',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Ha Nam',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Ha Tinh',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Hai Duong',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Hung Yen',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Hoa Binh',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Thanh Hoa',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Thua Thien Hue',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Tra Vinh',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Tuyen Quang',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Da Nang',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Ninh Binh',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Lao Cai',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Son La',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Phu Yen',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Phu Tho',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Quang Ninh',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Vinh Phuc',1)

INSERT INTO events(value, eventTypeID)
VALUES ('Yen Bai',1)

-- THOI LUONG 

INSERT INTO events(value, eventTypeID)
VALUES ('Di Nhieu Ngay',2)

INSERT INTO events(value, eventTypeID)
VALUES ('Di Trong Ngay',2)

-- HANG MUC DU LICH

INSERT INTO events(value, eventTypeID)
VALUES ('Tiet kiem',3)

INSERT INTO events(value, eventTypeID)
VALUES ('Tieu chuan',3)

INSERT INTO events(value, eventTypeID)
VALUES ('Cao cap',3)

-- TAP SU KIEN MUA

INSERT INTO events(value, eventTypeID)
VALUES ('Mua xuan',4)

INSERT INTO events(value, eventTypeID)
VALUES ('Mua ha',4)

INSERT INTO events(value, eventTypeID)
VALUES ('Mua thu',4)

INSERT INTO events(value, eventTypeID)
VALUES ('Mua dong',4)

-- TAP CHI PHI

INSERT INTO events(value, eventTypeID)
VALUES ('Gia duoi 1 Trieu',5)

INSERT INTO events(value, eventTypeID)
VALUES ('Gia tu 1- 2 Trieu',5)

INSERT INTO events(value, eventTypeID)
VALUES ('Gia tu 2 - 3 Trieu',5)

INSERT INTO events(value, eventTypeID)
VALUES ('Gia tren 3 Trieu',5)

-- TAP SO LUONG NGUOI

INSERT INTO events(value, eventTypeID)
VALUES ('1-2 Nguoi',6)

INSERT INTO events(value, eventTypeID)
VALUES ('3-10 Nguoi',6)

INSERT INTO events(value, eventTypeID)
VALUES ('Tren 10 Nguoi',6)

-- DAC DIEM DIA DANH

INSERT INTO events(value, eventTypeID)
VALUES ('Vung Nui',7)

INSERT INTO events(value, eventTypeID)
VALUES ('Vung Bien',7)

INSERT INTO events(value, eventTypeID)
VALUES ('Khu di tich',7)

INSERT INTO events(value, eventTypeID)
VALUES ('Khu vui choi',7)

-- CAC DIA DANH 

INSERT INTO events(value, eventTypeID)
VALUES ('Cot Co Lung Cu',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Chua Ba Vang',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Co Do Hoa Lu',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Dragon Park',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Da Lat',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Da Co To',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Den Hung',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Dong Thien Long',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Ha Long',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Ho Tay',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Lang Bac',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Moc Chau',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Mu Cang Chai',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Nha Vuong',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Nha May Thuy Dien Hoa Binh',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Tam Dao',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Thien Duong Bao Son',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Thanh Nha Ho',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Sapa',8)

INSERT INTO events(value, eventTypeID)
VALUES ('Vuong Quoc Gia Ba Vi',8)


INSERT INTO ruleGroups(left1,left2,[right])
VALUES (26,26,37)

Set quoted_identifier on
go


Set quoted_identifier off
go