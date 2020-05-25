package br.edu.univas.si7.lab7.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.edu.univas.si7.lab7.dao.StudentMemoryDAO;

@Configuration
@EnableWebMvc
@ComponentScan(value = "br.edu.univas.si7.lab7")
@PropertySource("classpath:persistence-postgresql.properties")
public class StudentConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public StudentMemoryDAO studentDAO() { // default beanId: studentDAO (nome do método)
		return new StudentMemoryDAO();
	}

	@Bean
	public DataSource securityDataSource() {

		// create connection pool
		ComboPooledDataSource ds = new ComboPooledDataSource();

		try {
			ds.setDriverClass(env.getProperty("jdbc.driver")); // set the jdbc driver class
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		// set database connection props
		ds.setJdbcUrl(env.getProperty("jdbc.url"));
		ds.setUser(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));

		// set connection pool props
		ds.setInitialPoolSize(getInt("connection.pool.initialPoolSize"));
		ds.setMinPoolSize(getInt("connection.pool.minPoolSize"));
		ds.setMaxPoolSize(getInt("connection.pool.maxPoolSize"));
		ds.setMaxIdleTime(getInt("connection.pool.maxIdleTime"));

		return ds;
	}

	// helper method that read environment property and convert to int
	private int getInt(String propName) {

		String propVal = env.getProperty(propName);
		return Integer.parseInt(propVal); //convert to int
	}
}
