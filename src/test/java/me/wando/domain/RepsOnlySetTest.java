package me.wando.domain;

import org.junit.Test;

import static me.wando.domain.SetTestConstants.DROP_SET_MARKER;
import static me.wando.domain.SetTestConstants.EMPTY;
import static me.wando.domain.SetTestConstants.FAILURE_MARKER;
import static me.wando.domain.SetTestConstants.NEW_LINE;
import static me.wando.domain.SetTestConstants.REPS;
import static me.wando.domain.SetTestConstants.TWELVE;
import static me.wando.domain.SetTestConstants.ZERO;
import static me.wando.enumeration.SetType.DROP_SET;
import static me.wando.enumeration.SetType.FAILURE;
import static me.wando.enumeration.SetType.NORMAL;
import static me.wando.enumeration.SetType.WARM_UP;
import static org.junit.Assert.assertEquals;

public class RepsOnlySetTest {

    @Test
    public void testToString_Normal() {
        RepsOnlySet set = new RepsOnlySet();

        set.setReps(TWELVE);
        set.setSetType(NORMAL);

        System.out.println(set);

        assertEquals(TWELVE + REPS + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_DropSet() {
        RepsOnlySet set = new RepsOnlySet();

        set.setReps(TWELVE);
        set.setSetType(DROP_SET);

        assertEquals(TWELVE + REPS + DROP_SET_MARKER + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_Failure() {
        RepsOnlySet set = new RepsOnlySet();

        set.setReps(TWELVE);
        set.setSetType(FAILURE);

        assertEquals(TWELVE + REPS + FAILURE_MARKER + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_WarmUp() {
        RepsOnlySet set = new RepsOnlySet();

        set.setReps(TWELVE);
        set.setSetType(WARM_UP);

        assertEquals(EMPTY, set.toString());
    }

    @Test
    public void testToString_NoSetType() {
        RepsOnlySet set = new RepsOnlySet();

        set.setReps(TWELVE);

        assertEquals(TWELVE + REPS + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoReps() {
        RepsOnlySet set = new RepsOnlySet();

        set.setSetType(NORMAL);

        assertEquals(ZERO + REPS + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoRepsOrSetType() {
        RepsOnlySet set = new RepsOnlySet();

        assertEquals(ZERO + REPS + NEW_LINE, set.toString());
    }
}
