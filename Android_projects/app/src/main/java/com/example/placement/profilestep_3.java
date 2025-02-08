package com.example.placement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class profilestep_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profilestep3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Button btn_prv2 = findViewById(R.id.btn_prv2);
            btn_prv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent prv_2 = new Intent(profilestep_3.this,profilestep_2.class);
                    profilestep_3.this.startActivity(prv_2);
                    profilestep_3.this.finish();

                }
            });

            return insets;
        });
    }
}