import java.util.*;

// Customer class
class Customer {
    private int id;
    private String name;
    private int loyaltyPoints;

    public Customer(int id, String name, int loyaltyPoints) {
        this.id = id;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}

// Product class
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// Order class
class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private Date deliveryDate;

    public Order(int orderId, Customer customer, List<Product> products, Date deliveryDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
        this.deliveryDate = deliveryDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer.getName() +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}

// Comparator for sorting Products by Price
class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

// Comparator for sorting Customers by Loyalty Points
class CustomerLoyaltyComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c2.getLoyaltyPoints(), c1.getLoyaltyPoints()); // Descending order
    }
}

public class Amazon {
    public static void main(String[] args) {
        // ArrayList to store Customers and Products
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        // HashMap for fast retrieval
        HashMap<Integer, Customer> customerMap = new HashMap<>();
        HashMap<Integer, Product> productMap = new HashMap<>();

        // Adding Customers
        Customer c1 = new Customer(1, "Alice", 150);
        Customer c2 = new Customer(2, "Bob", 200);
        customers.add(c1);
        customers.add(c2);
        customerMap.put(c1.getId(), c1);
        customerMap.put(c2.getId(), c2);

        // Adding Products
        Product p1 = new Product(1, "Laptop", 1200.50);
        Product p2 = new Product(2, "Phone", 800.75);
        products.add(p1);
        products.add(p2);
        productMap.put(p1.getId(), p1);
        productMap.put(p2.getId(), p2);

        // HashSet to ensure unique products
        HashSet<Product> uniqueProducts = new HashSet<>();
        uniqueProducts.add(p1);
        uniqueProducts.add(p2);

        // TreeSet for sorted Customers
        TreeSet<Customer> sortedCustomers = new TreeSet<>(new CustomerLoyaltyComparator());
        sortedCustomers.addAll(customers);

        // TreeSet for sorted Products
        TreeSet<Product> sortedProducts = new TreeSet<>(new ProductPriceComparator());
        sortedProducts.addAll(products);

        // Demonstrating functionality
        System.out.println("Customers:");
        for (Customer customer : sortedCustomers) {
            System.out.println(customer);
        }

        System.out.println("\nProducts:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }

        // Creating and displaying an Order
        List<Product> orderProducts = new ArrayList<>();
        orderProducts.add(p1);
        orderProducts.add(p2);
        Order order = new Order(101, c1, orderProducts, new Date());
        System.out.println("\nOrder:");
        System.out.println(order);
    }
}
