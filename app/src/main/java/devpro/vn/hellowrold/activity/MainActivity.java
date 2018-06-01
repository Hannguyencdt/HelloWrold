package devpro.vn.hellowrold.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import devpro.vn.hellowrold.R;
import devpro.vn.hellowrold.config.BottomNavigationViewHelper;
import devpro.vn.hellowrold.fragrmet.DiscusionFragrmet;
import devpro.vn.hellowrold.fragrmet.HomeFragrmet;
import devpro.vn.hellowrold.fragrmet.ReveneuFragrmet;
import devpro.vn.hellowrold.fragrmet.TopMonthFragrmet;

public class MainActivity  extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigation);
        itInView();



    }
    private void itInView(){
        frameLayout = findViewById(R.id.frameConten);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        nextFragment(HomeFragrmet.newInstant(),R.id.frameConten);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_item1:
                nextFragment(HomeFragrmet.newInstant(),R.id.frameConten);
                break;
            case R.id.action_item2:
                nextFragment(DiscusionFragrmet.newInstant(),R.id.frameConten);
                break;
            case R.id.action_item3:
                nextFragment(ReveneuFragrmet.newInstant(),R.id.frameConten);
                break;
            case R.id.action_item4:
                nextFragment(TopMonthFragrmet.newInstant(),R.id.frameConten);
                break;
        }
        return false;
    }
    public void nextFragment(Fragment fragment, int id) {
        String backStateName = fragment.getClass().getName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        // transaction.addToBackStack(backStateName);
        transaction.commit();
    }
}













