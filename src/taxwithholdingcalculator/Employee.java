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
 * Employee Super Class
 * 
 * Author: Brock M. Hunter
 * Started: 08/09/2018
 * Completed: 08/09/2018
 * Revised: 08/14/2018 - added additional medicare tax eligibility and social 
 *          security tax eligibility methods and variables.
 *          08/16/2018 - added additional federal & state tax withholding 
 *          variables and methods. Updated federal tax to include additional
            withholding amount.
 * Testing: Passed 08/09/2018
 *          Revision Passed 08/14/2018
 *          Revision Passed 08/16/2018
 */

package taxwithholdingcalculator;

import java.math.BigDecimal;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author brock
 */

public class Employee {
    
    private int payFrequency;
    private int filingStatus;
    private int taxAllowances;
    private double addtlFedTax;
    private double addtlStateTax;
    private String filingState;
    boolean addtlMedTaxElig;
    boolean ssTaxElig;
    
    //CONSTRUCTOR
    public Employee() {
    int payFrequency    = 0;
    int filingStatus    = 0;
    int taxAllowances   = 0;
    double addtlFedTax = 0.0;
    String filingState  = "";
    boolean addtlMedTaxElig = false;
    boolean ssTaxElig = true;
    }//END constructor
    
    //PUBLIC METHODS
    //SET how frequently the employee is paid in num of checks per year
    public void setPayFrequency(int payFrequency) {
        
        switch (payFrequency) {
            case 1:
                this.payFrequency = 52;
                break;
            case 2:
                this.payFrequency = 26;
                break;
            case 3:
                this.payFrequency = 24;
                break;
            case 4:
                this.payFrequency = 12;
                break;
            default:
                this.payFrequency = 0;
                break;
        }
    }//END setPayFrequency()
    
    //RETURN pay frequency
    public int getPayFrequency() {
        return this.payFrequency;
    }//END getPayFrequency()
    
    //SET tax filing status
    public void setFilingStatus(int filingStatus) {
        //SWITCH filing status
        switch (filingStatus) {
            case 1: //Single
                this.filingStatus = 1;
                break;
            case 2: //Married filing jointly
                this.filingStatus = 2;
                break;
            case 3: //Married filing separately
                this.filingStatus = 3;
                break;
            case 4: //Head of household
                this.filingStatus = 4;
                break;
            default:
                this.filingStatus = 1;
                break;
        }
    }//END setFilingStatus()
    
    //RETURN filing status
    public int getFilingStatus() {
        return this.filingStatus;
    }//END getFilingStatus
    
    //SET number of tax exemptions
    public void setTaxAllowances(int numTaxAllowances) {
        //IF number of exemptions is less than or equal to 0 set to 0
        if (numTaxAllowances <= 0) {
            this.taxAllowances = 0;
        }
        //ELSE IF number of exemptions is greater than or equal to 10 set to 10
        else if (numTaxAllowances >= 10) {
            this.taxAllowances = 10;
        }
        //ELSE if exemptions are 1-9
        else {
            this.taxAllowances = numTaxAllowances;
        }
    }//END setTaxExemptions()
    
    //RETURN number of withholding allowances
    public int getTaxAllowances() {
        return this.taxAllowances;
    }//END getTaxAllowances()
    
    //SET additional federal withholding amount
    public void setAddtlFedTax(double addtlFedTax) {
        BigDecimal bd = new BigDecimal(addtlFedTax);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.addtlFedTax = bd.doubleValue();
    }
    
    //RETURN additional federal withholding amount
    public double getAddtlFedTax() {
        return this.addtlFedTax;
    }
    
    //SET additional state withholding amount
    public void setAddtlStateTax(double addtlStateTax) {
        BigDecimal bd = new BigDecimal(addtlStateTax);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.addtlStateTax = bd.doubleValue();
    }
    
    //RETURN additional state withholding amount
    public double getAddtlStateTax() {
        return this.addtlStateTax;
    }
    
    //SET filing state name
    public void setFilingState(String filingState) 
            throws FileNotFoundException {
        FileInputStream inFile = null;
        Scanner fileIn = null;
        String fileLine = null;
        
        //CAST input to upper-case
        filingState = filingState.toUpperCase();
        // OPEN list of states file
        inFile = new FileInputStream("states.txt");
        fileIn = new Scanner(inFile);
        
        //WHILE states file has next line
            while (fileIn.hasNextLine()) {
		//READ states file line
                fileLine = fileIn.nextLine();
                //IF filing state input is located in file line
                if (fileLine.contains(filingState)) {
                    this.filingState = filingState;
                    break;
                }
                else {
                    this.filingState = "INVALID";
                }
            }
        
        
    }//END setFilingState()
    
    //RETURN filing state
    public String getFilingState() {
        return this.filingState;
    }//END getFilingState()
    
    //SET additional medicare withholding eligibility
    public void setAddtlMedTaxElig(boolean addtlMedTaxElig) {
        this.addtlMedTaxElig = addtlMedTaxElig;
    }
    
    //RETURN additional medicare withholding eligibility
    public boolean getAddtlMedTaxElig() {
        return this.addtlMedTaxElig;
    }
    
    //SET Social Security tax withholding eligibility
    public void setSSTaxElig(boolean ssTaxElig) {
        this.ssTaxElig = ssTaxElig;
    }
    
    //RETURN Social Security tax withholding eligibility
    public boolean getSSTaxElig() {
        return this.ssTaxElig;
    }

}//ENDCLASS Employee
