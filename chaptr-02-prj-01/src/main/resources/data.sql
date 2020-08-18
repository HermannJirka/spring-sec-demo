INSERT IGNORE INTO `spring`.`user` (`id`, `username`, `password`, `algorithm`) VALUES ('1',
'john', '$2y$12$EEy6XGeajI1J8HG4cVNsNenNR6TtGH.rVHqXILxPKCpo1ldqHY/U6', 'BCRYPT');
INSERT IGNORE INTO `spring`.`authority` (`id`, `name`, `user`) VALUES ('1', 'READ', '1');
INSERT IGNORE INTO `spring`.`authority` (`id`, `name`, `user`) VALUES ('2', 'WRITE', '1');
INSERT IGNORE INTO `spring`.`product` (`id`, `name`, `price`, `currency`) VALUES ('1',
'Chocolate', '10', 'USD');