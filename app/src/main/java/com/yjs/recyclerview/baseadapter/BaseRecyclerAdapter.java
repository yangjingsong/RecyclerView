package com.yjs.recyclerview.baseadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yjs.recyclerview.adapter.BaseViewHolder;

/**
 * Created by yangjingsong on 17/2/16.
 */

public class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    SparseArray<Visitable> mData;
    public static final int TYPE_FOOTER = 100;
    public static final int TYPE_HEADER = 101;
    public static final int TYPE_LOADING = 102;
    private boolean isNeedLoading = true;
    LinearLayout mHeaderLayout;
    LinearLayout mFooterLayout;
    ItemTypeFactory itemTypeFactory;
    LoadMoreView loadMoreView;

    public BaseRecyclerAdapter(Context context) {
        itemTypeFactory = new ItemTypeFactory();
        mHeaderLayout = new LinearLayout(context);
        mHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mHeaderLayout.setOrientation(LinearLayout.VERTICAL);
        mFooterLayout = new LinearLayout(context);
        mFooterLayout.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mFooterLayout.setOrientation(LinearLayout.VERTICAL);
        loadMoreView = new SimpleLoadMoreView();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return createBaseViewHolder(mHeaderLayout);
            case TYPE_FOOTER:
                return createBaseViewHolder(mFooterLayout);
            case TYPE_LOADING:
                return createLoadingViewHolder(parent);
            default:
                View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
                return itemTypeFactory.createViewHolder(viewType, view);
        }

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        switch (viewType){
            case TYPE_HEADER:
                break;
            case TYPE_FOOTER:
                break;
            case TYPE_LOADING:
                loadMoreView.changeStatus(holder);
                break;
            default:
                holder.setUpView(mData.get(getRealPosition(position)), position);
        }


    }

    private BaseViewHolder createLoadingViewHolder(ViewGroup parent){
        View view =LayoutInflater.from(parent.getContext()).inflate(loadMoreView.getLayoutId(),parent,false);
        return new BaseViewHolder(view) {
            @Override
            public void setUpView(Object model, int position) {

            }
        };

    }

    @Override
    public int getItemCount() {
        return getDataSize() + getFooterCount() + getHeaderCount() + getLoadingViewCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (isNeedLoading && position == getItemCount() - 1) {
            return TYPE_LOADING;
        }
        if (getHeaderCount() > 0) {
            if (position == 0) {
                return TYPE_HEADER;
            } else if (position == mData.size() + 1 && getFooterCount() > 0) {
                return TYPE_FOOTER;
            } else {
                return mData.get(getRealPosition(position)).type(itemTypeFactory);
            }
        } else {
            if (position == mData.size() && getFooterCount() > 0) {
                return TYPE_FOOTER;
            } else {
                return mData.get(getRealPosition(position)).type(itemTypeFactory);
            }
        }


    }

    public int getHeaderCount() {
        return mHeaderLayout.getChildCount();
    }

    public int getFooterCount() {
        return mFooterLayout.getChildCount();
    }

    public int getDataSize() {
        return mData.size();
    }

    public int getLoadingViewCount() {
        return isNeedLoading ? 1 : 0;
    }

    public void addHeaderView(View headerView) {
        mHeaderLayout.addView(headerView);
        notifyDataSetChanged();
    }

    public void addFooterView(View footerView) {
        mFooterLayout.addView(footerView);
    }

    public int getRealPosition(int position) {
        return getHeaderCount() > 0 ? position - 1 : position;
    }

    private BaseViewHolder createBaseViewHolder(View view) {
        return new BaseViewHolder(view) {
            @Override
            public void setUpView(Object model, int position) {

            }
        };
    }

    public void setmData(SparseArray<Visitable> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public void setNeedLoading(boolean needLoading) {
        isNeedLoading = needLoading;
    }

    public void setItemTypeFactory(ItemTypeFactory itemTypeFactory) {
        this.itemTypeFactory = itemTypeFactory;
    }

    public void setLoadMoreView(LoadMoreView loadMoreView) {
        this.loadMoreView = loadMoreView;
    }
}
