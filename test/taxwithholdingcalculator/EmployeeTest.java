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
 * Employee class JUnit test
 * 
 * Author: Brock M. Hunter
 * Started: 08/09/2018
 * Completed: 08/09/2018
 * Revised: 08/12/2018 - Migrated to JUnit test from user-created test classes
 *          08/14/2018 - Added tests for set/get medicare and social security 
 *          tax eligibility variables.
 *          08/16/2018 - Added tests for set/get additional state and federal
 *          tax withholding amounts.
 */

package taxwithholdingcalculator;

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brock
 */
public class EmployeeTest {
    
    public EmployeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("TESTING STARTED");
        System.out.println("");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("");
        System.out.println("TESTING COMPLETED");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPayFrequency & getPayFrequency methods, of class Employee.
     */

    @Test
    public void testPayFrequency() {
        System.out.println("BEGIN TESTING SET/GET PAY FREQUENCY");
        Employee testEmp = new Employee();

        testEmp.setPayFrequency(1);
        if (testEmp.getPayFrequency() != 52) {
            System.out.println("FAILED SET/GET PAY FREQUENCY. EXPECTED: 52 "
                    + "RETURNED: " + testEmp.getPayFrequency());
        }
        testEmp.setPayFrequency(2);
        if (testEmp.getPayFrequency() != 26) {
            System.out.println("FAILED SET/GET PAY FREQUENCY. EXPECTED: 26 "
                    + "RETURNED: " + testEmp.getPayFrequency());
        }
        testEmp.setPayFrequency(3);
        if (testEmp.getPayFrequency() != 24) {
            System.out.println("FAILED SET/GET PAY FREQUENCY. EXPECTED: 24 "
                    + "RETURNED: " + testEmp.getPayFrequency());
        }
        testEmp.setPayFrequency(4);
        if (testEmp.getPayFrequency() != 12) {
            System.out.println("FAILED SET/GET PAY FREQUENCY. EXPECTED: 12 "
                    + "RETURNED: " + testEmp.getPayFrequency());
        }
        testEmp.setPayFrequency(5);
        if (testEmp.getPayFrequency() != 0) {
            System.out.println("FAILED SET/GET PAY FREQUENCY. EXPECTED: 0 "
                    + "RETURNED: " + testEmp.getPayFrequency());
        }
        testEmp.setPayFrequency(0);
        if (testEmp.getPayFrequency() != 0) {
            System.out.println("FAILED SET/GET PAY FREQUENCY. EXPECTED: 0 "
                    + "RETURNED: " + testEmp.getPayFrequency());
        }
        testEmp.setPayFrequency(100);
        if (testEmp.getPayFrequency() != 0) {
            System.out.println("FAILED SET/GET PAY FREQUENCY. EXPECTED: 0 "
                    + "RETURNED: " + testEmp.getPayFrequency());
        }
    }

    /**
     * Test of setFilingStatus & getFilingStatus methods, of class Employee.
     */

    @Test
    public void testFilingStatus() {
        System.out.println("BEGIN TESTING SET/GET FILING STATUS");
        Employee testEmp = new Employee();
        
        testEmp.setFilingStatus(1);
        if (testEmp.getFilingStatus() != 1) {
            System.out.println("FAILED SET/GET FILING STATUS. EXPECTED: 1 "
                    + "RETURNED: " + testEmp.getFilingStatus());
        }
        testEmp.setFilingStatus(2);
        if (testEmp.getFilingStatus() != 2) {
            System.out.println("FAILED SET/GET FILING STATUS. EXPECTED: 2 "
                    + "RETURNED: " + testEmp.getFilingStatus());
        }
        testEmp.setFilingStatus(3);
        if (testEmp.getFilingStatus() != 3) {
            System.out.println("FAILED SET/GET FILING STATUS. EXPECTED: 3 "
                    + "RETURNED: " + testEmp.getFilingStatus());
        }
        testEmp.setFilingStatus(4);
        if (testEmp.getFilingStatus() != 4) {
            System.out.println("FAILED SET/GET FILING STATUS. EXPECTED: 4 "
                    + "RETURNED: " + testEmp.getFilingStatus());
        }
        testEmp.setFilingStatus(0);
        if (testEmp.getFilingStatus() != 1) {
            System.out.println("FAILED SET/GET FILING STATUS. EXPECTED: 1 "
                    + "RETURNED: " + testEmp.getFilingStatus());
        }
        testEmp.setFilingStatus(6);
        if (testEmp.getFilingStatus() != 1) {
            System.out.println("FAILED SET/GET FILING STATUS. EXPECTED: 1 "
                    + "RETURNED: " + testEmp.getFilingStatus());
        }
        testEmp.setFilingStatus(100);
        if (testEmp.getFilingStatus() != 1) {
            System.out.println("FAILED SET/GET FILING STATUS. EXPECTED: 1 "
                    + "RETURNED: " + testEmp.getFilingStatus());
        }
    }

