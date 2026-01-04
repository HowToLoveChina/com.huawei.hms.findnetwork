package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class AnalysisReport extends C11707b {

    @InterfaceC4648p
    private Integer appSize;

    @InterfaceC4648p
    private List<App> apps;

    @InterfaceC4648p
    private Integer delSpaceSize;

    @InterfaceC4648p
    private boolean isFinishAnalysis;

    @InterfaceC4648p
    private String nextCursor;

    public Integer getAppSize() {
        return this.appSize;
    }

    public List<App> getApps() {
        return this.apps;
    }

    public Integer getDelSpaceSize() {
        return this.delSpaceSize;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public boolean isFinishAnalysis() {
        return this.isFinishAnalysis;
    }

    public void setAppSize(Integer num) {
        this.appSize = num;
    }

    public void setApps(List<App> list) {
        this.apps = list;
    }

    public void setDelSpaceSize(Integer num) {
        this.delSpaceSize = num;
    }

    public void setFinishAnalysis(boolean z10) {
        this.isFinishAnalysis = z10;
    }

    public void setNextCursor(String str) {
        this.nextCursor = str;
    }
}
