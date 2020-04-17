package com.example.Recipes.screens.OwnRecipes;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import com.example.Recipes.R;
import com.example.Recipes.model_Adding_Recipes.Own_Recipes;
import com.example.Recipes.screens.MainActivity;

import java.io.File;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.RepViewHolder> {
    private SortedList<Own_Recipes> sortedList;

    public Adapter() {
        sortedList = new SortedList<>(Own_Recipes.class, new SortedList.Callback<Own_Recipes>() {


            @Override
            public void onInserted(int position, int count) {
                notifyItemRangeInserted(position, count);
            }

            @Override
            public void onRemoved(int position, int count) {
                notifyItemRangeRemoved(position, count);
            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {
                notifyItemMoved(fromPosition, toPosition);
            }

            @Override
            public int compare(Own_Recipes o1, Own_Recipes o2) {

                return (int) (o2.timestamp - o1.timestamp);
            }

            @Override
            public void onChanged(int position, int count) {
                notifyItemRangeChanged(position, count);
            }

            @Override
            public boolean areContentsTheSame(Own_Recipes oldItem, Own_Recipes newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areItemsTheSame(Own_Recipes item1, Own_Recipes item2) {
                return item1.uid == item2.uid;
            }
        });
    }

    @NonNull
    @Override
    public com.example.Recipes.screens.OwnRecipes.Adapter.RepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new com.example.Recipes.screens.OwnRecipes.Adapter.RepViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipes_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.Recipes.screens.OwnRecipes.Adapter.RepViewHolder holder, int position) {
        holder.bind(sortedList.get(position));
    }

    @Override
    public int getItemCount() {
        return sortedList.size();
    }

    public void setItems(List<Own_Recipes> recipes) {
        sortedList.replaceAll(recipes);
    }

    static class RepViewHolder extends RecyclerView.ViewHolder {

        TextView noteText;
        TextView time;

        View delete;
        View change;
        ImageView photo;
        Own_Recipes recipes;


        public RepViewHolder(@NonNull final View itemView) {
            super(itemView);

            noteText = itemView.findViewById(R.id.note_text);
            delete = itemView.findViewById(R.id.delete);
            change = itemView.findViewById(R.id.change);
            photo = itemView.findViewById(R.id.Photo);
            time = itemView.findViewById(R.id.Time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   Add_Form_Recipes.start1((Activity) itemView.getContext(),recipes);
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.getInstanceRep().getAppDao().deleteR(recipes);
                }
            });
            ///
            change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Add_Form_Recipes.start((Activity) itemView.getContext(),recipes);
                }
            });
           // change.setOnClickListener(new View.OnClickListener() {
             //   @Override
               // public void onClick(View view) {
                 //   MainActivity.getInstanceRep().getRepDao().update(recipes);
                //}
            //});
            ///


        }

        public void bind(Own_Recipes recipes) {
            this.recipes = recipes;

            noteText.setText(recipes.name);
            time.setText(recipes.time);
            if(recipes.screen != null) {
                File image = new File(recipes.screen);
                Bitmap bm = BitmapFactory.decodeFile(image.getAbsolutePath());
                photo.setImageBitmap(bm);
            }
            }

        }
    }

