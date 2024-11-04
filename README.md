# Tournament Manager API

This project is an API designed to manage damas (checkers) tournaments, with features like user registration, filtering tournaments by region, and managing player participation. The backend is built with Java and PostgreSQL for data persistence, and utilizes Mockaroo for generating mock data.

## Features

- User registration with region input.
- Automatic filtering of tournaments based on the user's region.
- Search functionality to browse tournaments in other regions.
- Tournament details, registration, and management.
- Player profile and tournament history management.

## Tech Stack

- **Backend**: Java (Spring Boot)
- **Database**: PostgreSQL
- **Data Mocking**: Mockaroo
- **API Documentation**: Swagger

## Prerequisites

Before running the project, ensure you have the following installed:

- [Java 11 or higher](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [PostgreSQL](https://www.postgresql.org/) (version 12 or higher)
- [Mockaroo](https://mockaroo.com/) account for generating mock data.

## API Documentation

### 🔧 [Technical Documentation](./API_Documentation.md) | For a detailed description of all API routes and their usage.

Swagger is used for API documentation too. After starting the server, you can access the documentation at `http://localhost:8080/swagger-ui.html`.


## Contributing

If you want to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/spot-damas-api`).
3. Make your changes.
4. Push to the branch (`git push origin feature/spot-damas-api`).
5. Create a Pull Request.

## License

This project is licensed under the MIT License.
