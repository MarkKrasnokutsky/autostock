CREATE TABLE autostock.role (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE autostock.user (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                username VARCHAR(255) NOT NULL UNIQUE,
                                email VARCHAR(255) NOT NULL UNIQUE,
                                password VARCHAR(255) NOT NULL,
                                created_at DATETIME NOT NULL,
                                role_id INT,
                                CONSTRAINT FK_Пользователь_Роль FOREIGN KEY (`role_id`) REFERENCES autostock.role(id) ON DELETE SET NULL
);

CREATE TABLE `autostock`.`сотрудник` (
                                         `Код_Сотрудника` INT NOT NULL AUTO_INCREMENT,
                                         `ФИО_Сотрудника` VARCHAR(256) NOT NULL,
                                         `Номер_Телефона` VARCHAR(12) NOT NULL,
                                         `Должность` VARCHAR(45) NOT NULL,
                                         `Зарплата` INT NOT NULL,
                                         Id_Пользователя BIGINT,
                                         CHECK (`Зарплата` > 0),
                                         PRIMARY KEY (`Код_Сотрудника`),
                                             CONSTRAINT FK_Сотрудник_Пользователь FOREIGN KEY (`Id_Пользователя`) REFERENCES autostock.user(id));

CREATE TABLE autostock.`клиент` (
                                    `Код_Клиента` INT NOT NULL AUTO_INCREMENT,
                                    `ФИО_клиента` VARCHAR(256) NOT NULL,
                                    `Номер_Телефона` VARCHAR(12) NOT NULL,
                                    `Дата_Рождения` DATE NOT NULL,
                                    Id_Пользователя BIGINT,
                                    PRIMARY KEY (`Код_Клиента`),
                                    UNIQUE (`Номер_Телефона`),
                                    CONSTRAINT FK_Клиент_Пользователь FOREIGN KEY (`Id_Пользователя`) REFERENCES autostock.user(id));
