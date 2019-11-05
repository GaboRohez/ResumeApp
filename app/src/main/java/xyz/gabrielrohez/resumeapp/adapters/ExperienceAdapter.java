package xyz.gabrielrohez.resumeapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.data.network.response.Experience;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> {

    private List<Experience> list;

    public ExperienceAdapter(List<Experience> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_experience, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvCompany.setText(list.get(position).getName());
        holder.tvJob.setText(list.get(position).getJob());
        holder.tvPeriod.setText(list.get(position).getPeriod());
        holder.tvRJob.setText(list.get(position).getReference().getJob());
        holder.tvRName.setText(list.get(position).getReference().getName());
        holder.tvRPhone.setText(list.get(position).getReference().getphone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.experienceCompany)
        TextView tvCompany;
        @BindView(R.id.experienceJob)
        TextView tvJob;
        @BindView(R.id.experiencePeriod)
        TextView tvPeriod;
        @BindView(R.id.experienceRJob)
        TextView tvRJob;
        @BindView(R.id.experienceRName)
        TextView tvRName;
        @BindView(R.id.experienceRPhone)
        TextView tvRPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
