package xyz.silencelurker.hw.base.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import xyz.silencelurker.hw.base.dao.Dao;
import xyz.silencelurker.hw.base.entity.Salary;
import xyz.silencelurker.hw.base.service.SalaryService;

/**
 * @author Silence_Lurker
 */
@Service
public class SalaryServiceImpl implements SalaryService {

    @Override
    public List<Salary> findAll() {
        Connection con = Dao.getCon();
        List<Salary> list = new ArrayList<Salary>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM t_salary");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Salary s = new Salary();
                s.setAccumulationFund(rs.getDouble("accumulation_Fund"));
                s.setBasePay(rs.getDouble("base_Pay"));
                s.setCheck(rs.getDouble("check"));
                s.setInsurance(rs.getDouble("insurance"));
                s.setOther(rs.getDouble("other"));
                s.setRewardSalary(rs.getDouble("reward_Salary"));
                s.setStuffId(rs.getInt("stuff_Id"));
                s.setSubsidy(rs.getDouble("subsidy"));
                s.setTax(rs.getDouble("tax"));

                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void update(int id, Salary newSalary) {

    }

    @Override
    public Salary findById(Integer id) {
        Connection con = Dao.getCon();
        Salary s = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM t_salary");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                s = new Salary();
                s.setAccumulationFund(rs.getDouble("accumulation_Fund"));
                s.setBasePay(rs.getDouble("base_Pay"));
                s.setCheck(rs.getDouble("check"));
                s.setInsurance(rs.getDouble("insurance"));
                s.setOther(rs.getDouble("other"));
                s.setRewardSalary(rs.getDouble("reward_Salary"));
                s.setStuffId(rs.getInt("stuff_Id"));
                s.setSubsidy(rs.getDouble("subsidy"));
                s.setTax(rs.getDouble("tax"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    public void add(Salary t) {
        // TODO Auto-generated method stub

    }

}
