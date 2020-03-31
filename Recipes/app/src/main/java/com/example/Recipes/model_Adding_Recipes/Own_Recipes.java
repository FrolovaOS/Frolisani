package com.example.Recipes.model_Adding_Recipes;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class Own_Recipes   implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "timestamp")
    public long timestamp;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "products")
    public String products;

    @ColumnInfo(name = "instruction")
    public String instruction;

    @ColumnInfo(name = "time")
    public String time;

    @ColumnInfo(name = "level")
    public String level;


    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] screen;



    public Own_Recipes(Parcel in) {
        uid = in.readInt();
        timestamp = in.readLong();
        name = in.readString();
        products = in.readString();
        instruction = in.readString();
        time = in.readString();
        level = in.readString();
        if(screen!=null) in.readByteArray(screen);


    }

    public Own_Recipes() {

    }

    public static final Creator<Own_Recipes> CREATOR = new Creator<Own_Recipes>() {
        @Override
        public Own_Recipes createFromParcel(Parcel in) {
            return new Own_Recipes(in);
        }

        @Override
        public Own_Recipes[] newArray(int size) {
            return new Own_Recipes[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Own_Recipes)) return false;
        Own_Recipes that = (Own_Recipes) o;
        return uid == that.uid &&
                timestamp == that.timestamp &&
                name.equals(that.name) &&
                products.equals(that.products) &&
                instruction.equals(that.instruction) &&
                time.equals(that.time) &&
                level.equals(that.level) &&
                Arrays.equals(screen, that.screen);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uid);
        dest.writeLong(timestamp);
        dest.writeString(name);
        dest.writeString(products);
        dest.writeString(instruction);
        dest.writeString(time);
        dest.writeString(level);
        dest.writeByteArray(screen);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        int result = Objects.hash(uid, timestamp, name, products, instruction, time, level);
        result = 31 * result + Arrays.hashCode(screen);
        return result;
    }




}

