package edu.orangecoastcollege.cs273.kdo94.occars;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityLoanSummary extends Activity {

    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_loan_summary);

        returnButton = (Button) findViewById(R.id.returnButton);
    }

    public void returnToDataEntry(View view){
        this.finish();
    }
}
