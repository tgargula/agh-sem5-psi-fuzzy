package pl.edu.student.tgargula.fuzzify;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.util.Collections;
import java.util.List;

public class Fuzzy {
    private final FIS fis;

    public Fuzzy(String filename) {
        this.fis = FIS.load(filename, false);
    }

    public void showFuzzyCharts() {
        JFuzzyChart.get().chart(fis);
    }

    public void showDefuzzyChart() {
        Variable v = fis.getVariable("velocity");
        JFuzzyChart.get().chart(v, v.getDefuzzifier(), true);
    }

    public void setVariables(double leftDistance, double rightDistance, double position) {
        fis.setVariable("leftDistance", leftDistance);
        fis.setVariable("rightDistance", rightDistance);
        fis.setVariable("position", position);
        fis.evaluate();
    }

    public int getSpeed() {
        Variable v = fis.getVariable("velocity");
        List<String> termNames = List.of("fastLeft", "slowLeft", "stay", "slowRight", "fastRight");
        List<Double> terms = termNames.stream().map(v::getMembership).toList();
        int idx = terms.indexOf(Collections.max(terms));
        return switch (idx) {
            case 0 -> Constant.LEFT_FAST_SPEED;
            case 1 -> Constant.LEFT_SLOW_SPEED;
            case 2 -> 0;
            case 3 -> Constant.RIGHT_SLOW_SPEED;
            case 4 -> Constant.RIGHT_FAST_SPEED;
            default -> throw new IndexOutOfBoundsException("Index out of bounds.");
        };
    }
}
