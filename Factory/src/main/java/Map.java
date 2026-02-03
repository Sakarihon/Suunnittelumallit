import java.util.Random;

public abstract class Map {
    protected int width=20;
    protected int height=20;
    protected Tile[][]tiles;
    protected Random random = new Random();


    public Map() {
        tiles = new Tile[width][height];
        generate();
    }

    protected abstract Tile createTile();


    protected void generate(){
        for(int x=0; x<width; x++ ){
            for(int y=0; y<height; y++ ){
                tiles[x][y]=createTile();
            }
        }
    }


    public void display(){
        for(int x=0; x<width; x++ ){
            for(int y=0; y<height; y++ ){
                System.out.print(tiles[x][y].getCharacter()+"");
            }
            System.out.println();
        }
    }
}
