package p292fn;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import cn.C1461a;
import com.google.gson.Gson;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.OmPicture;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.io.File;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0227m;
import p527on.C11976a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import pk.C12158a;

/* renamed from: fn.h */
/* loaded from: classes6.dex */
public class C9735h {

    /* renamed from: a */
    public Random f47985a = new Random();

    /* renamed from: fn.h$b */
    public static class b extends AbstractC12367d {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            OmPicture omPicture;
            try {
                JSONArray jSONArrayM60777g = C9735h.m60771f().m60777g();
                if (jSONArrayM60777g == null) {
                    return;
                }
                for (int i10 = 0; i10 < jSONArrayM60777g.length(); i10++) {
                    String string = jSONArrayM60777g.getString(i10);
                    if (!TextUtils.isEmpty(string) && (omPicture = (OmPicture) new Gson().fromJson(string, OmPicture.class)) != null) {
                        C9735h.m60771f().m60773b(omPicture.getKey(), omPicture.getUrl(), omPicture.getHash());
                    }
                }
            } catch (Exception e10) {
                C1461a.m8358e("OmPictureManager", "parse overSizePictures exception: " + e10.toString());
            }
        }
    }

    /* renamed from: fn.h$c */
    public static class c {

        /* renamed from: a */
        public static C9735h f47986a = new C9735h();
    }

    /* renamed from: f */
    public static C9735h m60771f() {
        return c.f47986a;
    }

    /* renamed from: a */
    public final void m60772a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && !file.delete()) {
            C1461a.m8358e("OmPictureManager", "picture file delete fail");
        }
    }

    /* renamed from: b */
    public void m60773b(String str, String str2, String str3) throws InterruptedException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !URLUtil.isHttpsUrl(str2)) {
            C1461a.m8358e("OmPictureManager", "param illegal, key: " + str);
            return;
        }
        String strM60778h = m60778h(str2);
        if (TextUtils.isEmpty(strM60778h)) {
            strM60778h = m60776e(str2);
        }
        if (TextUtils.isEmpty(strM60778h)) {
            C1461a.m8358e("OmPictureManager", "picturePath is empty, key: " + str);
            return;
        }
        try {
            if (new File(strM60778h).exists()) {
                if (str3.equals(C0227m.m1591d(strM60778h))) {
                    return;
                }
            }
        } catch (C9721b e10) {
            C1461a.m8358e("OmPictureManager", "getFileSHA256Str " + str + " exception: " + e10.toString());
        }
        m60772a(strM60778h);
        C4896a c4896a = new C4896a(str2, strM60778h, 0L);
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
                m60774c(strM60778h, c4896a.getUrl(), c4896a);
            } catch (C9721b e11) {
                C1461a.m8358e("OmPictureManager", "download picture " + str + " exception: " + e11.toString());
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e12) {
                    C1461a.m8358e("OmPictureManager", "download picture sleep exception: " + e12.toString());
                }
            }
            if (new File(strM60778h).exists()) {
                if (str3.equals(C0227m.m1591d(strM60778h))) {
                    m60779i(str2, strM60778h);
                } else {
                    C1461a.m8358e("OmPictureManager", "picture hash not equal, key: " + str);
                    m60772a(strM60778h);
                }
                return;
            }
            continue;
        }
    }

    /* renamed from: c */
    public final void m60774c(String str, String str2, C4896a c4896a) throws C9721b {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "downloadFile failed, DownloadReq info is illegal.");
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile == null) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "get file parent path failed.");
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "file parent create failed.");
        }
        String strM72864a = C12158a.m72864a(str2, Constants.UTF_8);
        if (TextUtils.isEmpty(strM72864a)) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "url is null or empty after urldecoder");
        }
        C11976a.m72086g(strM72864a, c4896a, null);
    }

    /* renamed from: d */
    public void m60775d() {
        C12515a.m75110o().m75175e(new b(), false);
    }

    /* renamed from: e */
    public final String m60776e(String str) {
        if (TextUtils.isEmpty(str)) {
            C1461a.m8358e("OmPictureManager", "url is empty");
            return "";
        }
        int iNextInt = this.f47985a.nextInt(10000);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context contextM1378b = C0213f.m1378b();
        if (contextM1378b == null) {
            C1461a.m8358e("OmPictureManager", "context is null");
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("om_pictures");
        sb2.append(str2);
        sb2.append(str.hashCode());
        sb2.append(iNextInt);
        sb2.append(jCurrentTimeMillis);
        return sb2.toString();
    }

    /* renamed from: g */
    public JSONArray m60777g() {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            C1461a.m8358e("OmPictureManager", "hiCloudSysParamMap is null");
            return null;
        }
        String overSizePictures = hiCloudSysParamMapM60758q.getOverSizePictures();
        if (TextUtils.isEmpty(overSizePictures)) {
            C1461a.m8360w("OmPictureManager", "overSizePictures is empty");
            return null;
        }
        try {
            return new JSONArray(overSizePictures);
        } catch (Exception e10) {
            C1461a.m8358e("OmPictureManager", "getOverSizePictures exception: " + e10.toString());
            return null;
        }
    }

    /* renamed from: h */
    public final String m60778h(String str) {
        return C0212e0.m1364n(C0213f.m1377a(), "cache", str, "");
    }

    /* renamed from: i */
    public final void m60779i(String str, String str2) {
        C0212e0.m1373w(C0213f.m1377a(), "cache", str, str2);
    }
}
