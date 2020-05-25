package br.edu.univas.si7.lab7.config.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class StudentSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// db authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				// .antMatchers("/api/student/**").authenticated() //qualquer usuário
				// autenticado
				// .antMatchers("/api/students/**").authenticated()

				.antMatchers(HttpMethod.GET, "/api/students").hasRole("STUDENT")
				.antMatchers(HttpMethod.GET, "/api/student/**").hasRole("STUDENT")

				.antMatchers(HttpMethod.POST, "/api/student").hasRole("SECRETARY")

				.antMatchers(HttpMethod.PUT, "/api/student/**").hasAnyRole("SECRETARY", "ADMIN")

				.antMatchers(HttpMethod.DELETE, "/api/student/**").hasRole("ADMIN")

				.and().httpBasic().and().csrf().disable() // look at https://www.baeldung.com/spring-security-csrf
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
