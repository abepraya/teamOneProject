package id.bagusip.projectkel1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import id.bagusip.projectkel1.Dashboard.DashboardEmployeeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout textInputLayoutEmail, textInputLayoutPass;
    CardView cardViewLogin;
    TextView txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayoutEmail = findViewById(R.id.txtEmailLogin);
        textInputLayoutPass = findViewById(R.id.txtPassLogin);
        cardViewLogin = findViewById(R.id.btnLogin);
        txtSignUp = findViewById(R.id.txtSignUp);

        txtSignUp.setOnClickListener(this);
        cardViewLogin.setOnClickListener(this);



    }

    public void onClick (View v){
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPass.getEditText().getText().toString();

        if(v == txtSignUp)
        {
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        }
        else if (v == cardViewLogin)
        {
            Log.d("test",email);
            Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
           Intent i = new Intent(this, DashboardEmployeeActivity.class);
           startActivity(i);
        }

    }
}