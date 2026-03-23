package com.codewithgautam.rating_tracker.repository;

import com.codewithgautam.rating_tracker.model.RatingEntry;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingEntryRepository extends JpaRepository<RatingEntry, Long> {
    List<RatingEntry> findByPlayerNameIgnoreCaseOrderByRatingDateAsc(String playerName);
}
