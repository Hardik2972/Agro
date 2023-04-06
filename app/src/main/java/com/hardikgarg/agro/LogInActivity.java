package com.hardikgarg.agro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {
    TextView v1;
    EditText editTextEmail, editTextPassword;
    FirebaseAuth mAuth;
    EditText phone;

    Button buttonLogin;
    DataSnapshot snapshot;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
            String userid1 = user1.getUid();
            DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("users");
            reference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String cropFromDb=snapshot.child(userid1).child("crop").getValue(String.class);
                    if(cropFromDb.equals("Tomato")) {
                        startActivity(new Intent(getApplicationContext(), TomatoMainActivity.class));
                        finish();
                    }
                    else if(cropFromDb.equals("Bell Pepper")) {
                        startActivity(new Intent(getApplicationContext(), BellMainActivity.class));
                        finish();
                    }
                    else if(cropFromDb.equals("Sugarcane")) {
                        startActivity(new Intent(getApplicationContext(), SugarcaneMainActivity.class));
                        finish();
                    }
                    else if(cropFromDb.equals("Tea")) {
                        startActivity(new Intent(getApplicationContext(), TeaMainActivity.class));
                        finish();
                    }
                    else if(cropFromDb.equals("Coffee")) {
                        startActivity(new Intent(getApplicationContext(), CoffeeMainActivity.class));
                        finish();
                    }
                    else if(cropFromDb.equals("Lavendar")) {
                        startActivity(new Intent(getApplicationContext(), LavendarMainActivity.class));
                        finish();
                    }
                    else if(cropFromDb.equals("Ginger")) {
                        startActivity(new Intent(getApplicationContext(), GingerMainActivity.class));
                        finish();
                    }
                    else if(cropFromDb.equals("Garlic")) {
                        startActivity(new Intent(getApplicationContext(), GarlicMainActivity.class));
                        finish();
                    }
                    else if(cropFromDb.equals("Broccoli")) {
                        startActivity(new Intent(getApplicationContext(), BroccoliMainActivity.class));
                        finish();
                    }
                    else if(cropFromDb.equals("Sunflower")) {
                        startActivity(new Intent(getApplicationContext(), SunflowerMainActivity.class));
                        finish();
                    }
                    else{
                        startActivity(new Intent(getApplicationContext(), LettuceMainActivity.class));
                        finish();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        v1 =findViewById(R.id.signup);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ilogin=new Intent(LogInActivity.this,RegisterActivity.class);
                startActivity(ilogin);
                finish();

            }
        });
        mAuth=FirebaseAuth.getInstance();
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        buttonLogin=findViewById(R.id.button_registration);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email,password;
                email=String.valueOf(editTextEmail.getText());
                password=String.valueOf(editTextPassword.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(LogInActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LogInActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(LogInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
                                    String userid1 = user1.getUid();
                                    DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("users");
                                    reference1.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            String cropFromDb=snapshot.child(userid1).child("crop").getValue(String.class);
                                            if(cropFromDb.equals("Tomato")) {
                                                startActivity(new Intent(getApplicationContext(), TomatoMainActivity.class));
                                                finish();
                                            }
                                            else if(cropFromDb.equals("Bell Pepper")) {
                                                startActivity(new Intent(getApplicationContext(), BellMainActivity.class));
                                                finish();
                                            }
                                            else if(cropFromDb.equals("Sugarcane")) {
                                                startActivity(new Intent(getApplicationContext(), SugarcaneMainActivity.class));
                                                finish();
                                            }
                                            else if(cropFromDb.equals("Tea")) {
                                                startActivity(new Intent(getApplicationContext(), TeaMainActivity.class));
                                                finish();
                                            }
                                            else if(cropFromDb.equals("Coffee")) {
                                                startActivity(new Intent(getApplicationContext(), CoffeeMainActivity.class));
                                                finish();
                                            }
                                            else if(cropFromDb.equals("Lavendar")) {
                                                startActivity(new Intent(getApplicationContext(), LavendarMainActivity.class));
                                                finish();
                                            }
                                            else if(cropFromDb.equals("Ginger")) {
                                                startActivity(new Intent(getApplicationContext(), GingerMainActivity.class));
                                                finish();
                                            }
                                            else if(cropFromDb.equals("Garlic")) {
                                                startActivity(new Intent(getApplicationContext(), GarlicMainActivity.class));
                                                finish();
                                            }
                                            else if(cropFromDb.equals("Broccoli")) {
                                                startActivity(new Intent(getApplicationContext(), BroccoliMainActivity.class));
                                                finish();
                                            }
                                            else if(cropFromDb.equals("Sunflower")) {
                                                startActivity(new Intent(getApplicationContext(), SunflowerMainActivity.class));
                                                finish();
                                            }
                                            else{
                                                startActivity(new Intent(getApplicationContext(), LettuceMainActivity.class));
                                                finish();
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
                                    // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "signInWithEmail:success");
//                                    FirebaseUser user = mAuth.getCurrentUser();
//                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
//                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LogInActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                                }
                            }
                        });
            }
        });
    }
}