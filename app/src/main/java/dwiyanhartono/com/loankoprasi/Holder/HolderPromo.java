package dwiyanhartono.com.loankoprasi.Holder;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dwiyanhartono.com.loankoprasi.R;

public class HolderPromo extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView label;
    public ImageView image;
    ItemClickListner itemClickListener;
    public LinearLayout lv;

    public HolderPromo(@NonNull View itemView) {
        super(itemView);
        label = itemView.findViewById(R.id.label);
        image = itemView.findViewById(R.id.imagepromo);
        lv = itemView.findViewById(R.id.lv);
        lv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListner itemClickListener) {
        this.itemClickListener = itemClickListener;

    }
}
