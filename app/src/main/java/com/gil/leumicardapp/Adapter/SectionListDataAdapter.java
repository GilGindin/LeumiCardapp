package com.gil.leumicardapp.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
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
    private OnItemClickListener mlistener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mlistener = listener;
    }


    public SectionListDataAdapter(Context context, ArrayList<DataListObject> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item_layout, viewGroup, false);
        SingleItemRowHolder mh = new SingleItemRowHolder(v, mlistener);
        return mh;
    }

    @Override
    public void onBindViewHolder(final SingleItemRowHolder holder, int i) {

        final DataListObject singleItem = itemsList.get(i);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(mContext, singleItem.getTitle(), singleItem.getCatId(), singleItem.getImag());
            }
        });

        if (singleItem.getTitle() != null) {
            holder.tvTitle.setText(singleItem.getTitle());
        }
        if (singleItem.getSTitle() != null) {
            holder.textview_sTitlle.setText(singleItem.getSTitle());
        }

        if (singleItem.getImag() != null) {
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


        public SingleItemRowHolder(View view, final OnItemClickListener listener) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.textview_sTitlle = (TextView) view.findViewById(R.id.textview_sTitlle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                            notifyDataSetChanged();
                        }
                    }
                }
            });

        }

    }

    public void showDialog(Context context, String text, int textCategory, String image) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_layout);

        TextView textView = dialog.findViewById(R.id.text_dialog);
        textView.setText(text);
        TextView textView1 = dialog.findViewById(R.id.text_dialog_category);
        textView1.setText("קטגוריה " + textCategory);
        ImageView imageView = dialog.findViewById(R.id.image_dialog);
        Picasso.with(context).load(image).into(imageView);
        Button dialogButtonOK = dialog.findViewById(R.id.dialogButtonOK);
        dialogButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }

}
