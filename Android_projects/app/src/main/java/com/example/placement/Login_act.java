package com.example.placement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            TextView Sign_up_tv = findViewById(R.id.Sign_up_tv);
            Button Login = findViewById(R.id.btn_login) ;

            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent login_after_page = new Intent(Login_act.this,profilestep_1.class);
                    Login_act.this.startActivity(login_after_page);
                    Login_act.this.finish();

                }
            });

            Sign_up_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent sign_tv_intent = new Intent(Login_act.this,MainActivity.class);
                    Login_act.this.startActivity(sign_tv_intent);
                    Login_act.this.finish();
                }
            });

            return insets;
        });
    }
}