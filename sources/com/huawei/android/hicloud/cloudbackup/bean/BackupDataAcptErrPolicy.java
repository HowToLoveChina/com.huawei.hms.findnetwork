package com.huawei.android.hicloud.cloudbackup.bean;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.BackupDataAcptErrPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import p514o9.C11839m;
import p815ym.AbstractC14026a;

/* loaded from: classes2.dex */
public class BackupDataAcptErrPolicy {
    public static final int DEFAULT_RETRY_TIMES = 2;
    private static final int REPORT = 1;
    private static final String TAG = "BackupDataAcptErrPolicy";
    private List<Policy> policy;
    private Integer report;
    private Integer retryTimes;

    public static class Policy {
        private String appId;
        private List<String> fileNames;

        public String getAppId() {
            return this.appId;
        }

        public List<String> getFileNames() {
            List<String> list = this.fileNames;
            return list == null ? new ArrayList() : list;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setFileNames(List<String> list) {
            this.fileNames = list;
        }

        public String toString() {
            return "Policy{appId='" + this.appId + "', fileNames=" + this.fileNames + '}';
        }
    }

    public static Policy getPolicyByAppId(final String str, BackupDataAcptErrPolicy backupDataAcptErrPolicy) {
        if (backupDataAcptErrPolicy == null) {
            return null;
        }
        List<Policy> policy = backupDataAcptErrPolicy.getPolicy();
        if (!AbstractC14026a.m84159a(policy)) {
            return policy.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.bean.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BackupDataAcptErrPolicy.lambda$getPolicyByAppId$0(str, (BackupDataAcptErrPolicy.Policy) obj);
                }
            }).findFirst().orElse(null);
        }
        C11839m.m70689w(TAG, "getPolicyByAppId policyList is empty");
        return null;
    }

    public static boolean isReport(BackupDataAcptErrPolicy backupDataAcptErrPolicy) {
        if (backupDataAcptErrPolicy == null) {
            return false;
        }
        Integer num = 1;
        return num.equals(backupDataAcptErrPolicy.report);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getPolicyByAppId$0(String str, Policy policy) {
        return TextUtils.equals(policy.getAppId(), str);
    }

    public List<Policy> getPolicy() {
        List<Policy> list = this.policy;
        return list == null ? new ArrayList() : list;
    }

    public int getRetryTimes() {
        Integer num = this.retryTimes;
        if (num == null) {
            return 2;
        }
        return Math.max(0, num.intValue());
    }

    public void setPolicy(List<Policy> list) {
        this.policy = list;
    }

    public void setRetryTimes(Integer num) {
        this.retryTimes = num;
    }

    public String toString() {
        return "AppBatchBackupRetryPolicy{policy=" + this.policy + ", retryTimes=" + this.retryTimes + ", report=" + this.report + '}';
    }
}
