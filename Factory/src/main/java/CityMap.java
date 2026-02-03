
public class CityMap extends Map {


    public CityMap(){
            super();
    }

    @Override
    protected Tile createTile(){
        int r = random.nextInt(3);

        switch (r){
            case 0:
                return new RoadTile();

            case 1:
                return new ForestTile();

            default:
                return new BuildingTile();
        }
    }

}
