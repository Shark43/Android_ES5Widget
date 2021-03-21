package com.taliano.es5_widget;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonInvia);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtNome = findViewById(R.id.editTextName);
                EditText txtEta = findViewById(R.id.editTextEta);
                EditText txtMail = findViewById(R.id.editTextMail);
                RadioGroup radioGroupIndirizzi = findViewById(R.id.radioGroupIndirizzo);
                RadioGroup radioGroupHobby = findViewById(R.id.radioGroupHobby);

                String s = "";
                s += "Nome: " + txtNome.getText() + "\n" +
                        "Eta: " + txtEta.getText() + "\n" +
                        "Mail: " + txtMail.getText() + "\n";

                RadioButton radioButtonSelected = findViewById(radioGroupIndirizzi.getCheckedRadioButtonId());
                if(radioButtonSelected != null)
                    s += "Indirizzo: " + radioButtonSelected.getText() + "\n";
                String hobby = "Hobby: ";
                Boolean hobbyExists = false;
                for(int i=0; i< radioGroupHobby.getChildCount(); i++) {
                    CheckBox chk = (CheckBox) radioGroupHobby.getChildAt(i);
                    if (chk.isChecked()) {
                        hobby += chk.getText() + ", ";
                        hobbyExists = true;
                    }
                }
                if(hobbyExists)
                    s += hobby;

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("successful");
                builder.setMessage(s);
                builder.setIcon(R.mipmap.ic_launcher);
                final String finalS = s;
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(MainActivity.this, finalS, Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
