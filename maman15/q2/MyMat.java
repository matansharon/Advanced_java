import java.util.*;
/**
 * Write a description of class MyMat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyMat
{
    protected int [][]_mat;
    private int _col,_row;
    
    public MyMat(int x,int y)
    {
        Random rand=new Random();
        _row=x;_col=y;
        _mat=new int[_row][_col];
        for(int i=0;i<_row;i++)
        {
            for(int j=0;j<_col;j++)_mat[i][j]=rand.nextInt(10);
        }
    }
    public int getRow()
    {
        return _row;
    }
    public int getCol()
    {
        return _col;
    }
    public void print()
    {
        for(int i=0;i<_row;i++)
        {
            for(int j=0;j<_col;j++)
            {
                System.out.printf("%d ",_mat[i][j]);
            }
            System.out.println();
        }
    }
}
