-- Create table
CREATE TABLE IF NOT EXISTS Product (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    price FLOAT,
    stock INT
    );

-- Insert sample data
INSERT INTO Product (name, category, price, stock) VALUES
                                                       ('Laptop', 'Electronics', 1200.50, 10),
                                                       ('Smartphone', 'Electronics', 800.00, 25),
                                                       ('Coffee Mug', 'Kitchen', 12.99, 50);