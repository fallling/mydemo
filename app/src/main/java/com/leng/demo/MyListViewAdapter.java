package com.leng.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyListViewAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;

    private List<Message> list;

    private Context context;

    public MyListViewAdapter(Context context, List<Message> list) {
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if(view == null || view.getTag() == null) {

            if(list.get(i).getOwner() == 1) {
                view = layoutInflater.inflate(R.layout.left_message_backgound, null, false);
            }else {

                view = layoutInflater.inflate(R.layout.right_message_background, null, false);
            }
            viewHolder = new ViewHolder();
            viewHolder.avatarView = view.findViewById(R.id.avatarView);
            viewHolder.messageView = view.findViewById(R.id.messageView);
            viewHolder.messageViewBackground = view.findViewById(R.id.messageViewBackground);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        view.setTag(viewHolder);


        viewHolder.messageView.setText(list.get(i).getMessage());

        if(list.get(i).getOwner() == 1) {
            viewHolder.avatarView.setImageBitmap(SystemUtil.getCircleBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.avatar_1)));
        }else {
            viewHolder.avatarView.setImageBitmap(SystemUtil.getCircleBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.avatar_2)));
        }
        return view;
    }
}

class ViewHolder {
    ImageView avatarView;
    TextView messageView;
    LinearLayout messageViewBackground;
}