# eCommerce Microservices Platform

A production-ready e-commerce backend built with Spring Boot Microservices architecture.

## Tech Stack

- **Java & Spring Boot** — core microservices
- **Spring Cloud Gateway** — API gateway & routing
- **Eureka** — service discovery
- **Keycloak** — authentication & authorization (OAuth2 / JWT)
- **PostgreSQL** — relational data (product, order services)
- **MongoDB** — document storage (user service)
- **Apache Kafka + RabbitMQ** — async messaging & event-driven communication
- **Docker & Docker Compose** — containerization
- **Zipkin** — distributed tracing
- **Grafana + Loki + Prometheus** — logging & monitoring

## Services

| Service | Port | Description |
|---|---|---|
| `gateway` | 8080 | API Gateway |
| `eureka` | 8761 | Service Registry |
| `config-server` | 8888 | Centralized Config |
| `user-service` | 8082 | User management |
| `product-service` | 8081 | Product catalog |
| `order-service` | 8083 | Order management |
| `notification-service` | — | Event-driven notifications |

## Getting Started

### Prerequisites
- Java 17+
- Docker & Docker Compose
- Maven

### Run with Docker Compose

```bash
cd deploy/docker
docker compose up -d
```

### Run Locally

```bash
# Start infrastructure (postgres, mongo, kafka, keycloak, zipkin)
cd deploy/docker
docker compose up postgres mongo kafka zookeeper keycloak zipkin -d

# Start each service
cd configserver && mvn spring-boot:run
cd eureka && mvn spring-boot:run
cd gateway && mvn spring-boot:run
cd user && mvn spring-boot:run
cd product && mvn spring-boot:run
cd order && mvn spring-boot:run
cd notification && mvn spring-boot:run
```

## Author

**Bertuğ Kuturoglu**
- GitHub: [github.com/kuturogi](https://github.com/kuturogi)
- LinkedIn: [linkedin.com/in/bertugkuturoglu](https://linkedin.com/in/bertugkuturoglu)
- Email: bkuturoglu61@gmail.com
