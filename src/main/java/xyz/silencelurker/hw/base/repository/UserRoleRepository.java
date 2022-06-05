package xyz.silencelurker.hw.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.silencelurker.hw.base.entity.UserRole;

/**
 * @author Silence_Lurker
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
