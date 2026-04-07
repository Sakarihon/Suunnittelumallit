public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer = new Computer();

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel i5");
    }

    @Override
    public void buildRam() {
        computer.setRamSize(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("512GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Graphics");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 10");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}