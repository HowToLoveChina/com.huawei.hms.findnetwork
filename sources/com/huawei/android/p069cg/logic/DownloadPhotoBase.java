package com.huawei.android.p069cg.logic;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p015ak.C0219i;
import p031b7.C1120a;
import p511o6.C11820b;
import p572qb.C12297a;

/* loaded from: classes2.dex */
public class DownloadPhotoBase {

    /* renamed from: b */
    public static final Map<String, Map<String, Object>> f10972b = new ConcurrentHashMap();

    /* renamed from: c */
    public static final Map<String, Map<String, Object>> f10973c = new ConcurrentHashMap();

    /* renamed from: d */
    public static final Map<String, Map<String, Object>> f10974d = new ConcurrentHashMap();

    /* renamed from: a */
    public Context f10975a;

    public DownloadPhotoBase(Context context) {
        this.f10975a = context;
    }

    /* renamed from: a */
    public static void m14406a(Map<String, Object> map) {
        AbstractCallableC2320a abstractCallableC2320a;
        if (map == null || !map.containsKey("FIXED_BASECALLABLE_KEY") || (abstractCallableC2320a = (AbstractCallableC2320a) map.get("FIXED_BASECALLABLE_KEY")) == null || abstractCallableC2320a.getCallParam() == null) {
            return;
        }
        FileInfo fileInfo = (FileInfo) abstractCallableC2320a.getCallParam();
        String shareId = fileInfo.getShareId();
        if (TextUtils.isEmpty(fileInfo.getShareId())) {
            shareId = fileInfo.getAlbumId();
        }
        StringBuilder sb2 = new StringBuilder(shareId);
        sb2.append("_");
        sb2.append(TextUtils.isEmpty(fileInfo.getShareId()) ? fileInfo.getUniqueId() : fileInfo.getHash());
        sb2.append("_");
        sb2.append(abstractCallableC2320a.getThumbType());
        sb2.append("_");
        f10972b.put(sb2.toString(), map);
    }

    /* renamed from: b */
    public static Map<String, Object> m14407b(String str) {
        Map<String, Map<String, Object>> map = f10972b;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }

    /* renamed from: c */
    public static Map<String, Object> m14408c(String str) {
        Map<String, Map<String, Object>> map = f10973c;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }

    /* renamed from: d */
    public static String m14409d(int i10) {
        return i10 != 1 ? i10 != 2 ? "content" : "smallthumbnail" : "largethumbnail";
    }

    /* renamed from: e */
    public static boolean m14410e(Context context, FileInfo fileInfo, int i10, boolean z10, boolean z11) {
        if (fileInfo == null) {
            return false;
        }
        String strM70401f = C11820b.m70401f(z10 ? fileInfo.getShareId() : fileInfo.getAlbumId(), !z10 ? fileInfo.getUniqueId() : fileInfo.getHash(), i10);
        if (strM70401f == null) {
            return false;
        }
        Map<String, Map<String, Object>> map = f10972b;
        if (!map.containsKey(strM70401f)) {
            return false;
        }
        if (z11) {
            m14414i(strM70401f);
            map.remove(strM70401f);
        }
        return true;
    }

    /* renamed from: f */
    public static boolean m14411f() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ORIGINAL_DOWNLOAD_FILE_LIST size");
        sb2.append(f10974d.size());
        C1120a.m6675d("DownloadPhotoBase", sb2.toString());
        return !r1.isEmpty();
    }

    /* renamed from: g */
    public static void m14412g() {
        m14413h(0);
    }

    /* renamed from: h */
    public static void m14413h(int i10) {
        Iterator<Map.Entry<String, Map<String, Object>>> it = f10972b.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (i10 == 0) {
                if (key.endsWith("_0_")) {
                    it.remove();
                }
            } else if (key.endsWith("_1_") || key.endsWith("_2_")) {
                it.remove();
            }
        }
        C1120a.m6675d("DownloadPhotoBase", "DOWNLOAD_FILELIST size" + f10972b.size());
    }

    /* renamed from: i */
    public static void m14414i(String str) {
        f10974d.remove(str);
        if (!m14411f() && str.endsWith("_0_") && C0219i.f814b) {
            C1120a.m6677i("DownloadPhotoBase", "remove downloadApply applyType");
            C12297a.m73908c().m73915h("user-download_apply");
        }
    }
}
