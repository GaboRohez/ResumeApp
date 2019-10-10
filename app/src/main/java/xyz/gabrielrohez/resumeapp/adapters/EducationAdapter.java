package xyz.gabrielrohez.resumeapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.data.network.response.Courses;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.ViewHolder> {

    private List<Courses> list;
    private EducationInterface listener;

    public interface EducationInterface {
        void ItemViewClick(Courses courses);
    }

    public EducationAdapter(List<Courses> list, EducationInterface listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_education, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //  textViews
        holder.output[0].setText(list.get(position).getGrade());
        holder.output[1].setText(list.get(position).getPeriod());
        holder.output[2].setText(list.get(position).getId());

        //  pdf
        holder.document.setImageResource(AppConstants.PDF_FILE.getImageFromId(list.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.educationImage) ImageView document;
        @BindView(R.id.educationMenu) ImageButton btnMenu;
        @BindViews({R.id.educationTitle, R.id.educationPeriod, R.id.educationCertId}) TextView[] output;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.ItemViewClick(list.get(getAdapterPosition()));

        }
    }
}
