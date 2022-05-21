/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SJF {
    public static void sjf() throws FileNotFoundException
    {
  int pm; 
    int pz; 
    int rrq; 
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
    rrq=sc.nextInt();
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
    
               int f[] = new int[5];  
		int s=0;
                int m=0;
		
 
		for(int i=0;i<5;i++)
                {
			id[i] = i+1; 
			f[i] = 0;
		}
		
		boolean a = true;
		while(true)
		{
			int c=5;
                        int min=999;
			if (m == 5) 
				break;
			for (int i=0; i<5; i++)
			{
				if ((at[i] <= s) && (f[i] == 0) && (cb[i]<min))
				{
					min=cb[i]; 
					c=i;
				}
			}
			if (c==5) 
				s++;
			else
			{
				ct[c]=s+cb[c];
				s+=cb[c]+cs;
				ta[c]=ct[c]-at[c]; 
				wt[c]=ta[c]-cb[c]; 
				f[c]=1;
				m++;
			}
		}
        int totalwt = 0;
        int totalta = 0 ; 
        int totalfi=0; 
        int totalcb=0;  
        double maxfi = ct[0]; 
            for (int i = 0; i < 5; i++) {
                   totalwt+= wt[i]; 
                   totalta+= ta[i];   
                   totalfi+= ct[i]; 
                   totalcb+= cb[i];
                   id[i]=i;
            }
            for (int i = 1; i < 5; i++) {
                if (ct[i]>maxfi)
                    maxfi=ct[i]; 
            
        }
            
          int temp;
        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 5; j++) {
                if(ct[i] > ct[j]) {
                    temp = ct[i];
                    ct[i] = ct[j];
                    ct[j] = temp;
                    temp = id[i];
                    id[i] = id[j];
                    id[j] = temp;
                    temp = cb[i];
                    cb[i] = cb[j];
                    cb[j] = temp;
                    temp=at[i];
                    at[i]=at[j];
                    at[j]=temp;
                    temp=wt[i];
                    wt[i]=wt[j];
                    wt[j]=temp;
                    temp=ta[i];
                    ta[i]=ta[j];
                    ta[j]=temp;
                }
            }
        } 
        
             int beg[]=new int[5]; 
        int fin[]=new int[5]; 
            for (int i = 0; i < 5; i++) {
            beg[id[i]]=ct[id[i]]-cb[id[i]];
         fin[id[i]]=ct[id[i]]; 
        }
        
        
      System.out.println("a)\n gantt chart: ");
        System.out.println("--------------------------------------------------------------------------");
         for(int i = 0; i < 5; i++) {
            System.out.print("| "+beg[i]+" '"+"P" + id[i]+"' "+fin[i]+" |"); 
        }
           System.out.println("\n-----------------------------------------------------------------------");
         System.out.println("\nb)");
         System.out.println("processID\tfinish time\tturnaround time\t waiting time  ");
         for (int i = 0; i < 5; i++) {
         System.out.println(id[i] +"\t\t" +ct[i] + "\t\t" +ta[i] + "\t\t" +wt[i]);
        }
         System.out.println("c)");
         System.out.print("Average waiting time = " + (double)(totalwt /5));
         System.out.println("\nAverage turn around time = " + (double)totalta /(5));  
             System.out.println("Average finish  time= " + (double)totalfi/ 5); 
             System.out.println("d)\ncpu utilization :" +((totalcb/maxfi)*100) + "%");
	}
}

