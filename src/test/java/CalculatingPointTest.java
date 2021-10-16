import org.junit.Assert;
import org.junit.Test;
import ru.major.speedometer.Calculating;
import ru.major.speedometer.CalculatingPoint;
import ru.major.speedometer.Point;

public class CalculatingPointTest {

    @Test
    public void minusTest() {
        CalculatingPoint point1 = new CalculatingPoint("55.601452,37.722566");
        CalculatingPoint point2 = new CalculatingPoint("55.601452,37.722566");

        point2.minus(point1);
        Assert.assertEquals(0.0, point2.getLat(), 0.00001);
        Assert.assertEquals(0.0, point2.getLng(), 0.00001);
        point2 = new CalculatingPoint("55.601452,37.722566");
        point1.minus(point2);
        Assert.assertEquals(0.0, point1.getLat(), 0.00001);
        Assert.assertEquals(0.0, point1.getLng(), 0.00001);

        point1 = new CalculatingPoint("55.601452,37.722566");
        point2 = new CalculatingPoint("57.601452,38.722566");
        point2.minus(point1);
        Assert.assertEquals(2,point2.getLat(),0.00000001);
        Assert.assertEquals(1,point2.getLng(),0.00000001);


    }


}
