package id.bagusip.projectkel1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import id.bagusip.projectkel1.Dashboard.DashboardDeveloperActivity;
import id.bagusip.projectkel1.Dashboard.DashboardEmployeeActivity;
import id.bagusip.projectkel1.config.HttpHandler;
import id.bagusip.projectkel1.config.Konfigurasi;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout textInputLayoutEmail, textInputLayoutPass;
    CardView cardViewLogin;
    LinearLayout layoutLogin;
    TextView txtSignUp;

    private String status, message, role, access_token, email_resp, name_emp, id_emp, id_division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutLogin = findViewById(R.id.layoutLogin);
        textInputLayoutEmail = findViewById(R.id.txtEmailLogin);
        textInputLayoutPass = findViewById(R.id.txtPassLogin);


        cardViewLogin = findViewById(R.id.btnLogin);
        txtSignUp = findViewById(R.id.txtSignUp);

        txtSignUp.setOnClickListener(this);
        cardViewLogin.setOnClickListener(this);

        getSupportActionBar().setElevation(0);

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
        textInputLayoutEmail.getEditText().setText("jack@email.com");
        textInputLayoutPass.getEditText().setText("adamLavv");
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPass.getEditText().getText().toString();

//        textInputLayoutEmail.setText("nickhunter@email.com");
//        textInputLayoutPass.setText("adamLavv");
//        String email = textInputLayoutEmail.getText().toString();
//        String password = textInputLayoutPass.getText().toString();

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
                        status = object.getString("status");
                        message = object.getString("message");

                        if(!object.getString(Konfigurasi.response_login_role).isEmpty() || !object.getString(Konfigurasi.response_login_access_token).isEmpty()){
                            role = object.getString(Konfigurasi.response_login_role);
                            access_token = object.getString(Konfigurasi.response_login_access_token);
                            email_resp = object.getString(Konfigurasi.response_login_email);
                            name_emp = object.getString(Konfigurasi.response_login_name_emp);
                            id_emp = object.getString(Konfigurasi.KEY_ID_EMP);
                            id_division = object.getString(Konfigurasi.KEY_NAMA_ID_DIVISION);
                        }

                        HashMap<String, String> validation = new HashMap<>();
                        validation.put("status", status);
                        validation.put("message", message);

                        list.add(validation);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                Log.d("list", message);
                if(status.equals(Konfigurasi.status_response_success)){
                    switch (role){
                        case Konfigurasi.response_login_role_developer:
                            Intent intent = new Intent(MainActivity.this, DashboardDeveloperActivity.class);
                            Bundle extras = new Bundle();
                            extras.putString("role",role);
                            extras.putString("access_token",access_token);
                            extras.putString("email",email_resp);
                            extras.putString("name_emp",name_emp);
                            extras.putString("id_emp",id_emp);
                            extras.putString("id_division",id_division);
                            intent.putExtras(extras);
                            startActivity(intent);
                            break;
                        case Konfigurasi.response_login_role_employee:
                            Intent intent2 = new Intent(MainActivity.this, DashboardEmployeeActivity.class);
                            Bundle extras2 = new Bundle();
                            extras2.putString("role",role);
                            extras2.putString("access_token",access_token);
                            extras2.putString("email",email_resp);
                            extras2.putString("name_emp",name_emp);
                            intent2.putExtras(extras2);
                            startActivity(intent2);
                            break;
                        default:
                            Toast.makeText(MainActivity.this, "Can't find role", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Invalid data : " + message, Toast.LENGTH_SHORT).show();
                }

                super.onPostExecute(s);
                progressDialog.dismiss();


            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();

    }


    @Override
    public void onBackPressed() { }
}