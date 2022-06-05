package xyz.silencelurker.hw.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.silencelurker.hw.base.entity.Occupation;

/**
 * @author Silence_Lurker
 */
public interface OccupationRepository extends JpaRepository<Occupation, Integer> {

}
