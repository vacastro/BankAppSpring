package bancoVero.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuarios")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column (name="id_usuario")
	private int id;
	
	@Column (name="nombre")
	private String name;

	@Column (name="apellido")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dni")
	private Integer dni;
	
	@Column(name="edad")
	private int age;
	
	@Column (name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	   // private BankAccount account;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
	private List<BankAccount> accounts = new ArrayList<BankAccount>();
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")	
//	private List<DebitCard> cards = new ArrayList<DebitCard>();
	
	
	public User(String name, String lastName, String email, Integer dni, int age, String username, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.dni = dni;
		this.age = age;
		this.username = username;
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getDni() {
		return dni;
	}


	public void setDni(Integer dni) {
		this.dni = dni;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<BankAccount> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}


	public User() {
		super();
	}


	public User(int id, String name, String lastName, String email, Integer dni, int age, String username,
			String password, List<BankAccount> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.dni = dni;
		this.age = age;
		this.username = username;
		this.password = password;
		this.accounts = accounts;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", dni=" + dni
//				+ ", age=" + age + ", username=" + username + ", password=" + password + ", accounts=" + accounts
//				+ ", cards=" + cards + "]";
//	}
//	
	


}
