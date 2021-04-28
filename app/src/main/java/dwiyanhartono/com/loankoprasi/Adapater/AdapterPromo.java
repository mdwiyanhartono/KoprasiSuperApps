package dwiyanhartono.com.loankoprasi.Adapater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dwiyanhartono.com.loankoprasi.Data.DataPromo;
import dwiyanhartono.com.loankoprasi.Holder.HolderPromo;
import dwiyanhartono.com.loankoprasi.R;

public class AdapterPromo extends RecyclerView.Adapter<HolderPromo> {

    private List<DataPromo> assetslist;
    private OnItemClickListener onItemClickListener;

    public AdapterPromo(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        assetslist = new ArrayList<>();

    }


    @NonNull
    @Override
    public HolderPromo onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listpromo, parent, false);
        return new HolderPromo(v);
    }

    @Override
    public void onBindViewHolder(final HolderPromo holder, final int position) {
        final DataPromo da = assetslist.get(position);
        holder.image.setImageResource(da.getImage());
        holder.label.setText(da.getLabel());
    }

    @Override
    public int getItemCount() {
        return assetslist.size();
    }

    //
//
    public void setData(List<DataPromo> assetslist) {
        this.assetslist.clear();
        this.assetslist = assetslist;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(String branch);
    }

}
