package market.lib.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import market.lib.ui.viewholder.BaseViewHolder;

public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    private Context mContext;
    private List<T> mData;
    private OnItemClickListener<T> onItemClickListener;
    private OnItemLongClickListener<T> onItemLongClickListener;

    public RecyclerAdapter(Context mContext) {
        this.mContext = mContext;
        this.mData = new ArrayList<>();
    }

    public void addAll(List<T> list){
        mData.addAll(list);
        notifyDataSetChanged();
    }

    public void refresh(List<T> list){
        mData.clear();
        addAll(list);
    }

    public abstract int getItemLayout(int viewType);
    public abstract void bindData(int viewType,BaseViewHolder holder,T item);

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.createViewHolder(mContext,null,getItemLayout(viewType));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        T item = mData.get(position);
        bindData(viewType,holder,item);
        if(onItemClickListener != null) {
            final T itemData = item;
            final int pos = position;
            holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(itemData,pos);
                }
            });
        }
        if(onItemLongClickListener != null){
            final T itemData = item;
            final int pos = position;
            holder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onItemLongClickListener.onItemLongClick(itemData,pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        T item = mData.get(position);
        return getViewType(item,position);
    }

    protected int getViewType(T item,int position){
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener<M>{
        void onItemClick(M item,int pos);
    }

    public interface OnItemLongClickListener<M>{
        void onItemLongClick(M item,int pos);
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
