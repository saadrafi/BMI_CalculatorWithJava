package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  android.widget.Button gotobmi;
  TextView mcurrentHeight,mcurrentage,mcurrentweight;
  ImageView mincrementAge,mincrementWeight,mdecrementAge,mdecrementWeight;
  SeekBar mseekbar_height;
  RelativeLayout mMale,mFemale;

  int intWeigth=55;
  int intAge = 22;
  int currentProgress;
  String mintProgress ="170";
  String typeOfUser = "0";
  String weight2 = "55";
  String age2 ="22";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        gotobmi =findViewById(R.id.calculatebmi);

        mcurrentage = findViewById(R.id.currentage);
        mcurrentHeight = findViewById(R.id.currentheight);
        mcurrentweight = findViewById(R.id.currentweight);
        mincrementAge = findViewById(R.id.incrementage);
        mincrementWeight = findViewById(R.id.incremetweight);
        mdecrementAge =findViewById(R.id.decrementage);
        mdecrementWeight = findViewById(R.id.decrementweight);
        mseekbar_height =findViewById(R.id.seekbarforheight);
        mMale =findViewById(R.id.male);
        mFemale =findViewById(R.id.female);




        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeOfUser="Male";
            }
        });

        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeOfUser="Female";
            }
        });



        mseekbar_height.setMax(300);
        mseekbar_height.setProgress(170);

        mseekbar_height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress=progress;
                mintProgress = String.valueOf(currentProgress);
                mcurrentHeight.setText(mintProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mincrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge++;
                age2 = String.valueOf(intAge);
                mcurrentage.setText(age2);
            }
        });
        mdecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intAge > 0) {
                    intAge--;
                    age2 = String.valueOf(intAge);
                    mcurrentage.setText(age2);
                }else {
                    Toast.makeText(getApplicationContext(), "Age Can Not be Negative", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mincrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeigth++;
                weight2 = String.valueOf(intWeigth);
                mcurrentweight.setText(weight2);
            }
        });

        mdecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intWeigth > 0) {
                    intWeigth--;
                    weight2 = String.valueOf(intWeigth);
                    mcurrentweight.setText(weight2);
                }else{
                    Toast.makeText(getApplicationContext(), "Weight Can't be negative", Toast.LENGTH_SHORT).show();
                }
            }
        });





        gotobmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeOfUser.equals("0"))
                {
                    Toast.makeText(MainActivity.this,"Select Your Gender",Toast.LENGTH_SHORT).show();
                }else if (mintProgress.equals("0"))
                {
                    Toast.makeText(MainActivity.this, "Select Your Height", Toast.LENGTH_SHORT).show();
                }else{

                    Log.d("data",mintProgress);
                    Log.d("data",weight2);
                    Log.d("data",typeOfUser);
                    Log.d("data",age2);
                    bmiModel bmiModel = new bmiModel(mintProgress,weight2,typeOfUser,age2);


                    Intent intent = new Intent(MainActivity.this,bmiActivity.class);
                    intent.putExtra("data",bmiModel);
                    startActivity(intent);
                }



            }
        });
    }
}