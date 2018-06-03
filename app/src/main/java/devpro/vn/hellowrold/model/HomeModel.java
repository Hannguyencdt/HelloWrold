package devpro.vn.hellowrold.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nguye on 6/1/2018.
 */

public class HomeModel {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("course")
    @Expose
    private int course;
    @SerializedName("studentNumber")
    @Expose
    private int studentNumber;
    @SerializedName("revenue")
    @Expose
    private String revenue;
    @SerializedName("myLesson")
    @Expose
    private ArrayList myLesson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public ArrayList getMyLesson() {
        return myLesson;
    }

    public void setMyLesson(ArrayList myLesson) {
        this.myLesson = myLesson;
    }

    public HomeModel(int id, int course, int studentNumber, String revenue, ArrayList myLesson) {
        this.id = id;
        this.course = course;
        this.studentNumber = studentNumber;
        this.revenue = revenue;
        this.myLesson = myLesson;
    }
}

