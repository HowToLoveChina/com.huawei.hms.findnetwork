package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class TempBackupPolicy {
    private String businessModeChangePage;
    private SaveReminder saveReminder;

    public static class SaveReminder {
        private Integer deadlineReminder = 7;
        private Integer reminderInterval = 24;
        private Integer reminderTimes = 1;

        public Integer getDeadlineReminder() {
            return this.deadlineReminder;
        }

        public Integer getReminderInterval() {
            return this.reminderInterval;
        }

        public Integer getReminderTimes() {
            return this.reminderTimes;
        }

        public void setDeadlineReminder(Integer num) {
            this.deadlineReminder = num;
        }

        public void setReminderInterval(Integer num) {
            this.reminderInterval = num;
        }

        public void setReminderTimes(Integer num) {
            this.reminderTimes = num;
        }
    }

    public String getBusinessModeChangePage() {
        return this.businessModeChangePage;
    }

    public SaveReminder getSaveReminder() {
        return this.saveReminder;
    }

    public void setBusinessModeChangePage(String str) {
        this.businessModeChangePage = str;
    }

    public void setSaveReminder(SaveReminder saveReminder) {
        this.saveReminder = saveReminder;
    }
}
