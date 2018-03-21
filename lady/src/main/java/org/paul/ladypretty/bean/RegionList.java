package org.paul.ladypretty.bean;

import org.paul.lib.base.BaseBean;

import java.util.List;

public class RegionList extends BaseBean{

//    private int code;
//    private String message;

    private List<Region> data;

    @Override
    public String toString() {
        return "RegionList{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
