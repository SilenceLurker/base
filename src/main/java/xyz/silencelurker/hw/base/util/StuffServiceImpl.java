package xyz.silencelurker.hw.base.util;

import java.util.List;

import javax.annotation.Resource;

import xyz.silencelurker.hw.base.entity.Stuff;
import xyz.silencelurker.hw.base.repository.StuffRepository;
import xyz.silencelurker.hw.base.service.StuffService;

/**
 * @author Silence_Lurker
 */
public class StuffServiceImpl implements StuffService {

    @Resource
    private StuffRepository stuffRepository;

    @Override
    public Stuff findById(Integer id) {
        return stuffRepository.findById(id).get();
    }

    @Override
    public List<Stuff> findAll() {
        return stuffRepository.findAll();
    }

    @Override
    public Integer findSalaryIdByStuffId(Integer id) {
        return stuffRepository.findSalaryIdByStuffId(id);
    }

    @Override
    public void add(Stuff t) {
        stuffRepository.save(t);
    }

}
