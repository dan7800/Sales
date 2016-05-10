--liquibase formatted sql

--changeset codecentric-docs:release_1.create_tables.sql
CREATE TABLE `sales` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;