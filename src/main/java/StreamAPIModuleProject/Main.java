package StreamAPIModuleProject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();

        Product potato = new Product(1L, "Конструктор", "Toys", BigDecimal.valueOf(1999.99));
        Product Agusha = new Product(2L, "Агуша", "Children's products", BigDecimal.valueOf(199.99));
        Product carrot = new Product(3L, "Морковь", "vegetable", BigDecimal.valueOf(20.99));
        Product pineapple = new Product(4L, "Брелок", "Toys", BigDecimal.valueOf(349.51));
        Product DeadSouls = new Product(5L, "Мертвые души", "Books", BigDecimal.valueOf(320.99));
        Product ThePortraitOfDorianGray = new Product(6L, "Портрет Дориана Грея", "Books", BigDecimal.valueOf(300.99));
        Product pistachios = new Product(7L, "Фисташки", "nuts", BigDecimal.valueOf(10000.99));
        Product hazelnut = new Product(8L, "Фундук", "nuts", BigDecimal.valueOf(170.49));

        Set<Product> products1 = new HashSet<>();
        Set<Product> products2 = new HashSet<>();
        Set<Product> products3 = new HashSet<>();
        Set<Product> products4 = new HashSet<>();
        Set<Product> products5 = new HashSet<>();
        Set<Product> products6 = new HashSet<>();
        Set<Product> products7 = new HashSet<>();
        Set<Product> products8 = new HashSet<>();
        Set<Product> products9 = new HashSet<>();
        Set<Product> products10 = new HashSet<>();

        products1.add(potato);
        products2.add(potato);
        products2.add(Agusha);
        products2.add(pistachios);
        products3.add(pineapple);
        products3.add(DeadSouls);
        products4.add(ThePortraitOfDorianGray);
        products4.add(hazelnut);
        products5.add(carrot);
        products6.add(ThePortraitOfDorianGray);
        products6.add(hazelnut);
        products6.add(pistachios);
        products6.add(DeadSouls);
        products7.add(DeadSouls);
        products8.add(Agusha);
        products8.add(potato);
        products8.add(DeadSouls);
        products9.add(DeadSouls);
        products10.add(hazelnut);
        products10.add(carrot);
        products10.add(potato);

        Order order1 = new Order(1L, LocalDate.now(), LocalDate.now().plusDays(7), "Processing", products1);
        Order order2 = new Order(2L, LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 16), "Delivered", products2);
        Order order3 = new Order(3L, LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 14), "Delivered", products3);
        Order order4 = new Order(4L, LocalDate.now(), LocalDate.now().plusDays(3), "Processing", products4);
        Order order5 = new Order(5L, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5), "Delivered", products5);
        Order order6 = new Order(6L, LocalDate.now(), LocalDate.now().plusDays(5), "Processing", products6);
        Order order7 = new Order(7L, LocalDate.now().minusDays(15), LocalDate.now().minusDays(12), "Delivered", products7);
        Order order8 = new Order(8L, LocalDate.now().minusDays(11), LocalDate.now().minusDays(9), "Delivered", products8);
        Order order9 = new Order(9L, LocalDate.now().minusDays(25), LocalDate.now().minusDays(23), "Delivered", products9);
        Order order10 = new Order(10L, LocalDate.now().minusDays(7), LocalDate.now().minusDays(1), "Delivered", products10);
        Order order11 = new Order(11L, LocalDate.now(), LocalDate.now().plusDays(7), "Processing", products1);
        Order order12 = new Order(12L, LocalDate.now(), LocalDate.now().plusDays(2), "Processing", products2);
        Order order13 = new Order(13L, LocalDate.now(), LocalDate.now().plusDays(1), "Processing", products3);
        Order order14 = new Order(14L, LocalDate.now(), LocalDate.now().plusDays(3), "Processing", products4);
        Order order15 = new Order(15L, LocalDate.now().minusDays(7), LocalDate.now().minusDays(5), "Delivered", products5);
        Order order16 = new Order(16L, LocalDate.now(), LocalDate.now().plusDays(5), "Processing", products6);
        Order order17 = new Order(17L, LocalDate.now().minusDays(15), LocalDate.now().minusDays(12), "Delivered", products7);
        Order order18 = new Order(18L, LocalDate.now().minusDays(11), LocalDate.now().minusDays(9), "Delivered", products8);
        Order order19 = new Order(19L, LocalDate.now().minusDays(25), LocalDate.now().minusDays(23), "Delivered", products9);
        Order order20 = new Order(20L, LocalDate.now().minusDays(7), LocalDate.now().minusDays(1), "Delivered", products10);
        Order order21 = new Order(21L, LocalDate.now(), LocalDate.now().plusDays(7), "Processing", products1);
        Order order22 = new Order(22L, LocalDate.now(), LocalDate.now().plusDays(2), "Processing", products2);
        Order order23 = new Order(23L, LocalDate.now(), LocalDate.now().plusDays(1), "Processing", products3);
        Order order24 = new Order(24L, LocalDate.of(2021, 3, 14), LocalDate.now().plusDays(3), "Processing", products4);
        Order order25 = new Order(25L, LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 16), "Delivered", products5);

        Customer customer1 = new Customer(1L, "Alex",2L, Set.of(order1, order2, order3, order4, order5));
        Customer customer2 = new Customer(2L, "Boris",5L, Set.of(order6, order7, order8, order9, order10));
        Customer customer3 = new Customer(3L, "Catherine", 3L, Set.of(order11, order12, order13, order14, order15));
        Customer customer4 = new Customer(4L, "Dmitry", 14L, Set.of(order16, order17, order18, order19, order20));
        Customer customer5 = new Customer(5L, "Elena", 20L,Set.of(order21, order22, order23, order24, order25));

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        // Задание 1 (Получите список продуктов из категории "Books" с ценой более 100)
        List<Product> booksOver100 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> "Books".equals(product.getCategory()))
                .filter(product -> product.getPrice() > 100)
                .distinct()
                .collect(Collectors.toList());

        // Задание 2 (Получите список заказов с продуктами из категории "Children's products")

        List<Order> kategorChildrensProducts = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getProducts().stream()
                    .anyMatch(product -> "Children's products".equals(product.getCategory())))
                .collect(Collectors.toList());

        // Задание 3 (Получите список продуктов из категории "Toys" и примените скидку 10%
        // и получите сумму всех продуктов.)

        int kategorToysSale10 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> "Toys".equals(product.getCategory()))
                .distinct()
                .mapToInt(product -> (int) (product.getPrice() * 0.9))
                .sum();

        // Задание 4 (Получите список продуктов, заказанных клиентом второго уровня между 01-фев-2021 и 01-апр-2021.)

        List<Product> levelTwo2021_02_1 = customers.stream()
                .filter(customer -> customer.getLevel() == 2L)
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> ! order.getOrderDate().isBefore(LocalDate.of(2021, 2, 1)) &&
                        ! order.getOrderDate().isAfter(LocalDate.of(2021, 4, 1)))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());

        // Задание 5 (Получите топ 2 самые дешевые продукты из категории "Books")

        List<Product> top2CheapBook = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Book"))
                .distinct()
                .sorted(Comparator.comparingInt(Product::getPrice))
                .limit(2)
                .collect(Collectors.toList());


        // Задание 6 (Получите 3 самых последних сделанных заказа.)

        List<Order> last3Orders = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .distinct()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());

        // Задание 7 (Получите список заказов, сделанных 15-марта-2021, выведите id заказов в консоль и затем верните
        //список их продуктов.)

        List<Product> productsByOrder2021_03_15 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .peek(order -> System.out.println("Задание 7 Order ID: " + order.getId()))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());

        // Задание 8 (Рассчитайте общую сумму всех заказов, сделанных в феврале 2021.)

        int sumAllOrders2021_02 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> ! order.getOrderDate().isBefore(LocalDate.of(2021, 2, 1)) &&
                        ! order.getOrderDate().isAfter(LocalDate.of(2021, 2, 28)))
                .distinct()
                .flatMap(order -> order.getProducts().stream())
                .mapToInt(Product::getPrice)
                .sum();

        // Задание 9 (Рассчитайте средний платеж по заказам, сделанным 14-марта-2021.)

        double avgPayByOrders2021_03_14 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 14)))
                .distinct()
                .flatMap(order -> order.getProducts().stream())
                .mapToInt(Product::getPrice)
                .average()
                .orElse(0);

        // Задание 10 (Получите набор статистических данных (сумма, среднее, максимум, минимум, количество) для всех
        //продуктов категории "Книги".)

        IntSummaryStatistics statsBooks = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Books"))
                .distinct()
                .mapToInt(Product::getPrice)
                .summaryStatistics();

        // Задание 11 (Получите данные Map<Long, Integer> → key - id заказа, value - кол-во товаров в заказе)

        Map<Long, Integer> orderProductCountMap = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toMap(
                        Order::getId,
                        order -> order.getProducts().size()
                ));

        // Задание 12 (Создайте Map<Customer, List<Order>> → key - покупатель, value - список его заказов)

        Map<Customer, List<Order>> mapOrdersByCustomer = customers.stream()
                .collect(Collectors.toMap(
                        customer -> customer,
                        customer -> customer.getOrders().stream().collect(Collectors.toList())
                ));

        // Задание 13 (Создайте Map<Order, Double> → key - заказ, value - общая сумма продуктов заказа.)

        Map<Order, Double> mapSumByOrder = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toMap(
                        order -> order,
                        order -> order.getProducts().stream()
                                .mapToDouble(Product::getPrice)
                                .sum()
                ));

        // Задание 14 (Получите Map<String, List<String>> → key - категория, value - список названий товаров в категории)

        Map<String, List<String>> mapProductsByCategory = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())
                ));

        // Задание 15 (Получите Map<String, Product> → самый дорогой продукт по каждой категории.)

        Map<String, Product> mostExpensiveProductByCategory = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toMap(
                        Product::getCategory,
                        product -> product,
                        (p1, p2) -> p1.getPrice() > p2.getPrice() ? p1 : p2
                ));

    }
}