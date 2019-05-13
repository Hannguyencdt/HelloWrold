package devpro.vn.hellowrold.fragrmet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import devpro.vn.hellowrold.R;
import devpro.vn.hellowrold.api.RestManager;
import devpro.vn.hellowrold.model.HomeModel;
import devpro.vn.hellowrold.model.TopMontheModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

        View view =inflater.inflate(R.layout.fragment_top_month, container, false);
        tvData = view.findViewById(R.id.tvData);
        inItView(view);
        getTopMonthData();




        return view;
    }
    public void  inItView( View view){
        tvName1 = view.findViewById(R.id.tvName1);
        tvName2 = view.findViewById(R.id.tvName2);
        tvName3 = view.findViewById(R.id.tvName3);
        tvCourse1 = view.findViewById(R.id.tvCourse1);
        tvCourse2 = view.findViewById(R.id.tvCourse2);
        tvCourse3 = view.findViewById(R.id.tvCourse3);
        tvStudent3 = view.findViewById(R.id.tvStudent3);
        tvStudent1 = view.findViewById(R.id.tvStudent1);
        tvStudent2 = view.findViewById(R.id.tvStudent2);
        tvEvenue1 = view.findViewById(R.id.tvRevenue1);
        tvEvenue2 = view.findViewById(R.id.tvRevenue2);
        tvEvenue3 = view.findViewById(R.id.tvRevenue3);


    }
    private Gson gson;
    private TextView tvName1;
    private TextView tvName2;
    private TextView tvName3;
    private TextView tvCourse1;
    private TextView tvCourse2;
    private TextView tvCourse3;
    private TextView tvStudent1;
    private TextView tvStudent2;
    private TextView tvStudent3;
    private TextView tvEvenue1;
    private TextView tvEvenue2;
    private TextView tvEvenue3;
    private TextView tvData;



    private TopMontheModel topMontheModel;

    public void getTopMonthData() {

        gson = new Gson();
        Call<ResponseBody> call = RestManager.getApi().getTopMonthData();
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("HoangTV", "isSuccessful()");
                    try {

                        String data = response.body().string();
                        topMontheModel = gson.fromJson(data,TopMontheModel.class);
                        tvData.setText(String.valueOf(topMontheModel.getDate()));


                        tvName1.setText(String.valueOf(topMontheModel.getTop1().getName()));
                        tvName2.setText(String.valueOf(topMontheModel.getTop2().getName()));
                        tvName3.setText(String.valueOf(topMontheModel.getTop3().getName()));

                        tvEvenue1.setText(String.valueOf(topMontheModel.getTop1().getRevenue()));
                        tvEvenue2.setText(String.valueOf(topMontheModel.getTop2().getRevenue()));
                        tvEvenue3.setText(String.valueOf(topMontheModel.getTop3().getRevenue()));

                        tvCourse1.setText(String.valueOf(topMontheModel.getTop1().getCourse()));
                        tvCourse2.setText(String.valueOf(topMontheModel.getTop2().getCourse()));
                        tvCourse3.setText(String.valueOf(topMontheModel.getTop3().getCourse()));

                        tvStudent1.setText(String.valueOf(topMontheModel.getTop1().getStudent()));
                        tvStudent2.setText(String.valueOf(topMontheModel.getTop1().getStudent()));
                        tvStudent3.setText(String.valueOf(topMontheModel.getTop1().getStudent()));









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
