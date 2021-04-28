package dwiyanhartono.com.loankoprasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import dwiyanhartono.com.loankoprasi.Adapater.AdapterCardViewPager;
import dwiyanhartono.com.loankoprasi.Adapater.AdapterCardViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class Payment extends AppCompatActivity {

    List<Integer> listimage = new ArrayList<>();
    List<Integer> listimage2 = new ArrayList<>();
    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager2 = findViewById(R.id.ViewPageImageSlider);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.bannerbank));
        sliderItems.add(new SliderItem(R.drawable.bannerprovider));
        sliderItems.add(new SliderItem(R.drawable.apl3));
        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.8f + r * 0.16f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });

        initdata();

        HorizontalInfiniteCycleViewPager pager = findViewById(R.id.hviewpager);
        AdapterCardViewPager adapterCardViewPager = new AdapterCardViewPager(listimage,getBaseContext());
        pager.setAdapter(adapterCardViewPager);

        HorizontalInfiniteCycleViewPager pager2 = findViewById(R.id.Verticalviewpager2);
        AdapterCardViewPager2 adapterCardViewPager2 = new AdapterCardViewPager2(listimage2,getBaseContext());
        pager2.setAdapter(adapterCardViewPager2);
    }


    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    private void initdata() {
        listimage.add(R.drawable.xl);
        listimage.add(R.drawable.tri);
        listimage.add(R.drawable.telkomsel);
        listimage.add(R.drawable.smartfrens);
        listimage.add(R.drawable.indosat);
        listimage.add(R.drawable.bayu);
        listimage.add(R.drawable.axis);

        listimage2.add(R.drawable.bca);
        listimage2.add(R.drawable.bri);
        listimage2.add(R.drawable.mandiri);
        listimage2.add(R.drawable.bni);
        listimage2.add(R.drawable.btn);
    }
}