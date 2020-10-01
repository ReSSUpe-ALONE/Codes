package org.ReSSupe.test1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private ArrayList<Maindata> arrayList;

    public MainAdapter(ArrayList<Maindata> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder holder, int position) {
        holder.profile.setImageResource(arrayList.get(position).getProfile());
        holder.pf_name.setText(arrayList.get(position).getPf_name());
        holder.pf_content.setText(arrayList.get(position).getPf_content());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName=holder.pf_name.getText().toString();
                Toast.makeText(v.getContext(), curName,Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position)
    {
        try{
            arrayList.remove(position);
            notifyItemRemoved(position);

        } catch(IndexOutOfBoundsException ex)
        {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView profile;
        protected TextView pf_name;
        protected TextView pf_content;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile = (ImageView) itemView.findViewById(R.id.profile);
            this.pf_name = (TextView) itemView.findViewById(R.id.pf_name);
            this.pf_content = (TextView) itemView.findViewById(R.id.pf_content);
        }
    }
}
