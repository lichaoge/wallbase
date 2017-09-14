package tv.wallbase.service.impl;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tv.wallbase.gateway.model.Tag;
import tv.wallbase.gateway.service.TagService;
import tv.wallbase.mapper.TagMapper;

/**
 * @author Administrator
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    @Transactional
    public void save(Tag tag) {
        tagMapper.insert(tag);
    }

    @Override
    public Tag getByName(String name) {
        return tagMapper.findByName(name);
    }

    @Override
    public Set<Tag> getTagsFromString(String tagString) {
        Set<Tag> result = new HashSet<Tag>();
        for (String tagName : tagString.split(",")) {
            tagName = tagName.replaceAll("\\s+", "");
            Tag tagObj = this.getByName(tagName);    // get persistent object
            if (tagObj == null) {
                //主要控制不能随便写标签 ,如果是自己的写的标签 系统将不保存
                //tagObj = new Tag();
                //tagObj.setName(tagName);
            } else {
                result.add(tagObj);
            }
        }
        return result;
    }


}
