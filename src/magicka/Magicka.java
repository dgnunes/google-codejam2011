package magicka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Magicka {
	
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new  FileReader("D:\\CodeJam\\B-large.in"));
	        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\CodeJam\\B-large.out"));
	        String str;
	        int counter = 0;
	        System.out.println("Let the games begin!");
	        while (in.ready()) {
	            	counter++;
	            	str = in.readLine();
	                str = process (str,counter);
	                System.out.println(str);
	                if (counter > 1) {
	                	out.write(str);
		                out.newLine();
	                }
	        }
	        in.close();
	        out.close();
        } catch (IOException e) {
		    	System.out.println("FUDEU!");
        }    	
   }
    public static String process(String str,int c){
   		if (c == 1) return "";
   		System.out.println(str);

   		int ind1 = str.indexOf(" ");
   		int ind2 = 0;
   		CharSequence tmp;
   		CharSequence eInput;
   		
   		String spell = "[";
   		
   		int C, D, N;
       		C = Integer.parseInt(str.substring(0,ind1)); 
      		char [] c1 = new char [2*C];
      		char [] c2 = new char [2*C];
      		char [] c3 = new char [2*C];
      		
      		if (C != 0)
      			for (int i = 0; i < 2*C; i+=2) {
      				tmp = str.subSequence(ind1+1,str.indexOf(" ",ind1+1));
      				c1   [i]  = tmp.charAt(0);
      				c1 [i+1]  = tmp.charAt(1) ;
      				c2   [i]  = tmp.charAt(1);
      				c2 [i+1]  = tmp.charAt(0) ;
      				c3   [i]  = tmp.charAt(2);
      				c3 [i+1]  = tmp.charAt(2) ;
       				ind1 = str.indexOf(" ",ind1+1);
      			}
      		D = Integer.parseInt(str.substring(ind1+1,str.indexOf(" ",ind1+1)));
      		char [] d1 = new char [2*D];
      		char [] d2 = new char [2*D];
       		ind1 = str.indexOf(' ',ind1+1);
      		if (D != 0)
      			for (int i = 0; i < 2*D; i += 2) {
      				tmp = str.subSequence(ind1+1,str.indexOf(" ",ind1+1));
      				d1   [i]  = tmp.charAt(0);
      				d1 [i+1]  = tmp.charAt(1);
      				d2   [i]  = tmp.charAt(1);
      				d2 [i+1]  = tmp.charAt(0);
       				ind1 = str.indexOf(" ",ind1+1);
     			}
       		N = Integer.parseInt(str.substring(ind1+1,str.indexOf(" ",ind1+1)));
      		ind1 = str.indexOf(' ',ind1+1);
       		eInput = str.subSequence(ind1+1,ind1 + N + 1);
      		
       		char [] eOutput = new char [eInput.length()];
      		
      		if (N > 0) eOutput [0] = eInput.charAt(0);  
 			System.out.println("ADDED");
      		int last = 0;

      		boolean finish;
      		for (int i = 1; i < N; i++) {
      			finish = false;
      			//checa Vazio
      			if (last == -1) {
         			System.out.println("ADDED");
      				eOutput [0] = eInput.charAt(i);
      				finish = true;
      				last = 0;
      			}
      			//checa combinação
      			for (int j = 0; (j < 2 * C) && !finish ; j++){
      				if (c1[j] == eInput.charAt(i)){
      					if (c2 [j] == eOutput [last]){
      						System.out.println("COMBINATION");
      						eOutput [last] = c3 [j];
      						finish = true;
      						//checar se depois de transformação não combina com o anterior
      		      			boolean again = true;
      						while ((last > 0) && again ){
      		      				again = false;
      		      				for (int k = 0; (k < 2 * C) ; k++){
      		      					if (c1[k] == eOutput[last]){
      		      						if (c2 [k] == eOutput [last -1]){
      		        						System.out.println("COMBINATION");
      		      							last--;
      		      							eOutput [last] = c3 [k];
      		      							again = true;
      		      						}
      		      					}
      		      				}
      						}
      					}
      				}
      			}
      			//checa destruição
      			for (int j = 0; (j < 2 * D) && !finish ; j++){
      				if (d1[j] == eInput.charAt(i)){
      					for (int z = 0; z <= last; z++){
          					if (d2 [j] == eOutput [z]){
          						System.out.println("DESTRUCTION");
          						finish = true;
          						eOutput = new char [eInput.length()];
          						last = -1;
          						break;
           					}
      					}
      				}
      			}
      			//adiciona elemento
      			if (!finish) {
         			System.out.println("ADDED");
      				last++;
      				eOutput [last] = eInput.charAt(i); 
      			}
      				
      			
      		}
      		


  
      	for (int i = 0; i <= last; i++ ){
   			spell += eOutput [i];
   			if (i < last) spell += ", ";
  		}
  		
   	    return "Case #"+(c-1)+": " + spell + "]";
    	}
 }	    
