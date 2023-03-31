package com.hardikgarg.agro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CropChoose extends AppCompatActivity {
    RecyclerView recView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_choose);
        recView1=findViewById(R.id.idRecView1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recView1.setLayoutManager(gridLayoutManager);
        update_adapter adapter=new update_adapter(this,dataqueue());
        recView1.setAdapter(adapter);
    }
    public ArrayList<Model> dataqueue(){
        String state = getIntent().getStringExtra("state");
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

        ArrayList<Model> holder=new ArrayList<>();
        Model obj1=new  Model();
        obj1.setHeader("Bell pepper");
        obj1.setImage(R.drawable.bell);

        Model obj11=new  Model();
        obj11.setHeader("Tomato");
        obj11.setImage(R.drawable.tomato);

        Model obj8=new  Model();
        obj8.setHeader("Garlic");
        obj8.setImage(R.drawable.garlic);

        Model obj7=new  Model();
        obj7.setHeader("Ginger");
        obj7.setImage(R.drawable.ginger);

        Model obj5=new  Model();
        obj5.setHeader("Lavendar");
        obj5.setImage(R.drawable.lavendar);

        Model obj6=new  Model();
        obj6.setHeader("Lettuce");
        obj6.setImage(R.drawable.lettuce);

        Model obj3=new  Model();
        obj3.setHeader("Tea");
        obj3.setImage(R.drawable.tea);

        Model obj9=new  Model();
        obj9.setHeader("Broccoli");
        obj9.setImage(R.drawable.broccoli);

        Model obj4=new  Model();
        obj4.setHeader("Coffee");
        obj4.setImage(R.drawable.coffee);

        Model obj10=new  Model();
        obj10.setHeader("Sunflower");
        obj10.setImage(R.drawable.sunflower);

        Model obj2=new  Model();
        obj2.setHeader("Sugarcane");
        obj2.setImage(R.drawable.sugarcane);

        if(state1.equals(state)){
            holder.add(obj11);
            holder.add(obj4);
            holder.add(obj10);
            holder.add(obj7);
            holder.add(obj8);
        }
        else if (state.equals(state2)) {
            holder.add(obj1);
            holder.add(obj8);
            holder.add(obj7);
            holder.add(obj3);
            holder.add(obj4);
        }
        else if (state.equals(state3)) {
            holder.add(obj11);
            holder.add(obj3);
            holder.add(obj10);
            holder.add(obj1);
            holder.add(obj7);
            holder.add(obj8);

        }
        else if (state.equals(state4)) {
            holder.add(obj2);
            holder.add(obj11);
            holder.add(obj4);
            holder.add(obj1);
            holder.add(obj10);

        }
        else if (state.equals(state5)) {
            holder.add(obj10);
            holder.add(obj6);
        }
        else if (state.equals(state6)) {
            holder.add(obj1);
            holder.add(obj6);
            holder.add(obj2);
            holder.add(obj11);
            holder.add(obj3);
            holder.add(obj4);
        }
        else if (state.equals(state7)) {
            holder.add(obj1);
            holder.add(obj2);
            holder.add(obj3);
            holder.add(obj4);
            holder.add(obj7);
        }
        else if (state.equals(state8)) {
            holder.add(obj1);
            holder.add(obj2);
            holder.add(obj11);
            holder.add(obj3);
            holder.add(obj7);
            holder.add(obj8);
            holder.add(obj9);
        }
        else if (state.equals(state9)) {
            holder.add(obj8);
            holder.add(obj10);
        }
        else if (state.equals(state10)) {
            holder.add(obj8);
            holder.add(obj10);
            holder.add(obj11);

        }
        else if (state.equals(state11)) {
            holder.add(obj3);
            holder.add(obj5);
        }
        else if (state.equals(state12)) {
            holder.add(obj5);
        }
        else if (state.equals(state13)) {
            holder.add(obj8);
            holder.add(obj10);
            holder.add(obj5);
        }
        else if (state.equals(state14)) {
            holder.add(obj1);
            holder.add(obj7);
            holder.add(obj2);
            holder.add(obj3);
            holder.add(obj4);
            holder.add(obj10);
        }
        else if (state.equals(state15)) {
            holder.add(obj7);
            holder.add(obj2);
            holder.add(obj11);
            holder.add(obj8);
        }
        else if (state.equals(state16)) {
            holder.add(obj2);
        }
        else if (state.equals(state17)) {
            holder.add(obj2);
        }
        else if (state.equals(state18)) {
            holder.add(obj8);
            holder.add(obj7);
            holder.add(obj11);
        }
        else if (state.equals(state19)) {
            holder.add(obj11);
        }
        else if (state.equals(state20)) {
            holder.add(obj11);
            holder.add(obj10);
        }
        else if (state.equals(state21)) {
            holder.add(obj3);
            holder.add(obj4);
            holder.add(obj1);
        }
        else if (state.equals(state22)) {
            holder.add(obj3);
            holder.add(obj1);
        }
        else if (state.equals(state23)) {
            holder.add(obj3);
            holder.add(obj7);
        }
        else if (state.equals(state24)) {
            holder.add(obj4);
            holder.add(obj3);
        }
        else if (state.equals(state25)) {
            holder.add(obj7);
            holder.add(obj4);
            holder.add(obj1);
        }
        else if (state.equals(state26)) {
            holder.add(obj4);
        }
        else if (state.equals(state27)) {
            holder.add(obj8);
        }

        return holder;
    }
}