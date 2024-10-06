CREATE TABLE `autostock`.`оборудование` (
                                            `Id_Оборудования` INT NOT NULL,
                                            `Название` VARCHAR(64) NOT NULL,
                                            `Стоимость` INT NOT NULL,
                                            `Кол-во` INT NOT NULL,
                                            CHECK (`Стоимость` > 0),
                                            PRIMARY KEY (`Id_Оборудования`));
