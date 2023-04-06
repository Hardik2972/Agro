package com.hardikgarg.agro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class You extends AppCompatActivity {
    TextView n;
    TextView p;
    TextView s;
    Button b;
    Button editProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you);
        BottomNavigationView bnv=findViewById(R.id.bottomNavigationView);
        bnv.setSelectedItemId(R.id.you);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:

                        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
                        String userid1 = user1.getUid();
                        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("users");
                        reference1.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String cropFromDb=snapshot.child(userid1).child("crop").getValue(String.class);
                                if(cropFromDb.equals("Tomato")) {
                                    startActivity(new Intent(getApplicationContext(), TomatoMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                                else if(cropFromDb.equals("Bell Pepper")) {
                                    startActivity(new Intent(getApplicationContext(), BellMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                                else if(cropFromDb.equals("Sugarcane")) {
                                    startActivity(new Intent(getApplicationContext(), SugarcaneMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                                else if(cropFromDb.equals("Tea")) {
                                    startActivity(new Intent(getApplicationContext(), TeaMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                                else if(cropFromDb.equals("Coffee")) {
                                    startActivity(new Intent(getApplicationContext(), CoffeeMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                                else if(cropFromDb.equals("Lavendar")) {
                                    startActivity(new Intent(getApplicationContext(), LavendarMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                                else if(cropFromDb.equals("Ginger")) {
                                    startActivity(new Intent(getApplicationContext(), GingerMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                                else if(cropFromDb.equals("Garlic")) {
                                    startActivity(new Intent(getApplicationContext(), GarlicMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                                else if(cropFromDb.equals("Broccoli")) {
                                    startActivity(new Intent(getApplicationContext(), BroccoliMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                                else if(cropFromDb.equals("Sunflower")) {
                                    startActivity(new Intent(getApplicationContext(), SunflowerMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                                else{
                                    startActivity(new Intent(getApplicationContext(), LettuceMainActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                    finish();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                        return true;
                    case R.id.your_crop:

                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        String userid = user.getUid();
                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String stateFromDb=snapshot.child(userid).child("state").getValue(String.class);
                                Intent intent=new Intent(getApplicationContext(),cropDetails.class);
                                intent.putExtra("state",stateFromDb);
                                startActivity(intent);
                                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                                finish();
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        return true;
                    case R.id.you:
                        return true;
                }
                return false;
            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid=user.getUid();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String nameFromDb=snapshot.child(userid).child("name").getValue(String.class);
                String phoneFromDb=snapshot.child(userid).child("phone").getValue(String.class);
                String emailFromDb=snapshot.child(userid).child("email").getValue(String.class);
                String stateFromDb=snapshot.child(userid).child("state").getValue(String.class);
                n=findViewById(R.id.textViewName1);
                p=findViewById(R.id.textViewPhone1);
                s=findViewById(R.id.textViewState);
                n.setText(nameFromDb);
                p.setText(phoneFromDb);
                s.setText(stateFromDb);
//                Intent intent=new Intent(UploadNotice.this,You.class);
//                intent.putExtra("name",nameFromDb);
//                intent.putExtra("phone",phoneFromDb);
//                intent.putExtra("email",emailFromDb);
//                intent.putExtra("state",stateFromDb);
//                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        b=findViewById(R.id.logout);

//        String name=getIntent().getStringExtra("name");
//        String phone=getIntent().getStringExtra("phone");
//        String state=getIntent().getStringExtra("state");
        
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(You.this,LogInActivity.class);
                startActivity(intent);
                finish();

            }
        });
        editProfile=findViewById(R.id.edit_text);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(You.this,editProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}