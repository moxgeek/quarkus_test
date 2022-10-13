CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
);

CREATE TABLE `smartfeature` (
  `id` bigint(20) NOT NULL,
  `identifier` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
);

CREATE TABLE `smartmodel` (
  `smart_category` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `identifier` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
);

CREATE TABLE `smartmodel_smartfeature` (
  `SmartModel_id` bigint(20) NOT NULL,
  `features_id` bigint(20) NOT NULL
);

ALTER TABLE `smartfeature`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `smartmodel`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `smartmodel_smartfeature`
  ADD UNIQUE KEY `UK_4oydimo0qftfdikwe9dtgcku0` (`features_id`),
  ADD KEY `FKb4ut8ttftpcc9vpgfl0c9ueck` (`SmartModel_id`);
