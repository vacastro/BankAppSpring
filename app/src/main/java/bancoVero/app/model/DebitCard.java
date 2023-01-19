package bancoVero.app.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table (name="tarjetas_debito")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class DebitCard {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO )
	@Column (name="id_tarjeta_debito")
	private int  id;
	
	@OneToOne(mappedBy = "debit", cascade = CascadeType.ALL)
	private BankAccount bankAccount;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, updatable = false)
	private User user;
	
	@Column(name="num_tarjeta_debito")
	private String cardNumber;
	
	@Column (name="codigo_seguridad")
	private int securityCode;
	
	@Column (name="fecha_expiracion")
	private String expirationDate;
	
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	public DebitCard() {
		super();
	}
	public DebitCard(int id, BankAccount bankAccount, User user, String cardNumber, int securityCode,
			String expirationDate) {
		super();
		this.id = id;
		this.bankAccount = bankAccount;
		this.user = user;
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.expirationDate = expirationDate;
	}
	
	
	
	

}
