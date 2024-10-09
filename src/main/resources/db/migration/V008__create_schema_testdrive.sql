CREATE TABLE `autostock`.`тест_драйв` (
                                          `Номер_Тест_Драйва` INT NOT NULL AUTO_INCREMENT,
                                          `Код_Клиента` INT NOT NULL,
                                          `Код_Сотрудника` INT NOT NULL,
                                          `Id_Автомобиля` INT NOT NULL,
                                          `Дата_Проведения` DATE NOT NULL,
                                          PRIMARY KEY (`Номер_Тест_Драйва`),
                                          CONSTRAINT `Клиент_Тест_Драйва`
                                              FOREIGN KEY (`Код_Клиента`)
                                                  REFERENCES `autostock`.`клиент` (`Код_Клиента`),
                                                  CONSTRAINT `Сотрудник_Тест_Драйва`
                                                  FOREIGN KEY (`Код_Сотрудника`)
                                                  REFERENCES `autostock`.`сотрудник` (`Код_Сотрудника`),
                                                  CONSTRAINT `Автомобиль_Тест_Драйва`
                                                  FOREIGN KEY (`Id_Автомобиля`)
                                                  REFERENCES `autostock`.`автомобиль` (`id_Автомобиля`));
