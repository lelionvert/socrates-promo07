package fr.lacombe.socrates.covers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CoversApplication {

    public static void main(final String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java -jar application.jar meals.csv participants.csv");
            System.exit(-1);
        }

        final List<Meal> meals = parseMeals(args[0]);
        final List<Participant> participants = parseParticipants(args[1]);

        final List<Covers> covers = Meals.calculateCovers(participants, meals);
        System.out.println(covers);
    }

    private static List<Meal> parseMeals(final String csvPath) throws IOException {
        return Files.readAllLines(Paths.get(csvPath))
                .stream()
                .map(CoversApplication::toMeal)
                .collect(toList());
    }

    private static Meal toMeal(final String csvLine) {
        final String[] mealPeriod = csvLine.split(",");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return Meal.of(Period.of(
                LocalDateTime.parse(mealPeriod[0], formatter),
                LocalDateTime.parse(mealPeriod[1], formatter)
        ));
    }


    private static List<Participant> parseParticipants(final String csvPath) throws IOException {
        return Files.readAllLines(Paths.get(csvPath))
                .stream()
                .map(CoversApplication::toParticipant)
                .collect(toList());
    }

    private static Participant toParticipant(final String csvLine) {
        final String[] participantData = csvLine.split(",");
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return Participant.of(
                Period.of(
                        LocalDateTime.parse(participantData[0], formatter),
                        LocalDateTime.parse(participantData[1], formatter)
                ),
                Diet.valueOf(participantData[2])
        );
    }
}