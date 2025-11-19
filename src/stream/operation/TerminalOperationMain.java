package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationMain {

    static void main() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

        // Collectors 는 뒤에서 더 자세히 설명 ( 복잡한 수집이 필요할 떄 사용됩니다. )
        System.out.println("1. collect - List 수집");
        List<Integer> evenNumbers1 = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("evenNumbers1 = " + evenNumbers1);
        System.out.println();

        // .collect(Collectors.toList()); 를 대체할 수 있도록 Java 16+ 지원
        System.out.println("2. toList() - List 수집");
        List<Integer> evenNumbers2 = numbers.stream()
            .filter(n -> n % 2 == 0)
            .toList();
        System.out.println("evenNumbers2 = " + evenNumbers2);
        System.out.println();

        System.out.println("3. toArray - 배열로 변환");
        Integer[] arr = numbers.stream()
            .filter(n -> n % 2 == 0)
            .toArray(Integer[]::new);
        System.out.println("Array.toString(arr) = " + Arrays.toString(arr));
        System.out.println();

        System.out.println("4. forEach - 각 요소 처리");
        numbers.stream()
            .limit(5)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("5. count - 요소 개수");
        long count = numbers.stream()
            .filter(n -> n > 5)
            .count();
        System.out.println("5보다 큰 숫자의 개수 = " + count);
        System.out.println();

        System.out.println("6. reduce - 요소들의 합");
        System.out.println("초기값이 없는 reduce");
        Optional<Integer> sum1 = numbers.stream()
            .reduce((a, b) -> a + b);
        System.out.println("합계 (초기값 없음) : " + sum1.get());
        // 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10
        // 1 + 2 -> 3 + 2 -> 5 + 3 -> ...
        // 3, 5, 8, 12, 17, 22, 28, 35, 43, 52, 62
        // numbers 가 아무값도 없는 경우도 있기 때문에 Optional 로 반환합니다.

        System.out.println("초기값이 있는 reduce");
        int sum2 = numbers.stream()
            .reduce(
                100,
                (a, b) -> a + b
            );
        // 100 + 1, 101 + 2, 103 + 2 ...
        // 초기값이 설정되어 있기 때문에 항상 값이 있기 때문에 primitive Type 으로 반환합니다.
        System.out.println("합계 (초기값 있음) : " + sum2);

        System.out.println("7. min - 최소값");
        System.out.println("Stream의 min()은 Comparator를 사용하여 최소값을 찾습니다.");
        System.out.println();

        // Comparator의 반환값 규칙:
        // - 음수(-1): 첫 번째 인자(x)가 두 번째 인자(y)보다 작음 -> x를 선택
        // - 0: 두 값이 같음
        // - 양수(1): 첫 번째 인자(x)가 두 번째 인자(y)보다 큼 -> y를 선택

        System.out.println("방법 1: 삼항 연산자로 비교 (복잡)");
        Optional<Integer> min1 = numbers.stream()
            .min((x, y) ->
                (x < y) ? -1 : ((x == y) ? 0 : 1)
            );
        System.out.println("최소값 = " + min1.get());

        System.out.println("\n방법 2: if-else로 비교 (명확)");
        System.out.println("★ min() 내부 동작 과정 (실제 값 대입 예시):");
        System.out.println("  numbers = [1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10]");
        System.out.println();
        System.out.println("  [1단계] 현재 최소값 = 1");
        System.out.println("          비교: compare(1, 2)");
        System.out.println("          → 1 < 2 이므로 -1 반환");
        System.out.println("          → 음수(-1)가 나왔으므로 min()은 첫번째 값(1)을 유지");
        System.out.println("          → 현재 최소값 = 1");
        System.out.println();
        System.out.println("  [2단계] 현재 최소값 = 1");
        System.out.println("          비교: compare(1, 2)");
        System.out.println("          → 1 < 2 이므로 -1 반환");
        System.out.println("          → 현재 최소값 = 1 (계속 유지)");
        System.out.println();
        System.out.println("  [3단계] 현재 최소값 = 1");
        System.out.println("          비교: compare(1, 3)");
        System.out.println("          → 1 < 3 이므로 -1 반환");
        System.out.println("          → 현재 최소값 = 1 (계속 유지)");
        System.out.println();
        System.out.println("  ... 이런 식으로 모든 요소를 비교하면서 최소값 유지");
        System.out.println();
        System.out.println("  ※ 핵심 개념:");
        System.out.println("     - Comparator는 -1, 0, 1 같은 '비교 결과'만 반환");
        System.out.println("     - 실제 값(x 또는 y)을 선택하는 것은 min() 메서드가 처리");
        System.out.println("     - 음수 반환 → min()이 첫번째 값(x) 유지");
        System.out.println("     - 양수 반환 → min()이 두번째 값(y)를 새 최소값으로 설정");
        System.out.println();

        Optional<Integer> min2 = numbers.stream()
            .min((x, y) -> {
                if (x < y) {
                    return -1;  // x가 작으면 음수 반환 → min()이 x를 선택
                } else if (x == y) {
                    return 0;   // 같으면 0 반환 → min()이 현재 값 유지
                } else {
                    return 1;   // x가 크면 양수 반환 → min()이 y를 선택
                }
            });
        System.out.println("최종 최소값 = " + min2.get());

        System.out.println("\n방법 3: compareTo() 사용 (권장)");
        Optional<Integer> min3 = numbers.stream()
            .min((x, y) -> x.compareTo(y));
        System.out.println("최소값 = " + min3.get());

        System.out.println("\n방법 4: 메서드 레퍼런스 (가장 간결)");
        Optional<Integer> min4 = numbers.stream()
            .min(Integer::compareTo);
        System.out.println("최소값 = " + min4.get());
        // 빈 스트림의 경우 최소값이 존재하지 않기 때문에 Optional로 감싸서 반환"
        System.out.println();

        System.out.println("8. max - 최대값");
        Optional<Integer> max = numbers.stream()
            .max(Integer::compareTo);
        System.out.println("max.get() = " + max.get());
        System.out.println();

        System.out.println("9. findFirst - 첫 번째 요소");
        System.out.println("★ 순차 스트림에서의 findFirst():");
        System.out.println("  - 조건을 만족하는 '첫 번째' 요소를 반환");
        System.out.println("  - 순서가 보장됨 (항상 같은 결과)");
        Integer first = numbers.stream()
            .filter(n -> n > 5)  // 5보다 큰 숫자: 6, 7, 8, 9, 10
            .findFirst()         // 이 중 첫 번째인 6을 반환
            .get();
        System.out.println("first = " + first);  // 항상 6
        System.out.println();

        System.out.println("10. findAny - 아무 요소나 하나 찾기");
        System.out.println("★ Any의 의미: '아무거나(어떤 것이든)' 하나");
        System.out.println();
        System.out.println("[순차 스트림]");
        System.out.println("  - findFirst()와 동일하게 동작 (첫 번째 요소 반환)");
        System.out.println("  - 결과: 항상 6");
        Integer any = numbers.stream()
            .filter(n -> n > 5)
            .findAny()
            .get();
        System.out.println("순차 스트림 any = " + any);  // 보통 6
        System.out.println();

        System.out.println("[병렬 스트림]");
        System.out.println("  - 여러 스레드가 동시에 처리");
        System.out.println("  - 가장 먼저 조건을 만족하는 요소를 찾은 스레드의 결과 반환");
        System.out.println("  - 결과: 6, 7, 8, 9, 10 중 아무거나 (실행할 때마다 달라질 수 있음)");
        System.out.println();
        System.out.println("  예시:");
        System.out.println("    스레드1: [1, 2, 2] → 조건 만족 없음");
        System.out.println("    스레드2: [3, 4, 5] → 조건 만족 없음");
        System.out.println("    스레드3: [5, 6, 7] → 6 찾음! (가장 빠름) ✓");
        System.out.println("    스레드4: [8, 9, 10] → 8 찾음!");
        System.out.println("    → 스레드3이 가장 먼저 찾았으므로 6을 반환");
        System.out.println();

        Integer parallelAny = numbers.parallelStream()
            .filter(n -> n > 5)
            .findAny()
            .get();
        System.out.println("병렬 스트림 any = " + parallelAny);  // 6, 7, 8, 9, 10 중 하나
        System.out.println();


        System.out.println("★ 왜 병렬 스트림에서 findAny를 사용하나?");
        System.out.println("  [findFirst() 사용 시]");
        System.out.println("    - 병렬로 처리하더라도 '첫 번째' 요소를 찾아야 함");
        System.out.println("    - 순서를 보장하기 위해 스레드 간 동기화 필요");
        System.out.println("    - 성능 오버헤드 발생");
        System.out.println();
        System.out.println("  [findAny() 사용 시]");
        System.out.println("    - 순서를 고려하지 않음");
        System.out.println("    - 가장 먼저 찾은 결과를 즉시 반환");
        System.out.println("    - 병렬 처리의 성능 이점을 최대한 활용");
        System.out.println();
        System.out.println("  → 조건을 만족하는 '아무 요소나' 찾으면 되는 경우 findAny() 사용!");
        System.out.println();

        /**
         * findAny() 실용 예시: 대용량 주문 목록에서 배송 가능한 창고 찾기
         *
         * 상황:
         * - 전국에 100개의 창고가 있음       List<Warehouse> warehouses = getWarehouses();
         * - 각 창고마다 재고를 확인해야 함 (시간이 오래 걸리는 작업)
         * - 어느 창고든 재고만 있으면 배송 가능
         * - 순서는 중요하지 않음 (첫 번째 창고든 마지막 창고든 상관없음)
         *    Optional<Warehouse> availableWarehouse = warehouses.parallelStream()
         *        .filter(warehouse -> warehouse.hasStock("상품A"))        // 재고 확인 (무거운 작업)
         *        .findAny();                                             // 어느 창고든 재고만 있으면 OK
         *
         *    if (availableWarehouse.isPresent()) {
         *        System.out.println("배송 가능한 창고: " + availableWarehouse.get().getName());
         *        // 배송 처리...
         *    } else {
         *        System.out.println("재고 없음");
         *    }
         *
         * findFirst() 사용 시:
         * - 병렬로 처리해도 "첫 번째" 창고부터 순서대로 확인
         * - 첫 번째 창고에 재고가 없으면 두 번째 확인... (순차적)
         * - 100개 창고 중 마지막 창고에만 재고가 있다면 모든 창고를 다 확인해야 함
         *
         * findAny() 사용 시:
         * - 여러 스레드가 동시에 여러 창고를 병렬로 확인
         * - 가장 먼저 재고를 발견한 창고를 즉시 반환
         * - 마지막 창고에 재고가 있어도, 다른 스레드가 중간 창고에서 먼저 찾으면 바로 반환
         * - 성능 향상!
         */

        System.out.println("11. anyMatch - 조건을 만족하는 요소 존재 여부");
        boolean hasEven = numbers.stream()
            .anyMatch(n -> n % 2 == 0);
        System.out.println("hasEven = " + hasEven);
        System.out.println();

        System.out.println("12. allMatch - 모든 요소가 조건을 만족하는지");
        boolean allPositive = numbers.stream()
            .allMatch(n -> n > 0);
        System.out.println("allPositive = " + allPositive);
        System.out.println();

        System.out.println("13. noneMatch - 조건을 만족하는 요소가 없는지");
        boolean noNegative = numbers.stream()
            .noneMatch(n -> n < 0);
        System.out.println("noNegative = " + noNegative);

    }

}
