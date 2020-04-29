package com.example.laba6.adapters;


import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;


import com.example.laba6.DBHelper;
import com.example.laba6.Model;
import com.example.laba6.R;
import com.example.laba6.activities.DeleteAdminActivity;
import com.example.laba6.activities.MainActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ExampleViewHolder> implements Serializable {
    private Context mContext;
    private List<Model> models;
    RecyclerView recyclerView;




    public SecondAdapter(Context context, List<Model>newModels) {
        mContext = context;
        models = newModels;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.admin_card, parent, false);
        return new ExampleViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, final int position) {
        final DBHelper dbHelper = new DBHelper(mContext);
        final Model currentItem = models.get(position);

        String name = currentItem.getName();
        String description = currentItem.getDescription();
        int count = currentItem.getCount();
        int price = currentItem.getPrice();
        holder.nameTextView.setText(name);
        holder.descriptionTextView.setText(description);
        holder.countTextView.setText(String.valueOf(count));
        holder.priceTextView.setText(String.valueOf(price));

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DeleteAdminActivity.class);
                intent.putExtra("id", currentItem.getId());
                mContext.startActivity(intent);

            }
        });

//        holder.imgViewRemoveIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dbHelper.deleteProduct(new Model(currentItem.getId(),
//                        currentItem.getName(),
//                        currentItem.getDescription(),
//                        currentItem.getCount(),
//                        currentItem.getPrice()));
//
//                models.remove(position);
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position, models.size());
//
//
//                // Show the removed item label
//                Toast.makeText(mContext,"Removed : " + currentItem.getName(),Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }




    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView nameTextView;
        public TextView descriptionTextView;
        public TextView priceTextView;
        public TextView countTextView;
        public ImageButton imgViewRemoveIcon;
        public RelativeLayout relativeLayout;

        public ExampleViewHolder(View itemView) {
            super(itemView);
//            imgViewRemoveIcon = (ImageButton) itemView.findViewById(R.id.crossButton);
            nameTextView = (TextView) itemView.findViewById(R.id.mainSecondAdapterName);
            descriptionTextView = itemView.findViewById(R.id.mainSecondAdapterDescription);
            countTextView = itemView.findViewById(R.id.mainSecondAdapterCount);
            priceTextView = itemView.findViewById(R.id.mainSecondAdapterPrice);

            relativeLayout = itemView.findViewById(R.id.relativeAdminPanel);


        }

        @Override
        public void onClick(View v) {

        }
    }




}

