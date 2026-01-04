package com.huawei.fastengine.fastview.startfastappengine.bean;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class RpkPageInfo implements Serializable {
    public static final int AUTOCREATESHORTCUT = 2;
    public static final int DONTCREATESHORTCUT = 0;
    public static final int NONE_CREATE_SHORTCUT = 3;
    public static final int SHOULDCREATESHORTCUT = 1;
    private static final long serialVersionUID = 6321099514219022763L;
    private String appName;
    private String interruptedUri;
    private Options options;
    private String packageName;
    private String pageParam;
    private String pageUri;
    private String sourcePackage;
    public int createShortCut = 2;
    private boolean latestNeed = true;

    public String getAppName() {
        return this.appName;
    }

    public String getInterruptedUri() {
        return this.interruptedUri;
    }

    public Options getOptions() {
        return this.options;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPageParam() {
        return this.pageParam;
    }

    public String getPageUri() {
        return this.pageUri;
    }

    public String getSourcePackage() {
        return this.sourcePackage;
    }

    public int isCreateShortCut() {
        return this.createShortCut;
    }

    public boolean isLatestNeed() {
        return this.latestNeed;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setCreateShortCut(int i10) {
        int i11;
        if (i10 != 0) {
            int i12 = 1;
            if (i10 != 1) {
                i12 = 3;
                i11 = i10 != 3 ? 2 : 0;
            }
            this.createShortCut = i12;
            return;
        }
        this.createShortCut = i11;
    }

    public void setInterruptedUri(String str) {
        this.interruptedUri = str;
    }

    public void setLatestNeed(boolean z10) {
        this.latestNeed = z10;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPageParam(String str) {
        this.pageParam = str;
    }

    public void setPageUri(String str) {
        this.pageUri = str;
    }

    public void setSourcePackage(String str) {
        this.sourcePackage = str;
    }

    public void setCreateShortCut(boolean z10) {
        this.createShortCut = z10 ? 1 : 0;
    }
}
