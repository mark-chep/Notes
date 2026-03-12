DELETE FROM users;
INSERT INTO users (username, password, role, enabled)
VALUES ('user', 
        '$2a$10$ByIUiNa.nNoer8u6E1Z29u.yT6v7mK9A7Ld4B3jYd.D1Gj0vU9GqO', 
        'ROLE_USER', 1);
