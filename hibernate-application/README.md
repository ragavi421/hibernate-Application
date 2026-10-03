# Hibernate Application

Maven-based Hibernate application that maps a `Student` entity to a MySQL `student` table.

## Database

- Host: db01.dbhost.dev
- Port: 5051
- Database: db_4552jmwnd
- Username: user_4552jmwnd

The supplied database password is configured in `src/main/resources/hibernate.cfg.xml`.

## Requirements

- Java 8+
- Maven
- Internet access for Maven dependencies
- MySQL-compatible database access

## Run

From the project folder:

```bash
mvn clean compile
mvn exec:java
```

Hibernate uses `hibernate.hbm2ddl.auto=update`, so it will create/update the `student` table automatically.

The application:
1. Creates a Student object.
2. Inserts it using Hibernate.
3. Prints the inserted record.
4. Updates the course field.
5. Prints the updated record.

## Student fields

- ID
- Name
- Email
- Course
