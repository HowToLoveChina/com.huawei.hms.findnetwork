package com.huawei.android.backup.service.logic;

import android.annotation.TargetApi;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.BackupConstant;
import java.io.IOException;
import java.util.UUID;
import p229di.C9150o;
import p229di.C9153r;

@TargetApi(26)
/* loaded from: classes.dex */
public class RequestPackageSize {

    /* renamed from: a */
    public StorageStatsManager f9585a;

    /* renamed from: b */
    public PackageManager f9586b;

    public RequestPackageSize(Context context) {
        if (context == null) {
            return;
        }
        this.f9586b = context.getPackageManager();
        this.f9585a = (StorageStatsManager) context.getSystemService("storagestats");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088 A[RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long m12745a(java.lang.String r21, long r22, int r24) {
        /*
            r20 = this;
            r0 = r21
            java.lang.Long r1 = java.lang.Long.valueOf(r22)
            java.lang.String r2 = "excludeExternalSize begin, packageName : "
            java.lang.String r3 = ", appDataSize : "
            java.lang.Object[] r1 = new java.lang.Object[]{r2, r0, r3, r1}
            java.lang.String r2 = "RequestPackageSize"
            com.huawei.android.backup.filelogic.utils.C2111d.m12654j(r2, r1)
            android.os.Environment r1 = new android.os.Environment
            r1.<init>()
            java.io.File[] r3 = p229di.C9147l.m57483b(r1, r0)
            java.io.File[] r4 = p229di.C9147l.m57482a(r1, r0)
            java.io.File[] r1 = p229di.C9147l.m57484c(r1, r0)
            java.lang.String r5 = "com.tencent.mm"
            boolean r0 = r0.equals(r5)
            r5 = 0
            r6 = 0
            if (r0 == 0) goto L44
            int r0 = r3.length
            if (r0 <= 0) goto L39
            r0 = r3[r5]
            long r8 = p699v4.C13334c.m79988u(r0)
            goto L3a
        L39:
            r8 = r6
        L3a:
            int r0 = r4.length
            if (r0 <= 0) goto L54
            r0 = r4[r5]
            long r3 = p699v4.C13334c.m79988u(r0)
            goto L55
        L44:
            int r0 = r3.length
            if (r0 <= 0) goto L53
            r0 = r3[r5]
            java.io.File r0 = r0.getParentFile()
            long r3 = p699v4.C13334c.m79988u(r0)
            r8 = r3
            goto L54
        L53:
            r8 = r6
        L54:
            r3 = r6
        L55:
            int r0 = r1.length
            if (r0 <= 0) goto L5f
            r0 = r1[r5]
            long r0 = p699v4.C13334c.m79988u(r0)
            goto L60
        L5f:
            r0 = r6
        L60:
            long r10 = r22 - r8
            long r10 = r10 - r3
            long r10 = r10 - r0
            java.lang.Long r13 = java.lang.Long.valueOf(r8)
            java.lang.Long r15 = java.lang.Long.valueOf(r3)
            java.lang.Long r17 = java.lang.Long.valueOf(r10)
            java.lang.Long r19 = java.lang.Long.valueOf(r0)
            java.lang.String r12 = "excludeExternalSize end, externalFileSize : "
            java.lang.String r14 = ", externalCacheSize : "
            java.lang.String r16 = ", realDataSize : "
            java.lang.String r18 = ", externalMediaSize : "
            java.lang.Object[] r0 = new java.lang.Object[]{r12, r13, r14, r15, r16, r17, r18, r19}
            com.huawei.android.backup.filelogic.utils.C2111d.m12654j(r2, r0)
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 >= 0) goto L88
            return r6
        L88:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.service.logic.RequestPackageSize.m12745a(java.lang.String, long, int):long");
    }

    /* renamed from: b */
    public long m12746b(String str, int i10) {
        C2111d.m12653i("RequestPackageSize", "get app data size start: " + str);
        try {
            PackageManager packageManager = this.f9586b;
            if (packageManager != null) {
                return m12747c(C9150o.m57487a(packageManager, str, 0, i10).storageUuid, str, i10);
            }
            C2111d.m12653i("RequestPackageSize", "mPackageManager is null");
            return 0L;
        } catch (Exception unused) {
            C2111d.m12658n("RequestPackageSize", "getAppDataInfo exception packageName ", str);
            return 0L;
        }
    }

    /* renamed from: c */
    public final long m12747c(UUID uuid, String str, int i10) throws PackageManager.NameNotFoundException, IOException {
        StorageStatsManager storageStatsManager = this.f9585a;
        if (storageStatsManager == null) {
            C2111d.m12646b("RequestPackageSize", "getAPPDataInfo : mStorageStatsManager is null");
            return 0L;
        }
        try {
            StorageStats storageStatsQueryStatsForPackage = storageStatsManager.queryStatsForPackage(uuid, str, m12748d(i10));
            long dataBytes = storageStatsQueryStatsForPackage.getDataBytes();
            long cacheBytes = storageStatsQueryStatsForPackage.getCacheBytes();
            C2111d.m12653i("RequestPackageSize", "get app data size dataBytes: " + dataBytes + ", cacheBytes: " + cacheBytes);
            if (BackupConstant.m13146t().containsValue(str) && !BackupConstant.m13149w(str)) {
                return dataBytes - cacheBytes;
            }
            long jM12745a = m12745a(str, dataBytes, i10);
            return jM12745a;
        } catch (PackageManager.NameNotFoundException | IOException | SecurityException unused) {
            C2111d.m12648d("RequestPackageSize", "queryStatsForPackage exception happen");
            return 0L;
        }
    }

    /* renamed from: d */
    public final UserHandle m12748d(int i10) {
        return C9153r.m57493a(i10);
    }
}
