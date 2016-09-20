package edu.orangecoastcollege.cs273.kdo94.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class PurchaseActivity extends AppCompatActivity {

    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioButton threeYearsRadioButton;
    private RadioButton fourYearsRadioButton;
    private RadioButton fiveYearsRadioButton;

   private Car currentCar;

    private String monthlyPaymentText;
    private String loanSummaryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        carPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        downPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        threeYearsRadioButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        fourYearsRadioButton = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        fiveYearsRadioButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton);

        currentCar = new Car();
    }

    public void activateLoanReport(View view){
        double price, downPayment;

        try{
            price = Double.parseDouble(carPriceEditText.getText().toString());
            downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        }
        catch(NumberFormatException e)
        {
            price = 0.0;
            downPayment = 0.0;
        }

        int loanTerm;

        if(fiveYearsRadioButton.isChecked())
            loanTerm = 5;
        else if(fourYearsRadioButton.isChecked())
            loanTerm = 4;
        else
            loanTerm = 3;

        currentCar.setPrice(price);
        currentCar.setDownPayment(downPayment);
        currentCar.setLoanTerm(loanTerm);

        constructLoanSummaryText();

        // Create the Intent to share data with LoanSummaryActivity
        Intent loanSummaryIntent = new Intent(this, ActivityLoanSummary.class);
        loanSummaryIntent.putExtra("MonthlyPayment", monthlyPaymentText);
        loanSummaryIntent.putExtra("LoanSummary", loanSummaryText);

        // Start the new activity
        startActivity(loanSummaryIntent);
    }

    private void constructLoanSummaryText(){
        monthlyPaymentText = getString(R.string.report_line1) + currentCar.calculateMonthlyPayment();

        loanSummaryText = getString(R.string.report_line2) + currentCar.getPrice() +
                            getString(R.string.report_line3) + currentCar.getDownPayment() +
                            getString(R.string.report_line5) + currentCar.calculateTaxAmount() +
                            getString(R.string.report_line6) + currentCar.calculateTotalCost() +
                            getString(R.string.report_line7) + currentCar.calculateBorrowedAmount() +
                            getString(R.string.report_line8) + currentCar.calculateInterestAmount() +
                            getString(R.string.report_line4) + currentCar.getLoanTerm() +
                            getString(R.string.report_line9) + getString(R.string.report_line10) +
                            getString(R.string.report_line11) + getString(R.string.report_line12);
    }
}
