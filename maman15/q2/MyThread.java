
/**
 * MyThread class is the class that responsable for the calcultion of every vector
 * in the matrix
 * 
 * @author Matan Sharon
 * @version 12.5.20
 */
public class MyThread extends Thread
{
    private int[]_a,_b;//the 2 vectors
    private int [][]_MatRes;//pointer to the result matrix
    private int _x,_y;//the loction at the result matrix
    private int _res;//the sum of the vectors
    MyMultiMat _m;//pointer to the original matrix
    /**
     * MyThread Constructor create a thread from the otiginal matrix
     *
     * @param a the first vector
     * @param b the second vector
     * @param x the row loction at the result matrix
     * @param y the coloum loction at the result matrix
     * @param resMat pointer to the result matrix
     * @param m ponter to the original matrix
     */
    public MyThread(int []a,int []b,int x,int y,int [][]resMat,MyMultiMat m)
    {
        _a=a;_b=b;
        _x=x;_y=y;
        _MatRes=resMat;
        _m=m;
        
    }

    /**
     * Method run claculate the vectors multipltion
     *
     */
    public synchronized void run()
    {
        
        for(int i=0;i<_a.length;i++)
        {
            this._res+=_a[i]+_b[i];

        }
        _MatRes[_x][_y]=this._res;
        //System.out.println(this.getName()+" wrote "+_res+" to "+_x+" "+_y);
        
        
        
        
    }

    public int getRes(){return this._res;}
}
