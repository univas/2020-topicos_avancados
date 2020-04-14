package br.edu.univas.si7.lab7.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.edu.univas.si7.lab7.dao.StudentDAO;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.luv2code.springdemo")
//@PropertySource({ "classpath:persistence.properties" })
public class StudentAppConfig {

	// @Autowired
	// private Environment env;
	//
	// private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public StudentDAO studentDAO() {
		return new StudentDAO();
	}

	@Bean
	public EntityManager entityManager() {
		EntityManagerFactory emFactory = null;

		try {
			// Create the Factory
			emFactory = Persistence.createEntityManagerFactory("unit_app");
		} catch (Throwable e) {
			// Make sure you log the exception , as it might be swallowed
			System.err.println("Error creating EntityManagerFactory ." + e);
			throw new ExceptionInInitializerError(e);
		}
		return emFactory.createEntityManager();
	}

	// @Bean
	// public DataSource myDataSource() {
	//
	// // create connection pool
	// ComboPooledDataSource myDataSource = new ComboPooledDataSource();
	//
	// // set the jdbc driver
	// try {
	// myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
	// } catch (PropertyVetoException exc) {
	// throw new RuntimeException(exc);
	// }
	//
	// // log url and user ... just to make sure we are reading the data
	// logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
	//
	// // set database connection props
	// myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
	// myDataSource.setUser(env.getProperty("jdbc.user"));
	// myDataSource.setPassword(env.getProperty("jdbc.password"));
	//
	// // set connection pool props
	// myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
	// myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
	// myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
	// myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
	//
	// return myDataSource;
	// }
	//
	// @Bean
	// public LocalSessionFactoryBean sessionFactory() {
	//
	// // create session factorys
	// LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	// // set the properties
	// sessionFactory.setDataSource(myDataSource());
	// sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
	// sessionFactory.setHibernateProperties(getHibernateProperties());
	// return sessionFactory;
	// }
	//
	// @Bean
	// @Autowired
	// public HibernateTransactionManager transactionManager(SessionFactory
	// sessionFactory) {
	//
	// // setup transaction manager based on session factory
	// HibernateTransactionManager txManager = new HibernateTransactionManager();
	// txManager.setSessionFactory(sessionFactory);
	//
	// return txManager;
	// }
	//
	// private Properties getHibernateProperties() {
	// Properties props = new Properties();
	// // set hibernate properties
	// props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
	// props.setProperty("hibernate.show_sql",
	// env.getProperty("hibernate.show_sql"));
	// return props;
	// }
	//
	// // helper method that read environment property and convert to int
	// private int getIntProperty(String propName) {
	// String propVal = env.getProperty(propName);
	// // convert to int
	// int intPropVal = Integer.parseInt(propVal);
	// return intPropVal;
	// }
	//
}
