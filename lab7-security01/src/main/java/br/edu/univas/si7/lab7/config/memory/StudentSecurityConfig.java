package br.edu.univas.si7.lab7.config.memory;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

//@Configuration
//@EnableWebSecurity
public class StudentSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder(); // insecure for production but ok for tests

		auth.inMemoryAuthentication()
			.withUser("joao").password("{noop}aluno123").roles("STUDENT")
			.and()
			.withUser("jonas").password("{noop}secretaria123").roles("SECRETARIA")
			.and()
			.withUser("julia").password("{noop}admin123").roles("ADMIN", "STUDENT");
		//{noop} -> the encoding algorithm id
		//noop - plain text passwords
		//bcript - Bcript password hashing
		//...
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()

//			.antMatchers("/api/student/**").authenticated() //qualquer usuário autenticado
//			.antMatchers("/api/students/**").authenticated()

			.antMatchers(HttpMethod.GET, "/api/students").hasRole("STUDENT")
			.antMatchers(HttpMethod.GET, "/api/student/**").hasRole("STUDENT")

			.antMatchers(HttpMethod.POST, "/api/student").hasRole("SECRETARIA")

			.antMatchers(HttpMethod.PUT, "/api/student/**").hasAnyRole("SECRETARIA", "ADMIN")

			.antMatchers(HttpMethod.DELETE, "/api/student/**").hasRole("ADMIN")

			.and()
			.httpBasic() //tipo de autenticação
			.and()
			.csrf().disable() //look at https://www.baeldung.com/spring-security-csrf
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
