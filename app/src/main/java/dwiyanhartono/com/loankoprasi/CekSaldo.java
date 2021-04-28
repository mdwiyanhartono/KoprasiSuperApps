package dwiyanhartono.com.loankoprasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CekSaldo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_saldo);
    }

    public void back(View view) {
        Intent i = new Intent(this, BaseActivity.class);
        startActivity(i);
        finish();
    }
}