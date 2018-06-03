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
import devpro.vn.hellowrold.model.MyLessonModel;

/**
 * Created by nguye on 6/1/2018.
 */

public class MylessonAdapter extends RecyclerView.Adapter<MylessonAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<MyLessonModel> myLessonModels;

    public MylessonAdapter(Context mContext, ArrayList<MyLessonModel> myLessonModels) {
        this.mContext = mContext;
        this.myLessonModels = myLessonModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_my_lesson, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void addListChapter(ArrayList<MyLessonModel> chapterModels) {
        this.myLessonModels.clear();
        this.myLessonModels.addAll(myLessonModels);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        MyLessonModel model = myLessonModels.get(position);
        Picasso.get().load(model.getImage()).into(viewHolder.imgImage);
        viewHolder.tvTitle.setText(String.valueOf(model.getTitle()));
        viewHolder.tvPrice.setText(String.valueOf(model.getPrice()));
        viewHolder.tvRate.setText(String.valueOf(model.getRate()));
    }

    @Override
    public int getItemCount() {
        return myLessonModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgImage;
        TextView tvTitle;
        TextView tvRate;
        TextView tvPrice;

        public ViewHolder(View itemView) {
            super(itemView);

            imgImage = itemView.findViewById(R.id.imgImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvRate = itemView.findViewById(R.id.tvRate);
        }
    }
}
