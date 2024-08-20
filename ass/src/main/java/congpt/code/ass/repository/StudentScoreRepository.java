package congpt.code.ass.repository;

import congpt.code.ass.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer> {
}