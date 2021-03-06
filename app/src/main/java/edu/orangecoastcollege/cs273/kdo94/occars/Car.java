package edu.orangecoastcollege.cs273.kdo94.occars;

/**
 * Created by kdo94 on 9/15/2016.
 */



public class Car {
    private double mDownPayment;
    private int mLoanTerm;
    private double mPrice;
    private double TAX_RATE = 0.08;

    public Car(){
        mDownPayment = 0.0;
        mLoanTerm = 0;
        mPrice = 0.0;
    }

    public Car(double downPayment, int loanTerm, double price) {
        this.mDownPayment = downPayment;
        this.mLoanTerm = loanTerm;
        this.mPrice = price;
    }

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(double downPayment) {
        this.mDownPayment = downPayment;
    }

    public int getLoanTerm() {
        return mLoanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        mLoanTerm = loanTerm;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        this.mPrice = price;
    }

    public double calculateBorrowedAmount() {
        return (mPrice * TAX_RATE) + mPrice - mDownPayment;
    }

    public double calculateInterestAmount(){
        double rate = getInterestRate();
        int period = getLoanTerm() * 12;
        return (mPrice - mDownPayment) * (rate * Math.pow((1 + rate), period)) / (Math.pow((1 + rate), period) - 1);
    }

    public double calculateMonthlyPayment(){
        return (calculateBorrowedAmount() + calculateInterestAmount()) / (getLoanTerm() * 12);
    }

    public double calculateTaxAmount(){
        return mPrice * TAX_RATE;
    }

    public double calculateTotalCost(){
        return mPrice + calculateTaxAmount();
    }

    public double getInterestRate(){
        double rate;
        switch(mLoanTerm)
        {
            case 5:
                rate = 0.0419;
                break;
            case 4:
                rate = 0.0416;
                break;
            default:
                rate =  0.0462;
                break;
        }
        return rate;
    }
}
