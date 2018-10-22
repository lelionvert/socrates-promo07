package fr.lacombe.socrates.covers;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.Collections.unmodifiableSet;
import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class Diets {
	
	private static final Collector<Diet, List<Diet>, Diets> COLLECTOR = new DietsCollector();
	
	private final Map<Diet, Long> diets;
	
	private Diets(final Map<Diet, Long> diets) {
		this.diets = diets;
	}
	
	static Diets of(final Map<Diet, Long> diets) {
		return new Diets(diets);
	}
	
	static Collector<Diet, List<Diet>, Diets> collector() {
		return COLLECTOR;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Diets diets1 = (Diets) o;
		return Objects.equals(diets, diets1.diets);
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(diets);
	}
	
	@Override
	public String toString() {
		return diets.toString();
	}
	
	private static class DietsCollector implements Collector<Diet, List<Diet>, Diets> {
		
		@Override
		public Supplier<List<Diet>> supplier() {
			return ArrayList::new;
		}
		
		@Override
		public BiConsumer<List<Diet>, Diet> accumulator() {
			return List::add;
		}
		
		@Override
		public BinaryOperator<List<Diet>> combiner() {
			return (first, second) -> {
				first.addAll(second);
				return first;
			};
		}
		
		@Override
		public Function<List<Diet>, Diets> finisher() {
			return diets -> new Diets(diets.stream().collect(groupingBy(diet -> diet, counting())));
		}
		
		@Override
		public Set<Characteristics> characteristics() {
			return unmodifiableSet(EnumSet.of(
				CONCURRENT
			));
		}
	}
}
