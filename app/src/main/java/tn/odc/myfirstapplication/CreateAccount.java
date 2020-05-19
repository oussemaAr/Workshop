package tn.odc.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccount extends AppCompatActivity {

    // 1 declaration des Widgets
    Button createAccount;
    EditText firstName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        // 2 link createAccount avec button dans XML
        createAccount = findViewById(R.id.create_account);
        firstName = findViewById(R.id.first_name);

        // change the text of the button
        createAccount.setText("NEW TEXT");

        // 3 add click event for the button
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = firstName.getText().toString();
                Toast.makeText(CreateAccount.this, "Welcome "+ name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
