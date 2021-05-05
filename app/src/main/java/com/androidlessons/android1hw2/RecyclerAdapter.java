package com.androidlessons.android1hw2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    private List<String> list;
    private LayoutInflater inflater;
    private OnClickListener listener;

    public RecyclerAdapter(Context context, List<String> list){
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_rv, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.listItem.setText(list.get(position));
        holder.listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(list.get(position));
                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView listItem;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            listItem = itemView.findViewById(R.id.tv_list_item);
        }
    }

    public interface OnClickListener {
        void onClick(String item);

    }

}
