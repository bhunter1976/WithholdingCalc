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
 * Salary Employee class JUnit test
 * 
 * Author: Brock M. Hunter
 * Started: 08/09/2018
 * Completed: 08/20/2018
 * Revised: 08/12/2018 - Migrated to JUnit test from user-created test classes
 */
package taxwithholdingcalculator;

import java.text.ParseException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brock
 */
public class HourlyEmployeeTest {
    
    public HourlyEmployeeTest() {
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

    /**
     * Test of setHourlyWage & getHourlyWage methods, of class HourlyEmployee.
     */
    @Test
    public void testHourlyWage() {
        System.out.println("BEGIN TESTING SET/GET HOURLY WAGE.");
        HourlyEmployee testEmp = new HourlyEmployee();
        testEmp.setHourlyWage(10.00);
        if (testEmp.getHourlyWage() != 10.00) {
            System.out.println("FAILED SET/GET HOURLY WAGE. EXPECTED: 10.00 "
                    + "RETURNED: " + testEmp.getHourlyWage());
        }
        testEmp.setHourlyWage(20.00);
        if (testEmp.getHourlyWage() != 20.00) {
            System.out.println("FAILED SET/GET HOURLY WAGE. EXPECTED: 20.00 "
                    + "RETURNED: " + testEmp.getHourlyWage());
        }
        testEmp.setHourlyWage(45.78);
        if (testEmp.getHourlyWage() != 45.78) {
            System.out.println("FAILED SET/GET HOURLY WAGE. EXPECTED: 45.78 "
                    + "RETURNED: " + testEmp.getHourlyWage());
        }
        testEmp.setHourlyWage(125.25);
        if (testEmp.getHourlyWage() != 125.25) {
            System.out.println("FAILED SET/GET HOURLY WAGE. EXPECTED: 125.25 "
                    + "RETURNED: " + testEmp.getHourlyWage());
        }
    }

    /**
     * Test of setOTWage & getOTWage methods, of class HourlyEmployee.
     */

    @Test
    public void testOTWage() {
        System.out.println("BEGIN TESTING SET/GET OT WAGE.");
        HourlyEmployee testEmp = new HourlyEmployee();
        
        testEmp.setHourlyWage(125.25);
        testEmp.setOTWage();
        if (testEmp.getOTWage() != 187.88) {
            System.out.println("FAILED SET/GET OT WAGE. EXPECTED: 187.88 "
                    + "RETURNED: " + testEmp.getOTWage());
        }
        testEmp.setHourlyWage(10.00);
        testEmp.setOTWage();
        if (testEmp.getOTWage() != 15.00) {
            System.out.println("FAILED SET/GET OT WAGE. EXPECTED: 15.00 "
                    + "RETURNED: " + testEmp.getOTWage());
        }
        testEmp.setHourlyWage(25.75);
        testEmp.setOTWage();
        if (testEmp.getOTWage() != 38.63) {
            System.out.println("FAILED SET/GET OT WAGE. EXPECTED: 38.63 "
                    + "RETURNED: " + testEmp.getOTWage());
        }
        testEmp.setHourlyWage(45.23);
        testEmp.setOTWage();
        if (testEmp.getOTWage() != 67.85) {
            System.out.println("FAILED SET/GET OT WAGE. EXPECTED: 67.85 "
                    + "RETURNED: " + testEmp.getOTWage());
        }
        
    }

    /**
     * Test of setTotalHours & getTotalHours methods, of class HourlyEmployee.
     */

    @Test
    public void testTotalHours() {
        System.out.println("BEGIN TESTING SET/GET TOTAL HOURS.");
        HourlyEmployee testEmp = new HourlyEmployee();
        
        testEmp.setTotalHours(40.00);
        if (testEmp.getTotalHours() != 40.00) {
            System.out.println("FAILED SET/GET TOTAL HOURS. EXPECTED: 40.00 "
                    + "RETURNED: " + testEmp.getTotalHours());
        }
        testEmp.setTotalHours(85.36);
        if (testEmp.getTotalHours() != 85.36) {
            System.out.println("FAILED SET/GET TOTAL HOURS. EXPECTED: 85.36 "
                    + "RETURNED: " + testEmp.getTotalHours());
        }
        testEmp.setTotalHours(42.01);
        if (testEmp.getTotalHours() != 42.01) {
            System.out.println("FAILED SET/GET TOTAL HOURS. EXPECTED: 42.01 "
                    + "RETURNED: " + testEmp.getTotalHours());
        }
    }

     /**
     * Test of setOTHours & getOTHours methods, of class HourlyEmployee.
     */

    @Test
    public void testOTHours() {
        System.out.println("BEGIN TESTING SET/GET OT HOURS.");
        HourlyEmployee testEmp = new HourlyEmployee();

        testEmp.setOTHours(8.00);
        if (testEmp.getOTHours() != 8.00) {
            System.out.println("FAILED SET/GET OT HOURS. EXPECTED: 8.00 "
                    + "RETURNED: " + testEmp.getOTHours());
        }
        testEmp.setOTHours(23.02);
        if (testEmp.getOTHours() != 23.02) {
            System.out.println("FAILED SET/GET OT HOURS. EXPECTED: 23.02 "
                    + "RETURNED: " + testEmp.getOTHours());
        }
        testEmp.setOTHours(129.72);
        if (testEmp.getOTHours() != 129.72) {
            System.out.println("FAILED SET/GET OT HOURS. EXPECTED: 129.72 "
                    + "RETURNED: " + testEmp.getOTHours());
        }
    }
    
    /**
     * Test of setStraightHours & getStraightHours methods, of class 
     * HourlyEmployee.
     */

    @Test
    public void testStraightHours() {
        System.out.println("BEGIN TESTING SET/GET STRAIGHT HOURS.");
        HourlyEmployee testEmp = new HourlyEmployee();
        
        testEmp.setTotalHours(48.00);
        testEmp.setOTHours(8.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        if (testEmp.getStraightHours() != 40.00) {
            System.out.println("FAILED SET/GET STRAIGHT HOURS. EXPECTED: 40.00 "
                    + "RETURNED: " + testEmp.getStraightHours());
        }
        testEmp.setTotalHours(82.64);
        testEmp.setOTHours(2.64);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        if (testEmp.getStraightHours() != 80.00) {
            System.out.println("FAILED SET/GET STRAIGHT HOURS. EXPECTED: 80.00 "
                    + "RETURNED: " + testEmp.getStraightHours());
        }
        testEmp.setTotalHours(82.64);
        testEmp.setOTHours(0.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        if (testEmp.getStraightHours() != 82.64) {
            System.out.println("FAILED SET/GET STRAIGHT HOURS. EXPECTED: 82.64 "
                    + "RETURNED: " + testEmp.getStraightHours());
        }
    }

    /**
     * Test of setStraightPay & getStraightPay methods, of class HourlyEmployee.
     */

    @Test
    public void testStraightPay() {
        System.out.println("BEGIN TESTING SET/GET STRAIGHT PAY.");
        HourlyEmployee testEmp = new HourlyEmployee();
        
        testEmp.setHourlyWage(10.00);
        testEmp.setTotalHours(82.64);
        testEmp.setOTHours(2.64);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();
        if (testEmp.getStraightPay() != 800.00) {
            System.out.println("FAILED SET/GET STRAIGHT PAY. EXPECTED: 800.00 "
                    + "RETURNED: " + testEmp.getStraightPay());
        }
        testEmp.setHourlyWage(22.53);
        testEmp.setTotalHours(56.24);
        testEmp.setOTHours(0.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();
        if (testEmp.getStraightPay() != 1267.09) {
            System.out.println("FAILED SET/GET STRAIGHT PAY. EXPECTED: 1267.09 "
                    + "RETURNED: " + testEmp.getStraightPay());
        }
    }

    /**
     * Test of setOTPay & getOTPay methods, of class HourlyEmployee.
     */

    @Test
    public void testOTPay() {
        System.out.println("BEGIN TESTING SET/GET OT PAY.");
        HourlyEmployee testEmp = new HourlyEmployee();
        
        testEmp.setHourlyWage(10.00);
        testEmp.setOTWage();
        testEmp.setTotalHours(56.24);
        testEmp.setOTHours(0.00);
        testEmp.setOTPay();
        if (testEmp.getOTPay() != 0.00) {
            System.out.println("FAILED SET/GET OT PAY. EXPECTED: 0.00 "
                    + "RETURNED: " + testEmp.getOTPay());
        }
        testEmp.setHourlyWage(22.68);
        testEmp.setOTWage();
        testEmp.setTotalHours(56.24);
        testEmp.setOTHours(16.24);
        testEmp.setOTPay();
        if (testEmp.getOTPay() != 552.48) {
            System.out.println("FAILED SET/GET OT PAY. EXPECTED: 552.48 "
                    + "RETURNED: " + testEmp.getOTPay());
        }
        testEmp.setHourlyWage(39.59);
        testEmp.setOTWage();
        testEmp.setTotalHours(56.24);
        testEmp.setOTHours(16.24);
        testEmp.setOTPay();
        if (testEmp.getOTPay() != 964.49) {
            System.out.println("FAILED SET/GET OT PAY. EXPECTED: 964.49 "
                    + "RETURNED: " + testEmp.getOTPay());
        }
    }

    /**
     * Test of setGrossPay & getGrossPay methods, of class HourlyEmployee.
     */

    @Test
    public void testSetGrossPay() throws Exception {
        System.out.println("BEGIN TESTING SET/GET GROSS PAY.");
        HourlyEmployee testEmp = new HourlyEmployee();
        
        testEmp.setHourlyWage(10.00);
        testEmp.setOTWage();
        testEmp.setTotalHours(56.24);
        testEmp.setOTHours(0.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();
        testEmp.setOTPay();
        testEmp.setGrossPay();
        if (testEmp.getGrossPay() != 562.40) {
            System.out.println("FAILED SET/GET GROSS PAY. EXPECTED: 562.40 "
                    + "RETURNED: " + testEmp.getGrossPay());
        }
        testEmp.setHourlyWage(22.50);
        testEmp.setOTWage(); //33.75
        testEmp.setTotalHours(56.24);
        testEmp.setOTHours(16.24);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay(); //900.00
        testEmp.setOTPay(); //548.10
        testEmp.setGrossPay();
        if (testEmp.getGrossPay() != 1448.10) {
            System.out.println("FAILED SET/GET GROSS PAY. EXPECTED: 1448.10 "
                    + "RETURNED: " + testEmp.getGrossPay());
        }
    }
    /**
     * Test of setPreTaxAmt & getPreTaxAmt methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */

    @Test
    public void testPreTaxAmt() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET PRE-TAX.");
        HourlyEmployee testEmp = new HourlyEmployee();
        
        testEmp.setPreTaxAmt(125.00);
        if (Math.abs(testEmp.getPreTaxAmt() - 125.00) > 0.0001) {
            System.out.println("FAILED SET/GET PRE-TAX AMT. EXPECTED: 125.00. "
                    + "RETURNED: " + testEmp.getPreTaxAmt());
        }
        testEmp.setPreTaxAmt(125);
        if (Math.abs(testEmp.getPreTaxAmt() - 125.00) > 0.0001) {
            System.out.println("FAILED SET/GET PRE-TAX AMT. EXPECTED: 125.00. "
                    + "RETURNED: " + testEmp.getPreTaxAmt());
        }
        testEmp.setPreTaxAmt(500.00);
        if (Math.abs(testEmp.getPreTaxAmt() - 500.00) > 0.0001) {
            System.out.println("FAILED SET/GET PRE-TAX AMT. EXPECTED: 500.00. "
                    + "RETURNED: " + testEmp.getPreTaxAmt());
        }
        testEmp.setPreTaxAmt(500);
        if (Math.abs(testEmp.getPreTaxAmt() - 500.00) > 0.0001) {
            System.out.println("FAILED SET/GET PRE-TAX AMT. EXPECTED: 500.00. "
                    + "RETURNED: " + testEmp.getPreTaxAmt());
        }
    }

    /**
     * Test of setPostTaxAmt & getPostTaxAmt methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */

    @Test
    public void testPostTaxAmt() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET POST-TAX.");
        double postTaxAmt = 0.0;
        HourlyEmployee testEmp = new HourlyEmployee();
        
        testEmp.setPostTaxAmt(125.00);
        if (Math.abs(testEmp.getPostTaxAmt() - 125.00) > 0.0001) {
            System.out.println("FAILED SET/GET POST-TAX AMT. EXPECTED: 125.00. "
                    + "RETURNED: " + testEmp.getPostTaxAmt());
        }
        testEmp.setPostTaxAmt(125);
        if (Math.abs(testEmp.getPostTaxAmt() - 125.00) > 0.0001) {
            System.out.println("FAILED SET/GET POST-TAX AMT. EXPECTED: 125.00. "
                    + "RETURNED: " + testEmp.getPostTaxAmt());
        }
        testEmp.setPostTaxAmt(500.00);
        if (Math.abs(testEmp.getPostTaxAmt() - 500.00) > 0.0001) {
            System.out.println("FAILED SET/GET POST-TAX AMT. EXPECTED: 500.00. "
                    + "RETURNED: " + testEmp.getPostTaxAmt());
        }
        testEmp.setPostTaxAmt(500);
        if (Math.abs(testEmp.getPostTaxAmt() - 500.00) > 0.0001) {
            System.out.println("FAILED SET/GET POST-TAX AMT. EXPECTED: 500.00. "
                    + "RETURNED: " + testEmp.getPostTaxAmt());
        }
    }

    /**
     * Test of setAllowanceAmt & getAllowanceAmt methods, of class 
     * SalaryEmployee.
     * @throws java.text.ParseException
     */

    @Test
    public void testAllowanceAmt() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET ALLOWANCE AMOUNT.");
        HourlyEmployee testEmp = new HourlyEmployee();
        //Paid weekly with 0 allowances
        testEmp.setPayFrequency(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 0.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: 0.00"
                    + "RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid weekly with 1 allowances
        testEmp.setPayFrequency(1);
        testEmp.setTaxAllowances(1);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 79.80) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "79.80 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid weekly with 8 allowances
        testEmp.setPayFrequency(1);
        testEmp.setTaxAllowances(8);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 638.40) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "638.40 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid weekly with 10 allowances
        testEmp.setPayFrequency(1);
        testEmp.setTaxAllowances(10);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 798.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "798.00 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid weekly with 12 allowances
        testEmp.setPayFrequency(1);
        testEmp.setTaxAllowances(12);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 798.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "798.00 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid bi-weekly with 0 allowances
        testEmp.setPayFrequency(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 0.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: 0.00"
                    + "RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid bi-weekly with 1 allowances
        testEmp.setPayFrequency(2);
        testEmp.setTaxAllowances(1);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 159.60) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "159.60 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid bi-weekly with 8 allowances
        testEmp.setPayFrequency(2);
        testEmp.setTaxAllowances(8);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 1276.80) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1276.80 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid bi-weekly with 10 allowances
        testEmp.setPayFrequency(2);
        testEmp.setTaxAllowances(10);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 1596.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1596.00 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid bi-weekly with 12 allowances
        testEmp.setPayFrequency(2);
        testEmp.setTaxAllowances(12);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 1596.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1596.00 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid semi-monthly with 0 allowances
        testEmp.setPayFrequency(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 0.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: 0.00"
                    + "RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid semi-monthly with 1 allowances
        testEmp.setPayFrequency(3);
        testEmp.setTaxAllowances(1);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 172.90) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "172.90 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid semi-monthly with 8 allowances
        testEmp.setPayFrequency(3);
        testEmp.setTaxAllowances(8);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 1383.20) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1383.20 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid semi-monthly with 10 allowances
        testEmp.setPayFrequency(3);
        testEmp.setTaxAllowances(10);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 1729.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1729.00 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid semi-monthly with 12 allowances
        testEmp.setPayFrequency(3);
        testEmp.setTaxAllowances(12);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 1729.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1729.00 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid monthly with 0 allowances
        testEmp.setPayFrequency(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 0.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: 0.00"
                    + "RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid monthly with 1 allowances
        testEmp.setPayFrequency(4);
        testEmp.setTaxAllowances(1);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 345.80) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "345.80 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid monthly with 8 allowances
        testEmp.setPayFrequency(4);
        testEmp.setTaxAllowances(8);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 2766.40) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "2766.40 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid monthly with 10 allowances
        testEmp.setPayFrequency(4);
        testEmp.setTaxAllowances(10);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 3458.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "3458.00 RETURNED: " + testEmp.getAllowanceAmt());
        }
        //Paid monthly with 12 allowances
        testEmp.setPayFrequency(4);
        testEmp.setTaxAllowances(12);
        testEmp.setAllowanceAmt();
        testEmp.getAllowanceAmt();
        if (testEmp.getAllowanceAmt() != 3458.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "3458.00 RETURNED: " + testEmp.getAllowanceAmt());
        }
    }

    /**
     * Test of setTaxableAmt & getTaxableAmt methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */

    @Test
    public void testTaxableAmt() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET TAXABLE AMOUNT.");
        HourlyEmployee testEmp = new HourlyEmployee();
        
        testEmp.setHourlyWage(10.00);
        testEmp.setOTWage();//15.00
        testEmp.setTotalHours(56.24);
        testEmp.setOTHours(0.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();//562.40
        testEmp.setOTPay();
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();//562.40
        testEmp.setPreTaxAmt(125.00);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setTaxableAmt();
        if (testEmp.getTaxableAmt() != 437.40) {
            System.out.println("FAILED SET/GET TAXABLE AMOUNT. Expected: "
                    + "437.40 Returned: " + testEmp.getTaxableAmt());
        }

        testEmp.setHourlyWage(22.75);
        testEmp.setOTWage();//34.13
        testEmp.setTotalHours(86.24);
        testEmp.setOTHours(6.24);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();//1820.00
        testEmp.setOTPay();//212.97
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setPreTaxAmt(100.00);
        testEmp.setTaxAllowances(1);
        testEmp.setAllowanceAmt();//159.60
        testEmp.setTaxableAmt();
        if (testEmp.getTaxableAmt() != 1773.37) {
            System.out.println("FAILED SET/GET TAXABLE AMOUNT. Expected: "
                    + "1773.37 Returned: " + testEmp.getTaxableAmt());
        }
        testEmp.setHourlyWage(47.63);
        testEmp.setOTWage();//71.45
        testEmp.setTotalHours(95.23);
        testEmp.setOTHours(15.23);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();//3810.40
        testEmp.setOTPay();//1088.18
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();//4898.58
        testEmp.setPreTaxAmt(100.00);
        testEmp.setTaxAllowances(10);//1729.00
        testEmp.setAllowanceAmt();
        testEmp.setTaxableAmt();
        if (testEmp.getTaxableAmt() != 3069.58) {
            System.out.println("FAILED SET/GET TAXABLE AMOUNT. Expected: "
                    + "3069.58 Returned: " + testEmp.getTaxableAmt());
        }
        testEmp.setHourlyWage(19.35);
        testEmp.setOTWage();//29.03
        testEmp.setTotalHours(173.64);
        testEmp.setOTHours(13.64);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();//3096.00
        testEmp.setOTPay();//395.97
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setPreTaxAmt(100.00);
        testEmp.setTaxAllowances(15);
        testEmp.setAllowanceAmt();//3458.00
        testEmp.setTaxableAmt();
        if (testEmp.getTaxableAmt() != 0.00) {
            System.out.println("FAILED SET/GET TAXABLE AMOUNT. Expected: "
                    + "0.00 Returned: " + testEmp.getTaxableAmt());
        }
    }

    /**
     * Test of setFedTax & getFedTax methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */
