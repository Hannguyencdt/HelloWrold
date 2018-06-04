package devpro.vn.hellowrold.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import devpro.vn.hellowrold.R;
import devpro.vn.hellowrold.model.DetailModel;
import devpro.vn.hellowrold.model.MyLessonModel;

/**
 * Created by nguye on 6/4/2018.
 */

public class DetailAdapter  extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<DetailModel> detailModels;

    public DetailAdapter(Context mContext, ArrayList<DetailModel> detailModels) {
        this.mContext = mContext;
        this.detailModels = detailModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_detail, parent, false);
        ViewHolder viewHolder = new DetailAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DetailModel model = detailModels.get(position);


        viewHolder.tvId.setText(String.valueOf(model.getId()));
        viewHolder.tvTieuDe.setText(String.valueOf(model.getTieuDe()));
        viewHolder.tvTenNguoiMua.setText(String.valueOf(model.getTenNguoiMua()));
        viewHolder.tvNguon.setText(String.valueOf(model.getNguon()));
        viewHolder.tvMaCoupon.setText(String.valueOf(model.getMaCoupon()));
        viewHolder.tvTrangThai.setText(String.valueOf(model.getTrangThai()));
        viewHolder.tvDoanhThu.setText(String.valueOf(model.getDoanhThu()));
        viewHolder.tvThuNhap.setText(String.valueOf(model.getThuNhap()));
        viewHolder.tvDateTime.setText(String.valueOf(model.getDateTime()));


    }

    public void addListChapter(ArrayList<MyLessonModel> chapterModels) {
        this.detailModels.clear();
        this.detailModels.addAll(detailModels);
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return detailModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        TextView tvId;
        TextView tvTieuDe;
        TextView tvTenNguoiMua;
        TextView tvNguon;
        TextView tvMaCoupon;
        TextView tvTrangThai;
        TextView tvDoanhThu;
        TextView tvThuNhap;
        TextView tvDateTime;

        public ViewHolder(View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvId);
            tvTieuDe = itemView.findViewById(R.id.tvTieuDe);
            tvTenNguoiMua = itemView.findViewById(R.id.tvTenNguoiMua);
            tvNguon = itemView.findViewById(R.id.tvNguon);
            tvMaCoupon = itemView.findViewById(R.id.tvMaCoupon);
            tvTrangThai = itemView.findViewById(R.id.tvTrangThai);
            tvDoanhThu = itemView.findViewById(R.id.tvDoanhThu);
            tvThuNhap = itemView.findViewById(R.id.tvThuNhap);
            tvDateTime = itemView.findViewById(R.id.tvDateTime);
        }
    }
}
