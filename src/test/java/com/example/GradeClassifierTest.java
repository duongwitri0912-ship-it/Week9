package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeClassifierTest {

    @Test
    public void testEP_Yeu() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(3.0));
    }

    @Test
    public void testEP_TrungBinh() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.0));
    }

    @Test
    public void testEP_Kha() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.0));
    }

    @Test
    public void testEP_Gioi() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(9.0));
    }

    @Test
    public void testBVA_Boundaries() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.0));
        assertEquals("Yếu", GradeClassifier.classifyGrade(4.9));

        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0));
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.4));
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5));

        assertEquals("Khá", GradeClassifier.classifyGrade(7.9));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }

    @Test
    public void testException_GpaLessThanZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(-0.1);
        });
        assertEquals("GPA không hợp lệ: -0.1", exception.getMessage());
    }

    @Test
    public void testException_GpaGreaterThanTen() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(10.1);
        });
        assertEquals("GPA không hợp lệ: 10.1", exception.getMessage());
    }
}
