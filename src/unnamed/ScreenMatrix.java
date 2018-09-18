package unnamed;

public class ScreenMatrix{

    private int sizeX, sizeY;
    private char[][] matrix;

    public ScreenMatrix(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        matrix = new char[sizeX][sizeY];

    }

    public void set(int x, int y, char c){
        matrix[x][y] = c;
    }

    public char getCharAt(int x, int y){
        return matrix[x][y];
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY(){
        return sizeY;
    }

    public void print(){
        for(char[] array : matrix) {
            for (char c : array) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void debugGenerateMatrix(){
        int n;
        char c;
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                n = (int) (Math.random() * 92) + 32;
                c = (char) n;
                matrix[i][j] = c;
            }
        }
    }
}
