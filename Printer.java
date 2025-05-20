import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Printer {

    private Printer() {
        // ! 空にしておく
    };

    public static void print(Object element) {
        System.out.print(element);
    }

    public static void println(Object element) {
        System.out.println(element);
    }

    // エラー出力
    public static void err(Object element) {
        System.err.println(element);
    }

    /*
     * 配列の全体像を出力
     * 例：element = {1, 2, 3, 4, 5}の場合
     * 出力：[1, 2, 3, 4, 5]
     */
    public static void print(int[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static void print(double[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static void print(long[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static void print(char[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static void print(String[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static <T> void print(List<T> list) {
        System.out.print(list);
    }

    public static <T> void print(Set<T> set) {
        System.out.print(set);
    }

    public static <T> void print(Map<T, T> map) {
        System.out.print(map);
    }

    public static void println(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void println(double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void println(long[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void println(char[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void println(String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static <T> void println(List<T> list) {
        System.out.println(list);
    }

    public static <T> void println(Set<T> set) {
        System.out.println(set);
    }

    public static <T> void println(Map<T, T> map) {
        System.out.println(map);
    }

    // Mapのkeyとvalueのセットを出力
    public static <T> void printMap(Map<T, T> map) {
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    // Mapのkeyのみを出力
    public static <T> void printKey(Map<T, T> map) {
        for (T key : map.keySet()) {
            System.out.println(key);
        }
    }

    // Mapのvalueのみを出力
    public static <T> void printValue(Map<T, T> map) {
        for (T value : map.values()) {
            System.out.println(value);
        }
    }

    /*
     * 配列の要素をすべて出力
     * 
     * @param changeLine 改行の有無。trueならば1つの要素を出力するごとに改行し、falseならば空白区切りで出力する。
     */

    // ? Object[]にしてもエラーが出る、なんで？
    public static void printEach(int[] arr, boolean changeLine) {
        if (changeLine) {
            for (int element : arr) {
                System.out.println(element);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }

    public static void printEach(double[] arr, boolean changeLine) {
        if (changeLine) {
            for (double element : arr) {
                System.out.println(element);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }

    public static void printEach(long[] arr, boolean changeLine) {
        if (changeLine) {
            for (long element : arr) {
                System.out.println(element);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }

    public static void printEach(char[] arr, boolean changeLine) {
        if (changeLine) {
            for (char element : arr) {
                System.out.println(element);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }

    public static <T> void printEach(T[] arr, boolean changeLine) {
        if (changeLine) {
            for (T element : arr) {
                System.out.println(element);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }

    public static <T> void printEach(List<T> list, boolean changeLine) {
        if (changeLine) {
            for (T element : list) {
                System.out.println(element);
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }

    /*
     * varargs対応型
     * 例：Printer.printEach(false, "Hello", 123, 45.6, 'X');
     * 出力：Hello 123 45.6 X
     */
    public static void printEach(boolean changeLine, Object... elements) {
        // elementsがない場合にはエラー
        if (elements.length == 0) {
            throw new IllegalArgumentException("1つ以上の引数を指定して下さい。");
        }

        if (changeLine) {
            for (Object element : elements) {
                System.out.println(element);
            }
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(elements[i]);
            }
            System.out.println();
        }
    }

    /*
     * 区切り文字を指定できる型
     * 
     * @param delimiter 区切り文字。配列やリストの要素が入力された文字で区切られて出力される。
     */
    public static void printJoined(int[] arr, String delimiter) {
        String result = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(delimiter));
        System.out.println(result);
    }

    public static void printJoined(double[] arr, String delimiter) {
        String result = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(delimiter));
        System.out.println(result);
    }

    public static void printJoined(long[] arr, String delimiter) {
        String result = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(delimiter));
        System.out.println(result);
    }

    public static void printJoined(char[] arr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                sb.append(delimiter);
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }

    public static <T> void printJoined(T[] arr, String delimiter) {
        System.out.println(String.join(delimiter, Arrays.stream(arr)
                .map(String::valueOf)
                .toArray(String[]::new)));
    }

    public static <T> void printJoined(List<T> list, String delimiter) {
        System.out.println(String.join(delimiter, list.stream()
                .map(String::valueOf)
                .toList()));
    }

}