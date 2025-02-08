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

public class profilestep_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profilestep2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Button btn_prv_1 = findViewById(R.id.btn_prv1);
            Button btn_nxt2 = findViewById(R.id.btn_next2);

            btn_prv_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent prv1 = new Intent(profilestep_2.this,profilestep_1.class);
                    profilestep_2.this.startActivity(prv1);
                    profilestep_2.this.finish();

                }
            });
            btn_nxt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent nxt2 = new Intent(profilestep_2.this,profilestep_3.class);
                    profilestep_2.this.startActivity(nxt2);
                    profilestep_2.this.finish();

                }
            });

            return insets;
        });
    }
}