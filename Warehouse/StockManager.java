import java.util.*;
import java.util.concurrent.*;

class StockManager {
    private Map<String, Merchandise> stockData = new ConcurrentHashMap<>();
    private PriorityQueue<Shipment> shipmentQueue = new PriorityQueue<>(Collections.reverseOrder());

    public void registerItem(Merchandise item) {
        stockData.put(item.getItemCode(), item);
    }

    public void queueShipment(Shipment shipment) {
        synchronized (shipmentQueue) {
            shipmentQueue.add(shipment);
        }
    }

    public void handleShipments() {
        ExecutorService workers = Executors.newFixedThreadPool(3);
        while (!shipmentQueue.isEmpty()) {
            Shipment shipment;
            synchronized (shipmentQueue) {
                shipment = shipmentQueue.poll();
            }
            if (shipment != null) {
                workers.execute(() -> processShipment(shipment));
            }
        }
        workers.shutdown();
    }

    private void processShipment(Shipment shipment) {
        System.out.println("Handling " + shipment);
        for (String productID : shipment.getProductList()) {
            Merchandise item = stockData.get(productID);
            if (item != null) {
                try {
                    item.decrementStock(1);
                    System.out.println("OUT OF DELIVERY " + item.getTitle() + " for Shipment " + shipment.getShipmentID());
                } catch (StockUnavailableException e) {
                    System.err.println("Shipment " + shipment.getShipmentID() + " issue: " + e.getMessage());
                }
            } else {
                System.err.println("Shipment " + shipment.getShipmentID() + " issue: Item " + productID + " not found.");
            }
        }
    }

    public void showInventory() {
        System.out.println("Updated Stock Levels:");
        stockData.values().forEach(System.out::println);
    }
}