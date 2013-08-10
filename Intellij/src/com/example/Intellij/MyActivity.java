package com.example.Intellij;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {

    EditText userInput;
    TextView dialog;
    String userTxt;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        userInput = (EditText) findViewById(R.id.edit_txt1);
        dialog = (TextView) findViewById(R.id.txt_view1);

        userTxt =  userInput.getText().toString();
    }

    public void showUserInput(View view)
    {
        Log.d("called","called");

        dialog.setText("You have entered "+ userTxt);
    }
}
