package id.bagusip.projectkel1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import id.bagusip.projectkel1.Dashboard.DashboardEmployeeActivity;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;

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

        if(v == txtSignUp)
        {
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        }
        else if (v == cardViewLogin)
        {
            login();
        }

    }

    private void login() {
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPass.getEditText().getText().toString();
        class GetJSON extends AsyncTask<Void, Void, String> {
            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(MainActivity.this, "Getting Data", "Please wait...", false, false);
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> login = new HashMap<>();
                login.put(Konfigurasi.KEY_NAMA_EMAIL, email);
                login.put(Konfigurasi.KEY_NAMA_PASSWORD, password);
                HttpHandler handler = new HttpHandler();
                String result = handler.sendPostRequest(Konfigurasi.URL_LOGIN,login);
                Log.d("Login result", result);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                JSONObject jsonObject = null;
                ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
                try {
                    jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String status = object.getString("status");
                        String message = object.getString("message");


                        HashMap<String, String> validation = new HashMap<>();
                        validation.put("status", status);
                        validation.put("message", message);

                        list.add(validation);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("list", String.valueOf(list));

                if(list.isEmpty()){
                    Log.d("message","invalid credentials");
                }
                else{
                    Intent myIntent = new Intent(MainActivity.this, DashboardEmployeeActivity.class);
                    startActivity(myIntent);
                }

                super.onPostExecute(s);
                progressDialog.dismiss();


            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();

    }
}