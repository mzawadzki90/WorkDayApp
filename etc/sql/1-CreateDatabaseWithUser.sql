CREATE DATABASE workdayapp;
CREATE USER workdayapp_user WITH ENCRYPTED PASSWORD 'workdayapp';
GRANT ALL PRIVILEGES ON DATABASE workdayapp TO workdayapp_user;