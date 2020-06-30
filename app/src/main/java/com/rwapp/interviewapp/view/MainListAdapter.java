package com.rwapp.interviewapp.view;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rwapp.interviewapp.R;
import com.rwapp.interviewapp.models.Cards;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Purpose: Adapter to inflate the data in the MainActivity.class recycler
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private List<Cards> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context mContext;

    MainListAdapter(Context context, List<Cards> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mContext = context;
    }

    /**
     * Inflates the row layout
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.main_recycler_row, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Binding of the data in each item
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mData.get(position).getCard_type() != null) {
            holder.mTitle.setText(mData.get(position).getCard_type());
        }

        //Inflating text
        if (mData.get(position).getCard().getTitle() != null) {
            if (!mData.get(position).getCard().getTitle().getValue().isEmpty()) {
                holder.mDescription.setText(mData.get(position).getCard().getTitle().getValue());
            }

            if (mData.get(position).getCard().getTitle().getAttributes() != null) {
                holder.mDescription.setTextColor(Color.parseColor(mData.get(position).getCard().getTitle().getAttributes().getText_color()));
                holder.mDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, mData.get(position).getCard().getTitle().getAttributes().getFont().getSize());
                holder.mTitle.setTextColor(Color.parseColor(mData.get(position).getCard().getTitle().getAttributes().getText_color()));
                holder.mTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, mData.get(position).getCard().getTitle().getAttributes().getFont().getSize());
            }
        }

        //Inflating image
        if (mData.get(position).getCard().getImage() != null) {
            if (!mData.get(position).getCard().getImage().getUrl().isEmpty()) {
                Glide.with(mContext).load(mData.get(position).getCard().getImage().getUrl()).into(holder.mImageView);
            }
            if (mData.get(position).getCard().getImage().getSize() != null) {
                ViewGroup.LayoutParams params = holder.mImageView.getLayoutParams();
                params.height = mData.get(position).getCard().getImage().getSize().getHeight();
                params.width = mData.get(position).getCard().getImage().getSize().getWidth();
            }
        }

    }

    /**
     * Total number of the rows
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * Stores and recycles views as they are scrolled off screen
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitle;
        TextView mDescription;
        ImageView mImageView;

        ViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.description);
            mImageView = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    /**
     * Convenience method for getting data at click position
     */
    Cards getItem(int id) {
        return mData.get(id);
    }

    /**
     * Allows clicks events to be caught
     */
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    /**
     * Parent activity will implement this method to respond to click events
     */
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}