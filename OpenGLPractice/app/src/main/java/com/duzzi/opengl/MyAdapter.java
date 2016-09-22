package com.duzzi.opengl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 文件名: MyAdapter
 * 描    述: [该类的简要描述]
 * 创建人: duzzi
 * 创建时间: 2016/9/23
 */
class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final Context mContext;
    private String[] mStringArray;

    MyAdapter(Context context, String[] stringArray) {
        mContext = context;
        mStringArray = stringArray;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder =
                new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_text, null));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextView.setText(mStringArray[position]);
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.callback(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStringArray == null ? 0 : mStringArray.length;
    }

    private OnItemClickListener mOnItemClickListener;

    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        void callback(int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }

}
