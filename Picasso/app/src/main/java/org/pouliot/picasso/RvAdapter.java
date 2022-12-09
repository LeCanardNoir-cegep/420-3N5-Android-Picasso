package org.pouliot.picasso;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;
import com.squareup.picasso.Target;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    public List<String> imagesUrls;
    public Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public ViewHolder(LinearLayout layout) {
            super(layout);
            // Define click listener for the ViewHolder's View

            imageView = (ImageView) layout.findViewById(R.id.picasso_holder);
        }

        public ImageView getTextView() {
            return imageView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public RvAdapter(List<String> dataSet, Context parent) {
        imagesUrls = dataSet;
        context = parent;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        LinearLayout layout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false);

        return new ViewHolder(layout);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.getTextView().setImageURI(Uri.parse(imagesUrls.get(position)));
        //Picasso.get().load(imagesUrls.get(position)).into((ImageView) viewHolder.imageView);
        Picasso.get().load(imagesUrls.get(position)).resize(1000, 1000).centerCrop().into((ImageView) viewHolder.imageView);
        Log.i("RvAdapter", "onBindViewHolder: " + viewHolder.imageView.getMaxWidth());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return imagesUrls.size();
    }


}
