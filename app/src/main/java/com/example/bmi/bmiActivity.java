package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiActivity extends AppCompatActivity {
    android.widget.Button reCalculate;

    TextView mbmiDisplay,mbmiCategory,mGender;
    ImageView mImageView;
   bmiModel bmiModel;
    String mbmi;
    String height,weight;
    float intBmi;
    float intHeight,intWeight;
    RelativeLayout mBackground;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        reCalculate = findViewById(R.id.gotomain);
        mbmiDisplay=findViewById(R.id.bmidisplay);
        mbmiCategory =findViewById(R.id.bmicategorydispaly);
        mGender =findViewById(R.id.genderdisplay);
        mBackground = findViewById(R.id.contentlayout);
        mImageView =findViewById(R.id.imageview);

        i=getIntent();

        bmiModel bmiModel=(bmiModel) i.getSerializableExtra("data");

         height=bmiModel.getHeight();
         weight = bmiModel.getWeight();


        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);


        intHeight = intHeight/100;

        intBmi = intWeight/(intHeight*intHeight);

        mbmi = Float.toString(intBmi);

        mGender.setText(bmiModel.getGender());
        mbmiDisplay.setText(mbmi);

        if (intBmi<16)
        {
            mbmiCategory.setText("Severe Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.crosss);
        }else  if (intBmi<16.9&&intBmi>16)
        {
            mbmiCategory.setText("Moderate Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }else if (intBmi<18&&intBmi>17)
        {
            mbmiCategory.setText("Mild Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }else if (intBmi<25&&intBmi>18.4)
        {
            mbmiCategory.setText("Normal");
            mImageView.setImageResource(R.drawable.ok);
        }else  if (intBmi<29.4&&intBmi>25)
        {
            mbmiCategory.setText("Overweight");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }else {
            mbmiCategory.setText("Too Much Overweight");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }



    }


    public void gotoMain(View view) {
        Intent intent = new Intent(bmiActivity.this,MainActivity.class);
        startActivity(intent);
    }
}