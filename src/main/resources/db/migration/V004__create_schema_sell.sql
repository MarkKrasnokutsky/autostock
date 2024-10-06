CREATE TABLE `autostock`.`продажа` (
                                                    `Номер_Продажи` INT NOT NULL,
                                                    `Id_Автомобиля` INT NOT NULL,
                                                    `Код_Клиента` INT NOT NULL,
                                                    `Код_Сотрудника` INT NOT NULL,
                                                    `Дата_Продажи` DATE NOT NULL,
                                                    `Итоговая_Стоимость` INT NOT NULL,
                                                    `Статус_Оплаты` VARCHAR(45) NOT NULL,
                                                    CHECK (`Итоговая_Стоимость` > 0),
                                                    PRIMARY KEY (`Номер_Продажи`),
                                                    CONSTRAINT `Id_Автомобиля`
                                                        FOREIGN KEY (`Id_Автомобиля`)
                                                            REFERENCES `autostock`.`автомобиль` (`id_Автомобиля`),
                                                    CONSTRAINT `Код_Клиента`
                                                        FOREIGN KEY (`Код_Клиента`)
                                                            REFERENCES `autostock`.`клиент` (`Код_Клиента`),
                                                    CONSTRAINT `Код_Сотрудника`
                                                        FOREIGN KEY (`Код_Сотрудника`)
                                                            REFERENCES `autostock`.`сотрудник` (`Код_Сотрудника`),
                                                    UNIQUE(`Id_Автомобиля`));
