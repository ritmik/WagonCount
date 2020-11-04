package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button bt;
    EditText ed;
    String sss="empty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView_tv1);
        bt = findViewById(R.id.button);
        ed = findViewById(R.id.editText_ed1);
        bt.setOnClickListener(v -> fn());
//        if(arrayList.size() > 620) {
//            Toast toast = Toast.makeText(getApplicationContext(),"защита сработала!", Toast.LENGTH_SHORT);
//            toast.show();
//            break; //защита
//        }
    }
    RandomTrain randomTrain = new RandomTrain();
    void fn(){
        randomTrain.reCreate();
        findCountWagon();
        tv.setText("randomTrain = "+ randomTrain.len + " finded="+lenWagon);
    }
    public int lenWagon;
    void findCountWagon(){
        boolean wagon;
        ArrayList<Boolean> arrayList = new ArrayList<>();
        while (true){
            wagon = randomTrain.getNextWagon();
            arrayList.add(wagon);

            //if((arrayList.size() > 190) && (arrayList.size() % 2) == 0){
            if((arrayList.size() % 2) == 0){
                //делим массив попалам и XOR
                boolean XORtrue = false;
                int sizeDev2 = arrayList.size()/2;
                for(int i=0; i < sizeDev2; i++){
                    if (arrayList.get(i) ^ arrayList.get(i+sizeDev2)){
                        XORtrue = true;
                        break;
                    }
                }
                if(!XORtrue) {
                    lenWagon = sizeDev2;//результат готов
                    break;
                }
            }
        }
    }

}