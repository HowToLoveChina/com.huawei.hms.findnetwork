package ie;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import android.widget.ImageView;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import ie.C10474a;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.function.Consumer;
import okhttp3.C11918e0;
import p020ap.C1010e;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p681uj.C13195l;
import p709vj.C13452e;
import p783xp.C13843a;
import tm.C13040c;

/* renamed from: ie.b */
/* loaded from: classes3.dex */
public class C10475b {

    /* renamed from: a */
    public int f50478a;

    /* renamed from: b */
    public int f50479b;

    /* renamed from: c */
    public String f50480c;

    /* renamed from: d */
    public Context f50481d;

    /* renamed from: e */
    public Location f50482e;

    /* renamed from: f */
    public String f50483f;

    /* renamed from: g */
    public String f50484g;

    /* renamed from: h */
    public ImageView f50485h;

    /* renamed from: i */
    public Consumer<C10474a.b> f50486i;

    /* renamed from: ie.b$a */
    public class a extends AbstractC12367d {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11839m.m70688i("RequestPetalMapSnapshotTask", "doRequestPetalMapSnapshot");
            C10475b c10475b = C10475b.this;
            c10475b.f50484g = c10475b.m64382j();
            if (TextUtils.isEmpty(C10475b.this.f50484g)) {
                C11839m.m70687e("RequestPetalMapSnapshotTask", "doRequestPetalMapSnapshot, requestUrl is empty");
                C10475b.this.m64383k();
            } else {
                C10475b c10475b2 = C10475b.this;
                c10475b2.m64380h(c10475b2.f50484g);
            }
        }
    }

    /* renamed from: ie.b$b */
    public class b extends C4896a {
        public b(String str, long j10) {
            super(str, j10);
        }

        @Override // com.huawei.hicloud.download.C4896a, com.huawei.hicloud.okhttp.callback.AbstractC4975a
        public void prepare(C11918e0.a aVar) throws UnsupportedEncodingException {
            String strEncode;
            try {
                strEncode = URLEncoder.encode(C13195l.m79272J().m79344y("PhoneFinder", ""), Constants.UTF_8);
            } catch (Exception unused) {
                C11839m.m70687e("RequestPetalMapSnapshotTask", "MapSnapshotCallback Exception");
                strEncode = null;
            }
            aVar.m71574a("authType", "0").m71574a("authValue", strEncode).m71574a(HwPayConstant.KEY_SITE_ID, String.valueOf(C13452e.m80781L().m80947n0()));
            super.prepare(aVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00e7  */
        /* JADX WARN: Type inference failed for: r9v0, types: [ie.b$b] */
        /* JADX WARN: Type inference failed for: r9v11 */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v4, types: [java.io.OutputStream] */
        @Override // com.huawei.hicloud.download.C4896a, com.huawei.hicloud.okhttp.callback.AbstractC4975a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void onResponse(okhttp3.C11922g0 r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.String r0 = "RequestPetalMapSnapshotTask"
                okhttp3.h0 r1 = r10.m71595s()
                java.lang.String r1 = r1.m71637z()
                r2 = 0
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r3.<init>(r1)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r1 = "resultCode"
                java.lang.String r1 = r3.optString(r1)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r4 = "result"
                java.lang.String r3 = r3.optString(r4)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r4 = 0
                byte[] r3 = com.huawei.secure.android.common.util.SafeBase64.decode(r3, r4)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r5.<init>()     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r6 = "onResponse buff size: "
                r5.append(r6)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                int r6 = r3.length     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r5.append(r6)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                p514o9.C11839m.m70688i(r0, r5)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                android.os.Bundle r5 = new android.os.Bundle     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r5.<init>()     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r6 = "operationType"
                java.lang.String r7 = "mapCardShow"
                r5.putString(r6, r7)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r6 = "businessId"
                java.lang.String r7 = "petalMapCard"
                r5.putString(r6, r7)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r6 = "errorReason"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r7.<init>()     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r8 = "map download response. resultCode: "
                r7.append(r8)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r7.append(r1)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r8 = ", buff size: "
                r7.append(r8)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                int r8 = r3.length     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r7.append(r8)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r5.putString(r6, r7)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                ap.e r6 = p020ap.C1010e.m6125b()     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r6.m6129D(r5)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r5.<init>()     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r6 = "onResponse. resultCode: "
                r5.append(r6)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r5.append(r1)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                p399jk.AbstractC10896a.m65887i(r0, r5)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r5 = "0"
                boolean r1 = com.huawei.hidisk.common.util.javautil.StringUtil.equals(r1, r5)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                if (r1 != 0) goto L8f
                r10.close()
                return r2
            L8f:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r1.<init>()     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                ie.b r9 = ie.C10475b.this     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r9 = ie.C10475b.m64378f(r9)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                r1.append(r9)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r9 = "_tmp"
                r1.append(r9)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String r9 = r1.toString()     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.lang.String[] r1 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.nio.file.Path r9 = java.nio.file.Paths.get(r9, r1)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r4]     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                java.io.OutputStream r9 = java.nio.file.Files.newOutputStream(r9, r1)     // Catch: java.lang.Throwable -> Lc5 java.lang.Exception -> Lc7
                int r1 = r3.length     // Catch: java.lang.Throwable -> Lc0 java.lang.Exception -> Lc3
                r9.write(r3, r4, r1)     // Catch: java.lang.Throwable -> Lc0 java.lang.Exception -> Lc3
                r9.flush()     // Catch: java.lang.Throwable -> Lc0 java.lang.Exception -> Lc3
            Lb9:
                r9.close()
            Lbc:
                r10.close()
                goto Le4
            Lc0:
                r0 = move-exception
                r2 = r9
                goto Le5
            Lc3:
                r1 = move-exception
                goto Lc9
            Lc5:
                r0 = move-exception
                goto Le5
            Lc7:
                r1 = move-exception
                r9 = r2
            Lc9:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc0
                r3.<init>()     // Catch: java.lang.Throwable -> Lc0
                java.lang.String r4 = "onResponse error e:"
                r3.append(r4)     // Catch: java.lang.Throwable -> Lc0
                java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> Lc0
                r3.append(r1)     // Catch: java.lang.Throwable -> Lc0
                java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Lc0
                p514o9.C11839m.m70687e(r0, r1)     // Catch: java.lang.Throwable -> Lc0
                if (r9 == 0) goto Lbc
                goto Lb9
            Le4:
                return r2
            Le5:
                if (r2 == 0) goto Lea
                r2.close()
            Lea:
                r10.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ie.C10475b.b.onResponse(okhttp3.g0):java.lang.Void");
        }
    }

    public C10475b(Context context, Location location, String str, String str2, ImageView imageView, int i10, int i11, Consumer<C10474a.b> consumer) {
        this.f50481d = context;
        this.f50482e = location;
        this.f50480c = str;
        this.f50483f = str2;
        this.f50485h = imageView;
        this.f50478a = i10;
        this.f50479b = i11;
        this.f50486i = consumer;
    }

    /* renamed from: g */
    public void m64379g() {
        C12515a.m75110o().m75175e(new a(), false);
    }

    /* renamed from: h */
    public final void m64380h(String str) {
        C11839m.m70688i("RequestPetalMapSnapshotTask", "downloadSnapshot");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f50480c)) {
            C11839m.m70687e("RequestPetalMapSnapshotTask", "downloadSnapshot, url or path empty");
            m64383k();
            return;
        }
        String str2 = this.f50480c + "_tmp";
        try {
            NotifyUtil.downloadFileToPathSilent(str2, str, new b(str2, 0L));
        } catch (Exception e10) {
            NotifyLogger.m29914e("RequestPetalMapSnapshotTask", "downloadFileToPathSilent exception: " + e10.getMessage());
            m64383k();
        }
        File file = new File(str2);
        if (!file.exists()) {
            NotifyLogger.m29914e("RequestPetalMapSnapshotTask", "download file to local temp failed. destPath = " + str2);
            m64383k();
            return;
        }
        File file2 = new File(this.f50480c);
        if (file2.exists()) {
            NotifyLogger.m29913d("RequestPetalMapSnapshotTask", "destFile exist, delete it, destPath:" + this.f50480c);
            if (!file2.delete()) {
                NotifyLogger.m29914e("RequestPetalMapSnapshotTask", "destFile delete failed, destPath:" + this.f50480c);
            }
        }
        if (file.renameTo(file2)) {
            m64384l();
            NotifyLogger.m29913d("RequestPetalMapSnapshotTask", "download success, destPath:" + this.f50480c);
            return;
        }
        NotifyLogger.m29914e("RequestPetalMapSnapshotTask", "rename file failed, destPath:" + this.f50480c);
        m64383k();
    }

    /* renamed from: i */
    public final String m64381i(String str, Context context) {
        String strM78623O;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            strM78623O = (C13452e.m80781L().m80842P0() && C1010e.m6125b().m6138d(context)) ? C13040c.m78609F().m78623O() : C13040c.m78609F().m78622N();
        } catch (C9721b e10) {
            C11839m.m70687e("RequestPetalMapSnapshotTask", "cannot get phoneFinder address from grs: " + e10.getMessage());
            strM78623O = null;
        }
        C11839m.m70686d("RequestPetalMapSnapshotTask", "domain is " + strM78623O);
        if (TextUtils.isEmpty(strM78623O)) {
            C11839m.m70687e("RequestPetalMapSnapshotTask", "domain is empty");
            return null;
        }
        return strM78623O + str;
    }

    /* renamed from: j */
    public final String m64382j() throws UnsupportedEncodingException {
        if (this.f50482e == null) {
            C11839m.m70687e("RequestPetalMapSnapshotTask", "getRequestUrl, location is null");
            return null;
        }
        if (this.f50479b <= 0 || this.f50478a <= 0) {
            C11839m.m70687e("RequestPetalMapSnapshotTask", "getRequestUrl, size is error");
            return null;
        }
        try {
            String strEncode = URLEncoder.encode(this.f50482e.getLatitude() + "," + this.f50482e.getLongitude(), Constants.UTF_8);
            String strEncode2 = URLEncoder.encode("{" + this.f50482e.getLatitude() + "," + this.f50482e.getLongitude() + "}", Constants.UTF_8);
            String strEncode3 = URLEncoder.encode(strEncode, Constants.UTF_8);
            String strEncode4 = URLEncoder.encode(strEncode2, Constants.UTF_8);
            String strM64381i = m64381i("/FindCloud/FindService/Map/Image", this.f50481d);
            if (TextUtils.isEmpty(strM64381i)) {
                C11839m.m70687e("RequestPetalMapSnapshotTask", "getRequestUrl, url is empty");
                return null;
            }
            String str = C13843a.m83067S() ? "&language=zh" : "&language=en";
            StringBuilder sb2 = new StringBuilder(strM64381i);
            sb2.append("?width=");
            sb2.append(this.f50478a);
            sb2.append("&height=");
            sb2.append(this.f50479b);
            sb2.append("&location=");
            sb2.append(strEncode3);
            sb2.append("&scale=2");
            sb2.append("&zoom=");
            sb2.append(16);
            sb2.append("&markers=");
            sb2.append(strEncode4);
            sb2.append("&markerStyles=icon:");
            sb2.append(this.f50483f);
            sb2.append("&fields=result");
            sb2.append(str);
            return String.valueOf(sb2);
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e("RequestPetalMapSnapshotTask", "getRequestUrl, URLEncoder error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: k */
    public final void m64383k() {
        if (this.f50486i == null || this.f50485h == null) {
            return;
        }
        this.f50486i.accept(new C10474a.b(this.f50480c, true, false));
    }

    /* renamed from: l */
    public final void m64384l() {
        if (this.f50486i == null || this.f50485h == null) {
            return;
        }
        this.f50486i.accept(new C10474a.b(this.f50480c, true, true));
    }
}
