package com.bankaya.pokemon.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.beans.factory.BeanCreationException;

/**
 * Analyzes {@link BeanCreationException} failures and provides detailed failure analysis.
 * <p>
 * This analyzer extends Spring Boot's {@link AbstractFailureAnalyzer} to intercept and analyze
 * {@link BeanCreationException} instances that occur during the bean creation process. It generates
 * a {@link FailureAnalysis} object containing a descriptive message and suggested action to help
 * developers diagnose and resolve bean creation issues.
 * </p>
 * 
 * <p><strong>Usage:</strong></p>
 * <ul>
 *   <li>Automatically invoked by Spring Boot when a {@link BeanCreationException} is thrown.</li>
 *   <li>Generates user-friendly error messages to aid in troubleshooting bean configuration 
 *   problems.</li>
 * </ul>
 * 
 * <p><strong>Example Scenario:</strong></p>
 * <pre>
 * If a bean named "dataSource" fails to initialize due to a missing dependency, this analyzer
 * will produce a failure analysis with a description of the error and a suggested action to
 * check the bean definition and its dependencies.
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
 *   <li>{@link BeanCreationException}: Exception type that this analyzer handles.</li>
 *   <li>{@link FailureAnalysis}: Encapsulates the failure description and suggested action.</li>
 * </ul>
 * 
 * <p><strong>Thread Safety:</strong></p>
 * <ul>
 *   <li>This class is thread-safe as it does not maintain any mutable state.</li>
 * </ul>
 * 
 * @see AbstractFailureAnalyzer
 * @see BeanCreationException
 * @see FailureAnalysis
 */
public class BeanCreationFailureAnalyzer extends AbstractFailureAnalyzer<BeanCreationException> {

    /**
     * Analyzes the root failure and the specific {@link BeanCreationException} to produce a
     * {@link FailureAnalysis} containing a description of the error and a recommended action.
     *
     * @param rootFailure The root cause of the failure, which may be different from the
     *                    {@code cause}.
     * @param cause       The specific {@link BeanCreationException} that triggered this analyzer.
     * @return A {@link FailureAnalysis} object containing the error description and suggested
     *         action, or {@code null} if this analyzer does not handle the given exception.
     */
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, BeanCreationException cause) {
        String description = String.format("ANALYZER - Error creating bean with name '%s': %s",
                cause.getBeanName(),
                cause.getMessage());
        String action = "Check the bean definition and dependencies.";
        return new FailureAnalysis(description, action, cause);
    }
}
