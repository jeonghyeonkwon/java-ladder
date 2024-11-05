package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.LadderMethod.toLines;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {

    @DisplayName("Persons와 Results 사이즈 같지 않으면 예외")
    @Test
    void size_exception() {
        Persons persons = new Persons(new String[]{
                "a", "b", "c"
        });

        List<Ladder> create = List.of(
                new Ladder(toLines(List.of(false, true))),
                new Ladder(toLines(List.of(true, false)))
        );
        Ladders ladders = Ladders.of(create);
        Results results = new Results(new String[]{
                "꽝", "1000"
        });

        assertThatIllegalArgumentException().isThrownBy(
                () -> LadderGame.result(persons, ladders, results)
        );

    }
}
