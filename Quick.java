import java.util.*;
import java.io.*;
public class Quick{
  public static int partition ( int [] data, int start, int end){
	   Random randgen = new Random();
	   int random = start + randgen.nextInt((end - start) + 1);
	   switchPos(data,start,random);
	   int lo=start+1;
	   int high=end;
	   int index=lo;
	   while (index <= high){
      if(data[index] < data[start]){
        switchPos(data,index,lo);
        lo++;
        index++;
      }
	    else if(data[index]>data[start]){
		     switchPos(data,index,high);
		     high--;
	    }
	    else{
        if(data[index] == data[start]){
          index++;
        }
	    }
	}
	   switchPos(data,start,high);
	   return high;
	}

  public static void switchPos(int[] data, int num1, int num2){
	    int temp = data[num2];
	    data[num2]=data[num1];
	    data[num1]=temp;
  }

  public static int quickselect(int[]data, int k){
	   int lo=0;
	   int high= data.length-1;
	   int x= partition(data,lo,high);
     while (x !=k){
	    if (x < k){
        lo = x + 1;
		    x = partition(data,lo,high);
	    }
	    else{
		    high = x - 1;
		    x = partition(data,lo,high);
	    }
	   }
	   return data[x];
  }
  public static void quicksort(int[] data){
	   quickH(data,0,data.length-1);
  }
  public static void quickH(int[] data,int lo,int high){
    if (high-lo <=20){
      sorting(data,lo,high);
      return;
    }
    if(lo < high){
      int pivot = partition(data, lo, high);
      quickH(data, lo, pivot - 1);
      quickH(data, pivot + 1, high);
    }
  }
  public static void sorting(int[] data,int lo,int high){
	   int index = lo+1;
	    while(index <= high){
	       int counter=index;
	        while(counter > lo && data[index]<data[counter-1]){
		          counter--;
	        }
          shifting(data, index, counter);
          index++;
	    }
  }
  public static void	shifting(int[] data, int oldNum,int newNum){
	   int temp=data[oldNum];
	    for (int i=oldNum;i>newNum;i--){
	       data[i]=data[i-1];
	    }
	    data[newNum]=temp;
  }
  public static String toString(int[] data){
    String newstr="";
    for (int i=0;i<data.length;i++){
    newstr+=data[i]+ ",";
    }
      return newstr;
    }
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}

 }
