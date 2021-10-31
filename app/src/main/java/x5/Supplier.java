package x5;

import java.util.ArrayList;
import java.util.List;

public class Supplier {

    public static String getResult(int n, List<Integer> price, List<Integer> amount, List<Integer> count, List<Integer> delivery) {
        List<Department> departmentList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int department = 0, departmentCount = 0, tempN = 0;
        double departmentPrice = 0, productPrice = 0;
        Department d;

        for (int i = 0; i < delivery.size(); i++) {
            departmentList.add(i, new Department(price.get(i), amount.get(i), count.get(i), delivery.get(i)));
        }

        while (n > 0) {
            for (int i = 0; i < departmentList.size(); i++) {
                d = departmentList.get(i);
                tempN = Math.min(n, d.availableProducts());
                productPrice = (double) d.calcOrder(tempN) / tempN;
                if ((departmentPrice == 0 || productPrice < departmentPrice) && tempN != 0) {
                    department = i;
                    departmentPrice = productPrice;
                    departmentCount = tempN;
                }
            }

            if (!departmentList.get(department).createOrder(departmentCount)) {
                break;
            }
            n -= departmentCount;
            departmentPrice = 0;
            result.add(String.valueOf(department));
        }

        return String.join(",", result);
    }

    private static class Department {
        private final int price;
        private final int amount;
        private final int delivery;
        private int count;

        public Department(int price, int amount, int count, int delivery) {
            this.price = price;
            this.amount = amount;
            this.delivery = delivery;
            this.count = count;
        }

        public int availableProducts() {
            return count * amount;
        }

        public Integer calcOrder(int productCount) {
            return calcParts(productCount) * price + delivery;
        }

        public boolean createOrder(int productCount) {
            int batches = calcParts(productCount);
            if (batches > count) {
                return false;
            }
            count -= batches;
            return true;
        }

        public Integer calcParts(int productCount) {
            return (int) Math.ceil((double) productCount / amount);
        }
    }
}
