package Positions;

public class MapGraphics {

    private int x, y;
    private int [][] matrix;
    private int [] positions = new int[4];


    public MapGraphics(int[] dimensions){
        this.positions = dimensions;
    }

    public void setAverages(){
        x = (positions[0] + positions[1]) / 2;
        y = (positions[2] + positions[3]) / 2;
    }

    public void printDimensions(){
        System.out.println("X-dimensions: " + x);
        System.out.println("Y-dimensions: " + y);
    }

    public void createMatrix(){
        matrix = new int [x][y];
    }

    public void paintMatrix(){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                System.out.print(" CELL ");
            }
        }
    }



}
