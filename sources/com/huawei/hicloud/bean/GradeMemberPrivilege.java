package com.huawei.hicloud.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class GradeMemberPrivilege {
    private List<String> normalGradeCodes;
    private List<PackageDisplayLevel> packageDisplayLevel;

    public static class PackageDisplayLevel {
        private List<String> gradeCode;
        private int level;

        public List<String> getGradCode() {
            return this.gradeCode;
        }

        public int getLevel() {
            return this.level;
        }

        public void setGradCode(List<String> list) {
            this.gradeCode = list;
        }

        public void setLevel(int i10) {
            this.level = i10;
        }
    }

    public List<String> getNormalGradeCodes() {
        return this.normalGradeCodes;
    }

    public List<PackageDisplayLevel> getPackageDisplayLevel() {
        return this.packageDisplayLevel;
    }

    public void setNormalGradeCodes(List<String> list) {
        this.normalGradeCodes = list;
    }

    public void setPackageDisplayLevel(List<PackageDisplayLevel> list) {
        this.packageDisplayLevel = list;
    }
}
