package com.ysconsolidated.testexplecits;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestExplements extends Activity {

    public static final String CLASS_TAG = "TestExplicitIntents ";

    private String message = "";
    private String phone = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_explements);




        // Getting to the views defined in the XML files.
        TextView tvMessageDetails = (TextView) findViewById(R.id.tvMessageDetails);
        tvMessageDetails.setBackgroundColor(Color.GREEN);
        tvMessageDetails.setMovementMethod(new ScrollingMovementMethod());
        message ="Is it St. Patricks Day?";
        phone = "";
        setSummary();

        // Responding to an event - the onClick for the Edit Message Button
        // Using a named inner class
        Button btnEditMessage;
        btnEditMessage = (Button) this.findViewById(R.id.btnEditMessage);
        HandleButtonEditMessageOnClick buttonEditMessageOnClick;
        buttonEditMessageOnClick = new HandleButtonEditMessageOnClick();
        btnEditMessage.setOnClickListener(buttonEditMessageOnClick);


        //editToSend

        Button btnEditToSend;
        btnEditToSend = (Button) this.findViewById(R.id.etToSend);
        HandleButtonEditToSendOnClick buttonEditToSendOnClick;
        buttonEditToSendOnClick = new HandleButtonEditToSendOnClick();
        btnEditToSend.setOnClickListener(buttonEditToSendOnClick);


    }


    private void setSummary() {
        StringBuilder summary;

        summary = new StringBuilder("Sending To:\n");
        summary.append(phone);
        summary.append("\n\nMessage:\n");
        summary.append(message);
        TextView tvMessageDetails = (TextView) findViewById(R.id.tvMessageDetails);
        // edit to send //
        TextView tvMPhoneDetails = (TextView) findViewById(R.id.tvMessageDetails);
        tvMPhoneDetails.setText(summary);
            //Edit to send //
        tvMessageDetails.setText(summary);
    }


    @SuppressWarnings("rawtypes")
    public class HandleButtonEditMessageOnClick implements View.OnClickListener {

        public static final String CLASS_TAG = "HandleButtonEditMessageOnClick";

        @SuppressLint("LongLogTag")
        public void onClick(View v) {


            Log.i(CLASS_TAG,"onClick started...");

            // Example of an EXPLICIT intent, as we are naming the java class to use
            // (EditMessage.class)
            Intent editIntent;
            Activity sourceActivity;
            Class destinationClass;

            sourceActivity = TestExplements.this;
            destinationClass = EditMessage.class;
            editIntent = new Intent(sourceActivity, destinationClass);

            editIntent.putExtra("CURRENT_MESSAGE", TestExplements.this.message);

            startActivity(editIntent);
        }
    }




    /// EDIT TO SEND //

    @SuppressWarnings("rawtypes")
    public  class  HandleButtonEditToSendOnClick implements View.OnClickListener{

        public static final int NEW_MESSAGE_REQUEST = 1;
        @Override
        public void onClick(View view) {

            Log.i(CLASS_TAG,"onClick started...");

            Intent editIntent;
            Activity sourceActivity;
            Class destinationClass;

            sourceActivity = TestExplements.this;
            destinationClass = EditSendTo.class;
            editIntent = new Intent(sourceActivity, destinationClass);
            editIntent.putExtra("CURRENT_MESSAGE", TestExplements.this.message);

            startActivity(editIntent);

        }
    }


    // Edit TO SEND



        }



