package gorosort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GoroSort {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("D:\\CodeJam\\D-large.in"));
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\CodeJam\\D-large.out"));
	        String str1;
	        String str2;
	        int counter = 1;
	        System.out.println("Let the games begin!");
        	str1 = in.readLine();
	        while (in.ready()) {
	            	counter++;
	            	str1 = in.readLine();
	            	str2 = in.readLine();
	                str1 = process (str1,str2,counter);
	                System.out.println(str1);
	                out.write(str1);
	                out.newLine();
	        }
	        in.close();
	        out.close();
        } catch (IOException e) {
        	System.out.println(e);
        	System.out.println("FUDEU!");
        }    	
   }
    	public static String process(String str1, String str2, int c){
    		int ind1 = str2.indexOf(" ");
    		int ind2 = 0;
    		int N = Integer.parseInt(str1);
    		int punch1 = 0;
    		int punch2 = 0;
    		int punch3 = 0;
 
    		int [] gorosort = new int [N];
       		int [] hvector  = new int [N];
    		
    		System.out.println("##########################");
    		if (N == 1) gorosort [0] = Integer.parseInt(str2); 
    		else
			gorosort [0] = Integer.parseInt(str2.substring(0,ind1)); 
    		for (int i = 1; i < N; i++){
           		ind2 = str2.indexOf(' ',ind1+1);
    			
	       		if (ind2 == -1) gorosort [i] = Integer.parseInt (str2.substring (ind1 + 1));
			       else gorosort [i] = Integer.parseInt (str2.substring (ind1 + 1, ind2));
	       		ind1 = ind2;
    		}

    		for (int j = 0; j < gorosort.length; j++) System.out.print (gorosort[j] + " ");
    		System.out.print ("\n");
    		hvector = gorosort.clone();
    		
    		//hvector = HeapSort.heapSort(hvector); 
    		Arrays.sort(hvector);
    		int [] gorosort2 = gorosort.clone();
    		int [] gorosort3 = gorosort.clone();
    		
    		int temp;
    		int min = 0;
    		for (int i = 0; i < gorosort.length; i++){
    			if (gorosort [i] != hvector [i]) { //não está no local certo
        			min = hvector [i];

        			for (int j = i; j < gorosort.length; j++){ //encontra min no gorosort
        				if (gorosort [j] == min) {
        					punch1 ++;
        					temp = gorosort [j];
    						gorosort [j] = gorosort [i];
    						gorosort [i] = temp;
        				}
        			}
        			
    			}
    			
    		}
    		temp = 0;
    		min = 0;
    		for (int i = gorosort2.length-1; i >= 0; i--){
    			if (gorosort2 [i] != hvector [i]) { //não está no local certo
        			min = hvector [i];

        			for (int j = gorosort2.length-1; j >= 0; j--){ //encontra min no gorosort
        				if (gorosort2 [j] == min) {
        					punch2 ++;
        					temp = gorosort2 [j];
    						gorosort2 [j] = gorosort2 [i];
    						gorosort2 [i] = temp;
        				}
        			}
        			
    			}
    			
    		}
    		
       		temp = 0;
    		min = 0;
    		for (int i = 0; i < gorosort3.length; i++){
    			if (gorosort3 [i] != hvector [i]) { //não está no local certo
        			min = hvector [i];

        			for (int j = i; j < gorosort3.length; j++){ //encontra min no gorosort
        				if (gorosort2 [j] == min) {
        					punch3 += Math.abs(j - i) + 1;
        					temp = gorosort3 [j];
    						gorosort2 [j] = gorosort3 [i];
    						gorosort2 [i] = temp;
        				}
        			}
        			
    			}
    			
    		}
    		
    		
    		if (punch1 != punch2 ) System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
      	    for (int j = 0; j < gorosort.length; j++) System.out.print (gorosort[j] + " ");
      	    System.out.print ("\n");
    	    return "Case #"+(c-1)+": " + punch3 + ".000000";

    	}

		    
		    
}
