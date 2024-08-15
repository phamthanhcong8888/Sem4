package congpt.code.exam.repository;

import congpt.code.exam.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
