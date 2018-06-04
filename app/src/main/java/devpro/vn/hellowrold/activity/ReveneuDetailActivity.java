package devpro.vn.hellowrold.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

import devpro.vn.hellowrold.R;
import devpro.vn.hellowrold.adapter.DetailAdapter;
import devpro.vn.hellowrold.adapter.MylessonAdapter;
import devpro.vn.hellowrold.model.DetailModel;
import devpro.vn.hellowrold.model.ListDataMDetailModel;
import devpro.vn.hellowrold.model.ListDataMyLessonModel;
import devpro.vn.hellowrold.model.MyLessonModel;

public class ReveneuDetailActivity extends AppCompatActivity {
    private RecyclerView rcReveneuDetail;
    private ArrayList<DetailModel> detailModels;
    private DetailAdapter detailAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveneu_detail);
        rcReveneuDetail = findViewById(R.id.rcReveneuDetail);
        detailModels = new ArrayList<>();
        Intent intent = getIntent();
        String s = (String) intent.getSerializableExtra("Data");
        Gson gson = new Gson();
        ListDataMDetailModel listDataMDetailModel = gson.fromJson(s,ListDataMDetailModel.class);
        detailModels = listDataMDetailModel.getDetailModels();

        for (DetailModel model : detailModels) {
            Log.d("HoangTV", "Title: " + model.getSoDu());
        }

        this.detailAdapter = new DetailAdapter(this,detailModels);
        this.rcReveneuDetail.setHasFixedSize(true);
        this.rcReveneuDetail.setLayoutManager(new LinearLayoutManager(this));
        this.rcReveneuDetail.setAdapter(detailAdapter);

    }
}
