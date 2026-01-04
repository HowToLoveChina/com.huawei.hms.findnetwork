package com.huawei.cloud.pay.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes5.dex */
public class DispRule implements Serializable {
    private static final long serialVersionUID = 8558184350996849681L;

    @SerializedName("limit")
    private int limit;

    @SerializedName("tasks")
    private List<DlTask> tasks;

    public int getLimit() {
        return this.limit;
    }

    public List<DlTask> getTasks() {
        return this.tasks;
    }

    public void setLimit(int i10) {
        this.limit = i10;
    }

    public void setTasks(List<DlTask> list) {
        this.tasks = list;
    }
}
