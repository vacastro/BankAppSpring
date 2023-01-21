package bancoVero.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bancoVero.app.model.User;
import bancoVero.app.repository.UserRepository;

@SpringBootTest
class AppApplicationTests {
	
	@Autowired
	UserRepository userRepository;
	
	

	@Test
	void pruebaInsert() {
		User user = new User();
		user.setName("verito");
		userRepository.save(user);
		userRepository.findAll();
		
		
	}

}
