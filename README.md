# 🧩 Microservices System – Auth, API Gateway, Jokes & Quotee

Detta projekt består av fyra mikrotjänster:
- 🔐 **Auth Server** – Hanterar inloggning och generering av JWT-tokens.
- 🌐 **API Gateway** – Routing och validering av inkommande förfrågningar.
- 😂 **Joke Service** – Returnerar skämt, skyddad via JWT.
- 💬 **Quotee Service** – Returnerar citat, skyddad via JWT.

## 📦 Teknikstack
- Java 17
- Spring Boot 3
- Spring Security & OAuth2 Resource Server
- Docker & Docker Compose
- JWT (Json Web Token)

---

## 🚀 Kom igång

### ✅ Förutsättningar
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- Java 17 + Maven (för att bygga initialt)

---

### 🛠️ Bygg tjänsterna
Kör följande kommando från huvudmappen:

```bash
./mvnw spring-boot:build-image
Eller för Windows PowerShell:

powershell
Kopiera
Redigera
mvn spring-boot:build-image
🐳 Starta systemet
bash
Kopiera
Redigera
docker-compose up --build
Det startar alla mikrotjänster:

auth-server på http://localhost:8080

api-gateway på http://localhost:8081

joke-service på http://localhost:8082

quotee-service på http://localhost:8083

🧪 Testa systemet med Insomnia eller curl
1. 🔐 Hämta JWT-token
POST http://localhost:8080/auth/login

json
Kopiera
Redigera
{
  "username": "user",
  "password": "password"
}
Svar:

text
Kopiera
Redigera
<JWT_TOKEN_HÄR>
2. 😂 Hämta ett skämt (joke-service)
GET http://localhost:8082/api/jokes/random

Headers:

http
Kopiera
Redigera
Authorization: Bearer <JWT_TOKEN>
3. 💬 Hämta ett citat (quotee-service)
GET http://localhost:8083/api/quotee/random

Headers:

http
Kopiera
Redigera
Authorization: Bearer <JWT_TOKEN>
🧹 Stäng ner systemet
bash
Kopiera
Redigera
docker-compose down