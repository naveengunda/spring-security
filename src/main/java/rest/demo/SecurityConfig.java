package rest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfig {

	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				requests -> requests.requestMatchers("/", "/login").permitAll().anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").usernameParameter("username").passwordParameter("password")
						.permitAll());

		return http.build();
	}
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailServiceImpl);
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }
	 
	 public BCryptPasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
		return builder.authenticationProvider(authenticationProvider()).build();
		
	}

}