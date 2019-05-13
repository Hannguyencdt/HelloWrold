package devpro.vn.hellowrold.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nguye on 6/7/2018.
 */

public class TopMontheModel {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("top1")
    @Expose
    private Top1Model top1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Top1Model getTop1() {
        return top1;
    }

    public void setTop1(Top1Model top1) {
        this.top1 = top1;
    }

    public Top2Model getTop2() {
        return top2;
    }

    public void setTop2(Top2Model top2) {
        this.top2 = top2;
    }

    public Top3Model getTop3() {
        return top3;
    }

    public void setTop3(Top3Model top3) {
        this.top3 = top3;
    }

    @SerializedName("top2")
    @Expose
    private Top2Model top2;
    @SerializedName("top3")
    @Expose
    private Top3Model top3;

}
