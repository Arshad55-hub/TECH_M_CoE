class StorageSpot {
    private int row, rack, compartment;

    public StorageSpot(int row, int rack, int compartment) {
        this.row = row;
        this.rack = rack;
        this.compartment = compartment;
    }

    @Override
    public String toString() {
        return "Row " + row + ", Rack " + rack + ", Compartment " + compartment;
    }
}