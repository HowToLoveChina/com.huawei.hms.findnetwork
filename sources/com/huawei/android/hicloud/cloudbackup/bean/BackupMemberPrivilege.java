package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class BackupMemberPrivilege {
    private List<AutoBackupFrequency> autoBackupFrequency;

    public static class AutoBackupFrequency {
        private int frequencyLevel;
        private List<String> gradeCode;
        private int index;

        public int getFrequencyLevel() {
            return this.frequencyLevel;
        }

        public List<String> getGradeCode() {
            return this.gradeCode;
        }

        public int getIndex() {
            return this.index;
        }

        public void setFrequencyLevel(int i10) {
            this.frequencyLevel = i10;
        }

        public void setGradeCode(List<String> list) {
            this.gradeCode = list;
        }

        public void setIndex(int i10) {
            this.index = i10;
        }
    }

    public List<AutoBackupFrequency> getAutoBackupFrequency() {
        return this.autoBackupFrequency;
    }

    public void setAutoBackupFrequency(List<AutoBackupFrequency> list) {
        this.autoBackupFrequency = list;
    }
}
