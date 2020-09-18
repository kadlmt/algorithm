package xiaohui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/17 13:01
 * @description：A*寻路算法
 * @modified By：
 * @version: 1.1
 */
public class AStarSearch {
    private static final int[][] MAZE = {
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 }
    };

    /**
     * @Author liumt
     * @Description 主逻辑
     * @Date 13:09 2020/9/17
     * @Param [起始方格, 终点方格]
     * @return xiaohui.AStarSearch.Grid
     **/
    public static Grid aSearch(Grid start, Grid end){
        //可到达的方格
        List<Grid> openList = new ArrayList<>();
        //已到达的方格
        List<Grid> closeList = new ArrayList<>();
        //把起点加入openList
        openList.add(start);
        //主循环,每一轮检查一个当前方格节点
        while(openList.size() > 0){
            //找出openList中f最小的方格,将其作为当方格
            Grid current = findMinGrid(openList);
            //将当前方格从openList中移除
            openList.remove(current);
            //将当前方格加入closeList
            closeList.add(current);
            //找到上下左右方格
        }
        return null;
    }

    public static List<Grid> findNeighbors(Grid current, List<Grid> openList,
                                           List<Grid> closeList){
        List<Grid> gridList = new ArrayList<>();
        return null;
    }

    /**
     * @Author liumt
     * @Description 找出f最小的方格
     * @Date 13:16 2020/9/17
     * @Param [openList]
     * @return xiaohui.AStarSearch.Grid
     **/
    public static Grid findMinGrid(List<Grid> openList){
        Grid temp = openList.get(0);
        for(Grid grid: openList){
            if(grid.f < temp.f){
                temp = grid;
            }
        }
        return temp;
    }

    class Grid{
        //x坐标
        public int x;
        //y坐标
        public int y;
        //g+h
        public int f;
        //从起点走到当前格子的成本
        public int g;
        //从当前格子走到终点的成本
        public int h;
        //来路,从哪个方格走来
        public Grid parent;
        public Grid(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
