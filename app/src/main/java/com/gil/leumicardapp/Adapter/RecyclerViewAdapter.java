package com.gil.leumicardapp.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gil.leumicardapp.Model.DataListCat;
import com.gil.leumicardapp.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemRowHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<DataListCat> dataList;
    private Context mContext;
    private ArrayList singleSectionItems;

    public RecyclerViewAdapter(Context context, ArrayList<DataListCat> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_of_items, viewGroup, false);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final String sectionName = dataList.get(i).getCTitle();

        for (int j = 0; j < dataList.size(); j++) {
            singleSectionItems = dataList.get(j).getAllItems();
            Log.d(TAG, "onBindViewHolder:---- " + dataList.get(j).toString());
        }


        itemRowHolder.itemTitle.setText(sectionName);

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

        SnapHelper snapHelper = new PagerSnapHelper();
        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        snapHelper.attachToRecyclerView(itemRowHolder.recycler_view_list);
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);

        itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);

    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }


    public class ItemRowHolder extends RecyclerView.ViewHolder {

        private TextView itemTitle;
        private RecyclerView recycler_view_list;

        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
        }
    }

}
