package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GeneticAlgorithm implements ProblemSolver {
    @Override
    public List<Dame> solve(int iterations, List<Dame> damen) {
        List<Dame> generation = damen;
        for (int i = 0; i < iterations; i++) {
            List<Dame> successors = naturalSelection(generation);
            List<Dame> mutatedClones = successors.stream().map(dame -> dame.mutate()).collect(Collectors.toList());
            generation.clear();
            generation.addAll(successors);
            generation.addAll(mutatedClones);
        }
        return generation;
    }

    private List<Dame> naturalSelection(List<Dame> damen) {
        Collections.shuffle(damen);
        List<Dame> successors = new LinkedList<>();
        for (int i = 0; i < damen.size(); i+=2) {
            Dame challenger = damen.get(i);
            Dame defender = damen.get(i + 1);
            successors.add(challenger.getFitness(damen) > defender.getFitness(damen) ? challenger : defender);
        }
        return successors;
    }
}
