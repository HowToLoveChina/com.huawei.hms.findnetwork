package p010a9;

import java.io.Serializable;
import java.util.List;

/* renamed from: a9.b */
/* loaded from: classes3.dex */
public class C0080b implements Serializable {
    private static final long serialVersionUID = -5711619776595550360L;
    private a backupSwitch;
    private int dataVersion = 1;
    private String frameworkType;
    private List<b> syncSwitch;
    private String uidSha256;

    /* renamed from: a9.b$a */
    public static class a implements Serializable {
        private static final long serialVersionUID = 3211046525596769863L;
        private List<b> appSwitch;
        private int backupFrequency;
        private int baseStatus;
        private Integer baseStatusNew;
        private int status;
        private Integer statusNew;

        public List<b> getAppSwitch() {
            return this.appSwitch;
        }

        public int getBackupFrequency() {
            return this.backupFrequency;
        }

        public int getBaseStatus() {
            return this.baseStatus;
        }

        public Integer getBaseStatusNew() {
            return this.baseStatusNew;
        }

        public int getStatus() {
            return this.status;
        }

        public Integer getStatusNew() {
            return this.statusNew;
        }

        public void setAppSwitch(List<b> list) {
            this.appSwitch = list;
        }

        public void setBackupFrequency(int i10) {
            this.backupFrequency = i10;
        }

        public void setBaseStatus(int i10) {
            this.baseStatus = i10;
        }

        public void setBaseStatusNew(Integer num) {
            this.baseStatusNew = num;
        }

        public void setStatus(int i10) {
            this.status = i10;
        }

        public void setStatusNew(Integer num) {
            this.statusNew = num;
        }
    }

    /* renamed from: a9.b$b */
    public static class b implements Serializable {
        private static final long serialVersionUID = -6349666505803266785L;
        private String bundleName;
        private Integer memberStatus;
        private int status;
        private String type;

        public String getBundleName() {
            return this.bundleName;
        }

        public Integer getMemberStatus() {
            return this.memberStatus;
        }

        public int getStatus() {
            return this.status;
        }

        public String getType() {
            return this.type;
        }

        public void setBundleName(String str) {
            this.bundleName = str;
        }

        public void setMemberStatus(Integer num) {
            this.memberStatus = num;
        }

        public void setStatus(int i10) {
            this.status = i10;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public a getBackupSwitch() {
        return this.backupSwitch;
    }

    public int getDataVersion() {
        return this.dataVersion;
    }

    public String getFrameworkType() {
        return this.frameworkType;
    }

    public List<b> getSyncSwitch() {
        return this.syncSwitch;
    }

    public String getUidSha256() {
        return this.uidSha256;
    }

    public void setBackupSwitch(a aVar) {
        this.backupSwitch = aVar;
    }

    public void setFrameworkType(String str) {
        this.frameworkType = str;
    }

    public void setSyncSwitch(List<b> list) {
        this.syncSwitch = list;
    }

    public void setUidSha256(String str) {
        this.uidSha256 = str;
    }
}
