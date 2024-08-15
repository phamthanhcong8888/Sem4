package congpt.code.exam.controller;

import ch.qos.logback.core.model.Model;
import congpt.code.exam.entity.Entry;
import congpt.code.exam.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/entries")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @GetMapping
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entry> getEntryById(@PathVariable Long id) {
        return entryService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entry createEntry(@RequestBody Entry entry) {
        entry.setCreated(LocalDateTime.now());
        return entryService.save(entry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entry> updateEntry(@PathVariable Long id, @RequestBody Entry entryDetails) {
        return entryService.findById(id)
                .map(entry -> {
                    entry.setTitle(entryDetails.getTitle());
                    entry.setContent(entryDetails.getContent());
                    entry.setRate(entryDetails.getRate());
                    entry.setAuthor(entryDetails.getAuthor());
                    Entry updatedEntry = entryService.save(entry);
                    return ResponseEntity.ok(updatedEntry);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        if (entryService.findById(id).isPresent()) {
            entryService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
