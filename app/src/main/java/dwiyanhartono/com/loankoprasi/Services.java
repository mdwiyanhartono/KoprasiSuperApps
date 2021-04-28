package dwiyanhartono.com.loankoprasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dwiyanhartono.com.loankoprasi.Adapater.AdapterFood;
import dwiyanhartono.com.loankoprasi.Data.DataFood;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Services extends AppCompatActivity implements AdapterFood.OnItemClickListener {

    RecyclerView rc1;
    AdapterFood adapterFood;
    private List<DataFood> food = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rc1 = findViewById(R.id.rc1);
        rc1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rc1.setItemAnimator(new DefaultItemAnimator());
        adapterFood = new AdapterFood(this);
        food.add(new DataFood(R.drawable.serviceac,"Service AC","Service","4.2","0.5"));
        food.add(new DataFood(R.drawable.laundry,"Laundry","Clothes","4.2","1.5"));
        food.add(new DataFood(R.drawable.serviceel,"Service Electrical","Electricity","4.0","0.2"));
        adapterFood.setData(food);
        rc1.setAdapter(adapterFood);
    }

    @Override
    public void Detail(int Image, String labelname, String labelkategory, String bintang, String Jarak) {

    }
}