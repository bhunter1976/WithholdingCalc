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
 * Completed: ?
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
public class SalaryEmployeeTest {
    
    public SalaryEmployeeTest() {
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
     * Test of setGrossAnnualSalary & getGrossAnnualSalary methods, of class
     * SalaryEmployee.
     * @throws java.lang.Exception
     */
    
    @Test
    public void testGrossAnnualSalary() throws Exception {
        System.out.println("BEGIN TESTING SET/GET GROSS ANNUAL SALARY.");
        SalaryEmployee testSalaryEmp = new SalaryEmployee();
        
        testSalaryEmp.setGrossAnnualSalary(10000.00);
        if (testSalaryEmp.getGrossAnnualSalary() != 10000.00) {
            System.out.println("FAILED SET/GET GROSS ANNUAL SALARY. EXPECTED: "
                    + "10000.00. RETURNED: " 
                    + testSalaryEmp.getGrossAnnualSalary());
        }
        
        testSalaryEmp.setGrossAnnualSalary(50000.00);
        if (testSalaryEmp.getGrossAnnualSalary() != 50000.00){
            System.out.println("FAILED SET/GET GROSS ANNUAL SALARY. EXPECTED: "
                    + "50000.00. RETURNED: " 
                    + testSalaryEmp.getGrossAnnualSalary());
        }
        
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        if (testSalaryEmp.getGrossAnnualSalary() != 100000.00) {
            System.out.println("FAILED SET/GET GROSS ANNUAL SALARY. EXPECTED: "
                    + "100000.00. RETURNED: " 
                    + testSalaryEmp.getGrossAnnualSalary());
        }
    }

    /**
     * Test of setGrossPay & getGrossPay methods, of class SalaryEmployee.
     * @throws java.lang.Exception
     */

    @Test
    public void testGrossPay() throws Exception {
        System.out.println("BEGIN TESTING SET/GET GROSS PAY.");
        SalaryEmployee testSalaryEmp = new SalaryEmployee();
        
        //Paid weekly @50k/year
        testSalaryEmp.setGrossAnnualSalary(50000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        if (testSalaryEmp.getGrossPay() != 961.54) {
            System.out.println("FAILED SET/GET GROSS PAY. EXPECTED 961.54. "
                    + "RETURNED: " + testSalaryEmp.getGrossPay());
        }
        //Paid bi-weekly @50k/year
        testSalaryEmp.setGrossAnnualSalary(50000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        if (testSalaryEmp.getGrossPay() != 1923.08) {
            System.out.println("FAILED SET/GET GROSS PAY. EXPECTED 1923.08. "
                    + "RETURNED: " + testSalaryEmp.getGrossPay());
        }
        //Paid semi-monthly @50k/year
        testSalaryEmp.setGrossAnnualSalary(50000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        if (testSalaryEmp.getGrossPay() != 2083.33) {
            System.out.println("FAILED SET/GET GROSS PAY. EXPECTED 2083.33. "
                    + "RETURNED: " + testSalaryEmp.getGrossPay());
        }
        //Paid monthly @50k/year
        testSalaryEmp.setGrossAnnualSalary(50000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        if (testSalaryEmp.getGrossPay() != 4166.67) {
            System.out.println("FAILED SET/GET GROSS PAY. EXPECTED 4166.67. "
                    + "RETURNED: " + testSalaryEmp.getGrossPay());
        }
    }

    /**
     * Test of setPreTaxAmt & getPreTaxAmt methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */

    @Test
    public void testPreTaxAmt() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET PRE-TAX.");
        SalaryEmployee testSalaryEmp = new SalaryEmployee();
        
        testSalaryEmp.setPreTaxAmt(125.00);
        if (testSalaryEmp.getPreTaxAmt() != 125.00) {
            System.out.println("FAILED SET/GET PRE-TAX AMT. EXPECTED: 125.00. "
                    + "RETURNED: " + testSalaryEmp.getPreTaxAmt());
        }
        testSalaryEmp.setPreTaxAmt(125);
        if (testSalaryEmp.getPreTaxAmt() != 125.00) {
            System.out.println("FAILED SET/GET PRE-TAX AMT. EXPECTED: 125.00. "
                    + "RETURNED: " + testSalaryEmp.getPreTaxAmt());
        }
        testSalaryEmp.setPreTaxAmt(500.00);
        if (testSalaryEmp.getPreTaxAmt() != 500.00) {
            System.out.println("FAILED SET/GET PRE-TAX AMT. EXPECTED: 500.00. "
                    + "RETURNED: " + testSalaryEmp.getPreTaxAmt());
        }
        testSalaryEmp.setPreTaxAmt(500);
        if (testSalaryEmp.getPreTaxAmt() != 500.00) {
            System.out.println("FAILED SET/GET PRE-TAX AMT. EXPECTED: 500.00. "
                    + "RETURNED: " + testSalaryEmp.getPreTaxAmt());
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
        SalaryEmployee testSalaryEmp = new SalaryEmployee();
        
        testSalaryEmp.setPostTaxAmt(125.00);
        if (testSalaryEmp.getPostTaxAmt() != 125.00) {
            System.out.println("FAILED SET/GET POST-TAX AMT. EXPECTED: 125.00. "
                    + "RETURNED: " + testSalaryEmp.getPostTaxAmt());
        }
        testSalaryEmp.setPostTaxAmt(125);
        if (testSalaryEmp.getPostTaxAmt() != 125.00) {
            System.out.println("FAILED SET/GET POST-TAX AMT. EXPECTED: 125.00. "
                    + "RETURNED: " + testSalaryEmp.getPostTaxAmt());
        }
        testSalaryEmp.setPostTaxAmt(500.00);
        if (testSalaryEmp.getPostTaxAmt() != 500.00) {
            System.out.println("FAILED SET/GET POST-TAX AMT. EXPECTED: 500.00. "
                    + "RETURNED: " + testSalaryEmp.getPostTaxAmt());
        }
        testSalaryEmp.setPostTaxAmt(500);
        if (testSalaryEmp.getPostTaxAmt() != 500.00) {
            System.out.println("FAILED SET/GET POST-TAX AMT. EXPECTED: 500.00. "
                    + "RETURNED: " + testSalaryEmp.getPostTaxAmt());
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
        SalaryEmployee testSalaryEmp = new SalaryEmployee();
        //Paid weekly with 0 allowances
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 0.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: 0.00"
                    + "RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid weekly with 1 allowances
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setTaxAllowances(1);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 79.80) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "79.80 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid weekly with 8 allowances
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setTaxAllowances(8);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 638.40) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "638.40 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid weekly with 10 allowances
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setTaxAllowances(10);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 798.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "798.00 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid weekly with 12 allowances
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setTaxAllowances(12);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 798.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "798.00 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid bi-weekly with 0 allowances
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 0.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: 0.00"
                    + "RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid bi-weekly with 1 allowances
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setTaxAllowances(1);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 159.60) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "159.60 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid bi-weekly with 8 allowances
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setTaxAllowances(8);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 1276.80) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1276.80 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid bi-weekly with 10 allowances
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setTaxAllowances(10);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 1596.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1596.00 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid bi-weekly with 12 allowances
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setTaxAllowances(12);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 1596.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1596.00 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid semi-monthly with 0 allowances
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 0.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: 0.00"
                    + "RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid semi-monthly with 1 allowances
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setTaxAllowances(1);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 172.90) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "172.90 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid semi-monthly with 8 allowances
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setTaxAllowances(8);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 1383.20) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1383.20 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid semi-monthly with 10 allowances
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setTaxAllowances(10);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 1729.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1729.00 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid semi-monthly with 12 allowances
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setTaxAllowances(12);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 1729.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "1729.00 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid monthly with 0 allowances
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 0.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: 0.00"
                    + "RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid monthly with 1 allowances
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setTaxAllowances(1);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 345.80) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "345.80 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid monthly with 8 allowances
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setTaxAllowances(8);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 2766.40) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "2766.40 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid monthly with 10 allowances
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setTaxAllowances(10);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 3458.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "3458.00 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
        //Paid monthly with 12 allowances
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setTaxAllowances(12);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.getAllowanceAmt();
        if (testSalaryEmp.getAllowanceAmt() != 3458.00) {
            System.out.println("FAILED SET/GET ALLOWANCE AMOUNT. EXPECTED: "
                    + "3458.00 RETURNED: " + testSalaryEmp.getAllowanceAmt());
        }
    }

    /**
     * Test of setTaxableAmt & getTaxableAmt methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */

    @Test
    public void testTaxableAmt() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET TAXABLE AMOUNT.");
        SalaryEmployee testSalaryEmp = new SalaryEmployee();
        
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setPreTaxAmt(125.00);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setTaxableAmt();
        if (testSalaryEmp.getTaxableAmt() != 1798.08) {
            System.out.println("FAILED SET/GET TAXABLE AMOUNT. Expected: "
                    + "1798.08 Returned: " + testSalaryEmp.getTaxableAmt());
        }
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setPreTaxAmt(100.00);
        testSalaryEmp.setTaxAllowances(1);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setTaxableAmt();
        if (testSalaryEmp.getTaxableAmt() != 3586.55) {
            System.out.println("FAILED SET/GET TAXABLE AMOUNT. Expected: "
                    + "3586.55 Returned: " + testSalaryEmp.getTaxableAmt());
        }
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setPreTaxAmt(100.00);
        testSalaryEmp.setTaxAllowances(10);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setTaxableAmt();
        if (testSalaryEmp.getTaxableAmt() != 2337.67) {
            System.out.println("FAILED SET/GET TAXABLE AMOUNT. Expected: "
                    + "2337.67 Returned: " + testSalaryEmp.getTaxableAmt());
        }
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setPreTaxAmt(100.00);
        testSalaryEmp.setTaxAllowances(15);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setTaxableAmt();
        if (testSalaryEmp.getTaxableAmt() != 4775.33) {
            System.out.println("FAILED SET/GET TAXABLE AMOUNT. Expected: "
                    + "4775.33 Returned: " + testSalaryEmp.getTaxableAmt());
        }
    }

    /**
     * Test of setFedTax & getFedTax methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */

    @Test
    public void testFedTax() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET FED TAX AMOUNT.");
        SalaryEmployee testSalaryEmp = new SalaryEmployee();
        
        //Paid weekly single withholding 0 allowances 0 tax bracket
        testSalaryEmp.setGrossAnnualSalary(3500.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(10.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 10.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 10.00 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }

        //Paid weekly single withholding 0 allowances 10% tax bracket
        testSalaryEmp.setGrossAnnualSalary(10400.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 20.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 20.00 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly single withholding 0 allowances 12% tax bracket
        testSalaryEmp.setGrossAnnualSalary(36400.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 71.82) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 71.82 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly single withholding 0 allowances 22% tax bracket
        testSalaryEmp.setGrossAnnualSalary(78000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 236.32) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 236.32 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly single withholding 0 allowances 24% tax bracket
        testSalaryEmp.setGrossAnnualSalary(130000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 473.16) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 473.16 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly single withholding 0 allowances 32% tax bracket
        testSalaryEmp.setGrossAnnualSalary(182000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 745.16) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 745.16 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly single withholding 0 allowances 35% tax bracket
        testSalaryEmp.setGrossAnnualSalary(416000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 2307.65) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 2307.65 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly single withholding 0 allowances 37% tax bracket
        testSalaryEmp.setGrossAnnualSalary(520000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 3013.91) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 3013.91 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly single withholding 1 allowances 37% tax bracket
        testSalaryEmp.setGrossAnnualSalary(520000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(1);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 2984.38) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 2984.38 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly single withholding 12 allowances 35% tax bracket
        testSalaryEmp.setGrossAnnualSalary(520000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(12);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 2728.35) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 2728.35 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly single withholding 0 allowances 0 tax bracket
        testSalaryEmp.setGrossAnnualSalary(3250.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly single withholding 0 allowances 10% tax bracket
        testSalaryEmp.setGrossAnnualSalary(10400.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 25.80) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 25.80 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly single withholding 0 allowances 12% tax bracket
        testSalaryEmp.setGrossAnnualSalary(31200.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 119.62) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 119.62 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly single withholding 0 allowances 22% tax bracket
        testSalaryEmp.setGrossAnnualSalary(78000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 472.52) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 472.52 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly single withholding 0 allowances 24% tax bracket
        testSalaryEmp.setGrossAnnualSalary(130000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 946.22) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 946.22 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly single withholding 0 allowances 32% tax bracket
        testSalaryEmp.setGrossAnnualSalary(182000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 1490.22) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1490.22 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly single withholding 0 allowances 35% tax bracket
        testSalaryEmp.setGrossAnnualSalary(390000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 4265.17) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4265.17 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly single withholding 0 allowances 37% tax bracket
        testSalaryEmp.setGrossAnnualSalary(650000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 7877.71) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 7877.71 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 0% tax bracket
        testSalaryEmp.setGrossAnnualSalary(3600.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 10% tax bracket
        testSalaryEmp.setGrossAnnualSalary(12000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 34.60) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 34.60 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 12% tax bracket
        testSalaryEmp.setGrossAnnualSalary(36000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 153.58) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 153.58 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 22% tax bracket
        testSalaryEmp.setGrossAnnualSalary(72000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 456.88) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 456.88 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 24% tax bracket
        testSalaryEmp.setGrossAnnualSalary(120000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 925.04) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 925.04 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 32% tax bracket
        testSalaryEmp.setGrossAnnualSalary(192000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 1747.68) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1747.68 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 35% tax bracket
        testSalaryEmp.setGrossAnnualSalary(360000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 4183.04) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4183.04 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly single withholding 0 allowances 37% tax bracket
        testSalaryEmp.setGrossAnnualSalary(600000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 7763.28) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 7763.28 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 0% tax bracket
        testSalaryEmp.setGrossAnnualSalary(3600.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 10% tax bracket
        testSalaryEmp.setGrossAnnualSalary(12000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 69.20) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 69.20 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 12% tax bracket
        testSalaryEmp.setGrossAnnualSalary(36000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 307.16) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 307.16 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 22% tax bracket
        testSalaryEmp.setGrossAnnualSalary(60000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 693.86) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 693.86 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 24% tax bracket
        testSalaryEmp.setGrossAnnualSalary(120000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 1850.20) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1850.20 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 32% tax bracket
        testSalaryEmp.setGrossAnnualSalary(180000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 3175.56) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 3175.56 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 35% tax bracket
        testSalaryEmp.setGrossAnnualSalary(420000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 10116.31) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 10116.31 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly single withholding 0 allowances 37% tax bracket
        testSalaryEmp.setGrossAnnualSalary(600000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(4);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 15526.81) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 15526.81 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 0% tax bracket
        testSalaryEmp.setGrossAnnualSalary(10400.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 10% tax bracket
        testSalaryEmp.setGrossAnnualSalary(26000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 27.80) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 27.80 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 12% tax bracket
        testSalaryEmp.setGrossAnnualSalary(78000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 146.04) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 146.04 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 22% tax bracket
        testSalaryEmp.setGrossAnnualSalary(104000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 234.94) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 234.94 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 24% tax bracket
        testSalaryEmp.setGrossAnnualSalary(260000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 927.04) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 927.04 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 32% tax bracket
        testSalaryEmp.setGrossAnnualSalary(364000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 1464.64) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1464.64 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 35% tax bracket
        testSalaryEmp.setGrossAnnualSalary(520000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 2487.22) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 2487.22 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid weekly married withholding 0 allowances 37% tax bracket
        testSalaryEmp.setGrossAnnualSalary(780000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 4302.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4302.00 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 0% tax bracket
        testSalaryEmp.setGrossAnnualSalary(10400.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 10% tax bracket
        testSalaryEmp.setGrossAnnualSalary(26000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 55.60) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 55.60 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 12% tax bracket
        testSalaryEmp.setGrossAnnualSalary(78000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 292.06) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 292.06 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 22% tax bracket
        testSalaryEmp.setGrossAnnualSalary(130000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 689.96) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 689.96 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 24% tax bracket
        testSalaryEmp.setGrossAnnualSalary(260000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 1854.16) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1854.16 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 32% tax bracket
        testSalaryEmp.setGrossAnnualSalary(390000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 3249.36) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 3249.36 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 35% tax bracket
        testSalaryEmp.setGrossAnnualSalary(520000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 4974.49) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4974.49 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid bi-weekly married withholding 0 allowances 37% tax bracket
        testSalaryEmp.setGrossAnnualSalary(650000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(5000);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 11754.07) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 11754.07 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 0% tax bracket
        testSalaryEmp.setGrossAnnualSalary(10800.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 10% tax bracket
        testSalaryEmp.setGrossAnnualSalary(24000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 51.90) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 51.90 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 12% tax bracket
        testSalaryEmp.setGrossAnnualSalary(84000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(500.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 846.40) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 846.40 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 22% tax bracket
        testSalaryEmp.setGrossAnnualSalary(120000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 655.80) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 655.80 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 24% tax bracket
        testSalaryEmp.setGrossAnnualSalary(240000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 1808.68) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1808.68 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 32% tax bracket
        testSalaryEmp.setGrossAnnualSalary(360000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 3120.20) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 3120.20 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 35% tax bracket
        testSalaryEmp.setGrossAnnualSalary(480000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 4805.76) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4805.76 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid semi-monthly married withholding 0 allowances 37% tax bracket
        testSalaryEmp.setGrossAnnualSalary(720000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 8396.14) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 8396.14 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 0% tax bracket
        testSalaryEmp.setGrossAnnualSalary(11400.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 0.00) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 0.00 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 10% tax bracket
        testSalaryEmp.setGrossAnnualSalary(27000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 128.70) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 128.70 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 12% tax bracket
        testSalaryEmp.setGrossAnnualSalary(60000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 452.70) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 452.70 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 22% tax bracket
        testSalaryEmp.setGrossAnnualSalary(156000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 1971.40) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 1971.40 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 24% tax bracket
        testSalaryEmp.setGrossAnnualSalary(300000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 4817.14) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 4817.14 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 32% tax bracket
        testSalaryEmp.setGrossAnnualSalary(384000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 6880.10) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 6880.10 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 35% tax bracket
        testSalaryEmp.setGrossAnnualSalary(540000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 11361.22) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 11361.22 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
        //Paid monthly married withholding 0 allowances 37% tax bracket
        testSalaryEmp.setGrossAnnualSalary(720000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setFilingStatus(3);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setAddtlFedTax(0.00);
        testSalaryEmp.setFedTax();
        if (testSalaryEmp.getFedTax() != 16791.96) {
            System.out.println("FAILED SET/GET FED TAX. EXPECTED: 16791.96 "
                    + "RETURNED: " + testSalaryEmp.getFedTax());
        }
    }

    /**
     * Test of setSSTax & getSSTax methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */

    @Test
    public void testSSTax() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET SS TAX AMOUNT.");
        SalaryEmployee testSalaryEmp = new SalaryEmployee();
        //Paid weekly at 100k /year eligible for ss tax withholding
        testSalaryEmp.setSSTaxElig(true);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setSSTax();
        if (testSalaryEmp.getSSTax() != 119.23) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 119.23"
                    + " RETURNED: " + testSalaryEmp.getSSTax());
        }
        //Paid bi-weekly at 100k /year eligible for ss tax withholding
        testSalaryEmp.setSSTaxElig(true);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setSSTax();
        if (testSalaryEmp.getSSTax() != 238.46) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 238.46"
                    + " RETURNED: " + testSalaryEmp.getSSTax());
        }
        //Paid semi-monthly at 100k /year not eligible for ss tax withholding
        testSalaryEmp.setSSTaxElig(false);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setSSTax();
        if (testSalaryEmp.getSSTax() != 0.00) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 0.00"
                    + " RETURNED: " + testSalaryEmp.getSSTax());
        }
        //Paid monthly at 100k /year not eligible for ss tax withholding
        testSalaryEmp.setSSTaxElig(false);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setSSTax();
        if (testSalaryEmp.getSSTax() != 0.00) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 0.00"
                    + " RETURNED: " + testSalaryEmp.getSSTax());
        }
    }

    /**
     * Test of setMedicareTax & getMedicareTax methods, of class SalaryEmployee.
     * @throws java.text.ParseException
     */

    @Test
    public void testSetMedicareTax() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET MEDICARE TAX AMOUNT.");
        SalaryEmployee testSalaryEmp = new SalaryEmployee();
        
        //Paid weekly at 100k /year normal medicare tax withholding
        testSalaryEmp.setAddtlMedTaxElig(false);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setMedicareTax();
        if (testSalaryEmp.getMedicareTax() != 27.88) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 27.88"
                    + " RETURNED: " + testSalaryEmp.getMedicareTax());
        }
        //Paid bi-weekly at 100k /year normal medicare tax withholding
        testSalaryEmp.setAddtlMedTaxElig(false);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setMedicareTax();
        if (testSalaryEmp.getMedicareTax() != 55.77) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 55.77"
                    + " RETURNED: " + testSalaryEmp.getMedicareTax());
        }
        //Paid semi-monthly at 100k /year extra medicare tax withholding
        testSalaryEmp.setAddtlMedTaxElig(true);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setMedicareTax();
        if (testSalaryEmp.getMedicareTax() != 97.92) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 97.92"
                    + " RETURNED: " + testSalaryEmp.getMedicareTax());
        }
        //Paid monthly at 100k /year extra medicare tax withholding
        testSalaryEmp.setAddtlMedTaxElig(true);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setMedicareTax();
        if (testSalaryEmp.getMedicareTax() != 195.83) {
            System.out.println("FAILED SET/GET SS TAX AMOUNT. EXPECTED: 195.83"
                    + " RETURNED: " + testSalaryEmp.getMedicareTax());
        }
    }

    /**
     * Test of setNetPay method, of class SalaryEmployee.
     * @throws java.text.ParseException
     */

    @Test
    public void testSetNetPay() throws ParseException {
        System.out.println("BEGIN TESTING SET/GET NET PAY AMOUNT.");
        SalaryEmployee testSalaryEmp = new SalaryEmployee();
        //Paid weekly @ 100k/year normal ss and med tax married 2 allowances
        testSalaryEmp.setSSTaxElig(true);
        testSalaryEmp.setAddtlMedTaxElig(false);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(1);
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setPostTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setFedTax();
        testSalaryEmp.setMedicareTax();
        testSalaryEmp.setSSTax();
        testSalaryEmp.setNetPay();
        if (testSalaryEmp.getNetPay() != 1557.95) {
            System.out.println("FAILED SET/GET NET PAY AMOUNT. EXPECTED: "
                    + "1557.95 RETURNED: " + testSalaryEmp.getNetPay());
        }
        //Paid bi-weekly @ 100k/year normal ss and med tax married 2 allowances
        testSalaryEmp.setSSTaxElig(true);
        testSalaryEmp.setAddtlMedTaxElig(false);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(2);
        testSalaryEmp.setFilingStatus(2);
        testSalaryEmp.setTaxAllowances(2);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setPostTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setFedTax();
        testSalaryEmp.setMedicareTax();
        testSalaryEmp.setSSTax();
        testSalaryEmp.setNetPay();
        if (testSalaryEmp.getNetPay() != 3186.03) {
            System.out.println("FAILED SET/GET NET PAY AMOUNT. EXPECTED: "
                    + "3186.04 RETURNED: " + testSalaryEmp.getNetPay());           
        }
        //Paid semi-monthly @ 100k/year no ss and normal med tax single 
        //0 allowances
        testSalaryEmp.setSSTaxElig(false);
        testSalaryEmp.setAddtlMedTaxElig(false);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(3);
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(0);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setPostTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setFedTax();
        testSalaryEmp.setMedicareTax();
        testSalaryEmp.setSSTax();
        testSalaryEmp.setNetPay();
        if (testSalaryEmp.getNetPay() != 3381.21) {
            System.out.println("FAILED SET/GET NET PAY AMOUNT. EXPECTED: "
                    + "3381.21 RETURNED: " + testSalaryEmp.getNetPay());
        }
        //Paid monthly @ 100k/year no ss and higher med tax single 1 allowance
        testSalaryEmp.setSSTaxElig(false);
        testSalaryEmp.setAddtlMedTaxElig(true);
        testSalaryEmp.setGrossAnnualSalary(100000.00);
        testSalaryEmp.setPayFrequency(4);
        testSalaryEmp.setFilingStatus(1);
        testSalaryEmp.setTaxAllowances(1);
        testSalaryEmp.setAllowanceAmt();
        testSalaryEmp.setGrossPay();
        testSalaryEmp.setPreTaxAmt(0.00);
        testSalaryEmp.setPostTaxAmt(0.00);
        testSalaryEmp.setTaxableAmt();
        testSalaryEmp.setFedTax();
        testSalaryEmp.setMedicareTax();
        testSalaryEmp.setSSTax();
        testSalaryEmp.setNetPay();
        if (testSalaryEmp.getNetPay() != 6770.29) {
            System.out.println("FAILED SET/GET NET PAY AMOUNT. EXPECTED: "
                    + "6770.29 RETURNED: " + testSalaryEmp.getNetPay());
        }
    }
}
