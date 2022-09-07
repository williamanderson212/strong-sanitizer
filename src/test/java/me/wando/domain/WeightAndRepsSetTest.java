package me.wando.domain;

import me.wando.enumeration.SetType;
import me.wando.enumeration.WeightType;
import org.junit.Test;

import static me.wando.domain.SetTestConstants.DROP_SET_MARKER;
import static me.wando.domain.SetTestConstants.EMPTY;
import static me.wando.domain.SetTestConstants.FAILURE_MARKER;
import static me.wando.domain.SetTestConstants.FIFTEEN_POINT_TWENTY_ONE;
import static me.wando.domain.SetTestConstants.KG;
import static me.wando.domain.SetTestConstants.NEW_LINE;
import static me.wando.domain.SetTestConstants.TWELVE;
import static me.wando.domain.SetTestConstants.TWELVE_POINT_ZERO;
import static me.wando.domain.SetTestConstants.X;
import static me.wando.domain.SetTestConstants.ZERO;
import static me.wando.domain.SetTestConstants.ZERO_POINT_ZERO;
import static org.junit.Assert.assertEquals;

public class WeightAndRepsSetTest {

    @Test
    public void testToString_Normal() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.NORMAL);
        set.setWeightType(WeightType.NORMAL);
        set.setWeight(FIFTEEN_POINT_TWENTY_ONE);
        set.setReps(TWELVE);

        System.out.println(set);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KG + X + TWELVE + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_Assisted() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.NORMAL);
        set.setWeightType(WeightType.ASSISTED);
        set.setWeight(FIFTEEN_POINT_TWENTY_ONE);
        set.setReps(TWELVE);

        assertEquals(WeightType.ASSISTED.getStringValue() + FIFTEEN_POINT_TWENTY_ONE + KG + X + TWELVE + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_Weighted() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.NORMAL);
        set.setWeightType(WeightType.WEIGHTED);
        set.setWeight(FIFTEEN_POINT_TWENTY_ONE);
        set.setReps(TWELVE);

        assertEquals(WeightType.WEIGHTED.getStringValue() + FIFTEEN_POINT_TWENTY_ONE + KG + X + TWELVE + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoWeightType() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.NORMAL);
        set.setWeight(FIFTEEN_POINT_TWENTY_ONE);
        set.setReps(TWELVE);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KG + X + TWELVE + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_DropSet() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.DROP_SET);
        set.setWeightType(WeightType.NORMAL);
        set.setWeight(FIFTEEN_POINT_TWENTY_ONE);
        set.setReps(TWELVE);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KG + X + TWELVE + DROP_SET_MARKER + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_Failure() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.FAILURE);
        set.setWeightType(WeightType.NORMAL);
        set.setWeight(FIFTEEN_POINT_TWENTY_ONE);
        set.setReps(TWELVE);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KG + X + TWELVE + FAILURE_MARKER + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_WarmUp() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.WARM_UP);
        set.setWeightType(WeightType.NORMAL);
        set.setWeight(FIFTEEN_POINT_TWENTY_ONE);
        set.setReps(TWELVE);

        assertEquals(EMPTY, set.toString());
    }

    @Test
    public void testToString_NoSetType() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setWeightType(WeightType.NORMAL);
        set.setWeight(FIFTEEN_POINT_TWENTY_ONE);
        set.setReps(TWELVE);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KG + X + TWELVE + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_IntegerWeight() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.NORMAL);
        set.setWeightType(WeightType.NORMAL);
        set.setWeight(TWELVE);
        set.setReps(TWELVE);

        assertEquals(TWELVE_POINT_ZERO + KG + X + TWELVE + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoWeight() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.NORMAL);
        set.setWeightType(WeightType.NORMAL);
        set.setReps(TWELVE);

        assertEquals(ZERO_POINT_ZERO + KG + X + TWELVE + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoReps() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.NORMAL);
        set.setWeightType(WeightType.NORMAL);
        set.setWeight(FIFTEEN_POINT_TWENTY_ONE);

        assertEquals(FIFTEEN_POINT_TWENTY_ONE + KG + X + ZERO + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoWeightOrReps() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setSetType(SetType.NORMAL);
        set.setWeightType(WeightType.NORMAL);

        assertEquals(ZERO_POINT_ZERO + KG + X + ZERO + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoWeightOrRepsOrSetType() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        set.setWeightType(WeightType.NORMAL);

        assertEquals(ZERO_POINT_ZERO + KG + X + ZERO + NEW_LINE, set.toString());
    }

    @Test
    public void testToString_NoWeightOrRepsOrSetTypeOrWeightType() {
        WeightAndRepsSet set = new WeightAndRepsSet();

        assertEquals(ZERO_POINT_ZERO + KG + X + ZERO + NEW_LINE, set.toString());
    }
}
