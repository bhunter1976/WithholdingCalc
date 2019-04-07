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
 * Hourly Employee Sub-Class
 * 
 * Author: Brock M. Hunter
 * Started: 08/16/2018
 * Completed: 08/20/2018
 * Revised: ?
 * Testing: Passed 08/20/2018
 */

package taxwithholdingcalculator;

import java.math.BigDecimal;
import java.text.ParseException;

/**
 *
 * @author brock
 */

public class HourlyEmployee extends Employee {
    
    private double hourlyWage;
    private double otWage;
    private double totalHours;
    private double straightHours;
    private double otHours;
    private double straightPay;
    private double otPay;
    
    private double grossPay;
    private double preTaxAmt;
    private double postTaxAmt;
    private double allowanceAmt;
    private double taxableAmt;
    private double fedTax;
    private double ssTax;
    private double medicareTax;
    private double stateTax;
    private double localTax;
    private double netPay;
    private String format = "";
    
    //CONSTRUCTOR
    public HourlyEmployee() {
        double hourlyWage = 0.0;
        double otWage = 0.0;
        double totalHours = 0.0;
        double straightHours = 0.0;
        double otHours = 0.0;
        double straightPay = 0.0;
        double otPay = 0.0;
        double grossPay = 0.0;
        double preTaxAmt = 0.0;
        double postTaxAmt = 0.0;
        double allowanceAmt = 0.0;
        double taxableAmt = 0.0;
        double fedTax = 0.0;
        double ssTax = 0.0;
        double medicareTax = 0.0;
        double stateTax = 0.0;    //add state tax in future version
        double localTax = 0.0;    //add local tax in future version
        double netPay = 0.0;
        String format = " ";
    }
    //PUBLIC METHODS
    /**
     *
     * @param hourlyWage
     */

