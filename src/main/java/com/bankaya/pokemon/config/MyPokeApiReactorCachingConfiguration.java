package com.bankaya.pokemon.config;

import java.time.Duration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import skaro.pokeapi.PokeApiReactorCachingConfiguration;

/**
 * Configuration class for setting up caching and HTTP client settings for the Pokemon API integration.
 * <p>
 * This configuration enables caching within the Spring application context and imports additional 
 * caching configurations from {@link PokeApiReactorCachingConfiguration}. It also defines beans for
 * {@link ConnectionProvider} and {@link HttpClient} to manage HTTP connections efficiently.
 * </p>
 * 
 * <p><strong>Annotations:</strong></p>
 * <ul>
 *   <li>{@link Configuration}: Indicates that the class can be used by the Spring IoC container as 
 *   a source of bean definitions.</li>
 *   <li>{@link Import}: Allows for importing additional configuration classes. Here, it imports 
 *   {@link PokeApiReactorCachingConfiguration}.</li>
 *   <li>{@link EnableCaching}: Enables Spring's annotation-driven cache management capability.</li>
 * </ul>
 * 
 * <p><strong>Purpose:</strong></p>
 * <ul>
 *   <li>Enables caching to improve performance by storing frequently accessed data.</li>
 *   <li>Configures the Reactor Netty {@link HttpClient} with a custom {@link ConnectionProvider} 
 *   to manage HTTP connections efficiently.</li>
 * </ul>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Automatically detected and processed by Spring during application startup.</li>
 *   <li>Provides custom HTTP client configurations for interacting with external Pokemon APIs.</li>
 * </ul>
 * 
 * @see Configuration
 * @see Import
 * @see EnableCaching
 * @see ConnectionProvider
 * @see HttpClient
 * @see PokeApiReactorCachingConfiguration
 */
@Configuration
@Import(PokeApiReactorCachingConfiguration.class)
@EnableCaching
public class MyPokeApiReactorCachingConfiguration {

    /**
     * Creates and configures a {@link ConnectionProvider} bean for managing HTTP connections.
     * <p>
     * The {@code ConnectionProvider} is configured with the following settings:
     * <ul>
     * <li><strong>Name:</strong> "Auto refresh & no connection limit"</li>
     * <li><strong>Maximum Idle Time:</strong> 10 seconds</li>
     * <li><strong>Maximum Connections:</strong> 500</li>
     * <li><strong>Pending Acquire Max Count:</strong> Unlimited (-1)</li>
     * </ul>
     * These settings ensure efficient management of HTTP connections, allowing for high concurrency
     * and minimizing connection overhead.
     * </p>
     * 
     * @return A configured {@link ConnectionProvider} instance.
     */
    @Bean
    public ConnectionProvider connectionProvider() {
        return ConnectionProvider.builder("Auto refresh & no connection limit")
                .maxIdleTime(Duration.ofSeconds(10)).maxConnections(500).pendingAcquireMaxCount(-1)
                .build();
    }
    
    /**
     * Creates and configures an {@link HttpClient} bean using the provided {@link ConnectionProvider}.
     * <p>
     * The {@code HttpClient} is configured with the following settings:
     * <ul>
     *   <li><strong>Connection Provider:</strong> Uses the provided {@link ConnectionProvider} 
     *   for managing connections.</li>
     *   <li><strong>Compression:</strong> Enables HTTP response compression.</li>
     *   <li><strong>Address Resolver:</strong> Uses the default address resolver group for DNS 
     *   resolution.</li>
     * </ul>
     * These settings optimize the HTTP client for performance and reliability when communicating 
     * with external services.
     * </p>
     * 
     * @param connectionProvider The {@link ConnectionProvider} bean used to manage HTTP connections.
     * @return A configured {@link HttpClient} instance.
     */
    @Bean
    public HttpClient httpClient(ConnectionProvider connectionProvider) {
        return HttpClient.create(connectionProvider).compress(true)
                .resolver(DefaultAddressResolverGroup.INSTANCE);
    }
}
