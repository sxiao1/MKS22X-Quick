import java.util.*;
import java.io.*;
public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int partition(int[] data, int start,int end){
   if(end == start){
     return start;
   }
   Random randgen = new Random();
   //int fstart = data[start];
   int rand= start + randgen.nextInt((end - start) + 1);
   int num = data[rand]; //switching the random position to the index 0
   switchPos(data, start, rand);
   start= start + 1;
   int ind = start;
   while(ind != end){
     //int r = randgen.nextInt() % 2;
     if(data[ind] > data[start] ){
       switchPos(data, ind, end);
       end--;
     }
   else if(data[ind] < data[start]){
    switchPos(data, ind, start);
    start ++;
    ind ++;
   }
   else{
     ind ++;
   }
 }
 switchPos(data, ind, end);
   return rand;
 }
 public static void switchPos(int[] data, int num1, int num2){
   int temp = num1;
   data[num1] = data[num2];
   data[num2] = temp;
 }
 public static int quickselect(int []data, int k){
   int small = 0;
   int big = data.length - 1;
   int x = partition(data, small, big);
   while(x != k){
     if(x < k){
       small = x + 1;
       x = partition(data, small, big);
     }
     else{
       big = x - 1;
       x = partition(data, small, big);
     }
   }
   return data[x];
 }
 public static void quicksort(int[] data){
   sortH(data, 0, data.length -1);
 }
 public static void sortH(int[] data, int small, int big){
   if(big - small <= 20){
     int ind = small + 1;
     while(ind <= big){
       int counter = ind;
       while(counter > small && data[ind] < data[counter -1]){
         counter--;
       }
       int n = data[ind];
       for(int i = ind ; i>counter; i--){
         data[i] = data[i-1];
       }
       data[counter] = n;
         }
         return;
   }
   else{
   if(small < big){
     int half = partition(data, small, big);
     sortH(data, small, half-1);
     sortH(data, half +1, big);
   }
 }
 }
 public static String toString(int[] array){
   String newstr="";
   for (int i=0;i<array.length;i++){
    newstr+=array[i]+ ",";
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
