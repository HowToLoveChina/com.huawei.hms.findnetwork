package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes5.dex */
public class ResumeResBody extends C11707b {

    @InterfaceC4648p
    private Integer processTime;

    @InterfaceC4648p
    private List<String> rangeList;

    @InterfaceC4648p
    private Integer sliceSize;

    public Integer getProcessTime() {
        return this.processTime;
    }

    public List<String> getRangeList() {
        return this.rangeList;
    }

    public Integer getSliceSize() {
        return this.sliceSize;
    }

    public void setProcessTime(Integer num) {
        this.processTime = num;
    }

    public void setRangeList(List<String> list) {
        this.rangeList = list;
    }

    public void setSliceSize(int i10) {
        this.sliceSize = Integer.valueOf(i10);
    }
}
