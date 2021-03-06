package Item;

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
    private String imagePath;
    private ImageIcon image;
    private int rating;
    
    public Item(String itemName)
    {
        this.itemName = itemName;
        this.description = "";
        this.value = 0;
        this.date = "";
        this.imagePath = "";
        this.image = new ImageIcon(imagePath);
        this.rating = 0;
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
    
    public int getRating(){
        return rating;
    }

    public void setDate(String date) {
        this.date = date;
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
    
    public void setRating(int newRating){
        this.rating = newRating;
    }
    
    
}
