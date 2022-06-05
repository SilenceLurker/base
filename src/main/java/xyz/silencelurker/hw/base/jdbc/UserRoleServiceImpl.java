package xyz.silencelurker.hw.base.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import xyz.silencelurker.hw.base.dao.Dao;
import xyz.silencelurker.hw.base.entity.UserRole;
import xyz.silencelurker.hw.base.service.UserRoleService;

/**
 * @author Silence_Lurker
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Override
    public List<UserRole> findAll() {
        Connection con = Dao.getCon();
        List<UserRole> list = new ArrayList<UserRole>();

        try {
            PreparedStatement ps = con.prepareStatement("select * from t_userRole");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserRole ur = new UserRole();
                ur.setUserRole(rs.getString("userRole"));
                ur.setUserRoleId(rs.getInt("userRoleId"));

                list.add(ur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public UserRole findById(Integer id) {
        Connection con = Dao.getCon();
        UserRole role = null;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM t_userRole WHERE ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                role = new UserRole();
                role.setUserRole(rs.getString("user_Role"));
                role.setUserRoleId(rs.getInt("user_Role_Id"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }

    @Override
    public void add(UserRole t) {
        Connection con = Dao.getCon();

        try {
            PreparedStatement ps = con.prepareStatement("Insert into t_userRole VALUES(?,?);");
            ps.setInt(1, t.getUserRoleId());
            ps.setString(2, t.getUserRole());

            if (!ps.execute()) {
                throw new Exception("Add Error!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
