package tv.wallbase.gateway.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 序列保存
 *
 * @author wangkun23
 */
@ToString
public class Sequence implements Serializable {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private int nextId;


    public Sequence() {

    }

    public Sequence(String name, int nextId) {
        this.name = name;
        this.nextId = nextId;
    }

}
