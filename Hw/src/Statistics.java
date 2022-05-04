/*
 *		Name:		Lam, Simon
 *		Project:	HW #2
 *		Due:		Oct. 19, 2012
 *		Course:		CS-141-01-f12
 *
 *		Description:
 *		This project is called Statistics. I implemented most of the code from
 *		my professor T. Nguyen. However, the standard deviation was designed 
 *		by me. This project determines the minimum, maximum, average, and
 *		standard deviation value from a list of random integers in an array.
 *
 */

import java.util.Random;
import java.text.DecimalFormat;

public class Statistics {

	private int[] numberArray;
    private final int MAX_VALUE = 100;
    
    public Statistics (int n) {
        numberArray = new int[n];
    }
    
    public void randomInitalize (int seed) {
        Random rand = new Random();
        
        if (seed != 0){
            rand.setSeed(seed);
        }
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = rand.nextInt(MAX_VALUE + 1);
        }

    }
    
    public int getMaximum () {
        int max = numberArray[0];
        for (int i = 1; i < numberArray.length; i++) {
           if (numberArray[i] > max) {
               max = numberArray[i];
           }
        }
        return max;
    }
        
    public int getMinimum () {
        int min = numberArray[0];
        for (int num : numberArray) {
           if (num < min) {
               min = num;
           }
        }
        return min;
    }
    
        
    public double getAverage () {
        int sum = 0;
        for (int num : numberArray){
           sum += num;
        }
        return (double)sum / numberArray.length;
    }

    public double getStandardDeviation () {
    	int sum = 0;
        for (int num : numberArray) {
        	sum += ((num - getAverage()) * (num - getAverage()));
        }
        return Math.sqrt((double)sum / numberArray.length);
    }

    
    public void print (int perline) {
        int itemCount = 0;
        for (int num : numberArray) {
            System.out.printf("%6d", num);
            if (++itemCount % perline == 0)
                System.out.println();
        }
        if (itemCount % perline != 0)
            System.out.println();
    }
    
    public void printPseudoHistogram () {
        int[] modeArray = new int[MAX_VALUE + 1];
        
        for (int num : numberArray){
            modeArray[num]++;
        }
        for (int i = 0; i < modeArray.length; i++) {
            if (modeArray[i] > 0) {
                System.out.printf("%4d: ", i);
                for (int j = 0; j < modeArray[i]; j++)
                    System.out.printf("*");
                System.out.println();
            }
        }
    }
    
    public void printHistogramLandscape () {
    	
    	DecimalFormat format = new DecimalFormat("#00");
    	
    	int[] listArray = new int [MAX_VALUE + 1];
    	
    	for (int num : numberArray){
    		listArray[num]++;
    	}
    	for (int i = 0; i < listArray.length; i++) {
    			for (int j = numberArray.length; j >= 1; j--) {
    				if (j == listArray[i]) {
    					System.out.print(" *");
    				} else {
    					System.out.print("");
    				}
    			}
    	}
    	System.out.println();
    	for (int x = 0; x < listArray.length; x++){
    		System.out.printf(" " + format.format(x));
    	}
    }

	public static void main (String[] args) {

        Statistics stats = new Statistics(250);     
        
        stats.randomInitalize(100);
         
        stats.print(10);
        
        System.out.println("Maximum = " + stats.getMaximum());
        System.out.println("Minimum = " + stats.getMinimum());
        System.out.printf("Average = %.2f\n", stats.getAverage());
        System.out.printf("Standard Deviation = %.2f\n", stats.getStandardDeviation());
        //stats.printPseudoHistogram();
        stats.printHistogramLandscape();        
	}
}
