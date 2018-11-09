package com.blogspot.creaxiom.barvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate;
    private TextView tvResult;

    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(STATE_HASIL, tvResult.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth = (EditText)findViewById(R.id.edt_width);
        edtHeight = (EditText)findViewById(R.id.edt_height);
        edtLength = (EditText)findViewById(R.id.edt_length);
        btnCalculate = (Button)findViewById(R.id.btn_calculate);
        tvResult = (TextView)findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String length = edtLength.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(length)) {
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(width)) {
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(height)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l * w * h;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}
