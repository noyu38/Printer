# Printer.java
**System.out.println()とかいう怪文書を書きまくらなくていいように**  
標準出力をもうちょい楽に、便利に実行できるようにしたメソッド集です。  
作業中のデバッグなどを行いたいときに便利かもです<strike>(複数人作業で使われたらたまったもんじゃないのでやめてください)</strike>  
## メソッド一覧
以下のメソッドが用意されています。
### Printer.print(), Printer.println()
---  
基本的にSystem.out.print(), System.out.println()と同じです。引数にList,Set,Mapを入れた場合も同様です。  
ただし、引数にint[]などの配列を入れた場合のみ違った挙動を示します。  
配列arrを引数に入れた場合、Arrays.toString(arr)の結果を出力します。
```
int[] arr = {1, 2, 3, 4, 5};

Printer.println(arr); // 結果：[1, 2, 3, 4, 5]
```
### Printer.err()
---  
System.err.println()と同じです。
### Printer.printMap(Map<T, T> map)
---  
Mapにおけるkeyとvalueを : (コロン)でつないだ形式で表示します。実行例では,(コンマ)で区切られていますが、実際には各セットを出力するごとに改行されます。
```
Map<String, String> map = Map.of("name", "Alice", "city", "Tokyo");

Printer.printMap(map);
// 結果：name:Alice, city:Tokyo
```
### Printer.printKey(Map<T, T> map)
---  
Mapにおけるkeyのみを出力します。
```
Map<String, String> map = Map.of("name", "Alice", "city", "Tokyo");

Printer.printKey(map);
// 結果：name, city
```
### Printer.printValue(Map<T, T> map)
---  
Mapにおけるvalueのみを出力します。
```
Map<String, String> map = Map.of("name", "Alice", "city", "Tokyo");

Printer.printValue(map);
// 結果：Alice, Tokyo
```
### Printer.printEach("int[]やList", boolean changeLine)
---  
配列やリストの要素を1つずつ出力します。
changeLineがtrueの場合は1つ出力するごとに改行し、falseの場合は空白区切りで出力します。
```
Printer.printEach(new int[]{10, 20, 30}, false);
// 結果：10 20 30
```
### Printer.printEach(boolean changeLine, Object... elements)
---  
printEach()をvarargsに対応させたものです。
```
Printer.printEach(false, "Hello", 123, 45.6, 'X');
// 出力：Hello 123 45.6 X
```
### Printer.printJoined("int[]やList", String delimiter)
---  
配列やリストの要素を、文字列delimiterで区切って1つずつ出力します。
```
Printer.printJoined(List.of("dog", "cat", "rabbit"), "/");
// 結果：dog/cat/rabbit
```