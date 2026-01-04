package com.huawei.cloud.pay.model;

import java.util.Objects;

/* loaded from: classes5.dex */
public class ManagerUIParams implements Comparable<ManagerUIParams> {
    private String content;
    private int priority;
    private String title;
    private String xhdpipic;
    private String xxhdpipic;
    private String xxxhdpipic;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.priority == ((ManagerUIParams) obj).priority;
    }

    public String getContent() {
        return this.content;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getTitle() {
        return this.title;
    }

    public String getXhdpipic() {
        return this.xhdpipic;
    }

    public String getXxhdpipic() {
        return this.xxhdpipic;
    }

    public String getXxxhdpipic() {
        return this.xxxhdpipic;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.priority));
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setXhdpipic(String str) {
        this.xhdpipic = str;
    }

    public void setXxhdpipic(String str) {
        this.xxhdpipic = str;
    }

    public void setXxxhdpipic(String str) {
        this.xxxhdpipic = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(ManagerUIParams managerUIParams) {
        long j10 = this.priority - managerUIParams.priority;
        if (j10 < 0) {
            return -1;
        }
        return j10 > 0 ? 1 : 0;
    }
}
