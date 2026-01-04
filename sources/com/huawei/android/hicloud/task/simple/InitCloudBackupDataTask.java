package com.huawei.android.hicloud.task.simple;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupUserInfo;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.p088ui.notification.RefurbishedNotification;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import fk.C9721b;
import il.C10542o;
import p429kk.C11058a;
import p514o9.C11839m;
import p572qb.C12299b;
import p581qk.AbstractC12367d;
import p617rl.C12526j;
import p652t9.EnumC12999a;
import p709vj.C13452e;
import p711vl.C13466f;
import p814yl.C13998b0;
import pm.C12176c;
import to.C13049a;

/* loaded from: classes3.dex */
public class InitCloudBackupDataTask extends AbstractC12367d {

    /* renamed from: a */
    public final Context f13100a;

    public InitCloudBackupDataTask(Context context) {
        this.f13100a = context;
    }

    /* renamed from: e */
    public static void m18100e(long j10) {
        SettingOperator settingOperator = new SettingOperator();
        if (j10 != settingOperator.querylastsuccesstime()) {
            C11839m.m70688i("InitCloudBackupDataTask", "refreshBackupSuccessTime: " + j10);
            settingOperator.replace(new Settings[]{new Settings("lastsuccesstime", String.valueOf(j10), "2")});
            C12299b.m73927i();
        }
    }

    /* renamed from: c */
    public final boolean m18101c(long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iM75350N = new C12526j().m75350N();
        C11839m.m70688i("InitCloudBackupDataTask", "lastRefreshTime: " + j10 + ", now: " + jCurrentTimeMillis + ", correctLastBackupEndTime: " + iM75350N);
        return jCurrentTimeMillis - j10 >= ((long) iM75350N) * 86400000;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("InitCloudBackupDataTask", "InitCloudBackupDataTask call");
        m18102d();
        try {
            C11839m.m70688i("InitCloudBackupDataTask", "start about request");
            new C12176c().m73272a(C11058a.m66627b("02101"));
        } catch (C9721b e10) {
            C11839m.m70687e("InitCloudBackupDataTask", "daily query about error. " + e10.toString());
        }
        new RefurbishedNotification().checkRefurbishBackupRecords(m18103f(this.f13100a));
    }

    /* renamed from: d */
    public final void m18102d() {
        try {
            long jM78705D = new C13049a(EnumC12999a.CLOUD_BACKUP, null).m78705D();
            C11839m.m70688i("InitCloudBackupDataTask", "package totalCapacity: " + jM78705D);
            String str = jM78705D > 0 ? "1" : "0";
            C13452e.m80781L().m80884Z2(str);
            String strM80975u0 = C13452e.m80781L().m80975u0();
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_id", "");
            contentValues.put("user_id_encrypt", strM80975u0);
            contentValues.put("user_type", str);
            C12299b.m73938t(contentValues);
        } catch (Exception e10) {
            C11839m.m70688i("InitCloudBackupDataTask", "get totalCapacity error: " + e10.toString());
        }
    }

    /* renamed from: f */
    public final CloudBackupUserInfo m18103f(Context context) {
        C11839m.m70688i("InitCloudBackupDataTask", "refreshLastSuccessTime start");
        CloudBackupUserInfo cloudBackupUserInfoM64685l1 = null;
        try {
        } catch (C9721b e10) {
            C11839m.m70687e("InitCloudBackupDataTask", "queryLastSuccessTime failed." + e10.toString());
        }
        if (TextUtils.isEmpty(C13452e.m80781L().m80950o())) {
            C11839m.m70688i("InitCloudBackupDataTask", "refreshLastSuccessTime getDeviceID is null");
            return null;
        }
        long backupEndTime = 0;
        if (!m18101c(C13466f.m81073d().m81078f("lastRefreshBackupSuccessTime", 0L))) {
            C11839m.m70688i("InitCloudBackupDataTask", "no need refresh last success time");
            return null;
        }
        Long lM84109K0 = new C13998b0().m84109K0();
        C11839m.m70688i("InitCloudBackupDataTask", "lastSuccessTime from about is: " + lM84109K0);
        if (lM84109K0 == null) {
            cloudBackupUserInfoM64685l1 = new C10542o().m64685l1(true, true, false);
            CloudRecoveryItem currentLatestBackupRecord = cloudBackupUserInfoM64685l1.getCurrentLatestBackupRecord();
            if (currentLatestBackupRecord != null) {
                backupEndTime = currentLatestBackupRecord.getBackupEndTime();
            }
            lM84109K0 = Long.valueOf(backupEndTime);
            C11839m.m70688i("InitCloudBackupDataTask", "lastSuccessTime from deviceList is: " + lM84109K0);
        }
        C13466f.m81073d().m81083k("lastRefreshBackupSuccessTime", System.currentTimeMillis());
        m18100e(lM84109K0.longValue());
        C11839m.m70688i("InitCloudBackupDataTask", "queryLastSuccessTime lastSuccessTime = " + lM84109K0);
        return cloudBackupUserInfoM64685l1;
    }
}
