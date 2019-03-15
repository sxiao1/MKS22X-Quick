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
 public static void quicksort(int[] data){
   sortH(data, 0, data.length -1);
 }
 public static void sortH(int[] data, int small, int big){
   if(big - small <= 20){
     int ind = small +1 ;
     while(ind <= big){
       int count = ind;
       while(count > small && data[ind] < data[count -1]){
         count --;
       }
       int temp = data[ind];
       for(int i = data[ind]; i > count; i--){
         data[i] = data[i-1];
       }
       data[count] = temp;
       ind ++;
     }
   }
   if(small <big){
     int half = partition(data, small, big);
     sortH(data, small, half-1);
     sortH(data, half +1, big);
   }
 }
 public static String toString(int[] array){
   String newstr="";
   for (int i=0;i<array.length;i++){
    newstr+=array[i]+ ",";
  }
  return newstr;
  }

 }
