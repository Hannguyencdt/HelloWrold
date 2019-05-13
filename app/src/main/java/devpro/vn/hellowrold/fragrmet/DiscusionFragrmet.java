package devpro.vn.hellowrold.fragrmet;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import devpro.vn.hellowrold.R;
import devpro.vn.hellowrold.activity.CoursesActivity;
import devpro.vn.hellowrold.adapter.DiscusionAdapter;
import devpro.vn.hellowrold.adapter.MylessonAdapter;
import devpro.vn.hellowrold.api.RestManager;
import devpro.vn.hellowrold.config.Network;
import devpro.vn.hellowrold.data.MyDatabaseHelper;
import devpro.vn.hellowrold.model.DiscussionModel;
import devpro.vn.hellowrold.model.HomeModel;
import devpro.vn.hellowrold.model.ListDataDiscussionModel;
import devpro.vn.hellowrold.model.ListDataMyLessonModel;
import devpro.vn.hellowrold.model.MyLessonModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nguye on 5/7/2018.
 */

public class DiscusionFragrmet extends Fragment {
    public static DiscusionFragrmet discusionFragrmet;

    public static DiscusionFragrmet newInstant() {
        if (discusionFragrmet == null) {
            discusionFragrmet = new DiscusionFragrmet();
        }
        return discusionFragrmet;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discusion, container, false);
        rcDiscussion = view.findViewById(R.id.rcDiscussion);
        discussionModels = new ArrayList<>();
        getDiscussionData();


//        listDiscussion = new ArrayList<Discussion>();
//        adapter = new DiscussionAdapter(getContext(), listDiscussion);
//        adapter.setCallBack(this);
//        rcDiscussion.setLayoutManager(new LinearLayoutManager(getContext()));
//        rcDiscussion.setAdapter(adapter);

        return view;
    }

    private Gson gson;
    private RecyclerView rcDiscussion;
    private DiscusionAdapter discusionAdapter;
    private ArrayList<DiscussionModel> discussionModels;
    private MyDatabaseHelper db;


    public void getDiscussionData() {
        gson = new Gson();
        if (Network.isNetworkAvailable(getContext())) {
            Call<ResponseBody> call = RestManager.getApi().getDiscussionData();
            call.enqueue(new Callback<ResponseBody>() {

                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Log.d("HoangTV", "isSuccessful()");
                        try {
                            String data = response.body().string();

                            ListDataDiscussionModel listDataDiscussionModel = gson.fromJson(data, ListDataDiscussionModel.class);
                            discussionModels = listDataDiscussionModel.getDiscussionModels();
//                            discusionAdapter.addListChapter(discussionModels);
                            discusionAdapter = new DiscusionAdapter(getContext(), discussionModels);
                            rcDiscussion.setHasFixedSize(true);
                            rcDiscussion.setLayoutManager(new LinearLayoutManager(getContext()));
                            rcDiscussion.setAdapter(discusionAdapter);

                            //
                            db = new MyDatabaseHelper(getContext());
                            db.deleteALLTable();
                            for (DiscussionModel model : discussionModels) {
                                db.addDiscussion(model);

                            }


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
        } else {
            MyDatabaseHelper db = new MyDatabaseHelper(getContext());
            discussionModels = db.getAllDiscussion();
         //   discusionAdapter.addListChapter(discussionModels);
            discusionAdapter = new DiscusionAdapter(getContext(), discussionModels);
            rcDiscussion.setHasFixedSize(true);
            rcDiscussion.setLayoutManager(new LinearLayoutManager(getContext()));
            rcDiscussion.setAdapter(discusionAdapter);

        }
    }
}



