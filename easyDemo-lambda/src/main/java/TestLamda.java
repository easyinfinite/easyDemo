import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName:TestLamda
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2020/6/9 10:51 上午
 * @version: 1.0.0
 **/
public class TestLamda {
    public static void main(String[] args) {
//        Stream<Integer> stream = Stream.of(73, 74, 75, 71, 69, 72, 76, 73);
//        List<Integer> a = stream.skip(2).collect(Collectors.toList());
//        a.sort(Comparator.comparingInt(Integer::intValue).reversed());
//
////        stream.sorted().map(String::valueOf).collect(Collectors.toList()).forEach(System.out::print);
//        List<Integer> b =filterNum(a, n -> n > 1);
//        b.forEach(System.out::println);


//        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
//        List<Integer> numbers2 = Arrays.asList(3, 4);
//        List<int[]> pairs =
//                numbers1.stream()
//                        .flatMap(i -> numbers2.stream()
//                                .map(j -> new int[]{i, j})
//                        )
//                        .collect(toList());
//        pairs.forEach(n -> System.out.println(n[0] + ":" + n[1]));
//

        Integer[] aa = new Integer[]{111, 222, 333};

        String[] arrayOfWords = {"Goodbye", "World"};
//        List<Character> sss =  Arrays.stream(aa).map(n -> n.toString().toCharArray()).flatMapToInt(i->(int)i).collect(Collectors.toList());
//        sss.forEach(System.out::println);

    }


    public static List<Integer> filterNum(List<Integer> list, Predicate<Integer> b) {
        List<Integer> result = new ArrayList<>();
        for (int a : list) {
            if (b.test(a)) {
                result.add(a);
            }
        }
        return result;
    }


}
