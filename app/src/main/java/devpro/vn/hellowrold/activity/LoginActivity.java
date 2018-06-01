package devpro.vn.hellowrold.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import devpro.vn.hellowrold.R;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtPass;
    private Button bntLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        itInView();
    }

    private void itInView(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        bntLogin = findViewById(R.id.bntLogin);
        bntLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                finish();
                startActivity(intent);

            }
        });
    }
}
