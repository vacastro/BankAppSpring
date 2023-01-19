package bancoVero.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bancoVero.app.model.User;
import bancoVero.app.repository.UserRepository;
import bancoVero.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/BANK-APP/getUser/{id}")
	public User getUser(@PathVariable("id")String id) throws Exception{
		return userService.getUser(id);
		
	}
	
	
	@PostMapping (value = "/BANK-APP/registro")
	public void nuevoUsuario (@RequestBody User user) throws Exception{
		userService.guardarUser(user);
	}

	
}
