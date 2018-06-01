package devpro.vn.hellowrold.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import devpro.vn.hellowrold.R;

public class SlapView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slap_view);

        // Sau 3 giay chuyển sang Màn hình Login
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SlapView.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }
    }

