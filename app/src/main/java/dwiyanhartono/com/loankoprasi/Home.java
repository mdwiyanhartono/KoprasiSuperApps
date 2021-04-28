package dwiyanhartono.com.loankoprasi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import dwiyanhartono.com.loankoprasi.Adapater.AdapterPromo;
import dwiyanhartono.com.loankoprasi.Data.DataPromo;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment implements dwiyanhartono.com.loankoprasi.Adapater.AdapterPromo.OnItemClickListener {

    private ViewPager2 viewPager2;

    private Handler sliderHandler = new Handler();
    LinearLayout lymf, lyel, lywa, lycomplaint, eform, services, payment;

    RecyclerView rc1;
    AlertDialog.Builder dialog;
    View dialogView;
    AdapterPromo adapterPromo;
    private List<DataPromo> Promo = new ArrayList<>();

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager2 = v.findViewById(R.id.ViewPageImageSlider);
        rc1 = v.findViewById(R.id.rc1);
        lymf = v.findViewById(R.id.lymf);
        lyel = v.findViewById(R.id.lyel);
        lywa = v.findViewById(R.id.lywa);
        eform = v.findViewById(R.id.eform);
//        services = v.findViewById(R.id.services);
        payment = v.findViewById(R.id.payment);
//        lycomplaint = v.findViewById(R.id.lycomplaint);
        rc1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rc1.setItemAnimator(new DefaultItemAnimator());
        adapterPromo = new AdapterPromo(this);
        Promo.add(new DataPromo(R.drawable.apl1, "Label1"));
        Promo.add(new DataPromo(R.drawable.apl2, "Label2"));
        Promo.add(new DataPromo(R.drawable.apl3, "Label3"));
        Promo.add(new DataPromo(R.drawable.apl4, "Label4"));
        Promo.add(new DataPromo(R.drawable.apl5, "Label5"));
        Promo.add(new DataPromo(R.drawable.apl6, "Label6"));
        Promo.add(new DataPromo(R.drawable.apl7, "Label7"));
        adapterPromo.setData(Promo);
        rc1.setAdapter(adapterPromo);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.apl1));
        sliderItems.add(new SliderItem(R.drawable.apl2));
        sliderItems.add(new SliderItem(R.drawable.apl3));
        sliderItems.add(new SliderItem(R.drawable.apl4));

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

        lymf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TagihanMF.class);
                startActivity(i);
//                getActivity().finish();
            }
        });

        lyel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater2 = getLayoutInflater();
                dialogView = inflater2.inflate(R.layout.layoutnotifpin, null);
                final EditText epin = dialogView.findViewById(R.id.textpin);

                dialog.setView(dialogView);
                dialog.setCancelable(false);
                dialog.setIcon(R.drawable.info);
                dialog.setTitle("MASUKAN PIN");

                dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(epin.getText().toString().trim().equalsIgnoreCase("")){
                            epin.setError("Silahkan masukan PIN anda");
                        }
                        Intent i = new Intent(getContext(), Mutasi.class);
                        startActivity(i);
//                        getActivity().finish();

                        dialog.dismiss();
                    }
                });

                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        lywa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater2 = getLayoutInflater();
                dialogView = inflater2.inflate(R.layout.layoutnotifpin, null);
                final EditText epin = dialogView.findViewById(R.id.textpin);

                dialog.setView(dialogView);
                dialog.setCancelable(false);
                dialog.setIcon(R.drawable.info);
                dialog.setTitle("MASUKAN PIN");

                dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(epin.getText().toString().trim().equalsIgnoreCase("")){
                            epin.setError("Silahkan masukan PIN anda");
                        }
                        Intent i = new Intent(getContext(), CekSaldo.class);
                        startActivity(i);
//                        getActivity().finish();

                        dialog.dismiss();
                    }
                });

                dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
//        lycomplaint.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getContext() , Complaint.class);
//                startActivity(i);
//            }
//        });


        eform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PegajuanPinjaman.class);
                startActivity(i);

//                Intent i = new Intent(getActivity(), FoodAndBeverage.class);
//                startActivity(i);
            }
        });

//        services.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getActivity(),Services.class);
//                startActivity(i);
//            }
//        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Payment.class);
                startActivity(i);
            }
        });
        return v;
    }


    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }

    @Override
    public void onItemClick(String branch) {

    }


}