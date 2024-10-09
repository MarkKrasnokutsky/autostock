CREATE TABLE `autostock`.`платёж` (
                                      `Номер_Платежа` INT NOT NULL AUTO_INCREMENT,
                                      `Номер_Продажи` INT NOT NULL,
                                      `Дата_Платежа` DATE NOT NULL,
                                      `Сумма_Платежа` INT NOT NULL,
                                      `Способ_Оплаты` VARCHAR(45) NOT NULL,
                                      CHECK (`Сумма_Платежа` > 0),
                                      PRIMARY KEY (`Номер_Платежа`),
                                      CONSTRAINT `Номер_Продажи`
                                          FOREIGN KEY (`Номер_Продажи`)
                                              REFERENCES `autostock`.`продажа` (`Номер_Продажи`),
                                              UNIQUE(`Номер_Продажи`));
