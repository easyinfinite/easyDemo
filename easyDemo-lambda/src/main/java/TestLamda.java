import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName:TestLamda
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2020/6/9 10:51 上午
 * @version: 1.0.0
 **/
public class TestLamda {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(73, 74, 75, 71, 69, 72, 76, 73);
        List<Integer> a = stream.skip(2).collect(Collectors.toList());
        a.sort(Comparator.comparingInt(Integer::intValue).reversed());

//        stream.sorted().map(String::valueOf).collect(Collectors.toList()).forEach(System.out::print);
        List<Integer> b =filterNum(a, n -> n > 1);
        b.forEach(System.out::println);
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
