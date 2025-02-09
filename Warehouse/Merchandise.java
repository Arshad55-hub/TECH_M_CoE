class Merchandise {
    private String itemCode, title;
    private int stockLevel;
    private StorageSpot storageSpot;

    public Merchandise(String itemCode, String title, int stockLevel, StorageSpot storageSpot) {
        this.itemCode = itemCode;
        this.title = title;
        this.stockLevel = stockLevel;
        this.storageSpot = storageSpot;
    }

    public String getItemCode() { return itemCode; }
    public String getTitle() { return title; }
    public int getStockLevel() { return stockLevel; }
    public StorageSpot getStorageSpot() { return storageSpot; }

    public void decrementStock(int qty) throws StockUnavailableException {
        if (qty > stockLevel) {
            throw new StockUnavailableException("Not a proper Title FOr " + title);
        }
        stockLevel -= qty;
    }

    @Override
    public String toString() {
        return title + " (ID: " + itemCode + ", Stock: " + stockLevel + ", Location: " + storageSpot + ")";
    }
}