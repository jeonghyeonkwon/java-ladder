package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {
    private static final String HEIGHT_UNIT = "|";
    private static final String VERTICAL_LINE_UNIT = "-";
    private static final String VERTICAL_EMPTY_UNIT = " ";
    private static final String RESULT_MESSAGE = "실행결과";



    public static void print(Persons persons, Ladders ladders) {
        System.out.println(RESULT_MESSAGE);
        int lengthCount = persons.getPersons().stream()
                .map(person -> person.getLength())
                .max(Integer::compareTo)
                .orElse(0) + 2;
        printPersons(lengthCount, persons);
        printLadder(lengthCount, ladders);
    }

    private static void printPersons(int maxLength, Persons persons) {
        persons.getPersons().forEach(person -> System.out.print(personText(maxLength, person)));
        System.out.println();
    }

    private static String personText(int maxLength, Person person) {
        return Stream.generate(() -> VERTICAL_EMPTY_UNIT)
                .limit(maxLength - person.getLength())
                .collect(Collectors.joining()) + person.getName();
    }

    private static void printLadder(int maxLength, Ladders ladders) {
        printHeight(maxLength, ladders.getLadders());
    }

    private static void printHeight(int maxLength, List<Ladder> heights) {
        for (Ladder height : heights) {
            printVerticals(maxLength, height.getLines());
            System.out.println();
        }
    }

    private static void printVerticals(int maxLength, List<Boolean> vertical) {
        System.out.print(startLadder(maxLength));
        vertical.stream()
                .map(isLine -> isLine ? createVertical(maxLength) : createEmpty(maxLength))
                .forEach(unit -> printVertical(unit));
    }

    private static void printVertical(String unit) {
        System.out.print(unit);
    }

    private static String startLadder(int maxLength) {
        return Stream.generate(() -> VERTICAL_EMPTY_UNIT)
                .limit(maxLength - 1)
                .collect(Collectors.joining()) + HEIGHT_UNIT;
    }

    private static String createVertical(int maxLength) {
        return Stream.generate(() -> VERTICAL_LINE_UNIT)
                .limit(maxLength - 1)
                .collect(Collectors.joining()) + HEIGHT_UNIT;
    }

    private static String createEmpty(int maxLength) {
        return Stream.generate(() -> VERTICAL_EMPTY_UNIT)
                .limit(maxLength - 1)
                .collect(Collectors.joining()) + HEIGHT_UNIT;
    }

}
