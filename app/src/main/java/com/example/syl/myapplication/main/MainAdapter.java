package com.example.syl.myapplication.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.syl.myapplication.R;

import java.util.List;

/**
 * Created by Shen YunLong on 2017/04/10.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    private OnItemClickListener mListener;

    private Context mContext;
    private List<MainItem> mItems;

    public MainAdapter(Context context, List<MainItem> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_recycler_view_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MainItem item = mItems.get(position);
        holder.mTitle.setText(item.mTitle);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;

        public ViewHolder(final View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.item_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }

    }
}
