package com.bankaya.pokemon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Configuration class for setting up Swagger/OpenAPI documentation for the Pokemon API.
 * <p>
 * This configuration class defines a bean that customizes the OpenAPI documentation, providing
 * metadata such as the API title, description, and version. By configuring OpenAPI, developers
 * and consumers can easily understand and interact with the API through a user-friendly interface.
 * </p>
 * 
 * <p><strong>Annotations:</strong></p>
 * <ul>
 *   <li>{@link Configuration}: Indicates that the class can be used by the Spring IoC container
 *       as a source of bean definitions.</li>
 * </ul>
 * 
 * <p><strong>Purpose:</strong></p>
 * <ul>
 *   <li>Enables and customizes Swagger/OpenAPI documentation for the application.</li>
 *   <li>Provides metadata to enhance the clarity and usability of the API documentation.</li>
 * </ul>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Automatically detected and processed by Spring during application startup.</li>
 *   <li>Accessible via the Swagger UI or OpenAPI endpoints to visualize and interact with the API.</li>
 * </ul>
 * 
 * @see Configuration
 * @see OpenAPI
 * @see Info
 */
@Configuration
public class SwaggerConfig {

    /**
     * Creates and configures a custom {@link OpenAPI} bean for the Pokemon API documentation.
     * <p>
     * The {@code OpenAPI} instance is customized with the following information:
     * <ul>
     *   <li><strong>Title:</strong> "Pokemon API"</li>
     *   <li><strong>Description:</strong> "API that provides details, abilities, and items for 
     *   Pokemon."</li>
     *   <li><strong>Version:</strong> "v1"</li>
     * </ul>
     * This metadata enhances the generated Swagger/OpenAPI documentation, making it more informative
     * and easier to understand for developers and API consumers.
     * </p>
     * 
     * <p><strong>Example Usage:</strong></p>
     * <pre>
     * When the application is running, navigate to {@code /swagger-ui.html} or {@code /v3/api-docs} 
     * to view the API documentation.
     * </pre>
     * 
     * @return A configured {@link OpenAPI} instance containing the API metadata.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Pokemon API")
                .description("API that provides details, abilities, and items for Pokemon.")
                .version("v1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Repository")
                        .url("https://github.com/your-repo/pokemon-api"));
    }
}