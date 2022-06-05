package xyz.silencelurker.hw.base.service;

import java.util.List;

import xyz.silencelurker.hw.base.entity.Department;

/**
 * @author Silence_Lurker
 */
public interface DepartmentService extends Service<Department> {
    /**
     * <p>
     * 获取所有的部门信息
     * </p>
     * 
     * @return
     */
    public List<Department> findAll();

    /**
     * 根据传入的ID查询对应的部门信息并返回
     * 
     * @param id
     * @return
     */
    public Department findById(Integer id);

    /**
     * 更新部门信息数据
     * 
     * @param id
     * @param newDepartment
     */
    public void update(Integer id, Department newDepartment);

    /**
     * 增加一个新的部门
     * 
     * @param department
     */
    public void add(Department department);
}
