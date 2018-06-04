package devpro.vn.hellowrold.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nguye on 6/4/2018.
 */

public class ReveneuModel {
    //    "id": 1,
//            "today": "1.000.000 VNĐ",
//            "yesterday": "2.000.000 VNĐ",
//            "thisMonth": "20.000.000 VNĐ",
//            "lastMonth": "23.000.000 VNĐ",
//            "lifeTime": "66.000.000 VNĐ",
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("today")
    @Expose
    private String today;
    @SerializedName("yesterday")
    @Expose
    private String yesterday;
    @SerializedName("thisMonth")
    @Expose
    private String thisMonth;
    @SerializedName("lastMonth")
    @Expose
    private String lastMonth;
    @SerializedName("lifeTime")
    @Expose
    private String lifeTime;

    public ArrayList getDetailRevenue() {
        return detailRevenue;
    }

    public void setDetailRevenue(ArrayList detailRevenue) {
        this.detailRevenue = detailRevenue;
    }

    @SerializedName("detailRevenue")
    @Expose
    private ArrayList detailRevenue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getYesterday() {
        return yesterday;
    }

    public void setYesterday(String yesterday) {
        this.yesterday = yesterday;
    }

    public String getThisMonth() {
        return thisMonth;
    }

    public void setThisMonth(String thisMonth) {
        this.thisMonth = thisMonth;
    }

    public String getLastMonth() {
        return lastMonth;
    }

    public void setLastMonth(String lastMonth) {
        this.lastMonth = lastMonth;
    }

    public String getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(String lifeTime) {
        this.lifeTime = lifeTime;
    }
}
