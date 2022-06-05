package xyz.silencelurker.hw.base.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * 员工描述
 * </p>
 * 
 * @author Silence_Lurker
 */
@Entity
@Table(name = "t_stuff")
public class Stuff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuffId;
    private String name;
    private String sex;
    private int age;
    private int departmentId;
    private int occupationId;
    private int userRoleId;

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupationId(int occupationId) {
        this.occupationId = occupationId;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setStuffId(int stuffId) {
        this.stuffId = stuffId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getAge() {
        return age;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public int getOccupationId() {
        return occupationId;
    }

    public String getSex() {
        return sex;
    }

    public int getStuffId() {
        return stuffId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

}
