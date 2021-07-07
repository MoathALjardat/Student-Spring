package com.example.demo;
import com.example.demo.models.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.lang.reflect.Method;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		Student s = new Student();
		Class c = s.getClass();
		int mods = c.getModifiers();
		System.out.println(mods);
		Method m[] = c.getDeclaredMethods();
		for (int i = 0; i < m.length; i++)
			System.out.println(m[i].toString());

		SpringApplication.run(DemoApplication.class, args);
	}

}
