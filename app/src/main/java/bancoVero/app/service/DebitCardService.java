package bancoVero.app.service;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import bancoVero.app.exception.ExceptValidationDebitCard;
import bancoVero.app.exception.ExceptValidationUser;
import bancoVero.app.model.DebitCard;
import bancoVero.app.model.User;

@Service
public class DebitCardService {
//	 Scanner sc = new Scanner(System.in);
//	    public DebitCard createDebitCard(List<User> customers) {
//	        DebitCard debitCard = new DebitCard();
//
//	        String cardnumber = String.valueOf((long)(Math.random() *1000000000+1));
//	        System.out.println(cardnumber);
//
//	        System.out.println("Enter the segurity code of the debit card");
//	        String securityCode = sc.nextLine();
//	        if (securityCode.equals("")) {
//	            throw new ExceptValidationDebitCard("Security code canÂ´t be empty");
//	        } else if (securityCode.length() != 4) {
//	            throw new ExceptValidationDebitCard("Security code must be 4");
//	        } else {
//	            debitCard.setSecurityCode(Integer.parseInt(securityCode));
//	        }
//	        System.out.println("Enter the expiration date of the debit card:  ");
//	        System.out.println("Year: ");
//
//	        String expirationDate="";
//	        boolean monthControl ;
//	        do{
//	            try{
//	                monthControl=false;
//	                System.out.println("You must enter 2 digit for month. Month: ");
//	                int month = sc.nextInt();
//	                if(month <13){
//	                    System.out.println("--------------------------------");
//	                }else {
//	                    throw new ExceptValidationUser("Invalid");
//	                }
//	            }catch(Exception e){
//	                e.printStackTrace();//para imprimir por consola
//	                monthControl=true;
//	            }
//	        }while(monthControl);
//
//	        boolean yearControl;
//	        do{
//	            try{
//	                yearControl=false;
//	                System.out.println("Year: ");
//	                int year=sc.nextInt();
//	               if (year>= Year.now().getValue()){
//	                   System.out.println("--");
//	               }else{
//	                   throw new ExceptValidationUser("Invalid year");
//	               }
//	            }catch (Exception e){
//	                e.printStackTrace();
//	                yearControl=true;
//	            }
//	        }while(yearControl);
//
//
//	        debitCard.setExpirationDate(expirationDate);
//
//
//	        return debitCard;
//	    };
//

}
