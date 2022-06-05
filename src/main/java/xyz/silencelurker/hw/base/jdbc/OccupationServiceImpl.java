package xyz.silencelurker.hw.base.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import xyz.silencelurker.hw.base.dao.Dao;
import xyz.silencelurker.hw.base.entity.Occupation;
import xyz.silencelurker.hw.base.entity.factory.OccupationFactory;
import xyz.silencelurker.hw.base.service.OccupationService;

/**
 * @author Silence_Lurker
 */
@Service
public class OccupationServiceImpl implements OccupationService {

    @Override
    public List<Occupation> findAll() {
        Connection con = Dao.getCon();
        List<Occupation> list = null;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM t_occupation");
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<Occupation>();

            OccupationFactory of = new OccupationFactory();

            while (rs.next()) {
                of.setOccupation(rs.getString("occupation"));
                of.setOccupationId(rs.getInt("occupation_Id"));
                list.add(of.build());
            }

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void update(int id, Occupation newOccupation) {
        Connection con = Dao.getCon();

        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE t_occupation set occupation = ? , occupation_Id = ? where occupation_Id = ?");
            ps.setString(1, newOccupation.getOccupation());
            ps.setInt(2, newOccupation.getOccupationId());
            ps.setInt(3, id);

            if (ps.executeUpdate() == 0) {
                con.close();
                throw new SQLException("未成功更新");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Occupation findById(Integer id) {
        Connection con = Dao.getCon();
        Occupation o = null;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM t_occupation where occupation_Id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            OccupationFactory of = new OccupationFactory();

            while (rs.next()) {
                of.setOccupation(rs.getString("occupation"));
                of.setOccupationId(rs.getInt("occupation_Id"));
                o = of.build();
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }

    @Override
    public void add(Occupation t) {
        Connection con = Dao.getCon();

        try {
            PreparedStatement ps = con.prepareStatement("insert into t_occupation values(?,?);");

            ps.setInt(1, t.getOccupationId());
            ps.setString(2, t.getOccupation());

            boolean flag;

            flag = ps.execute();

            if (!flag) {
                throw new Exception("Add Error!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
