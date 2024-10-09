CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);

CREATE UNIQUE INDEX ix_auth_username_authority ON authorities (username, authority);

INSERT INTO users (username, password, enabled) VALUES
('admin', '$2a$12$vbV6AzQH2lkzoJq1tlDkKeJw8Ok9COmlrKq/PvJXym468LX4v4bwK', true);

INSERT INTO authorities (username, authority) VALUES
('admin', 'ROLE_ADMIN');