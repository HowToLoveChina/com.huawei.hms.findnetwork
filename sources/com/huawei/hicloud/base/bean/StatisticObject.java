package com.huawei.hicloud.base.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class StatisticObject {
    private StatisticDataObject[] data;
    private StatisticResultObject result;

    public StatisticDataObject[] getData() {
        StatisticDataObject[] statisticDataObjectArr = this.data;
        return statisticDataObjectArr != null ? (StatisticDataObject[]) statisticDataObjectArr.clone() : new StatisticDataObject[0];
    }

    public StatisticResultObject getResult() {
        return this.result;
    }

    public void setData(StatisticDataObject[] statisticDataObjectArr) {
        if (statisticDataObjectArr != null) {
            this.data = (StatisticDataObject[]) statisticDataObjectArr.clone();
        } else {
            this.data = null;
        }
    }

    public void setResult(StatisticResultObject statisticResultObject) {
        this.result = statisticResultObject;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
