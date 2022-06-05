package xyz.silencelurker.hw.base.util;

import java.util.List;

import javax.annotation.Resource;

import xyz.silencelurker.hw.base.entity.Department;
import xyz.silencelurker.hw.base.repository.DepartmentRepository;
import xyz.silencelurker.hw.base.service.DepartmentService;

/**
 * @author Silence_Lurker
 */
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public void add(Department department) {
        departmentRepository.save(department);

    }

    @Override
    public void update(Integer id, Department newDepartment) {

    }

}
