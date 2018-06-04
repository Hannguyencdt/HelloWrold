package devpro.vn.hellowrold.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nguye on 5/31/2018.
 */

public class DiscussionModel {
//
//"id": 1,
//            "name": "Nguyễn Thị Ngọc",
//            "message": "Giáo viên Androoid đẹp trai quá .",
//            "time": "03:00",
//            "dateTime": "01/06",
//            "image": "https://cdn1.iconfinder.com/data/icons/user-pictures/101/malecostume-512.png"
@SerializedName("id")
@Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("image")
    @Expose
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
