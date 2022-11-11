import java.text.DecimalFormat;
import java.util.Scanner;//import java class Scanner from library

public class Application {
	
	//Declare prices
	static double priceCoke = 1.50;
	static double pricePepsi = 1.60;
	static double priceFanta = 1.40;
	static double priceSprite = 1.40;
	
	//Declare stocks
	static int qtyCoke = 40;
	static int qtyPepsi = 30;
	static int qtyFanta = 3;
	static int qtySprite = 4;
	
	//Declare variables
	static String chosenProduct;
	static int totalTakings = 0;
	static int totalTransactions = 0;
	static DecimalFormat currency = new DecimalFormat("€0.00");
	
	//Declare scanner object
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		chooseProduct();
	}
	
	public static void chooseProduct() {
		System.out.println("Welcome to Coca-Cola vending machine");
		System.out.println("1) Coke\t\t2) Pepsi");
		System.out.println("3) Fanta\t4) Sprite");
		
		String choice = input.next();
		
		switch (choice) {
			case "1":
				if (qtyCoke == 0) {
					System.out.println("Out of stock. Please try another product.");
				}
				else {
					payment("Coke", priceCoke);
				}
				break;
			case "2":
				if (qtyCoke == 0) {
					System.out.println("Out of stock. Please try another Product");
				}
				else {
					payment("Pepsi", pricePepsi);
				}
				break;
			case "3":
				if (qtyFanta == 0) {
					System.out.println("Out of stock. Please try another Product");
				}
				
				else {
					payment("Fanta", priceFanta);
				}
				break;
			case "4":
				if (qtySprite == 0) {
					System.out.println("Out of stock. Please try another Product");
				}
				else {
					payment("Sprite", priceSprite);
				}
				break;
			case "k":
				admin();
			default:
				System.out.println("You did not choose a valid option");
				chooseProduct();
				break;
		}
	}
	
	public static void payment(String product, double transactionPrice) {
		String chosenProduct = product;
		System.out.println("You are purchasing " + chosenProduct);
		System.out.println("Price: " + currency.format(transactionPrice));
		
		System.out.println("Please pay now:");
		double insertedAmount = input.nextDouble();
		while (insertedAmount != transactionPrice) {
			System.out.println("Balance left: " + currency.format(transactionPrice - insertedAmount));
			insertedAmount = insertedAmount + input.nextDouble();
		}
		
		System.out.println("You have paid " + currency.format(insertedAmount));
		System.out.println("Dispensing " + chosenProduct);
		
		if (chosenProduct.equals("Coke")){
			qtyCoke--;
		}
		
		else if (chosenProduct.equals("Pepsi")){
			qtyPepsi--;
		}
		
		else if (chosenProduct.equals("Fanta")) {
			qtyFanta--;
		}
		
		else if (chosenProduct.equals("Sprite")) {
			qtySprite--;
		}
		
		totalTakings++;
		totalTransactions++;
	}
	
	public static void admin() {
		System.out.println("Welcome to Admin Screen");
		System.out.println("");
	}
}
