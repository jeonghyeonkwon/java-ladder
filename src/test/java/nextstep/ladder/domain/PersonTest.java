package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    void 이름_5자_이상_예외() {

        assertThatThrownBy(
                () -> new Person("jeonghyeon")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_예외() {
        assertThatThrownBy(
                () -> new Person(" ")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
