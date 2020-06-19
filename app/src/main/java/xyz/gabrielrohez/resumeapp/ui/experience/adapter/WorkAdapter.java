package xyz.gabrielrohez.resumeapp.ui.experience.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import xyz.gabrielrohez.resumeapp.databinding.ItemWorkExperienceBinding;
import xyz.gabrielrohez.resumeapp.model.ExperienceItem;

public class WorkAdapter  extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {

    private List<ExperienceItem> list;

    public WorkAdapter(List<ExperienceItem> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemWorkExperienceBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvJob.setText(list.get(position).getJob());
        holder.binding.tvLocation.setText(list.get(position).getName()+ " - "+list.get(position).getCity());
        holder.binding.tvPeriod.setText(list.get(position).getPeriod());

        StringBuilder activities = new StringBuilder();
        for (String item : list.get(position).getActivities()){
            activities.append("• "+item+"\n");
        }
        holder.binding.tvActivities.setText(activities.toString().trim());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder{

        private ItemWorkExperienceBinding binding;

        public ViewHolder(ItemWorkExperienceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
