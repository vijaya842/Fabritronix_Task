package com.example.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private Context mContext;
    private List<TaskDTO> Data;

    public void setItems(List<TaskDTO> Data){

        this.Data = Data;
        notifyDataSetChanged();
    }



    public RecyclerAdapter(Context mContext, List<TaskDTO> Data) {
        this.mContext = mContext;
        this.Data = Data;

        //option= new RequestOptions().centerCrop().placeholder(R.drawable.loadingimgshape).error(R.drawable.loadingimgshape);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.recycler_data,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvlink.setText(Data.get(position).getLink());
        holder.tvstate.setText(Data.get(position).getState());
        holder.tvtyp.setText(Data.get(position).getType());
        holder.tvname.setText(Data.get(position).getName());
        holder.tvlabel.setText(Data.get(position).getLabel());

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvlink;
        TextView tvstate;
        TextView tvtyp;
        TextView tvname;
        TextView tvlabel;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvlink = itemView.findViewById(R.id.tvlink);
            tvstate = itemView.findViewById(R.id.tvstate);
            tvtyp = itemView.findViewById(R.id.tvtyp);
            tvname = itemView.findViewById(R.id.tvname);
            tvlabel = itemView.findViewById(R.id.tvlabel);
        }
    }
}
