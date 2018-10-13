create database intelligence;

create table `user` (
  `id` int(11) not null AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL comment '用户名',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL comment '性别',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL comment '状态',
  `interest` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL comment '爱好',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL comment '生日',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL comment '地址',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL comment '上次登录时间',
  primary key(`id`) using btree
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

insert into `user` values (1,'小张','男','硕士','太极拳','1951-11-22','湖北省武当山','10:55:77');
insert into `user` values (2,'小马','男','小学','经济学','2000-11-22','北京市朝阳区','12:55:77');
insert into `user` values (3,'小郭','男','本科','编程思想','1981-11-22','山东省济南市','14:25:77');