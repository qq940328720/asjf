package com.aishang.asjf.client.crmserver.response;

import java.io.Serializable;

public class AsAndXydResponse implements Serializable {

    private boolean xyd;

    private boolean as;

    @Override
    public String toString() {
        return "AsAndXydResponse{" +
                "xyd=" + xyd +
                ", as=" + as +
                '}';
    }

    public boolean isXyd() {
        return xyd;
    }

    public void setXyd(boolean xyd) {
        this.xyd = xyd;
    }

    public boolean isAs() {
        return as;
    }

    public void setAs(boolean as) {
        this.as = as;
    }
}
