package probs.samsung.day01.prob19;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static probs.samsung.day01.prob19.Zzaero.*;
import static probs.samsung.day01.prob19.Zzaero.DIRECTIONS;
import static probs.samsung.day01.prob19.Zzaero.RIGHT;
import static probs.samsung.day01.prob19.Zzaero.UP;

public class ZzaeroTest {

    private char[][] stringArray2Char2dArray(List<String> strArray) {
        int rowCount = strArray.size();
        int colCount = strArray.get(0).length();
        char[][] char2dArray = new char[rowCount][colCount];

        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                char2dArray[rowIdx][colIdx] = strArray.get(rowIdx).charAt(colIdx);
            }
        }

        return char2dArray;
    }

    @Test
    public void getMinimumNumOfTrials() {
//        List<String> givenRawmap = new ArrayList<>();
//        givenRawmap.add("#####");
//        givenRawmap.add("#..B#");
//        givenRawmap.add("#.#.#");
//        givenRawmap.add("#RO.#");
//        givenRawmap.add("#####");
//
//        char[][] givenMap = stringArray2Char2dArray(givenRawmap);
//
//        int minimumNumOfTrials
//                = Zzaero.getMinimumNumOfTrials(givenMap);
//
//        assertEquals(1, minimumNumOfTrials);
    }

    @Test
    public void executeTilt_1() {
        List<String> givenRawmap = new ArrayList<>();
        givenRawmap.add("#####");
        givenRawmap.add("#...#");
        givenRawmap.add("#.#.#");
        givenRawmap.add("#.O.#");
        givenRawmap.add("#####");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);
        int[] direction = DIRECTIONS[UP];

        Zzaero.TwoValue<Integer, Integer> anotherBallLocation
                = new Zzaero.TwoValue<>(1, 3);

        Zzaero.TwoValue<Integer, Integer> ballLocation
                = new Zzaero.TwoValue<>(3, 1);

        Zzaero.TwoValue<Integer, Integer> tilted
                = Zzaero.executeTilt(givenMap, ballLocation, anotherBallLocation, direction);

        int tiltedX = tilted.val1;
        int tiltedY = tilted.val2;
        assertEquals(1, tiltedX);
        assertEquals(1, tiltedY);
    }

    @Test
    public void executeTilt_2() {
        List<String> givenRawmap = new ArrayList<>();
        givenRawmap.add("#####");
        givenRawmap.add("#...#");
        givenRawmap.add("#.#.#");
        givenRawmap.add("#.O.#");
        givenRawmap.add("#####");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);
        int[] direction = DIRECTIONS[RIGHT];

        Zzaero.TwoValue<Integer, Integer> anotherBallLocation
                = new Zzaero.TwoValue<>(1, 3);

        Zzaero.TwoValue<Integer, Integer> ballLocation
                = new Zzaero.TwoValue<>(3, 1);

        Zzaero.TwoValue<Integer, Integer> tilted
                = Zzaero.executeTilt(givenMap, ballLocation, anotherBallLocation, direction);

        int tiltedX = tilted.val1;
        int tiltedY = tilted.val2;
        assertEquals(2, tiltedX);
        assertEquals(3, tiltedY);
    }

    @Test
    public void executeTilt1() {
    }

    @Test
    public void getInitialStateAndCleanMap() {
    }

    @Test
    public void getState() {
    }
}