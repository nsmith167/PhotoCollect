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
    private Date dateTime;
    private String tag;
    private ImageIcon image;
    
    public Item(String itemName)
    {
        this.itemName = itemName;
        this.description = "";
        this.value = 0;
        this.dateTime = new Date();
        this.tag = "";
        this.image = new ImageIcon("");
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
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
    
    
}
