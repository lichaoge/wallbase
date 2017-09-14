package tv.wallbase.gateway.service;

import tv.wallbase.gateway.model.Tag;

import java.util.List;
import java.util.Set;

/**
 * 标签管理
 *
 * @author Administrator
 */
public interface TagService {

    public void save(Tag tag);

    public Tag getByName(String name);

    public Set<Tag> getTagsFromString(String tagString);
}
