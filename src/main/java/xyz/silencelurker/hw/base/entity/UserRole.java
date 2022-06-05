package xyz.silencelurker.hw.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * 用于描述用户的权限信息（系统内角色）
 * </p>
 * 
 * @author Silence_Lurker
 */
@Entity
@Table(name = "t_userrole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRoleId;
    private String userRole;

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRole() {
        return userRole;
    }

    public int getUserRoleId() {
        return userRoleId;
    }
}
