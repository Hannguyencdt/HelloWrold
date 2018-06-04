package devpro.vn.hellowrold.fragrmet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import devpro.vn.hellowrold.R;
import devpro.vn.hellowrold.activity.CoursesActivity;
import devpro.vn.hellowrold.activity.ReveneuDetailActivity;
import devpro.vn.hellowrold.api.RestManager;
import devpro.vn.hellowrold.model.HomeModel;
import devpro.vn.hellowrold.model.ReveneuModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nguye on 5/7/2018.
 */

public class ReveneuFragrmet extends Fragment {
    public static ReveneuFragrmet reveneuFragrmet;

    public static ReveneuFragrmet newInstant() {
        if (reveneuFragrmet == null) {
            reveneuFragrmet = new ReveneuFragrmet();

        }
        return reveneuFragrmet;
    }


    private void inItView(View view) {
        tvToday = view.findViewById(R.id.tvToday);
        tvYesterday = view.findViewById(R.id.tvYesterday);
        tvThisMonth = view.findViewById(R.id.tvThisMonth);
        tvLastMonth = view.findViewById(R.id.tvLastMonth);
        tvLifeTime = view.findViewById(R.id.tvLifeTime);
        bntDetailRevenue = view.findViewById(R.id.bntDetailRevenue);
    }

    private TextView tvToday;
    private TextView tvYesterday;
    private TextView tvThisMonth;
    private TextView tvLastMonth;
    private TextView tvLifeTime;
    private Button bntDetailRevenue;
    private Gson gson;
    private ReveneuModel reveneuModel;
    public String dataReveneu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_reveneu, container, false);
        inItView(view);
        getReveneuData();
        bntDetailRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReveneuDetailActivity.class);
                intent.putExtra("Data", dataReveneu);
                startActivity(intent);

            }
        });
        return view;
    }

    public void getReveneuData() {

        gson = new Gson();
        Call<ResponseBody> call = RestManager.getApi().getRevenueData();
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("HoangTV", "isSuccessful()");
                    try {
                        String data = response.body().string();

                       reveneuModel = gson.fromJson(data,ReveneuModel.class );
                        dataReveneu = data;
                        tvToday.setText(String.valueOf(reveneuModel.getToday()));
                        tvYesterday.setText(String.valueOf(reveneuModel.getYesterday()));
                        tvLastMonth.setText(String.valueOf(reveneuModel.getLastMonth()));
                        tvThisMonth.setText(String.valueOf(reveneuModel.getThisMonth()));
                        tvLifeTime.setText(String.valueOf(reveneuModel.getLifeTime()));
                        Log.d("HoangTV", "data" + data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.d("HoangTV", "false()");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("HoangTV", "onFailure()");
            }
        });
    }


}