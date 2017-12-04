package Linkedin;
import java.util.*;
public class UnionIntersectOfTwoLists {
    /*lists are sorted*/
    public static List<Integer> union(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        if (l1 == null || l1.size() == 0) return l2;
        if (l2 == null || l2.size() == 0) return l1;
        List<Integer> res = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < l1.size() && ptr2 < l2.size()) {
            if (l1.get(ptr1) < l2.get(ptr2)) {
                res.add(l1.get(ptr1));
                ptr1++;
            } else if (l1.get(ptr1) > l2.get(ptr2)) {
                res.add(l2.get(ptr2));
                ptr2++;
            } else {
                res.add(l1.get(ptr1));
                ptr1++; ptr2++;
            }
        }
        while (ptr1 < l1.size()) {
            res.add(l1.get(ptr1));
            ptr1++;
        }
        while (ptr2 < l2.size()) {
            res.add(l1.get(ptr2));
            ptr2++;
        }
        return res;
    }
    public static List<Integer> intersection(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        if (l1 == null || l2 == null || l1.size() == 0 || l2.size() == 0) return null;
        List<Integer> res = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < l1.size() && ptr2 < l2.size()) {
            if (l1.get(ptr1) == l2.get(ptr2)) {
                res.add(l1.get(ptr1));
                ptr1++; ptr2++;
            } else if (l1.get(ptr1) < l2.get(ptr2)) {
                ptr1++;
            } else {
                ptr2++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,3,4,6,8));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(3,5,6,8));

        for (int i : intersection(l1, l2)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : union(l1, l2)) {
            System.out.print(i + " ");
        }
    }
}
