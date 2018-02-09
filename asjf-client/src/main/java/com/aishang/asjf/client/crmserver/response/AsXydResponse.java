package com.aishang.asjf.client.crmserver.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class AsXydResponse implements Serializable {

    private boolean canSkip;

    private boolean signatrueSuccess;

    private String name;

    private String url;



    public boolean isCanSkip() {
        return canSkip;
    }

    public void setCanSkip(boolean canSkip) {
        this.canSkip = canSkip;
    }


    @Override
    public String toString() {
        return "AsXydResponse{" +
                "canSkip=" + canSkip +
                ", signatrueSuccess=" + signatrueSuccess +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public boolean isSignatrueSuccess() {
        return signatrueSuccess;
    }

    public void setSignatrueSuccess(boolean signatrueSuccess) {
        this.signatrueSuccess = signatrueSuccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AsXydResponse that = (AsXydResponse) o;

        if (canSkip != that.canSkip) return false;
        if (signatrueSuccess != that.signatrueSuccess) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return url != null ? url.equals(that.url) : that.url == null;
    }

    @Override
    public int hashCode() {
        int result = (canSkip ? 1 : 0);
        result = 31 * result + (signatrueSuccess ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
