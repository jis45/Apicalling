package com.jishnu.callingatees.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jishnu.callingatees.Model.DataList;
import com.jishnu.callingatees.R;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<DataList> dataList;
    private Context context;

    public CustomAdapter(Context context,List<DataList>dataList){
        this.context=context;
        this.dataList=dataList;
    }
    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_card_view,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {

        holder.TxTtitle.setText(dataList.get(position).getTitle());
        Picasso.Builder builder =new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
         public final View mView;

         TextView TxTtitle;
         ImageView imageView;




        public CustomViewHolder(@NonNull View itemView) {



            super(itemView);
            mView=itemView;
            TxTtitle=itemView.findViewById(R.id.titles);
            imageView=itemView.findViewById(R.id.coverphoto);
        }
    }
}
