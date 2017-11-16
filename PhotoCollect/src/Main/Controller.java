package Main;


import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import Collection.Collection;
import Item.Item;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;

/**
 *
 * @author Nathan
 */
public class Controller {
    private Collection currentCollection;
    private ArrayList<Collection> collections = new ArrayList<>();
    private MainUI mainUI;
    
    public Controller()
    {
        //Connect to database
        Database db = new Database();
        Connection connection = db.connectDB();
        
        
        try
        {
            //Create query for getting collections
            PreparedStatement collectionQuery = connection.prepareStatement("SELECT * FROM collections;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //Get result set from query
            ResultSet collectionRS = collectionQuery.executeQuery();
            
            //Populate collections ArrayList with results
            collectionRS.first();
            int collectionID = 0;
            while (!(collectionRS.isAfterLast()))
            {
                collectionID++;
                Collection newCollection = new Collection(collectionRS.getString("title"));
                newCollection.setStartDate(collectionRS.getString("startDate"));
               //Create query to get items for collection
                PreparedStatement itemsQuery = connection.prepareStatement("SELECT * FROM items WHERE collection_id = " + collectionID +";", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet itemRS = itemsQuery.executeQuery();
                itemRS.first();
                while(!(itemRS.isAfterLast()))
                {
                    Item newItem = new Item(itemRS.getString("name"));
                    newItem.setDescription(itemRS.getString("description"));
                    newItem.setValue(itemRS.getFloat("value"));
                    newItem.setDate(itemRS.getString("date"));
                    newItem.setImagePath(itemRS.getString("imagePath"));
                    ImageIcon itemImage = new ImageIcon(itemRS.getString("imagePath"));
                    newItem.setImage(itemImage);
                    newItem.setRating(itemRS.getInt("rating"));
                    newCollection.addItem(newItem);
                    itemRS.next();
                }
                collections.add(newCollection); 
                collectionRS.next();
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        //Initialize UI with collections
        this.mainUI = new MainUI(collections);
    }
    
    /**
     * Set current collection based on string parameter.
     * @param collection 
     */
    public void loadCollection(String collection)
    {
        boolean collectionFound = false;
        ListIterator<Collection> collectionIter = collections.listIterator();
        Collection c = collectionIter.next();
        
        while(collectionFound == false && collectionIter.hasNext())
        {
            if(c.getTitle().equals(collection))
            {
                currentCollection = c;
                collectionFound = true;
            }
            else
                collectionIter.next();
        }
        
        //Collection not found
        if((!(collectionIter.hasNext())) && (!(collectionFound)))
        {
            System.out.println("Collection could not be found");
        }
    }
    
    /**
     * Save the given collection under the given name.
     * @param collection
     * @param name 
     */
    public void saveCollection(Collection collection, String name)
    {
        
    }
    
    /**
     * Export given collection to folder.
     * @param collection
     * @param name 
     */
    public void exportCollection(Collection collection, String name)
    {
        
    }
    
    
    /**
     * Import selected collection.
     * @return newCollection
     */
    public Collection importCollection()
    {
        File selectedFile = new File("");
        Collection newCollection = new Collection(selectedFile.getName());
        return newCollection;
    }

}
