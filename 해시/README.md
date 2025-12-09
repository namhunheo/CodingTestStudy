## 📅 진행 

* [오늘의 문제](https://github.com/Java-CodingTestStudy/CodingTestStudy/blob/main/Picked.md)
 
| 날짜 | 문제 유형 | 문제 | 난이도 | 발표 선정 문제 |
|:---:|:---:|:---|:---|:---:|
| 25.12.08 | 해시 | [완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java)(필수) <br> [롤케이크 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/132265)(필수) <br> [귤 고르기](https://school.programmers.co.kr/learn/courses/30/lessons/138476)(필수)<br>  [3차 압축](https://school.programmers.co.kr/learn/courses/30/lessons/17684) <br> [전화번호 목록](https://school.programmers.co.kr/learn/courses/30/lessons/42577)| <img src="https://img.shields.io/badge/Lv.1-1185FE?style=plastic"/> <br> <img src="https://img.shields.io/badge/Lv.2-3DA639?style=plastic"/> <br> <img src="https://img.shields.io/badge/Lv.2-3DA639?style=plastic"/> <br> <img src="https://img.shields.io/badge/Lv.2-3DA639?style=plastic"/> <br> <img src="https://img.shields.io/badge/Lv.2-3DA639?style=plastic"/> | <br><br><br>
<br> 

| 문제 | 예진 | 채원 | 성준 | 민석 | 훈주 | 의선
| :---: | :---: | :---: | :---: | :---: |:---: | :---: |
| 5 문제 | ✔️  | 3️⃣  | 3️⃣ | 3️⃣  |  |    |

> ✔️ 다 품  
> ❌ 못 품  
> 1️⃣2️⃣3️⃣4️⃣5️⃣ 푼 문제 수

---

## Hash 

* 저장/검색에서 자주 활용되는 자료 구조
* 입력 데이터를 특정 알고리즘을 통해 고정된 길이의 데이터로 변환한 값
* 특징
    * key-value 구조: key는 중복X, value는 중복O
    * 해시 함수를 통해 인덱스 번호 계산
    * 저장 및 탐색 O(1)

* 해시 함수: 해시 함수(Hash function)는 입력받은 데이터를 해시 값으로 출력시키는 알고리즘
* 해시 테이블: 키와 값을 함께 저장해 둔 데이터 구조
* 해싱(Hashing): 해시 함수를 통해 입력받은 데이터를 변환시키고, 이 값을 해시 테이블에 저장하는 과정

### HashMap, HashTable 비교

* HashTable은 자바에서 구현한 클래스 중 가장 오래 된 클래스로 가능하면 사용을 지양한다
* 차이점
    * Thread-Safe: HashTable은 Thread-Safe하고 Map은 그렇지 않음
    * null: 해시테이블은 key에 null 허용X, map은 key에 null 허용


### HashMap 기본 함수

```java
import java.util.Map;
import java.util.HashMap;
```
| 메서드                          | 설명                       | 예시                          |
| ---------------------------- | ------------------------ | --------------------------- |
| `put(key, value)`            | 값 저장 또는 덮어쓰기             | `map.put("a", 1);`          |
| `get(key)`                   | key의 value 반환 (없으면 null) | `map.get("a");`             |
| `getOrDefault(key, default)` | key 없을 때 default 값 반환    | `map.getOrDefault("b", 0);` |
| `containsKey(key)`           | key 존재 여부 확인             | `map.containsKey("a");`     |
| `remove(key)`                | key 삭제                   | `map.remove("a");`          |
| `replace(key, value)`        | key 존재할 때만 변경            | `map.replace("a", 5);`      |
| `size()`                     | 저장된 개수                   | `map.size();`               |
| `isEmpty()`                  | 비어있는지                    | `map.isEmpty();`            |


### HashSet 기본 함수

| 메서드               | 설명    | 예시                   |
| ----------------- | ----- | -------------------- |
| `add(value)`      | 값 추가  | `set.add("a");`      |
| `contains(value)` | 포함 여부 | `set.contains("a");` |
| `remove(value)`   | 값 삭제  | `set.remove("a");`   |
| `size()`          | 크기    | `set.size();`        |
| `isEmpty()`       | 비어있는지 | `set.isEmpty();`     |


### Map 순회

* **반복자 Iterator**
    ```java
    Map<Integer, String> map = new HashMap<>();

    Iterator<Integer> iter = map.keySet().iterator();
    while(iter.hasNext()){
        Integer key = iter.next();
        String value = map.get(key);
    }
    ```

* **entrySet** 
    * entry: map의 key-value 쌍을 entry라고 함
    ```java
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    ```

* **keySet**
    ```java
    Map<Integer, String> map = new HashMap<>();

    for(Integer i : map.keySet()){
        int key = i;
        String value = map.get(i);
    }
    ```

* **forEach**
    ```java
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("a", "val1");
    map.put("b", "val2");
    map.put("c", "val3");
            
    map.forEach((k, v) -> {
        System.out.println(String.format("키: %s, 값: %s", k, v));
    });
    ```

#### Map.Entry

* Map.Entry는 Map 내부에서 한 쌍의 (key, value)를 표현하기 위한 **내부 인터페이스(타입)**
* key와 value를 동시에 가져오고 싶을 때 사용하는 구조
* 예시
    | 개념          | 비유                    |
    | ----------- | --------------------- |
    | `Map`       | 전화번호부                 |
    | `Key`       | 사람 이름                 |
    | `Value`     | 전화번호                  |
    | `Map.Entry` | 이름 + 전화번호가 묶인 한 줄 데이터 |


* 순회 예시  
    ❌ 나쁜 방식 (O(N) 조회 반복 → 비효율)  
    ```java
    for(String key : map.keySet()) {
        System.out.println(key + " : " + map.get(key)); // get() 반복 호출 비용↑
    }
    ```  

    ✅ 좋은 방식 (entrySet() 사용)  
    ```java
    for(Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + " = " + entry.getValue());
    }
    ```

* Entry 메소드
    | 메서드          | 설명       |
    | ------------- | -------- |
    | `getKey()`    | key 반환   |
    | `getValue()`  | value 반환 |
    | `setValue(v)` | value 변경 |

* 시간복잡도

    | 자료구조    | 평균   | 최악                       | 비고          |
    | ------- | ---- | ------------------------ | ----------- |
    | HashMap | O(1) | O(n) → Java8 이후 O(log n) | 충돌 시 트리     |
    | HashSet | O(1) | O(n) → Java8 이후 O(log n) | 내부는 HashMap |

 

### Map 정렬

* key 기준 정렬
    * **TreeMap**  
    HashMap은 순서를 보장하지 않지만, TreeMap은 키(Key)를 기준으로 자동으로 정렬된 Map을 제공
    ```java
    Map<String, Integer> map = new HashMap<>();
    map.put("apple", 3);
    map.put("banana", 2);
    map.put("cherry", 5);
    map.put("date", 1);

    // Key값으로 정렬 (TreeMap 사용)
    Map<String, Integer> treemap = new TreeMap<>(map);

    /* 내림차순 정렬 */
    Map<String, Integer> treemap = new TreeMap<>(Collections.reverseOrder());
    treemap.putAll(map);
    ```

    * **keySet** : map의 keySet을 list로 변환 후 정렬
        ```java
            List<String> keySet = new ArrayList<>(map.keySet());	// map의 keySet()을 list로
            
            Collections.sort(keySet);	// 오름차순 정렬
            Collections.reverse(keySet); 	// 내림차순 정렬
        ```

    * **stream**
        ```java
        // 오름차순
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())   
                .forEach(System.out::println);

        // 내림차순
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .forEach(System.out::println);

        ```

* value 기준 정렬
    * **entry**
        ```java
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> a.getValue() - b.getValue());

        // 내림차순
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        // compareTo
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        ```

    * **comparator**: map의 keySet을 list로 변환 후 정렬
        ```java
            List<String> list = new ArrayList<>(map.keySet());

            keySet.sort(new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    return map.get(s1) - map.get(s2);       // 오름차순 정렬
                    return map.get(s2) - map.get(s1);       // 내림차순 정렬
                }
            })
        ```

    * 람다식
    ```java
        // 내림차순 정렬
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
    ```

#### compareTo vs compare override

| 비교 형태           | 사용 구문               | 예시                            |
| --------------- | ------------------- | ----------------------------- |
| `compare(a, b)` | Comparator 구현 시 사용  | `return b - a`                |
| `compareTo(b)`  | Comparable 구현 객체 비교 | `"apple".compareTo("banana")` |



### 요약

> HashMap: key→value 매핑, 카운팅 문제에 최강자

> HashSet: 중복 제거, prefix/중복 검사 문제에 자주 사용

> entrySet(): key/value를 동시에 꺼낼 때 사용 → keySet()+get()보다 효율적

### (참고)List to Array
