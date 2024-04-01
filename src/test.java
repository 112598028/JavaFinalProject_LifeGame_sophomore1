import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("�п�J���G");
		int length = sc.nextInt();
		System.out.print("�п�J�e�G");
		int width = sc.nextInt();
		
		System.out.println("�п�J�L���G");
		int [][] world = new int[length][width];
		
		for(int i=0; i<length; i++) {
			for(int j=0; j<width; j++) {
				System.out.print("�z�{�b��J���O��"+ (i+1) +"�C��" + (j+1) +"�檺�ͩR=>");
				world[i][j] = sc.nextInt();
				
			}
		}
		
		System.out.println();
		System.out.println("�z�ثe���@�ɦp�U�G" );
		for(int i=0; i<length; i++) {
			for(int j=0; j<width; j++) {
				System.out.print(world[i][j]+" ");
			}
			System.out.println();	
			}
		
		System.out.println("�п�J�A�Q�n���D�X�ӥ@�N�G");
		int num = sc.nextInt();
		
		for(int k=0; k<num; k++) {
			System.out.println();
			System.out.print("�п�J�A�Q�n���D�ĴX�ӥ@�N�G");
			int gen = sc.nextInt();
			
			int[][] new_world;
			new_world = new_world(world, length, width);
			
			for(int g=1; g<gen; g++) {
				new_world = new_world(new_world, length, width);
			}
			
			System.out.println("�H�U���z�{�b���@�ɡG");
			print_new_world(new_world, length, width);
		}
		
		
	}
	public static int[][] new_world(int[][] world, int length, int width) {
		int[][] new_world = new int[length][width];
		
		//�����h�j��覡���y�ѽL�C�@���I
        for(int i=0; i<length; i++){
            for(int j=0; j<width; j++){
                //�H�@�Ӻ⬰���ߡA�p��P��K���I���ͩR�ơA�����h�j��覡���y
                int count = 0;
                for(int x=-1; x<=1; x++){
                    for(int y=-1; y<=1; y++){
                       //�N�P��K���I��=�ͩR�ƥ[��p�ƪ��ܼƸ�
                       //(i+x >= 0 && j+y >= 0) && (i+x < length && j+y < width) ���P�_�I�O�_�W�X�ѽL�~
                       //!(x == 0 && y == 0) ���ư������I
                        if((i+x >= 0 && j+y >= 0) && (i+x < length && j+y < width) && !(x == 0 && y == 0)){
                            count += world[i+x][j+y];
                        }
                       
                    }
                }
              //�����I�U�@�������A
                if(count == 2){ //�[�`�� 2 �ɵ�����
                    new_world[i][j] = world[i][j];
                }
                else if(count == 3){ //�[�`�� 3 �ɥͥX�s�ͩR
                    new_world[i][j] = 1;
                }
                else{ //�䥦���A�ͩR���`
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
