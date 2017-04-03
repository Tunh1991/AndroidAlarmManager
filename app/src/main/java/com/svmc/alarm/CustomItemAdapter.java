package com.svmc.alarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sev_user on 3/8/2017.
 */

public class CustomItemAdapter extends BaseAdapter {
    private static final int MAX_LAYOUT = 4;
    private static final int LAYOUT_1 = 1;
    private static final int LAYOUT_2 = 2;
    private static final int LAYOUT_3 = 3;
    private LayoutInflater mInflater;
    Context context;
    private ArrayList<ListItem> mData = new ArrayList<ListItem>();

    public CustomItemAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//        this.mData = mData;
    }

    public void addItem(final ListItem item) {
        mData.add(item);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        ListItem item = mData.get(position);
        View v = view;
        int type = getItemViewType(position);
        if (v == null) {
            holder = new ViewHolder();

            switch (type) {
                case LAYOUT_1:
                    view = mInflater.inflate(R.layout.custom_item1, viewGroup, false);
                    holder.tv1 = (TextView) view.findViewById(R.id.tvLabel);
                    holder.tv2 = (TextView) view.findViewById(R.id.tvContent);
                    holder.tv1.setText(item.getLabel());
                    holder.tv2.setText(item.getName());
                    break;
                case LAYOUT_2:
                    view = mInflater.inflate(R.layout.custom_item2, viewGroup, false);
                    holder.tv1 = (EditText) view.findViewById(R.id.labelItem);
                    holder.tv1.setText(item.getLabel());
                    break;

                case LAYOUT_3:
                    view = mInflater.inflate(R.layout.custom_item3, viewGroup, false);
                    holder.tv1 = (TextView) view.findViewById(R.id.tvVibrate);
                    holder.tv1.setText(item.getLabel());
                    holder.cb = (CheckBox) view.findViewById(R.id.cbVibrate);
                    if(item.isCheckbox()){

                        holder.cb.setChecked(true);

                    }
                    else{

                        holder.cb.setChecked(false);

                    }

                    break;
            }
        } else
            holder = (ViewHolder) view.getTag();
        return view;
    }
    public void setCheckBox(int position){
        ListItem item = mData.get(position);
        item.setCheckbox(!item.isCheckbox());
        notifyDataSetChanged();
    }

    @Override
    public int getViewTypeCount() {
        return MAX_LAYOUT;
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getType();
    }

    public class ViewHolder {
        public TextView tv1;
        public TextView tv2;
        public EditText et;
        public CheckBox cb;

    }


}
