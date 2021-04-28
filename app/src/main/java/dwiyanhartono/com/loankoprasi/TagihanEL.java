package dwiyanhartono.com.loankoprasi;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class TagihanEL extends AppCompatActivity {

    CardView cv1,cv2;
    LinearLayout lyclose,cvbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagihan_e_l);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cv1 = findViewById(R.id.cvtagihanheader);
        cv2 = findViewById(R.id.cvtagihandetail);
        cvbtn = findViewById(R.id.lydetail);
        lyclose = findViewById(R.id.lyclose);
        cvbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv2.setVisibility(View.VISIBLE);
                cv1.setVisibility(View.GONE);
                cvbtn.setVisibility(View.GONE);
            }
        });
        lyclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv2.setVisibility(View.GONE);
                cv1.setVisibility(View.VISIBLE);
                cvbtn.setVisibility(View.VISIBLE);
            }
        });
    }
}