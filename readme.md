Database configuration

Login to psql
psql -U postgres

Database creation
CREATE DATABASE healthcare_db;

User creation
CREATE USER healthcare_user WITH ENCRYPTED PASSWORD 'healthcare_user';

Grant privileges
GRANT ALL PRIVILEGES ON DATABASE healthcare_db TO healthcare_user;

