package com.huawei.fastengine.fastview.download.install;

/* loaded from: classes5.dex */
public class ManagerTask {
    private String packageName;
    private String path;

    public ManagerTask(String str, String str2) {
        setPath(str2);
        setPackageName(str);
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPath() {
        return this.path;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
