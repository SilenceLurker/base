package xyz.silencelurker.hw.base.service;

import java.util.List;

import xyz.silencelurker.hw.base.entity.Stuff;

/**
 * @author Silence_Lurker
 */
public interface StuffService extends Service<Stuff> {
    /**
     * 按Id查询员工数据
     * 
     * @param id
     * @return
     */
    Stuff findById(Integer id);

    /**
     * 获取全部信息
     * 
     * @return
     */
    List<Stuff> findAll();

    /**
     * 根据用户ID搜索匹配的薪水ID
     * 
     * @param id
     * @return
     */
    Integer findSalaryIdByStuffId(Integer id);
}
