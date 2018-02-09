package com.aishang.asjf.client.mallserver.response.info;

import java.util.List;

/**
 * Created by mx on 17-12-7.
 */
public class DictAreaVo extends DictionaryProvice{

    List<DictAreaVo> listAreas;

    public List<DictAreaVo> getListAreas() {
        return listAreas;
    }

    public void setListAreas(List<DictAreaVo> listAreas) {
        this.listAreas = listAreas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DictAreaVo that = (DictAreaVo) o;

        return listAreas != null ? listAreas.equals(that.listAreas) : that.listAreas == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (listAreas != null ? listAreas.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DictAreaVo{" +
                "listAreas=" + listAreas +
                '}';
    }
}
