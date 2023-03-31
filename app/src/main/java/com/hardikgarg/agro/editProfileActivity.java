package com.hardikgarg.agro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class editProfileActivity extends AppCompatActivity {
    EditText editTextName,editTextPhone;
    Spinner spinner;
    String value;
    Button button;
    String[] state={"Assam","West Bengal","Odisha","Andhra Pradesh","Telangana","Tamil Nadu","Kerala","Maharashtra","Punjab","Haryana","Himachal Pradesh","Jammu and Kashmir","Uttar Pradesh","Karnatka","Gujarat","Goa","Pondicherry","Madhya Pradesh","Chattisgarh","Bihar","Tripura","Arunachal Pradesh","Sikkim","Nagaland","Meghalaya","Manipur","Rajasthan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        editTextName=findViewById(R.id.idEditTextName);
        editTextPhone=findViewById(R.id.idEditTextPhone);
        button=findViewById(R.id.button_details);
        spinner=findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(editProfileActivity.this,android.R.layout.simple_spinner_item,state);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                value=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
                editTextName=findViewById(R.id.idEditTextName);
                editTextPhone=findViewById(R.id.idEditTextPhone);
                editTextName.setText(nameFromDb);
                editTextPhone.setText(phoneFromDb);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextName.getText().toString().isEmpty()){
                    editTextName.setError("Empty");
                    editTextName.requestFocus();
                } else if (editTextPhone.getText().toString().isEmpty()) {
                    editTextPhone.setError("Empty");
                    editTextPhone.requestFocus();
                }else{
                    reference.child(userid).child("name").setValue(editTextName.getText().toString());
                    reference.child(userid).child("phone").setValue(editTextPhone.getText().toString());
                    reference.child(userid).child("state").setValue(value);

                    Intent iHome=new Intent(editProfileActivity.this,MainActivity.class);
                    iHome.putExtra("s",value);
                    startActivity(iHome);
                    finish();
                }
            }
        });
    }
}