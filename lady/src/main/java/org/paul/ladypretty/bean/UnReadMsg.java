package org.paul.ladypretty.bean;

import org.paul.lib.base.BaseBean;

import java.util.List;

public class UnReadMsg extends BaseBean {

//    private int code;
//    private String message;

    private List<Msg> data;

    public List<Msg> getData() {
        return data;
    }

    public void setData(List<Msg> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UnReadMsg{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
