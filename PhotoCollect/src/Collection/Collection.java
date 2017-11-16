package Collection;

import java.util.ArrayList;
import Item.Item;

/**
 * Represents a collection of photos and associated data
 * @author nps5120
 */
public class Collection {
    
    private String title;
    private ArrayList<Item> items = new ArrayList<>();
    private int totalItems;
    private float totalValue;
    private int totalRating;
    private double avgRating;
    private String collectionStartDate;
    private String latestItem;
    
    public Collection(String title)
    {
        this.title = title;
        this.collectionStartDate = "";
        this.totalItems = 0;
        this.totalValue = 0;
        this.totalRating = 0;
        this.avgRating = 0;
        this.latestItem = "";
    }
    
    public void addItem(Item item)
    {
        items.add(item);
        totalItems++;
        totalValue += item.getValue();
        totalRating += item.getRating();
        avgRating = totalRating/totalItems;
        latestItem = item.getItemName();
    }
    
    public void removeItem(Item item)
    {
        items.remove(item);
        totalItems--;
        totalValue -= item.getValue();
        totalRating -= item.getRating();
        
        if (totalItems == 0)
        {
            avgRating = 0;
            latestItem = "";
        }
        else 
        {
            avgRating = totalRating/totalItems;
            latestItem = items.get(items.size() - 1).getItemName();
        }
        
        
    }
    
    public void sort()
    {
        
    }
    
    public void search(String key)
    {
        
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public ArrayList<Item> getItems()
    {
        return this.items;
    }
    
    public int getTotalItems()
    {
        return this.totalItems;
    }
    
    public float getTotalValue()
    {
        return this.totalValue;
    }
    
    public double getAverageRating()
    {
        return this.avgRating;
    }
    
    public String getStartDate()
    {
        return this.collectionStartDate;
    }
    
    public void setStartDate(String date)
    {
        this.collectionStartDate = date;
    }
    
    public String getLatestItem()
    {
        return this.latestItem;
    }
}
