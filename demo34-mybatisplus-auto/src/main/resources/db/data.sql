DELETE FROM user;

INSERT INTO user (id, name, age, title) VALUES
(1, '宋江', 18, '及时雨'),
(2, '卢俊义', 20, '玉麒麟'),
(3, '吴用', 28, '智多星'),
(4, '公孙胜', 21, '入云龙'),
(5, '关胜', 24, '大刀');


DELETE FROM role;

INSERT INTO role (id, name, `order`) VALUES
(1, '头领', 1),
(2, '军师', 2),
(3, '马军', 3),
(4, '步军', 4);

DELETE FROM user_role;

INSERT INTO user_role (id, userId, roleId) VALUES
(1,1,1),
(2,2,1),
(3,3,2),
(4,5,4),
(5,4,3);