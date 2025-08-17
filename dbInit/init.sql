-- Create database if not exists
CREATE DATABASE IF NOT EXISTS EMS;
USE EMS;

-- 1️⃣ Roles table (no dependencies)
CREATE TABLE IF NOT EXISTS `roles` (
  `id` BINARY(16) NOT NULL,
  `role_name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 2️⃣ Departments table (no dependencies)
CREATE TABLE IF NOT EXISTS `departments` (
  `id` VARCHAR(100) NOT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 3️⃣ Users table (depends on roles)
CREATE TABLE IF NOT EXISTS `users` (
  `id` CHAR(36) NOT NULL,
  `email` VARCHAR(255) DEFAULT NULL,
  `password` VARCHAR(255) NOT NULL,
  `role_id` BINARY(16) DEFAULT NULL,
  `is_active` BIT(1) DEFAULT NULL,
  `created_at` DATETIME(6) DEFAULT NULL,
  `updated_at` DATETIME(6) DEFAULT NULL,
  `created_date` DATETIME(6) DEFAULT NULL,
  `updated_date` DATETIME(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 4️⃣ Employees table (depends on users and departments)
CREATE TABLE IF NOT EXISTS `employees` (
  `id` VARCHAR(100) NOT NULL,
  `user_id` CHAR(36) DEFAULT NULL,
  `first_name` VARCHAR(255) DEFAULT NULL,
  `last_name` VARCHAR(255) DEFAULT NULL,
  `phone` VARCHAR(255) DEFAULT NULL,
  `gender` VARCHAR(255) DEFAULT NULL,
  `dob` DATETIME(6) DEFAULT NULL,
  `department_id` VARCHAR(100) DEFAULT NULL,
  `designation` VARCHAR(255) DEFAULT NULL,
  `joining_date` DATETIME(6) DEFAULT NULL,
  `shift_start` time DEFAULT NULL,
  `shift_end` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `department_id` (`department_id`),
  KEY `employees_ibfk_1` (`user_id`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 5️⃣ Leave requests table (depends on employees)
CREATE TABLE IF NOT EXISTS `leave_requests` (
  `id` BINARY(16) NOT NULL,
  `employee_id` VARCHAR(100) DEFAULT NULL,
  `leave_type` VARCHAR(255) DEFAULT NULL,
  `from_date` DATETIME(6) DEFAULT NULL,
  `to_date` DATETIME(6) DEFAULT NULL,
  `reason` VARCHAR(255) DEFAULT NULL,
  `status` VARCHAR(255) DEFAULT NULL,
  `requested_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `leave_requests_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 6️⃣ Attendance table (depends on employees)
CREATE TABLE IF NOT EXISTS `attendance` (
  `id` BINARY(16) NOT NULL,
  `employee_id` VARCHAR(100) DEFAULT NULL,
  `date` DATETIME(6) DEFAULT NULL,
  `check_in` DATETIME(6) DEFAULT NULL,
  `check_out` DATETIME(6) DEFAULT NULL,
  `status` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
