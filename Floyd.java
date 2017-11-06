import java.util.Scanner;

public class Floyd {



	static int[][] P;
	static int[][] Z;
//----------------------------FLOYD'S ALGORITHM-----------------------------------------

	public static int[][] FloydAlgo(int[][] M, int N) {
		
		int counter = 1; //for labeling purposes {D1, D2, D3 ...}
		int paths = 1;
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// to keep track.;
					if (M[i][k] + M[k][j] < M[i][j]) { 
						
						M[i][j] = M[i][k] + M[k][j];
						P[i][j] = k+1;

					}
					
					// or not to keep track.
					//M[i][j] = min(M[i][j], M[i][k] + M[k][j]);
				}
				
			}
			System.out.println("Matrix D" + counter++);
			printMatrix(M, N);
			System.out.println("Paths: D" + paths++);
			printMatrix(P, N);
		}
		System.out.println("SHORTEST PATH:");
		return M;
	}

	public static int min(int i, int j) {
		if (i > j) {
			return j;
		}
		return i;
	}
    //-------------------------PRINT MATRIX-------------------------------------------
	public static void printMatrix(int[][] Matrix, int N) {
		
		String infinity;
		
		System.out.print("\n\t");
		for (int j = 1; j <= N; j++) {
			System.out.print(j + "\t");
		}
		System.out.println();
		for (int j = 0; j < 9*N+5; j++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(i+1 + " |\t");
			for (int j = 0; j < N; j++) {
				if(Matrix[i][j] == 999){
					infinity = "-";
					System.out.print(infinity);
					System.out.print("\t");
				}else{
					System.out.print(Matrix[i][j]);
					System.out.print("\t");
				}
				
			}
			System.out.println("\n");
		}
		System.out.println("\n");
	}
	//----------------------------FILL MATRIX-----------------------------------------
	public static int[][] fillMatrix(int N, int[][] P){ 
        
        int[][] data = P; 
        int counter = 1;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the elements for the Matrix ROW by ROW"); 
        for(int row = 0; row< N; row++){ 
              
              System.out.println("ROW " + counter + ": "); 
              counter++;
              for(int col = 0 ;col< N; col++){ 
                   //System.out.println("Enter the elements for the Matrix ROW by ROW"); 
                  data[row][col] = in.nextInt(); 
                  if(data[row][col]== -1){
                  	data[row][col] = 999;
                  }
               }
                System.out.println(); 
         
        } 

         return data; 
	}

	
	//----------------------------MAIN------------------------------------------------
	public static void main(String[] args) {
		
		System.out.println("Please enter N: "); //ask user for number of values to build array
        Scanner scan = new Scanner( System.in );
  	    int N = Integer.parseInt(scan.nextLine()); 
  	    //System.out.println(N);
  	    
		
		//int[][] M = { { 0, 1, 999, 1, 5 }, { 9, 0, 3, 2, 999 }, { 999, 999, 0, 4, 999 },
				//{ 999, 999, 2, 0, 3 }, { 3, 999, 999, 999, 0 } };
		
		P = new int[N][N]; //used to keep track of the paths 
		Z = new int[N][N]; //used to fill the matrix 
		
		int[][] M = fillMatrix(N, Z);
		System.out.println("Matrix to find the shortest path of.");
		printMatrix(M, N);
		System.out.println("Shortest Path Matrix:");
		printMatrix(FloydAlgo(M, N), N);
		System.out.println("PATH MATRIX");
		printMatrix(P, N);
	}


}