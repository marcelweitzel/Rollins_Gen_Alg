package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Damenproblem {
    private List<Dame> damen;
    private ProblemSolver solver;

    public Damenproblem(ProblemSolver solver) {
        this.solver = solver;
    }

    public static void main(String[] args) {
        Damenproblem damenproblem = new Damenproblem(new GeneticAlgorithm());
        damenproblem.printBoard(damenproblem.solve(), 8);

    }

    public List<Dame> solve() {
        List<Dame> damen = new LinkedList<>();
        int boardSize = 8;
        for (int i = 0; i < boardSize; i++) {
            damen.add(new Dame(boardSize));
        }
        return solver.solve(30000, damen);
    }

    public void printBoard(List<Dame> damen, int boardSize) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < boardSize*boardSize; i++) {
            stringBuilder.append("#");
        }
        String board = stringBuilder.toString();
        char[] boardChars = board.toCharArray();
        damen.forEach((Dame dame) -> boardChars[dame.getPosX() + dame.getPosY() * boardSize] = 'X');
        board = new String(boardChars);
        for (int i = 0; i < boardSize; i++) {
            System.out.println(board.substring(i*boardSize, i*boardSize+boardSize));
        }
        damen.forEach(dame -> System.out.println(dame.getFitness(damen)));
    }
}
