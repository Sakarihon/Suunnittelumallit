public class GenerateCodeCommand implements Command {

    private final boolean[][] pixels;

    public GenerateCodeCommand(boolean[][] pixels) {
        this.pixels = pixels;
    }

    @Override
    public void execute() {

        System.out.println("int[][] pixelArt = {");

        for (int row = 0; row < pixels.length; row++) {

            System.out.print("    {");

            for (int col = 0; col < pixels[row].length; col++) {

                int value = pixels[row][col] ? 1 : 0;

                System.out.print(value);

                if (col < pixels[row].length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.print("}");

            if (row < pixels.length - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }

        System.out.println("};");
    }
}