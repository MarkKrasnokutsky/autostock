CREATE TABLE `autostock`.`сотрудник` (
                                         `Код_Сотрудника` INT NOT NULL,
                                         `ФИО_Сотрудника` VARCHAR(256) NOT NULL,
                                         `Номер_Телефона` VARCHAR(12) NOT NULL,
                                         `Должность` VARCHAR(45) NOT NULL,
                                         `Зарплата` INT NOT NULL,
                                         CHECK (`Зарплата` > 0),
                                         PRIMARY KEY (`Код_Сотрудника`));
