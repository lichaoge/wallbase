package tv.wallbase.mapper;


import org.apache.ibatis.annotations.Mapper;
import tv.wallbase.gateway.model.Sequence;

/**
 * 流水号生成规则修改
 *
 * @author wangkun23
 * @Note 不要使用更改方法生产流水号，请使用SequenceService
 */
@Mapper
public interface SequenceMapper {

    /**
     * 新增一条
     *
     * @param sequence
     */
    public void insert(Sequence sequence);

    /**
     * 获取自增序列
     *
     * @param name
     * @return
     */
    public Sequence getSequence(String name);

    /**
     * 修改自增
     *
     * @param sequence
     */
    public void updateSequence(Sequence sequence);
}
