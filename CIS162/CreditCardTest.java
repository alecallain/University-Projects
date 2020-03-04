
/**
 * This class is for testing the CreditCard class.
 * 
 * @Alec Allain 
 * @9/23/16
 */
public class CreditCardTest
{
    public static void main(String [] args) {
    CreditCard brenda = new CreditCard("Brenda Stern");
    int errors = 0;

    // multiple purchases
    brenda.purchase(100);
    brenda.purchase(2.35);
    if(brenda.getPurchases() != 102.35){
        System.out.println("    ERROR! with purchase");
        errors++;
    }

    // negative purchase
    brenda.purchase(-10);
    if(brenda.getPurchases() != 102.35){
        System.out.println("    ERROR! with negative purchase");
        errors++;
    }
    
    
    // previous balance
    brenda.getPreviousBalance();
    
    // get fees
    brenda.getFees();
    
    // get interest
    brenda.getInterest();
    
    // get purchases
    brenda.getPurchases();
    
    // get balance transfers
    brenda.getBalanceTransfers();
    
    // get cash advances
    brenda.getCashAdvances();
    
    // get number of purchases
    brenda.getNumPurchases();
    
    // return card holder name
    brenda.getName();
    
    // apply credit
    brenda.purchase(100);
    brenda.applyCredit(50.0);
    if (brenda.getPurchases() != 50.0) {
        System.out.println("    ERROR! with applying credit");
        errors++;
       }
    
    // balance transfers
    brenda.balanceTransfer(500);
    if (brenda.getBalanceTransfers() != 515){
        System.out.println("    ERROR! with balance transfer");
        errors++;
       }
    
    // cash advance
    brenda.cashAdvance(500, 11);
    if (brenda.getCashAdvances() != 500) {
        System.out.println("    ERROR! with cash advance");
        errors++;
    }
    
    // calculate minimum payment
    int newBalance = 2100;
    //brenda.calcMinimumPayment();
    //if (brenda.calcMinimumPayment() != 31.5) {
        System.out.println("    ERROR! with calculating minimum payment");
        errors++;
    //}
    
    // reset amounts
    //brenda.resetAmounts();
    //if (brenda.resetAmounts() != 0) {
        System.out.println("    ERROR! with reseting amounts");
        errors++;
    //}
    
    // print month statement
    //brenda.printStatement();
    
    // make payment
    brenda.makePayment(1000, 13);
    //if (brenda.makePayment() != 1000) {
        System.out.println("    ERROR! with making payment");
        errors++;
    //}
    
    // close billing period
    brenda.closeBillingPeriod();
    
    
    System.out.println(errors + " errors detected");

}
}
