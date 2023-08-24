CREATE TABLE Cart (Cart_ID int(11) NOT NULL, User_ID int(11) NOT NULL, Menu_ID int(11) NOT NULL, Cart_Quantity decimal(2, 0) NOT NULL, Cart_Total_Price decimal(5, 0) NOT NULL, Cart_Is_Selected int(1) DEFAULT 0 NOT NULL comment '0: False
1: True', PRIMARY KEY (Cart_ID), UNIQUE INDEX (Cart_ID));
CREATE TABLE `Like` (Like_ID int(11) NOT NULL, `Like` int(1), Review_ID int(11) NOT NULL, PRIMARY KEY (Like_ID), UNIQUE INDEX (Like_ID));
CREATE TABLE Menu_Items (Menu_ID int(11) NOT NULL AUTO_INCREMENT, Menu_Section_ID int(4) NOT NULL, Menu_Name varchar(20) NOT NULL, Menu_Description text NOT NULL, Menu_Photo_URL varchar(255), Menu_Star_Rating decimal(2, 1), Menu_Price decimal(5, 0) NOT NULL, Menu_Tag_ID int(11), PRIMARY KEY (Menu_ID), UNIQUE INDEX (Menu_ID));
CREATE TABLE Menu_Items_Menu_Tag (Menu_Items_Menu_Tag_ID int(11) NOT NULL AUTO_INCREMENT, Menu_ID int(11) NOT NULL, Menu_Tag_ID int(11), PRIMARY KEY (Menu_Items_Menu_Tag_ID), UNIQUE INDEX (Menu_Items_Menu_Tag_ID));
CREATE TABLE Menu_Section (Menu_Section_ID int(4) NOT NULL AUTO_INCREMENT, Menu_Section_Name varchar(20) NOT NULL, PRIMARY KEY (Menu_Section_ID), UNIQUE INDEX (Menu_Section_ID));
CREATE TABLE Menu_Tag (Menu_Tag_ID int(11) NOT NULL AUTO_INCREMENT, Menu_Tag_Name varchar(20) NOT NULL, PRIMARY KEY (Menu_Tag_ID), UNIQUE INDEX (Menu_Tag_ID));
CREATE TABLE Order_Payment_Method (Payment_Method_ID int(11) NOT NULL AUTO_INCREMENT, Method varchar(20) NOT NULL comment '0: 신용카드
1: 간편카드 결제
2: 네이버페이
3: 카카오페이
4: 페이코
5: 하나Pay
6: KBPay
7: WON뱅킹 우리페이', PRIMARY KEY (Payment_Method_ID), UNIQUE INDEX (Payment_Method_ID));
CREATE TABLE Orders (Order_ID int(11) NOT NULL AUTO_INCREMENT, User_ID int(11) NOT NULL, Menu_ID int(11) NOT NULL, Order_Payment_Method int(11) NOT NULL, Order_DateTime datetime DEFAULT now() NOT NULL comment '주문한 날짜 및 시간', Order_Quantity int(4) NOT NULL, Order_Preparation_Status int(1) DEFAULT 0 NOT NULL comment '0: 접수 대기 중
1: 접수 완료, 조리 중
2: 준비 완료', Order_Estimated_Preparation_Time int(4) NOT NULL, PRIMARY KEY (Order_ID), UNIQUE INDEX (Order_ID));
CREATE TABLE Review_Image (Review_Image_ID int(11) NOT NULL AUTO_INCREMENT, Menu_ID int(11) NOT NULL, Review_ID int(11) NOT NULL, Review_Image_URL varchar(255) NOT NULL, PRIMARY KEY (Review_Image_ID), UNIQUE INDEX (Review_Image_ID));
CREATE TABLE Reviews (Review_ID int(11) NOT NULL AUTO_INCREMENT, User_ID int(11) NOT NULL, Menu_ID int(11) NOT NULL, Review_Rating decimal(2, 1) NOT NULL, Review_Content text NOT NULL, Review_Creation_DateTime datetime DEFAULT now() NOT NULL, Review_Edited_DateTime datetime NULL, Review_Status int(1) DEFAULT 0 NOT NULL comment '-1: delete
0: public
1: updated', PRIMARY KEY (Review_ID), UNIQUE INDEX (Review_ID));
CREATE TABLE Users (User_ID int(11) NOT NULL AUTO_INCREMENT, User_Name varchar(20) NOT NULL, Password_Hash varchar(64) NOT NULL, Student_Number int(4) NOT NULL, Level int(4) DEFAULT 0 NOT NULL comment '주문 내역에 따른 사용자 등급
0: 0-5회, 대학생.
1: 6-10회, 대학원생,
2: 11회 이상, 쩝쩝박사', PRIMARY KEY (User_ID), UNIQUE INDEX (User_ID));
ALTER TABLE Orders ADD CONSTRAINT FKOrders162675 FOREIGN KEY (User_ID) REFERENCES Users (User_ID);
ALTER TABLE Orders ADD CONSTRAINT FKOrders287050 FOREIGN KEY (Menu_ID) REFERENCES Menu_Items (Menu_ID);
ALTER TABLE Menu_Items ADD CONSTRAINT FKMenu_Items585145 FOREIGN KEY (Menu_Section_ID) REFERENCES Menu_Section (Menu_Section_ID);
ALTER TABLE Reviews ADD CONSTRAINT FKReviews705395 FOREIGN KEY (User_ID) REFERENCES Users (User_ID);
ALTER TABLE Reviews ADD CONSTRAINT FKReviews829770 FOREIGN KEY (Menu_ID) REFERENCES Menu_Items (Menu_ID);
ALTER TABLE Review_Image ADD CONSTRAINT FKReview_Ima134755 FOREIGN KEY (Menu_ID) REFERENCES Menu_Items (Menu_ID);
ALTER TABLE Review_Image ADD CONSTRAINT FKReview_Ima383783 FOREIGN KEY (Review_ID) REFERENCES Reviews (Review_ID);
ALTER TABLE `Like` ADD CONSTRAINT FKLike957958 FOREIGN KEY (Review_ID) REFERENCES Reviews (Review_ID);
ALTER TABLE Cart ADD CONSTRAINT FKCart810961 FOREIGN KEY (User_ID) REFERENCES Users (User_ID);
ALTER TABLE Cart ADD CONSTRAINT FKCart202246 FOREIGN KEY (Cart_ID) REFERENCES Orders (Order_ID);
ALTER TABLE Orders ADD CONSTRAINT FKOrders223228 FOREIGN KEY (Order_Payment_Method) REFERENCES Order_Payment_Method (Payment_Method_ID);
ALTER TABLE `Like` ADD CONSTRAINT FKLike271269 FOREIGN KEY (Like_ID) REFERENCES Users (User_ID);
ALTER TABLE Cart ADD CONSTRAINT FKCart686586 FOREIGN KEY (Menu_ID) REFERENCES Menu_Items (Menu_ID);
ALTER TABLE Menu_Items_Menu_Tag ADD CONSTRAINT FKMenu_Items267332 FOREIGN KEY (Menu_ID) REFERENCES Menu_Items (Menu_ID);
ALTER TABLE Menu_Items_Menu_Tag ADD CONSTRAINT FKMenu_Items954971 FOREIGN KEY (Menu_Tag_ID) REFERENCES Menu_Tag (Menu_Tag_ID);
