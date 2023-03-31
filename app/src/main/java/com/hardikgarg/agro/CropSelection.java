package com.hardikgarg.agro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class CropSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_selection);
        ImageView bell=(ImageView)findViewById(R.id.iV1);
        ImageView sunflower=(ImageView)findViewById(R.id.iV2);
        ImageView tea=(ImageView)findViewById(R.id.iV3);
        ImageView garlic=(ImageView)findViewById(R.id.iV4);
        ImageView ginger=(ImageView)findViewById(R.id.iV5);
        ImageView tomato=(ImageView)findViewById(R.id.iV6);
        ImageView lettuce=(ImageView)findViewById(R.id.iV7);
        ImageView broccoli=(ImageView)findViewById(R.id.iV8);
        ImageView coffee=(ImageView)findViewById(R.id.iV9);
        ImageView lavendar=(ImageView)findViewById(R.id.iV10);
        ImageView sugarcane=(ImageView)findViewById(R.id.iV11);

        String state=getIntent().getStringExtra("s");
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
        if(state.equals(state1)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
        }
        else if(state.equals(state2)){
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
        }
        else if(state.equals(state3)){
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
        }
        else if(state.equals(state4)){
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
        }
        else if(state.equals(state5)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
        }
        else if(state.equals(state6)){
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
        }
        else if(state.equals(state7)){
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);
        }
        else if(state.equals(state8)){
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state9)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state10)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state11)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state12)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state13)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state14)){
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state15)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state16)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state17)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state18)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state19)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state20)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state21)){
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state22)){
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state23)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state24)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state25)){
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state26)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)garlic.getParent()).removeView(garlic);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }
        else if(state.equals(state27)){
            ((ViewGroup)bell.getParent()).removeView(bell);
            ((ViewGroup)tomato.getParent()).removeView(tomato);
            ((ViewGroup)broccoli.getParent()).removeView(broccoli);
            ((ViewGroup)lavendar.getParent()).removeView(lavendar);
            ((ViewGroup)tea.getParent()).removeView(tea);
            ((ViewGroup)ginger.getParent()).removeView(ginger);
            ((ViewGroup)coffee.getParent()).removeView(coffee);
            ((ViewGroup)sugarcane.getParent()).removeView(sugarcane);
            ((ViewGroup)sunflower.getParent()).removeView(sunflower);
            ((ViewGroup)lettuce.getParent()).removeView(lettuce);

        }

    }
}