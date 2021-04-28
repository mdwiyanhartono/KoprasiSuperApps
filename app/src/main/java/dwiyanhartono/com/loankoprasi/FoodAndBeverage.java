package dwiyanhartono.com.loankoprasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dwiyanhartono.com.loankoprasi.Adapater.AdapterFood;
import dwiyanhartono.com.loankoprasi.Adapater.AdapterPromo;
import dwiyanhartono.com.loankoprasi.Data.DataFood;
import dwiyanhartono.com.loankoprasi.Data.DataPromo;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FoodAndBeverage extends AppCompatActivity implements AdapterFood.OnItemClickListener {

    RecyclerView rc1;
    AdapterFood adapterFood;
    private List<DataFood> food = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_and_beverage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rc1 = findViewById(R.id.rc1);
        rc1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rc1.setItemAnimator(new DefaultItemAnimator());
        adapterFood = new AdapterFood(this);
        food.add(new DataFood(R.drawable.makanan1,"Rumah Makan 1","Food","4.2","0.5"));
        food.add(new DataFood(R.drawable.makanan2,"Rumah Makan 2","Food","2.2","1.5"));
        food.add(new DataFood(R.drawable.makanan3,"Rumah Makan 3","Food","4.0","0.2"));
        food.add(new DataFood(R.drawable.makanan4,"Rumah Makan 4","Food","4.9","0.1"));
        food.add(new DataFood(R.drawable.minuman1,"Cafe Shop 1","Coffe","2.2","0.2"));
        food.add(new DataFood(R.drawable.minuman2,"Cafe Shop 2","Coffe","3.2","1.5"));
        food.add(new DataFood(R.drawable.minuman3,"Cafe Shop 3","Coffe","5.0","0.1"));
        food.add(new DataFood(R.drawable.minuman4,"Juice Shop 1","Juice","2.2","2.5"));
        food.add(new DataFood(R.drawable.minuman5,"Juice Shop 2","Juice","4.5","1.5"));
        food.add(new DataFood(R.drawable.minuman6,"Juice Shop 3","Juice","4.2","0.3"));
        adapterFood.setData(food);
        rc1.setAdapter(adapterFood);
    }


    @Override
    public void Detail(int Image, String labelname, String labelkategory, String bintang, String Jarak) {
        Intent inten = new Intent(this, DetailFnB.class);
        inten.putExtra("Image", Image);
        inten.putExtra("labelname", labelname);
        inten.putExtra("labelkategory", labelkategory);
        inten.putExtra("bintang", bintang);
        inten.putExtra("jarak", Jarak);
        startActivity(inten);

    }
}