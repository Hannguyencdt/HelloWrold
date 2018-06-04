package devpro.vn.hellowrold.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nguye on 6/4/2018.
 */

public class DetailModel {
//    "id": 12904,
//            "tieuDetieuDe": "10 Ngày Giảm cân ngay tại nhà bằng Yoga",
//            "tenNguoiMua": "Nguyễn Anh Dũng",
//            "nguon": "Unica",
//            "maCoupon": "ABCDEFGH",
//            "trangThai": "Đã kích hoạt",
//            "doanhThu": 850000,
//            "thuNhap": "680.000 VNĐ (80%)",
//            "soDu": "40.000.000 VNĐ",
//            "dateTime": "10h00 - 01/10/2016"

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("tieuDe")
    @Expose
    private String tieuDe;
    @SerializedName("tenNguoiMua")
    @Expose
    private String tenNguoiMua;
    @SerializedName("nguon")
    @Expose
    private String nguon;
    @SerializedName("maCoupon")
    @Expose
    private String maCoupon;
    @SerializedName("trangThai")
    @Expose
    private String trangThai;
    @SerializedName("doanhThu")
    @Expose
    private String doanhThu;
    @SerializedName("thuNhap")
    @Expose
    private String thuNhap;
    @SerializedName("soDu")
    @Expose
    private String soDu;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTenNguoiMua() {
        return tenNguoiMua;
    }

    public void setTenNguoiMua(String tenNguoiMua) {
        this.tenNguoiMua = tenNguoiMua;
    }

    public String getNguon() {
        return nguon;
    }

    public void setNguon(String nguon) {
        this.nguon = nguon;
    }

    public String getMaCoupon() {
        return maCoupon;
    }

    public void setMaCoupon(String maCoupon) {
        this.maCoupon = maCoupon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(String doanhThu) {
        this.doanhThu = doanhThu;
    }

    public String getThuNhap() {
        return thuNhap;
    }

    public void setThuNhap(String thuNhap) {
        this.thuNhap = thuNhap;
    }

    public String getSoDu() {
        return soDu;
    }

    public void setSoDu(String soDu) {
        this.soDu = soDu;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
