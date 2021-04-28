package dwiyanhartono.com.loankoprasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dwiyanhartono.com.loankoprasi.Adapater.AdapterFood;
import dwiyanhartono.com.loankoprasi.Adapater.AdapterFoodDetail;
import dwiyanhartono.com.loankoprasi.Data.DataFood;
import dwiyanhartono.com.loankoprasi.Data.DataFoodDetail;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailFnB extends AppCompatActivity implements AdapterFoodDetail.OnItemClickListener {

    RecyclerView rc1 ;
    ImageView imageView;
    TextView textlabel,textdesc,jarak,bintang;
    AdapterFoodDetail adapterFoodDetail;
    private List<DataFoodDetail> food = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fn_b);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();

        imageView = findViewById(R.id.imagedetail);
        textlabel = findViewById(R.id.judulmakanan);
        textdesc = findViewById(R.id.kategory);
        jarak = findViewById(R.id.jarak);
        bintang = findViewById(R.id.star);
        imageView.setImageResource(i.getIntExtra("Image" , 0));
        textlabel.setText(i.getStringExtra("labelname"));
        textdesc.setText(i.getStringExtra("labelkategory"));
        bintang.setText(i.getStringExtra("bintang"));
        jarak.setText(i.getStringExtra("jarak"));

        rc1 = findViewById(R.id.rc1);
        rc1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rc1.setItemAnimator(new DefaultItemAnimator());
        adapterFoodDetail = new AdapterFoodDetail(this);
        food.add(new DataFoodDetail(R.drawable.sate,"Sate Ayam","Food","Sate Ayam, dengan Bumbu Kacang","21,000"));
        food.add(new DataFoodDetail(R.drawable.susi,"Susi","Food","Susi, dengan dagin tuna segar","41,000"));
        food.add(new DataFoodDetail(R.drawable.capcai,"Capcai","Food","Capcai, dengan Sayuran segar","12,000"));
        food.add(new DataFoodDetail(R.drawable.cekerpedes,"Ceker Dower","Food","Ceker Ayam, dengan bumbu Dower yang bisa bikin bibir anda dower","15,000"));

        adapterFoodDetail.setData(food);
        rc1.setAdapter(adapterFoodDetail);
    }

    @Override
    public void Detail(int Image, String labelname, String labelkategory, String bintang, String Jarak) {

    }
}