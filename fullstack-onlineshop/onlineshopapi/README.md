# Online Shop API

## Running Locally

Activate the `local` profile to use preconfigured dev credentials:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

Or set the environment variable `SPRING_PROFILES_ACTIVE=local` in your IDE run configuration.

For deployed environments, all sensitive values (`DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USERNAME`, `DB_PASSWORD`, `JWT_SECRET`, `CORS_ALLOWED_ORIGINS`) must be provided via environment variables.

## Resources
- Swagger UI: http://localhost:3000/api/swagger-ui/index.html
- API docs: http://localhost:3000/api/v3/api-docs
