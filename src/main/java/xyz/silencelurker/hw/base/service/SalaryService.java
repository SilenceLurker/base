package xyz.silencelurker.hw.base.service;

import java.util.List;

import xyz.silencelurker.hw.base.entity.Salary;

/**
 * @author Silence_Lurker
 */
public interface SalaryService extends Service<Salary> {
    /**
     * 获取全部薪水信息
     * 
     * @return
     */
    public List<Salary> findAll();

    /**
     * 根据id更新薪水
     * 
     * @param id
     * @param newSalary
     */
    public void update(int id, Salary newSalary);
}
