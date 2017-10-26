
import java.util.ArrayList;

/**
 * Represents a collection of photos and associated data
 * @author nps5120
 */
public class Collection {
    
    private String title;
    private ArrayList<Item> items = new ArrayList<>();
    
    public Collection(String title)
    {
        this.title = title;
    }
    
    public void addItem(Item item)
    {
        items.add(item);
    }
    
    public void removeItem(Item item)
    {
        items.remove(item);
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
}
