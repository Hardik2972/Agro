package com.hardikgarg.agro;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class update_adapter extends RecyclerView.Adapter<myviewholder> {
    ArrayList<Model> data;
    Context context;

    public update_adapter(Context context,ArrayList<Model> data) {
        this.data = data;
        this.context=context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator= LayoutInflater.from(parent.getContext());
        View view=inflator.inflate(R.layout.single_row,parent,false);
        return new myviewholder(view);
    }
    public void update(String crop){
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid=user.getUid();
        reference.child(userid).child("crop").setValue(crop);
        reference.child(userid).child("cropDate").setValue("12");
        reference.child(userid).child("cropMonth").setValue("12");
        reference.child(userid).child("cropYear").setValue("2003");
    }
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final Model temp1 = data.get(position);
        holder.t1.setText(data.get(position).getHeader());
        holder.img.setImageResource(data.get(position).getImage());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(temp1.getHeader().equals("Bell Pepper")){
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, BellMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeader().equals("Sugarcane")) {
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, SugarcaneMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
                else if (temp1.getHeader().equals("Tea")) {
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, TeaMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeader().equals("Coffee")) {
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, CoffeeMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeader().equals("Lavendar")) {
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, LavendarMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeader().equals("Lettuce")) {
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, LettuceMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeader().equals("Ginger")) {
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, GingerMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeader().equals("Garlic")) {
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, GarlicMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeader().equals("Broccoli")) {
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, BroccoliMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeader().equals("Sunflower")) {
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, SunflowerMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeader().equals("Tomato")) {
                    update(temp1.getHeader());
                    Intent intent=new Intent(context, TomatoMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
//                    Intent intent = new Intent(context,YourCropActivity.class);
//                    intent.putExtra("image",temp1.getImage());
//                    intent.putExtra("heading",temp1.getHeader());
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}


