package com.huawei.android.hicloud.cloudspace.bean;

import java.util.Objects;

/* loaded from: classes2.dex */
public class StorageModuleInfo implements Comparable<StorageModuleInfo> {
    private int moduleColor;
    private int moduleDarkColor;
    private String moduleName;
    private float percent = 0.0f;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StorageModuleInfo) && Float.compare(((StorageModuleInfo) obj).percent, this.percent) == 0;
    }

    public int getModuleColor() {
        return this.moduleColor;
    }

    public int getModuleDarkColor() {
        return this.moduleDarkColor;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public float getPercent() {
        return this.percent;
    }

    public int hashCode() {
        return Objects.hash(this.moduleName, Integer.valueOf(this.moduleColor), Integer.valueOf(this.moduleDarkColor), Float.valueOf(this.percent));
    }

    public void setModuleColor(int i10) {
        this.moduleColor = i10;
    }

    public void setModuleDarkColor(int i10) {
        this.moduleDarkColor = i10;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public void setPercent(float f10) {
        this.percent = f10;
    }

    @Override // java.lang.Comparable
    public int compareTo(StorageModuleInfo storageModuleInfo) {
        return Float.compare(storageModuleInfo.getPercent(), this.percent);
    }
}
