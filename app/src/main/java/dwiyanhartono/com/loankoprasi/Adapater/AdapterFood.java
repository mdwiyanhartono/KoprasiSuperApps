package dwiyanhartono.com.loankoprasi.Adapater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dwiyanhartono.com.loankoprasi.Data.DataFood;
import dwiyanhartono.com.loankoprasi.Data.DataPromo;
import dwiyanhartono.com.loankoprasi.Holder.HolderFood;
import dwiyanhartono.com.loankoprasi.Holder.HolderPromo;
import dwiyanhartono.com.loankoprasi.R;

public class AdapterFood extends RecyclerView.Adapter<HolderFood> {

    private List<DataFood> assetslist;
    private OnItemClickListener onItemClickListener;

    public AdapterFood(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        assetslist = new ArrayList<>();

    }


    @NonNull
    @Override
    public HolderFood onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_b_beverage, parent, false);
        return new HolderFood(v);
    }

    @Override
    public void onBindViewHolder(final HolderFood holder, final int position) {
        final DataFood da = assetslist.get(position);
        holder.image.setImageResource(da.getImage());
        holder.labelnama.setText(da.getLabelnama());
        holder.labelkategory.setText(da.getLabelkategory());
        holder.bintang.setText(da.getBintang());
        holder.jarak.setText(da.getJarak());

        holder.lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.Detail(da.getImage(),da.getLabelnama(),da.getLabelkategory(),da.getBintang(),da.getJarak());
            }
        });
    }

    @Override
    public int getItemCount() {
        return assetslist.size();
    }

    //
//
    public void setData(List<DataFood> assetslist) {
        this.assetslist.clear();
        this.assetslist = assetslist;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void Detail(int Image, String labelname,String labelkategory, String bintang , String Jarak);
    }

}
