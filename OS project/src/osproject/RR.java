 
package osproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RR {
       public static void roundRobin() throws FileNotFoundException 
    { 
        
   int pm; 
    int pz;
    int q; 
    int cs; 
    int id[]=new int[5]; 
    int at[] =new int[5]; 
    int cb[] = new int[5]; 
    int sb[]=new int[5];  
    int wt[] = new int[5]; 
    int ct[] =new int[5]; 
    int ta[]=new int[5];  
    File file = new File("Processes.txt");
    Scanner sc =new Scanner(file); 
    pm = sc.nextInt();
    pz=sc.nextInt();
    q=sc.nextInt();
    cs=sc.nextInt();
    while (sc.hasNextInt())
    {
        for (int i = 0; i < 5; i++) {
            id[i] = sc.nextInt();
            at[i]= sc.nextInt();
            cb[i] =sc.nextInt();
            sb[i]=sc.nextInt();
        }
    }
    
    
        String seq = new String();  
        int res_b[] = new int[cb.length]; 
        int res_a[] = new int[at.length];  
  
        for (int i = 0; i < res_b.length; i++) { 
            res_b[i] = cb[i]; 
            res_a[i] = at[i]; 
        } 
        
        int t = 0; 
        while (true) { 
            boolean flag = true; 
            for (int i = 0; i < 5; i++) { 
                if (res_a[i] <= t) { 
                    if (res_a[i] <= q) { 
                        if (res_b[i] > 0) { 
                            flag = false; 
                            if (res_b[i] > q) { 
                                t = t + q + cs; 
                                res_b[i] = res_b[i] - q; 
                                res_a[i] = res_a[i] + q; 
                                seq += " " + id[i]; 
                            } 
                            else { 
                                t = t + res_b[i]+cs; 
                                ct[i] = t - at[i];  
                                wt[i] = t - cb[i] - at[i];  
                                res_b[i] = 0; 
                                seq += " "+ id[i]; 
                            } 
                        } 
                    }
                    
                    else if (res_a[i] > q) { 
                        for (int j = 0; j < 5; j++) { 
                            if (res_a[j] < res_a[i]) { 
                                if (res_b[j] > 0) { 
                                    flag = false; 
                                    if (res_b[j] > q) { 
                                        t = t + q+cs; 
                                        res_b[j] = res_b[j] - q; 
                                        res_a[j] = res_a[j] + q; 
                                        seq += " " + id[j];  
                                    } 
                                    else { 
                                        t = t + res_b[j]+cs; 
                                        ct[j] = t - at[j];  
                                        wt[j] = t - cb[j] - at[j];  
                                        res_b[j] = 0; 
                                        seq += " " + id[j]; 
                                    } 
                                } 
                            } 
                        } 
                        if (res_b[i] > 0) { 
                            flag = false; 
                            if (res_b[i] > q) { 
                                t = t + q+cs; 
                                res_b[i] = res_b[i] - q; 
                                res_a[i] = res_a[i] + q; 
                                seq += " " + id[i]; 
                            } 
                            else { 
                                t = t + res_b[i]+cs; 
                                ct[i] = t - at[i]; 
                                wt[i] = t - cb[i] - at[i]; 
                                res_b[i] = 0; 
                                seq += " " + id[i];
                            } 
                        } 
                    } 
                } 
                else if (res_a[i] > t) { 
                    t++; 
                    i--; 
                } 
            } 
            if (flag) { 
                break; 
            } 
        }
           
       int totalwt = 0;
        int totalta = 0 ; 
        int totalfi=0;
        int totalcb=0; 
        for (int i = 0; i < 5; i++) {
             ta[i] = ct[i]-at[i]; 
            totalwt+= wt[i]; 
            totalta+= ta[i]; 
            totalfi+= ct[i]; 
            totalcb+= cb[i]; 
        }
        double maxfi=ct[0];
        for (int i = 1; i < 5; i++) {
            if(ct[i]>maxfi)
                maxfi=ct[i];   
        }
        
        //print the requirments 
        System.out.println("a)\n gantt chart");
        System.out.println("------------------------------------------------------------------");
                System.out.println(""+seq); 
                System.out.println("------------------------------------------------------------------");
        System.out.println("\nb)\nid  finisht  waitingt  turnaroundt"); 
        for (int i = 0; i < 5; i++) { 
            System.out.println(" " + id[i] + "    " + ct[i]+ "\t" + wt[i]+"\t" + ta[i]  ); 
           
        } 
  
              System.out.println("c)");
         System.out.print("Average waiting time = " + (double)(totalwt /5)); 
         System.out.println("\nAverage turn around time = " + (double)totalta /(5));  
             System.out.println("Average finish  time= " + (double)totalfi/ 5);  
             System.out.println("d)\ncpu utilization :" +((totalcb/maxfi)*100) + "%");
    } 
  
    
} 
