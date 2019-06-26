package com.mobileapps.week02day02app.Activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobileapps.week02day02app.Activities.CarRegistrationActivity;
import com.mobileapps.week02day02app.Models.Car;
import com.mobileapps.week02day02app.R;

public class MainActivity extends AppCompatActivity
{
    public static final int REQUEST_CODE = 100;
    ImageView imgMake, imgColor,imgTransmission;
    TextView tvMake, tvModel, tvYear, tvColor, tvEngineSize, tvTransmission;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgColor = findViewById(R.id.imgColor);
        imgMake = findViewById(R.id.imgMake);
        imgTransmission = findViewById(R.id.imgTransmission);

        tvMake = findViewById(R.id.tvMake);
        tvModel = findViewById(R.id.tvModels);
        tvYear = findViewById(R.id.tvYear);
        tvColor = findViewById(R.id.tvColor);
        tvEngineSize = findViewById(R.id.tvEngineSize);
        tvTransmission = findViewById(R.id.tvTransmission);

        setVisibilityOfTheViews(View.GONE);
    }

    private void setVisibilityOfTheViews(int visible)
    {
        imgColor.setVisibility(visible);
        imgMake.setVisibility(visible);
        imgTransmission.setVisibility(visible);

        tvMake.setVisibility(visible);
        tvModel.setVisibility(visible);
        tvYear.setVisibility(visible);
        tvColor.setVisibility(visible);
        tvEngineSize.setVisibility(visible);
        tvTransmission.setVisibility(visible);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null)
        {
            Bundle passedBundle = data.getExtras();
            Car passedCard = passedBundle.getParcelable("car");
            setVisibilityOfTheViews(View.VISIBLE);
            setMake(passedCard.getMake());
            tvModel.setText(passedCard.getModel());
            tvYear.setText(passedCard.getYear());
            setCarColor(passedCard.getColor());
            tvEngineSize.setText("Engine size\n     "+passedCard.getEngineSize());
            setTransmission(passedCard.getTransmissionType());
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setTransmission(String transmissionType)
    {
        switch (transmissionType)
        {
            case "Automatic":
                tvTransmission.setText(transmissionType);
                imgTransmission.setImageDrawable(getDrawable(R.drawable.automatic));
                break;

            case "Manual":
                tvTransmission.setText(transmissionType);
                imgTransmission.setImageDrawable(getDrawable(R.drawable.manual));
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setCarColor(String color)
    {
        switch (color)
        {
            case "Green":
                tvColor.setText(color);
                imgColor.setImageDrawable(getDrawable(R.color.green));
                break;
            case "Blue":
                tvColor.setText(color);
                imgColor.setImageDrawable(getDrawable(R.color.blue));
                break;
            case "Yellow":
                tvColor.setText(color);
                imgColor.setImageDrawable(getDrawable(R.color.yellow));
                break;
            case "Red":
                tvColor.setText(color);
                imgColor.setImageDrawable(getDrawable(R.color.red));
                break;
            case "Black":
                tvColor.setText(color);
                imgColor.setImageDrawable(getDrawable(R.color.black));
                break;
            case "White":
                tvColor.setText(color);
                imgColor.setImageDrawable(getDrawable(R.color.white));
                break;
            case "Gray":
                tvColor.setText(color);
                imgColor.setImageDrawable(getDrawable(R.color.gray));
                break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setMake(String make)
    {
        switch (make)
        {
            case "Audi":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.audi));
                break;
            case "BMW":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.bmw));
                break;
            case "Ford":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.ford));
                break;
            case "Holden":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.holden));
                break;
            case "Hyundai":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.hyundai));
                break;
            case "Kia":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.kia));
                break;
            case "Mazda":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.mazda));
                break;
            case "Mercedes":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.mercedes));
                break;
            case "Nissan":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.nissan));
                break;
            case "Peugeot":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.peugeot));
                break;
            case "Toyota":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.toyota));
                break;
            case "Volksagens":
                tvMake.setText(make);
                imgMake.setImageDrawable(getDrawable(R.drawable.volkswagen));
                break;

        }
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(this, CarRegistrationActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

}
