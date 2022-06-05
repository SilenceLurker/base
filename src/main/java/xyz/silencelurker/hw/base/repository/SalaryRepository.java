package xyz.silencelurker.hw.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.silencelurker.hw.base.entity.Salary;

/**
 * @author Silence_Lurker
 */
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}
