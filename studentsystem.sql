use master
go
if Exists(select * from sysdatabases where name='studentsystem')
	drop database studentsystem
go
create database studentsystem
go
use studentsystem
go
create table [user]( --系统用户（user）表
	id int Primary key identity(1,1),      --主键
	account varchar(30) not null,      --账号（学生和老师的学号）
	[password] varchar(30) not null,      --密码
	name varchar(20),				--用户姓名
	[type] tinyint not null--(用户类型：1为管理员，默认2为学生，3为老师)
)
select * from [user]
go
INSERT INTO [user] VALUES ( 'admin', '111111', '管理员', '1')
,( '2001', '111111', '卡卡西', '3')
,( '2005', '111111', '爱德华纽盖特', '3')
,( '2006', '111111', '香克斯', '3')
,( '2007', '111111', '波风水门', '3')
,( '2008', '111111', '纲手', '3')
,( '2009', '111111', '大筒木辉夜', '3')
,( '2010', '111111', '漩涡玖辛奈', '3')
,( '2011', '111111', '夕日红', '3')
,('2012', '111111', '鹰眼米霍克', '3')
,( '201301001', '111111', '蒙奇D路飞', '2')
,( '201301002', '111111', '妮可罗宾', '2')
,( '201301003', '111111', '罗罗诺亚卓洛', '2')
,( '201301004', '111111', '托尼托尼乔巴', '2')
select * from [user]
go
create table grade(						--年级表
	id int primary key identity(1,1),	--ID
	name nvarchar(20)						--年级名称
)
go
INSERT INTO grade VALUES ( '2013级'),( '2014级'),( '2015级')
select * from grade
go
create table clazz(						--班级表
	id int primary key identity(1,1),		--ID
	name nvarchar(50) not null,				--班级名称
	gradeid int references grade(id),		--外键（年级ID）
)
go
INSERT INTO clazz VALUES ( '3年1班', '1'),( '3年2班', '1')
,( '3年3班', '1'),( '3年4班', '1'),( '4年1班', '2'),( '4年2班', '2')
,( '4年3班', '2'),( '4年4班', '2'),( '5年1班', '3'),( '5年2班', '3')
,( '5年3班', '3'),( '5年4班', '3'),( '5年5班', '3')
select * from clazz
go
create table student( --学生表
	id int primary key identity(1,1),          --ID
	number nvarchar(20),					--学号
	name nvarchar(20),						--姓名
	sex nvarchar(1),								--性别
	phone nvarchar(20),						--电话
	qq nvarchar(20),						--QQ
	photo varchar(20),						--图片路径
	clazzid int references clazz(id)						--学生所在班级
)
go
  insert into student values ('201301001', '蒙奇D路飞', '男','18345345612', '252345', 'image/8.jpg', '1')
  ,('201301002', '妮可罗宾', '女', '16342346345', '345745',  'image/1.jpg', '1')
 ,('201301003', '罗罗诺亚卓洛', '男', '16234574564', '734577',  'image/1.jpg', '1')
 ,( '201301004', '托尼托尼乔巴', '男', '15436574765', '3546634',  'image/1.jpg', '1')
 ,( '201301005', '娜美', '女', '15346235622', '7453256',  'image/1.jpg', '1')
 ,( '201301006', '山治', '男', '16234514532', '8456257',  'image/1.jpg', '1')
 ,( '201301007', '布鲁克', '男', '16345234664', '7257346',  'image/1.jpg', '1')
 ,( '201301008', '乌索普', '男', '16236457676', '8345756',  'image/1.jpg', '1')
 ,( '201301009', '弗兰奇', '男', '17346734768', '23563457',  'image/1.jpg', '1')
 ,( '201301010', '娜菲鲁塔利薇薇', '女', '11452356234', '235345',  'image/1.jpg', '1')
 ,( '201301011', '小鱿', '男', '17632878467', '6235745',  'image/1.jpg', '1')
 ,( '201301012', '梅里号', '男', '15235543456', '2352346',  'image/1.jpg', '1')
 ,( '201301013', '阳光号', '男', '15232342355', '45236',  'image/1.jpg', '1')
 ,( '201302001', '马歇尔蒂奇', '男', '13928398784', '89872874',  'image/1.jpg', '2')
 ,( '201302002', '范奥卡', '男', '13984728784', '89878372',  'image/1.jpg', '2')
 ,( '201302003', '基萨斯巴加斯', '男', '13787287843', '99893727',  'image/1.jpg', '2')
 ,( '201302004', '毒Q', '男', '18787238748', '89387823',  'image/1.jpg', '2')
 ,( '201302005', '雨之希留', '男', '18398782744', '82094987',  'image/1.jpg', '2')
 ,( '201302006', '卡特琳娜', '女', '16392784264', '9793845',  'image/1.jpg', '2')
 ,( '201302007', '圣胡安恶狼', '男', '12787467593', '89874873',  'image/1.jpg', '2')
 ,( '201302008', '巴克斯乔特', '男', '15249797297', '89923832',  'image/1.jpg', '2')
 ,( '201302009', '阿巴罗', '男', '12746763859', '98791235',  'image/1.jpg', '2')
 ,( '201303001', '汉库克', '女', '15234235688', '12575643',  'image/1.jpg', '3')
 ,( '201303002', '桑达索尼娅', '女', '15236386674', '2456568',  'image/1.jpg', '3')
 ,( '201303003', '玛丽哥鲁德', '女', '12364573467', '2634681',  'image/1.jpg', '3')
 ,( '201303004', '玛格丽特', '女', '16353462367', '23467436',  'image/1.jpg', '3')
 ,( '201303005', '艾弗兰德拉', '女', '11345235678', '2352366',  'image/1.jpg', '3')
 ,( '201303006', '贝拉董娜', '女', '14523462567', '7912635',  'image/1.jpg', '3')
 ,( '201304001', '白胡子', '男', null, null,  'image/1.jpg', '4')
 ,( '201304002', '马尔高', '男', null, null,  'image/1.jpg', '4')
 ,( '201304003', '艾斯', '男', null, null,  'image/1.jpg', '4')
 ,( '201304004', '乔兹', '男', null, null,  'image/1.jpg', '4')
 ,( '201304005', '萨奇', '男', null, null,  'image/1.jpg', '4')
 ,( '201304006', '比斯塔', '男', null, null,  'image/1.jpg', '4')
 ,( '201304007', '布拉曼克', '男', null, null,  'image/1.jpg', '4')
 ,( '201304008', '拉克约', '男', null, null,  'image/1.jpg', '4')
 ,( '201304009', '那谬尔', '男', null, null,  'image/1.jpg', '4')
 ,( '201304010', '布伦海姆', '男', null, null,  'image/1.jpg', '4')
 ,( '201304011', '库利艾尔', '男', null, null,  'image/1.jpg', '4')
 ,( '201304012', '金古多', '男', null, null,  'image/1.jpg', '4')
 ,( '201304013', '佛萨', '男', null, null,  'image/1.jpg', '4')
 ,( '201304014', '斯比多基尔', '男', null, null,  'image/1.jpg', '4')
 ,( '201401001', '日向雏田', '女', null, null,  'image/1.jpg', '5')
 ,( '201401002', '李洛克', '男', null, null,  'image/1.jpg', '5')
 ,( '201401003', '日向花火', '女', null, null,  'image/1.jpg', '5')
 ,( '201401004', '奈良鹿丸', '男', null, null,  'image/1.jpg', '5')
 ,( '201401005', '日向宁次', '男', null, null,  'image/1.jpg', '5')
 ,( '201401006', '佐井', '男', null, null,  'image/1.jpg', '5')
 ,( '201401007', '山中井野', '女', null, null,  'image/1.jpg', '5')
 ,( '201401008', '秋道丁次', '男', null, null,  'image/1.jpg', '5')
 ,( '201401009', '犬冢牙', '男', null, null,  'image/1.jpg', '5')
 ,( '201401010', '野原琳', '女', null, null,  'image/1.jpg', '5')
 ,( '201401011', '天天', '女', null, null,  'image/1.jpg', '5')
 ,( '201401012', '木叶丸', '男', null, null,  'image/1.jpg', '5')
 ,( '201401013', '赤丸', '男', null, null,  'image/1.jpg', '5')
 ,( '201401014', '漩涡鸣人', '男', null, null,  'image/1.jpg', '5')
 ,( '201401015', '佐助', '男', null, null,  'image/1.jpg', '5')
 ,( '201401016', '春野樱', '女', null, null,  'image/1.jpg', '5')
 ,( '201401017', '油女志乃', '男', null, null,  'image/1.jpg', '5')
 ,( '201402001', '宇智波带土', '男', null, null,  'image/1.jpg', '6')
 ,( '201402002', '长门', '男', null, null,  'image/1.jpg', '6')
 ,( '201402003', '绝', '男', null, null,  'image/1.jpg', '6')
 ,( '201402004', '角都', '男', null, null, 'image/1.jpg', '6')
 ,( '201402005', '迪达拉', '男', null, null, 'image/1.jpg', '6')
 ,( '201402006', '小南', '女', null, null, 'image/1.jpg', '6')
 ,( '201402007', '大蛇丸', '男', null, null, 'image/1.jpg', '6')
 ,( '201402008', '飞段', '男', null, null, 'image/1.jpg', '6')
 ,( '201402009', '蝎', '男', '', '', 'image/1.jpg', '6')
 ,( '201402010', '弥彦', '男', null, null, 'image/1.jpg', '6')
 ,( '201402011', '千柿鬼鲛', '男', null, null, 'image/1.jpg', '6')
 select * from student
