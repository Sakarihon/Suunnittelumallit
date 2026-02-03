public abstract class Tile{

    public abstract char getCharacter();
    public abstract String getType();
    public abstract void action();
}

class RoadTile extends Tile {
    @Override
    public char getCharacter() { return 'R'; }
    @Override
    public String getType() { return "road"; }
    @Override
    public void action() { }
}

class ForestTile extends Tile {
    @Override
    public char getCharacter() { return 'F'; }
    @Override
    public String getType() { return "forest"; }
    @Override
    public void action() { }
}

class BuildingTile extends Tile {
    @Override
    public char getCharacter() { return 'B'; }
    @Override
    public String getType() { return "building"; }
    @Override
    public void action() { }
}

class SwampTile extends Tile {
    @Override
    public char getCharacter() { return 'S'; }
    @Override
    public String getType() { return "swamp"; }
    @Override
    public void action() { }
}

class WaterTile extends Tile {
    @Override
    public char getCharacter() { return 'W'; }
    @Override
    public String getType() { return "water"; }
    @Override
    public void action() { }
}
