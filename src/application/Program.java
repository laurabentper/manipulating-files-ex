package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("File path: ");
        String path = sc.nextLine();
        File sourceFile = new File(path);
        String sourceDir = sourceFile.getParent();
        boolean success = new File(sourceDir + "\\out").mkdir();
        String targetFile = sourceDir + "\\out\\summary.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String lineCSV = br.readLine();

            while(lineCSV != null) {
                String[] fields = lineCSV.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);
                products.add(new Product(name, price, quantity));

                lineCSV = br.readLine();
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))){
                for(Product product : products) {
                    bw.write(product.getName() + " - " + String.format("%.2f", product.getTotalValue()));
                    bw.newLine();
                }
            } catch (IOException e){
                System.out.println("Error writing file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }


        sc.close();
    }
}
