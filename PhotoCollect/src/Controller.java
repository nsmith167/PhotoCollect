
import java.util.ArrayList;
import java.util.ListIterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nathan
 */
public class Controller {
    private View view;
    private Collection currentCollection;
    private ArrayList<Collection> collections = new ArrayList<>();
    
    public Controller()
    {
        view = new View();
        //Initialize collections from persistent data
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
}
