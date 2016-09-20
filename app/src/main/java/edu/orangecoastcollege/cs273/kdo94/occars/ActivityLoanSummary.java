package edu.orangecoastcollege.cs273.kdo94.occars;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityLoanSummary extends Activity {

    private Button returnButton;
    private TextView monthlyPaymentTextView;
    private TextView loanReportTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_loan_summary);

        returnButton = (Button) findViewById(R.id.returnButton);

        Bundle intentBundle = getIntent().getExtras();
        loanReportTextView = (TextView) findViewById(R.id.loanReportTextView);
        monthlyPaymentTextView = (TextView) findViewById(R.id.monthlyPaymentTextView);


        loanReportTextView.setText(intentBundle.getString("LoanSummary"));
        monthlyPaymentTextView.setText(intentBundle.getString("MonthlyPayment"));

    }

    public void returnToDataEntry(View view){
        this.finish();
    }
}
