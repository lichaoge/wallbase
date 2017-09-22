package tv.wallbase.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tv.wallbase.gateway.enums.SequenceType;
import tv.wallbase.gateway.model.Sequence;
import tv.wallbase.gateway.service.SequenceService;
import tv.wallbase.mapper.SequenceMapper;

import javax.annotation.Resource;
import java.text.NumberFormat;

/**
 * 序列号生产器
 *
 * @Desc 用户系统中编号需要保证唯一，并且呈递增序列的单号
 * Created by wangkun23 on 2017/9/7.
 */
@Service
public class SequenceServiceImpl implements SequenceService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private SequenceMapper sequenceMapper;


    /**
     * 生成交易单号
     * 流水编号前面6是递增 ，后面两位随机生成但是不能重复，放到数据序列
     * 默认100000开始
     *
     * @return
     */
    public synchronized String generateWallpaperNo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("wallbase");//房联订单
        stringBuilder.append("-");//平台ID

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(6);
        formatter.setGroupingUsed(false);

        String nextId = formatter.format(this.getNextId(SequenceType.WALLPAPER));
        //这里保证不重复 ，
        stringBuilder.append(nextId);
        //在添加三位的随机值
        stringBuilder.append(RandomStringUtils.randomNumeric(2));

        return stringBuilder.toString();
    }


    /**
     * 读取下一个ID
     *
     * @return
     */
    @Transactional
    private Integer getNextId(SequenceType sequenceType) {
        Sequence sequence = new Sequence(sequenceType.toString(), -1);
        Sequence result = sequenceMapper.getSequence(sequenceType.name());
        if (result == null) {
            logger.warn("A null sequence was returned from the database {}", sequence);
            //throw new RuntimeException("Error: A null sequence was returned from the database " + sequence);
            Sequence entity = new Sequence(sequenceType.toString(), 0);
            sequenceMapper.insert(entity);
            //重新调用一次
            result = sequenceMapper.getSequence(sequenceType.name());
        }
        Sequence parameterObject = new Sequence(sequenceType.toString(), result.getNextId() + 1);
        sequenceMapper.updateSequence(parameterObject);
        return result.getNextId();
    }


}
