DELETE FROM users;
INSERT INTO users (username, password, role, enabled)
VALUES ('user', '{noop}password', 'user', 1);
