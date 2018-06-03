package devpro.vn.hellowrold.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nguye on 6/3/2018.
 */

public class ListDataMyLessonModel {
    @SerializedName("myLesson")
    @Expose
    private ArrayList<MyLessonModel> myLessonModels = new ArrayList<>();

    public ArrayList<MyLessonModel> getMyLessonModels() {
        return myLessonModels;
    }

    public void setMyLessonModels(ArrayList<MyLessonModel> myLessonModels) {
        this.myLessonModels = myLessonModels;
    }
}
