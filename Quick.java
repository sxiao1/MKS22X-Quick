import java.util.*;
import java.io.*;
public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int partition(int[] data, int start,int end){
   Random randgen = new Random();
   int num = start + randgen.nextInt(end - start + 1); //returns a random number in the range
   int temp = data[num]; //switching the random position to the index 0
   data[num] = data[start];
   data[start] = temp;
   int small = start + 1; //starting from index 1
   int big = end; //last index to read
   int index = small;
   while(index <= big){
     if(data[index] < data[start]){
       int temp1 = data[small];
       data[small] = data[index];
       data[index] = temp;
       small++;
       index++;
     }
     else if(data[index] > data[start]){
       int temp1 = data[big];
       data[big] = data[index];
       data[index] = temp;
       big--;
     }
     else{
       index++;
     }
   }
   int temp1 = data[big];
   data[big] = data[start];
   data[start] = temp;
   return big;
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

 }
