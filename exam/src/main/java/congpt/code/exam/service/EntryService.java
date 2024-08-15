package congpt.code.exam.service;

import congpt.code.exam.entity.Entry;
import congpt.code.exam.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Optional<Entry> findById(Long id) {
        return entryRepository.findById(id);
    }

    public Entry save(Entry entry) {
        return entryRepository.save(entry);
    }

    public void deleteById(Long id) {
        entryRepository.deleteById(id);
    }
}
