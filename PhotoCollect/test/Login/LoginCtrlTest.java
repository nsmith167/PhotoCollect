/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajr5723
 */
public class LoginCtrlTest {
    
    public LoginCtrlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of requestAuthenticate method, of class LoginCtrl.
     */
    @Test
    public void testRequestAuthenticate() {
        System.out.println("requestAuthenticate");
        String usernameToCheck = "";
        char[] passwordToCheck = null;
        LoginCtrl instance = new LoginCtrl();
        boolean expResult = false;
        boolean result = instance.requestAuthenticate(usernameToCheck, passwordToCheck);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of requestNagivationCtrl method, of class LoginCtrl.
     */
    @Test
    public void testRequestNagivationCtrl() {
        System.out.println("requestNagivationCtrl");
        LoginCtrl instance = new LoginCtrl();
        instance.requestNagivationCtrl();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
