/**考察内容：
 * 二维数组[二维数组赋值、二维数组遍历]
 * 动态规划[变化公式]
 * */
public class b_最小路径和 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid){
        int row = grid.length; int col = grid[0].length;
        int[][] dp = new int[row][col];
        //grid[0][0]
        dp[0][0] = grid[0][0];
        //第一行
        for(int i=1; i<col; i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        //第一列
        for(int i=1; i<row; i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
