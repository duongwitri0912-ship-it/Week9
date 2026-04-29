package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GradeClassifier {

    // Khởi tạo đối tượng Logger của SLF4J
    private static final Logger logger = LoggerFactory.getLogger(GradeClassifier.class);

    public static String classifyGrade(double gpa) {
        // Ghi log mức độ INFO khi hàm bắt đầu được gọi
        logger.info("Bắt đầu xử lý phân loại điểm cho GPA: {}", gpa);

        if (gpa < 0.0 || gpa > 10.0) {
            // Ghi log mức độ ERROR khi phát hiện dữ liệu đầu vào sai
            logger.error("Đã xảy ra lỗi: GPA không hợp lệ ({})", gpa);
            throw new IllegalArgumentException("GPA không hợp lệ: " + gpa); //
        }

        if (gpa < 5.0) {
            // Ghi log mức độ DEBUG để theo dõi luồng logic bên trong
            logger.debug("GPA {} < 5.0, phân loại: Yếu", gpa);
            return "Yếu"; //
        }

        if (gpa < 6.5) {
            logger.debug("GPA {} < 6.5, phân loại: Trung bình", gpa);
            return "Trung bình"; //
        }

        if (gpa < 8.0) {
            logger.debug("GPA {} < 8.0, phân loại: Khá", gpa);
            return "Khá"; //
        }

        logger.debug("GPA {} >= 8.0, phân loại: Giỏi", gpa);
        return "Giỏi"; //
    }
}
