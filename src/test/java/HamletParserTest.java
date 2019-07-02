import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testFindHoratio() {
        Integer expected = 158;
        Integer actual = hamletParser.count("Horatio",hamletText);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHamlet() {
        Integer expected = 472;
        Integer actual = hamletParser.count("Hamlet",hamletText);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testChangeHamletToLeon() {
        Integer before = hamletParser.count("Hamlet",hamletText);
        String after = hamletParser.replace("Hamlet","Leon");
        Integer leonAfter = hamletParser.count("Leon",after);
        Integer hamletAfter = hamletParser.count("Hamlet",after);
   //     Assert.assertEquals(hamletText,after+" ");
        Assert.assertEquals(before,leonAfter);
        Integer expected=0;
        Assert.assertEquals(expected,hamletAfter);
    }

    @Test
    public void testChangeHoratioToTariq() {
        Integer before = hamletParser.count("Horatio",hamletText);
        String after = hamletParser.replace("Horatio","Tariq");
        Integer leonAfter = hamletParser.count("Tariq",after);
        Integer hamletAfter = hamletParser.count("Horatio",after);
        Assert.assertEquals(before,leonAfter);
        Integer expected=0;
        Assert.assertEquals(expected,hamletAfter);
    }
}