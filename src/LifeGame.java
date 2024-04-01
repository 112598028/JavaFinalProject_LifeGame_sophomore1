import java.util.*;
 
public class LifeGame {
  public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  back :
    while (sc.hasNext()){
      String in =sc.nextLine();
      if (in.equals("0 0")) {
        break;
      }
      else{
        int row = in.charAt(0) - '0';
        int col = in.charAt(2) - '0';
        int[][] arr = new int[row][col];
        List<String> list = new ArrayList<String>();
          for (int j = 0; j < row; j ++){
              list.add(sc.nextLine());
          }
          for (int i = 0; i < row; i ++){
              for (int k = 0; k < col; k ++){
                arr[i][k] = list.get(i).charAt(k) - '0';
              }
          }
          for (int m = 0; m < row; m ++){
              for (int n = 0; n < col; n ++){
                System.out.print(arr[m][n] + " ");
              }
              System.out.println();
          }
          continue back;
      }
    }
  sc.close();
  }
}


