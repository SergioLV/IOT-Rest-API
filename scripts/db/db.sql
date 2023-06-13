-- Create the "admin" table
CREATE TABLE admin (
                       username VARCHAR(255) PRIMARY KEY,
                       password VARCHAR(255)
);


-- Create the "tokens" table
CREATE TABLE tokens (
                        token_value VARCHAR(255) PRIMARY KEY,
                        created_at TIMESTAMP
);

-- Create the "company" table
CREATE TABLE company (
                         company_id SERIAL PRIMARY KEY,
                         company_name VARCHAR(255) UNIQUE,
                         company_api_key VARCHAR(255)
);

-- Create the "location" table
CREATE TABLE location (
                          location_id SERIAL PRIMARY KEY,
                          location_name VARCHAR(255),
                          location_country VARCHAR(255),
                          location_city VARCHAR(255),
                          location_meta VARCHAR(255),
                          company_id INT,
                          FOREIGN KEY (company_id) REFERENCES company(company_id),
                          CONSTRAINT uc_company_location UNIQUE (company_id, location_name)
);

-- Create the "sensor" table
CREATE TABLE sensor (
                        sensor_id SERIAL PRIMARY KEY,
                        location_id INT,
                        sensor_name VARCHAR(255),
                        sensor_category VARCHAR(255),
                        sensor_meta VARCHAR(255),
                        sensor_api_key VARCHAR(255),
                        FOREIGN KEY (location_id) REFERENCES location(location_id),
                        CONSTRAINT uc_name_meta UNIQUE (sensor_name, sensor_meta)
);

-- Create the "humidity_sensor" table
CREATE TABLE humidity_sensors_data (
                                 humidity_sensor_id SERIAL PRIMARY KEY,
                                 sensor_id INT,
                                 timestamp TIMESTAMP,
                                 percentage DECIMAL(6, 4)
);

CREATE TABLE temperature_sensors_data (
                                       temperature_sensor_id SERIAL PRIMARY KEY,
                                       sensor_id INT,
                                       timestamp TIMESTAMP,
                                       temperature DECIMAL(6, 4)
);

INSERT INTO admin (username, password) VALUES ('admin', '511bc56250dfd22b78f2aa0fc18959fe2c661a5441d0053ddcfe30fd4834018460b8bb840b9d4f0024a15313958b8a81ad57c05fc6791f89ede299cfead3297e');
