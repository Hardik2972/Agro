package com.hardikgarg.agro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
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

import java.util.Calendar;

public class BroccoliMainActivity extends AppCompatActivity {
    Button b;
    TextView t1;
    int d;
    int y;
    int m;
    ImageView cropImage,calenderImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broccoli_main);
        cropImage=findViewById(R.id.idCropImage);
        BottomNavigationView bnv=findViewById(R.id.bottomNavigationView);
        bnv.setSelectedItemId(R.id.home);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
//                        FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
//                        String userid1 = user1.getUid();
//                        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("users");
//                        reference1.addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                String cropFromDb=snapshot.child(userid1).child("crop").getValue(String.class);
//                                if(cropFromDb.equals("Tomato")){
//                                    startActivity(new Intent(getApplicationContext(), TomatoMainActivity.class));
//                                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
//                                    finish();
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//
//                            }
//                        });
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
                        startActivity(new Intent(getApplicationContext(),You.class));
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        finish();
                        return true;
                }
                return false;
            }
        });
//        b = findViewById(R.id.idChangeCrop);
        Calendar calendar=Calendar.getInstance();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("users");
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String userid=user.getUid();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dateFromDb=snapshot.child(userid).child("cropDate").getValue(String.class);
                String monthFromDb=snapshot.child(userid).child("cropMonth").getValue(String.class);
                String yearFromDb=snapshot.child(userid).child("cropYear").getValue(String.class);
                String stateFromDb=snapshot.child(userid).child("state").getValue(String.class);
                String crop=snapshot.child(userid).child("crop").getValue(String.class);
                if(crop.equals("none")){
                    Dialog dialog=new Dialog(BroccoliMainActivity.this);
                    dialog.setContentView(R.layout.dialog_crop);
                    dialog.setCancelable(false);
                    Button btnOkay=dialog.findViewById(R.id.idSelectCrop);
                    btnOkay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(BroccoliMainActivity.this,CropChoose.class);
                            intent.putExtra("state",stateFromDb);
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
                else if (dateFromDb.equals("12") && monthFromDb.equals("12") && yearFromDb.equals("2003")) {
                    Dialog dialog=new Dialog(BroccoliMainActivity.this);
                    dialog.setContentView(R.layout.dialog_calendar);
                    dialog.setCancelable(false);
                    Button btnOkay=dialog.findViewById(R.id.idSelectDate);
                    btnOkay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            y=calendar.get(Calendar.YEAR);
                            d=calendar.get(Calendar.DAY_OF_MONTH);
                            m=calendar.get(Calendar.MONTH);
                            DatePickerDialog g=new DatePickerDialog(BroccoliMainActivity.this, new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                    String cropDate=i2+"";
                                    String cropMonth=i1+1+"";
                                    String cropYear=i+"";

                                    reference.child(userid).child("cropDate").setValue(cropDate);
                                    reference.child(userid).child("cropMonth").setValue(cropMonth);
                                    reference.child(userid).child("cropYear").setValue(cropYear);
                                }
                            },y,m,d);
                            g.show();
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        calenderImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                y=calendar.get(Calendar.YEAR);
//                d=calendar.get(Calendar.DAY_OF_MONTH);
//                m=calendar.get(Calendar.MONTH);
//                DatePickerDialog g=new DatePickerDialog(MainActivity2.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//                        String cropDate=i2+"";
//                        String cropMonth=i1+"";
//                        String cropYear=i+"";
//
//                        reference.child(userid).child("cropDate").setValue(cropDate);
//                        reference.child(userid).child("cropMonth").setValue(cropMonth);
//                        reference.child(userid).child("cropYear").setValue(cropYear);
//                    }
//                },y,m,d);
//                g.show();
//
//
//            }
//        });
        reference.addValueEventListener(new ValueEventListener() {
            TextView d1,d2,d3,d4,d5,d6,d7,d8,d9,d11,d10,d12,d13;
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String dateFromDb=snapshot.child(userid).child("cropDate").getValue(String.class);
                String monthFromDb=snapshot.child(userid).child("cropMonth").getValue(String.class);
                String yearFromDb=snapshot.child(userid).child("cropYear").getValue(String.class);
                Calendar cal=Calendar.getInstance();
                int date1,date2,date3,date4,date5,date6,date7,date8,date9,date10,date11,date12,date13;
                int month1,month2,month3,month4,month5,month6,month7,month8,month9,month10,month11,month12,month13;
                date1=Integer.parseInt(dateFromDb);
                date2=Integer.parseInt(dateFromDb);
                date3=Integer.parseInt(dateFromDb);
                date4=Integer.parseInt(dateFromDb);
                date5=Integer.parseInt(dateFromDb);
                date6=Integer.parseInt(dateFromDb);
                date7=Integer.parseInt(dateFromDb);
                date8=Integer.parseInt(dateFromDb);
                date9=Integer.parseInt(dateFromDb);
                date10=Integer.parseInt(dateFromDb);
                date11=Integer.parseInt(dateFromDb);
                date12=Integer.parseInt(dateFromDb);
                date13=Integer.parseInt(dateFromDb);
                month1=Integer.parseInt(monthFromDb);
                month2=Integer.parseInt(monthFromDb);
                month3=Integer.parseInt(monthFromDb);
                month4=Integer.parseInt(monthFromDb);
                month5=Integer.parseInt(monthFromDb);
                month6=Integer.parseInt(monthFromDb);
                month7=Integer.parseInt(monthFromDb);
                month8=Integer.parseInt(monthFromDb);
                month9=Integer.parseInt(monthFromDb);
                month10=Integer.parseInt(monthFromDb);
                month11=Integer.parseInt(monthFromDb);
                month12=Integer.parseInt(monthFromDb);
                month13=Integer.parseInt(monthFromDb);
                //1
                if(date1-28<0 || date1-28==0){
                    date1=date1+2;
                    month1=month1-1;
                }
                else{
                    date1=date1-28;
                }
                //2
                if(date2-21<0 || date2-21==0){
                    date2=date2+9;
                    month2=month2-1;
                }
                else{
                    date2=date2-21;
                }
                //3
                if(date3-14<0 || date3-14==0){
                    date3=date3+16;
                    month3=month3-1;
                }
                else{
                    date3=date3-14;
                }
                //4
                if(date4-7<0 || date4-7==0){
                    date4=date4+23;
                    month4=month4-1;
                }
                else{
                    date4=date4-7;
                }
                //6
                if(date6+7>30 || date6+7==30){
                    date6=date6+7-30;
                    month6=month6+1;
                }
                else{
                    date6=date6+7;
                }
                //7
                if(date7+70>30 || date7+70==30){
                    month7=month7+(date7+70)/30;
                    if((date7+70)/30!=0){
                        date7=date7+70-(((date7+70)/30))*30;
                    }


                }
                else{
                    date7=date7+7;
                }
                //8
                if(date8+77>30 || date8+77==30){

                    month8=month8+(date8+77)/30;
                    if((date8+77)/30!=0){
                        date8=date8+77-(((date8+77)/30))*30;
                    }
                }
                else{
                    date8=date8+7;
                }
                //9
                if(date9+98>30 || date9+98==30){

                    month9=month9+(date9+98)/30;
                    if((date9+98)/30!=0){
                        date9=date9+98-(((date9+98)/30))*30;
                    }
                }
                else{
                    date9=date9+98;
                }
                //10
                if(date10+105>30 || date10+105==30){

                    month10=month10+(date10+105)/30;
                    if((date10+105)/30!=0){
                        date10=date10+105-(((date10+105)/30))*30;
                    }
                }
                else{
                    date10=date10+105;
                }
                //11
                if(date11+112>30 || date11+112==30){

                    month11=month11+(date11+112)/30;
                    if((date11+112)/30!=0){
                        date11=date11+112-(((date11+112)/30))*30;
                    }
                }
                else{
                    date11=date11+112;
                }
                //12
                if(date12+126>30 || date12+126==30){

                    month12=month12+(date12+126)/30;
                    if((date12+126)/30!=0){
                        date12=date12+126-(((date12+126)/30))*30;
                    }
                }
                else{
                    date12=date12+126;
                }
                //13
                if(date13+133>30 || date13+133==30){

                    month13=month13+(date13+133)/30;
                    if((date13+133)/30!=0){
                        date13=date13+133-(((date13+133)/30))*30;
                    }
                }
                else{
                    date13=date13+133;
                }
                String da1=String.valueOf(date1);
                String da2=String.valueOf(date2);
                String da3=String.valueOf(date3);
                String da4=String.valueOf(date4);
                String da5=String.valueOf(date5);
                String da6=String.valueOf(date6);
                String da7=String.valueOf(date7);
                String da8=String.valueOf(date8);
                String da9=String.valueOf(date9);
                String da10=String.valueOf(date10);
                String da11=String.valueOf(date11);
                String da12=String.valueOf(date12);
                String da13=String.valueOf(date13);
                String ma1=String.valueOf(month1);
                String ma2=String.valueOf(month2);
                String ma3=String.valueOf(month3);
                String ma4=String.valueOf(month4);
                String ma5=String.valueOf(month5);
                String ma6=String.valueOf(month6);
                String ma7=String.valueOf(month7);
                String ma8=String.valueOf(month8);
                String ma9=String.valueOf(month9);
                String ma10=String.valueOf(month10);
                String ma11=String.valueOf(month11);
                String ma12=String.valueOf(month12);
                String ma13=String.valueOf(month13);
                d1=findViewById(R.id.idDate1WeekBefore);
                d2=findViewById(R.id.idDate2WeekBefore);
                d3=findViewById(R.id.idDate3WeekBefore);
                d4=findViewById(R.id.idDate4WeekBefore);
                d5=findViewById(R.id.idDate5WeekBefore);
                d6=findViewById(R.id.idDate6WeekBefore);
                d7=findViewById(R.id.idDate7WeekBefore);
                d8=findViewById(R.id.idDate8WeekBefore);
                d9=findViewById(R.id.idDate9WeekBefore);
                d10=findViewById(R.id.idDate10WeekBefore);
                d11=findViewById(R.id.idDate11WeekBefore);
                d12=findViewById(R.id.idDate12WeekBefore);
                d13=findViewById(R.id.idDate13WeekBefore);
                d1.setText("Date:"+da1+"/"+ma1);
                d2.setText("Date:"+da2+"/"+ma2);
                d3.setText("Date:"+da3+"/"+ma3);
                d4.setText("Date:"+da4+"/"+ma4);
                d5.setText("Date:"+da5+"/"+ma5);
                d6.setText("Date:"+da6+"/"+ma6);
                d7.setText("Date:"+da7+"/"+ma7);
                d8.setText("Date:"+da8+"/"+ma8);
                d9.setText("Date:"+da9+"/"+ma9);
                d10.setText("Date:"+da10+"/"+ma10);
                d11.setText("Date:"+da11+"/"+ma11);
                d12.setText("Date:"+da12+"/"+ma12);
                d13.setText("Date:"+da13+"/"+ma13);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t12;
        t1=findViewById(R.id.idTV1Expand);
        findViewById(R.id.card1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t1.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t1.setVisibility(v);
            }
        });
        t2=findViewById(R.id.idTV2Expand);
        findViewById(R.id.card2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t2.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t2.setVisibility(v);
            }
        });
        t3=findViewById(R.id.idTV3Expand);
        findViewById(R.id.card3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t3.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t3.setVisibility(v);
            }
        });
        t4=findViewById(R.id.idTV4Expand);
        findViewById(R.id.card4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t4.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t4.setVisibility(v);
            }
        });
        t5=findViewById(R.id.idTV5Expand);
        findViewById(R.id.card5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t5.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t5.setVisibility(v);
            }
        });
        t6=findViewById(R.id.idTV6Expand);
        findViewById(R.id.card6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t6.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t6.setVisibility(v);
            }
        });
        t7=findViewById(R.id.idTV7Expand);
        findViewById(R.id.card7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t7.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t7.setVisibility(v);
            }
        });
        t8=findViewById(R.id.idTV8Expand);
        findViewById(R.id.card8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t8.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t8.setVisibility(v);
            }
        });
        t9=findViewById(R.id.idTV9Expand);
        findViewById(R.id.card9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t9.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t9.setVisibility(v);
            }
        });
        t10=findViewById(R.id.idTV10Expand);
        findViewById(R.id.card10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t10.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t10.setVisibility(v);
            }
        });
        t12=findViewById(R.id.idTV12Expand);
        findViewById(R.id.card12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v=(t12.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
                t12.setVisibility(v);
            }
        });






    }
}