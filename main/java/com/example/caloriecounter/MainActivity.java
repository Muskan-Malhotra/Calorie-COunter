package com.example.caloriecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    TextView textView2;
    EditText CC;
    EditText CB;
//    Button button;
    Button savebutton;
    SharedPreferences shared;
    final String savetext = "Save_text";
    final String Savetext = "Save_Text";
    int count = 0;
    //SharedPreferences.Editor editor = shared.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        CC = (EditText) findViewById(R.id.CC);
        CC.setEnabled(false);
        CB = (EditText) findViewById(R.id.CB);
        CB.setEnabled(false);
//        button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(this);
        savebutton = (Button) findViewById(R.id.savebutton);
        savebutton.setOnClickListener((View.OnClickListener) this);
        loadText();

    }




    @SuppressLint("SetTextI18n")
    public void onClick(View v) {

        if (count == 0) {
            //v.getId();
            CC.setEnabled(true);
            CB.setEnabled(true);

            loadText();
            count++;
            savebutton.setText("Save");
        } else {
            // onDestroy() used to close the app
            saveText();
            CC.setEnabled(false);
            CB.setEnabled(false);
            savebutton.setText("Edit");
            count--;
            //case R.id.button:
//                loadText();
//                break;
        }
    }
    @SuppressLint("SetTextI18n")
    void saveText() {
        shared = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(savetext, CC.getText().toString());
        editor.putString(Savetext, CB.getText().toString());
        editor.apply();
        //to change the text on the button;
        loadText();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();


    }
//    @SuppressLint("SetTextI18n")
//    void changeText(){
//        CC= new EditText(MainActivity.this);
//        CC.setText("Show Up");  // after restarting the app this show up msg is placed in cc
////        Toast.makeText(this,"Text Loaded",Toast.LENGTH_LONG).show();
//    }

    void loadText(){

        shared = getPreferences(Context.MODE_PRIVATE);
        String savedText = shared.getString(savetext," ");
        String SavedText = shared.getString(Savetext," ");
        CC.setText(savedText);
        CB.setText(SavedText);

//        Toast.makeText(this,"Text Loaded",Toast.LENGTH_LONG).show();
    }
//    @SuppressLint("SetTextI18n")
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        savebutton.setText("Edit");
//        saveText();
    }






//        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
//        final SharedPreferences.Editor editor = shared.edit();
//
//        editor.putString("CalorieC", CC.getText().toString());  // to convert string to integer then parseint is used.
//        editor.putString("CalorieB",CB.getText().toString());
//        editor.commit();
//
//        savebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               //save();
//            }

//            private void save() {
//                //SharedPreferences shared = getSharedPreferences("Calories", Context.MODE_PRIVATE); //USED TO DECLARE
////     'it takes two arguments name of the file where data is stored and second one is the mode i.e private'
//                //SharedPreferences.Editor editor = shared.edit(); //it alows to edit the file and add the data in the file.
//                editor.putString("CalorieC", edit2.getText().toString());  // to convert string to integer then parseint is used.
//                editor.putString("CalorieB",edit.getText().toString());  //we want the text from edit text to store here so we are using gettext and then we'll change it to string.
//
//                editor.commit(); //to commit changes to display is important.
//
//                // this shows the message to be displayed in the app.
//            }
////            Toast.makeText(this,"Your data has been Saved Successfully", Toast.LENGTH_LONG).show();


//log.d is fpr debug

//        });

//        private void chechsharedpreferences(){
//            String CC = shared.getString(getString(R.string.CC),"");
//            String CB = shared.getString(getString(R.string.CB),"");
//
//        }




//Check the shared preferences and set them accordingly



