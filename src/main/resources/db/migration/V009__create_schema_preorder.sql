CREATE TABLE `autostock`.`предзаказ` (
                                         `Номер_Предзаказа` INT NOT NULL,
                                         `Тип_Кузова` VARCHAR(32) NOT NULL,
                                         `Марка` VARCHAR(128) NOT NULL,
                                         `Модель` VARCHAR(128) NOT NULL,
                                         `Цвет` VARCHAR(32) NOT NULL,
                                         `Пробег` INT NOT NULL,
                                         `Страна_Экспорта` VARCHAR(32) NOT NULL,
                                         `Код_Клиента` INT NOT NULL,
                                         `Дата_Привоза` DATE NOT NULL,
                                         PRIMARY KEY (`Номер_Предзаказа`),
                                         CONSTRAINT `Код_Клиента_Предзаказ`
                                             FOREIGN KEY (`Код_Клиента`)
                                                 REFERENCES `autostock`.`клиент` (`Код_Клиента`));
