package com.huawei.android.hicloud.cloudbackup.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.os.PersistableBundle;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupCacheRecord;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12571m;

/* loaded from: classes2.dex */
public class CloudBackupCacheJobService extends JobService {
    private static final String TAG = "CloudBackupCacheJobService";

    private void deleteModuleCache(Context context, String str, String str2, String str3) {
        BackupCacheRecord.delete(context, str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append(str3);
        C12571m.m75547i(sb2.toString());
        C12571m.m75547i(str + str4 + str3);
    }

    private long getCacheDuration() {
        return new C12526j().m75408n0(false);
    }

    private Context getContext() {
        Context contextM1377a = C0213f.m1377a();
        return contextM1377a == null ? getApplicationContext() : contextM1377a;
    }

    private boolean isDirInvalid(File file) {
        String[] list;
        return file == null || !file.exists() || (list = file.list()) == null || list.length <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCommd(JobParameters jobParameters) {
        C11839m.m70688i(TAG, "onStartJob");
        if (CBAccess.hasTaskWorking()) {
            return;
        }
        Context context = getContext();
        if (jobParameters == null || jobParameters.getExtras() == null) {
            C11839m.m70687e(TAG, "onStartJob params or value is null");
            return;
        }
        PersistableBundle extras = jobParameters.getExtras();
        String string = extras.getString("cloneTempPath");
        String string2 = extras.getString("dataTempPath");
        File fileM63442h = C10278a.m63442h(string);
        if (isDirInvalid(fileM63442h)) {
            BackupCacheRecord.clear(context);
            C12571m.m75547i(string2);
            C11839m.m70688i(TAG, "isDirInvalid false");
            return;
        }
        String[] list = fileM63442h.list();
        Map<String, ?> all = BackupCacheRecord.getAll(context);
        Set<String> setKeySet = all.keySet();
        List<String> arrayList = new ArrayList();
        if (list != null) {
            arrayList = Arrays.asList(list);
        }
        arrayList.removeAll(setKeySet);
        for (String str : arrayList) {
            C11839m.m70688i(TAG, "sp not contain " + str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string2);
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(str);
            C12571m.m75547i(sb2.toString());
            C12571m.m75547i(string + str2 + str);
        }
        long cacheDuration = getCacheDuration();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            if (isDirInvalid(C10278a.m63442h(string + File.separator + key))) {
                BackupCacheRecord.delete(context, key);
                C11839m.m70688i(TAG, "appId: " + key + " isDirInvalid false");
            } else {
                Object value = entry.getValue();
                if (value instanceof Long) {
                    long jLongValue = ((Long) value).longValue();
                    if (jLongValue <= 0) {
                        deleteModuleCache(context, string, string2, key);
                        C11839m.m70688i(TAG, "appId: " + key + " time <= 0");
                    } else {
                        long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                        if (cacheDuration == 0 || jCurrentTimeMillis > cacheDuration || jCurrentTimeMillis < 0) {
                            deleteModuleCache(context, string, string2, key);
                            C11839m.m70688i(TAG, "appId: " + key + " ,time Expired ,time = " + jLongValue);
                        }
                    }
                } else {
                    deleteModuleCache(context, string, string2, key);
                    C11839m.m70688i(TAG, "appId: " + key + " value not long");
                }
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupCacheJobService.1
            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                CloudBackupCacheJobService.this.startCommd(jobParameters);
            }

            @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
            public void release() {
                super.release();
                CloudBackupCacheJobService.this.jobFinished(jobParameters, false);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C11839m.m70688i(TAG, "CloudBackupJobService onStopJob");
        return false;
    }
}
