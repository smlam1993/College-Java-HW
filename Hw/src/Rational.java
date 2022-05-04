/*
* 	Name:  		Lam, Simon
* 	Homework: 	# 3
*	Due:       	10/22/2012
* 	Course: 	CS-141-01-f12
*
*	Description:
* 	This homework is about displaying a rational number with an unknown decimal place. It is also
* 	looking for the maximum and sum of the rational numbers.
*/

import java.text.NumberFormat;
import java.math.BigDecimal;
import java.util.Random;

public class Rational {
    
    private int numerator, denominator;
    
    public Rational (int numerator, int denominator) {
        assert denominator != 0 : "den is 0";
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public Rational () {
        this(0, 1);
    }
    
    public Rational (int numerator) {
        this(numerator, 1);
    }
    
    public void setRational (int numerator, int denominator) {
        assert denominator != 0;
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public double convertDouble () {
        return numerator / denominator;
    }
    
    private static void randomInitialize (Rational[] array) {
        
        Random  rand = new Random();
        
        for (int i = 0; i < array.length; i++)
            array[i].setRational(rand.nextInt(9) + 1, rand.nextInt(9) + 1);
    }
    
    public String print () {
    	return numerator + "/" + denominator;
        }
    
    public String convertString (int numberOfDigits) {
    	BigDecimal bg = new BigDecimal((double)numerator / (double)denominator);
    	NumberFormat nf = NumberFormat.getNumberInstance();
    	nf.setGroupingUsed(false);
    	nf.setMaximumFractionDigits(numberOfDigits);
    	nf.setMinimumFractionDigits(numberOfDigits);
	
    	return nf.format(bg);
        //return the value of the Rational number up to the numberOfDigits fractional digits
    	}

    public void printValue(int numberOfDigits) {
    	BigDecimal bg = new BigDecimal((double)numerator / (double)denominator).setScale(numberOfDigits);
    	System.out.println(bg);

        //print out the value of the Rational number up to the numberOfDigits fractional digits

    }
    
    public static Rational getMaximum (Rational[] array) {
    	Rational max = array[0];
    	
    	for (int i = 1; i < array.length; i++) {
    		if(max.convertDouble() < array[i].convertDouble()){
    			max = array[i];
    		}
    	}
        return max;
    }
 
    public static void main (String[] args) {
           
        Rational[] array = new Rational[50];
        
        for (int i = 0; i < array.length; i++)
            array[i] = new Rational();
        
        Rational.randomInitialize(array);
        
        double sum = 0;
        
        for (Rational r : array)
            sum += r.convertDouble();
        
        System.out.println("maximum = " + Rational.getMaximum(array).print());
        System.out.println("sum = " + sum);
        
        Rational api = new Rational(22, 7);
        
        System.out.println(api.print());
        System.out.println(api.convertString(50));
        api.printValue(100);
        System.out.println();
	}

}