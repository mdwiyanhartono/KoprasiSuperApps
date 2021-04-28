package dwiyanhartono.com.loankoprasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import static dwiyanhartono.com.loankoprasi.R.*;
import static dwiyanhartono.com.loankoprasi.R.drawable.*;
import static dwiyanhartono.com.loankoprasi.R.drawable.notif;

public class BaseActivity extends AppCompatActivity {

    private final static int ID_HOME = 2;
    private final static int ID_ACCOUNT = 3;
    private final static int ID_NOTIF = 1;
    MeowBottomNavigation bottomNavigation;

    Home home;
    Notif notif;
    Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_base);
        home = new Home();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(id.fragment, home);
        fragmentTransaction.commit();
        bottomNavigation = findViewById(id.bottom_nav);
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTIF, drawable.notif));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME, drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ACCOUNT, drawable.account));
        bottomNavigation.setOnClickMenuListener(item -> {
//                Toast.makeText(MainActivity.this, "clicked item : " + item.getId(), Toast.LENGTH_SHORT).show();
        });
        bottomNavigation.setOnShowListener(item -> {
//                Toast.makeText(MainActivity.this, "showing item : " + item.getId(), Toast.LENGTH_SHORT).show();

            String name;
            switch (item.getId()) {
                case ID_HOME:
                    home = new Home();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(id.fragment, home);
                    fragmentTransaction1.commit();
                    name = "HOME";
                    break;
                case ID_ACCOUNT:
                    account = new Account();
                    FragmentTransaction AccountfragmentTransaction = getSupportFragmentManager().beginTransaction();
                    AccountfragmentTransaction.replace(id.fragment, account);
                    AccountfragmentTransaction.commit();
                    name = "ACCOUNT";
                    break;
                case ID_NOTIF:
                    notif = new Notif();
                    FragmentTransaction NotiffragmentTransaction = getSupportFragmentManager().beginTransaction();
                    NotiffragmentTransaction.replace(id.fragment, notif);
                    NotiffragmentTransaction.commit();
                    name = "NOTIF";
                    break;
                default:
                    name = "";
            }

        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(MainActivity.this, "reselected item : " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.show(ID_HOME, true);
    }
}