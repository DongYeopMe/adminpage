-- Product 데이터 추가
INSERT INTO Product (product_id,name, product_code, category,price, open)
VALUES
    (1,'americano','CODE1', 'COFFEE', 100, true),
    (2,'chocolatte','CODE2', 'ADE', 200, true);
INSERT INTO Member (member_id,member_email, member_password, member_name, member_gender, member_rank)
VALUES
    (1,'john.doe@example.com', 'password123', 'John Doe', 'Male', 'VIP'),
    (2,'jane.smith@example.com', 'securePass!456', 'Jane Smith', 'Female', 'GOLD');
