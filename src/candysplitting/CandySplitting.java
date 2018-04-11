package candysplitting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CandySplitting {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new  FileReader("D:\\CodeJam\\C-large.in"));
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\CodeJam\\C-large.out"));
	        String str1;
	        String str2;
	        int counter = 1;
	        str1 = in.readLine();
	        System.out.println("Let the games begin!");
	        while (in.ready()) {
	            	counter++;
	            	str1 = in.readLine();
	            	str2 = in.readLine();
	            	str1 = process (str1, str2,counter -1);
	                System.out.println(str1);
	                if (counter > 1) {
	                	out.write(str1);
		                out.newLine();
	                }
	        }
	        in.close();
	        out.close();
        } catch (IOException e) {
		    	System.out.println("FUDEU!");
        }    	
   }
    public static String process(String str1, String str2, int c){
  //		if (c == 1) return "";
 
		int ind1 = str2.indexOf(" ");
   		int ind2 = 0;
		int N = Integer.parseInt(str1);

   		long [] bag = new long [N];
   		
   		bag [0] = Integer.parseInt(str2.substring(0,ind1)); 

  		for (int i = 1; i < N; i++){
       		ind2 = str2.indexOf(' ',ind1+1);
			
       		if (ind2 == -1) bag [i] = Integer.parseInt (str2.substring (ind1 + 1));
		       else bag [i] = Integer.parseInt (str2.substring (ind1 + 1, ind2));
       		ind1 = ind2;
		}
   		
  		boolean cry = false;
  		long xor = bag [0];
  		for (int i = 1; i < N; i++){
			//XOR é comutativo
			xor = xor ^ bag [i];
		}
//		if (xor % 2 != 0) return "Case #"+(c)+": NO";
		if (xor != 0) return "Case #"+(c)+": NO";
  		
  		//ordenar a bag
  		//bag = HeapSort.heapSort(bag);
  		Arrays.sort(bag);
  		
//  		long aux;
//     	long pilesize = 0;
//     	for (int i = 0; i < N; i++){
//     		aux = bag [i];
//     		bag [i] = bag [N-i];
//     		bag[N-i] = aux;
//     	}
     	
//     	pilesize = xor/2;
//  		System.out.println("XOR " + xor);
  		
  		long biggerS = 0;
   	    boolean finish = false;
  	
   		long P = 0;
   		long P1 = 0;

   		long S = 0;
   	    
   		System.out.println (xor);
  		for (int i = 0; i < bag.length; i++){ //checando elementos sozinhos
  			P = 0;
			P1 = 0;
			S = 0;
  			for (int j = 0; j < bag.length; j++) {
  				if (j == i) P ^= bag[j];
   				else        {
   					P1 ^= bag[j];
   					S  += bag[j];
   				}
   				
   			}
   			if (P1 == P){
		  		System.out.println ("Saida " + 1);
   				return "Case #"+(c )+": " + S;
			}
   		}
   		for (int i = 0; i < bag.length; i++){ //checando elementos sozinhos
 	 		for (int k = 0; k < bag.length; k++){ //checando elementos sozinhos
 	 			if (i == k) k++;
 	 			P = 0;
				P1 = 0;
				S = 0;
	
				for (int j = 0; j < bag.length; j++) {
	  				if (j == i || j == k) P ^= bag[j];
	   				else        {
	   					P1 ^= bag[j];
	   					S  += bag[j];
	   				}
	   				
	   			}
	   			if (P1 == P){
			  		System.out.println ("Saida " + 2);
	   				return "Case #"+(c )+": " + S;
				}
 	 		}	
   		}
  		
	  	return "Case #"+(c )+": FERROU";
 }
}
