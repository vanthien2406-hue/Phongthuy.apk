# Phong Thủy Tổng Hợp

Ứng dụng Android tiếng Việt, định hướng tích hợp Kinh Dịch, Kỳ Môn Độn Giáp, Tử Vi và Bát Tự.

## Trạng thái

Bản khởi tạo hiện cung cấp giao diện Android native bằng Jetpack Compose: trang tổng quan, bốn mục chuyên môn, phần giới thiệu từng mục và biểu mẫu nhập ngày giờ để chuẩn bị cho các chức năng lập lá số. Đây là bộ khung MVP; **chưa có thuật toán luận đoán/lập lá số**. Cần xác minh quy tắc lịch pháp, múi giờ, tiết khí và cách an sao với chuyên gia trước khi triển khai kết quả.

## Chạy ứng dụng

1. Mở repository bằng Android Studio (bản hỗ trợ Android Gradle Plugin 8.7.3).
2. Đồng bộ Gradle và chạy cấu hình `app` trên thiết bị hoặc emulator.
3. Yêu cầu Android SDK 35; thiết bị tối thiểu Android 7.0 (API 24).

## Hướng phát triển

- Xây dựng và kiểm thử thư viện lịch âm/dương, can chi và tiết khí.
- Triển khai từng hệ thống như các module độc lập, có bộ dữ liệu và nguồn tham khảo rõ ràng.
- Thêm hồ sơ người dùng, lưu cục bộ và kiểm thử các trường hợp ngày nhuận/múi giờ.
- Cung cấp giải thích minh bạch; nội dung văn hóa/tín ngưỡng không thay thế tư vấn chuyên môn.
