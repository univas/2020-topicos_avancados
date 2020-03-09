package br.edu.univas.si7.lab7.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import br.edu.univas.si7.lab7.model.GraduationStudentBean;
import br.edu.univas.si7.lab7.model.HintService;
import br.edu.univas.si7.lab7.model.PostGradStudentBean;
import br.edu.univas.si7.lab7.model.SimpleHintService;
import br.edu.univas.si7.lab7.model.TechnicianStudentBean;

@Configuration //substitui a configuração dos beans no XML
@PropertySource("classpath:school.properties")
public class StudentConfiguration {

	@Bean //anotação que define um novo bean - anota um método
	//o nome do método é o beanId
	public GraduationStudentBean graduationStudentBean() {
		return new GraduationStudentBean();
	}
	
	@Bean
	//o spring controla a chamada destes métodos
	public SimpleHintService simpleHintBean() {
		return new SimpleHintService();
	}
	
	@Bean
	public TechnicianStudentBean techStudentBean() {
		HintService theHintService = simpleHintBean();
		TechnicianStudentBean obj = new TechnicianStudentBean(theHintService);
		return obj;
	}
	
	@Bean
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PostGradStudentBean postStudentBean() {
		return new PostGradStudentBean(simpleHintBean());
	}
}
