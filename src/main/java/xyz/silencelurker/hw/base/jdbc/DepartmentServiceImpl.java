package xyz.silencelurker.hw.base.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import xyz.silencelurker.hw.base.dao.Dao;
import xyz.silencelurker.hw.base.entity.Department;
import xyz.silencelurker.hw.base.entity.factory.DepartmentFactory;
import xyz.silencelurker.hw.base.service.DepartmentService;

/**
 * @author Silence_Lurker
 * 
 *         映射表：t_department
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public List<Department> findAll() {
        Connection con = Dao.getCon();
        List<Department> list = null;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM t_department");
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<Department>();

            DepartmentFactory df = new DepartmentFactory();

            while (rs.next()) {
                df.setDepartmentInfo(rs.getString(2));
                df.setId(rs.getInt(1));
                list.add(df.build());
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void add(Department department) {
        Connection con = Dao.getCon();

        try {
            PreparedStatement ps = con.prepareStatement(INSERT + "VALUES(?,?)");
            ps.setInt(1, department.getDepartmentId());
            ps.setString(2, department.getDepartment());
            ps.executeQuery();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Department findById(Integer id) {
        Connection con = Dao.getCon();
        Department d = null;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM t_department WHERE department_Id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            DepartmentFactory df = new DepartmentFactory();

            while (rs.next()) {
                df.setDepartmentInfo(rs.getString(2));
                df.setId(rs.getInt(1));
                d = df.build();
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return d;
    }

    @Override
    public void update(Integer id, Department newDepartment) {
        Connection con = Dao.getCon();

        try {
            PreparedStatement ps = con
                    .prepareStatement(
                            "update t_department set department_Id = ? , department = ? where department_Id = ?");
            ps.setInt(1, newDepartment.getDepartmentId());
            ps.setString(2, newDepartment.getDepartment());
            ps.setInt(3, id);

            ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
