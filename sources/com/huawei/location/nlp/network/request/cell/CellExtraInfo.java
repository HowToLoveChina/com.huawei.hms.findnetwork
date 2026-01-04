package com.huawei.location.nlp.network.request.cell;

import com.huawei.location.nlp.network.request.BaseExtraInfo;
import java.util.List;

/* loaded from: classes8.dex */
public class CellExtraInfo extends BaseExtraInfo {
    private List<Integer> cellDetails;

    public List<Integer> getCellDetails() {
        return this.cellDetails;
    }

    public void setCellDetails(List<Integer> list) {
        this.cellDetails = list;
    }
}
