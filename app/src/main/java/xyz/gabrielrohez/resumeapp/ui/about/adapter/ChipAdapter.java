package xyz.gabrielrohez.resumeapp.ui.about.adapter;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.gabrielrohez.resumeapp.databinding.ItemChipBinding;

public class ChipAdapter extends RecyclerView.Adapter<ChipAdapter.ViewHolder> {

    private List<String> list;

    public ChipAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemChipBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.chip.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ItemChipBinding binding;

        public ViewHolder(ItemChipBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
