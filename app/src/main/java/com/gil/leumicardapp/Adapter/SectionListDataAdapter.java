package com.gil.leumicardapp.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gil.leumicardapp.Model.DataListObject;
import com.gil.leumicardapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {
    private static final String TAG = "SectionListDataAdapter";
    private ArrayList<DataListObject> itemsList;
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<DataListObject> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item_layout, viewGroup, false);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        DataListObject singleItem = itemsList.get(i);

        if (singleItem.getTitle() != null){
            holder.tvTitle.setText(singleItem.getTitle());
        }
       if (singleItem.getSTitle() != null){
           holder.textview_sTitlle.setText(singleItem.getSTitle());
       }

        if (singleItem.getImag() != null) {
            Log.d(TAG, "onBindViewHolder: -----"+singleItem.getImag().isEmpty());
//              Glide.with(mContext)
//                .load(singleItem.getImag())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .centerCrop()
//                .error(R.drawable.ic_launcher_background)
//                .into(holder.itemImage);
            Picasso.with(mContext).load(singleItem.getImag()).into(holder.itemImage);

        }
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, textview_sTitlle;
        private ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.textview_sTitlle = (TextView) view.findViewById(R.id.textview_sTitlle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(mContext);

                    final TextView input = new TextView (mContext);
                    alert.setView(input);

                    final ImageView inputImage = new ImageView(mContext);
                    alert.setView(inputImage);

                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                          

                            input.setText("hi");
                            // Do something with value!
                        }
                    });

                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            // Canceled.
                        }
                    });
                    alert.show();

                }
            });

        }

    }


}
