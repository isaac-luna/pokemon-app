package com.bankaya.pokemon.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.web.reactive.function.client.WebClientRequestException;

/**
 * Analyzes {@link WebClientRequestException} failures and provides detailed failure analysis.
 * <p>
 * This analyzer extends Spring Boot's {@link AbstractFailureAnalyzer} to intercept and analyze
 * {@link WebClientRequestException} instances that occur during HTTP requests made by
 * {@link org.springframework.web.reactive.function.client.WebClient}. It generates a
 * {@link FailureAnalysis} object containing a descriptive message and suggested action to help
 * developers diagnose and resolve issues related to external service connectivity.
 * </p>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Automatically invoked by Spring Boot when a {@link WebClientRequestException} is thrown.</li>
 *   <li>Generates user-friendly error messages to aid in troubleshooting external service 
 *   connectivity problems.</li>
 * </ul>
 * 
 * <p><strong>Example Scenario:</strong></p>
 * <pre>
 * If a {@link WebClient} instance fails to connect to an external API due to an incorrect URL or 
 * network issues, this analyzer will produce a failure analysis with a description of the error 
 * and a suggested action to verify the service URL and network connectivity.
 * </pre>
 * 
 * <p><strong>Annotations:</strong></p>
 * <ul>
 *   <li>No specific annotations are required for this class.</li>
 * </ul>
 * 
 * <p><strong>Dependencies:</strong></p>
 * <ul>
 *   <li>{@link AbstractFailureAnalyzer}: Base class for failure analyzers.</li>
 *   <li>{@link WebClientRequestException}: Exception type that this analyzer handles.</li>
 *   <li>{@link FailureAnalysis}: Encapsulates the failure description and suggested action.</li>
 * </ul>
 * 
 * <p><strong>Thread Safety:</strong></p>
 * <ul>
 *   <li>This class is thread-safe as it does not maintain any mutable state.</li>
 * </ul>
 * 
 * @see AbstractFailureAnalyzer
 * @see WebClientRequestException
 * @see FailureAnalysis
 */
public class WebClientFailureAnalyzer extends AbstractFailureAnalyzer<WebClientRequestException> {

    /**
     * Analyzes the root failure and the specific {@link WebClientRequestException} to produce a
     * {@link FailureAnalysis} containing a description of the error and a recommended action.
     *
     * @param rootFailure The root cause of the failure, which may be different from the
     *                    {@code cause}.
     * @param cause       The specific {@link WebClientRequestException} that triggered this
     *                    analyzer.
     * @return A {@link FailureAnalysis} object containing the error description and suggested
     *         action, or {@code null} if this analyzer does not handle the given exception.
     */
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, WebClientRequestException cause) {
        String description = String.format(
                "ANALYZER - Failed to connect to the external service: %s",
                cause.getMessage());
        String action = "Verify the service URL and network connectivity.";
        return new FailureAnalysis(description, action, cause);
    }
}