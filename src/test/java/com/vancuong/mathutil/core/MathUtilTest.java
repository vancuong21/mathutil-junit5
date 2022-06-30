/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.vancuong.mathutil.core;

import static com.vancuong.mathutil.core.MathUtil.*;
// import static danh rieng cho ham static
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author cuong
 */
public class MathUtilTest {

    // chơi DDT, tách data ra hỏi câu lệnh kiểm thử, tham số hoá data này
    // chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][]{
            {1, 1},
            {2, 2},
            {5, 120},
            {6, 720}
        };
    }

    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cc data, ngầm định thứ tự mảng
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }

//    @Test
//    public void testGetFactorialGivenRightArgReturnsWell() {
//        assertEquals(120, getFactorial(5));
//    }
    // bắt ngoại lệ khi đưa data cà chớn !!!
    @Test
    public void testGetFactorialGiveWrongArgThrowException() {
        // xài biểu thức Lambda
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };

        Executable exObject = () -> {
            getFactorial(-5);
        };
        assertThrows(IllegalArgumentException.class, exObject);
    }
}
