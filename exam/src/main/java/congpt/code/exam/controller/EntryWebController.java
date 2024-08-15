package congpt.code.exam.controller;

import congpt.code.exam.entity.Entry;
import congpt.code.exam.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/entries") // Thêm đường dẫn cơ sở
public class EntryWebController {

    @Autowired
    private EntryService entryService;

    @GetMapping
    public String getEntries(Model model) {
        List<Entry> entries = entryService.findAll();
        model.addAttribute("entries", entries);
        return "entries";
    }

    @GetMapping("/new") // Đường dẫn để hiển thị form tạo mới
    public String showCreateForm(Model model) {
        model.addAttribute("entry", new Entry()); // Thêm một đối tượng Entry rỗng vào mô hình
        return "create-entry"; // Trả về tên của trang HTML cho form
    }

    @PostMapping // Phương thức này sẽ xử lý yêu cầu POST từ form
    public String createEntry(@ModelAttribute Entry entry) {
        entry.setCreated(LocalDateTime.now()); // Cài đặt thời gian tạo
        entryService.save(entry); // Lưu entry mới
        return "redirect:/entries"; // Chuyển hướng về trang danh sách entries
    }
}
