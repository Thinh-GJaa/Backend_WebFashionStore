package api.webfashionstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfig(JwtFilter jwtFilter, CustomAccessDeniedHandler accessDeniedHandler,
                          CustomAuthenticationEntryPoint authenticationEntryPoint) {
        this.jwtFilter = jwtFilter;
        this.accessDeniedHandler = accessDeniedHandler;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configure(http)) // 🔹 Cho phép CORS nếu cần
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/login").permitAll() // 🔹 Cho phép truy cập API login
                        .requestMatchers("/test-api/**").permitAll() // 🔹 Cho phép truy cập test API
                        .requestMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN") // 🔹 Dùng hasAuthority thay vì hasRole
                        .requestMatchers("/api/staff/**").hasAuthority("ROLE_STAFF")
                        .anyRequest().authenticated()
                )
                .exceptionHandling(config -> config
                        .accessDeniedHandler(accessDeniedHandler) // Xử lý lỗi 403
                        .authenticationEntryPoint(authenticationEntryPoint) // Xử lý lỗi 401
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
