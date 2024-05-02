package com.rfrey.book.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Raphael Frey",
                        email = "raphael-frey@gmx.net",
                        url = "https://raphael-frey.de"
                ),
                description = "OpenAPI description for the Book Network API",
                title = "OpenAPI specification for the Book Network API",
                version = "1.0",
                license = @License(
                        name = "MIT",
                        url = "https://opensource.org/licenses/MIT"
                ),
                termsOfService = "https://opensource.org/licenses/MIT"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8088/api/v1",
                        description = "Local development server"
                ),
                @Server(
                        url = "https://books.raphael-frey/api/v1",
                        description = "Production server"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "Bearer token authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
