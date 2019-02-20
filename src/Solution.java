import java.util.*;


class Solution {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,2,2,2,2,3,3,3,3,3);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return o1-o2;
            }
        });

        list.stream().forEach(System.out::println);


    }


}
