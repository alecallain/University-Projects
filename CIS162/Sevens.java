/*****************************************
 * This class creates the game of Sevens
 * 
 * @author Alec Allain 
 * @version 10/10/16
 ****************************************/
public class Sevens
{
    GVdie d1;
    GVdie d2;
    GVdie d3;
    GVdie d4;
    GVdie d5;
    GVdie d6;
    int player1Score;
    int player2Score;
    int numRolls;
    boolean player1Turn;

    /*****************************
     * Initializes the variables
     ****************************/
    public Sevens () {
        d1 = new GVdie();
        d2 = new GVdie();
        d3 = new GVdie();
        d4 = new GVdie();
        d5 = new GVdie();
        d6 = new GVdie();
        player1Score = 0;
        player2Score = 0;
        numRolls = 0;
        d1.setBlank();
        d2.setBlank();
        d3.setBlank();
        d4.setBlank();
        d5.setBlank();
        d6.setBlank();
        player1Turn = true;
    }

    /*****************************
     * @return player 1's score
     ****************************/
    public int getScore1() {
        return player1Score;
    }

    /*****************************
     * @return player 2's score
     ****************************/
    public int getScore2() {
        return player2Score;
    }

    /*****************************
     * Defines if it's player 1's turn to roll
     ****************************/
    public boolean isPlayer1turn() {
        if (player1Turn) {
            return true;
        }else {
            return false;
        }
    }

    /*****************************
     * Determines if there's more rolls than three
     ****************************/
    public boolean turnOver() {
        if (numRolls >= 3) { 
            player1Turn = false;
            passDice();
            resetDice();
            return true;
        }else {
            return false;
        }
    }

    /*****************************
     * Determines a winner of the current game
     ****************************/
    public boolean gameOver() {
        // calls if loser has over 77 points
        if (player1Score >= 77) {
            System.out.println("Player 2 wins");
            return true;
        }else if (player2Score >= 77) {
            System.out.println("Player 1 wins");
            return true;
        }else {
            return false;
        }
    }

    /*****************************
     * @return values of the dice
     ****************************/
    public GVdie getDie (int num) {
        // gets the dice number
        if (num == 1) {
            return d1;
        }else if (num == 2) {
            return d2;
        }else if (num == 3) {
            return d3;
        }else if (num == 4) {
            return d4;
        }else if (num == 5) {
            return d5;
        }else {
            return d6;
        }
    }

    /*****************************
     * Resets all the dice
     ****************************/
    private void resetDice() {
        // all dice are reset
        d1.setFrozen(false);
        d2.setFrozen(false);
        d3.setFrozen(false);
        d4.setFrozen(false);
        d5.setFrozen(false);
        d6.setFrozen(false);

        d1.setHeld(false);
        d2.setHeld(false);
        d3.setHeld(false);
        d4.setHeld(false);
        d5.setHeld(false);
        d6.setHeld(false);

        d1.setBlank();
        d2.setBlank();
        d3.setBlank();
        d4.setBlank();
        d5.setBlank();
        d6.setBlank();
    }

    /*****************************
     * @return total of all dice not held
     ****************************/
    private int getDiceTotal() {
        int totalValue = 0;
        if (!d1.isHeld()) {
            totalValue += d1.getValue();
        }
        if (!d2.isHeld()) {
            totalValue += d2.getValue();
        }
        if (!d3.isHeld()) {
            totalValue += d3.getValue();
        }
        if (!d4.isHeld()) {
            totalValue += d4.getValue();
        }
        if (!d5.isHeld()) {
            totalValue += d5.getValue();
        }
        if (!d6.isHeld()) {
            totalValue += d6.getValue();
        }
        return totalValue;
    }

    /*****************************
     * @return number of dice held
     ****************************/
    private int getNumHeld() {
        //adds up dice held
        int numDice = 0;
        if (d1.isHeld()) {
            numDice += 1;
        }
        if (d2.isHeld()) {
            numDice += 1;
        }
        if (d3.isHeld()) {
            numDice += 1;
        }
        if (d4.isHeld()) {
            numDice += 1;
        }
        if (d5.isHeld()) {
            numDice += 1;
        }
        if (d6.isHeld()) {
            numDice += 1;
        }
        return numDice;
    }

