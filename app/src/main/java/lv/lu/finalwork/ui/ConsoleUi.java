package lv.lu.finalwork.ui;

import lv.lu.finalwork.model.ProductInputData;
import lv.lu.finalwork.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ConsoleUi {

    private final ProductService productService;
    private final Scanner scanner;

    @Autowired
    public ConsoleUi(ProductService productService, Scanner scanner) {
        this.productService = productService;
        this.scanner = scanner;
    }

    public void run() {
        int userChoice;
        do {
            printMenu();
            userChoice = scanner.nextInt();

            if (userChoice == 1) {
                productService.save(getProductInputData(scanner));
            }

            if (userChoice == 2) {
                productService.findAll().forEach(System.out::println);
            }

        } while (userChoice != 0);
    }

    private ProductInputData getProductInputData(Scanner scanner) {
        ProductInputData productInputData = new ProductInputData();

        System.out.println("Enter product name: ");
        productInputData.setName(scanner.next());

        System.out.println("Enter product price: ");
        productInputData.setPrice(scanner.nextDouble());

        System.out.println("Enter product category: ");
        productInputData.setCategory(scanner.next());

        return productInputData;
    }

    private void printMenu() {
        System.out.println("\n\n === Product Accounting Application === \n");
        System.out.println("Choose one of following options:");
        System.out.println("1: Save product");
        System.out.println("2: List all products");
        System.out.println("0: Exit application");
        System.out.println("\nPlease select choice: ");
    }
}
