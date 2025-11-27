package Lab2;

class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max(quantity, 0);
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = Math.max(pricePerItem, 0.0);
    }

    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }
}

public class lab21 {
    public static void main(String[] args) {
        Invoice item1 = new Invoice("A123", "Молоток", 3, 15.50);
        Invoice item2 = new Invoice("B456", "Отвёртка", -2, 7.25);
        Invoice item3 = new Invoice("C789", "Гайки", 10, -1.0);

        displayInvoice(item1);
        displayInvoice(item2);
        displayInvoice(item3);
    }

    private static void displayInvoice(Invoice invoice) {
        System.out.println("Счёт: " + invoice.getPartNumber() + " - " + invoice.getPartDescription() +
                ", количество: " + invoice.getQuantity() +
                ", цена за единицу: " + invoice.getPricePerItem() +
                ", сумма: " + invoice.getInvoiceAmount());
    }
}
