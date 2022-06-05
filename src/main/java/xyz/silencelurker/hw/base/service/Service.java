package xyz.silencelurker.hw.base.service;

import java.util.List;

/**
 * @author Silence_Lurker
 */
public interface Service<T> {
    public static final String SELECT = "SELECT ? FROM ";
    public static final String DELETE = "DELETE FROM ? ";
    public static final String INSERT = "INSERT INTO ? ";

    /**
     * 获取对应服务的全部信息
     * 
     * @return
     */
    public List<T> findAll();

    /**
     * 根据Id获取对应的对象
     * 
     * @param id
     * @return
     */
    public T findById(Integer id);

    /**
     * 增加新的数据
     * 
     * @param t 新的数据
     */
    void add(T t);
}
