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
import java.util.ArrayList;

import devpro.vn.hellowrold.R;
import devpro.vn.hellowrold.activity.CoursesActivity;
import devpro.vn.hellowrold.api.RestManager;
import devpro.vn.hellowrold.config.Network;
import devpro.vn.hellowrold.data.MyDatabaseHelper;
import devpro.vn.hellowrold.model.HomeModel;
import devpro.vn.hellowrold.model.MyLessonModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nguye on 5/7/2018.
 */

public class HomeFragrmet extends Fragment {
    public String dataMyLesson;
    public static HomeFragrmet homeFragrmet;

    public static HomeFragrmet newInstant() {
        if (homeFragrmet == null) {
            homeFragrmet = new HomeFragrmet();
        }
        return homeFragrmet;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        inItView(view);
        getHomeData();
        bntCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CoursesActivity.class);
                intent.putExtra("Data", dataMyLesson);
                startActivity(intent);
            }
        });
        return view;

    }

    private void inItView(View view) {
        tvCourse = view.findViewById(R.id.tvcourse);
        tvStudentNumber = view.findViewById(R.id.tvStudentNumber);
        tvRevenue = view.findViewById(R.id.tvRevenue);
        bntCourses = view.findViewById(R.id.bntCourses);
    }


    private Gson gson;
    private TextView tvCourse;
    private TextView tvStudentNumber;
    private TextView tvRevenue;
    private HomeModel homeModel;
    private Button bntCourses;
    private MyDatabaseHelper db;


    public void getHomeData() {

        gson = new Gson();

        if(Network.isNetworkAvailable(getContext())){
            // Trường hợp có mạng

            Call<ResponseBody> call = RestManager.getApi().getHomeData();
            call.enqueue(new Callback<ResponseBody>() {

                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Log.d("HoangTV", "isSuccessful()");
                        try {

                            String data = response.body().string();


                            homeModel = gson.fromJson(data, HomeModel.class);

                            // ADD data vào sqlite

                            for (MyLessonModel model: homeModel.getMyLesson()) {
                                db = new MyDatabaseHelper(getContext());
                               db.deleteALLTable();
                                db.addMyLesson(model);

                            }

                            dataMyLesson = data;
                            tvCourse.setText(String.valueOf(homeModel.getCourse()));
                            tvStudentNumber.setText(String.valueOf(homeModel.getStudentNumber()));
                            tvRevenue.setText(String.valueOf(homeModel.getRevenue()));

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
        else {
            // Trường hợp K có mạng dùng Sqlite

        }

    }
}



