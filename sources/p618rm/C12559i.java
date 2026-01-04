package p618rm;

import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.util.C2735t;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;
import p292fn.C9733f;
import p514o9.C11835i;
import p514o9.C11839m;

/* renamed from: rm.i */
/* loaded from: classes6.dex */
public class C12559i {
    /* renamed from: c */
    public static String m75509c(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf == -1 ? "" : name.substring(iLastIndexOf);
    }

    /* renamed from: d */
    public static boolean m75510d(CloudBackupStatus cloudBackupStatus) {
        if (!C9733f.m60705z().m60720O("backupBundleCitOpt")) {
            C11839m.m70688i("BundleApkRenamer", "isSupportRenameBundleApk featureSwitchOpen false");
            return false;
        }
        String strM60762u = C9733f.m60705z().m60762u("backupBundleCitOpt");
        if (TextUtils.isEmpty(strM60762u)) {
            C11839m.m70688i("BundleApkRenamer", "isSupportRenameBundleApk featureParameters isEmpty");
            return true;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(strM60762u).getJSONArray("apps");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                arrayList.add(jSONArray.getString(i10));
            }
            boolean z10 = arrayList.isEmpty() || arrayList.contains(cloudBackupStatus.m29870d());
            C11839m.m70686d("BundleApkRenamer", "isSupportRenameBundleApk appId: " + cloudBackupStatus.m29870d() + " ,isSupport: " + z10);
            return z10;
        } catch (Throwable th2) {
            C11839m.m70687e("BundleApkRenamer", "isSupportRenameBundleApk get app error: " + th2);
            return false;
        }
    }

    /* renamed from: e */
    public static /* synthetic */ List m75511e(Long l10) {
        return new ArrayList();
    }

    /* renamed from: g */
    public static void m75513g(File file, File file2) throws C9721b {
        if (file2.exists()) {
            C11839m.m70689w("BundleApkRenamer", "Target file already exists, may be overwritten deleteResult:" + C11835i.m70642f(file2));
        }
        if (file.renameTo(file2)) {
            return;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "renameBundleApkBeforeTar file name is empty: " + C10279b.m63452a(file2));
    }

    /* renamed from: h */
    public static File[] m75514h(File[] fileArr, final CloudBackupStatus cloudBackupStatus, Consumer<CloudBackupStatus> consumer) throws C9721b {
        if (fileArr == null || fileArr.length == 0 || cloudBackupStatus == null) {
            C11839m.m70687e("BundleApkRenamer", "Input file array or backupStatus is empty");
            return fileArr;
        }
        if (!m75510d(cloudBackupStatus)) {
            return fileArr;
        }
        HashMap map = new HashMap();
        for (File file : fileArr) {
            if (file == null) {
                C11839m.m70689w("BundleApkRenamer", "File object is null, skipping");
            } else {
                if (!file.exists()) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "renameBundleApkBeforeTar file not exist: " + C10279b.m63452a(file));
                }
                if (file.isDirectory()) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "Target is a directory, not a file: " + C10279b.m63452a(file));
                }
                if (!file.canRead() || !file.canWrite()) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "File is not readable or writable: " + C10279b.m63452a(file));
                }
                if (TextUtils.isEmpty(file.getName())) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "renameBundleApkBeforeTar file name is empty: " + C10279b.m63452a(file));
                }
                ((List) map.computeIfAbsent(Long.valueOf(file.length()), new Function() { // from class: rm.g
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return C12559i.m75511e((Long) obj);
                    }
                })).add(file);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            long jLongValue = ((Long) entry.getKey()).longValue();
            List<File> list = (List) entry.getValue();
            if (list.size() == 1) {
                File file2 = (File) list.get(0);
                File fileM63441g = C10278a.m63441g(C10278a.m63437c(file2), jLongValue + m75509c(file2));
                m75513g(file2, fileM63441g);
                arrayList.add(fileM63441g);
            } else {
                int i10 = 0;
                for (File file3 : list) {
                    File fileM63437c = C10278a.m63437c(file3);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(jLongValue);
                    sb2.append("_");
                    int i11 = i10 + 1;
                    sb2.append(i10);
                    sb2.append(m75509c(file3));
                    File fileM63441g2 = C10278a.m63441g(fileM63437c, sb2.toString());
                    m75513g(file3, fileM63441g2);
                    arrayList.add(fileM63441g2);
                    i10 = i11;
                }
            }
        }
        arrayList.sort(Comparator.comparing(new C2735t()));
        if (C1443a.f6214b.booleanValue()) {
            C11839m.m70686d("BundleApkRenamer", "renameBundleApk success appId: " + cloudBackupStatus.m29870d() + " ,before: " + ((List) Arrays.stream(fileArr).map(new C2735t()).collect(Collectors.toList())).toString() + " after: " + ((List) arrayList.stream().map(new C2735t()).collect(Collectors.toList())).toString());
        }
        Optional.ofNullable(consumer).ifPresent(new Consumer() { // from class: rm.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(cloudBackupStatus);
            }
        });
        return (File[]) arrayList.toArray(new File[0]);
    }
}
