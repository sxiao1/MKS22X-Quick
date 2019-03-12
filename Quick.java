import java.util.Random;
public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   return 1;
 }
 public static int qsh(int[] data, int k, int indexb, int indexe){
   if(indexb == k || indexe == k){
     return data[k];
   }
   else{
     int middle = data[data.length / 2];
     int lo = data[0];
     int hi = data[data.length - 1];
     if((middle > lo && middle < hi) || (middle < lo && middle > hi)){
       int temp = data[0];
       data[0] = middle;
       data[data.length / 2] = temp;
       lo = data[0];
     }
     for(int i = 0; i < data.length;i++){
         if(data[i] <= data[0]){
           int temp2 = data[indexb];
           data[indexb] = data[i];
           data[i] = temp2;
           qsh(data, k, indexb + 1, indexe);
         }
         else{
           if(data[i] >= data[0]){
             int temp1 = data[indexe];
             data[indexe] = data[i];
             data[i] = temp1;
             qsh(data,k, indexb, indexe + 1);
           }
         }
       }
       return 1;
     }
   }
 }
