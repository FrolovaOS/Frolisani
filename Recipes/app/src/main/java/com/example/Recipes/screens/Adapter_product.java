package com.example.Recipes.screens;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.Recipes.R;
import java.util.ArrayList;

public class Adapter_product extends RecyclerView.Adapter<Adapter_product.ProductViewHolder> {

  protected final Context mContext;
  private ArrayList<Product_class> PRODUCTS;

  protected Adapter_product(Context context, ArrayList prod) {
    this.mContext = context;
    PRODUCTS = prod;
  }

  @Override
  public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_fridg, parent, false);
    return new ProductViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
    final Product_class prod = PRODUCTS.get(position);
    holder.bind(prod);
  }

  @Override
  public int getItemCount() {
    return PRODUCTS.size();
  }

  public class ProductViewHolder extends RecyclerView.ViewHolder {
    TextView product_name;
    Product_class product;
    Switch IsExit;

    public DatabaseHelper mDBHelper = new DatabaseHelper(mContext);
    ContentValues cv = new ContentValues();

    public ProductViewHolder(View view) {

      super(view);
      product_name = itemView.findViewById(R.id.note_text1);
      IsExit = itemView.findViewById(R.id.switch1);
      itemView.setOnClickListener(
              new View.OnClickListener() {
                @Override
                public void onClick(View view) {}
              });

      IsExit.setOnClickListener(
              new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  SQLiteDatabase db = mDBHelper.getWritableDatabase();
                  if (IsExit.isChecked()) {
                    cv.put("product_fridge", 1);
                    db.update(
                            "app_product",
                            cv,
                            "product_id = ?",
                            new String[] {String.valueOf(product.getId())});
                    product.setIsExit(1);
                  } else {
                    cv.put("product_fridge", 0);
                    db.update(
                            "app_product",
                            cv,
                            "product_id = ?",
                            new String[] {String.valueOf(product.getId())});
                    product.setIsExit(0);
                  }
                }
              });
    }

    public void bind(Product_class prod) {
      this.product = prod;
      product_name.setText(prod.getName());
      if (product.getIsExit() == 1) {
        IsExit.setChecked(true);
      } else IsExit.setChecked(false);
    }
  }
}
