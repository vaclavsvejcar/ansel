INSERT INTO a_user(id, email, password, first_name, last_name, language)
VALUES (1, 'test@test.com', '$2a$10$KL6Nv6WwpLpMIZyWLuB8l.14OnMjfh826ii1xgPTVUiFf9fyU5Y6e', 'John', 'Smith', 'ENGLISH_US');

select email, language from a_user;