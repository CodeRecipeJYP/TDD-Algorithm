package probs.samsung_day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Samsung02Test {
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
    public void getPassableWayCount() {
        List<String> givenRawmap = new ArrayList<>();

        givenRawmap.add("333333");
        givenRawmap.add("233333");
        givenRawmap.add("222323");
        givenRawmap.add("111222");
        givenRawmap.add("111331");
        givenRawmap.add("112332");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(3, Samsung02.getPassableWayCount(givenMap, 2));

    }

    @Test
    public void getPassableWayCount_2() {
        List<String> givenRawmap = new ArrayList<>();

        givenRawmap.add("321123");
        givenRawmap.add("322123");
        givenRawmap.add("322233");
        givenRawmap.add("333333");
        givenRawmap.add("333322");
        givenRawmap.add("333322");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(7, Samsung02.getPassableWayCount(givenMap, 2));
    }

    @Test
    public void getPassableWayCount_3() {
        List<String> givenRawmap = new ArrayList<>();

        givenRawmap.add("321123");
        givenRawmap.add("322123");
        givenRawmap.add("322233");
        givenRawmap.add("333333");
        givenRawmap.add("333322");
        givenRawmap.add("333322");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(3, Samsung02.getPassableWayCount(givenMap, 3));
    }

    @Test
    public void getPassableWayCount_4() {
        List<String> givenRawmap = new ArrayList<>();

        givenRawmap.add("321123");
        givenRawmap.add("322123");
        givenRawmap.add("322233");
        givenRawmap.add("333333");
        givenRawmap.add("333322");
        givenRawmap.add("333322");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(11, Samsung02.getPassableWayCount(givenMap, 1));
    }

    @Test
    public void isPassable() {
        List<String> givenRawmap = new ArrayList<>();
        givenRawmap.add("333333");
        givenRawmap.add("233333");
        givenRawmap.add("222323");
        givenRawmap.add("111222");
        givenRawmap.add("111331");
        givenRawmap.add("112332");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(true, Samsung02.isPassable(givenMap[0], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[1], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[2], 2));
        assertEquals(true, Samsung02.isPassable(givenMap[3], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[4], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[5], 2));
    }

    @Test
    public void isPassable_2() {
        List<String> givenRawmap = new ArrayList<>();
        givenRawmap.add("111223");
        givenRawmap.add("111233");
        givenRawmap.add("211233");
        givenRawmap.add("332333");
        givenRawmap.add("332233");
        givenRawmap.add("212333");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(true, Samsung02.isPassable(givenMap[0], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[1], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[2], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[3], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[4], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[5], 2));
    }

    @Test
    public void isPassable_3() {
        List<String> givenRawmap = new ArrayList<>();
        givenRawmap.add("322111");
        givenRawmap.add("332111");
        givenRawmap.add("332112");
        givenRawmap.add("333233");
        givenRawmap.add("332233");
        givenRawmap.add("333212");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(true, Samsung02.isPassable(givenMap[0], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[1], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[2], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[3], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[4], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[5], 2));
    }


    @Test
    public void isPassable_2_1() {
        List<String> givenRawmap = new ArrayList<>();
        givenRawmap.add("321123");
        givenRawmap.add("322123");
        givenRawmap.add("322233");
        givenRawmap.add("333333");
        givenRawmap.add("333322");
        givenRawmap.add("333322");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(false, Samsung02.isPassable(givenMap[0], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[1], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[2], 2));
        assertEquals(true, Samsung02.isPassable(givenMap[3], 2));
        assertEquals(true, Samsung02.isPassable(givenMap[4], 2));
        assertEquals(true, Samsung02.isPassable(givenMap[5], 2));
    }

    @Test
    public void isPassable_2_2() {
        List<String> givenRawmap = new ArrayList<>();
        givenRawmap.add("333333");
        givenRawmap.add("222333");
        givenRawmap.add("122333");
        givenRawmap.add("112333");
        givenRawmap.add("223322");
        givenRawmap.add("333322");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(true, Samsung02.isPassable(givenMap[0], 2));
        assertEquals(true, Samsung02.isPassable(givenMap[1], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[2], 2));
        assertEquals(false, Samsung02.isPassable(givenMap[3], 2));
        assertEquals(true, Samsung02.isPassable(givenMap[4], 2));
        assertEquals(true, Samsung02.isPassable(givenMap[5], 2));
    }

    @Test
    public void isPassable_4_1() {
        List<String> givenRawmap = new ArrayList<>();

        givenRawmap.add("321123");
        givenRawmap.add("322123");
        givenRawmap.add("322233");
        givenRawmap.add("333333");
        givenRawmap.add("333322");
        givenRawmap.add("333322");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(true, Samsung02.isPassable(givenMap[0], 1));
        assertEquals(false, Samsung02.isPassable(givenMap[1], 1));
        assertEquals(true, Samsung02.isPassable(givenMap[2], 1));
        assertEquals(true, Samsung02.isPassable(givenMap[3], 1));
        assertEquals(true, Samsung02.isPassable(givenMap[4], 1));
        assertEquals(true, Samsung02.isPassable(givenMap[5], 1));
    }

    @Test
    public void isPassable_4_2() {
        List<String> givenRawmap = new ArrayList<>();

        givenRawmap.add("333333");
        givenRawmap.add("333222");
        givenRawmap.add("333221");
        givenRawmap.add("333211");
        givenRawmap.add("223322");
        givenRawmap.add("223333");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        assertEquals(true, Samsung02.isPassable(givenMap[0], 1));
        assertEquals(true, Samsung02.isPassable(givenMap[1], 1));
        assertEquals(true, Samsung02.isPassable(givenMap[2], 1));
        assertEquals(true, Samsung02.isPassable(givenMap[3], 1));
        assertEquals(true, Samsung02.isPassable(givenMap[4], 1));
        assertEquals(true, Samsung02.isPassable(givenMap[5], 1));
    }

    @Test
    public void getEveryCandidates() {
        List<String> givenRawmap = new ArrayList<>();

        givenRawmap.add("333333");
        givenRawmap.add("233333");
        givenRawmap.add("222323");
        givenRawmap.add("111222");
        givenRawmap.add("111331");
        givenRawmap.add("112332");

        char[][] givenMap = stringArray2Char2dArray(givenRawmap);

        List<char[]> everyCandidates = Samsung02.getEveryCandidates(givenMap);
        everyCandidates = null;
    }
}