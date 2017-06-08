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
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.BaseVH> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private View mHeaderView;

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

    public View getHeaderView() {
        return mHeaderView;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    @Override
    public BaseVH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER) {
            return new HeaderVH(mHeaderView);
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_recycler_view_item, parent, false);

        return new ItemVH(view, mHeaderView != null, mListener);
    }

    @Override
    public void onBindViewHolder(BaseVH holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            return;
        }
        //需要调整position
        int realPosition = (mHeaderView == null) ? position : position - 1;
        MainItem item = mItems.get(realPosition);
        ((ItemVH) holder).mTitle.setText(item.mTitle);
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView != null && position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return (mHeaderView == null) ? mItems.size() : mItems.size() + 1;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class BaseVH extends RecyclerView.ViewHolder {

        public BaseVH(View itemView) {
            super(itemView);
        }
    }

    /**
     * Item ViewHolder extends {@link BaseVH}
     */
    public static class ItemVH extends BaseVH {
        private boolean mHasHeader;
        private TextView mTitle;

        public ItemVH(final View itemView, final boolean hasHeader, final OnItemClickListener listener) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.item_title);
            mHasHeader = hasHeader;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            //需要调整position
                            int realPosition = hasHeader ? position - 1 : position;
                            listener.onItemClick(itemView, realPosition);
                        }
                    }
                }
            });
        }

    }

    /**
     * Header ViewHolder extends {@link BaseVH}
     */
    public static class HeaderVH extends BaseVH {

        public HeaderVH(View itemView) {
            super(itemView);
        }
    }
}
