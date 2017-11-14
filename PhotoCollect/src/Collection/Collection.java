package Collection;

import java.util.ArrayList;
import java.util.Date;
import Item.Item;

/**
 * Represents a collection of photos and associated data
 * @author nps5120
 */
public class Collection {
    
    private String title;
    private ArrayList<Item> items = new ArrayList<>();
    private int totalItems;
    private int totalValue;
    private double avgRating;
    private Date collectionStartDate;
    private String latestItem;
    
    public Collection(String title)
    {
        this.title = title;
        this.collectionStartDate = new Date();
        this.totalItems = 0;
        this.totalValue = 0;
        this.avgRating = 0;
        this.latestItem = "";
    }
    
    public void addItem(Item item)
    {
        items.add(item);
        totalItems++;
        totalValue += item.getValue();
        avgRating = totalValue/totalItems;
        latestItem = item.getItemName();
    }
    
    public void removeItem(Item item)
    {
        items.remove(item);
        totalItems--;
        totalValue -= item.getValue();
        
        if (totalItems == 0)
        {
            avgRating = 0;
            latestItem = "";
        }
        else 
        {
            avgRating = totalValue/totalItems;
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
    
    public double getTotalValue()
    {
        return this.totalValue;
    }
    
    public double getAverageRating()
    {
        return this.avgRating;
    }
    
    public Date getStartDate()
    {
        return this.collectionStartDate;
    }
    
    public String getLatestItem()
    {
        return this.latestItem;
    }
}
