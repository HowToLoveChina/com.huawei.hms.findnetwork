package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class BackupLockParams {
    private final String backupDeviceId;
    private final int backupTimes;
    private final String bakId;
    private final long bkStartDays;
    private final String flowControlCnt;
    private final boolean fullBK;
    private final String gradeCode;
    private final boolean isClean;
    private final String lastBkCompleteDays;
    private final int lockByDelDevice;
    private final int lockByDelDeviceFlag;
    private LockParamVFSRef lockParamVFSRef;

    public static class LockParamBak {
        private final int backupTimes;
        private final String bakId;
        private final long bkStartDays;
        private final String flowControlCnt;
        private final boolean fullBK;
        private final String lastBkCompleteDays;

        public LockParamBak(String str, int i10, long j10, boolean z10, String str2, String str3) {
            this.bakId = str;
            this.backupTimes = i10;
            this.bkStartDays = j10;
            this.fullBK = z10;
            this.lastBkCompleteDays = str2;
            this.flowControlCnt = str3;
        }

        public int getBackupTimes() {
            return this.backupTimes;
        }

        public String getBakId() {
            return this.bakId;
        }

        public long getBkStartDays() {
            return this.bkStartDays;
        }

        public String getFlowControlCnt() {
            return this.flowControlCnt;
        }

        public String getLastBkCompleteDays() {
            return this.lastBkCompleteDays;
        }

        public boolean isFullBK() {
            return this.fullBK;
        }
    }

    public static class LockParamDevice {
        private final String backupDeviceId;
        private final int lockByDelDevice;
        private final int lockByDelDeviceFlag;

        public LockParamDevice(String str, int i10, int i11) {
            this.backupDeviceId = str;
            this.lockByDelDevice = i10;
            this.lockByDelDeviceFlag = i11;
        }

        public String getBackupDeviceId() {
            return this.backupDeviceId;
        }

        public int getLockByDelDevice() {
            return this.lockByDelDevice;
        }

        public int getLockByDelDeviceFlag() {
            return this.lockByDelDeviceFlag;
        }
    }

    public static class LockParamVFSRef {
        private long availableSpaceSize;
        private long backupSize;
        private boolean noRefVfsFile;
        private long vfsRefSize;

        public LockParamVFSRef(long j10, long j11, boolean z10, long j12) {
            this.backupSize = j10;
            this.availableSpaceSize = j11;
            this.noRefVfsFile = z10;
            this.vfsRefSize = j12;
        }

        public long getAvailableSpaceSize() {
            return this.availableSpaceSize;
        }

        public long getBackupSize() {
            return this.backupSize;
        }

        public long getVfsRefSize() {
            return this.vfsRefSize;
        }

        public boolean isNoRefVfsFile() {
            return this.noRefVfsFile;
        }
    }

    public BackupLockParams(LockParamDevice lockParamDevice, LockParamBak lockParamBak, String str, boolean z10) {
        this.backupDeviceId = lockParamDevice.getBackupDeviceId();
        this.bakId = lockParamBak.getBakId();
        this.gradeCode = str;
        this.backupTimes = lockParamBak.getBackupTimes();
        this.bkStartDays = lockParamBak.getBkStartDays();
        this.fullBK = lockParamBak.isFullBK();
        this.isClean = z10;
        this.lastBkCompleteDays = lockParamBak.getLastBkCompleteDays();
        this.flowControlCnt = lockParamBak.getFlowControlCnt();
        this.lockByDelDevice = lockParamDevice.getLockByDelDevice();
        this.lockByDelDeviceFlag = lockParamDevice.getLockByDelDeviceFlag();
    }

    public String getBackupDeviceId() {
        return this.backupDeviceId;
    }

    public int getBackupTimes() {
        return this.backupTimes;
    }

    public String getBakId() {
        return this.bakId;
    }

    public long getBkStartDays() {
        return this.bkStartDays;
    }

    public String getFlowControlCnt() {
        return this.flowControlCnt;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getLastBkCompleteDays() {
        return this.lastBkCompleteDays;
    }

    public int getLockByDelDevice() {
        return this.lockByDelDevice;
    }

    public int getLockByDelDeviceFlag() {
        return this.lockByDelDeviceFlag;
    }

    public LockParamVFSRef getLockParamVFSRef() {
        return this.lockParamVFSRef;
    }

    public boolean isClean() {
        return this.isClean;
    }

    public boolean isFullBK() {
        return this.fullBK;
    }

    public BackupLockParams(LockParamDevice lockParamDevice, LockParamBak lockParamBak, String str, boolean z10, LockParamVFSRef lockParamVFSRef) {
        this.backupDeviceId = lockParamDevice.getBackupDeviceId();
        this.bakId = lockParamBak.getBakId();
        this.gradeCode = str;
        this.backupTimes = lockParamBak.getBackupTimes();
        this.bkStartDays = lockParamBak.getBkStartDays();
        this.fullBK = lockParamBak.isFullBK();
        this.isClean = z10;
        this.lastBkCompleteDays = lockParamBak.getLastBkCompleteDays();
        this.flowControlCnt = lockParamBak.getFlowControlCnt();
        this.lockByDelDevice = lockParamDevice.getLockByDelDevice();
        this.lockByDelDeviceFlag = lockParamDevice.getLockByDelDeviceFlag();
        this.lockParamVFSRef = lockParamVFSRef;
    }
}
