package ArrayCPTwoD;


/* LeetCode 885. Spiral Matrix III */
public class SpiralMatrixIII {

     /* Printing method */
     static void printArr(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] getSpiralMatrix(int rows ,int cols ,int rStart ,int cStart){

        int element=2;
        int arr[][] = new int[(rows*cols)][2];
        int topRow = rStart, bottomRow = topRow+1, leftCol = cStart, rightCol = leftCol+1;
        int k=0;
        arr[k][0]=rStart;
        arr[k][1]=cStart;
        k++;
        while (element<=rows*cols){
            
            for (int i = leftCol+1; i <= rightCol && element<= rows*cols; i++) {
                if(topRow>=rows || i>=cols || i<0 || topRow<0){
                    continue;
                }
                arr[k][0]=topRow;
                arr[k][1]=i;
                  k++;
                 element++;
             }
             leftCol--;

             for (int i = topRow+1; i <= bottomRow && element<= rows*cols; i++) {
                if(i>=rows || rightCol>=cols || i<0 || rightCol<0){
                    continue;
                }                
                arr[k][0]=i;
                arr[k][1]=rightCol;
                   k++;
                element++;
              }
             topRow--; 

             for (int i = rightCol-1; i >= leftCol && element<= rows*cols; i--) {
                if(i>=cols || bottomRow>=rows || i<0 || bottomRow<0){
                    continue;
                } 
                 arr[k][0]=bottomRow;
                 arr[k][1]=i;
                 k++;
               element++;
             }
             rightCol++;
             for (int i = bottomRow-1; i >= topRow && element<=rows*cols; i--) {
                 if(i>=rows || leftCol>=cols || i<0 || leftCol<0 ){
                    continue;
                 }
                 arr[k][0]=i;
                 arr[k][1]=leftCol;
                 k++;
                  element++;
              }
            bottomRow++;
        }
        return arr;
    }
    public static void main(String[] args) {
    
        int rows = 1, cols = 4, rStart = 0, cStart = 0;
        int arr[][] = getSpiralMatrix(rows , cols , rStart , cStart );
        printArr(arr);

    }
}
