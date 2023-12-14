# TaskTracker

TaskTracker - это простая система управления задачами, разработанная с использованием Java и Spring.

## Требования

1. Java 17+
2. Spring Boot
3. PostgreSQL или MySQL
4. Docker Compose

## Установка и запуск

1. **Клонирование репозитория:**
   ```bash
   git clone <URL_Вашего_репозитория>
   cd TaskTracker
Настройка базы данных:

Создайте базу данных в PostgreSQL или MySQL.
Конфигурация приложения:

Откройте файл src/main/resources/application.properties и укажите настройки вашей базы данных.
Сборка и запуск:

bash
Copy code
./mvnw clean package
docker-compose up
Это соберет проект и запустит его с помощью Docker Compose.

Swagger UI:
После запуска, перейдите по адресу http://localhost:8080/swagger-ui.html для доступа к Swagger UI и документации API.

Использование API
API описано в Swagger UI, но вот несколько примеров:

Регистрация пользователя:

bash
Copy code
curl -X POST "http://localhost:8080/auth/signup" -H "Content-Type: application/json" -d '{"email": "user@example.com", "password": "password"}'
Аутентификация и получение токена:

bash
Copy code
curl -X POST "http://localhost:8080/auth/login" -H "Content-Type: application/json" -d '{"email": "user@example.com", "password": "password"}'
Создание новой задачи:

bash
Copy code
curl -X POST "http://localhost:8080/tasks" -H "Authorization: Bearer <Ваш_JWT_токен>" -H "Content-Type: application/json" -d '{"title": "Новая задача", "description": "Описание задачи", "priority": "высокий", "status": "в ожидании"}'
Тестирование
Для запуска тестов выполните:

bash
Copy code
./mvnw test
