package xyz.gabrielrohez.resumeapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.data.network.response.Interests;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;

public class InterestsAdapter extends RecyclerView.Adapter<InterestsAdapter.ViewHolder> {

    private List<Interests> list;

    public InterestsAdapter(List<Interests> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.interests_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(list.get(position).getName());
        holder.ivImage.setBackgroundResource(AppConstants.Interest.getImageFromId(list.get(position).getIcon()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemInterestImage)
        ImageView ivImage;
        @BindView(R.id.itemInterestTitle)
        TextView tvTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
