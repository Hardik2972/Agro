package com.hardikgarg.agro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>{
    Context context;
    ArrayList<ContactModel> arrContacts;




    RecyclerContactAdapter(Context context,ArrayList<ContactModel> arrContacts){
        this.context=context;
        this.arrContacts=arrContacts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.news_rv_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ContactModel temp1 = arrContacts.get(position);
        holder.image.setImageResource(arrContacts.get(position).img);
        holder.heading.setText(arrContacts.get(position).heading);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(temp1.getHeading().equals("Bell Pepper")){
                    Intent intent = new Intent(context,Bell.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeading().equals("Sugarcane")) {
                    Intent intent = new Intent(context,Sugarcane.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeading().equals("Tea")) {
                    Intent intent = new Intent(context,Tea.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeading().equals("Coffee")) {
                    Intent intent = new Intent(context,Coffee.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeading().equals("Lavendar")) {
                    Intent intent = new Intent(context,Lavendar.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeading().equals("Lettuce")) {
                    Intent intent = new Intent(context,Lettuce.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeading().equals("Ginger")) {
                    Intent intent = new Intent(context,Ginger.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeading().equals("Garlic")) {
                    Intent intent = new Intent(context,Garlic.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeading().equals("Broccoli")) {
                    Intent intent = new Intent(context,Broccoli.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeading().equals("Sunflower")) {
                    Intent intent = new Intent(context,Sunflower.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (temp1.getHeading().equals("Tomato")) {
                    Intent intent = new Intent(context,Tomato.class);
                    intent.putExtra("image",temp1.getImg());
                    intent.putExtra("heading",temp1.getHeading());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView heading;
        ImageView image;
        public ViewHolder(View view){
            super(view);
            heading = (view).findViewById(R.id.idTVNewsHeading);
            image = (view).findViewById(R.id.idIVNews);
        }
    }
}
