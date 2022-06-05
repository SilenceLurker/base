package xyz.silencelurker.hw.base.entity.factory;

import xyz.silencelurker.hw.base.entity.Department;

/**
 * @author Silence_Lurker
 */
public class DepartmentFactory {

    private int id = -1;
    private String departmentInfo;
    private Department department = new Department();

    public Department build() {
        if (departmentInfo == null) {
            departmentInfo = "经理室";
        }
        department.setDepartment(departmentInfo);
        if (id == -1) {
            id = 1;
        }
        department.setDepartmentId(id);
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartmentInfo(String departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

}
