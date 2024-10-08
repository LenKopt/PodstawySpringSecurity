-- Создание таблицы для пользователей
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- исправляем SERIAL на AUTO_INCREMENT
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

-- Создание таблицы для ролей
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL UNIQUE
);

-- Создание таблицы для связи пользователей и ролей (многие ко многим)
CREATE TABLE user_roles (
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    role_id INT REFERENCES roles(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);
-- Создание таблицы для ролей пользователей
CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);

-- Уникальный индекс для таблицы authorities
CREATE UNIQUE INDEX ix_auth_username_authority ON authorities (username, authority);

-- Вставка пользователей
INSERT INTO users (username, password, enabled) VALUES
('user', 'password', true),
('admin', 'adminpass', true);

-- Вставка ролей
INSERT INTO roles (role_name) VALUES
('ROLE_USER'),
('ROLE_ADMIN');

-- Связывание пользователей с их ролями
INSERT INTO user_roles (user_id, role_id) VALUES
((SELECT id FROM users WHERE username = 'user'), (SELECT id FROM roles WHERE role_name = 'ROLE_USER')),
((SELECT id FROM users WHERE username = 'admin'), (SELECT id FROM roles WHERE role_name = 'ROLE_ADMIN'));