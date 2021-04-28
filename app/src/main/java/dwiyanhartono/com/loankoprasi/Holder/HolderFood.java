package dwiyanhartono.com.loankoprasi.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dwiyanhartono.com.loankoprasi.R;

public class HolderFood extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView labelnama,labelkategory,bintang,jarak;
    public ImageView image;
    ItemClickListner itemClickListener;
    public LinearLayout lv;

    public HolderFood(@NonNull View itemView) {
        super(itemView);
        labelnama = itemView.findViewById(R.id.judulmakanan);
        image = itemView.findViewById(R.id.img1);
        labelkategory = itemView.findViewById(R.id.kategory);
        bintang = itemView.findViewById(R.id.star);
        jarak = itemView.findViewById(R.id.jarak);
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
