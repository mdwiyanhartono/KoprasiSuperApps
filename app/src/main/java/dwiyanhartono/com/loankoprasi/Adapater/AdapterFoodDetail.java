package dwiyanhartono.com.loankoprasi.Adapater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dwiyanhartono.com.loankoprasi.Data.DataFood;
import dwiyanhartono.com.loankoprasi.Data.DataFoodDetail;
import dwiyanhartono.com.loankoprasi.Holder.HolderFoodDetail;
import dwiyanhartono.com.loankoprasi.R;

public class AdapterFoodDetail extends RecyclerView.Adapter<HolderFoodDetail> {

    private List<DataFoodDetail> assetslist;
    private OnItemClickListener onItemClickListener;

    public AdapterFoodDetail(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        assetslist = new ArrayList<>();

    }


    @NonNull
    @Override
    public HolderFoodDetail onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_b_beveragedetail, parent, false);
        return new HolderFoodDetail(v);
    }

    @Override
    public void onBindViewHolder(final HolderFoodDetail holder, final int position) {
        final DataFoodDetail da = assetslist.get(position);
        holder.image.setImageResource(da.getImage());
        holder.labelnama.setText(da.getLabelnama());
        holder.labelkategory.setText(da.getLabelkategory());
        holder.harga.setText(da.getHarga());
        holder.desc.setText(da.getDesc());
    }

    @Override
    public int getItemCount() {
        return assetslist.size();
    }

    //
//
    public void setData(List<DataFoodDetail> assetslist) {
        this.assetslist.clear();
        this.assetslist = assetslist;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void Detail(int Image, String labelname,String labelkategory, String bintang , String Jarak);
    }

}
