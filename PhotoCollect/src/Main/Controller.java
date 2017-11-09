package Main;


import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import Collection.Collection;
import Item.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
//        //Connect to database
//        Database db = new Database();
//        Connection connection = db.connectDB();
//        
//        
//        try
//        {
//            //Create query for getting collections
//            PreparedStatement collectionQuery = connection.prepareStatement("SELECT * FROM Collections;");
//            PreparedStatement itemsQuery = connection.prepareStatement("SELECT * FROM Items;");
//            
//            //Get result set from query
//            ResultSet collectionRS = collectionQuery.executeQuery();
//            ResultSet itemsRS = itemsQuery.executeQuery();
//            
//            //Populate collections ArrayList with results
//            collectionRS.first();
//            while (!(collectionRS.isAfterLast()))
//            {
//                collections.add(new Collection(collectionRS.getString("Name")));
//                //TODO populate items for each collection
//            }
//        }
//        catch(SQLException e)
//        {
//            System.out.println("Database connection failed");
//        }
        
        //TEST
        Collection testCollection = new Collection("Test");
        Item testItem = new Item("TEST");
        testCollection.addItem(testItem);
        collections.add(testCollection);
        
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
        
        if(!(collectionIter.hasNext()))
            //Display error that collection could not be found
            System.out.println("Collection could not be found");
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
     * Display the given item and its details.
     * @param item 
     */
    public void showItem(Item item)
    {
        
    }
    
    /**
     * Interface for adding a new item to the current collection. To be called by the view.
     * @param name
     * @param description
     * @param value
     * @param dateTime
     * @param tag
     * @param image 
     */
    public void addItem(String name, String description, float value, Date dateTime, String tag, Image image)
    {
        currentCollection.addItem(new Item(name));
    }
}
