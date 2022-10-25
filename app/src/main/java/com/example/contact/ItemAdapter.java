package com.example.contact;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class ItemAdapter extends BaseAdapter {
    private Activity activity;
    private List<Item> itemList;

    private class ViewHolder{
        TextView txtTen, txtSDT;
    }

    public ItemAdapter(Activity activity, List<Item> itemList) {
        this.activity = activity;
        this.itemList = itemList;
    }

    public Context getContext() {
        return activity;
    }

    public void setContext(Context context) {
        this.activity = activity;
    }


    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.item, null);

            holder = new ViewHolder();

            holder.txtTen = (TextView) view.findViewById(R.id.textViewTen);
            holder.txtSDT = (TextView) view.findViewById(R.id.textViewSDT);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        Item item = itemList.get(i);

        holder.txtTen.setText(item.getTen());
        holder.txtSDT.setText((item.getSdt()));

        return view;
    }
}
