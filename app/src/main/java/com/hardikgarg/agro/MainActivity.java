package com.hardikgarg.agro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
//    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        if(user==null){
            Intent iHome=new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(iHome);
            finish();
        }



        BottomNavigationView bnv=findViewById(R.id.bottomNavigationView);
        bnv.setSelectedItemId(R.id.home);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
                        String userid1 = user1.getUid();
                        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("users");
                        reference1.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String cropFromDb=snapshot.child(userid1).child("crop").getValue(String.class);
                                if(cropFromDb.equals("Tomato")){
                                    startActivity(new Intent(getApplicationContext(), TomatoMainActivity.class));
                                    finish();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                        return true;
                    case R.id.your_crop:
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
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
                                finish();
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        return true;
                    case R.id.you:
                        startActivity(new Intent(getApplicationContext(),You.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        finish();
                        return true;
                }
                return false;
            }
        });
    }
//    public void loadFrag(Fragment fragment, boolean b){
//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        if(b){
//            ft.add(R.id.container,fragment);
//        }
//        else{
//            ft.replace(R.id.container,fragment);
//        }
//
//        ft.commit();
//    }
}