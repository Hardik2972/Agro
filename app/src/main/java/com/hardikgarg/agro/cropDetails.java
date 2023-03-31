package com.hardikgarg.agro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class cropDetails extends AppCompatActivity {

ArrayList<ContactModel> arrContacts=new ArrayList<>();
    String state1 = "Odisha";
    String state2 = "Assam";
    String state3= "West Bengal";
    String state4 = "Andhra Pradesh";
    String state5 = "Telangana";
    String state6 = "Tamil Nadu";
    String state7 = "Kerala";
    String state8 = "Maharashtra";
    String state9 = "Punjab";
    String state10 = "Haryana";
    String state11 = "Himachal Pradesh";
    String state12 = "Jammu and Kashmir";
    String state13 = "Uttar Pradesh";
    String state14 = "Karnatka";
    String state15 = "Gujarat";
    String state16 = "Goa";
    String state17 = "Pondicherry";
    String state18 = "Madhya Pradesh";
    String state19 = "Chattisgarh";
    String state20 = "Bihar";
    String state21 = "Tripura";
    String state22 = "Arunachal Pradesh";
    String state23 = "Sikkim";
    String state24 = "Nagaland";
    String state25 = "Meghalaya";
    String state26 = "Manipur";
    String state27 = "Rajasthan";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_details);
        RecyclerView recyclerView=findViewById(R.id.cropDhancha);
        BottomNavigationView bnv=findViewById(R.id.bottomNavigationView);
        bnv.setSelectedItemId(R.id.your_crop);

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
                                    startActivity(new Intent(getApplicationContext(), TomatoMainActivity.class));
                                    finish();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                        return true;
                    case R.id.your_crop:
//                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
//                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                        String userid = user.getUid();
//                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users");
//                        reference.addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                String stateFromDb=snapshot.child(userid).child("state").getValue(String.class);
//                                Intent intent=new Intent(getApplicationContext(),cropDetails.class);
//                                intent.putExtra("state",stateFromDb);
//                                startActivity(intent);
//                                finish();
//                            }
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//                            }
//                        });
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
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        ContactModel model1= new ContactModel(R.drawable.bell,"Bell Pepper");
        ContactModel model2= new ContactModel(R.drawable.sugarcane,"Sugarcane");
        ContactModel model3= new ContactModel(R.drawable.tea,"Tea");
        ContactModel model4= new ContactModel(R.drawable.coffee,"Coffee");
        ContactModel model5= new ContactModel(R.drawable.lavendar,"Lavendar");
        ContactModel model6= new ContactModel(R.drawable.lettuce,"Lettuce");
        ContactModel model7= new ContactModel(R.drawable.ginger,"Ginger");
        ContactModel model8= new ContactModel(R.drawable.garlic,"Garlic");
        ContactModel model9= new ContactModel(R.drawable.broccoli,"Broccoli");
        ContactModel model10= new ContactModel(R.drawable.sunflower,"Sunflower");
        ContactModel model11= new ContactModel(R.drawable.tomato,"Tomato");
//        arrContacts.add(model);
//        arrContacts.add(model1);
//        RecyclerContactAdapter adapter1 = new RecyclerContactAdapter(this,arrContacts);
//        recyclerView.setAdapter(adapter1);
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String userid = user.getUid();
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String stateFromDb=snapshot.child(userid).child("state").getValue(String.class);
//                state=stateFromDb;
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        String state = getIntent().getStringExtra("state");
        Toast.makeText(this, state, Toast.LENGTH_SHORT).show();
        if(state1.equals(state)){
            arrContacts.add(model11);
            arrContacts.add(model4);
            arrContacts.add(model10);
            arrContacts.add(model7);
            arrContacts.add(model8);
        }
        else if (state.equals(state2)) {
            arrContacts.add(model1);
            arrContacts.add(model8);
            arrContacts.add(model7);
            arrContacts.add(model3);
            arrContacts.add(model4);
        }
        else if (state.equals(state3)) {
            arrContacts.add(model11);
            arrContacts.add(model3);
            arrContacts.add(model10);
            arrContacts.add(model1);
            arrContacts.add(model7);
            arrContacts.add(model8);

        }
        else if (state.equals(state4)) {
            arrContacts.add(model2);
            arrContacts.add(model11);
            arrContacts.add(model4);
            arrContacts.add(model1);
            arrContacts.add(model10);

        }
        else if (state.equals(state5)) {
            arrContacts.add(model10);
            arrContacts.add(model6);
        }
        else if (state.equals(state6)) {
            arrContacts.add(model1);
            arrContacts.add(model6);
            arrContacts.add(model2);
            arrContacts.add(model11);
            arrContacts.add(model3);
            arrContacts.add(model4);
        }
        else if (state.equals(state7)) {
            arrContacts.add(model1);
            arrContacts.add(model2);
            arrContacts.add(model3);
            arrContacts.add(model4);
            arrContacts.add(model7);
        }
        else if (state.equals(state8)) {
            arrContacts.add(model1);
            arrContacts.add(model2);
            arrContacts.add(model11);
            arrContacts.add(model3);
            arrContacts.add(model7);
            arrContacts.add(model8);
            arrContacts.add(model9);
        }
        else if (state.equals(state9)) {
            arrContacts.add(model8);
            arrContacts.add(model10);
        }
        else if (state.equals(state10)) {
            arrContacts.add(model8);
            arrContacts.add(model10);
            arrContacts.add(model11);

        }
        else if (state.equals(state11)) {
            arrContacts.add(model3);
            arrContacts.add(model5);
        }
        else if (state.equals(state12)) {
            arrContacts.add(model5);
        }
        else if (state.equals(state13)) {
            arrContacts.add(model8);
            arrContacts.add(model10);
            arrContacts.add(model5);
        }
        else if (state.equals(state14)) {
            arrContacts.add(model1);
            arrContacts.add(model7);
            arrContacts.add(model2);
            arrContacts.add(model3);
            arrContacts.add(model4);
            arrContacts.add(model10);
        }
        else if (state.equals(state15)) {
            arrContacts.add(model7);
            arrContacts.add(model2);
            arrContacts.add(model11);
            arrContacts.add(model8);
        }
        else if (state.equals(state16)) {
            arrContacts.add(model2);
        }
        else if (state.equals(state17)) {
            arrContacts.add(model2);
        }
        else if (state.equals(state18)) {
            arrContacts.add(model8);
            arrContacts.add(model7);
            arrContacts.add(model11);
        }
        else if (state.equals(state19)) {
            arrContacts.add(model11);
        }
        else if (state.equals(state20)) {
            arrContacts.add(model11);
            arrContacts.add(model10);
        }
        else if (state.equals(state21)) {
            arrContacts.add(model3);
            arrContacts.add(model4);
            arrContacts.add(model1);
        }
        else if (state.equals(state22)) {
            arrContacts.add(model3);
            arrContacts.add(model1);
        }
        else if (state.equals(state23)) {
            arrContacts.add(model3);
            arrContacts.add(model7);
        }
        else if (state.equals(state24)) {
            arrContacts.add(model4);
            arrContacts.add(model3);
        }
        else if (state.equals(state25)) {
            arrContacts.add(model7);
            arrContacts.add(model4);
            arrContacts.add(model1);
        }
        else if (state.equals(state26)) {
            arrContacts.add(model4);
        }
        else if (state.equals(state27)) {
            arrContacts.add(model8);
        }
        RecyclerContactAdapter adapter1 = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter1);
        findViewById(R.id.idAddCrop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cropDetails.this,CropChoose.class);
                intent.putExtra("state",state);
                startActivity(intent);
                finish();
            }
        });
    }


}