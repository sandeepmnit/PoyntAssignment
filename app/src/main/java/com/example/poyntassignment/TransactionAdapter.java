package com.example.poyntassignment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int HEADER_ITEM_TYPE = 1;
    public static final int LIST_ITEM_TYPE = 2;
    public static final int INVALID_ITEM_TYPE = -1;
    List<Object> mdata;

    public TransactionAdapter(List<Object> mdata) {
        this.mdata = mdata;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder  viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (viewType) {
            case HEADER_ITEM_TYPE:
                View v = inflater.inflate(R.layout.item_header,viewGroup,false);
                viewHolder =  new HeaderViewHolder(v);
                break;

            case LIST_ITEM_TYPE:
                View v1 = inflater.inflate(R.layout.item_row,viewGroup,false);
                viewHolder =  new ItemViewHolder(v1);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

             switch (viewHolder.getItemViewType()) {
                 case HEADER_ITEM_TYPE:
                     HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
                     configureHeaderViewHolder(headerViewHolder, position);
                     break;
                 case LIST_ITEM_TYPE:
                     ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
                     configureItemViewHolder(itemViewHolder, position);
                     break;
             }
    }

    private void configureHeaderViewHolder(HeaderViewHolder viewHolder,int position) {
          String headerText =(String) mdata.get(position);
          viewHolder.headerTextView.setText(headerText);
    }

    private void configureItemViewHolder(ItemViewHolder itemViewHolder, int position) {
        TransationModel transationModel = (TransationModel)mdata.get(position);
        itemViewHolder.transactionSummary.setText(transationModel.getTransactionSummary());
        itemViewHolder.transactionAmount.setText(transationModel.getTransactionaAmount());
        itemViewHolder.date.setText(transationModel.getDate());
    }

    @Override
    public int getItemViewType(int position) {
        Object object = mdata.get(position);
        if(object instanceof String) {
            return HEADER_ITEM_TYPE;
        } else if ( object instanceof TransationModel) {
            return LIST_ITEM_TYPE;
        }

        return INVALID_ITEM_TYPE;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class HeaderViewHolder extends  RecyclerView.ViewHolder {

        TextView headerTextView;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            headerTextView = itemView.findViewById(R.id.headerTextView);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView transactionSummary;
        TextView date;
        TextView transactionAmount;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            transactionAmount = itemView.findViewById(R.id.amount);
            date = itemView.findViewById(R.id.date);
            transactionSummary = itemView.findViewById(R.id.summary);
        }
    }
}

