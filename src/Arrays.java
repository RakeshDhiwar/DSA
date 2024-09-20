public class Arrays {

    //Spiral Matrix
    static void Spiral(int mat[][]) {
        int SR = 0;
        int ER = mat.length - 1;
        int SC = 0;
        int EC = mat[0].length - 1;

        while(SR<=ER && SC<=EC){
            //top
            for (int j = SC; j <= EC; j++) {
                System.out.println(mat[SR][j]+"");
            }
            
            //right
            for (int i = SR+1; i <= ER; i++) {
                System.out.println(mat[i][EC]+"");
            }
            
            //bottom
            for (int j = EC-1; j >= SC ; j--) {
                if (SR == ER) break;
                System.out.println(mat[ER][j]+"");
            }

            //left
            for (int i = ER-1; i >= SR+1 ; i--) {
                if (SC == EC) break;
                System.out.println(mat[i][SC]+"");
            }
            SR++; SC++; ER--; EC--;
        }
    }


    //Diagonal Sum
    static void DiagonalSum(int mat[][]) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i==j) sum += mat[i][j];
            }
        }
        int row = 0;
        int col = mat[0].length-1;
        while(row <= mat.length-1) {
            if (row == col) {
                row++;
                col--;
                continue;
            }
            sum += mat[row][col];
            row++;
            col--;
        }
        System.out.println(sum);
    }
    static void DiagonalSum1(int mat[][]) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i==j) sum += mat[i][j];
                else if (i + j == mat.length-1) {
                    if (i == j) continue;
                    sum += mat[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    static void DiagonalSum2(int mat[][]) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];

            if (i != (mat.length - 1 - i) ){
                sum += mat[i][mat.length - 1 - i];
            }
        }
        System.out.println(sum);
    }

    //Search In Sorted Matrix ( row and col wise both )
        //  Brute force - n^2
        //  row wise Binary - NLog
        //  Staircase Search -

        // Staircase Search
        public static void StaircaseSearch(int mat[][],int key){

             int row  = 0; int col = mat[0].length-1;



            while (row < mat.length && col >=0) {
                if (mat[row][col] == key) {
                    System.out.println("Key found at"+"("+row+","+col+")");
                    return;
                } else if (mat[row][col] > key) {
                    //move left
                    col--;
                } else {
                    //move right
                    row++;
                }
            }
            System.out.println("Key not found!");
        }


    public static void main(String[] args) {
        int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] > max) {
                    max = mat[i][j];
                }
                if (mat[i][j] < min) {
                    min = mat[i][j];
                }
            }
        }
//        System.out.println(max);
//        System.out.println(min);

        int mat1[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        Spiral(mat1);
//        DiagonalSum2(mat1);
        StaircaseSearch(mat1,14);
    }
}
