package com.example.myfmrvinterfaceviewmodel.ui.myAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfmrvinterfaceviewmodel.R;
import com.example.myfmrvinterfaceviewmodel.ui.myInterface.MyListener;
import com.example.myfmrvinterfaceviewmodel.ui.myModel.MyChildModel;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Vh>{

    // Adapter
    // ViewHolder

    // listener Send data to MainActivity
    // onAttact
    // deAttact

    Context context;
    ArrayList<MyChildModel> listData;
    MyListener listener;

    public MyAdapter(Context context, ArrayList<MyChildModel> listData, MyListener listener) {
        this.context = context;
        this.listData = listData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);
        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {

        MyChildModel object = listData.get(position);

        holder.imageFlag1.setImageResource(object.getImage());
        holder.tv_country1.setText(object.getCountry());
        holder.tv_rate1.setText(""+object.getRate());

        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class Vh extends RecyclerView.ViewHolder{
        ImageView imageFlag1;
        TextView tv_country1,tv_rate1;

        public Vh(@NonNull View itemView) {
            super(itemView);

            imageFlag1 = itemView.findViewById(R.id.imageFlag1);
            tv_country1 = itemView.findViewById(R.id.tv_country1);
            tv_rate1 = itemView.findViewById(R.id.tv_rate1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickItem = (int) v.getTag();

                    MyChildModel objectToSend = listData.get(clickItem);

                    listener.myCallBack(objectToSend);
                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if(context instanceof MyListener){
            listener = (MyListener) context;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        listener = null;
    }
}
