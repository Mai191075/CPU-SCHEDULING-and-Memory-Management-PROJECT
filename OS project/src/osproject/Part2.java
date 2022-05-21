/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Part2 {
    public static void simulation() throws FileNotFoundException
    {   
       int pm,ps,rrq,cs;
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
    ps=sc.nextInt();
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
         
     int framesNo,pagesNo,fs;
     fs=ps;
     framesNo=pm/fs;
     pagesNo=framesNo;
    int pageId0[] =new int[sb[0]/fs];
    int frameId0[] =new int[sb[0]/fs];
       
    int pageId1[] =new int[sb[1]/fs];
    int frameId1[] =new int[sb[1]/fs];
    
    int pageId2[] =new int[sb[2]/fs];
    int frameId2[] =new int[sb[2]/fs];
    
    int pageId3[] =new int[sb[3]/fs];
    int frameId3[] =new int[sb[3]/fs];
    
    int pageId4[] =new int[sb[4]/fs];
    int frameId4[] =new int[sb[4]/fs];
    
    
    ArrayList<Integer> list0 = new ArrayList<>();
        
        for (int i=0; i<sb[0]/fs; i++) {
            list0.add(i);
        }
         Collections.shuffle(list0);
     
         ArrayList<Integer> list1 = new ArrayList<>();
        
        for (int i=0; i<sb[1]/fs; i++) {
            list1.add(i);
        }
       Collections.shuffle(list1);
       
         ArrayList<Integer> list2 = new ArrayList<>();
        
        for (int i=0; i<sb[2]/fs; i++) {
            list2.add(i);
        }
       Collections.shuffle(list2);
       
          
       
         ArrayList<Integer> list3 = new ArrayList<>();
        
        for (int i=0; i<sb[3]/fs; i++) {
            list3.add(i);
        }
       Collections.shuffle(list3);
     
       
         ArrayList<Integer> list4 = new ArrayList<>();
        
        for (int i=0; i<sb[4]/fs; i++) {
            list4.add(i);
        }
       Collections.shuffle(list4);
           
            for (int j = 0; j <sb[0]/fs; j++) {
                pageId0[j]=j;
                frameId0[j]=list0.get(j);
            }
            for (int j = 0; j< sb[1]/fs; j++) {
                 pageId1[j]=j;
                frameId1[j]=list1.get(j);
            }
            for (int j = 0; j< sb[2]/fs; j++) {
              pageId2[j]=j;
                frameId2[j]=list2.get(j);
            }
            for (int j = 0; j< sb[3]/fs; j++) {
            pageId3[j]=j;
                frameId3[j]=list3.get(j);
            }
            for (int j = 0; j< sb[4]/fs; j++) {
            pageId4[j]=j;
                frameId4[j]=list4.get(j);
          
        }
             System.out.println("\n******************************************************************\nA)PAGE TABLE");
            System.out.println("Page Table For Process"+0);
            System.out.println("PageId\tFrameId");
            for (int j = 0; j < sb[0]/fs; j++) {
                 System.out.println(""+pageId0[j]+"\t"+frameId0[j]);
            }
             System.out.println("******************************************************************");
          System.out.println("Page Table For Process"+1);
            System.out.println("PageId\tFrameId");
            for (int j = 0; j < sb[1]/fs; j++) {
                 System.out.println(""+pageId1[j]+"\t"+frameId1[j]);
            }
             System.out.println("******************************************************************");
          System.out.println("Page Table For Process"+2);
            System.out.println("PageId\tFrameId");;
            for (int j = 0; j < sb[2]/fs; j++) {
                 System.out.println(""+pageId2[j]+"\t"+frameId2[j]);
            }
             System.out.println("******************************************************************");
           System.out.println("Page Table For Process"+3);
            System.out.println("PageId\tFrameId");
            for (int j = 0; j < sb[3]/fs; j++) {
                 System.out.println(""+pageId3[j]+"\t"+frameId3[j]);
            }
            System.out.println("******************************************************************");
          System.out.println("Page Table For Process"+4);
            System.out.println("PageId\tFrameId");
            for (int j = 0; j < sb[4]/fs; j++) {
                 System.out.println(""+pageId4[j]+"\t"+frameId4[j]);
            }
            
            //map memory
            int framesMe[] = new int[pm/fs];
            boolean free[] = new boolean [pm/fs];
           int inside[]= new int[pm/fs];
           int fromB[]=new int[pm/fs];
           int toB []= new int[pm/fs];
          
            for (int i = 0; i < pm/fs; i++)
            {
            framesMe[i]=i;
            free[i]=true;
             }
            
            fromB[0]=0;
            toB[0]=fs-1;
            for (int i = 1; i < pm/fs; i++) {
            fromB[i]=toB[i-1]+1;
            toB[i]=toB[i-1]+fs;
        }
            
            
            
             for (int i = 0; i < 5; i++)
             {
                   if(sb[i]<= pm)
                   {
                     if(i==0)
                     {
                         for (int j = 0; j < sb[0]/fs; j++) {
                             if(free[frameId0[j]])
                             {  
                              inside[frameId0[j]]=pageId0[j];
                              free[frameId0[j]]=false;
                             }
                         }
                     }
                     else if (i==1)
                     {
                      for (int j = 0; j < sb[1]/fs; j++) {
                             if(free[frameId1[j]])
                             {  
                              inside[frameId1[j]]=pageId1[j];
                              free[frameId1[j]]=false;
                             }
                         }
                     }
                     else if (i==2)
                     {
                      for (int j = 0; j < sb[2]/fs; j++) {
                             if(free[frameId2[j]])
                             {  
                              inside[frameId2[j]]=pageId2[j];
                              free[frameId2[j]]=false;
                             }
                         }
                     
                     }
                     else if (i==3)
                     {
                      for (int j = 0; j < sb[3]/fs; j++) {
                             if(free[frameId3[j]])
                             {  
                              inside[frameId3[j]]=pageId3[j];
                              free[frameId3[j]]=false;
                             }
                         }
                     
                     
                     }
                     else if (i==4)
                     {
                        for (int j = 0; j < sb[4]/fs; j++) {
                             if(free[frameId4[j]])
                             {  
                              inside[frameId4[j]]=pageId4[j];
                              free[frameId4[j]]=false;
                             }
                         }
                       
                     
                     
                     }
                   
                   } 
                       
                 }
            
             System.out.println("\n******************************************************************\nB)Mapping Physical Memory(Paging)");
            
               System.out.println("Beginning \t PageId \t Finish \t FrameNo \t FreeOrNot");
            for (int i = 0; i < pm/fs; i++) {
            System.out.println("  "+fromB[i]+"\t\t"+inside[i]+"\t\t"+toB[i]+"\t\t"+framesMe[i]+"\t\t"+free[i] );
            
            }    
             System.out.println("\n******************************************************************\nc)");
              Scanner scn =new Scanner(System.in);
              int logicalAddress;
              int physicalAdd;
              int p=0,f=0,d=0;
              System.out.println("Please enter any logical address : ");
              logicalAddress = scn.nextInt();
              physicalAdd= logicalAddress+fs;
              for (int i = 0; i < pm/fs; i++) {
              if( physicalAdd <= toB[i] && physicalAdd >= fromB[i])
                  {
                      f=framesMe[i];
                      p=inside[i];
                  }
              d=logicalAddress%fs;
              
            }
               System.out.println(" "+ logicalAddress+" -> {p,d}={"+ p +","+ d +"} -> {f,d}={"+f+","+d+"} -> "+physicalAdd);
        } 
}
        
        
        
        
        
        
        
        
        
        
        
  
    
    
    

