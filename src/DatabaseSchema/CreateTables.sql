use greetingcardcost;

CREATE TABLE `card` (
  `cardID` int NOT NULL AUTO_INCREMENT,
  `width` int NOT NULL,
  `length` int NOT NULL,
  PRIMARY KEY (`cardID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cost` (
  `greetingID` int NOT NULL,
  `cardID` int NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`greetingID`,`cardID`),
  KEY `cardID_idx` (`cardID`),
  CONSTRAINT `cost_card_cardID_fk` FOREIGN KEY (`cardID`) REFERENCES `card` (`cardID`),
  CONSTRAINT `cost_greeting_greetingID_fk` FOREIGN KEY (`greetingID`) REFERENCES `greeting` (`greetingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `greeting` (
  `greetingID` int NOT NULL AUTO_INCREMENT,
  `message` varchar(90) NOT NULL,
  `uppercase` int NOT NULL,
  `lowercase` int NOT NULL,
  `special` int NOT NULL,
  `digits` int NOT NULL,
  PRIMARY KEY (`greetingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;