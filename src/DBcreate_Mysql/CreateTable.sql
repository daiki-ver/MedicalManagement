drop table if exists doctor;

/*==============================================================*/
/* Table: doctor                                                */
/*==============================================================*/
create table doctor
(
   id                   int not null,
   dname                varchar(30) not null,
	 dusername            varchar(50),
	 droom                varchar(20),
   demail               varchar(50) UNIQUE not null,
   dpassword            varchar(20) not null,
   djob                 varchar(20),
   dsex                 varchar(2) not null,
	 dage                 int not null,
	 did_card             varchar(18),
   dphone               varchar(20),
   daddress             varchar(120),
   ddescribe            varchar(300),
   role                 varchar(10) not null,
   primary key (id)
);
-- 创建插入触发器，想User表进行同步插入
CREATE TRIGGER `addUser_doctor` AFTER INSERT ON `doctor` FOR EACH ROW INSERT INTO `user` VALUES (new.demail,new.`dpassword`,new.dname,new.dsex,new.dusername,new.djob,new.dphone,new.daddress,new.ddescribe,'doctor',NULL);
-- 创建更新触发器，向User表发起同步更新
CREATE TRIGGER `updateUser_doctor` AFTER UPDATE ON `doctor` FOR EACH ROW UPDATE `user` SET `password`=new.dpassword,`name`=new.dname,sex=new.dsex,username=new.dusername,job=new.djob,phone=new.dphone,address=new.daddress,`describe`=new.ddescribe,role=new.role WHERE email=new.demail;




drop table if exists patient;

/*==============================================================*/
/* Table: patient                                               */
/*==============================================================*/
create table patient
(
   pid                  int not null,
   pemail               varchar(50) UNIQUE not null,
   pname                varchar(30) not null,
	 pusername						varchar(50),
   ppassword            varchar(20) not null,
   page                 int not null,
   psex                 varchar(2) not null,
   pjob                 varchar(20),
   pmarriage            varchar(2),
   pnation              varchar(20) not null,
   pnatplace            varchar(20),
   paddress             varchar(120),
   pphone               varchar(20),
   allergy              varchar(100),
   pid_card             varchar(18),
   pdiseases             varchar(100),
   pdescribe            varchar(300),
   role                 varchar(10) not null,
	 primary key (pid)
);
-- 创建插入触发器，想User表进行插入
CREATE TRIGGER `addUser_trigger` AFTER INSERT ON `patient` FOR EACH ROW INSERT INTO `user` VALUES (new.pemail,new.ppassword,new.pname,new.psex,NULL,NULL,NULL,new.paddress,NULL,'patient',NULL);
-- 创建更新触发器，向User表发起同步更新
CREATE TRIGGER `updateUser_trigger` AFTER UPDATE ON `patient` FOR EACH ROW UPDATE `user` SET `password`=new.ppassword,`name`=new.pname,sex=new.psex,username=new.pusername,job=new.pjob,phone=new.pphone,address=new.paddress,`describe`=new.pdescribe,role=new.role WHERE email=old.pemail;





drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   email                varchar(50) not null,
   password             varchar(25) not null,
   dname                varchar(30) not null,
   sex                  varchar(2) not null,
   username             varchar(50),
   job                  varchar(20),
   phone                varchar(20),
   address              varchar(120),
	 `describe`          varchar(200),
   role                 varchar(10) not null,
	 birthday             date,
   primary key (email)
);



drop table if exists medical;

/*==============================================================*/
/* Table: medical                                               */
/*==============================================================*/
create table medical
(
   mid                  int not null,
   id                   int not null,
   pid                  int not null,
   pid_card             varchar(18) not null,
   pname                varchar(30) not null,
	 psex
   dname                varchar(30) not null,
   droom                VARCHAR(20),
   indate               date,
   outdate              date,
   diagnosis            varchar(200),
   outresult            varchar(200),
   hnum                 int,
   bnum                 int,
   curepass             varchar(200),
   suit                 varchar(200),
   nowill               varchar(100),
   oldill               varchar(100),
   marriagehis          varchar(60),
   bodycheck            varchar(50),
   othercheck           varchar(50),
   `describe`          varchar(200),
   primary key (mid)
);
alter table medical add constraint FK_have foreign key (pid)
      references patient (pid) on delete restrict on update restrict;
alter table medical add constraint FK_haves foreign key (id)
      references doctor (id) on delete restrict on update restrict;


