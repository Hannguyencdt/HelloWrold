package devpro.vn.hellowrold.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;

import devpro.vn.hellowrold.R;
import devpro.vn.hellowrold.adapter.MylessonAdapter;
import devpro.vn.hellowrold.model.HomeModel;
import devpro.vn.hellowrold.model.ListDataMyLessonModel;
import devpro.vn.hellowrold.model.MyLessonModel;

public class CoursesActivity extends AppCompatActivity {
    private RecyclerView rcCourses;
    private MylessonAdapter adapter;
    private ArrayList<MyLessonModel> myLessonModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        rcCourses = findViewById(R.id.rcCourses);
        myLessonModels = new ArrayList<>();
        Intent intent = getIntent();
        String s = (String) intent.getSerializableExtra("Data");
        Gson gson = new Gson();
        ListDataMyLessonModel listDataMyLessonModel = gson.fromJson(s,ListDataMyLessonModel.class);
        myLessonModels = listDataMyLessonModel.getMyLessonModels();

        for (MyLessonModel model : myLessonModels) {
            Log.d("HoangTV", "Title: " + model.getTitle());
        }

        this.adapter = new MylessonAdapter(this, myLessonModels);
        this.rcCourses.setHasFixedSize(true);
        this.rcCourses.setLayoutManager(new LinearLayoutManager(this));
        this.rcCourses.setAdapter(adapter);


        //  Gson = new gson;
        //Chuyeern duwx lieeu sang
        // homeModel = gson.fromJson(data,HomeModel.class);
        // himeModel.getAll(homeModel);
        //xong


    }
}