    /**
     * Test of setTaxAllowances & getTaxAllowances methods, of class Employee.
     */

    @Test
    public void testTaxAllowances() {
        System.out.println("BEGIN TESTING SET/GET ALLOWANCES");
        Employee testEmp = new Employee();
        
        testEmp.setTaxAllowances(-1);
        if (testEmp.getTaxAllowances() != 0) {
            System.out.println("FAILED SET/GET TAX ALLOWANCES. EXPECTED: 0 "
                    + "RETURNED: " + testEmp.getTaxAllowances());
        }
        testEmp.setTaxAllowances(0);
        if (testEmp.getTaxAllowances() != 0) {
            System.out.println("FAILED SET/GET TAX ALLOWANCES. EXPECTED: 0 "
                    + "RETURNED: " + testEmp.getTaxAllowances());
        }
        testEmp.setTaxAllowances(1);
        if (testEmp.getTaxAllowances() != 1) {
            System.out.println("FAILED SET/GET TAX ALLOWANCES. EXPECTED: 1 "
                    + "RETURNED: " + testEmp.getTaxAllowances());
        }
        testEmp.setTaxAllowances(7);
        if (testEmp.getTaxAllowances() != 7) {
            System.out.println("FAILED SET/GET TAX ALLOWANCES. EXPECTED: 7 "
                    + "RETURNED: " + testEmp.getTaxAllowances());
        }
        testEmp.setTaxAllowances(10);
        if (testEmp.getTaxAllowances() != 10) {
            System.out.println("FAILED SET/GET TAX ALLOWANCES. EXPECTED: 10 "
                    + "RETURNED: " + testEmp.getTaxAllowances());
        }
        testEmp.setTaxAllowances(25);
        if (testEmp.getTaxAllowances() != 10) {
            System.out.println("FAILED SET/GET TAX ALLOWANCES. EXPECTED: 10 "
                    + "RETURNED: " + testEmp.getTaxAllowances());
        }
    }

    /**
     * Test of setFilingState and getFilingState methods, of class Employee.
     */

    @Test
    public void testFilingState() throws FileNotFoundException {
        System.out.println("BEGIN TESTING SET/GET FILING STATE");
        String filingState = " ";
        Employee testEmp = new Employee();
        
        testEmp.setFilingState("FL");
        filingState = testEmp.getFilingState();
        if (filingState.compareTo("FL") != 0){
            System.out.println("FAILED SET/GET FILING STATE. EXPECTED: FL"
                    + " RETURNED: " + testEmp.getFilingState());
        }
        testEmp.setFilingState("fl");
        filingState = testEmp.getFilingState();
        if (filingState.compareTo("FL") != 0){
            System.out.println("FAILED SET/GET FILING STATE. EXPECTED: FL"
                    + " RETURNED: " + testEmp.getFilingState());
        }
        testEmp.setFilingState("co");
        filingState = testEmp.getFilingState();
        if (filingState.compareTo("CO") != 0){
            System.out.println("FAILED SET/GET FILING STATE. EXPECTED: CO"
                    + " RETURNED: " + testEmp.getFilingState());
        }
        testEmp.setFilingState("ky");
        filingState = testEmp.getFilingState();
        if (filingState.compareTo("KY") != 0){
            System.out.println("FAILED SET/GET FILING STATE. EXPECTED: KY"
                    + " RETURNED: " + testEmp.getFilingState());
        }
        testEmp.setFilingState("united states");
        filingState = testEmp.getFilingState();
        if (filingState.compareTo("INVALID") != 0){
            System.out.println("FAILED SET/GET FILING STATE. EXPECTED: "
                    + "INVALID RETURNED: " + testEmp.getFilingState());
        }
    }

