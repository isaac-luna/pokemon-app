package com.bankaya.pokemon.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Configuration class for setting up SOAP Web Services within the Spring application.
 * <p>
 * This configuration enables Spring Web Services, registers the necessary servlet for handling
 * SOAP requests, defines the WSDL definition for the Pokemon service, and loads the corresponding
 * XML Schema Definition (XSD) for request and response validation.
 * </p>
 * 
 * <p><strong>Annotations:</strong></p>
 * <ul>
 *   <li>{@link EnableWs}: Enables SOAP Web Services in the Spring application.</li>
 *   <li>{@link Configuration}: Indicates that the class can be used by the Spring IoC container as 
 *   a source of bean definitions.</li>
 * </ul>
 * 
 * <p><strong>Purpose:</strong></p>
 * <ul>
 *   <li>Enables and configures SOAP Web Services within the application.</li>
 *   <li>Registers the `MessageDispatcherServlet` to handle SOAP requests.</li>
 *   <li>Defines the WSDL for the Pokemon service, specifying the port type, location URI, target 
 *   namespace, and associated schema.</li>
 *   <li>Loads the XSD schema for validating SOAP messages.</li>
 * </ul>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Automatically detected and processed by Spring during application startup.</li>
 *   <li>Provides the necessary configuration for exposing SOAP endpoints at the specified URI.</li>
 * </ul>
 * 
 * @see EnableWs
 * @see Configuration
 * @see WsConfigurerAdapter
 * @see MessageDispatcherServlet
 * @see DefaultWsdl11Definition
 * @see XsdSchema
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    
    /**
     * Registers the {@link MessageDispatcherServlet} with the Spring application context.
     * <p>
     * The {@code MessageDispatcherServlet} is a specialized Spring Web Servlet that dispatches
     * SOAP messages to appropriate endpoints. It is configured with the application context and
     * set to transform WSDL locations to make them relative to the servlet's URL mapping.
     * </p>
     * 
     * <p><strong>Configuration Details:</strong></p>
     * <ul>
     *   <li><strong>URL Mapping:</strong> Configures the servlet to handle requests matching the 
     *   pattern {@code /ws/*}.</li>
     *   <li><strong>WSDL Location Transformation:</strong> Enables transformation of WSDL 
     *   locations to ensure correct path resolution.</li>
     * </ul>
     * 
     * <p><strong>Example Usage:</strong></p>
     * <pre>
     * A SOAP request sent to {@code http://localhost:8080/ws/pokemon} will be handled by the 
     * {@code MessageDispatcherServlet}.
     * </pre>
     * 
     * @param applicationContext The Spring {@link ApplicationContext} to associate with the 
     * servlet.
     * @return A {@link ServletRegistrationBean} that registers the {@link MessageDispatcherServlet} 
     * with the specified URL mapping.
     */
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    /**
     * Defines the WSDL (Web Services Description Language) for the Pokémon SOAP service.
     * <p>
     * The {@code DefaultWsdl11Definition} bean configures the WSDL with the following properties:
     * <ul>
     *   <li><strong>Port Type Name:</strong> "PokemonPort"</li>
     *   <li><strong>Location URI:</strong> "/ws"</li>
     *   <li><strong>Target Namespace:</strong> "http://bankaya.com/pokemon/xsd"</li>
     *   <li><strong>Schema:</strong> Associates the WSDL with the provided {@link XsdSchema} for 
     *   request and response validation.</li>
     * </ul>
     * This configuration ensures that the SOAP service is correctly described and accessible via 
     * the specified URI.
     * </p>
     * 
     * <p><strong>Example Usage:</strong></p>
     * <pre>
     * The WSDL can be accessed at {@code http://localhost:8080/ws/pokemon.wsdl}, providing the 
     * necessary definitions for clients to interact with the service.
     * </pre>
     * 
     * @param pokemonSchema The {@link XsdSchema} bean that defines the structure of SOAP requests 
     * and responses.
     * @return A configured {@link DefaultWsdl11Definition} bean for the Pokémon service WSDL.
     */
    @Bean(name = "pokemon")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pokemonSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("PokemonPort");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://bankaya.com/pokemon/xsd");
        definition.setSchema(pokemonSchema);
        return definition;
    }
    
    /**
     * Loads the XSD (XML Schema Definition) schema for the Pokémon SOAP service.
     * <p>
     * The {@code pokemonSchema} bean reads the "pokemon.xsd" file from the classpath and creates a
     *  {@link SimpleXsdSchema} instance.
     * This schema is used to validate the structure of SOAP requests and responses, ensuring they 
     * conform to the defined types and elements.
     * </p>
     * 
     * <p><strong>Configuration Details:</strong></p>
     * <ul>
     *   <li><strong>Schema Location:</strong> "pokemon.xsd" located in the classpath resources.</li>
     * </ul>
     * 
     * <p><strong>Example Usage:</strong></p>
     * <pre>
     * The schema defines complex types such as {@code PokemonDto}, {@code PokemonAbilityDto}, and 
     * {@code PokemonHeldItemDto}, which are used in SOAP messages.
     * </pre>
     * 
     * @return A {@link XsdSchema} instance representing the Pokémon service schema.
     */
    @Bean
    public XsdSchema pokemonSchema() {
        return new SimpleXsdSchema(new ClassPathResource("pokemon.xsd"));
    }

}