/*
 * Income tax withholding calculator that calculates estimated federal, state, 
 * and FICA tax withholdings based on appropriate filing status, income amount, 
 * tax brackets, and state of residence. Can be calculated on exempt employee 
 * gross annual salary amount or non-exempt employee hourly wage and hours 
 * worked.
 * 
 * ALPHA VERSION
 * STATE TAX NOT AVAILABLE - ONLY FOR AK, FL, NV, NH, SD, TN, TX, WA, WY
 * 
 * Config File to save employee settings
 * 
 * Author: Brock M. Hunter
 * Started: 08/30/2018
 * Completed: ?
 * Revised: ?
 * Testing: ?
 */

package taxwithholdingcalculator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static Properties properties = new Properties();
    
    public void saveProperties(String title, String value) {
        
        try {
            properties.setProperty(title, value);
            properties.store(new FileOutputStream("config.tax"), null);
        }
        catch (IOException e) {
            
        }
    }
}
