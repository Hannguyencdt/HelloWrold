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

public class ReveneuFragrmet extends Fragment {
    public static ReveneuFragrmet reveneuFragrmet;

    public static ReveneuFragrmet newInstant(){
        if (reveneuFragrmet == null) {
            reveneuFragrmet = new ReveneuFragrmet();

        }
        return reveneuFragrmet;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reveneu, container, false);
    }



}