/*
    @Test
    public void testFedTax() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET FED TAX AMOUNT.");
        HourlyEmployee testEmp = new HourlyEmployee();
        
        //Paid weekly single withholding 0 allowances 0 tax bracket
        testEmp.setHourlyWage(10.00);
        testEmp.setOTWage();//15.00
        testEmp.setTotalHours(5.00);
        testEmp.setOTHours(0.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();//50.00
        testEmp.setOTPay();//0.00
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly single withholding 0 allowances 10% tax bracket
        testEmp.setHourlyWage(10.00);
        testEmp.setOTWage();//15.00
        testEmp.setTotalHours(20.00);
        testEmp.setOTHours(0.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();//200.00
        testEmp.setOTPay();//0.00
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 20.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 20.00 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly single withholding 0 allowances 12% tax bracket
        testEmp.setHourlyWage(10.00);
        testEmp.setOTWage();//15.00
        testEmp.setTotalHours(40.00);
        testEmp.setOTHours(0.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();//400.00
        testEmp.setOTPay();//0.00
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 35.82) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 35.82 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly single withholding 0 allowances 22% tax bracket
        testEmp.setHourlyWage(25.00);
        testEmp.setOTWage();//37.50
        testEmp.setTotalHours(40.00);
        testEmp.setOTHours(0.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();//1000.00
        testEmp.setOTPay();//0.00
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 126.32) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 126.32 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly single withholding 0 allowances 24% tax bracket
        testEmp.setHourlyWage(25.00);
        testEmp.setOTWage();//37.50
        testEmp.setTotalHours(60.00);
        testEmp.setOTHours(20.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();//1000.00
        testEmp.setOTPay();//750.00
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();//1750.00
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();//1750.00
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 293.16) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 293.16 "
                    + "RETURNED: " + testEmp.getFedTax());
        }

        //Paid bi-weekly single withholding 0 allowances 32% tax bracket
        testEmp.setHourlyWage(175.00);
        testEmp.setOTWage();//262.50
        testEmp.setTotalHours(40.00);
        testEmp.setOTHours(0.00);
        testEmp.setStraightHours(testEmp.getTotalHours()-testEmp.getOTHours());
        testEmp.setStraightPay();//7000.00
        testEmp.setOTPay();//0.00
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();//7000.00
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();//7000.00
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 1490.22) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1490.22 "
                    + "RETURNED: " + testEmp.getFedTax());
        }

        //Paid bi-weekly single withholding 0 allowances 35% tax bracket
        testEmp.setGrossAnnualSalary(390000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 4265.17) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4265.17 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid bi-weekly single withholding 0 allowances 37% tax bracket
        testEmp.setGrossAnnualSalary(650000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 7877.71) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 7877.71 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 0% tax bracket
        testEmp.setGrossAnnualSalary(3600.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 10% tax bracket
        testEmp.setGrossAnnualSalary(12000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 34.60) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 34.60 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 12% tax bracket
        testEmp.setGrossAnnualSalary(36000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 153.58) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 153.58 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 22% tax bracket
        testEmp.setGrossAnnualSalary(72000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 456.88) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 456.88 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 24% tax bracket
        testEmp.setGrossAnnualSalary(120000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 925.04) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 925.04 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 32% tax bracket
        testEmp.setGrossAnnualSalary(192000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 1747.68) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1747.68 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 35% tax bracket
        testEmp.setGrossAnnualSalary(360000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 4183.04) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4183.04 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 37% tax bracket
        testEmp.setGrossAnnualSalary(600000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 7763.28) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 7763.28 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 0% tax bracket
        testEmp.setGrossAnnualSalary(3600.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 10% tax bracket
        testEmp.setGrossAnnualSalary(12000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 69.20) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 69.20 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 12% tax bracket
        testEmp.setGrossAnnualSalary(36000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 307.16) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 307.16 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 22% tax bracket
        testEmp.setGrossAnnualSalary(60000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 693.86) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 693.86 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 24% tax bracket
        testEmp.setGrossAnnualSalary(120000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 1850.20) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1850.20 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 32% tax bracket
        testEmp.setGrossAnnualSalary(180000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 3175.56) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 3175.56 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 35% tax bracket
        testEmp.setGrossAnnualSalary(420000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 10116.31) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 10116.31 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 37% tax bracket
        testEmp.setGrossAnnualSalary(600000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(4);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 15526.81) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 15526.81 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 0% tax bracket
        testEmp.setGrossAnnualSalary(10400.00);
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 10% tax bracket
        testEmp.setGrossAnnualSalary(26000.00);
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 27.80) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 27.80 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 12% tax bracket
        testEmp.setGrossAnnualSalary(78000.00);
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 146.04) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 146.04 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 22% tax bracket
        testEmp.setGrossAnnualSalary(104000.00);
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 234.94) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 234.94 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 24% tax bracket
        testEmp.setGrossAnnualSalary(260000.00);
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 927.04) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 927.04 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 32% tax bracket
        testEmp.setGrossAnnualSalary(364000.00);
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 1464.64) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1464.64 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 35% tax bracket
        testEmp.setGrossAnnualSalary(520000.00);
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 2487.22) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 2487.22 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 37% tax bracket
        testEmp.setGrossAnnualSalary(780000.00);
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 4302.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4302.00 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 0% tax bracket
        testEmp.setGrossAnnualSalary(10400.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 10% tax bracket
        testEmp.setGrossAnnualSalary(26000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 55.60) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 55.60 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 12% tax bracket
        testEmp.setGrossAnnualSalary(78000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 292.06) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 292.06 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 22% tax bracket
        testEmp.setGrossAnnualSalary(130000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 689.96) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 689.96 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 24% tax bracket
        testEmp.setGrossAnnualSalary(260000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 1854.16) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1854.16 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 32% tax bracket
        testEmp.setGrossAnnualSalary(390000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 3249.36) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 3249.36 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 35% tax bracket
        testEmp.setGrossAnnualSalary(520000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 4974.49) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4974.49 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 37% tax bracket
        testEmp.setGrossAnnualSalary(650000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(5000);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 11754.07) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 11754.07 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 0% tax bracket
        testEmp.setGrossAnnualSalary(10800.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 10% tax bracket
        testEmp.setGrossAnnualSalary(24000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 51.90) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 51.90 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 12% tax bracket
        testEmp.setGrossAnnualSalary(84000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(500.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 846.40) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 846.40 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 22% tax bracket
        testEmp.setGrossAnnualSalary(120000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 655.80) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 655.80 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 24% tax bracket
        testEmp.setGrossAnnualSalary(240000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 1808.68) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1808.68 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 32% tax bracket
        testEmp.setGrossAnnualSalary(360000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 3120.20) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 3120.20 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 35% tax bracket
        testEmp.setGrossAnnualSalary(480000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 4805.76) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4805.76 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 37% tax bracket
        testEmp.setGrossAnnualSalary(720000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 8396.14) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 8396.14 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 0% tax bracket
        testEmp.setGrossAnnualSalary(11400.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 10% tax bracket
        testEmp.setGrossAnnualSalary(27000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 128.70) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 128.70 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 12% tax bracket
        testEmp.setGrossAnnualSalary(60000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 452.70) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 452.70 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 22% tax bracket
        testEmp.setGrossAnnualSalary(156000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 1971.40) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1971.40 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 24% tax bracket
        testEmp.setGrossAnnualSalary(300000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 4817.14) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4817.14 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 32% tax bracket
        testEmp.setGrossAnnualSalary(384000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 6880.10) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 6880.10 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 35% tax bracket
        testEmp.setGrossAnnualSalary(540000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 11361.22) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 11361.22 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 37% tax bracket
        testEmp.setGrossAnnualSalary(720000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setFilingStatus(3);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setAddtlFedTax(0.00);
        testEmp.setFedTax();
        if (testEmp.getFedTax() != 16791.96) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 16791.96 "
                    + "RETURNED: " + testEmp.getFedTax());
        }
    }

    /**
     * Test of setSSTax & getSSTax methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */
