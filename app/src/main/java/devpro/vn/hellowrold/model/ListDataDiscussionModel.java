package devpro.vn.hellowrold.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nguye on 6/5/2018.
 */

public class ListDataDiscussionModel {
    public ArrayList<DiscussionModel> getDiscussionModels() {
        return discussionModels;
    }

    public void setDiscussionModels(ArrayList<DiscussionModel> discussionModels) {
        this.discussionModels = discussionModels;
    }

    @SerializedName("discussion")
    @Expose
    private ArrayList<DiscussionModel> discussionModels = new ArrayList<>();
}
