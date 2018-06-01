package devpro.vn.hellowrold.fragrmet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import devpro.vn.hellowrold.R;


/**
 * Created by nguye on 5/7/2018.
 */

public class TopMonthFragrmet  extends Fragment {
    public static TopMonthFragrmet topMonthFragrmet;

    public static TopMonthFragrmet newInstant(){
        if (topMonthFragrmet == null) {
            topMonthFragrmet = new TopMonthFragrmet();

        }
        return topMonthFragrmet;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top_month
                , container, false);
    }



}
