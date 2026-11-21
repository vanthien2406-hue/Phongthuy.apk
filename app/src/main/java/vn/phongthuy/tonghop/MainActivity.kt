package vn.phongthuy.tonghop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private data class MetaphysicsModule(
    val title: String,
    val subtitle: String,
    val symbol: String,
    val description: String
)

private val modules = listOf(
    MetaphysicsModule("Kinh Dịch", "Quẻ và hào", "☯", "Khám phá 64 quẻ, cấu trúc hào và các cách gieo quẻ."),
    MetaphysicsModule("Kỳ Môn Độn Giáp", "Thời bàn và không gian", "✧", "Tra cứu cục, bàn cục và các yếu tố trong hệ thống Kỳ Môn."),
    MetaphysicsModule("Tử Vi", "Lá số và cung", "✶", "Tìm hiểu hệ thống cung, chính tinh và các khái niệm Tử Vi."),
    MetaphysicsModule("Bát Tự", "Tứ trụ và ngũ hành", "☯", "Xem can chi năm, tháng, ngày, giờ và mối quan hệ ngũ hành.")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme()) {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PhongThuyApp()
                }
            }
        }
    }
}

@Composable
private fun PhongThuyApp() {
    var selectedModule by remember { mutableStateOf<MetaphysicsModule?>(null) }
    var birthDate by remember { mutableStateOf("") }
    var birthTime by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item { Spacer(Modifier.height(12.dp)) }
        item {
            Text("PHONG THỦY TỔNG HỢP", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
            Text("Tri thức phương Đông", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text("Kinh Dịch · Kỳ Môn · Tử Vi · Bát Tự", style = MaterialTheme.typography.bodyMedium)
        }
        if (selectedModule == null) {
            item {
                Card(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
                    Column(Modifier.padding(20.dp)) {
                        Text("Bắt đầu khám phá", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(6.dp))
                        Text("Chọn một bộ môn để tìm hiểu kiến thức và các công cụ đang phát triển.")
                    }
                }
            }
            item { Text("BỘ MÔN", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold) }
            items(modules.size) { index ->
                val module = modules[index]
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { selectedModule = module },
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(Modifier.padding(18.dp), horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                        Text(module.symbol, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
                        Column {
                            Text(module.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            Text(module.subtitle, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
            item {
                Card(shape = RoundedCornerShape(16.dp)) {
                    Column(Modifier.padding(18.dp)) {
                        Text("Thông tin ngày giờ sinh", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Text("Biểu mẫu chuẩn bị cho chức năng lập lá số; chưa tính kết quả.", style = MaterialTheme.typography.bodySmall)
                        Spacer(Modifier.height(10.dp))
                        OutlinedTextField(value = birthDate, onValueChange = { birthDate = it }, label = { Text("Ngày sinh (dd/mm/yyyy)") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                        Spacer(Modifier.height(8.dp))
                        OutlinedTextField(value = birthTime, onValueChange = { birthTime = it }, label = { Text("Giờ sinh (HH:mm, nếu biết)") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                    }
                }
            }
            item {
                Text("Nội dung mang tính tham khảo văn hóa, tín ngưỡng; không thay thế tư vấn y tế, pháp lý hoặc tài chính.", style = MaterialTheme.typography.bodySmall)
            }
        } else {
            val module = selectedModule!!
            item {
                OutlinedButton(onClick = { selectedModule = null }) { Text("←  Tất cả bộ môn") }
            }
            item {
                Card(shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
                    Column(Modifier.padding(22.dp)) {
                        Text(module.symbol, style = MaterialTheme.typography.headlineLarge)
                        Text(module.title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                        Text(module.subtitle, style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(12.dp))
                        Text(module.description)
                    }
                }
            }
            item {
                Text("ĐANG PHÁT TRIỂN", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(6.dp))
                Text("Phần này sẽ có bài học căn bản, công cụ lập bàn/lá số và phần giải thích từng bước. Kết quả chỉ được hiển thị sau khi quy tắc tính toán được kiểm chứng.")
            }
            item {
                Button(onClick = { selectedModule = null }, modifier = Modifier.fillMaxWidth()) { Text("Quay về trang chủ") }
            }
        }
        item { Spacer(Modifier.height(12.dp)) }
    }
}
