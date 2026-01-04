package com.huawei.android.hicloud.common.provider;

import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.C1461a;
import com.huawei.hicloud.bean.EntryPackageInfo;
import com.huawei.hicloud.bean.EntryTrustConfig;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9733f;
import p459lp.C11326d;
import p514o9.C11839m;
import p618rm.C12540b1;

/* loaded from: classes3.dex */
public class HiCloudStatusProvider extends HicloudFeatursProvider {

    /* renamed from: f */
    public static final UriMatcher f11950f;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11950f = uriMatcher;
        uriMatcher.addURI("com.huawei.android.hicloud.stateProvider", "status_content_uri_query", 32);
    }

    /* renamed from: e0 */
    public final boolean m15636e0(Map<String, EntryPackageInfo> map) throws PackageManager.NameNotFoundException {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            C11839m.m70687e("HiCloudStatusProvider", "calling pkg name empty");
            return false;
        }
        String strM68050l = C11326d.m68050l(getContext(), callingPackage);
        if (!map.containsKey(callingPackage)) {
            C1461a.m8357d("HiCloudStatusProvider", "packageInfoMap not contain the pkgName!");
            return false;
        }
        EntryPackageInfo entryPackageInfo = map.get(callingPackage);
        if (entryPackageInfo == null || entryPackageInfo.getPackSigns() == null) {
            return false;
        }
        return entryPackageInfo.getPackSigns().contains(strM68050l);
    }

    /* renamed from: f0 */
    public List<EntryPackageInfo> m15637f0() throws Throwable {
        String strM1266i2 = C0209d.m1266i2(C0213f.m1378b(), "hicloud_entry_param_local.json");
        C1461a.m8357d("HiCloudStatusProvider", "getConfigFromFile");
        return m15638g0(strM1266i2);
    }

    /* renamed from: g0 */
    public final List<EntryPackageInfo> m15638g0(String str) {
        EntryTrustConfig entryTrustConfig;
        ArrayList arrayList = new ArrayList();
        return (TextUtils.isEmpty(str) || (entryTrustConfig = (EntryTrustConfig) C12540b1.m75483a(str, EntryTrustConfig.class)) == null) ? arrayList : entryTrustConfig.getEntryTrusts();
    }

    /* renamed from: h0 */
    public final boolean m15639h0() {
        EntryTrustConfig entryTrustConfig;
        Map<String, EntryPackageInfo> map = (Map) m15637f0().stream().collect(Collectors.toMap(new Function() { // from class: g9.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((EntryPackageInfo) obj).getPackageName();
            }
        }, Function.identity()));
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            return m15636e0(map);
        }
        String entryTrustConfigList = hiCloudSysParamMapM60757p.getEntryTrustConfigList();
        if (!TextUtils.isEmpty(entryTrustConfigList) && (entryTrustConfig = (EntryTrustConfig) C12540b1.m75483a(entryTrustConfigList, EntryTrustConfig.class)) != null) {
            List<EntryPackageInfo> entryTrusts = entryTrustConfig.getEntryTrusts();
            if (entryTrusts == null || entryTrusts.size() == 0) {
                return m15636e0(map);
            }
            for (EntryPackageInfo entryPackageInfo : entryTrusts) {
                String packageName = entryPackageInfo.getPackageName();
                if (map.containsKey(packageName)) {
                    EntryPackageInfo entryPackageInfo2 = map.get(packageName);
                    if (entryPackageInfo2 != null) {
                        List<String> packSigns = entryPackageInfo2.getPackSigns();
                        packSigns.addAll(entryPackageInfo.getPackSigns());
                        entryPackageInfo2.setPackSigns(packSigns);
                        map.put(packageName, entryPackageInfo2);
                    }
                } else {
                    map.put(packageName, entryPackageInfo);
                }
            }
            return m15636e0(map);
        }
        return m15636e0(map);
    }

    @Override // com.huawei.android.hicloud.common.provider.HicloudFeatursProvider, android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int iMatch = f11950f.match(uri);
        C11839m.m70687e("HiCloudStatusProvider", "HiCloudStatusProvider enter with other app");
        if (iMatch == 32 && m15639h0()) {
            return m15663W(str, strArr2);
        }
        C11839m.m70687e("HiCloudStatusProvider", "can not parse the uri:" + uri);
        return new MatrixCursor(new String[0]);
    }
}
