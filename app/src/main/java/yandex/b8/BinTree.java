package yandex.b8;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BinTree {

    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        Node<Integer> tree = new Node<>();

        while (inp.hasNext()) {
            switch (inp.next()) {
                case "ADD":
                    System.out.println(tree.add(inp.nextInt()) ? "DONE" : "ALREADY");
                    break;
                case "SEARCH":
                    System.out.println(tree.contains(inp.nextInt()) ? "YES" : "NO");
                    break;
                case "PRINTTREE":
                    System.out.println(tree);
                    break;
                default:
                    return;
            }
        }
    }

    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        Node() {
        }

        Node(T value) {
            this.value = value;
        }

        public boolean add(T value) {
            if (this.value == null) {
                this.value = value;
                return true;
            }
            switch (this.value.compareTo(value)) {
                case -1:
                    if (right == null) {
                        right = new Node<T>(value);
                        return true;
                    }
                    if (right.value.equals(value)) {
                        return false;
                    }
                    return right.add(value);
                case 1:
                    if (left == null) {
                        left = new Node<T>(value);
                        return true;
                    }
                    if (left.value.equals(value)) {
                        return false;
                    }
                    return left.add(value);
                default:
                    return false;
            }
        }

        public boolean contains(T v) {
            if (this.value == null) {
                return false;
            }
            switch (this.value.compareTo(v)) {
                case -1:
                    return right != null && right.contains(v);
                case 1:
                    return left != null && left.contains(v);
                default:
                    return true;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            toStringRecursively(sb, 0);
            if (sb.length() > 2) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }

        private void toStringRecursively(StringBuilder stringBuilder, int level) {
            if (left != null) {
                left.toStringRecursively(stringBuilder, level + 1);
            }
            IntStream.range(0, level).forEach(i -> stringBuilder.append("."));
            stringBuilder.append(this.value).append("\n");
            if (right != null) {
                right.toStringRecursively(stringBuilder, level + 1);
            }
        }
    }
}
