package probs.prob35;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class EscapeBall2MainTest {

//    @Test
//    public void main_1() throws IOException {
//        for (int caseIdx = 1; caseIdx <= 7; caseIdx++) {
//            String prefix = "src/main/java/probs/prob35/case0" + caseIdx;
//
//            System.setIn(new FileInputStream(prefix + ".in"));
//
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            System.setOut(new PrintStream(byteArrayOutputStream));
//
//            EscapeBall2Main.main(null);
//            String actual = byteArrayOutputStream.toString();
//
//            Scanner scanner = new Scanner(new FileInputStream(prefix + ".out"));
//            String expected = scanner.nextLine();
//        }
//    }

    @Test
    public void main_2() throws IOException {
        String prefix = "src/main/java/probs/prob35/case07";

        System.setIn(new FileInputStream(prefix + ".in"));

        EscapeBall2Main.main(null);
    }
}