/*
    @Test
    public void testSSTax() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET SS TAX AMOUNT.");
        HourlyEmployee testEmp = new HourlyEmployee();
        //Paid weekly at 100k /year eligible for ss tax withholding
        testEmp.setSSTaxElig(true);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setSSTax();
        if (testEmp.getSSTax() != 119.23) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 119.23"
                    + " RETURNED: " + testEmp.getSSTax());
        }
        //Paid bi-weekly at 100k /year eligible for ss tax withholding
        testEmp.setSSTaxElig(true);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setSSTax();
        if (testEmp.getSSTax() != 238.46) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 238.46"
                    + " RETURNED: " + testEmp.getSSTax());
        }
        //Paid semi-monthly at 100k /year not eligible for ss tax withholding
        testEmp.setSSTaxElig(false);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setSSTax();
        if (testEmp.getSSTax() != 0.00) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 0.00"
                    + " RETURNED: " + testEmp.getSSTax());
        }
        //Paid monthly at 100k /year not eligible for ss tax withholding
        testEmp.setSSTaxElig(false);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setSSTax();
        if (testEmp.getSSTax() != 0.00) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 0.00"
                    + " RETURNED: " + testEmp.getSSTax());
        }
    }

    /**
     * Test of setMedicareTax & getMedicareTax methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */
