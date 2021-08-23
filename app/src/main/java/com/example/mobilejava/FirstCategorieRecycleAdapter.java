package com.example.mobilejava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FirstCategorieRecycleAdapter extends RecyclerView.Adapter<FirstCategorieRecycleAdapter.FirstCategorieHolder>{

    private List<MyModel> firstlist;
    private FirstCategorieListener CategorieListener;

    public FirstCategorieRecycleAdapter(List<MyModel> firstlist, FirstCategorieListener categorieListener) {
        this.firstlist = firstlist;
        CategorieListener = categorieListener;
    }

    @NonNull
    @Override
    public FirstCategorieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FirstCategorieHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FirstCategorieHolder holder, int position) {
        holder.bindFirstCategorie(firstlist.get(position));

    }

    @Override
    public int getItemCount() {
        return firstlist.size();
    }

    class FirstCategorieHolder extends RecyclerView.ViewHolder{
        ConstraintLayout constraintLayout;
       TextView title,description,price;
        ImageView imagetop;


        public FirstCategorieHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.firstrecylce);
           imagetop=itemView.findViewById(R.id.imagetop);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            price=itemView.findViewById(R.id.valeur);

        }
        void bindFirstCategorie(final MyModel model){
         imagetop.setImageResource(model.image);
         title.setText(model.title);
         description.setText(model.description);
        }
    }

}
