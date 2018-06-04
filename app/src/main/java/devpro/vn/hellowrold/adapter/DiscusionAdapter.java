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
import devpro.vn.hellowrold.fragrmet.DiscusionFragrmet;
import devpro.vn.hellowrold.model.DiscussionModel;
import devpro.vn.hellowrold.model.MyLessonModel;

/**
 * Created by nguye on 6/5/2018.
 */

public class DiscusionAdapter extends RecyclerView.Adapter<DiscusionAdapter.ViewHolder> {

private Context mContext;
private ArrayList<DiscussionModel> discussionModels;

public DiscusionAdapter(Context mContext, ArrayList<DiscussionModel> discussionModels) {
        this.mContext = mContext;
        this.discussionModels = discussionModels;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_discussion, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
        }

public void addListChapter(ArrayList<DiscussionModel> chapterModels) {
        this.discussionModels.clear();
        this.discussionModels.addAll(discussionModels);
        notifyDataSetChanged();
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DiscussionModel model = discussionModels.get(position);
        Picasso.get().load(model.getImage()).into(viewHolder.imgImage);
        viewHolder.tvName.setText(String.valueOf(model.getName()));
        viewHolder.tvMessage.setText(String.valueOf(model.getMessage()));
        viewHolder.tvTime.setText(String.valueOf(model.getTime()));
        viewHolder.tvDateTime.setText(String.valueOf(model.getDateTime()));

        }

@Override
public int getItemCount() {
        return discussionModels.size();
        }

class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imgImage;
    TextView tvName;
    TextView tvMessage;
    TextView tvTime;
    TextView tvDateTime;


    public ViewHolder(View itemView) {
        super(itemView);

        imgImage = itemView.findViewById(R.id.imgImage);
        tvName = itemView.findViewById(R.id.tvName);
        tvMessage = itemView.findViewById(R.id.tvMessage);
        tvTime = itemView.findViewById(R.id.tvTime);
        tvDateTime = itemView.findViewById(R.id.tvDateTime);

    }
}
}