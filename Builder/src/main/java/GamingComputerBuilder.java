public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer = new Computer();

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel i9");
    }

    @Override
    public void buildRam() {
        computer.setRamSize(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 4080");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}