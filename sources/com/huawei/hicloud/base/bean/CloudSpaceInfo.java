package com.huawei.hicloud.base.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CloudSpaceInfo {
    private AddInfo addInfo;
    private int status;

    public static class AddInfo {
        private List<ProgressModel> dataPanelList;
        private long totalSpace;

        public List<ProgressModel> getDataPanelList() {
            return this.dataPanelList;
        }

        public long getTotalSpace() {
            return this.totalSpace;
        }

        public void setDataPanelList(List<ProgressModel> list) {
            this.dataPanelList = list;
        }

        public void setTotalSpace(long j10) {
            this.totalSpace = j10;
        }
    }

    public static class ProgressModel implements Comparable<ProgressModel> {
        private String color;
        private String icon;
        private String key;
        private int percent;
        private String service;
        private long used;

        public String getColor() {
            return this.color;
        }

        public String getIcon() {
            return this.icon;
        }

        public String getKey() {
            return this.key;
        }

        public int getPercent() {
            return this.percent;
        }

        public String getService() {
            return this.service;
        }

        public long getUsed() {
            return this.used;
        }

        public void setColor(String str) {
            this.color = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setPercent(int i10) {
            this.percent = i10;
        }

        public void setService(String str) {
            this.service = str;
        }

        public void setUsed(long j10) {
            this.used = j10;
        }

        @Override // java.lang.Comparable
        public int compareTo(ProgressModel progressModel) {
            return Float.compare(progressModel.getPercent(), this.percent);
        }
    }

    public AddInfo getAddInfo() {
        return this.addInfo;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAddInfo(AddInfo addInfo) {
        this.addInfo = addInfo;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
