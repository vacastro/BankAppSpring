package bancoVero.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bancoVero.app.exception.ExceptValidationUser;
import bancoVero.app.model.BankAccount;
import bancoVero.app.model.User;
import bancoVero.app.repository.UserRepository;

@Service
public class UserService {
	
	User user = new User ();
	
	Scanner sc = new Scanner(System.in);
	
	
	@Autowired
	UserRepository userRepository;

	public User createUser() {
		
		boolean nameControl;
		do {
			try {
				nameControl = false;
				System.out.println("Ingrese nombre ");
				String name = sc.nextLine();
				if (name.trim().equals("")) {
					throw new ExceptValidationUser("Name can not be empty, try again");
				} else if (verifyString(name)) {
					throw new ExceptValidationUser("no puede ingresar caracteres numericos");
				} else {
					user.setName(name);
				}
			} catch (Exception e) {
				e.printStackTrace();
				nameControl = true;
			}
		} while (nameControl);

		boolean lastNameControl;
		do {
			try {
				lastNameControl = false;
				System.out.println("Ingrese apellido");
				String lastName = sc.nextLine();
				if (lastName.trim().equals("")) {
					throw new ExceptValidationUser("LastName can not be empty");

				} else if (verifyString(lastName)) {
					throw new ExceptValidationUser("no puede ingresar caracteres numericos");
				} else {
					user.setLastName(lastName);
				}
			} catch (Exception e) {
				e.printStackTrace();
				lastNameControl = true;
			}

		} while (lastNameControl);

		boolean emailControl;
		do {
			try {
				emailControl = false;
				System.out.println("Ingrese email");
				String email = sc.nextLine();
				if (email.trim().equals("")) {
					throw new ExceptValidationUser("Email canÂ´t be empty");
				} else if (!email.contains("@") || !email.contains(".com")) {
					throw new ExceptValidationUser("el email debe contener @ y .com");
				} else {
					user.setEmail(email);
				}
			} catch (Exception e) {
				e.printStackTrace();
				emailControl = true;
			}
		} while (emailControl);

		boolean dniControl;
		do {
			try {
				dniControl = false;
				System.out.println("Ingrese su dni");
				String dni = sc.nextLine();
				if (dni.trim().equals("")) {
					throw new ExceptValidationUser("Dni canÂ´t be empty");
				} else if (dni.length() != 8) {
					throw new ExceptValidationUser("El dni deben ser 8 caracteres");
				} else {
					user.setDni(Integer.parseInt(dni));
				}
			} catch (Exception e) {
				dniControl = true;
				e.printStackTrace();
			}
		} while (dniControl);

		boolean ageControl;
		do {
			try {
				ageControl = false;
				System.out.println("Ingrese edad");
				String age = sc.nextLine();
				if (age.trim().equals("")) {
					throw new ExceptValidationUser("Age canÂ´t be empty");
				} else if (Integer.parseInt(age) < 18) {
					throw new ExceptValidationUser("Debe ser mayor a 18 para ser usuario de la app");
				} else {
					user.setAge(Integer.parseInt(age));
				}
			} catch (Exception e) {
				ageControl = true;
				e.printStackTrace();
			}
		} while (ageControl);
		boolean usernameControl;
		do {
			try {
				usernameControl = false;
				System.out.println("Ingrese username");
				String username = sc.nextLine();
				if (username.trim().equals("")) {
					throw new ExceptValidationUser("Username canÂ´t be empty");
//				} else if (verifyUsername(customers, username)) {
//					throw new ExceptValidationUser("The username is already exist, try again");
				} else {
					user.setUsername(username);
				}
			} catch (Exception e) {
				usernameControl = true;
				e.printStackTrace();
			}
		} while (usernameControl);

		boolean passwordControl;
		do {
			try {
				passwordControl = false;
				System.out.println("Ingrese password");
				System.out.println("La password deben ser 4 caracteres numericos");
				String password = sc.nextLine();

				if (password.trim().equals("")) {
					throw new ExceptValidationUser("Password canÂ´t be empty");
				} else {
					user.setPassword(password);
				}
			} catch (Exception e) {
				passwordControl = true;
				e.printStackTrace();
			}
		} while (passwordControl);
		
	//	customers.add(user);
	//	showUser(customers);
//		userRepository.save(user);
		return user;

	}

	public boolean verifyUser(List<User> customers) {
		boolean verificador;
		if (customers.size() < 10) {
			verificador = false;
		} else {
			verificador = true;
		}
		return verificador;
	}

	public List <String> showUser(List<User> customers) {
		List<String> dataUsuarios = new ArrayList<String>();
		for (User user : customers) {
			dataUsuarios.add("Name: " + user.getName() );
			dataUsuarios.add("Last Name: " + user.getLastName());
			dataUsuarios.add("Email: " + user.getEmail());
			dataUsuarios.add("Dni:  " + user.getDni());
			dataUsuarios.add("Age: " + user.getAge() );
//			for (BankAccount cuenta : user.getAccounts()) {
//				dataUsuarios.add("CBU: " +cuenta.getCbu());
//				dataUsuarios.add("Saldo:" +cuenta.getBalance());
//			}
//			
			dataUsuarios.add("\n");
		}
		
		return dataUsuarios;
	}

	public boolean verifyString(String n) {
		boolean validatorString = false;
		for (int i = 0; i < n.length(); i++) {
			if (Character.isDigit(n.charAt(i))) {
				validatorString = true;
			}
		}
		return validatorString;

	}

	public boolean verifyUsername(List<User> customers, String username) {
		boolean validator = false;
		for (User aux : customers) {
			if (aux.getUsername().equals(username)) { // para no repetir datos user
				validator = true;
			}
		}
		return validator;
	}
   /*

    public void passwordValidation(ArrayList<User> customers, BankAccount bankAccount) {
        boolean passwordControl = true;

        System.out.println("Enter the password :");
        do {
            try {
                String password = sc.nextLine();
                for (User auxpassword : customers) {
                    if (auxpassword.getAccount().equals(password)) {
                        throw new ExcepValidationBankAccount("unavailable password ");
                    }
                }
                if (password.equals("")) {
                    throw new ExcepValidationBankAccount("Password canÂ´t be empty");
                } else if (password.length() != 4) {
                    throw new ExcepValidationBankAccount("Password  must be 4 digit ");
                }
                else {
                    user.setPassword(String.valueOf(Integer.parseInt(password)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (passwordControl);

    }*/
	
	public User getUser (String id) {
		Optional <User> datosUser = userRepository.getUserById(id);
		if (datosUser.isPresent()) {
			user = datosUser.get();
		}
		return user;
	}
	
	public void guardarUser (User user) {
		userRepository.save(user);
	}


}
