package market.lib.ui.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class BaseViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;

    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<>();
    }

    public static BaseViewHolder createViewHolder(Context context, View itemView) {
        return new BaseViewHolder(context, itemView);
    }

    public static BaseViewHolder createViewHolder(Context context,
                                                  ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        return new BaseViewHolder(context, itemView);
    }


    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }


    /****以下为辅助方法*****/
    public BaseViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public BaseViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public BaseViewHolder setImageUrl(int viewId, String url) {
        ImageView view = getView(viewId);
        Glide.with(mContext).load(url).into(view);
        return this;
    }

    public BaseViewHolder gone(int... viewId){
        for(int id : viewId){
            View v = getView(id);
            v.setVisibility(View.GONE);
        }
        return this;
    }

    public BaseViewHolder visible(int... viewId){
        for(int id : viewId){
            View v = getView(id);
            v.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public BaseViewHolder setOnClick(int viewId, View.OnClickListener l){
        View view = getView(viewId);
        view.setOnClickListener(l);
        return this;
    }
}
