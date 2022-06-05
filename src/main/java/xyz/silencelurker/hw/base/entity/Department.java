package xyz.silencelurker.hw.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>
 * 部门描述
 * </p>
 * 
 * @author Silence_Lurker
 */
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;
    private String department;

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartment() {
        return department;
    }

    public int getDepartmentId() {
        return departmentId;
    }
}
