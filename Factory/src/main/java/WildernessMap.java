
public class WildernessMap extends Map {

            public WildernessMap(){
            super();
        }

        @Override
        protected Tile createTile(){
            int r = random.nextInt(3);

            switch (r){
                case 0:
                    return new SwampTile();

                case 1:
                    return new ForestTile();

                default:
                    return new WaterTile();
            }
        }

    }

