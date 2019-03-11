import java.util.Random;
public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   Random rand = new Random();
   int start = Math.abs(rand.nextInt() % data.length);
   int temp = data[0];
   data[0] = data[start];
   data[start] = temp;
   for(int i = 0; i < data.length;i++){
     if(k < start){
       return 1;
     }
   }
   return 1;
 }
}