go
create table teacher(					 --老师信息
	id int primary key identity(1,1),       --ID
	number nvarchar(20),					--工号
	name nvarchar(20),						--姓名
	sex nvarchar(4),						--性别
	phone nvarchar(20),						--电话
	qq nvarchar(20),						--QQ
	photo nvarchar(200)						--图片路径
)
go
 INSERT INTO teacher VALUES ( '2001', '卡卡西', '男', '18987831233', '63456345', 'image/1.jpg')
 ,( '2002', '卡普', '男', '13927387432', '65686786',  'image/1.jpg')
,( '2003', '战国', '男', '11389823821', '1233456',  'image/1.jpg')
,( '2004', '青雉', '男', '15234523454', '7456345',  'image/1.jpg')
,( '2005', '爱德华纽盖特', '男', '16234243242', '34634534',  'image/1.jpg')
,( '2006', '香克斯', '男', '16345475689', '35464573',  'image/1.jpg')
,( '2007', '波风水门', '男', '15234234234', '35683673',  'image/1.jpg')
,( '2008', '纲手', '女', '14352341231', '73456236',  'image/1.jpg')
,( '2009', '大筒木辉夜', '女', '13452342342', '234523455',  'image/1.jpg')
,( '2010', '漩涡玖辛奈', '女', '14423423543', '734562356',  'image/1.jpg')
,( '2011', '夕日红', '女', '15234234523', '7243821',  'image/1.jpg')
,( '2012', '鹰眼米霍克', '男', '15236345346', '8345632',  'image/1.jpg')
select * from teacher
go
create table course(					--课程表
	id int  primary key identity(1,1),								--ID
	name nvarchar(50) not null				--课程名称
)
go
insert into course values('语文'),
('数学'),
('英语'),
('化学'),
('物理'),
('生物'),
('历史'),
('政治'),
('计算机'),
('体育')
select * from course
go
create table grade_course(				--年级—课程
	id int primary Key identity(1,1),		--ID
	gradeid int references grade(id),		--外键（年级ID）
	courseid int references course(id)			--外键（课程ID）
)
go
  INSERT INTO grade_course VALUES ( '1', '1'),
  ( '1', '2') ,
 ( '1', '3') ,
 ( '1', '4') ,
 ( '1', '5') ,
 ( '2', '10') ,
 ( '2', '9') ,
 ( '2', '8') ,
 ( '2', '1') ,
 ('3', '2') ,
 ( '3', '5') ,
 ( '3', '7') ,
 ( '3', '8') 
