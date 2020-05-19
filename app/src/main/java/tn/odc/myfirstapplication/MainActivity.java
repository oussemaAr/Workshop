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
    EditText password;
    TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("my_pref", MODE_PRIVATE);
        boolean isLoggedIN = sharedPreferences.getBoolean("is_logged_in", false);
        if(isLoggedIN){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

        createAccount = findViewById(R.id.navigate_to_create);

        validate = findViewById(R.id.validate);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

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
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref", MODE_PRIVATE);
        String emailTxt = sharedPreferences.getString("email", "");
        String passwordTxt = sharedPreferences.getString("password", "");

        String inputEmail = email.getText().toString();
        String inputPassword = password.getText().toString();

        if(emailTxt.equals(inputEmail) && passwordTxt.equals(inputPassword)){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("is_logged_in", true);
            editor.commit();
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }else{
            email.setError("Wrong Email");
            password.setError("Wrong Password");
        }
    }
}