    /*****************************
     * Freezes all the dice in place
     ****************************/
    private void freezeDice() {
        // dice are all frozen
        d1.setFrozen(true);
        d2.setFrozen(true);
        d3.setFrozen(true);
        d4.setFrozen(true);
        d5.setFrozen(true);
        d6.setFrozen(true);
    }

    /*****************************
     * Shows value of each die
     ****************************/
    private void showDice() {
        if (d1.isHeld()) {
            System.out.println("*" + " " + d2.getValue() + " " + d3.getValue() + " " + d4.getValue() + " " + d5.getValue() + " " + d6.getValue());
        }else if (d2.isHeld()) {
            System.out.println(d1.getValue() + " " + "*" + " " + d3.getValue() + " " + d4.getValue() + " " + d5.getValue() + " " + d6.getValue());
        }else if (d3.isHeld()) {
            System.out.println(d1.getValue() + " " + d2.getValue() + " " + "*" + " " + d4.getValue() + " " + d5.getValue() + " " + d6.getValue());
        }else if (d4.isHeld()) {
            System.out.println(d1.getValue() + " " + d2.getValue() + " " + d3.getValue() + " " + "*" + " " + d5.getValue() + " " + d6.getValue());
        }else if (d5.isHeld()) {
            System.out.println(d1.getValue() + " " + d2.getValue() + " " + d3.getValue() + " " + d4.getValue() + " " + "*" + " " + d6.getValue());
        }else if (d6.isHeld()) {
            System.out.println(d1.getValue() + " " + d2.getValue() + " " + d3.getValue() + " " + d4.getValue() + " " + d5.getValue() + " " + "*");
        }
    }

    /*****************************
     * Rolls all dice that aren't held
     ****************************/
    public void rollDice() {
        if (numRolls <= 3) {
            if (!d1.isHeld()) {    
                d1.roll();
            }
            if (!d2.isHeld()) {
                d2.roll();
            }
            if (!d3.isHeld()) {    
                d3.roll();
            }
            if (!d4.isHeld()) {
                d4.roll();
            }
            if (!d5.isHeld()) {
                d5.roll();
            }
            if (!d6.isHeld()) {
                d6.roll();
            }
            numRolls = numRolls + 1;
        }
        checkValidOptions(); 
    }

    /*****************************
     * Adds current score and switches to other player
     ****************************/
    public void passDice() {
        getDiceTotal();
        if (player1Turn) {
            player1Score += getDiceTotal();
        }else if (!player1Turn) {
            player2Score += getDiceTotal();
        }

        if (player1Turn) {
            resetDice();
            numRolls = 0;
            return;
        }else if (!player1Turn) {
            resetDice();
            numRolls = 0;
            return;
        }
    }

    /*****************************
     * Resets for a fresh game
     ****************************/
    public void resetGame() {
        resetDice();
        numRolls = 0;
        player1Score = 0;
        player2Score = 0;
    }

    /*****************************
     * Confirms there's at least one pair of dice not held that add to seven
     ****************************/
    private void checkValidOptions() {
        if (!d1.isHeld() && !d2.isHeld() && (d1.getValue() + d2.getValue() == 7)) {
            return;
        }
        else if (!d1.isHeld() && !d3.isHeld() && (d1.getValue() + d3.getValue() == 7)) {
            return;
        }
        else if (!d1.isHeld() && !d4.isHeld() && (d1.getValue() + d4.getValue() == 7)) {
            return;
        }
        else if (!d1.isHeld() && !d5.isHeld() && (d1.getValue() + d5.getValue() == 7)) {
            return;
        }
        else if (!d1.isHeld() && !d6.isHeld() && (d1.getValue() + d6.getValue() == 7)) {
            return;
        }

        else if (!d2.isHeld() && !d3.isHeld() && (d2.getValue() + d3.getValue() == 7)) {
            return;
        }
        else if (!d2.isHeld() && !d4.isHeld() && (d2.getValue() + d4.getValue() == 7)) {
            return;
        }
        else if (!d2.isHeld() && !d5.isHeld() && (d2.getValue() + d5.getValue() == 7)) {
            return;
        }
        else if (!d2.isHeld() && !d6.isHeld() && (d2.getValue() + d6.getValue() == 7)) {
            return;
        }

        else if (!d3.isHeld() && !d4.isHeld() && (d3.getValue() + d4.getValue() == 7)) {
            return;
        }
        else if (!d3.isHeld() && !d5.isHeld() && (d3.getValue() + d5.getValue() == 7)) {
            return;
        }
        else if (!d3.isHeld() && !d6.isHeld() && (d3.getValue() + d6.getValue() == 7)) {
            return;
        }

        else if (!d4.isHeld() && !d5.isHeld() && (d4.getValue() + d5.getValue() == 7)) {
            return;
        }
        else if (!d4.isHeld() && !d6.isHeld() && (d4.getValue() + d6.getValue() == 7)) {
            return;
        }

        else if (!d5.isHeld() && !d6.isHeld() && (d5.getValue() + d6.getValue() == 7)) {
            return;
        }
        else {
            numRolls = 3;
            freezeDice();
        }
    }

