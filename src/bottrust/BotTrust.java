package bottrust;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BotTrust {
	
	public static void main(String[] args) {
		try {
			BufferedReader in  = new BufferedReader(new FileReader ("D:\\CodeJam\\A-small-attempt3.in"));
	        BufferedWriter out = new BufferedWriter(new FileWriter ("D:\\CodeJAm\\A-small.out"));
	        String str;
	        int counter = 0;
//	        System.out.println("Let the games begin!");
	        while (in.ready()) {
	            	counter++;
	            	str = in.readLine();
	                str = process (str,counter);
	                System.out.println(str);
	                out.write(str);
	                out.newLine();
	        }
	        in.close();
	        out.close();
        } catch (IOException e) {
        	System.out.println(e);	
        	System.out.println("FUDEU!");
        }    	
   }
    	public static String process(String str,int c){
    		String s;
    		if (c == 1) return "";
    		System.out.println(str);
    		int ind1 = str.indexOf(" ");
    		int ind2 = 0;
    		String R;
    		int P;
    		int n         = Integer.parseInt(str.substring(0,ind1)); 
    		int t         = 0;
    		
    		int [] Orange = new int [n]; 
    		int [] Blue   = new int [n];

    		for (int i = 1; i <= n; i++) {
        		R = str.substring(ind1+1,str.indexOf(" ",ind1+1));
        		
        		ind1 = str.indexOf(" ",ind1+1);
				ind2 = str.indexOf(' ',ind1+1);
				if (ind2 != -1) s = str.substring (ind1 + 1, ind2);
        		if (ind2 == -1) P = Integer.parseInt (str.substring (ind1 + 1));
        			       else P = Integer.parseInt (str.substring (ind1 + 1, ind2));
        			
        		if (R.equals("O")){
        			Orange [i - 1] = P;
        			Blue   [i - 1] = 0;
        		} 
        		else {
        			Orange [i - 1] = 0;
        			Blue   [i - 1] = P;
        		}
        		
        		ind1 = ind2;
				ind2 = str.indexOf(' ',ind1+1);	
    		}
    		int Po         = 1;
    		int Pb         = 1;
    		int tnow       = 0;
    		int move;
    		boolean BNext = Orange [0] == 0;
    		for (int i = 0; i <= n-1;i++) {
        		tnow       = 1;
    			System.out.println("#######################");
        		if (BNext) {
    				//Blue Acting
    				move = 0;
    				if (Pb != Blue [i]) {
    					move = Math.abs(Blue [i] - Pb);
    					tnow = move + 1;
    					System.out.println ("B vai de " + Pb +" até " + Blue [i] + " gastando " + move + " e aperta botão com " + 1);
    					Pb   = Blue[i];
    				} else System.out.println ("B aperta botão");
    				//Orange Acting
    				int nP = 0;
    				for (int j = i; j <= n-1; j++){
    					if (Orange [j] != 0) {
    						nP = Orange [j];
    						break;
    					}
    				}
    				move = 0;
    				if (nP > 0)
    					if (nP != Po)
    						move = (nP - Po)/Math.abs(nP - Po);
    				if (Math.abs(nP - Po) > tnow) move = move * tnow;
    				else move = (nP - Po);
    				System.out.println("O se adianta e vai de " + Po + " até " + (Po + move) + " andando " + move + " para chegar em " + nP);
    				
    				Po += move;
			
   				} else {
    				//Orange Acting
   		    		move = 0;
    				if (Po != Orange [i]) {
    					move = Math.abs(Orange [i] - Po);
    					tnow =  move + 1;
    					System.out.println ("O vai de " + Po +" até " + Orange [i] + " gastando " + move + " e aperta botão com " + 1);
    					Po   = Orange[i];
    				} else System.out.println ("O aperta botão");

    				//Blue Acting
    				int nP = 0;
    				for (int j = i; j <= n-1; j++){
    					if (Blue [j] != 0) {
    						nP = Blue [j];
    						break;
    					}
    				}
    				move = 0;
    				if (nP > 0)
    					if (nP != Pb)
    						move = (nP - Pb)/Math.abs(nP - Pb);
    				if (Math.abs(nP - Pb) > tnow) move = move * tnow; 
    				else move = (nP - Pb);
    				System.out.println("B se adianta e vai de " + Pb + " até " + (Pb + move) + " andando " + move + " para chegar em " + nP);
    				
    				Pb += move;
   					
   				}	
    			System.out.println ("-> " + tnow + " segundos");
        		t += tnow;
    			if (i <= n-2)
    				BNext = Orange [i + 1] == 0;
    		}
   	
    	    return "Case #"+(c-1)+": " + t;

    	}
		    
		    
}