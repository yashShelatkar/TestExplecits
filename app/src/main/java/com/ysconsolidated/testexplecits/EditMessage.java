package com.ysconsolidated.testexplecits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditMessage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_message);

        Intent editIntent;
        EditText etMessage;
        editIntent = this.getIntent();
        String theMessage;
        theMessage = editIntent.getStringExtra("CURRENT_MESSAGE");
        etMessage = (EditText) this.findViewById(R.id.etMessage);
        etMessage.setText(theMessage);

        Button btnDone = (Button) this.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new ButtonDoneOnClickHandler());
    }

        private class ButtonDoneOnClickHandler implements View.OnClickListener {

            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("NEW_MESSAGE", ((EditText) findViewById(R.id.etMessage)).getText().toString());
                setResult(RESULT_OK, intent);
                finish();


            }
        }
}
