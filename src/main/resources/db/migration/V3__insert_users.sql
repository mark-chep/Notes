DELETE FROM users;
INSERT INTO users (username, password, role, enabled)
VALUES ('user', 
        '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPZ08zax5AgWu8WtvBW', 
        'user', 1);
