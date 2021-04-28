package dwiyanhartono.com.loankoprasi.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dwiyanhartono.com.loankoprasi.R;

public class HolderFoodDetail extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView labelnama,labelkategory,desc,harga;
    public ImageView image;
    ItemClickListner itemClickListener;
    public LinearLayout lv;

    public HolderFoodDetail(@NonNull View itemView) {
        super(itemView);
        labelnama = itemView.findViewById(R.id.judulmakanan);
        image = itemView.findViewById(R.id.img1);
        labelkategory = itemView.findViewById(R.id.kategory);
        harga = itemView.findViewById(R.id.labelharga);
        desc = itemView.findViewById(R.id.labeldesc);
        lv = itemView.findViewById(R.id.lyitem);
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
