package bancoVero.app.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component 
@Entity
@Table(name="cuentas")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="cbu")
	private int cbu;
	
	@Column(name="balance")
	private double balance;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, updatable = false)
    private User user;
	
//	@OneToOne
//	@JoinColumn(name = "id_tarjeta_debito", updatable = false, nullable = false)
//	private DebitCard debit;
    
    
    public BankAccount(User user) {
        this.user = user;
        this.balance = 0.0;
    }

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCbu() {
		return cbu;
	}

	public void setCbu(int cbu) {
		this.cbu = cbu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public DebitCard getDebit() {
//		return debit;
//	}
//
//	public void setDebit(DebitCard debit) {
//		this.debit = debit;
//	}

//	public static int getCbuNumber() {
//		return cbuNumber;
//	}
//
//	public static void setCbuNumber(int cbuNumber) {
//		BankAccount.cbuNumber = cbuNumber;
//	}

	public BankAccount() {
		super();
	}

//	public BankAccount(int id, double balance, int cbu, User user, DebitCard debit) {
//		super();
//		this.id = id;
//		this.balance = balance;
//		this.cbu = cbu;
//		this.user = user;
////		this.debit = debit;
//	}
//    
    

}
