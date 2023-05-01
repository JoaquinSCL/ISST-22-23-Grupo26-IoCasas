        package es.upm.dit.isst.lab5.config;

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
                    .requestMatchers("/css/**", "/img/**", "/layouts/**", "/", "/index").permitAll()
                    .requestMatchers("/lista").hasRole("PROP")
                    .anyRequest().authenticated().and()
                    .formLogin().loginPage("/login").permitAll().and()
                    .logout().permitAll().and()
                    .httpBasic();
                return http.build();
            }
        
        /*     @Bean
            public UserDetailsService userDetailsService(){
                UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin1")
                .roles("ADMIN")
                .build();
                UserDetails profesor = User.withDefaultPasswordEncoder()
                .username("profesor")
                .password("profesor1")
                .roles("PROF")
                .build();
                UserDetails alumno = User.withDefaultPasswordEncoder()
                .username("alum")
                .password("alum1")
                .roles("ALUM")
                .build();
                return new InMemoryUserDetailsManager(admin, profesor, alumno); 
            } */
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
