package xyz.silencelurker.hw.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.silencelurker.hw.base.entity.Department;

/**
 * 部门类相关继承了JPARepository的接口
 * 
 * @author Silence_Lurker
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
