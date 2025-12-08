package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import optional.model.Delivery;
import optional.model.Order;

// 배송정보가 null 이거나 cancel 인 경우 배송 x 표시
public class DeliveryMain {

    static Map<Long, Order> orderRepository = new HashMap<>();

    static {
        orderRepository.put(1L, new Order(1L, new Delivery("배송완료", false)));
        orderRepository.put(2L, new Order(2L, new Delivery("배송중", false)));
        orderRepository.put(3L, new Order(3L, new Delivery("배송중", true)));
        orderRepository.put(4L, new Order(4L, null));
    }

    static void main() {
        System.out.println("1 = " + getDeliveryStatus(1L));
        System.out.println("2 = " + getDeliveryStatus(2L));
        System.out.println("3 = " + getDeliveryStatus(3L));
        System.out.println("4 = " + getDeliveryStatus(4L));
    }

    private static String getDeliveryStatus(long orderId) {

        return findOrder(orderId)
            .map(Order::getDelivery)                            // map 으로 Delivery 를 꺼내고 ( empty 일 경우 이후 작업 x )
            .filter(delivery -> !delivery.isCanceled()) // isCanceled 값이 false 일 경우
            .map(Delivery::getStatus)                           // Status 값을 반환
            .orElse("배송 X");                                   // map - filter - map 에서 empty 로 설정된 경우 배송x 반환
    }

    static Optional<Order> findOrder(Long orderId) {
        return Optional.ofNullable(orderRepository.get(orderId));
    }

}
