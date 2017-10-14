package com.ysconsolidated.testexplecits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditSendTo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_send_to);


        Intent editIntent;
        EditText etPhoneNumber;

        editIntent = this.getIntent();
        String theNumber;
        theNumber = editIntent.getStringExtra("CURRENT_MESSAGE");
        etPhoneNumber = (EditText) findViewById(R.id.phoneNumberTextView);
        etPhoneNumber.setText(theNumber);

        Button done = (Button) this.findViewById(R.id.doneButton);
        done.setOnClickListener(new ButtonDoneOnClickHandler());



    }

    private class ButtonDoneOnClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent();
            intent.putExtra("NEW_MESSAGE" , ((EditText) findViewById(R.id.phoneNumberTextView)).getText().toString());
            setResult(RESULT_OK,intent);
            finish();

        }
    }
}
