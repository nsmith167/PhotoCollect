
import java.awt.Image;
import java.util.Date;

/**
 * Represents photo and photo data.
 * @author nps5120
 */
class Item {
    private String itemName;
    private String description;
    private float value;
    private Date dateTime;
    private String tag;
    private Image image;
    
    public Item(String itemName, String description, float value, Date dateTime, String tag, Image image)
    {
        this.itemName = itemName;
        this.description = description;
        this.value = value;
        this.dateTime = dateTime;
        this.tag = tag;
        this.image = image;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    
}
