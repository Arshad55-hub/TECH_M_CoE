class StockUnavailableException extends Exception {
    public StockUnavailableException(String msg) { super(msg); }
}

class InvalidStorageException extends Exception {
    public InvalidStorageException(String msg) { super(msg); }
}