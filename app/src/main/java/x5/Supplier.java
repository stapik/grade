package x5;

import java.util.ArrayList;
import java.util.List;

public class Supplier {

    public static String getResult(int n, List<Integer> price, List<Integer> amount, List<Integer> count, List<Integer> delivery) {
        List<Department> departmentList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int departmentIdx = -1, departmentProductCount = 0, tempN;
        double departmentPrice = 0, tempPrice;
        Department department;

        for (int i = 0; i < delivery.size(); i++) {
            departmentList.add(i, new Department(price.get(i), amount.get(i), count.get(i), delivery.get(i)));
        }

        while (n > 0) {
            for (int i = 0; i < departmentList.size(); i++) {
                department = departmentList.get(i);
                tempN = Math.min(n, department.availableProducts());
                if (tempN == 0) {
                    continue;
                }
                tempPrice = (double) department.calcOrder(tempN) / tempN;
                if ((departmentPrice == 0 || tempPrice < departmentPrice)) {
                    departmentIdx = i;
                    departmentPrice = tempPrice;
                    departmentProductCount = tempN;
                }
            }

            if (departmentIdx == -1) {
                break;
            }

            if (departmentList.get(departmentIdx).createOrder(departmentProductCount)) {
                n -= departmentProductCount;
                result.add(String.valueOf(departmentIdx));

                departmentIdx = -1;
                departmentPrice = 0;
                departmentProductCount = 0;
            }
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
            int parts = calcParts(productCount);
            if (parts > count) {
                return false;
            }
            count -= parts;
            return true;
        }

        public Integer calcParts(int productCount) {
            return (int) Math.ceil((double) productCount / amount);
        }
    }
}
