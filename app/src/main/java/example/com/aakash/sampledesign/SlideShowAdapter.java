package example.com.aakash.sampledesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideExtension;


/**
 * Created by aakash on 04August,2018
 */
public class SlideShowAdapter extends PagerAdapter {

    private Context context;
    LayoutInflater layoutInflater;

    public int[] images = {
            R.drawable.liverpool,
            R.drawable.chelsea,
            R.drawable.manchestercity,
            R.drawable.arsenal,
            R.drawable.spurs,
            R.drawable.united
    };

    public SlideShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.slideshow_layout, container, false);
        ImageView imageView = view.findViewById(R.id.image_view);
        //imageView.setImageResource(images[position]);
        Glide.with(context).load(images[position]).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view,"Image "+(position+1),Snackbar.LENGTH_LONG).show();
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
