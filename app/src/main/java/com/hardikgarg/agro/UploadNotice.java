package com.hardikgarg.agro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UploadNotice extends AppCompatActivity {
    Spinner spinner;
    private TextView  selectImage;
    private ImageView image;
    FirebaseAuth mAuth;
    FirebaseUser user;
    private Button button;
    private Bitmap bitmap;
    private final int REQ=1;
    private TextView name;
    private TextView phone;
    private DatabaseReference reference;
    private StorageReference storageReference;
    String value;

    String[] state={"Assam","West Bengal","Odisha","Andhra Pradesh","Telangana","Tamil Nadu","Kerala","Maharashtra","Punjab","Haryana","Himachal Pradesh","Jammu and Kashmir","Uttar Pradesh","Karnatka","Gujarat","Goa","Pondicherry","Madhya Pradesh","Chattisgarh","Bihar","Tripura","Arunachal Pradesh","Sikkim","Nagaland","Meghalaya","Manipur","Rajasthan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_notice);
        spinner=findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(UploadNotice.this,android.R.layout.simple_spinner_item,state);
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
        reference= FirebaseDatabase.getInstance().getReference("users");
        button=findViewById(R.id.button_details);
        name=findViewById(R.id.editTextName);
        phone=findViewById(R.id.editTextPhone);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty()){
                    name.setError("Empty");
                    name.requestFocus();
                } else if (phone.getText().toString().isEmpty()) {
                    phone.setError("Empty");
                    phone.requestFocus();
                }else{
                    uploadData();
                    Intent iHome=new Intent(UploadNotice.this,cropDetails.class);
                    iHome.putExtra("s",value);
                    startActivity(iHome);
                    finish();
                }

            }
        });

    }
    private void uploadData(){
        String kName=name.getText().toString();
        String kPhone=phone.getText().toString();
        String state=value;
        String crop="none";
        String cropDate="12";
        String cropMonth="12";
        String cropYear="2003";
        // ***********************************************calender for date*****************************************************
        Calendar calForDate= Calendar.getInstance();
        SimpleDateFormat currentDate=new SimpleDateFormat("dd-MM-yy");
        String date=currentDate.format(calForDate.getTime());
        //************************************************calender for time*******************************************************
        Calendar calForTime= Calendar.getInstance();
        SimpleDateFormat currentTime=new SimpleDateFormat("hh:mm a");
        String time=currentTime.format(calForTime.getTime());
        //**************************************************get uid from authentication of firebase********************************************
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid=user.getUid();
        NoticeData noticeData=new NoticeData(kName,date,time,userid,state,kPhone,crop,cropDate,cropMonth,cropYear);
        reference.child(userid).setValue(noticeData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                //Toast.makeText(UploadNotice.this, "Data added successfully", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UploadNotice.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

}