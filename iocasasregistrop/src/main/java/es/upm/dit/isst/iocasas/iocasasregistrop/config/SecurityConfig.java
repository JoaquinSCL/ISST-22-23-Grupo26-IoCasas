        package es.upm.dit.isst.iocasas.iocasasregistrop.config;

        import javax.sql.DataSource;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.core.userdetails.User;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.provisioning.InMemoryUserDetailsManager;
        import org.springframework.security.provisioning.JdbcUserDetailsManager;
        import org.springframework.security.web.SecurityFilterChain;
        import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



        @Configuration
        @EnableWebSecurity
        public class SecurityConfig {
            @Bean
            public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests()
                    .requestMatchers("/css/**", "/img/**", "/layouts/**", "/").permitAll()
                    .requestMatchers("/lista").hasRole("PROP")
                    .anyRequest().authenticated().and()
                    .formLogin().permitAll().and()
                    .logout().permitAll().and()
                    .httpBasic();
                return http.build();
            }
        
    
            @Bean
            public UserDetailsService jdbcUserDetailsService(DataSource dataSource){
                String usersByUsernameQuery = "select username, password, enabled from users where username =?";
                String authsByUserQuery = "select username, authority from authorities where username = ?";
                JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
                users.setUsersByUsernameQuery(usersByUsernameQuery);
                users.setAuthoritiesByUsernameQuery(authsByUserQuery);
                return users;
            }    
        }
