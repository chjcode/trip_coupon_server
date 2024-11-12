CREATE TABLE Sido (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      sido_code INT NOT NULL,
                      sido_name VARCHAR(20) NOT NULL
);

CREATE TABLE Gugun (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       sido_id BIGINT NOT NULL,
                       gugun_code INT NOT NULL,
                       gugun_name VARCHAR(20) NOT NULL,
                       FOREIGN KEY (sido_id) REFERENCES Sido(id)
);

CREATE TABLE ContentType (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             content_type_name VARCHAR(45) NOT NULL
);

CREATE TABLE Attraction (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            title VARCHAR(500) NOT NULL,
                            content_type_id BIGINT,
                            sido_id BIGINT,
                            gugun_id BIGINT,
                            first_image_url VARCHAR(100),
                            second_image_url VARCHAR(100),
                            map_level INT,
                            latitude DECIMAL(20, 17),
                            longitude DECIMAL(20, 17),
                            tel VARCHAR(20),
                            first_address VARCHAR(100),
                            second_address VARCHAR(100),
                            homepage VARCHAR(1000),
                            overview TEXT,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (content_type_id) REFERENCES ContentType(id),
                            FOREIGN KEY (sido_id) REFERENCES Sido(id),
                            FOREIGN KEY (gugun_id) REFERENCES Gugun(id)
);

CREATE TABLE User (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      nickname VARCHAR(20) NOT NULL,
                      email VARCHAR(100) UNIQUE NOT NULL,
                      password VARCHAR(100) NOT NULL,
                      role ENUM('ADMIN', 'USER') DEFAULT 'USER',
                      registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Coupon (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        attraction_id BIGINT,
                        user_id BIGINT,
                        published_number INT,
                        FOREIGN KEY (attraction_id) REFERENCES Attraction(id),
                        FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Board (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       user_id BIGINT NOT NULL,
                       title VARCHAR(255) NOT NULL,
                       content TEXT NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES User(id)
);