package tn.odc.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button createAccount;
    Button validate;
    EditText email;
    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAccount = findViewById(R.id.navigate_to_create);

        validate = findViewById(R.id.validate);
        email = findViewById(R.id.email);

        SharedPreferences sharedPreferences = getSharedPreferences("my_pref", MODE_PRIVATE);
        String emailTxt = sharedPreferences.getString("email", "No Mail Found");
        email.setText(emailTxt);

        link = findViewById(R.id.link);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateAccount.class);
                startActivity(intent);
            }
        });

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = email.getText().toString();
                if(emailString.contains("@")){
                    Toast.makeText(MainActivity.this, "Valid Email", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Wrong Email", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void showToast(View view) {
        Toast.makeText(this, "XML CLick", Toast.LENGTH_SHORT).show();
    }

    public void navigateToMain(View view) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
