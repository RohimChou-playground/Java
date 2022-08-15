import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import service.StudentService;

public class Application {

	public static void main(String[] args) {
//		StudentService studentService = new StudentService();
//		System.out.println(studentService.list());
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentService service = appContext.getBean("studentService", StudentService.class);
		System.out.println(service.list());
	}

}
