package scu.edu.cn.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 机器人运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、
 * 右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够
 * 进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * @author: zzy
 * @create: 2021-03-25 20:08
 **/
public class RobotMotionRange {
    public static void main(String[] args) {
        System.out.println(movingCount(3, 1, 0));
    }

    public static int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        if (k == 0){
            return 1;
        }
        visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int ans = 1;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int column = cur[1];
            //向左
            if (column+1<n && visited[row][column+1] == 0 && get(row)+get(column+1) <=k){
                visited[row][column+1] = 1;
                queue.offer(new int[]{row,column+1});
                ans += 1;
            }
            //向下
            if (row+1 < m && visited[row+1][column] == 0 && get(row+1)+get(column) <= k){
                visited[row+1][column] = 1;
                queue.offer(new int[]{row+1,column});
                ans += 1;
            }
        }
        return ans;
    }

    private static int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
