import java.util.Arrays;
import java.util.Scanner;
public class life_game {

	public static void main(String[] args) {
		
		System.out.println("康威生命遊戲 Conway's Game of Life");
		System.out.println();
		System.out.println("俗話(？)說的好，No game no life，歡迎大家來到用生命下棋的世界(誤)");
		System.out.println("以下有個規則聽好了：");
		System.out.println("每個細胞在當前的狀況下，檢查以自己為中心的周邊共8個細胞，而這些細胞的數量將會決定你這個細胞在某世代的存亡...");
		System.out.println();
		System.out.println("以下幾點請注意：");
		System.out.println("1. 當周邊低於2個(不含2)存活細胞時，他將在下一個世代變成死亡狀態");
		System.out.println("2. 當周邊有2個或3個存活細胞時，他將在下一個世代保持不變");
		System.out.println("3. 當周邊有3個存活細胞時，他將在下一個世代變成存活狀態");
		System.out.println("4. 當周邊超過3個存活細胞時，他將在下一個世代變成死亡狀態");
		System.out.println();
		System.out.println("好了，了解這些規則之後，終於輪到你主宰生命的時刻了");
		System.out.println("請先輸入盤面的長與寬");
		System.out.println("再輸入你構想的盤面(令存活細胞為1，死亡細胞為0)，創造這個世界");
		System.out.println("接著請輸入你想要知道幾個世代的變化");
		System.out.println("最後請輸入你想要知道第哪個世代的變化");
		System.out.println("廢話不多說，我們開始吧！");
		System.out.println();
		System.out.println();
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("請輸入長：");
		int length = sc.nextInt();
		System.out.print("請輸入寬：");
		int width = sc.nextInt();
		
		System.out.println("請輸入盤面：");
		int [][] world = new int[length][width];
		
		for(int i=0; i<length; i++) {
			for(int j=0; j<width; j++) {
				System.out.print("您現在輸入的是第"+ (i+1) +"列第" + (j+1) +"行的生命=>");
				world[i][j] = sc.nextInt();
				
			}
		}
		
		System.out.println();
		System.out.println("您目前的世界如下：" );
		for(int i=0; i<length; i++) {
			for(int j=0; j<width; j++) {
				System.out.print(world[i][j]+" ");
			}
			System.out.println();	
			}
		System.out.println("------------------------------------");
		System.out.print("請輸入你想要知道幾個世代：");
		int num = sc.nextInt();
		
		for(int k=0; k<num; k++) {
			System.out.println();
			System.out.print("請輸入你想要知道第幾個世代：");
			int gen = sc.nextInt();
			
			int[][] new_world;
			new_world = new_world(world, length, width);
			
			for(int g=1; g<gen; g++) {
				new_world = new_world(new_world, length, width);
			}
			
			System.out.println("以下為您現在的世界：");
			print_new_world(new_world, length, width);
		}
		
		
	}
	public static int[][] new_world(int[][] world, int length, int width) {
		int[][] new_world = new int[length][width];
		
		//用雙層迴圈方式掃描棋盤每一個點
        for(int i=0; i<length; i++){
            for(int j=0; j<width; j++){
                //以一個算為中心，計算周圍八個點的生命數，用雙層迴圈方式掃描
                int count = 0;
                for(int x=-1; x<=1; x++){
                    for(int y=-1; y<=1; y++){
                       //將周圍八個點的生命數(1)加到count裡
                       //(i+x >= 0 && j+y >= 0) && (i+x < length && j+y < width) 為判斷點是否超出棋盤外
                       //!(x == 0 && y == 0) 為排除中心點
                        if((i+x >= 0 && j+y >= 0) && (i+x < length && j+y < width) && !(x == 0 && y == 0)){
                            count += world[i+x][j+y];
                        }
                       
                    }
                }
              //中心點下一次的狀態
                if(count == 2){ //加總為 2 時等於原樣
                    new_world[i][j] = world[i][j];
                }
                else if(count == 3){ //加總為 3 時生出新生命
                    new_world[i][j] = 1;
                }
                else{ //其它狀態生命死亡
                    new_world[i][j] = 0 ;
                }
            }
        }
      	return new_world;
	}

	
	public static void print_new_world(int[][] new_world, int length, int width) {
		for(int s=0; s<length; s++) {
			for(int r=0; r<width; r++) {
				System.out.print(new_world[s][r]+" ");
			}
			System.out.println();
		}
	}
}