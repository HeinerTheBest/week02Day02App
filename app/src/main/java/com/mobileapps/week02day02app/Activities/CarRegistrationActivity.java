package com.mobileapps.week02day02app.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobileapps.week02day02app.Models.Car;
import com.mobileapps.week02day02app.R;

public class CarRegistrationActivity extends AppCompatActivity {

    String [] opcMake={"Audi","BMW","Ford","Holden","Hyundai","Kia","Mazda","Mercedes","Nissan","Peugeot","Toyota","Volksagens"};
    String [] opcColor={"Green","Blue","Yellow","Red","Black","White","Gray"};

    private final int RESULT_CODE = 777;

    Spinner spMake, spColor;
    EditText etModel, etYear, etEngineSize;
    RadioButton rbAutomatic, rbManual;
    Button btnRestart, btnSubmit;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_registration);

        spMake = findViewById(R.id.spMake);
        spColor = findViewById(R.id.spColor);
        etModel = findViewById(R.id.etModel);
        etYear = findViewById(R.id.etYear);
        etEngineSize = findViewById(R.id.etEngineSize);
        rbAutomatic = findViewById(R.id.rbAutomatic);
        rbManual = findViewById(R.id.rbManual);
        btnRestart = findViewById(R.id.btnRestart);
        btnSubmit = findViewById(R.id.btnSubmit);
        intent = getIntent();

        ArrayAdapter<String> adapterMake = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcMake);
        spMake.setAdapter(adapterMake);

        ArrayAdapter<String> adapterColor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcColor);
        spColor.setAdapter(adapterColor);

    }

    public void submit(View view)
    {
        if(allFill())
        {
            String make = String.valueOf(spMake.getSelectedItem());
            String model = etModel.getText().toString();
            String year = etYear.getText().toString();
            String color = String.valueOf(spColor.getSelectedItem());
            String transmissionType;
            if(rbAutomatic.isChecked()) {
                transmissionType = "Automatic";
            }else
                transmissionType = "Manual";
            String engineSize = etEngineSize.getText().toString();

            Car car = new Car(make,model,year,color,transmissionType,engineSize);

            Bundle bundle = new Bundle();
            bundle.putParcelable("car",car);

            intent.putExtras(bundle);
            setResult(RESULT_CODE,intent);
            finish();
        }
    }

    public void restart(View view)
    {
        etModel.setText("");
        etYear.setText("");
        etEngineSize.setText("");
    }

    private boolean allFill()
    {
        if(etModel.getText().toString().isEmpty())
        {
            showToast("Enter the Model");
            return false;
        }
        if(etYear.getText().toString().isEmpty())
        {
            showToast("Enter the Year");
            return false;
        }
        if(etEngineSize.getText().toString().isEmpty())
        {
            showToast("Enter the Engine size");
            return false;
        }
        return true;
    }

    private void showToast(String text)
    {
        Toast toast=Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT);
        toast.setMargin(50,50);
        toast.show();
    }


}
