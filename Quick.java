import java.util.Random;
public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   return 1;
 }
 public static int qsh(int[] data, int k, int indexlo, int indexhi){
   if(indexlo == indexhi){
     for(int i = 0; i < data.length; i++){
       if(data[i+1] <= data[i]){
         int temp = data[i+1];
         data[i+1] = data[i];
         data[i] = temp;
       }
     }
     return data[indexlo];
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
