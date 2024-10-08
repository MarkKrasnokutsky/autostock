CREATE TABLE `autostock`.`автомобиль` (
                                          `id_Автомобиля` INT NOT NULL AUTO_INCREMENT,
                                          `Тип_Кузова` VARCHAR(32) NOT NULL,
                                          `Марка` VARCHAR(128) NOT NULL,
                                          `Модель` VARCHAR(128) NOT NULL,
                                          `Цвет` VARCHAR(32) NOT NULL,
                                          `Год_Выпуска` INT NOT NULL,
                                          `Объём_Двигателя` DECIMAL(10,2) NOT NULL,
                                          `Лошадиные_Силы` INT NOT NULL,
                                          `Пробег` INT NOT NULL,
                                          `Стоимость` INT NOT NULL,
                                          `Статус` VARCHAR(32) NOT NULL,
                                          CHECK (`Год_Выпуска` > 1950 AND `Объём_Двигателя` > 0.1 AND `Лошадиные_Силы` > 0 AND `Пробег` > 0 AND `Стоимость` > 0),
                                          PRIMARY KEY (`id_Автомобиля`));
