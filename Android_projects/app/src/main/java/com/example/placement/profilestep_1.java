package com.example.placement;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class profilestep_1 extends AppCompatActivity {
    private Button pickDateBtn, saveButton, upload_img;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private EditText nameInput, emailInput, phoneInput, cast, bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profilestep1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ------------------------- Firebase Setup ------------------------
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Users");

        // Initialize UI elements
        pickDateBtn = findViewById(R.id.idBtnPickDate);
        saveButton = findViewById(R.id.final_submit);
        upload_img = findViewById(R.id.upload_image);

        nameInput = findViewById(R.id.et_name);
        emailInput = findViewById(R.id.et_email);
        phoneInput = findViewById(R.id.et_enrollment);
        cast = findViewById(R.id.et_cast);
        bg = findViewById(R.id.et_bg);

        // ------------------------- Save Data to Firebase ------------------------
        saveButton.setOnClickListener(view -> {
            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String phone = phoneInput.getText().toString().trim();
            String cast1 = cast.getText().toString().trim();
            String bg1 = bg.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || cast1.isEmpty() || bg1.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            saveUserData(name, email, phone, cast1, bg1);
        });

        // ------------------------- Date Picker ------------------------
        pickDateBtn.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    profilestep_1.this,
                    (view, selectedYear, monthOfYear, dayOfMonth) ->
                            pickDateBtn.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + selectedYear),
                    year, month, day);

            datePickerDialog.show();
        });

        // ------------------------- Image Upload ------------------------
        upload_img.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 100);
        });
    }

    // ------------------------- Save User Data to Firebase ------------------------
    private void saveUserData(String name, String email, String phone, String cast, String bg) {
        // Generate unique ID for the user
        String userId = reference.push().getKey();

        if (userId != null) {
            // Create a User object
            User user = new User(name, email, phone, cast, bg);

            // Save data to Firebase
            reference.child(userId).setValue(user)
                    .addOnSuccessListener(aVoid -> Toast.makeText(profilestep_1.this, "Data Saved!", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e -> Toast.makeText(profilestep_1.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
        }
    }

    // ------------------------- User Model Class ------------------------
    public static class User {
        private String name, email, phone, cast, bg;

        public User() {
        }

        public User(String name, String email, String phone, String cast, String bg) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.cast = cast;
            this.bg = bg;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }

        public String getCast() { return cast; }
        public void setCast(String cast) { this.cast = cast; }

        public String getBg() { return bg; }
        public void setBg(String bg) { this.bg = bg; }
    }
}
