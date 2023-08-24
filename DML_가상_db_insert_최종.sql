-- CREATE SCHEMA `db_01` ;
-- use db_01;
-- DROP SCHEMA `db_01`;

-- select * from `users`;
-- select * from `menu_section`;
-- select * from `order_payment_method`;

-- Users table 
INSERT INTO `users` (`User_ID`, `User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES (1, '김민지', "hash1", 20210001, 0);
INSERT INTO `users` (`User_ID`, `User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES (2, '이서영', "hash2", 20210002, 1);
INSERT INTO `users` (`User_ID`, `User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES (3, '박지원', "hash3", 20210003, 2);
INSERT INTO `users` (`User_ID`, `User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES (4, '정유진', "hash4", 20220083, 0);
INSERT INTO `users` (`User_ID`, `User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES (5, '한지은', "hash5", 20210004, 1);
INSERT INTO `users` (`User_ID`, `User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES (6, '장혜린', "hash6", 20220008, 2);
INSERT INTO `users` (`User_ID`, `User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES (7, '김은지', "hash7", 20210006, 0);
INSERT INTO `users` (`User_ID`, `User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES (8, '송지현', "hash8", 20200441, 1);
INSERT INTO `users` (`User_ID`, `User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES (9, '최현아', "hash9", 20210008, 2);
INSERT INTO `users` (`User_ID`, `User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES (10, '이주연', "hash10", 20210107, 0);
/*
-- 프라이머리 키 없는 버전.
INSERT INTO `users` (`User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES ('김민지', "hash1", 20210001, 0);
INSERT INTO `users` (`User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES ('이서영', "hash2", 20210002, 1);
INSERT INTO `users` (`User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES ('박지원', "hash3", 20210003, 2);
INSERT INTO `users` (`User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES ('정유진', "hash4", 20220083, 0);
INSERT INTO `users` (`User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES ('한지은', "hash5", 20210004, 1);
INSERT INTO `users` (`User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES ('장혜린', "hash6", 20220008, 2);
INSERT INTO `users` (`User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES ('김은지', "hash7", 20210006, 0);
INSERT INTO `users` (`User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES ('송지현', "hash8", 20200441, 1);
INSERT INTO `users` (`User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES ('최현아', "hash9", 20210008, 2);
INSERT INTO `users` (`User_Name`, `Password_Hash`, `Student_Number`, `Level`) VALUES ('이주연', "hash10", 20210107, 0);
*/

-- Menu_Section table
INSERT INTO `menu_section` (`Menu_Section_ID`, `Menu_Section_Name`) VALUES (1, '파스타');
INSERT INTO `menu_section` (`Menu_Section_ID`, `Menu_Section_Name`) VALUES (2, '라멘');
INSERT INTO `menu_section` (`Menu_Section_ID`, `Menu_Section_Name`) VALUES (3, '일식/양식');
INSERT INTO `menu_section` (`Menu_Section_ID`, `Menu_Section_Name`) VALUES (4, '한식');
INSERT INTO `menu_section` (`Menu_Section_ID`, `Menu_Section_Name`) VALUES (5, '분식');
INSERT INTO `menu_section` (`Menu_Section_ID`, `Menu_Section_Name`) VALUES (6, '카페');

-- Order_Payment_Method table (`Method` 컬럼 insert 데이터 수정 완료)
INSERT INTO `order_payment_method` (`Payment_Method_ID`, `Method`) VALUES (1, '신용카드');
INSERT INTO `order_payment_method` (`Payment_Method_ID`, `Method`) VALUES (2, '간편카드결제');
INSERT INTO `order_payment_method` (`Payment_Method_ID`, `Method`) VALUES (3, '네이버페이'); 
INSERT INTO `order_payment_method` (`Payment_Method_ID`, `Method`) VALUES (4, '카카오페이');
INSERT INTO `order_payment_method` (`Payment_Method_ID`, `Method`) VALUES (5, '페이코');
INSERT INTO `order_payment_method` (`Payment_Method_ID`, `Method`) VALUES (6, '하나Pay');
INSERT INTO `order_payment_method` (`Payment_Method_ID`, `Method`) VALUES (7, 'KBPay');
INSERT INTO `order_payment_method` (`Payment_Method_ID`, `Method`) VALUES (8, 'WON뱅킹 우리페이'); 

-- Menu_Items table
INSERT INTO Menu_Items (Menu_ID, Menu_Section_ID, Menu_Name, Menu_Description, Menu_Photo_URL, Menu_Star_Rating, Menu_Price)
VALUES
(1, 1, "고기들기름파스타", "맛있는 파스타 요리입니다", "예시URL1", 3.9, 6000),
(2, 1, "우삼겹알리올리오", "맛있는 파스타 요리입니다", "예시URL2", 3.3, 6500), 
(3, 1, "클래식토마토파스타", "맛있는 파스타 요리입니다", "예시URL3", 4.6, 6500), 
(4, 1, "매콤로제파스타", "맛있는 파스타 요리입니다", "예시URL4", 3.9, 7500),
(5, 1, "트리플버섯크림파스타", "맛있는 파스타 요리입니다", "예시URL5", 4.3, 6500), 
(6, 1, "대패삼겹크림파스타", "맛있는 파스타 요리입니다", "예시URL6", 4.8, 7500),
(7, 1, "김치삼겹필라프", "맛있는 필라프 요리입니다", "예시URL7", 4.8, 7500), 
(8, 1, "4분돼지김치파스타", "맛있는 파스타 요리입니다", "예시URL8", 4.3, 7500), 
(9, 2, "미스터라멘", "맛있는 라멘 요리입니다", "예시URL9", 3.8, 6000),
(10, 2, "돈코츠라멘", "맛있는 라멘 요리입니다", "예시URL10", 4.1, 7000), 
(11, 2, "시오라멘", "맛있는 라멘 요리입니다", "예시URL11", 3.6, 7000), 
(12, 2, "스끼야끼라멘", "맛있는 라멘 요리입니다", "예시URL12", 4.2, 7500), 
(13, 2, "바질라멘", "맛있는 라멘 요리입니다", "예시URL13", 4.1, 7500), 
(14, 2, "소유라멘", "맛있는 간장라멘 요리입니다", "예시URL14", 3.7, 7500), 
(15, 2, "매운돈코츠라멘", "맛있는 라멘 요리입니다", "예시URL15", 3.6, 7500), 
(16, 2, "해장김치라멘", "맛있는 라멘 요리입니다", "예시URL16", 4.2, 6000), 
(17, 2, "탄탄멘", "맛있는 라멘 요리입니다", "예시URL17", 4.2, 8000), 
(18, 2, "마라탕멘", "맛있는 라멘 요리입니다", "예시URL18", 3.5, 8000), 
(19, 2, "열라맵닭라멘", "맛있는 라멘 요리입니다", "예시URL19", 4.5, 9000), 
(20, 3, "돈까스우동세트", "맛있는 돈까스와 우동 요리입니다", "예시URL20", 3.3, 7500),
(21, 3, "제주흑돼지돈까스", "맛있는 돈까스 요리입니다", "예시URL21", 4.5, 6000), 
(22, 3, "제주흑돼지돈까스정식", "맛있는 돈까스 요리와 정식입니다", "예시URL22", 4.1, 6800), 
(23, 3, "통모짜돈까스정식", "맛있는 치즈 돈까스 요리와 정식입니다", "예시URL23", 3.4, 9900), 
(24, 3, "카레밥", "맛있는 카레 요리입니다", "예시URL24", 3.5, 4500), 
(25, 3, "제주흑돼지돈까스카레", "맛있는 돈까스 카레 요리입니다", "예시URL25", 4.0, 7500), 
(26, 3, "새우후라이 카레", "맛있는 새우튀김 카레 요리입니다", "예시URL26", 4.7, 6500), 
(27, 3, "가라아게 카레", "맛있는 가라아게 카레 요리입니다", "예시URL27", 4.3, 7200), 
(28, 3, "돈부리", "맛있는 돈부리 요리입니다", "예시URL28", 3.2, 6500), 
(29, 3, "믹스동", "맛있는 튀김과 밥 요리입니다", "예시URL29", 3.1, 8000), 
(30, 3, "돈코츠라멘", "맛있는 라멘 요리입니다", "예시URL30", 3.6, 6500), 
(31, 3, "우동", "맛있는 면 요리입니다", "예시URL31", 3.7, 4500), 
(32, 3, "카레우동", "맛있는 면 요리입니다", "예시URL32", 3.6, 6500), 
(33, 3, "탄탄면", "맛있는 면 요리입니다", "예시URL33", 4.7, 6500), 
(34, 3, "냉모밀", "맛있는 면 요리입니다", "예시URL34", 3.1, 6500), 
(35, 3, "판모밀", "맛있는 면 요리입니다", "예시URL35", 4.4, 5500), 
(36, 4, "우삼겹샐러드", "맛있는 샐러드 요리입니다", "예시URL36", 3.4, 6500), 
(37, 4, "리코타샐러드", "맛있는 샐러드 요리입니다", "예시URL37", 3.7, 6000), 
(38, 4, "닭가슴샐러드", "맛있는 샐러드 요리입니다", "예시URL38", 4.8, 6000), 
(39, 4, "그린샐러드", "맛있는 샐러드 요리입니다", "예시URL39", 3.6, 4500), 
(40, 4, "돼지김치찌개", "맛있는 한식 찌개 요리입니다", "예시URL40", 3.3, 5500),
(41, 4, "된장찌개", "맛있는 한식 찌개 요리입니다", "예시URL41", 3.1, 5500), 
(42, 4, "부대찌개", "맛있는 한식 찌개 요리입니다", "예시URL42", 5.0, 6000), 
(43, 4, "차돌된장찌개", "맛있는 한식 찌개 요리입니다", "예시URL43", 4.9, 6000), 
(44, 4, "불닭마요덮밥", "맛있는 한식 덮밥 요리입니다", "예시URL44", 3.1, 6000), 
(45, 4, "참치마요덮밥", "맛있는 한식 덮밥 요리입니다", "예시URL45", 4.9, 6000), 
(46, 4, "불닭덮밥", "맛있는 한식 덮밥 요리입니다", "예시URL46", 5.0, 6000), 
(47, 4, "제육덮밥", "맛있는 한식 덮밥 요리입니다", "예시URL47", 4.0, 6000), 
(48, 4, "오징어덮밥", "맛있는 한식 덮밥 요리입니다", "예시URL48", 4.5, 6500), 
(49, 4, "소불고기덮밥", "맛있는 한식 덮밥 요리입니다", "예시URL49", 4.8, 6500), 
(50, 4, "야채비빔밥", "맛있는 한식 덮밥 요리입니다", "예시URL50", 3.8, 5000), 
(51, 5, "아메리카노_hot", "맛있는 카페 음료입니다", "예시URL51", 5.0, 2000), 
(52, 5, "헤이즐넛아메리카노_hot", "맛있는 카페 음료입니다", "예시URL52", 4.7, 2500), 
(53, 5, "카페라떼_hot", "맛있는 카페 음료입니다", "예시URL53", 4.9, 2900), 
(54, 5, "카푸치노_hot", "맛있는 카페 음료입니다", "예시URL54", 4.3, 3200), 
(55, 5, "아메리카노_iced", "맛있는 카페 음료입니다", "예시URL55", 5.0, 2000), 
(56, 5, "헤이즐넛아메리카노_iced", "맛있는 카페 음료입니다", "예시URL56", 4.7, 2500), 
(57, 5, "카페라떼_iced", "맛있는 카페 음료입니다", "예시URL57", 4.9, 2900), 
(58, 5, "카푸치노_iced", "맛있는 카페 음료입니다", "예시URL58", 4.3, 3200), 
(59, 6, "오늘의메뉴", "오늘의메뉴는 매일 다른 메뉴로 준비되어 가격이 변동될 수 있습니다", "예시URL59", 4.5, 6500);

-- Menu_Tag
INSERT INTO Menu_Tag (Menu_Tag_ID, Menu_Tag_Name) VALUES 
(1,	"알류"),
(2,	"우유"),
(3,	"메밀"),
(4,	"땅콩"),
(5,	"대두"),
(6,	"밀"),
(7,	"잣"),
(8,	"호두"),
(9,	"게"),
(10, "새우"),
(11, "오징어"),
(12, "고등어"),
(13, "조개류"),
(14, "복숭아"),
(15, "토마토"),
(16, "닭고기"),
(17, "돼지고기"),
(18, "쇠고기"),
(19, "아황산류"),
(20, "비건");

-- Menu_Items_Menu_Tag
INSERT INTO Menu_Items_Menu_Tag (Menu_Items_Menu_Tag_ID, Menu_ID, Menu_Tag_ID) VALUES 
(1, 1, 6),
(2, 1, 17),
(3, 2, 6),
(4, 2, 18),
(5, 3, 6),
(6, 3, 15),
(7, 4, 1),
(8, 4, 6),
(9, 5, 1),
(10, 5, 2),
(11, 5, 6),
(12, 6, 1),
(13, 6, 2),
(14, 6, 6),
(15, 6, 17),
(16, 7, 17),
(17, 8, 6),
(18, 8, 17),
(19, 9, 6),
(20, 10, 6),
(21, 10, 17),
(22, 11, 6),
(23, 11, 17),
(24, 12, 6),
(25, 12, 18),
(26, 13, 6),
(27, 13, 17),
(28, 14, 6),
(29, 14, 17),
(30, 15, 6),
(31, 15, 17),
(32, 16, 6),
(33, 16, 17),
(34, 17, 1),
(35, 17, 4),
(36, 17, 6),
(37, 18, 6),
(38, 19, 6),
(39, 19, 17),
(40, 20, 1),
(41, 20, 6),
(42, 20, 17),
(43, 21, 1),
(44, 21, 6),
(45, 21, 17),
(46, 22, 1),
(47, 22, 6),
(48, 22, 17),
(49, 23, 1),
(50, 23, 2),
(51, 23, 6),
(52, 23, 17),
(53, 24, 6),
(54, 24, 17),
(55, 25, 1),
(56, 25, 2),
(57, 25, 6),
(58, 25, 17),
(59, 26, 1),
(60, 26, 2),
(61, 26, 6),
(62, 26, 10),
(63, 27, 1),
(64, 27, 2),
(65, 27, 6),
(66, 27, 16),
(67, 28, 1),
(68, 28, 6),
(69, 28, 17),
(70, 29, 1),
(71, 29, 6),
(72, 29, 17),
(73, 30, 6),
(74, 30, 17),
(75, 31, 6),
(76, 32, 2),
(77, 32, 6),
(78, 33, 1),
(79, 33, 4),
(80, 33, 6),
(81, 34, 6),
(82, 35, 6),
(83, 36, 18),
(84, 37, 2),
(85, 38, 16),
(86, 39, 20),
(87, 40, 17),
(88, 41, 17),
(89, 42, 5),
(90, 43, 18),
(91, 44, 16),
(92, 45, 2),
(93, 46, 16),
(94, 47, 17),
(95, 48, 11),
(96, 49, 18),
(97, 50, 1),
(98, 51, NULL),
(99, 52, NULL),
(100, 53, 2),
(101, 54, 2),
(102, 55, NULL),
(103, 56, NULL),
(104, 57, 2),
(105, 58, 2);


-- Orders table // menu 테이블이 생성되지 않아서 참조할 menu_id가 없음. 따라서 order 테이블 데이터 생성 불가
INSERT INTO `orders` (`Order_ID`, `User_ID`, `Menu_ID`, `Order_Payment_Method`, `Order_DateTime`, `Order_Quantity`, `Order_Preparation_Status`, `Order_Estimated_Preparation_Time`) VALUES (1, 1, 1, 3, "2023-08-22 12:30:00", 1, 1, 20);
INSERT INTO `orders` (`Order_ID`, `User_ID`, `Menu_ID`, `Order_Payment_Method`, `Order_DateTime`, `Order_Quantity`, `Order_Preparation_Status`, `Order_Estimated_Preparation_Time`) VALUES (2, 2, 9, 5, "2023-08-22  6:45:00", 2, 2, 10);
INSERT INTO `orders` (`Order_ID`, `User_ID`, `Menu_ID`, `Order_Payment_Method`, `Order_DateTime`, `Order_Quantity`, `Order_Preparation_Status`, `Order_Estimated_Preparation_Time`) VALUES (3, 3, 20, 1, "2023-08-23  9:15:00", 3, 0, 30);
-- 추가: 주문 시간 컬럼 제외하였음. insert 할 시 자동생성 됨
INSERT INTO `orders` (`Order_ID`, `User_ID`, `Menu_ID`, `Order_Payment_Method`, `Order_Quantity`, `Order_Preparation_Status`, `Order_Estimated_Preparation_Time`) VALUES (4, 4, 34, 2, 1, 1, 11);
INSERT INTO `orders` (`Order_ID`, `User_ID`, `Menu_ID`, `Order_Payment_Method`, `Order_Quantity`, `Order_Preparation_Status`, `Order_Estimated_Preparation_Time`) VALUES (5, 5, 23, 6, 1, 1, 5);

-- Reviews table // menu 테이블이 생성되지 않아서 참조할 menu_id가 없음.
INSERT INTO `reviews` (`Review_ID`, `User_ID`, `Menu_ID`, `Review_Rating`, `Review_Content`, `Review_Creation_DateTime`, `Review_Status`) VALUES (1, 1, 1, 4, '들기름 굿굿 맛있어요. 근데 면이 좀 덜 익었네요.', '2023-08-22  1:05:00', 0);
INSERT INTO `reviews` (`Review_ID`, `User_ID`, `Menu_ID`, `Review_Rating`, `Review_Content`, `Review_Creation_DateTime`, `Review_Edited_DateTime`, `Review_Status`) VALUES (2, 2, 9, 3, '그냥 그래요. 다음엔 다른 거 먹을 듯.', '2023-08-22  12:45:00', '2023-08-22  12:55:00', 1);
INSERT INTO `reviews` (`Review_ID`, `User_ID`, `Menu_ID`, `Review_Rating`, `Review_Content`, `Review_Creation_DateTime`, `Review_Status`) VALUES (3, 3, 20, 5, '강추 !! 너무 맛있어요 학식 중에 제일 맛있네요', '2023-08-23  11:15:00', 0);

-- Reviews_Image // menu 테이블이 생성되지 않아서 참조할 menu_id가 없음.
INSERT INTO `review_image` (`Review_Image_ID`, `Menu_ID`, `Review_ID`, `Review_Image_URL`) VALUES (1, 1, 1, "예시URL1");
INSERT INTO `review_image` (`Review_Image_ID`, `Menu_ID`, `Review_ID`, `Review_Image_URL`) VALUES (2, 9, 2, "예시URL2");
INSERT INTO `review_image` (`Review_Image_ID`, `Menu_ID`, `Review_ID`, `Review_Image_URL`) VALUES (3, 20, 3, "예시URL3");

-- Cart table 
INSERT INTO `cart` (`Cart_ID`,`User_ID`,`Menu_ID`,`Cart_Quantity`,`Cart_Total_Price`,`Cart_Is_Selected`) VALUES (1,1,1,1,12000,1);

-- Like table // review 테이블이 생성되지 않아서 참조할 review_id가 없음.
INSERT INTO `like` (`Like_ID`,`Like`,`Review_ID`) VALUES (1,20,1);
INSERT INTO `like` (`Like_ID`,`Like`,`Review_ID`) VALUES (2,13,2);
INSERT INTO `like` (`Like_ID`,`Like`,`Review_ID`) VALUES (3,39,3);














