package p744wl;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.ApkBean;
import com.huawei.android.hicloud.cloudbackup.bean.BundleBean;
import com.huawei.android.hicloud.cloudbackup.bean.Next2hmosMappingItem;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import fk.C9721b;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.LongPredicate;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0240y;
import p015ak.C0241z;
import p514o9.C11839m;
import p617rl.C12526j;
import p815ym.AbstractC14026a;

/* renamed from: wl.c */
/* loaded from: classes6.dex */
public class C13619c {

    /* renamed from: a */
    public static C12526j f61274a = new C12526j();

    /* renamed from: b */
    public static String m81946b(String str, String str2, String str3) throws C9721b {
        if (str2 == null) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getCommonFilePath local path is null.");
        }
        if (NextRestoreConstants.BUNDLE_NAME_GALLERY.equals(str3)) {
            if (!str2.contains("database/rdb")) {
                return m81948d(str2);
            }
            str2 = str2.replace("database/rdb", "database");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append("nextdata");
        sb2.append(str4);
        sb2.append(str2);
        return sb2.toString();
    }

    /* renamed from: c */
    public static ApkBean m81947c(List<ApkBean> list) {
        if (C0209d.m1184K0(C0213f.m1377a(), NextRestoreConstants.PKG_NAME_GALLERY_DATA)) {
            for (ApkBean apkBean : list) {
                if (NextRestoreConstants.PKG_NAME_GALLERY_DATA.equals(apkBean.getName())) {
                    return apkBean;
                }
            }
            return null;
        }
        for (ApkBean apkBean2 : list) {
            if (NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D.equals(apkBean2.getName())) {
                return apkBean2;
            }
        }
        return null;
    }

    /* renamed from: d */
    public static String m81948d(String str) {
        return "/storage/emulated/0/Huawei/CloudClone/media/" + str;
    }

    /* renamed from: e */
    public static ApkBean m81949e(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<Next2hmosMappingItem> listM75412p0 = f61274a.m75412p0();
        if (listM75412p0 == null || listM75412p0.isEmpty()) {
            C11839m.m70689w("Next2hmosMappingUtil", "mappingItems is Empty");
            return null;
        }
        Iterator<Next2hmosMappingItem> it = listM75412p0.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Next2hmosMappingItem next = it.next();
            List<BundleBean> bundle = next.getBundle();
            List<ApkBean> apk = next.getApk();
            if (!AbstractC14026a.m84159a(bundle) && !AbstractC14026a.m84159a(apk)) {
                Iterator<BundleBean> it2 = bundle.iterator();
                while (it2.hasNext()) {
                    if (str.equals(it2.next().getName())) {
                        if (apk != null && apk.size() != 0) {
                            return apk.get(0);
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: f */
    public static boolean m81950f(String str) {
        return NextRestoreConstants.PKG_NAME_GALLERY_DATA.equals(str) || NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D.equals(str);
    }

    /* renamed from: g */
    public static boolean m81951g(String str) throws Throwable {
        ApkBean apkBeanM81947c;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<Next2hmosMappingItem> listM75412p0 = f61274a.m75412p0();
        if (AbstractC14026a.m84159a(listM75412p0)) {
            C11839m.m70689w("Next2hmosMappingUtil", "mappingItems is Empty");
            return false;
        }
        loop0: for (Next2hmosMappingItem next2hmosMappingItem : listM75412p0) {
            List<BundleBean> bundle = next2hmosMappingItem.getBundle();
            List<ApkBean> apk = next2hmosMappingItem.getApk();
            if (!AbstractC14026a.m84159a(bundle) && !AbstractC14026a.m84159a(apk)) {
                Iterator<BundleBean> it = bundle.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getName())) {
                        if (apk == null || apk.size() == 0) {
                            break loop0;
                        }
                        if (NextRestoreConstants.BUNDLE_NAME_GALLERY.equals(str)) {
                            apkBeanM81947c = m81947c(apk);
                            if (apkBeanM81947c == null) {
                                return false;
                            }
                        } else {
                            apkBeanM81947c = apk.get(0);
                        }
                        String name = apkBeanM81947c.getName();
                        if (!apkBeanM81947c.isSupport()) {
                            C11839m.m70688i("Next2hmosMappingUtil", "apk not support, apkName:" + name);
                            return false;
                        }
                        if (!C0240y.m1682d(C0213f.m1377a(), name)) {
                            C11839m.m70688i("Next2hmosMappingUtil", name + " not install but om config is support");
                            return (NextRestoreConstants.PKG_NAME_MEMO.equals(name) && C0240y.m1682d(C0213f.m1377a(), "com.example.android.notepad")) ? false : true;
                        }
                        if (C0241z.m1688f("160000300") < apkBeanM81947c.getHiDiskVerCode()) {
                            C11839m.m70688i("Next2hmosMappingUtil", "hidisk version mismatch, apkName:" + name);
                            return false;
                        }
                        long minVerCode = apkBeanM81947c.getMinVerCode();
                        final long jM1688f = C0241z.m1688f(C0240y.m1680b(C0213f.m1377a(), name));
                        if (jM1688f < minVerCode) {
                            C11839m.m70688i("Next2hmosMappingUtil", "minVersion mismatch, version is " + jM1688f + "; apkName:" + name);
                            return false;
                        }
                        long[] excludeVerCodes = apkBeanM81947c.getExcludeVerCodes();
                        if (excludeVerCodes != null && excludeVerCodes.length > 0 && Arrays.stream(excludeVerCodes).anyMatch(new LongPredicate() { // from class: wl.b
                            @Override // java.util.function.LongPredicate
                            public final boolean test(long j10) {
                                return C13619c.m81953i(jM1688f, j10);
                            }
                        })) {
                            C11839m.m70688i("Next2hmosMappingUtil", "excludeVerCodes match, not support, version is:" + jM1688f + "; apkName:" + name);
                            return false;
                        }
                        if (C12526j.m75322e1(name) || NextRestoreConstants.PKG_NAME_FILE_MANAGER.equals(name)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m81952h(String str) {
        return CBSBaseReq.CURRENT_API_VERSION.equals(str) || "V4".equals(str);
    }

    /* renamed from: i */
    public static /* synthetic */ boolean m81953i(long j10, long j11) {
        return j11 == j10;
    }
}
