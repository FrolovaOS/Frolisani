package com.example.Recipes.screens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Recipes.R;
import com.example.Recipes.Recipes_class;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public  class AdapterMainDB extends RecyclerView.Adapter<AdapterMainDB.RecipesViewHolder> {

    protected final Context mContext;
    private ArrayList<Recipes_class> RECIPES;
   // public DatabaseHelper mDBHelper;
    protected AdapterMainDB(Context context,ArrayList rec) {
        this.mContext = context;
        RECIPES = rec;

    }

    @Override
    public RecipesViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_list, parent, false);
        return new RecipesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecipesViewHolder holder, int position) {
        final Recipes_class rec = RECIPES.get(position);
        holder.bind(rec);

        //добавить злосчастную фотку

        }

    @Override
    public int getItemCount() {
        return RECIPES.size();
    }



    public  class RecipesViewHolder extends RecyclerView.ViewHolder {
        TextView recipes;
        TextView Time;
        TextView Character;
        ImageView Block;
        ImageView Favorite;
        Recipes_class recp;
        ArrayList<String> recipe;
        public DatabaseHelper mDBHelper = new DatabaseHelper(mContext);
        ContentValues cv = new ContentValues();

        public RecipesViewHolder(View view) {

            super(view);
            recipes = itemView.findViewById(R.id.recipe);
            Block = itemView.findViewById(R.id.block1);
             Character= itemView.findViewById(R.id.character);
            Time = itemView.findViewById(R.id.time);
            Favorite= itemView.findViewById(R.id.favorites);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recipe = new ArrayList<String>();
                    recipe.add(0,recp.GetName());
                    recipe.add(1,recp.getCharacter());
                    recipe.add(2,recp.getInstruction());
                    recipe.add(3,recp.getProduct());
                    recipe.add(4,recp.getTime());
                    recipe.add(5,recp.getLevel());
                    recipe.add(6,String.valueOf(recp.getBlock()));
                    recipe.add(7,String.valueOf(recp.getFavorites()));
                    // recipe.add(8,rep.getImage());

                    Recicler_search.start1((Activity) itemView.getContext(),recipe);
                }
            });

            Block.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    SQLiteDatabase db = mDBHelper.getWritableDatabase();
                    if(recp.GetBlock()==0) {
                        cv.put("Recipes_block", 1);
                        db.update("app_recipes", cv, "recipes_id = ?",
                                new String[]{String.valueOf(recp.GetId())});
                        recp.setBlock(1);
                    }
                    else
                    {
                        cv.put("Recipes_block", 0);
                        db.update("app_recipes", cv, "recipes_id = ?",
                                new String[]{String.valueOf(recp.GetId())});
                        recp.setBlock(0);
                    }
                }
            });
            ///
            Favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase db = mDBHelper.getWritableDatabase();
                    if(recp.GetFavorite()==0) {
                        cv.put("Recipes_favorites", 1);
                        db.update("app_recipes", cv, "recipes_id = ?",
                                new String[]{String.valueOf(recp.GetId())});
                        recp.setFavorites(1);
                    }
                    else
                    {
                        cv.put("Recipes_favorites", 0);
                        db.update("app_recipes", cv, "recipes_id = ?",
                                new String[]{String.valueOf(recp.GetId())});
                        recp.setFavorites(0);
                    }
                }

            });

        }


        public  void bind(Recipes_class rec)
        {
            this.recp = rec;
            recipes.setText(rec.GetName());
            Time.setText(rec.getTime());
            Character.setText((rec.getCharacter()));
        }
    }

}
