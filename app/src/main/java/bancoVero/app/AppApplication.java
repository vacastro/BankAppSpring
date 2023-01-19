package bancoVero.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import bancoVero.app.repository.UserRepository;
import bancoVero.app.service.MenuService;

@SpringBootApplication
public class AppApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppApplication.class, args);
		
		MenuService menuService = new MenuService(context);
		menuService.menuPrincipal();
		
	}

}
