CREATE TABLE `autostock`.`оснащение` (
                                         `Id_Оснащения` INT NOT NULL,
                                         `Id_Автомобиля` INT NOT NULL,
                                         `Id_Оборудования` INT NOT NULL,
                                         PRIMARY KEY (`Id_Оснащения`),
                                         CONSTRAINT `Id_Авто`
                                             FOREIGN KEY (`Id_Автомобиля`)
                                                 REFERENCES `autostock`.`автомобиль` (`id_Автомобиля`),
                                                 CONSTRAINT `Id_Оборудования`
                                                 FOREIGN KEY (`Id_Оборудования`)
                                                 REFERENCES `autostock`.`оборудование` (`Id_Оборудования`));
