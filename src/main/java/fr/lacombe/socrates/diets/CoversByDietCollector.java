package fr.lacombe.socrates.diets;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.UNORDERED;
import static java.util.stream.Collectors.toMap;

class CoversByDietCollector implements Collector<Diet, Map<Diet, Integer>, CoversByDiet> {

    @Override
    public Supplier<Map<Diet, Integer>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Diet, Integer>, Diet> accumulator() {
        return (map, diet) -> map.put(diet, map.computeIfAbsent(diet, key -> 0) + 1);
    }

    @Override
    public BinaryOperator<Map<Diet, Integer>> combiner() {
        return (first, second) -> Stream.of(first, second)
                .flatMap(map -> map.entrySet().stream())
                .collect(toMap(Entry::getKey, Entry::getValue, Integer::sum));
    }

    @Override
    public Function<Map<Diet, Integer>, CoversByDiet> finisher() {
        return CoversByDiet::of;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(UNORDERED, CONCURRENT);
    }
}
