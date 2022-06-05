package xyz.silencelurker.hw.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.silencelurker.hw.base.entity.Stuff;

/**
 * @author Silence_Lurker
 */
public interface StuffRepository extends JpaRepository<Stuff, Integer> {
    /**
     * 根据用户ID搜索匹配的薪水ID
     * 
     * @param id
     * @return
     */
    Integer findSalaryIdByStuffId(Integer id);
}