/*
    @Test
    public void testSetMedicareTax() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET MEDICARE TAX AMOUNT.");
        HourlyEmployee testEmp = new HourlyEmployee();
        
        //Paid weekly at 100k /year normal medicare tax withholding
        testEmp.setAddtlMedTaxElig(false);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(1);
        testEmp.setGrossPay();
        testEmp.setMedicareTax();
        if (testEmp.getMedicareTax() != 27.88) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 27.88"
                    + " RETURNED: " + testEmp.getMedicareTax());
        }
        //Paid bi-weekly at 100k /year normal medicare tax withholding
        testEmp.setAddtlMedTaxElig(false);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(2);
        testEmp.setGrossPay();
        testEmp.setMedicareTax();
        if (testEmp.getMedicareTax() != 55.77) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 55.77"
                    + " RETURNED: " + testEmp.getMedicareTax());
        }
        //Paid semi-monthly at 100k /year extra medicare tax withholding
        testEmp.setAddtlMedTaxElig(true);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(3);
        testEmp.setGrossPay();
        testEmp.setMedicareTax();
        if (testEmp.getMedicareTax() != 97.92) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 97.92"
                    + " RETURNED: " + testEmp.getMedicareTax());
        }
        //Paid monthly at 100k /year extra medicare tax withholding
        testEmp.setAddtlMedTaxElig(true);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(4);
        testEmp.setGrossPay();
        testEmp.setMedicareTax();
        if (testEmp.getMedicareTax() != 195.83) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 195.83"
                    + " RETURNED: " + testEmp.getMedicareTax());
        }
    }

    /**
     * Test of setNetPay method, of class SalaryEmployee.
     * @throws java.text.ParseException
     */
