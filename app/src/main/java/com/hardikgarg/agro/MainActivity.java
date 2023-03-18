package com.hardikgarg.agro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
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



        bnv=findViewById(R.id.bottomNavigationView);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            Intent iHome=new Intent(MainActivity.this, RegisterActivity.class);
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.your_crop){
                    loadFrag(new fragment_yourcrop(),true);
                }else if(id==(R.id.you)) {
                    Intent iHome=new Intent(MainActivity.this,You.class);
                    startActivity(iHome);
                }else{
                    loadFrag(new fragment_community(),false);
                }

                return true;
            }
        });
    }
    public void loadFrag(Fragment fragment, boolean b){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(b){
            ft.add(R.id.container,fragment);
        }
        else{
            ft.replace(R.id.container,fragment);
        }

        ft.commit();
    }
}