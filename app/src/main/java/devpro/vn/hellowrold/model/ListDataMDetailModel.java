package devpro.vn.hellowrold.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nguye on 6/5/2018.
 */

public class ListDataMDetailModel {
    @SerializedName("detailRevenue")
    @Expose
    private ArrayList<DetailModel> detailModels = new ArrayList<>();

    public ArrayList<DetailModel> getDetailModels() {
        return detailModels;
    }

    public void setDetailModels(ArrayList<DetailModel> detailModels) {
        this.detailModels = detailModels;
    }

    }

