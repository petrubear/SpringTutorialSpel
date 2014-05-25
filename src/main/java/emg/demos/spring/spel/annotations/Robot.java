package emg.demos.spring.spel.annotations;

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
	public void setSpeech(@Value("#{randomText.getText()}")String speech) {
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
