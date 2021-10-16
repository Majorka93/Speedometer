import org.junit.Assert;
import org.junit.Test;
import ru.major.speedometer.Point;

public class PointsTest {

    Point point = new Point("55.601452,37.722566");
    Point point2 = new Point("190.601452,37.722566");
    Point point3 = new Point("95.601452,37.722566");
    Point point4 = new Point("95.601452,185.722566");

    @Test
    public void isInRangeTest() {

        Assert.assertTrue(point.isInRange());
        Assert.assertFalse(point2.isInRange());
        Assert.assertFalse(point3.isInRange());
        Assert.assertFalse(point4.isInRange());


    }


}