    /**
     * Test of setAddtlMedTaxElig & getAddtlMedTaxElig methods, of class 
     * Employee.
     */
    
    @Test
    public void testAddtlMedTaxElig() {
        System.out.println("BEGIN TESTING SET/GET ADDTL MED TAX ELIG");
        //boolean addtlMedTaxElig = false;
        Employee testEmp = new Employee();
        
        testEmp.setAddtlMedTaxElig(false);
        if (testEmp.getAddtlMedTaxElig() != false) {
            System.out.println("FAILED SET/GET ADDTL MED TAX ELIG. EXPECTED: "
                    + "FALSE RETURNED: " + testEmp.getAddtlMedTaxElig());
        }
        testEmp.setAddtlMedTaxElig(true);
        if (testEmp.getAddtlMedTaxElig() != true) {
            System.out.println("FAILED SET/GET ADDTL MED TAX ELIG. EXPECTED: "
                    + "TRUE RETURNED: " + testEmp.getAddtlMedTaxElig());
        }
    }

    /**
     * Test of setSSTaxElig & getSSTaxElig methods, of class Employee.
     */
    
    @Test
    public void testSSTaxElig() {
        System.out.println("BEGIN TESTING SET/GET SS TAX ELIG");
        Employee testEmp = new Employee();
        
        testEmp.setSSTaxElig(false);
        if (testEmp.getSSTaxElig() != false) {
            System.out.println("FAILED SET/GET SS TAX ELIG. EXPECTED: "
                    + "FALSE RETURNED: " + testEmp.getSSTaxElig());
        }
        testEmp.setSSTaxElig(true);
        if (testEmp.getSSTaxElig() != true) {
            System.out.println("FAILED SET/GET SS TAX ELIG. EXPECTED: "
                    + "TRUE RETURNED: " + testEmp.getSSTaxElig());
        }
    }
    
     /**
     * Test of setAddtlFedTax & getAddtlFedTax methods, of class Employee.
     */
    
    @Test
    public void testAddtlFedTax() {
        System.out.println("BEGIN TESTING SET/GET ADDTL FED TAX.");
        Employee testEmp = new Employee();
        
        testEmp.setAddtlFedTax(10.00);
        if (testEmp.getAddtlFedTax() != 10.00) {
            System.out.println("FAILED SET/GET ADDTL FED TAX. EXPECTED 10.00"
                    + " RETURNED: " + testEmp.getAddtlFedTax());
        }
        testEmp.setAddtlFedTax(25.50);
        if (testEmp.getAddtlFedTax() != 25.50) {
            System.out.println("FAILED SET/GET ADDTL FED TAX. EXPECTED 25.50"
                    + " RETURNED: " + testEmp.getAddtlFedTax());
        }
        testEmp.setAddtlFedTax(175.25);
        if (testEmp.getAddtlFedTax() != 175.25) {
            System.out.println("FAILED SET/GET ADDTL FED TAX. EXPECTED 175.25"
                    + " RETURNED: " + testEmp.getAddtlFedTax());
        }
    }
    
     /**
     * Test of setAddtlStateTax & getAddtlStateTax methods, of class Employee.
     */
    
    @Test
    public void testAddtlStateTax() {
        System.out.println("BEGIN TESTING SET/GET ADDTL STATE TAX.");
        Employee testEmp = new Employee();
        
        testEmp.setAddtlStateTax(10.00);
        if (testEmp.getAddtlStateTax() != 10.00) {
            System.out.println("FAILED SET/GET ADDTL STATE TAX. EXPECTED 10.00"
                    + " RETURNED: " + testEmp.getAddtlStateTax());
        }
        testEmp.setAddtlStateTax(25.50);
        if (testEmp.getAddtlStateTax() != 25.50) {
            System.out.println("FAILED SET/GET ADDTL STATE TAX. EXPECTED 25.50"
                    + " RETURNED: " + testEmp.getAddtlStateTax());
        }
        testEmp.setAddtlStateTax(175.25);
        if (testEmp.getAddtlStateTax() != 175.25) {
            System.out.println("FAILED SET/GET ADDTL STATE TAX. EXPECTED 175.25"
                    + " RETURNED: " + testEmp.getAddtlStateTax());
        }
    }
}
