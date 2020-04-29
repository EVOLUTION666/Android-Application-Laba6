package com.example.laba6.adapters;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;


import com.example.laba6.DBHelper;
import com.example.laba6.Model;
import com.example.laba6.R;
import com.example.laba6.activities.MainActivity;

import java.io.Serializable;
import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ExampleViewHolder> implements Serializable {
    private Context mContext;
    List<Model>models;
    RecyclerView recyclerView;





    public MainAdapter(Context context, List<Model>newModels) {
        mContext = context;
        models = newModels;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_card, null);
        return new ExampleViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, final int position) {
        Model currentItem = models.get(position);
        String name = currentItem.getName();
        String description = currentItem.getDescription();
        int count = currentItem.getCount();
        int price = currentItem.getPrice();
        holder.nameTextView.setText(name);
        holder.descriptionTextView.setText(description);
        holder.countTextView.setText(String.valueOf(count));
        holder.priceTextView.setText(String.valueOf(price));


    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView nameTextView;
        public TextView priceTextView;
        public TextView countTextView;
        public TextView descriptionTextView;
        public ExampleViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.mainAdapterName);
            descriptionTextView=itemView.findViewById(R.id.mainAdapterDescription);
            countTextView=itemView.findViewById(R.id.mainAdapterCount);
            priceTextView=itemView.findViewById(R.id.mainAdapterPrice);

        }

        @Override
        public void onClick(View v) {

        }
    }

}

