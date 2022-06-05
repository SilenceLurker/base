package xyz.silencelurker.hw.base.service;

import xyz.silencelurker.hw.base.entity.Occupation;

/**
 * @author Silence_Lurker
 */
public interface OccupationService extends Service<Occupation> {

    /**
     * 根据传入的id查询并更新数据为新的职业信息描述
     * 
     * @param id
     * @param newOccupation
     */
    public void update(int id, Occupation newOccupation);
}
