package xyz.gabrielrohez.resumeapp.ui.experience.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import xyz.gabrielrohez.resumeapp.databinding.ItemExperienceBinding;
import xyz.gabrielrohez.resumeapp.model.AppsItem;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> {

    private Context context;
    private List<AppsItem> list;

    public ExperienceAdapter(List<AppsItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemExperienceBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.titleApp.setText(list.get(position).getName());
        Glide.with(context)
                .load(list.get(position).getImageUrl())
                .into(holder.binding.imageApp);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ItemExperienceBinding binding;

        public ViewHolder(ItemExperienceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
