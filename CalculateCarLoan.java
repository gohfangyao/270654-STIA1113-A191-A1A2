import java.text.NumberFormat;
import java.util.Scanner;

public class CalculateCarLoan {
	static double getDouble() 
	{
		
		double carPrice = 0;
		
		Scanner scanner= new Scanner(System.in);
	     carPrice = scanner.nextDouble();
		 System.out.println("car price is"+ carPrice);
		 
		return carPrice;
	}
	
	static double getDouble(String strName) 
	{
	
		double carPrice = 0;
		
		System.out.println("Please enter"+ strName);
		Scanner scanner= new Scanner(System.in);
		carPrice = scanner.nextDouble();
	    System.out.println("The"+strName+ "is"+ "RM"+ carPrice);
		 
		return carPrice;
	}
	
	static int getInt(String strName) 
	{
	
		int carPrice = 0;
		
		System.out.println("Please enter"+ strName);
		Scanner scanner= new Scanner(System.in);
		carPrice = scanner.nextInt();
	    System.out.println("The"+strName+ "is"+ carPrice);
		 
		return carPrice;
	}
	
	
	
	static double readCarPrice()
	{
		double carPrice = getDouble("car price");
		if(carPrice<0) {
			System.out.println("car price cannot be negative. Your car price is"+ carPrice);
		}
		return carPrice;
	   
	}
	
	static double readdownPayment() 
	 {
		 double downPayment = getDouble("down payment");
		 if(downPayment ==0 && downPayment >=0) {
		System.out.println("down payment can be zero but cannot be negative. Your down payment is" + downPayment);
		
		 }
		 
		return downPayment;
	 }
	    
	 static int readloanPeriod()
		{
			int loanPeriod = getInt("loan period"+ "(years)");
			if(loanPeriod<0) {
				System.out.println("loanPeriod cannot be negative. Your loanPeriod is" + loanPeriod);
			}else if (loanPeriod >=5 && loanPeriod <=9) {
			    System.out.println("loanPeriod cannot less than 5 years and cannot more than 9 years. Your loanPeriod is" + loanPeriod +"years");
		}
			return loanPeriod;
		}

	static double readInterestRate()
      {
	double interestRate = getInt("interest rate"+"(%)");
	if(interestRate<0) {
		System.out.println("interest rate cannot be negative. Your interest rate is" + interestRate);
	}else if (interestRate >=3 && interestRate <=7) {
	    System.out.println("interest rate cannot less than 3% and cannot more than 7%. Your interest rate is" + interestRate+"%");
	}
	return interestRate;
   }
	
    static void displayCalculation() {
    double monthlyPayment=0; 
    double carPrice = readCarPrice();
    double downPayment = readdownPayment();
    int loanPeriod = readloanPeriod();
    double InterestRate = readInterestRate();
    double currentPaid=0;
	double currentInterest=0;
	double currentBalance=0;
	double yearlyInterest=0;
    
    System.out.print("Enter loan amount:");
    
    
    monthlyPayment= ((carPrice-downPayment)/loanPeriod/12)+((carPrice-downPayment)*InterestRate/100/12);
	System.out.println("monthly payment is"+ monthlyPayment);
	
	
    double yearlyPayment= monthlyPayment*12;
	
	double totalInterest = InterestRate/100*(carPrice-downPayment)*loanPeriod; 
    yearlyInterest = totalInterest/6;
    currentBalance = carPrice-downPayment+totalInterest;
	
		int currentYear=0;
		
		System.out.format("%20s %20s %20s %20s %n","Years","Principal","Interest","Balance");
	for (currentYear =1; currentYear<= loanPeriod ; currentYear++) { 
		currentPaid= currentPaid+12* monthlyPayment;
		currentInterest = currentInterest+yearlyInterest;
		currentBalance = currentBalance- yearlyPayment;
		 
		System.out.format("%20d %20.2f %,20.2f %,20.2f %n",currentYear,currentPaid, currentInterest,currentBalance);
		
	}
	
	}
    
	
	static void testScanner() {}
	
 public static void main(String[]args) {
	 displayCalculation();
	 
	
}
	 	

}  
	   



