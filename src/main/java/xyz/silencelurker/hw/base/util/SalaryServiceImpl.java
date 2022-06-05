package xyz.silencelurker.hw.base.util;

import java.util.List;

import javax.annotation.Resource;

import xyz.silencelurker.hw.base.entity.Salary;
import xyz.silencelurker.hw.base.repository.SalaryRepository;
import xyz.silencelurker.hw.base.service.SalaryService;

/**
 * @author Silence_Lurker
 */
public class SalaryServiceImpl implements SalaryService {

    @Resource
    SalaryRepository salaryRepository;

    @Override
    public List<Salary> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(int id, Salary newSalary) {
        salaryRepository.deleteById(id);
        salaryRepository.save(newSalary);
    }

    @Override
    public Salary findById(Integer id) {
        return salaryRepository.findById(id).get();
    }

    @Override
    public void add(Salary t) {
        salaryRepository.save(t);

    }

}
