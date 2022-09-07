package me.wando.domain;

import org.junit.Test;

import static me.wando.domain.SetTestConstants.COLON;
import static me.wando.domain.SetTestConstants.DROP_SET_MARKER;
import static me.wando.domain.SetTestConstants.EMPTY;
import static me.wando.domain.SetTestConstants.FAILURE_MARKER;
import static me.wando.domain.SetTestConstants.FIVE;
import static me.wando.domain.SetTestConstants.NEW_LINE;
import static me.wando.domain.SetTestConstants.TEN;
import static me.wando.domain.SetTestConstants.TWELVE;
import static me.wando.domain.SetTestConstants.ZERO;
import static me.wando.enumeration.SetType.DROP_SET;
import static me.wando.enumeration.SetType.FAILURE;
import static me.wando.enumeration.SetType.NORMAL;
import static me.wando.enumeration.SetType.WARM_UP;
import static org.junit.Assert.assertEquals;

public class DurationOnlySetTest {

    @Test
    public void testToString_Normal() {
        DurationOnlySet set = new DurationOnlySet();

        set.setSetType(NORMAL);
        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        System.out.println(set);

        assertEquals(TWELVE + COLON + TEN + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_DropSet() {
        DurationOnlySet set = new DurationOnlySet();

        set.setSetType(DROP_SET);
        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        assertEquals(TWELVE + COLON + TEN + DROP_SET_MARKER + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_Failure() {
        DurationOnlySet set = new DurationOnlySet();

        set.setSetType(FAILURE);
        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        assertEquals(TWELVE + COLON + TEN + FAILURE_MARKER + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_WarmUp() {
        DurationOnlySet set = new DurationOnlySet();

        set.setSetType(WARM_UP);
        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        assertEquals(EMPTY, set.toString());
    }

    @Test
    public void testToString_NoSetType() {
        DurationOnlySet set = new DurationOnlySet();

        set.setMinutes(TWELVE);
        set.setSeconds(TEN);

        assertEquals(TWELVE + COLON + TEN + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_SingleDigitSeconds() {
        DurationOnlySet set = new DurationOnlySet();

        set.setSetType(NORMAL);
        set.setMinutes(TWELVE);
        set.setSeconds(FIVE);

        assertEquals(TWELVE + COLON + ZERO + FIVE + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoMinutes() {
        DurationOnlySet set = new DurationOnlySet();

        set.setSetType(NORMAL);
        set.setSeconds(TEN);

        assertEquals(ZERO + COLON + TEN + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoSeconds() {
        DurationOnlySet set = new DurationOnlySet();

        set.setSetType(NORMAL);
        set.setMinutes(TWELVE);

        assertEquals(TWELVE + COLON + ZERO + ZERO + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoMinutesOrSeconds() {
        DurationOnlySet set = new DurationOnlySet();

        set.setSetType(NORMAL);

        assertEquals(ZERO + COLON + ZERO + ZERO + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoMinutesOrSecondsOrSetType() {
        DurationOnlySet set = new DurationOnlySet();

        assertEquals(ZERO + COLON + ZERO + ZERO + NEW_LINE, set.toString());
    }
}
