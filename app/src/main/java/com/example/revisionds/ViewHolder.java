package com.example.revisionds;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View nView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        nView=itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mClickListener.onItemClick(view,getAdapterPosition());

            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view,getAdapterPosition());
                return true;
            }
        });
    }
    public void setDetails(Context ctx,String Name,String price, String phone, String image){
        TextView mName=nView.findViewById(R.id.textName);
        TextView mPrice=nView.findViewById(R.id.textPrice);
        TextView mPhone=nView.findViewById(R.id.textPhone);
        ImageView mImage=nView.findViewById(R.id.imageView2);

        mName.setText(Name);
        Picasso.get().load(image).into(mImage);
    }
    private ViewHolder.ClickListener mClickListener;
    public interface ClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);

    }
    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