    //SET hourly wage amount
    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
        BigDecimal bd = BigDecimal.valueOf(this.hourlyWage);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.hourlyWage = bd.doubleValue();
    }
    //RETURN hourly wage amount
    public double getHourlyWage() {
        return this.hourlyWage;
    }  
    //SET OT wage amount
    public void setOTWage() {
        this.otWage = this.hourlyWage * 1.5;
        BigDecimal bd = BigDecimal.valueOf(this.otWage);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.otWage = bd.doubleValue();
    }
    //RETURN OT wage amount
    public double getOTWage() {
        return this.otWage;
    }
    //SET total hours worked

    /**
     *
     * @param totalHours
     */
    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
        BigDecimal bd = BigDecimal.valueOf(this.totalHours);
        bd = bd.setScale(2, BigDecimal.ROUND_UNNECESSARY);
        this.totalHours = bd.doubleValue();
    }
    //RETURN total hours worked
    public double getTotalHours() {
        return this.totalHours;
    }
    
    //SET straight hours worked
    public void setStraightHours(double straightHours) {
        this.straightHours = straightHours;
        BigDecimal bd = BigDecimal.valueOf(this.straightHours);
        bd = bd.setScale(2, BigDecimal.ROUND_UNNECESSARY);
        this.straightHours = bd.doubleValue();
    }
    //RETURN straight hours worked
    public double getStraightHours() {
        return this.straightHours;
    }
    //SET OT hours worked
    /**
     *
     * @param otHours
     */
    public void setOTHours(double otHours) {
        this.otHours = otHours;
        BigDecimal bd = BigDecimal.valueOf(this.otHours);
        bd = bd.setScale(2, BigDecimal.ROUND_UNNECESSARY);
        this.otHours = bd.doubleValue();
    }
    //RETURN OT hours
    public double getOTHours() {
        return this.otHours;
    }
    //SET straight pay
    public void setStraightPay() {
        this.straightPay = this.straightHours * this.hourlyWage;
        BigDecimal bd = BigDecimal.valueOf(this.straightPay);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.straightPay = bd.doubleValue();
    }
    //RETURN straight pay
    public double getStraightPay() {
        return this.straightPay;
    }
    //SET OT pay
    public void setOTPay() {
        this.otPay = this.otHours * this.otWage;
        BigDecimal bd = BigDecimal.valueOf(this.otPay);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.otPay = bd.doubleValue();
    }
    //RETURN OT pay
    public double getOTPay() {
        return this.otPay;
    }
    //SET gross paycheck amount
    public void setGrossPay() throws ParseException {
        this.grossPay = this.straightPay + this.otPay;
        BigDecimal bd = BigDecimal.valueOf(this.grossPay);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.grossPay = bd.doubleValue();
    }
    
    //RETURN gross paycheck amount
    public double getGrossPay() {
        return this.grossPay;
    }
    
    //SET pre-tax amount
    public void setPreTaxAmt(double preTaxAmt) throws ParseException {
        BigDecimal bd = BigDecimal.valueOf(preTaxAmt);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.preTaxAmt = bd.doubleValue();
    }
    
    //RETURN pre-tax amount
    public double getPreTaxAmt() {
        return this.preTaxAmt;
    }
    
    //SET post-tax amount
    public void setPostTaxAmt(double postTaxAmt) throws ParseException {
        BigDecimal bd = BigDecimal.valueOf(postTaxAmt);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.postTaxAmt = bd.doubleValue();
    }
    
    //RETURN post-tax amount
    public double getPostTaxAmt() {
        return this.postTaxAmt;
    }
    
    //SET withholding allowance amount
    public void setAllowanceAmt() throws ParseException {
        //SWITCH calcluate allowance amount by pay frequency & allowances
        switch (this.getPayFrequency()) {
            case 52:
                this.allowanceAmt = (this.getTaxAllowances() * 79.80);
                break;
            case 26:
                this.allowanceAmt = (this.getTaxAllowances() * 159.60);
                break;
            case 24:
                this.allowanceAmt = (this.getTaxAllowances() * 172.90);
                break;
            case 12:
                this.allowanceAmt = (this.getTaxAllowances() * 345.80);
                break;
            default:
                break;
        }
        BigDecimal bd = BigDecimal.valueOf(this.allowanceAmt);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.allowanceAmt = bd.doubleValue();
    }
    
    //RETURN taxable amount
    public double getAllowanceAmt() {
        return this.allowanceAmt;
    }
    //SET taxable amount
    public void setTaxableAmt() throws ParseException {
        this.taxableAmt = (this.grossPay - this.allowanceAmt - this.preTaxAmt);
        if (this.taxableAmt <= 0) {
            this.taxableAmt = 0.00;
        }
        BigDecimal bd = BigDecimal.valueOf(this.taxableAmt);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.taxableAmt = bd.doubleValue();        
    }
    
    //RETURN taxable amount
    public double getTaxableAmt() {
        return this.taxableAmt;
    }

    
    //SET federal tax amount
    public void setFedTax() throws ParseException {

        //IF single withholding rate and paid weekly
        if ((this.getFilingStatus() == 1 | this.getFilingStatus() == 4) 
                & (this.getPayFrequency() == 52)) {

            if (this.getTaxableAmt() <= 71.00) {
                this.fedTax = 0.00;
            }
            else if ((this.getTaxableAmt() >= 71.01) & 
                    (this.getTaxableAmt() <= 254.00)) {
                this.fedTax = this.getTaxableAmt() * 0.10;
            }
            else if ((this.getTaxableAmt() >= 254.01) & 
                    (this.getTaxableAmt() <= 815.00)) {
                this.fedTax = 18.30 + ((this.getTaxableAmt() - 254.00) * 0.12);
            }
            else if ((this.getTaxableAmt() >= 815.01) & 
                    (this.getTaxableAmt() <= 1658.00)) {
                this.fedTax = 85.62 + ((this.getTaxableAmt() - 815.00) * 0.22);
            }
            else if ((this.getTaxableAmt() >= 1658.01) & 
                    (this.getTaxableAmt() <= 3100.00)) {
                this.fedTax = 271.08 + ((this.getTaxableAmt()-1658.00) * 0.24);
            }
            else if ((this.getTaxableAmt() >= 3100.01) & 
                    (this.getTaxableAmt() <= 3917.00)) {
                this.fedTax = 617.16 + ((this.getTaxableAmt()-3100.00) * 0.32);
            }
            else if ((this.getTaxableAmt() >= 3917.01) & 
                    (this.getTaxableAmt() <= 9687.00)) {
                this.fedTax = 878.60 + ((this.getTaxableAmt()-3917.00) * 0.35);
            }
            else if (this.getTaxableAmt() >= 9687.01) {
                this.fedTax = 2898.10 + ((this.getTaxableAmt()-9687.00) * 0.37);
            }
            else {
                this.fedTax = 0.00;
            }
        }//END IF
        //ELSEIF single withholding rate and paid bi-weekly
        else if ((this.getFilingStatus() == 1 | this.getFilingStatus() == 4)
                & (this.getPayFrequency() == 26)) {
            
            if (this.getTaxableAmt() <= 142.00) {
                this.fedTax = 0.00;
            }
            else if ((this.getTaxableAmt() >= 142.01) & 
                    (this.getTaxableAmt() <= 509.00)) {
                this.fedTax = ((this.getTaxableAmt() - 142.00) * 0.10);
            }
            else if ((this.getTaxableAmt() >= 509.01) & 
                    (this.getTaxableAmt() <= 1631.00)) {
                this.fedTax = 36.70 + ((this.getTaxableAmt() - 509.00) * 0.12); 
            }
            else if ((this.getTaxableAmt() >= 1631.01) & 
                    (this.getTaxableAmt() <= 3315.00)) {
                this.fedTax = 171.34 + ((this.getTaxableAmt()-1631.00) * 0.22);
            }
            else if ((this.getTaxableAmt() >= 3315.01) & 
                    (this.getTaxableAmt() <= 6200.00)) {
                this.fedTax = 541.82 + ((this.getTaxableAmt()-3315.00) * 0.24);
            }
            else if ((this.getTaxableAmt() >= 6200.01) & 
                    (this.getTaxableAmt() <= 7835.00)) {
                this.fedTax = 1234.22 + ((this.getTaxableAmt()-6200.00) * 0.32);
            }
            else if ((this.getTaxableAmt() >= 7835.01) & 
                    (this.getTaxableAmt() <= 19373.00)) {
                this.fedTax = 1757.42 + ((this.getTaxableAmt()-7835.00) * 0.35);
            }
            else if (this.getTaxableAmt() >= 19373.01) {
                this.fedTax = 5795.72 + ((this.getTaxableAmt()-19373.00)* 0.37);
            }
            else {
                this.fedTax = 0.00;
            }
        }//END ELSEIF
        //ELSEIF single withholding rate and paid semi-monthly
        else if ((this.getFilingStatus() == 1 | this.getFilingStatus() == 4)
                & (this.getPayFrequency() == 24)) {
            
            if (this.getTaxableAmt() <= 154.00) {
                this.fedTax = 0.00;
            }
            else if ((this.getTaxableAmt() >= 154.01) & 
                    (this.getTaxableAmt() <= 551.00)) {
                this.fedTax = ((this.getTaxableAmt() - 154.00) * 0.10);
            }
            else if ((this.getTaxableAmt() >= 551.01) & 
                    (this.getTaxableAmt() <= 1767.00)) {
                this.fedTax = 39.70 + ((this.getTaxableAmt() - 551.00) * 0.12); 
            }
            else if ((this.getTaxableAmt() >= 1767.01) & 
                    (this.getTaxableAmt() <= 3592.00)) {
                this.fedTax = 185.62 + ((this.getTaxableAmt()-1767.00) * 0.22);
            }
            else if ((this.getTaxableAmt() >= 3592.01) & 
                    (this.getTaxableAmt() <= 6717.00)) {
                this.fedTax = 587.12 + ((this.getTaxableAmt()-3592.00) * 0.24);
            }
            else if ((this.getTaxableAmt() >= 6717.01) & 
                    (this.getTaxableAmt() <= 8488.00)) {
                this.fedTax = 1337.12 + ((this.getTaxableAmt()-6717.00) * 0.32);
            }
            else if ((this.getTaxableAmt() >= 8488.01) & 
                    (this.getTaxableAmt() <= 20988.00)) {
                this.fedTax = 1903.84 + ((this.getTaxableAmt()-8488.00) * 0.35);
            }
            else if (this.getTaxableAmt() >= 20988.01) {
                this.fedTax = 6278.84 + ((this.getTaxableAmt()-20988.00)* 0.37);
            }
            else {
                this.fedTax = 0.00;
            }
        }//END ELSEIF
        //ELSEIF single withholding rate and paid monthly
        else if ((this.getFilingStatus() == 1 | this.getFilingStatus() == 4)
                & (this.getPayFrequency() == 12)) {
            
            if (this.getTaxableAmt() <= 308.00) {
                this.fedTax = 0.00;
            }
            else if ((this.getTaxableAmt() >= 308.01) & 
                    (this.getTaxableAmt() <= 1102.00)) {
                this.fedTax = ((this.getTaxableAmt() - 308.00) * 0.10);
            }
            else if ((this.getTaxableAmt() >= 1102.01) & 
                    (this.getTaxableAmt() <= 3533.00)) {
                this.fedTax = 79.40 + ((this.getTaxableAmt() - 1102.00) * 0.12); 
            }
            else if ((this.getTaxableAmt() >= 3533.01) & 
                    (this.getTaxableAmt() <= 7183.00)) {
                this.fedTax = 371.12 + ((this.getTaxableAmt()-3533.00) * 0.22);
            }
            else if ((this.getTaxableAmt() >= 7183.01) & 
                    (this.getTaxableAmt() <= 13433.00)) {
                this.fedTax = 1174.12 + ((this.getTaxableAmt()-7183.00) * 0.24);
            }
            else if ((this.getTaxableAmt() >= 13433.01) & 
                    (this.getTaxableAmt() <= 16975.00)) {
                this.fedTax = 2674.12 + ((this.getTaxableAmt()-13433.00)* 0.32);
            }
            else if ((this.getTaxableAmt() >= 16975.01) & 
                    (this.getTaxableAmt() <= 41975.00)) {
                this.fedTax = 3807.56 + ((this.getTaxableAmt()-16975.00)* 0.35);
            }
            else if (this.getTaxableAmt() >= 41975.01) {
                this.fedTax = 12557.56 + ((this.getTaxableAmt()-41975.00)*0.37);
            }
            else {
                this.fedTax = 0.00;
            }
        }//END ELSEIF
        //ELSEIF married withholding rate and paid weekly
        else if ((this.getFilingStatus() == 2 | this.getFilingStatus() == 3) 
                & (this.getPayFrequency() == 52)) {
            
            if (this.getTaxableAmt() <= 222.00) {
                this.fedTax = 0.00;
            }
            else if ((this.getTaxableAmt() >= 222.01) & 
                    (this.getTaxableAmt() <= 588.00)) {
                this.fedTax = ((this.getTaxableAmt() - 222.00) * 0.10);
            }
            else if ((this.getTaxableAmt() >= 588.01) & 
                    (this.getTaxableAmt() <= 1711.00)) {
                this.fedTax = 36.60 + ((this.getTaxableAmt() - 588.00) * 0.12); 
            }
            else if ((this.getTaxableAmt() >= 1711.01) & 
                    (this.getTaxableAmt() <= 3395.00)) {
                this.fedTax = 171.36 + ((this.getTaxableAmt()-1711.00) * 0.22);
            }
            else if ((this.getTaxableAmt() >= 3395.01) & 
                    (this.getTaxableAmt() <= 6280.00)) {
                this.fedTax = 541.84 + ((this.getTaxableAmt()-3395.00) * 0.24);
            }
            else if ((this.getTaxableAmt() >= 6280.01) & 
                    (this.getTaxableAmt() <= 7914.00)) {
                this.fedTax = 1234.24 + ((this.getTaxableAmt()-6280.00)* 0.32);
            }
            else if ((this.getTaxableAmt() >= 7914.01) & 
                    (this.getTaxableAmt() <= 11761.00)) {
                this.fedTax = 1757.12 + ((this.getTaxableAmt()-7914.00)* 0.35);
            }
            else if (this.getTaxableAmt() >= 11761.01) {
                this.fedTax = 3103.57 + ((this.getTaxableAmt()-11761.00)*0.37);
            }
            else {
                this.fedTax = 0.00;
            }
        }//END ELSEIF
        //ELSEIF married withholding rate and paid bi-weekly
        else if ((this.getFilingStatus() == 2 | this.getFilingStatus() == 3) 
                & (this.getPayFrequency() == 26)) {
            
            if (this.getTaxableAmt() <= 444.00) {
                this.fedTax = 0.00;
            }
            else if ((this.getTaxableAmt() >= 444.01) & 
                    (this.getTaxableAmt() <= 1177.00)) {
                this.fedTax = ((this.getTaxableAmt() - 444.00) * 0.10);
            }
            else if ((this.getTaxableAmt() >= 1177.01) & 
                    (this.getTaxableAmt() <= 3421.00)) {
                this.fedTax = 73.30 + ((this.getTaxableAmt() - 1177.00) * 0.12); 
            }
            else if ((this.getTaxableAmt() >= 3421.01) & 
                    (this.getTaxableAmt() <= 6790.00)) {
                this.fedTax = 342.58 + ((this.getTaxableAmt()-3421.00) * 0.22);
            }
            else if ((this.getTaxableAmt() >= 6790.01) & 
                    (this.getTaxableAmt() <= 12560.00)) {
                this.fedTax = 1083.76 + ((this.getTaxableAmt()-6790.00) * 0.24);
            }
            else if ((this.getTaxableAmt() >= 12560.01) & 
                    (this.getTaxableAmt() <= 15829.00)) {
                this.fedTax = 2468.56 + ((this.getTaxableAmt()-12560.00)* 0.32);
            }
            else if ((this.getTaxableAmt() >= 15829.01) & 
                    (this.getTaxableAmt() <= 23521.00)) {
                this.fedTax = 3514.64 + ((this.getTaxableAmt()-15829.00)* 0.35);
            }
            else if (this.getTaxableAmt() >= 23521.01) {
                this.fedTax = 6206.84 + ((this.getTaxableAmt()-23521.00)*0.37);
            }
            else {
                this.fedTax = 0.00;
            }
        }//END ELSEIF
        //ELSEIF married withholding rate and paid semi-monthly
        else if ((this.getFilingStatus() == 2 | this.getFilingStatus() == 3) 
                & (this.getPayFrequency() == 24)) {
            
            if (this.getTaxableAmt() <= 481.00) {
                this.fedTax = 0.00;
            }
            else if ((this.getTaxableAmt() >= 481.01) & 
                    (this.getTaxableAmt() <= 1275.00)) {
                this.fedTax = ((this.getTaxableAmt() - 481.00) * 0.10);
            }
            else if ((this.getTaxableAmt() >= 1275.01) & 
                    (this.getTaxableAmt() <= 3706.00)) {
                this.fedTax = 79.40 + ((this.getTaxableAmt() - 1275.00) * 0.12); 
            }
            else if ((this.getTaxableAmt() >= 3706.01) & 
                    (this.getTaxableAmt() <= 7356.00)) {
                this.fedTax = 371.12 + ((this.getTaxableAmt()-3706.00) * 0.22);
            }
            else if ((this.getTaxableAmt() >= 7356.01) & 
                    (this.getTaxableAmt() <= 13606.00)) {
                this.fedTax = 1174.12 + ((this.getTaxableAmt()-7356.00) * 0.24);
            }
            else if ((this.getTaxableAmt() >= 13606.01) & 
                    (this.getTaxableAmt() <= 17148.00)) {
                this.fedTax = 2674.12 + ((this.getTaxableAmt()-13606.00)* 0.32);
            }
            else if ((this.getTaxableAmt() >= 17148.01) & 
                    (this.getTaxableAmt() <= 25481.00)) {
                this.fedTax = 3807.56 + ((this.getTaxableAmt()-17148.00)* 0.35);
            }
            else if (this.getTaxableAmt() >= 25481.01) {
                this.fedTax = 6724.11 + ((this.getTaxableAmt()-25481.00)*0.37);
            }
            else {
                this.fedTax = 0.00;
            }
        }//END ELSEIF
        //ELSEIF married withholding rate and paid monthly
        else if ((this.getFilingStatus() == 2 | this.getFilingStatus() == 3) 
                & (this.getPayFrequency() == 12)) {
            
            if (this.getTaxableAmt() <= 963.00) {
                this.fedTax = 0.00;
            }
            else if ((this.getTaxableAmt() >= 963.01) & 
                    (this.getTaxableAmt() <= 2550.00)) {
                this.fedTax = ((this.getTaxableAmt() - 963.00) * 0.10);
            }
            else if ((this.getTaxableAmt() >= 2550.01) & 
                    (this.getTaxableAmt() <= 7413.00)) {
                this.fedTax = 158.70 + ((this.getTaxableAmt() - 2550.00) * 0.12); 
            }
            else if ((this.getTaxableAmt() >= 7413.01) & 
                    (this.getTaxableAmt() <= 14713.00)) {
                this.fedTax = 742.26 + ((this.getTaxableAmt()-7413.00) * 0.22);
            }
            else if ((this.getTaxableAmt() >= 14713.01) & 
                    (this.getTaxableAmt() <= 27213.00)) {
                this.fedTax = 2348.26 + ((this.getTaxableAmt()-14713.00)* 0.24);
            }
            else if ((this.getTaxableAmt() >= 27213.01) & 
                    (this.getTaxableAmt() <= 34296.00)) {
                this.fedTax = 5348.26 + ((this.getTaxableAmt()-27213.00)* 0.32);
            }
            else if ((this.getTaxableAmt() >= 34296.01) & 
                    (this.getTaxableAmt() <= 50963.00)) {
                this.fedTax = 7614.82 + ((this.getTaxableAmt()-34296.00)* 0.35);
            }
            else if (this.getTaxableAmt() >= 50963.01) {
                this.fedTax = 13448.27 + ((this.getTaxableAmt()-50963.00)*0.37);
            }
            else {
                this.fedTax = 0.00;
            }
        }//END ELSEIF
        //ADD any additional federal withholding amount
        this.fedTax = this.fedTax + this.getAddtlFedTax();
        //FORMAT federal tax amount to correct decimal place
        BigDecimal bd = BigDecimal.valueOf(this.fedTax);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.fedTax = bd.doubleValue();
        
    }
    //RETURN federal tax amount
    public double getFedTax() {
        return this.fedTax;
    }
    
    //SET Social Security tax amount @ 6.2% of taxable wages
    public void setSSTax() throws ParseException {
        //IF paid less than $128400 this year
        if (this.getSSTaxElig() == true) {
            this.ssTax = (this.getGrossPay() * 0.062);
            BigDecimal bd = BigDecimal.valueOf(this.ssTax);
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            this.ssTax = bd.doubleValue();
        }
        //ELSE if paid $128400 or more this year
        else {
            this.ssTax = 0.00;
            BigDecimal bd = BigDecimal.valueOf(this.ssTax);
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            this.ssTax = bd.doubleValue();
        }
    }
    
    //RETURN Social Security tax amount
    public double getSSTax() {
        return this.ssTax;
    }
    
    //SET Medicare tax amount @ 1.45% or 2.35% of taxable wages
    public void setMedicareTax() throws ParseException {
        
        if (this.getAddtlMedTaxElig() == false) {
            this.medicareTax = (this.getGrossPay() * 0.0145);
            BigDecimal bd = BigDecimal.valueOf(this.medicareTax);
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            this.medicareTax = bd.doubleValue();
        }
        else {//IF year-to-date wages are greater than or equal to $200,000
            this.medicareTax = (this.getGrossPay() * 0.0235);
            BigDecimal bd = BigDecimal.valueOf(this.medicareTax);
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            this.medicareTax = bd.doubleValue();
        }
    }
    
    //RETURN Medicare tax amount
    public double getMedicareTax() {
        return this.medicareTax;
    }

/*  STATE TAX UNUSED AT THIS TIME - IMPLEMENT IN FUTURE VERSION
    //SET state tax amount
    public void setStateTax() {
        //FIXME - create algorithm to calculate state tax
    }
    
    //RETURN state tax amount
    public double getStateTax() {
        return this.stateTax;
    }
*/
/*  LOCAL TAX UNUSED AT THIS TIME - IMPLEMENT IN FUTURE VERSION
    //SET local tax amount
    public void setLocalTax() {
        //FIXME - create algorithm to calculate local tax
    }
    
    //RETURN local tax amount
    public double getLocalTax() {
        return this.localTax;
    }
    
*/
    //SET net pay amount
    public void setNetPay() throws ParseException {
        
        this.netPay = (this.grossPay - this.preTaxAmt - this.fedTax - 
                this.ssTax - this.medicareTax - this.stateTax - this.localTax -
                this.postTaxAmt);
        BigDecimal bd = BigDecimal.valueOf(this.netPay);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.netPay = bd.doubleValue();
    }
    //RETURN net pay amount
    public double getNetPay() {
        return this.netPay;
    }

}//END class Salary Employee