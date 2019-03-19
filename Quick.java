import java.util.*;
import java.io.*;
public class Quick{
  public static int partition ( int [] data, int start, int end){
	   Random randgen = new Random();
	   int random = start + randgen.nextInt((end - start) + 1); //finding random int in the range between the start and the end
	   switchPos(data,start,random);
	   int lo=start+1; //skipping index 0
	   int high=end;//last index
	   int index=lo;
	   while (index <= high){
      if(data[index] < data[start]){ //when it is smaller than the pivot, then the number will switch positions with the start and be on the left of the array
        switchPos(data,index,lo);
        lo++;
        index++;
      }
	    else if(data[index]>data[start]){ //when it is bigger than the pivot, then the number will be switched with a number from the right
		     switchPos(data,index,high);
		     high--;
	    }
	    else{
        if(data[index] == data[start]){ // if it equals then the index just increase
          index++;
        }
	    }
	}
	   switchPos(data,start,high); //move back the original number to the spot it belongs to in the array
	   return high;
	}

  public static void switchPos(int[] data, int num1, int num2){
	    int temp = data[num2]; //storing a temp value to store and switch indexes
	    data[num2]=data[num1];
	    data[num1]=temp;
  }

  public static int quickselect(int[]data, int k){
	   int lo=0;
	   int high= data.length-1;
	   int x= partition(data,lo,high);
     while (x !=k){
	    if (x < k){ // if it is smaller, then add it to the left side and the lo range increases by one and recurse through the rest of the array
        lo = x + 1;
		    x = partition(data,lo,high);
	    }
	    else{
		    high = x - 1; //if it is larger, then the range of the high increases and then the whole thing recurses again
		    x = partition(data,lo,high);
	    }
	   }
	   return data[x];
  }
  public static void quicksort(int[] data){
	   quickH(data,0,data.length-1); //calling the helper function
  }
  public static void quickH(int[] data,int lo,int high){
    if (high-lo <=20){ //base case
      insertionSort(data,lo,high);
      return;
    }
    if(lo < high){ //if the high and low still don't meet then you continue to recurse through the helper function by splitting up the function in half with a pivot
      int pivot = partition(data, lo, high);
      quickH(data, lo, pivot - 1);
      quickH(data, pivot + 1, high);
    }
  }
  public static void insertionSort(int[] data,int lo,int high){
	   int index = lo + 1;
	    while(index <= high){
	       int counter=index;
	        while(counter > lo && data[index]<data[counter-1]){ //counter decreases and shifts the numbers over by a certain amount
		          counter--;
	        }
          shifting(data, index, counter);
          index++;
	    }
  }
  public static void	shifting(int[] data, int oldNum,int newNum){
	   int temp=data[oldNum];
	    for (int i=oldNum;i>newNum;i--){ //shifting the numbers in the array over one spot to the right
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
