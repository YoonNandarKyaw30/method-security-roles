package org.example.methodsecurityrules.config;

import org.example.methodsecurityrules.security.DocumentPermissionEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
public class SecurityConfig {

    private final DocumentPermissionEvaluator evaluator;

    public SecurityConfig(DocumentPermissionEvaluator evaluator) {
        this.evaluator = evaluator;
    }
    @Bean
    public MethodSecurityExpressionHandler createExpressionHandler(){
        var expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(evaluator);
        return expressionHandler;
    }
    @Bean
    public UserDetailsService userDetailsService(){
        var uds = new InMemoryUserDetailsManager();
        var u1 = User.withUsername("john")
                .password("12345")
                .roles("ADMIN")
                .build();

        var u2 = User.withUsername("emma")
                .password("12345")
                .roles("USER")
                .build();

        uds.createUser(u1);
        uds.createUser(u2);

        return uds;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
