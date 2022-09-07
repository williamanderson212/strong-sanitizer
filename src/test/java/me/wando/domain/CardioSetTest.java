package me.wando.domain;

import org.junit.Test;

import static me.wando.domain.SetTestConstants.BAR;
import static me.wando.domain.SetTestConstants.COLON;
import static me.wando.domain.SetTestConstants.DROP_SET_MARKER;
import static me.wando.domain.SetTestConstants.EMPTY;
import static me.wando.domain.SetTestConstants.FAILURE_MARKER;
import static me.wando.domain.SetTestConstants.FIFTEEN_POINT_TWENTY_ONE;
import static me.wando.domain.SetTestConstants.FIVE;
import static me.wando.domain.SetTestConstants.KM;
import static me.wando.domain.SetTestConstants.NEW_LINE;
import static me.wando.domain.SetTestConstants.TEN;
import static me.wando.domain.SetTestConstants.TWELVE;
import static me.wando.domain.SetTestConstants.TWELVE_POINT_ZERO;
import static me.wando.domain.SetTestConstants.ZERO;
import static me.wando.domain.SetTestConstants.ZERO_POINT_ZERO;
import static me.wando.enumeration.SetType.DROP_SET;
import static me.wando.enumeration.SetType.FAILURE;
import static me.wando.enumeration.SetType.NORMAL;
import static me.wando.enumeration.SetType.WARM_UP;
import static org.junit.Assert.assertEquals;

public class CardioSetTest {

    @Test
    public void testToString_Normal() {
        CardioSet set = new CardioSet();

        set.setSetType(NORMAL);
        set.setDistance(FIFTEEN_POINT_TWENTY_ONE);
        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        System.out.println(set);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KM + BAR + TWELVE + COLON + TEN + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_DropSet() {
        CardioSet set = new CardioSet();

        set.setSetType(DROP_SET);
        set.setDistance(FIFTEEN_POINT_TWENTY_ONE);
        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KM + BAR + TWELVE + COLON + TEN + DROP_SET_MARKER + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_Failure() {
        CardioSet set = new CardioSet();

        set.setSetType(FAILURE);
        set.setDistance(FIFTEEN_POINT_TWENTY_ONE);
        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KM + BAR + TWELVE + COLON + TEN + FAILURE_MARKER + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_WarmUp() {
        CardioSet set = new CardioSet();

        set.setSetType(WARM_UP);
        set.setDistance(FIFTEEN_POINT_TWENTY_ONE);
        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        assertEquals(EMPTY, set.toString());
    }

    @Test
    public void testToString_NoSetType() {
        CardioSet set = new CardioSet();

        set.setDistance(FIFTEEN_POINT_TWENTY_ONE);
        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KM + BAR + TWELVE + COLON + TEN + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_SingleDigitSeconds() {
        CardioSet set = new CardioSet();

        set.setSetType(NORMAL);
        set.setDistance(FIFTEEN_POINT_TWENTY_ONE);
        set.setMinutes(TWELVE);
        set.setSeconds(FIVE);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KM + BAR + TWELVE + COLON + ZERO + FIVE + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_IntegerDistance() {
        CardioSet set = new CardioSet();

        set.setSetType(NORMAL);
        set.setDistance(TWELVE);
        set.setMinutes(TWELVE);
        set.setSeconds(FIVE);

        assertEquals(TWELVE_POINT_ZERO + KM + BAR + TWELVE + COLON + ZERO + FIVE + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoDistance() {
        CardioSet set = new CardioSet();

        set.setSetType(NORMAL);
        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        assertEquals(ZERO_POINT_ZERO + KM + BAR + TWELVE + COLON + TEN + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoMinutes() {
        CardioSet set = new CardioSet();

        set.setSetType(NORMAL);
        set.setDistance(FIFTEEN_POINT_TWENTY_ONE);
        set.setSeconds(TEN);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KM + BAR + ZERO + COLON + TEN + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoSeconds() {
        CardioSet set = new CardioSet();

        set.setSetType(NORMAL);
        set.setDistance(FIFTEEN_POINT_TWENTY_ONE);
        set.setMinutes(TWELVE);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KM + BAR + TWELVE + COLON + ZERO + ZERO + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoMinutesOrSeconds() {
        CardioSet set = new CardioSet();

        set.setSetType(NORMAL);
        set.setDistance(FIFTEEN_POINT_TWENTY_ONE);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KM + BAR + ZERO + COLON + ZERO + ZERO + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoMinutesOrSecondsOrDistance() {
        CardioSet set = new CardioSet();

        set.setSetType(NORMAL);

        assertEquals(ZERO_POINT_ZERO + KM + BAR + ZERO + COLON + ZERO + ZERO + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoMinutesOrSecondsOrDistanceOrSetType() {
        CardioSet set = new CardioSet();

        assertEquals(ZERO_POINT_ZERO + KM + BAR + ZERO + COLON + ZERO + ZERO + NEW_LINE, set.toString());
    }
}
