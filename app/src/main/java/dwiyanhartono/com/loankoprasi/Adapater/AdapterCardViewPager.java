package dwiyanhartono.com.loankoprasi.Adapater;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import dwiyanhartono.com.loankoprasi.R;

public class AdapterCardViewPager extends PagerAdapter {
    List<Integer> listimage;
    Context context;
    LayoutInflater layoutInflater;

    public AdapterCardViewPager(List<Integer> listimage, Context context) {
        this.listimage = listimage;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listimage.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.card_item,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.img_view);
        imageView.setImageResource(listimage.get(position));
        container.addView(view);
        return  view;
    }
}
