import java.util.List;

class Shipment implements Comparable<Shipment> {
    enum Urgency { REGULAR, HIGH_PRIORITY }

    private String shipmentID;
    private List<String> productList;
    private Urgency urgency;

    public Shipment(String shipmentID, List<String> productList, Urgency urgency) {
        this.shipmentID = shipmentID;
        this.productList = productList;
        this.urgency = urgency;
    }

    public String getShipmentID() { return shipmentID; }
    public List<String> getProductList() { return productList; }
    public Urgency getUrgency() { return urgency; }

    @Override
    public int compareTo(Shipment other) {
        return this.urgency.compareTo(other.urgency);
    }

    @Override
    public String toString() {
        return "Shipment " + shipmentID + " (Priority: " + urgency + ")";
    }
}