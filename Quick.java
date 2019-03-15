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
   int rand= data.length / 2;
   int num = data[rand]; //switching the random position to the index 0
   data[rand] = data[start];
   data[start] = num;
   rand = start;
   start++;
   /*int small = start + 1; //starting from index 1
   int big = end; //last index to read
   int index = small;
   while(index <= big){
     if(data[index]==data[start]){
       int place = randgen.nextInt() %2;
       if(place ==0){
         int temp1 = data[index];
         data[index] = data[big];
         data[big] = temp1;
         big--;
       }
       else{
         small++;
       }
     }
     else if(data[index] > data[start]){
       int temp1 = data[big];
       data[big] = data[index];
       data[index] = temp;
       big--;
     }
     else{
       small++;
     }
   }
   for(int x = start; x< end + 1; x++){
     if(data[x] > data[num]){
       fstart = data[x-1];
       data[x-1] = data[num];
       data[num] = fstart;
       return x -1;
     }
   }
   int temp1 = data[big];
   data[big] = data[start];
   data[start] = temp;
   return big;*/
   while(start != end){
     int r = randgen.nextInt() % 2;
     if(data[start] > num || data[start] == num && r ==0){
       int temp = data[start];
       data[start] = data[end];
       data[end] = temp;
       end--;
     }
     else{
       start++;
     }
   }
   if(data[start] < num){
     data[rand] = data[start];
     data[start] = num;
     rand = start;
   }
   else{
     data[rand] = data[start - 1];
     data[start -1] = num;
     rand = start -1;
   }
   return rand;
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
     }
   }
   return data[x];
 }
 public static void quicksort(int[] data){
   sortH(data, 0, data.length -1);
 }
 public static void sortH(int[] data, int small, int big){
   if(small < big){
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