select * from grade_course
go
create table clazz_course_teacher(			--班级_课程_老师
	id int primary key identity(1,1),		--ID
	gradeid int references grade(id),		--外键年级（ID）
	clazzid int references clazz(id),		--外键班级（ID）
	courseid int references grade_course(id),--外键（课程ID）
	teacherid int references teacher(id)	 --外键（教师ID）	
)
go
select * from clazz_course_teacher
INSERT INTO clazz_course_teacher VALUES ( '1', '1', '1', '5'),
( '1','2', '2', '12'),
('2', '3', '3', '11'),
('2', '4', '4', '10'),
('3', '5', '5', '4'),
( '3','6', '6', '9'),
('2', '7', '7', '1'),
('1','8', '8', '8')
select * from clazz_course_teacher

go
create table exam(						--考试表
	id int primary key identity(1,1),		--主键
	name varchar(50) ,						--考试名称
	[time] Date,							--考试时间
	remark varchar(200),					--备注
	[type] tinyint default(1),				--考试类型：默认1（1年级统考，2平时考试）
	gradeid int references grade(id),		--外键年级ID
	clazzid int references clazz(id),		--外键班级ID
	courseid int references course(id)		--外键科目（ID）
)
SELECT * FROM exam
go
  insert into exam values ( '中学第三次会考', '2016-01-15', '请科任老师尽快登记成绩', '1', '1', '1','1')
  ,( '1班语文测试', '2016-01-15', '第五单元测试', '2', '2', '2','2')
  select * from exam
  go
