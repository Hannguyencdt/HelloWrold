package devpro.vn.hellowrold.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devpro.vn.hellowrold.R;
import devpro.vn.hellowrold.config.Constants;
import devpro.vn.hellowrold.config.Network;
import devpro.vn.hellowrold.config.SharedPreferencesUtils;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtPass;
    private Button bntLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (SharedPreferencesUtils.getBoolean(this, Constants.KEY_CHECK_LOGIN )) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        itInView();
    }

    private void itInView(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        bntLogin = findViewById(R.id.bntLogin);
        bntLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Network.isNetworkAvailable(LoginActivity.this)){
                    String name = edtEmail.getText().toString();
                    String password = edtPass.getText().toString();

                    SharedPreferencesUtils.setString(LoginActivity.this,
                            Constants.KEY_NAME, name);

                    SharedPreferencesUtils.setString(LoginActivity.this,
                            Constants.KEY_PASSWORD, password);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    finish();
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Đéo có mạng", Toast.LENGTH_SHORT).show();
//                    String name = edtEmail.getText().toString();
//                    String password = edtPass.getText().toString();
//
//                    SharedPreferencesUtils.setString(LoginActivity.this,
//                            Constants.KEY_NAME, name);
//
//                    SharedPreferencesUtils.setString(LoginActivity.this,
//                            Constants.KEY_PASSWORD, password);


                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
