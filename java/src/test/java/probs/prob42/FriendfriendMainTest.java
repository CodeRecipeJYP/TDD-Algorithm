package probs.prob42;

import org.junit.Test;
import probs.utils.FileioUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class FriendfriendMainTest {

//    @Test
    public void main() {
        try {
            System.setIn(new FileInputStream("src/test/java/probs/prob42/case01.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FriendfriendMain.main(null);
//        FileioUtils.checkWith(FriendfriendMain.class, "prob42", "case01");
    }
}