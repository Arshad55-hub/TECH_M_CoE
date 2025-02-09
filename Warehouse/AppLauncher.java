import java.util.Arrays;

public class AppLauncher {
    public static void main(String[] args) {
        StockManager warehouse = new StockManager();

        
        warehouse.registerItem(new Merchandise("S101", "Keyboard", 6, new StorageSpot(2, 4, 1)));
        warehouse.registerItem(new Merchandise("P202", "Mouse", 3, new StorageSpot(3, 1, 2)));
        warehouse.registerItem(new Merchandise("M303", "Monitor", 4, new StorageSpot(1, 3, 3)));

        
        Shipment order1 = new Shipment("S001", Arrays.asList("A100", "B200"), Shipment.Urgency.REGULAR);
        Shipment order2 = new Shipment("S002", Arrays.asList("B200", "C300"), Shipment.Urgency.HIGH_PRIORITY);
        Shipment order3 = new Shipment("S003", Arrays.asList("A100"), Shipment.Urgency.REGULAR);

        
        warehouse.queueShipment(order1);
        warehouse.queueShipment(order2);
        warehouse.queueShipment(order3);

        
        warehouse.handleShipments();

        
        warehouse.showInventory();
    }
}