USE userform;
CREATE  TABLE `userform`.`user` (

  `username` VARCHAR(50) NULL ,

  `password` VARCHAR(50) NOT NULL ,

  `email` VARCHAR(50) NOT NULL ,

  PRIMARY KEY (`username`) ,

  UNIQUE INDEX `email_UNIQUE` (`email` ASC) );