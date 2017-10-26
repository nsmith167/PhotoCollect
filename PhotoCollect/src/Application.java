
import Login.*;

/**
 * Main application class 
 * @author nps5120
 */


public class Application {

    public static void main(String[] args)
    {
        Controller controller = new Controller();
        System.out.println("Main class initialized.");
        
        LoginUI aUI = new LoginUI(new LoginCtrl());
        aUI.setVisible(true);
    }
    
}
