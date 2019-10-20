package com.lesson.unittest.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberUtilsUnitTest {

    @Test
    public void should_return_true_when_input_normal_number_string() {
        //given
        String normal = "1234567890";
        //when
        boolean creatable = NumberUtils.isCreatable(normal);
        //then
        Assert.assertTrue(creatable);
    }

    @Test
    public void should_return_false_when_input_normal_string() {
        //given
        String normal = "heLlo world";
        //when
        boolean creatable = NumberUtils.isCreatable(normal);
        //then
        Assert.assertFalse(creatable);
    }

    @Test
    public void should_return_true_when_input_hexadecimal_0x_string() {
        //given
        String hexadecimal = "0x10";
        //when
        boolean creatable = NumberUtils.isCreatable(hexadecimal);
        //then
        Assert.assertTrue(creatable);
    }

    @Test
    public void should_return_true_when_input_hexadecimal_0X_string() {
        //given
        String hexadecimal = "0X10";
        //when
        boolean creatable = NumberUtils.isCreatable(hexadecimal);
        //then
        Assert.assertTrue(creatable);
    }

    @Test
    public void should_return_true_when_input_invalid_hexadecimal_string() {
        //given
        String hexadecimal = "0X";
        String hexadecimal1 = "0x";
        String hexadecimal2 = "0xk";
        String hexadecimal3 = "0xK";
        //when
        boolean creatable = NumberUtils.isCreatable(hexadecimal);
        boolean creatable1 = NumberUtils.isCreatable(hexadecimal1);
        boolean creatable2 = NumberUtils.isCreatable(hexadecimal2);
        boolean creatable3 = NumberUtils.isCreatable(hexadecimal3);
        //then
        Assert.assertFalse(creatable);
        Assert.assertFalse(creatable1);
        Assert.assertFalse(creatable2);
        Assert.assertFalse(creatable3);
    }

    @Test
    public void should_return_true_when_input_long_string() {
        //given
        String longStr1 = "123L";
        String longStr2 = "123l";
        //when
        boolean creatable1 = NumberUtils.isCreatable(longStr1);
        boolean creatable2 = NumberUtils.isCreatable(longStr2);
        //then
        Assert.assertTrue(creatable1);
        Assert.assertTrue(creatable2);
    }

    @Test
    public void should_return_true_when_input_octal_string() {
        //given
        String octalStr = "07";
        //when
        boolean creatable = NumberUtils.isCreatable(octalStr);
        //then
        Assert.assertTrue(creatable);
    }

    @Test
    public void should_return_false_when_input_invalid_octal_string() {
        //given
        String octalStr = "09";
        //when
        boolean creatable = NumberUtils.isCreatable(octalStr);
        //then
        Assert.assertFalse(creatable);
    }

    @Test
    public void should_return_false_when_input_null() {
        //given

        //when
        boolean creatable = NumberUtils.isCreatable(null);
        //then
        Assert.assertFalse(creatable);
    }

    @Test
    public void should_return_false_when_input_empty_string() {
        //given

        //when
        boolean creatable = NumberUtils.isCreatable("");
        //then
        Assert.assertFalse(creatable);
    }

    @Test
    public void should_return_false_when_input_blank_string() {
        //given

        //when
        boolean creatable = NumberUtils.isCreatable("  ");
        //then
        Assert.assertFalse(creatable);
    }

    @Test
    public void should_return_true_when_input_sign_up_front_string() {
        //given

        //when
        boolean creatable = NumberUtils.isCreatable("-123");
        boolean creatable1 = NumberUtils.isCreatable("+123");
        //then
        Assert.assertTrue(creatable);
        Assert.assertTrue(creatable1);
    }

    @Test
    public void should_return_true_when_input_scientific_notation() {
        //given

        //when
        boolean creatable = NumberUtils.isCreatable("1E2");
        boolean creatable1 = NumberUtils.isCreatable("1e2");
        boolean creatable2 = NumberUtils.isCreatable("1e+2");
        boolean creatable3 = NumberUtils.isCreatable("1E+2");
        boolean creatable4 = NumberUtils.isCreatable("1e-2");
        boolean creatable5 = NumberUtils.isCreatable("1E-2");
        boolean creatable6 = NumberUtils.isCreatable("1.3E-2");
        boolean creatable7 = NumberUtils.isCreatable("1.3e-2");
        boolean creatable8 = NumberUtils.isCreatable("1.3E+2");
        boolean creatable9 = NumberUtils.isCreatable("1.3e+2");
        //then
        Assert.assertTrue(creatable);
        Assert.assertTrue(creatable1);
        Assert.assertTrue(creatable2);
        Assert.assertTrue(creatable3);
        Assert.assertTrue(creatable4);
        Assert.assertTrue(creatable5);
        Assert.assertTrue(creatable6);
        Assert.assertTrue(creatable7);
        Assert.assertTrue(creatable8);
        Assert.assertTrue(creatable9);
    }

    @Test
    public void should_return_false_when_input_invalid_scientific_notation() {
        //given

        //when
        boolean creatable = NumberUtils.isCreatable("1ee2");
        boolean creatable1 = NumberUtils.isCreatable("1EE2");
        boolean creatable2 = NumberUtils.isCreatable("EE2");
        boolean creatable3 = NumberUtils.isCreatable("ee2");
        boolean creatable4 = NumberUtils.isCreatable("1e");
        boolean creatable5 = NumberUtils.isCreatable("1E");
        boolean creatable6 = NumberUtils.isCreatable("1E-");
        boolean creatable7 = NumberUtils.isCreatable("1E+");
        boolean creatable8 = NumberUtils.isCreatable("1.E+");
        boolean creatable9 = NumberUtils.isCreatable("1.E+D");
        boolean creatable10 = NumberUtils.isCreatable("1.E+F");
        boolean creatable11 = NumberUtils.isCreatable("1.E+L");

        //then
        Assert.assertFalse(creatable);
        Assert.assertFalse(creatable1);
        Assert.assertFalse(creatable2);
        Assert.assertFalse(creatable3);
        Assert.assertFalse(creatable4);
        Assert.assertFalse(creatable5);
        Assert.assertFalse(creatable6);
        Assert.assertFalse(creatable7);
        Assert.assertFalse(creatable8);
        Assert.assertFalse(creatable9);
        Assert.assertFalse(creatable10);
        Assert.assertFalse(creatable11);
    }

    @Test
    public void should_return_false_when_input_invalid_string_with_decimal_points() {
        //given

        //when
        boolean creatable = NumberUtils.isCreatable("0..1");
        boolean creatable1 = NumberUtils.isCreatable("0.1.");
        boolean creatable2 = NumberUtils.isCreatable("0.1.F");
        boolean creatable3 = NumberUtils.isCreatable("0.1L");
        boolean creatable4 = NumberUtils.isCreatable("0.1l");

        //then
        Assert.assertFalse(creatable);
        Assert.assertFalse(creatable1);
        Assert.assertFalse(creatable2);
        Assert.assertFalse(creatable3);
        Assert.assertFalse(creatable4);

    }

    @Test
    public void should_return_true_when_input_valid_string_with_decimal_points() {
        //given

        //when
        boolean creatable = NumberUtils.isCreatable("0.123");
        boolean creatable2 = NumberUtils.isCreatable(".01");
        boolean creatable3 = NumberUtils.isCreatable("1.");
        //then

        Assert.assertTrue(creatable);
        Assert.assertTrue(creatable2);
        Assert.assertTrue(creatable3);
    }

    @Test
    public void should_return_false_when_input_other_invalid_string() {
        //given

        //when
        boolean creatable = NumberUtils.isCreatable("3+3");
        boolean creatable1 = NumberUtils.isCreatable("3-3");
        boolean creatable2 = NumberUtils.isCreatable("13-");
        boolean creatable3 = NumberUtils.isCreatable("123L");
        boolean creatable4 = NumberUtils.isCreatable("E-");
        //then
        Assert.assertFalse(creatable);
        Assert.assertFalse(creatable1);
        Assert.assertFalse(creatable2);
    }
}