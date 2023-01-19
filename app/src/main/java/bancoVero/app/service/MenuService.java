package bancoVero.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import bancoVero.app.exception.ExceptApp;
import bancoVero.app.model.BankAccount;
import bancoVero.app.model.User;
import bancoVero.app.repository.UserRepository;


public class MenuService {
	
	ApplicationContext context;
	
	@Autowired
	BankAccount bankAccount;
	
	UserService userService = new UserService();
	
	BankAccountService bankAccountService = new BankAccountService();
	
	DebitCardService debitCardService = new DebitCardService();
	
	UserRepository userRepository;

	@Autowired
	User user;

	public MenuService(ApplicationContext context) {
		super();
		this.context = context;
		userRepository = context.getBean(UserRepository.class);
	}

	//	List<User> customers = inicialiarDatos();
	Scanner sc = new Scanner(System.in);
//    List<String> dataUsuarios = userService.showUser(customers);

	public void menuPrincipal() {
        boolean band;
//        List<String> dataUsuarios = userService.showUser(customers);
//        System.out.println(dataUsuarios);
        do {
            try {
                band = false;
                int i;
                System.out.println("Elija una opcion");
                System.out.println("---------------------------------------------------------------");
                System.out.println("1. Crear usuario");
                System.out.println("");
                System.out.println("2. Login");
                System.out.println("");
                System.out.println("3. Imprimir todos los usuarios y cuentas");
                System.out.println("");
                System.out.println("4. Salir");
                i = sc.nextInt();

                switch (i) {
                    case 1:
                            System.out.println(" Complete el formulario de registro : ");
                            user = userService.createUser();
                            userRepository.save(user);
//                            customers.add(user);
                            user.getAccounts().add(new BankAccount(user));
                            System.out.println("Su numero de cuenta es : " + user.getAccounts().get(0).getCbu());
                            System.out.println("El balance de su cuenta es : " + user.getAccounts().get(0).getBalance());
                            do {
                                menuBankAccount(user);
                            }

                            while (menuBankAccount(user) < 7);

                       
                        break;

                    case 2:
                        System.out.println("Bienvenido a la app, complete su usuario y clave");
//                        user = bankAccountService.loginBankAccount(customers);
                        do {
                            menuBankAccount(user);
                        }
                        while (menuBankAccount(user) < 7);
                        break;
                    case 3:
                        System.out.println("Data");
//                        System.out.println(dataUsuarios);
                        break;
                    case 4:
                        System.out.println("Gracias por usar nuestra app");
                        System.out.println(user.getName());
                        break;

                    default:
                        throw new ExceptApp("Opcion no valida. Ingrese nuevamente :");
                }

            } catch (Exception e) {
                e.printStackTrace();
                band = true;
            }

        } while (band);

	}


	public int menuBankAccount(User user) { // debit card atraves de bankAccount, mismo de usuario
		
		BankAccount bankAccount = new BankAccount();
        int numValitor = 0;
        System.out.println("Elija la opcion ");
        System.out.println("--------------------------------");
        System.out.println("1. Conocer su balance : ");
        System.out.println("2. Depositar");
        System.out.println("3. Transferir");
        System.out.println("4. Extraer");
        System.out.println("5. Crear tarjeta de debito");
        System.out.println("6. Volver al menu principal");

        numValitor = sc.nextInt();

        switch (numValitor) {
            case 1:
                System.out.println("Status of the balance");
                try{
                    if(user.getAccounts()==null){
                        throw new ExceptApp("Ustede no posee cuentas");
                    }else{
                        for( BankAccount account : user.getAccounts()){
                            System.out.println(account.getCbu()+"-- "+ account.getBalance());
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                bankAccountService.actualBalance(user.getAccounts().get(0));

                break;

            case 2:
                System.out.println("Depositar ");
               // System.out.println("Cuanto quiere depositar");
               // int dep1= sc.nextInt();
                bankAccountService.deposit(user.getAccounts().get(0));


                break;

             /*   System.out.println("cuenta propia o cuenta de terceros");
                int num= sc.nextInt();
                switch (num) {
                    case 1:
                    break;
                    case 2:
                }
                break;*/
            case 3:
                System.out.println("Transferencia");
//                bankAccountService.transfer(user.getAccounts().get(0), customers);
                for( BankAccount account : user.getAccounts()){
                    System.out.println(account.getCbu()+"-- "+ account.getBalance());
                }
                break;
            case 4:
                System.out.println("Extraccion");
                bankAccountService.extraction(user.getAccounts().get(0));

                break;
            case 5:
                System.out.println("Crear tarjeta de debito");
//                bankAccount.setDebit(debitCardService.createDebitCard(customers));
                break;
            case 6:
                System.out.println("Volver al menu anterior");
                menuPrincipal();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        return numValitor;

	}

	public List<User> inicialiarDatos() {
		
		List <User> customers = new ArrayList<User>();

		User user1 = new User("Veronica", "Castro", "verito@gmail.com", 89765456, 30, "verito", "1234");
		User user2 = new User("Pepita", "OÃ±a", "chaquichaqui@gmail.com", 93872908, 20, "deoro", "3456");
		User user3 = new User("Luquitas", "Castro ", "luquiluqui@gmail.com", 23456123, 21, "lady", "5696");
		User user4 = new User("Makki", "Tranqui", "makkitranui@gmail.com", 87654312, 18, "makki10", "5236");
//		User user5 = new User("Yukki", "Revoltoso", "yukkirevoltoso@gmail.com", 19876789, 22, "yukki10", "3256");
//		User user6 = new User("Eiko", "Arcentales", "eikoarcentales@gmail.com", 12345678, 24, "eiko99", "5844");
//		User user7 = new User("Kalel", "Vega", "kalelvega@gmail.com", 89765456, 30, "kalel01", "2364");
//
//		User user8 = new User("Jeronimo", "Robbins", "jrobins@gmail.com", 98987612, 31, "Rojan", "1234");
//		User user9 = new User("Cleotilde", "Delramos", "cleocleo@gmail.com", 12345678, 40, "Roca", "3456");
//		User user10 = new User("Zeus", "OÃ±a", "zeusona@gmail.com", 12121234, 20, "deOro", "1314");
		
		customers.add(user1);
		customers.add(user2);
		customers.add(user3);
		customers.add(user4);
		
		user1.getAccounts().add(new BankAccount(user1));
		user2.getAccounts().add(new BankAccount(user2));
		user3.getAccounts().add(new BankAccount(user3));
		user4.getAccounts().add(new BankAccount(user4));
		userService.guardarUser(user1);
		


		return customers;
	};


}