    /*****************************
     * @return true if a valid hand is represented
     ****************************/
    private boolean isValidHand() {
        int total = 0;
        if (d1.isHeld()) {
            total += d1.getValue();
        }
        if (d2.isHeld()) {
            total += d2.getValue();
        }
        if (d3.isHeld()) {
            total += d3.getValue();
        }
        if (d4.isHeld()) {
            total += d4.getValue();
        }
        if (d5.isHeld()) {
            total += d5.getValue();
        }
        if (d6.isHeld()) {
            total += d6.getValue();
        }
        getNumHeld();
        if (numRolls == 0 || (numRolls == 1 && total == 7) || (numRolls == 2 && total == 14)) {
            return true;
        }else {
            return false;
        }
    }

    /*****************************
     * Looks for one pair of dice not held that add to seven
     ****************************/
    private void autoHold() {
        if (d1.getValue() + d2.getValue() == 7) {
            d1.setHeld(true);
            d2.setHeld(true);
        }
        else if (d1.getValue() + d3.getValue() == 7) {
            d1.setHeld(true);
            d3.setHeld(true);
        }
        else if (d1.getValue() + d4.getValue() == 7) {
            d1.setHeld(true);
            d4.setHeld(true);
        }
        else if (d1.getValue() + d5.getValue() == 7) {
            d1.setHeld(true);
            d5.setHeld(true);
        }
        else if (d1.getValue() + d6.getValue() == 7) {
            d1.setHeld(true);
            d6.setHeld(true);
        }

        else if (d2.getValue() + d3.getValue() == 7) {
            d2.setHeld(true);
            d3.setHeld(true);
        }
        else if (d2.getValue() + d4.getValue() == 7) {
            d2.setHeld(true);
            d4.setHeld(true);
        }
        else if (d2.getValue() + d5.getValue() == 7) {
            d2.setHeld(true);
            d5.setHeld(true);
        }
        else if (d2.getValue() + d6.getValue() == 7) {
            d2.setHeld(true);
            d6.setHeld(true);
        }

        else if (d3.getValue() + d4.getValue() == 7) {
            d3.setHeld(true);
            d4.setHeld(true);
        }
        else if (d3.getValue() + d5.getValue() == 7) {
            d3.setHeld(true);
            d5.setHeld(true);
        }
        else if (d3.getValue() + d6.getValue() == 7) {
            d3.setHeld(true);
            d6.setHeld(true);
        }

        else if (d4.getValue() + d5.getValue() == 7) {
            d4.setHeld(true);
            d5.setHeld(true);
        }
        else if (d4.getValue() + d6.getValue() == 7) {
            d4.setHeld(true);
            d6.setHeld(true);
        }

        else if (d5.getValue() + d6.getValue() == 7) {
            d5.setHeld(true);
            d6.setHeld(true);
        }
        else {
            numRolls = 3;
            player1Turn = false;
        }
    }

    /*****************************
     * Simulates a players turn
     ****************************/
    private void autoTurn() {
        while(!turnOver()) {
            rollDice();
            showDice();
            autoHold();
        }
        passDice();
    }

    /*****************************
     * Simulates a game back and forth between players
     ****************************/
    public void autoGame() {
        while (!gameOver()) {
            autoTurn();
        }
        if (getScore1() >= 77) {
            gameOver();
        }
        if (getScore2() >= 77) {
            gameOver();
        }
    }

}