create table escore(										--考试成绩表
	id int primary key identity(1,1),						--主键
	examid int references exam(id) on delete cascade,		--外键考试ID
	studentid int references student(id),					--外键学生ID
	clazzid int references clazz(id),						--外键班级ID
	grade_courseid int  references grade_course(id),			--外键课程_年级ID
	score int default(0)										--成绩
)
go              
INSERT INTO escore VALUES ( '1', '1', '1', '1','123'),
( '1', '2', '1',  '2','56'),
( '1', '3', '1',  '3',  '67'),
( '1', '4', '2',  '2',  '67'),
 ( '1', '5', '2',  '3',  '120'),
 ( '1', '6', '2',  '4',  '76'),
 ( '1', '7', '2',  '5',  '78'),
 ( '1', '8', '3',  '1',  '67'),
 ( '1', '9', '3',  '2',  '87'),
 ( '1', '10', '3',  '3',  '66'),
 ( '1', '11', '3',  '4',  '56'),
 ( '1', '12', '3',  '5',  '88'),
 ('1', '13', '4',  '1',  '89'),
 ( '1', '14', '4',  '2',  '34'),
( '1','15', '4',  '3',  '55'),
( '1', '16', '4',  '4',  '90'),
 ( '1', '17', '4', '5',  '90'),
  ( '2', '18', '1', '1',  '78') ,
  ( '2', '19', '2','1',  '89') ,
  ( '2', '20', '3', '1',  '45') ,
  ( '2', '21', '4','1',   '67') ,
  ( '2', '22', '5',  '1',  '132') ,
  ( '2', '23', '6',  '1',  '123') ,
  ( '2', '24', '7',  '1',  '45') ,
  ( '2', '25', '8',  '1',  '65') ,
  ( '2', '26', '9',  '1',  '78') ,
  ( '2', '27', '10',  '1',  '144') ,
  ( '2', '28', '11',  '1',  '44') ,
  ( '2', '29', '12',  '1',  '65') ,
  ( '2', '30', '13', '1',  '87')
  go
  select * from escore
  go
  create table information(
	id int primary key identity(1,1),
	courseid int references course(id),		--外键课程id
  )
