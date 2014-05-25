package emg.demos.spring.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import emg.demos.spring.spel.xml.Robot;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("emg/demos/spring/spel/xml/beans/beans.xml");
		
		System.out.println("*********************");
		System.out.println("SPEL Demo");
		System.out.println("*********************");
		
		Robot robot = (Robot)context.getBean("robot");
		robot.speak();
		
		((ClassPathXmlApplicationContext) context).close();
		
		context = 
				new ClassPathXmlApplicationContext("emg/demos/spring/spel/annotations/beans/beans.xml");
		
		System.out.println("*********************");
		System.out.println("SPEL Demo Annotations");
		System.out.println("*********************");
		
		emg.demos.spring.spel.annotations.Robot robotAnnotations = (
				emg.demos.spring.spel.annotations.Robot)context.getBean("robot");
		robotAnnotations.speak();
		
		((ClassPathXmlApplicationContext) context).close();
		
		
		context = 
				new ClassPathXmlApplicationContext("emg/demos/spring/spel/operators/beans/beans.xml");
		
		System.out.println("*********************");
		System.out.println("SPEL Demo Operators");
		System.out.println("*********************");
		
		emg.demos.spring.spel.operators.Robot robotOperatos = (
				emg.demos.spring.spel.operators.Robot)context.getBean("robot");
		robotOperatos.speak();
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
