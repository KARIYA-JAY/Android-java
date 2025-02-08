package com.example.placement;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class profilestep_1 extends AppCompatActivity {
    private Button pickDateBtn;
    private TextView selectedDateTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profilestep1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            pickDateBtn = findViewById(R.id.idBtnPickDate);

            pickDateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // on below line we are getting
                    // the instance of our calendar.
                    final Calendar c = Calendar.getInstance();

                    // on below line we are getting
                    // our day, month and year.
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DAY_OF_MONTH);

                    // on below line we are creating a variable for date picker dialog.
                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            // on below line we are passing context.

                            profilestep_1.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {
                                    // on below line we are setting date to our text view.
                                    pickDateBtn.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }
                            },

                            year, month, day);

                    datePickerDialog.show();
                }
            });
            Button btn_next1 = findViewById(R.id.btn_next1);
            btn_next1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent step2 = new Intent(profilestep_1.this,profilestep_2.class);
                    profilestep_1.this.startActivity(step2);
                    profilestep_1.this.finish();

                }
            });



            return insets;
        });
    }
}