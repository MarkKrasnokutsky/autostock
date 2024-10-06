CREATE TABLE autostock.`клиент` (
                                    `Код_Клиента` INT NOT NULL AUTO_INCREMENT,
                                    `ФИО_клиента` VARCHAR(256) NOT NULL,
                                    `Номер_Телефона` VARCHAR(12) NOT NULL,
                                    `Дата_Рождения` DATE NOT NULL,
                                    PRIMARY KEY (`Код_Клиента`),
                                        UNIQUE(`Номер_Телефона`));
