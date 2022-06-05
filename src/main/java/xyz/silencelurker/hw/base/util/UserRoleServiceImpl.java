package xyz.silencelurker.hw.base.util;

import java.util.List;

import javax.annotation.Resource;

import xyz.silencelurker.hw.base.entity.UserRole;
import xyz.silencelurker.hw.base.repository.UserRoleRepository;
import xyz.silencelurker.hw.base.service.UserRoleService;

/**
 * @author Silence_Lurker
 */
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole findById(Integer id) {

        return userRoleRepository.getById(id);
    }

    @Override
    public void add(UserRole t) {
        userRoleRepository.save(t);
    }

}
