package ru.javatrain.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance () {
        Point p1 = new Point(4, 5);
        Point p2 = new Point(6, 1);
        Assert.assertEquals(Point.distance(p1, p2), 4.47213595499958);
    }
}
