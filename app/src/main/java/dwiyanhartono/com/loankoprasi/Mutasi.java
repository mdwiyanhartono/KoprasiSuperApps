package dwiyanhartono.com.loankoprasi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Mutasi extends AppCompatActivity {

    TextView tglawal, tglakhir;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutasi);
        tglawal = findViewById(R.id.tglawal);
        tglakhir = findViewById(R.id.tglakhir);
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = month + "-" + dayOfMonth + "-" + year;
                tglawal.setText(date);

            }
        };
        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = month + "-" + dayOfMonth + "-" + year;
                tglakhir.setText(date);

            }
        };
    }


    public void back(View view) {
        Intent i = new Intent(this, BaseActivity.class);
        startActivity(i);
        finish();
    }

    private void dialogTanggal() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(
                Mutasi.this,
                android.R.style.Theme_Holo_Dialog_MinWidth,
                mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void dialogTanggal2() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(
                Mutasi.this,
                android.R.style.Theme_Holo_Dialog_MinWidth,
                mDateSetListener2,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void tanggalawal(View view) {
        dialogTanggal();
    }

    public void tanggallahir(View view) {
        dialogTanggal2();
    }
}