package com.hardikgarg.agro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class YourCropActivity extends AppCompatActivity {
    RecyclerView recView;
    Button b;
    ArrayList<Model> holder=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_crop);
        recView=findViewById(R.id.idRecView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recView.setLayoutManager(layoutManager);
        String header=getIntent().getStringExtra("heading");
        if(header.equals("Bell pepper")){
            Model obj12 = new Model();
            obj12.setImage(R.drawable.bell);
            obj12.setHeader(header);
            holder.add(obj12);
            your_adapter adapter=new your_adapter(holder);
            recView.setAdapter(adapter);
        }

        b=findViewById(R.id.btnOpenDialog);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
//    public ArrayList<Model> dataqueue(){
//        ArrayList<Model> holder=new ArrayList<>();
//        Model obj1=new  Model();
//        obj1.setHeader("BELL PEPPER");
//        obj1.setImage(R.drawable.bell);
//        holder.add(obj1);
//
//        Model obj2=new  Model();
//        obj2.setHeader("BELL PEPPER");
//        obj2.setImage(R.drawable.tomato);
//        holder.add(obj2);
//
//        Model obj3=new  Model();
//        obj3.setHeader("BELL PEPPER");
//        obj3.setImage(R.drawable.garlic);
//        holder.add(obj3);
//
//        Model obj4=new  Model();
//        obj4.setHeader("BELL PEPPER");
//        obj4.setImage(R.drawable.ginger);
//        holder.add(obj4);
//
//        Model obj5=new  Model();
//        obj5.setHeader("BELL PEPPER");
//        obj5.setImage(R.drawable.lavendar);
//        holder.add(obj5);
//
//        Model obj6=new  Model();
//        obj6.setHeader("BELL PEPPER");
//        obj6.setImage(R.drawable.lettuce);
//        holder.add(obj6);
//
//        Model obj7=new  Model();
//        obj7.setHeader("BELL PEPPER");
//        obj7.setImage(R.drawable.tea);
//        holder.add(obj7);
//
//        Model obj8=new  Model();
//        obj8.setHeader("BELL PEPPER");
//        obj8.setImage(R.drawable.broccoli);
//        holder.add(obj8);
//
//        Model obj9=new  Model();
//        obj9.setHeader("BELL PEPPER");
//        obj9.setImage(R.drawable.coffee);
//        holder.add(obj9);
//
//        Model obj10=new  Model();
//        obj10.setHeader("BELL PEPPER");
//        obj10.setImage(R.drawable.sunflower);
//        holder.add(obj10);
//
//        Model obj11=new  Model();
//        obj11.setHeader("BELL PEPPER");
//        obj11.setImage(R.drawable.sugarcane);
//        holder.add(obj11);
//
//        return holder;
//    }
}