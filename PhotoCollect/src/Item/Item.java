package Item;

import java.util.Date;
import javax.swing.ImageIcon;

/**
 * Represents photo and photo data.
 * @author nps5120
 */
public class Item {
    private String itemName;
    private String description;
    private float value;
    private String date;
    private String tag;
    private String imagePath;
    private ImageIcon image;
    
    public Item(String itemName)
    {
        this.itemName = itemName;
        this.description = "";
        this.value = 0;
        this.date = "";
        this.tag = "";
        this.imagePath = "";
        this.image = new ImageIcon(imagePath);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public String getImagePath()
    {
        return this.imagePath;
    }
    
    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }
    
    
}
