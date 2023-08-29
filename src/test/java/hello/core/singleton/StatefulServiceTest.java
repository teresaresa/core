package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("스프링 빈은 항상 무상태(stateless)로 설계해야한다는 것을 알게 하기 위한 역설")
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A 사용자가 10000원을 주문
        statefulService1.order("userA", 10000);
        // ThreadA : B 사용자가 20000원을 주문
        statefulService2.order("userA", 20000);

        // ThreadA: 사용자A가 주문 금액을 조회한다
        int price = statefulService1.getPrice();
        Assertions.assertThat(price).isNotEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}