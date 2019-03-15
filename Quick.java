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
   return 1;
 }
 public static int qsh(int[] data, int k, int indexlo, int indexhi){
   int index = 0;
   if(indexlo == indexhi){
     for(int i = 0; i < data.length; i++){
       if(data[i+1] <= data[i]){
         int temp = data[i+1];
         data[i+1] = data[i];
         data[i] = temp;
         index ++;
       }
     }
   }
   if(index == k){
     return data[index];
   }
   else{
     int middle = data[data.length / 2];
     int lo = data[0];
     int hi = data[data.length - 1];
     if((middle > lo && middle < hi) || (middle < lo && middle > hi)){
       int temp = data[0];
       data[0] = middle;
       data[data.length / 2] = temp;
     }
     if((hi > lo && hi < middle) || (hi < lo && hi > middle)){
       int temp = data[0];
       data[0] = hi;
       data[data.length -1] = temp;
     }
     return 1;
     }
   }
 }
