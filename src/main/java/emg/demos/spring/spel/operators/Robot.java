package emg.demos.spring.spel.operators;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

	private String id = "Default Robot";
	private String speech = "hello";

	public void speak() {
		System.out.println(id + ":" + speech);
	}

	// igual que en xml spel va entre #{}
	@Autowired
	public void setId(@Value("#{randomText.getText()?.length()}")String id) {
		this.id = id;
	}

	@Autowired
	// ejemplos spel:
	//@Value("#{new java.util.Date().toString()}")
	//@Value("#{T(Math).sin(5)}")
	//@Value("#{T(Math).sin(T(Math).PI/4) ^ 2}")
	//@Value("#{T(Math).sin(T(Math).PI/4) ^ 2 lt 0.8}") donde lt = less than
	//@Value("#{T(Math).sin(T(Math).PI/4) ^ 2 le 0.8 ? 'yes' : 'no'}") 
	public void setSpeech(@Value("#{T(Math).sin(T(Math).PI/4) ^ 2 le 0.8 ? 'yes' : 'no'}")String speech) {
		this.speech = speech;
	}

	@PostConstruct
	public void init () {
		System.out.println("init robot");
	}
	
	@PreDestroy
	public void destroy () {
		System.out.println("destroy robot");
	}
}
