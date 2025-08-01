# desafio-alura-foroHub
# ForoHub API

API RESTful para la gestión de tópicos en un foro de discusión. Implementada con Java y Spring Boot, incluyendo autenticación con JWT, persistencia con Spring Data JPA y validaciones con Jakarta Bean Validation.

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security 6** – Autenticación y autorización con JWT
- **Spring Data JPA** – Acceso a base de datos
- **Hibernate** – ORM para persistencia
- **MySQL** – Base de datos relacional
- **Jakarta Validation** – Validaciones de datos
- **Insomnia/Postman** – Pruebas de endpoints
- **JJWT (Java JWT)** – Generación y validación de tokens JWT

---

## 📁 Estructura del proyecto

```bash
src/
├── main/
│   ├── java/
│   │   └── foroHub/
│   │       ├── api/
│   │       │   ├── controller/
│   │       │   ├── model/
│   │       │   ├── repository/
│   │       │   ├── DTO/
│   │       │   ├── service/
│   │       │   └── security/
│   └── resources/
│       ├── application.properties

🔐 Autenticación
La API utiliza JWT (JSON Web Tokens) para proteger sus endpoints.
Para autenticarte:

Login:

bash
Copiar
Editar
POST /auth/login
Content-Type: application/json
Body:
{
  "login": "usuario",
  "password": "contraseña"
}
Respuesta:

json
Copiar
Editar
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
Usa el token en el resto de peticiones:

makefile
Copiar
Editar
Authorization: Bearer <token>
📚 Endpoints principales
🧑‍💻 Autenticación
Método	Endpoint	Descripción
POST	/auth/login	Obtiene un token JWT

💬 Tópicos
Método	Endpoint	Descripción
GET	/topicos	Lista todos los tópicos
GET	/topicos/{id}	Detalle de un tópico
POST	/topicos	Crea un nuevo tópico
PUT	/topicos/{id}	Actualiza un tópico
DELETE	/topicos/{id}	Elimina un tópico

🧪 Pruebas con Insomnia
Ejemplo de headers necesarios:

makefile
Copiar
Editar
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
Content-Type: application/json
⚙️ Configuración
En application.properties configura tu conexión a la base de datos y claves JWT:

properties
Copiar
Editar
spring.datasource.url=jdbc:mysql://localhost:3306/foro
spring.datasource.username=root
spring.datasource.password=tu_contraseña

api.security.secret=clave-super-secreta
🛠️ Compilar y ejecutar
Desde terminal:
bash
Copiar
Editar
./mvnw spring-boot:run
Desde IntelliJ:
Ejecuta la clase ApiApplication.java como aplicación Spring Boot.

✅ Requisitos
JDK 17

MySQL 8+

Maven 3.8+

Postman o Insomnia para pruebas

📌 Futuras mejoras
Paginación y ordenamiento

Documentación con Swagger/OpenAPI

Gestión de usuarios y roles

Comentarios y categorías

🧑‍💻 Autor
Proyecto desarrollado por Claudia Sanchez como práctica de desarrollo de APIs REST con Spring Boot.

📄 Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.
