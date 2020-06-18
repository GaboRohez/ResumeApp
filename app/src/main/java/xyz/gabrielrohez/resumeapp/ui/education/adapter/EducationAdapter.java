package xyz.gabrielrohez.resumeapp.ui.education.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.databinding.ItemEducationBinding;
import xyz.gabrielrohez.resumeapp.model.CoursesItem;
import xyz.gabrielrohez.resumeapp.utils.AppUtils;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.ViewHolder> {

    private Context context;
    private List<CoursesItem> list;

    public EducationAdapter(List<CoursesItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemEducationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint({"SetTextI18n", "RestrictedApi"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvTitle.setText(list.get(position).getInstitute());
        holder.binding.tvGrade.setText(list.get(position).getGrade());
        holder.binding.tvCertID.setText(list.get(position).getPeriod() +" - "+list.get(position).getTitle());

        AppUtils.Colors color = AppUtils.Colors.randomColor();
        holder.binding.contentImage.setBackgroundResource(color.getLightColor());
        holder.binding.ivIcon.setColorFilter(ContextCompat.getColor(context, color.getDarkColor()), android.graphics.PorterDuff.Mode.SRC_IN);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ItemEducationBinding binding;

        public ViewHolder(ItemEducationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
