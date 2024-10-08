CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE user_roles (
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    role_id INT REFERENCES roles(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);
CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);

CREATE UNIQUE INDEX ix_auth_username_authority ON authorities (username, authority);

INSERT INTO users (username, password, enabled) VALUES
('user', 'password', true),
('admin', 'adminpass', true);

INSERT INTO roles (role_name) VALUES
('ROLE_USER'),
('ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES
((SELECT id FROM users WHERE username = 'user'), (SELECT id FROM roles WHERE role_name = 'ROLE_USER')),
((SELECT id FROM users WHERE username = 'admin'), (SELECT id FROM roles WHERE role_name = 'ROLE_ADMIN'));