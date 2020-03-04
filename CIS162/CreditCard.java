import java.text.NumberFormat;
/*************************************************
 * This project simulates a credit card.
 * 
 * @Alec Allain 
 * @9/25/16
 ************************************************/
public class CreditCard
{
    // This section defines the variables
    private String holderName; 
    double prevBalance = 0;
    private double purchases;
    double balanceTransfers = 0;
    double newBalance = 0;
    double fees = 0;
    double interest = 0;
    double cashAdvance = 0;
    private int numPurchases = 0;
    final double APR = 15.9/100;
    final int DUE_DATE = 20;
    final double LATE_FEE = 37.0;
    final double MIN_INTEREST = 0.5;
    private final double ADVANCE_APR = 25.9/100;

    private NumberFormat fmt = NumberFormat.getCurrencyInstance();

    // This section defines the constructors
    /**************************************
     * Prints the card owner's name
     *************************************/
    public CreditCard (String name) {
        holderName = name;
        System.out.println("Cardholder: " + holderName);
        return;
    }
    
    /**************************************
     * Prints card owner's name and the previous balance from the previous month
     *************************************/
    public CreditCard (String name, int amt){
        prevBalance = amt;
        System.out.println("Cardholder: " + name);
        System.out.print("Previous monthly balance: " + fmt.format(prevBalance));
        return;
    }

    // This section defines the accessor methods
    /**************************************
     * Returns the previous balance of owner
     *************************************/
    public double getPreviousBalance() {
        return prevBalance;
    }
    
    /**************************************
     * Returns fees due
     *************************************/
    public double getFees(){
        return fees;
    }
    
    /**************************************
     * Returns amount of interest due
     *************************************/
    public double getInterest(){
        return interest;
    }
    
    /**************************************
     * Returns amount from purchases
     *************************************/
    public double getPurchases(){
        return purchases;
    }

    /**************************************
     * Returns the transfer balance
     *************************************/
    public double getBalanceTransfers(){
        return balanceTransfers;
    }

    /**************************************
     * Returns the cash advances
     *************************************/
    public double getCashAdvances(){
        return cashAdvance;
    }

    /**************************************
     * Returns the number of purchases made
     *************************************/
    public int getNumPurchases() {
        return numPurchases;
    }

    /**************************************
     * Returns the name of the card owner
     *************************************/
    public String getName(){
        return holderName;
    }

    // This section defines the mutator methods
    /**************************************
     * Calculation for applying credit
     *************************************/
    public void applyCredit(double amt) {
        if (amt < 0) {
            System.out.println("Request cancelled: provide positive amount");
        }else{
            System.out.println("Credit applied: " + fmt.format(amt));
        }
        purchases = purchases - amt;
        return;
    }

    /**************************************
     * Calculation for the transfer balance
     *************************************/
    public void balanceTransfer(double amt) {
        if (amt < 0) {
            System.out.println("Provide positive amount");
        }else {
            System.out.println("Transfer: " + fmt.format(balanceTransfers));
        }
        fees = amt * (3/100);
        balanceTransfers = amt + (amt * (3/100));
        return;
    }

    /**************************************
     * Refreshes purchase amount
     *************************************/
    public void purchase(double amt) {
        if (purchases < 0) {
            System.out.println("Request cancelled: provide a positive amount");
        }else{
            System.out.println("Purchase Amount: " + fmt.format(purchases));
            numPurchases = numPurchases + 1;
        }
        purchases = purchases + amt;
        return;
    }

    /**************************************
     * Calculation for cash advances
     *************************************/
    public void cashAdvance(double amt, int day){
        double temp = amt * (ADVANCE_APR/365 * (31 - day));
        if (temp < 0.5) {
            temp = 0.5;
        }
        cashAdvance = cashAdvance + amt;
        interest = interest + temp;
        System.out.println("Cash Advance on Day " + day + ": " + fmt.format(cashAdvance));
        return;
    }

    // This section defines the private helper methods
    /**************************************
     * Calculation for minimum payment
     *************************************/
    private double calcMinimumPayment() {
        prevBalance = (1.5/100) * newBalance;
        return prevBalance;
    }

    /**************************************
     * Resets most values for the next payment cycle
     *************************************/
    private void resetAmounts() {
        prevBalance = newBalance;
        purchases = 0;
        balanceTransfers = 0;
        fees = 0;
        interest = 0;
        cashAdvance = 0;
    }

    /**************************************
     * Prints a month summary for owner
     *************************************/
    private void printStatement() {
        System.out.println("Cardholder:        " + holderName);
        System.out.println("Previous Balance:  " + fmt.format(prevBalance));
        System.out.println(getNumPurchases() + " Purchase(s):     " + fmt.format(purchases));
        System.out.println("Advances:          " + fmt.format(cashAdvance));
        System.out.println("Transfers:         " + fmt.format(balanceTransfers));
        System.out.println("Fees:              " + fmt.format(fees));
        System.out.println("Interest:          " + fmt.format(interest));
        System.out.println("New Balance:       " + fmt.format(newBalance));
        System.out.println("Minimum Payment:   " + fmt.format(calcMinimumPayment()));
    }

    // This section defines additional mutator methods
    /**************************************
     * Allows user to make payment for current cycle
     *************************************/
    public void makePayment(double amt, int day) {
        if ((amt < 0) || (day < 0)) {
            System.out.println("Payment can not be made.Provide positive values.");
        }
        if (day > DUE_DATE) {
            newBalance = prevBalance + LATE_FEE;
            System.out.println("Late fee applied. New payment required: " + fmt.format(newBalance));
        }else{
            System.out.println("Payment on Day " + day + ": " + fmt.format(prevBalance));
        }
        prevBalance = newBalance - amt;
        return;
    }

    /**************************************
     * Closes the month cycle and calculates final total for the cycle
     *************************************/
    public void closeBillingPeriod() {
        double tempInterest = 0;
        if (newBalance > 0) {
            tempInterest = prevBalance * (ADVANCE_APR/12);
        }if (tempInterest < 0.5) {
            tempInterest = 0.5;
        }
        interest = interest + tempInterest;
        newBalance = interest + balanceTransfers + purchases + cashAdvance + fees + prevBalance;
        printStatement();
        resetAmounts();
    }
}
