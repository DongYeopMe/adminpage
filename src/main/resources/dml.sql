-- Product 데이터 추가
INSERT INTO Product (product_id,product_name, product_code, product_category,product_price, open)
VALUES
    (1,'americano','CODE1', 'COFFEE', 100, true),
    (2,'chocolatte','CODE2', 'ADE', 200, true);
INSERT INTO Member (member_id,member_userid,member_email, member_password, member_name, member_gender, member_rank)
VALUES
    (1,'elell123','john.doe@example.com', 'password123', 'John Doe', 'Male', 'VIP'),
    (2,'eelel22','jane.smith@example.com', 'securePass!456', 'Jane Smith', 'Female', 'GOLD');
