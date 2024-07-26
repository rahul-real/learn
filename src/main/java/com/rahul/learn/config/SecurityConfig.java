/**
 * 
 */
package com.rahul.learn.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author rahul
 * @since 13-Jan-2024 2024 8:37:38 pm
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
//	@Value("${jwt.allowedServiceHosts}")
//	private String[] allowedServiceHosts;
	
	@Value("${jwt.preFlightCacheMaxAge}")
	private long preFlightCacheMaxAge;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/swagger").permitAll())
                .headers(headers-> headers
                		.cacheControl(cacheControl -> cacheControl.disable())
                		.frameOptions(frameOptions -> frameOptions.disable()))
                .cors(cors -> cors.configure(http))
                .build();
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();   
        configuration.setAllowedMethods(Arrays.asList("GET,POST,OPTIONS"));
        configuration.setAllowCredentials(true);
        //configuration.setAllowedOrigins(Arrays.asList(allowedServiceHosts));
        configuration.setMaxAge(preFlightCacheMaxAge);
        configuration.setAllowedHeaders(Arrays.asList(
        		"Access-Control-Allow-Origin, Access-Control-Allow-Headers, Strict-Transport-Security, Content-Security-Policy, x-requested-with, Content-Type, X-Experience-API-Version, Authorization, Cache-Control, Pragma, Expires"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();     
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }

}
