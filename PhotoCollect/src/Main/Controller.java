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
    private Database db;
    private Connection connection;
    private int latestID;
    
    public Controller()
    {
        //Connect to database
        db = new Database();
        connection = db.connectDB();
        
        
        try
        {
            //Create query for getting collections
            PreparedStatement collectionQuery = connection.prepareStatement("SELECT * FROM collections;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //Get result set from query
            ResultSet collectionRS = collectionQuery.executeQuery();
            ResultSet itemRS = null;
            
            //Populate collections ArrayList with results
            collectionRS.first();
            int collectionID = 0;
            latestID = 0;
            while (!(collectionRS.isAfterLast()))
            {
                Collection newCollection = new Collection(collectionRS.getString("title"));
                collectionID = collectionRS.getInt("collection_id");
                
                //Determine what the highest existing collectionID is
                if(latestID < collectionID)
                {
                    latestID = collectionID;
                }
                
                newCollection.setCollectionID(collectionID);
                newCollection.setStartDate(collectionRS.getString("startDate"));
               
                //Create query to get items for collection
                PreparedStatement itemsQuery = connection.prepareStatement("SELECT * FROM items WHERE collection_id = " + collectionID +";", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                itemRS = itemsQuery.executeQuery();
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
            
            collectionRS.close();
            itemRS.close();
            connection.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        //Initialize UI 
        this.mainUI = new MainUI(this);
    }
    
    /**
     * Save the given collection under the given name.
     * @param collection
     * @param name 
     */
    public void saveCollection(Collection collection)
    {
        //Connect to database
        db = new Database();
        connection = db.connectDB();
        
        try 
        {
            //Delete and Insert are used rather than Update to account for our inability to determine which collections are new and which exist in the db already
            PreparedStatement deleteQuery = connection.prepareStatement("DELETE FROM collections WHERE collection_id = " + collection.getCollectionID() + ";");
            deleteQuery.execute();
            
            PreparedStatement insertQuery = connection.prepareStatement("INSERT INTO dbo.collections VALUES (" + collection.getCollectionID() 
                    + ",'" + collection.getTitle() + "', " + collection.getTotalItems() + ", " + String.format("%.2f",collection.getTotalValue())
                    + ", " + collection.getAverageRating() + ", '" + collection.getStartDate() + "', '" + collection.getLatestItem() + "');");
            insertQuery.execute();
            
            //Clear existing items from collection in database
            PreparedStatement clearItemsQuery = connection.prepareStatement("DELETE FROM items WHERE collection_id = " + collection.getCollectionID() + ";");
            clearItemsQuery.execute();
            
            //Save items in collection
            PreparedStatement insertItemQuery = null;
            for (Item item: collection.getItems())
            {
                insertItemQuery = connection.prepareStatement("INSERT INTO dbo.items VALUES ('" + item.getItemName() + "','" + item.getDescription()
                        + "'," + String.format("%.2f",item.getValue()) + ",'" + item.getDate() + "','" + item.getImagePath()
                        + "'," + collection.getCollectionID() + "," + item.getRating() + ");");
                insertItemQuery.execute();
            }

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
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
        //TODO assign date
        //TODO assign collection
        return newCollection;
    }
    
    public ArrayList<Collection> getCollections()
    {
        return this.collections;
    }
    
    public int getLatestID()
    {
        if (this.latestID == 0)
            return this.latestID;
        else
            return this.latestID + 1;
    }

}