/*
    @Test
    public void testSetNetPay() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET NET PAY AMOUNT.");
        HourlyEmployee testEmp = new HourlyEmployee();
        //Paid weekly @ 100k/year normal ss and med tax married 2 allowances
        testEmp.setSSTaxElig(true);
        testEmp.setAddtlMedTaxElig(false);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(1);
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setGrossPay();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setPostTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setFedTax();
        testEmp.setMedicareTax();
        testEmp.setSSTax();
        testEmp.setNetPay();
        if (testEmp.getNetPay() != 1557.95) {
            System.out.println("FAILED SET/GET NET PAY AMOUNT. EXPECTED: "
                    + "1557.95 RETURNED: " + testEmp.getNetPay());
        }
        //Paid bi-weekly @ 100k/year normal ss and med tax married 2 allowances
        testEmp.setSSTaxElig(true);
        testEmp.setAddtlMedTaxElig(false);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(2);
        testEmp.setFilingStatus(2);
        testEmp.setTaxAllowances(2);
        testEmp.setAllowanceAmt();
        testEmp.setGrossPay();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setPostTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setFedTax();
        testEmp.setMedicareTax();
        testEmp.setSSTax();
        testEmp.setNetPay();
        if (testEmp.getNetPay() != 3186.03) {
            System.out.println("FAILED SET/GET NET PAY AMOUNT. EXPECTED: "
                    + "3186.04 RETURNED: " + testEmp.getNetPay());           
        }
        //Paid semi-monthly @ 100k/year no ss and normal med tax single 
        //0 allowances
        testEmp.setSSTaxElig(false);
        testEmp.setAddtlMedTaxElig(false);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(3);
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(0);
        testEmp.setAllowanceAmt();
        testEmp.setGrossPay();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setPostTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setFedTax();
        testEmp.setMedicareTax();
        testEmp.setSSTax();
        testEmp.setNetPay();
        if (testEmp.getNetPay() != 3381.21) {
            System.out.println("FAILED SET/GET NET PAY AMOUNT. EXPECTED: "
                    + "3381.21 RETURNED: " + testEmp.getNetPay());
        }
        //Paid monthly @ 100k/year no ss and higher med tax single 1 allowance
        testEmp.setSSTaxElig(false);
        testEmp.setAddtlMedTaxElig(true);
        testEmp.setGrossAnnualSalary(100000.00);
        testEmp.setPayFrequency(4);
        testEmp.setFilingStatus(1);
        testEmp.setTaxAllowances(1);
        testEmp.setAllowanceAmt();
        testEmp.setGrossPay();
        testEmp.setPreTaxAmt(0.00);
        testEmp.setPostTaxAmt(0.00);
        testEmp.setTaxableAmt();
        testEmp.setFedTax();
        testEmp.setMedicareTax();
        testEmp.setSSTax();
        testEmp.setNetPay();
        if (testEmp.getNetPay() != 6770.29) {
            System.out.println("FAILED SET/GET NET PAY AMOUNT. EXPECTED: "
                    + "6770.29 RETURNED: " + testEmp.getNetPay());
        }
    }
*/
}
