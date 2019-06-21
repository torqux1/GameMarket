package com.models;
import android.os.Parcel;
import android.os.Parcelable;
import com.orm.SugarRecord;
import java.util.List;


public class GameCategory extends SugarRecord implements Parcelable {
    private String name;
    private String description;
    private String itemColor;
    private int image;


    public GameCategory(String name, String description, String itemColor, int image) {
        this.setName(name);
        this.setDescription(description);
        this.setItemColor(itemColor);
        this.setImage(image);
    }
	
    public List<CategoryItems> getAllCategoryItems(GameCategory category){
        return CategoryItems.find(CategoryItems.class, "category = ?",category.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    protected GameCategory(Parcel in) {
        name = in.readString();
        description = in.readString();
        itemColor = in.readString();
        image = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(itemColor);
        dest.writeInt(image);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<GameCategory> CREATOR = new Parcelable.Creator<GameCategory>() {
        @Override
        public GameCategory createFromParcel(Parcel in) {
            return new GameCategory(in);
        }

        @Override
        public GameCategory[] newArray(int size) {
            return new GameCategory[size];
        }
    };
}
