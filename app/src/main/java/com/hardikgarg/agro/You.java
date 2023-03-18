package com.hardikgarg.agro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you);
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

            }
        });
    }
}