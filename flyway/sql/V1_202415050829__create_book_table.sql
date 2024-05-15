CREATE TABLE `library`.`books` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `edition` VARCHAR(45) NULL,
  `volume` INT NULL,
  `taken` TINYINT NULL,
  PRIMARY KEY (`id`));
