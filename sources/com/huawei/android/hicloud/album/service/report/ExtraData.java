package com.huawei.android.hicloud.album.service.report;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import java.util.LinkedHashMap;
import p031b7.C1122c;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class ExtraData {

    /* renamed from: a */
    public String f11591a;

    /* renamed from: b */
    public String f11592b;

    /* renamed from: c */
    public String f11593c;

    /* renamed from: d */
    public String f11594d;

    /* renamed from: e */
    public String f11595e;

    /* renamed from: f */
    public String f11596f;

    /* renamed from: g */
    public int f11597g;

    /* renamed from: h */
    public String f11598h;

    /* renamed from: i */
    public String f11599i;

    /* renamed from: j */
    public String f11600j;

    /* renamed from: k */
    public String f11601k;

    /* renamed from: l */
    public String f11602l;

    /* renamed from: m */
    public String f11603m;

    /* renamed from: n */
    public String f11604n;

    /* renamed from: o */
    public String f11605o;

    /* renamed from: p */
    public String f11606p;

    /* renamed from: q */
    public String f11607q;

    /* renamed from: r */
    public String f11608r;

    /* renamed from: s */
    public EnumC2434b f11609s;

    /* renamed from: t */
    public String f11610t;

    /* renamed from: u */
    public String f11611u;

    /* renamed from: v */
    public String f11612v;

    /* renamed from: w */
    public String f11613w;

    /* renamed from: com.huawei.android.hicloud.album.service.report.ExtraData$a */
    public static /* synthetic */ class C2433a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f11614a;

        static {
            int[] iArr = new int[EnumC2434b.values().length];
            f11614a = iArr;
            try {
                iArr[EnumC2434b.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11614a[EnumC2434b.UPLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11614a[EnumC2434b.COMMON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.report.ExtraData$b */
    public enum EnumC2434b {
        DOWNLOAD,
        UPLOAD,
        COMMON
    }

    public ExtraData(Context context, EnumC2434b enumC2434b) {
        this.f11595e = "0";
        this.f11596f = "null";
        this.f11598h = "null";
        this.f11604n = "null";
        this.f11605o = "null";
        this.f11606p = "null";
        this.f11607q = "null";
        this.f11608r = "1";
        this.f11609s = EnumC2434b.COMMON;
        m15224c(context, enumC2434b);
    }

    /* renamed from: a */
    public final String m15222a(String str) {
        return TextUtils.isEmpty(str) ? "null" : str;
    }

    /* renamed from: b */
    public LinkedHashMap<String, String> m15223b(LinkedHashMap<String, String> linkedHashMap) {
        linkedHashMap.put("business_id", this.f11591a);
        linkedHashMap.put("business_type", this.f11592b);
        linkedHashMap.put("traceID", this.f11593c);
        linkedHashMap.put(HwPayConstant.KEY_USER_ID, this.f11594d);
        linkedHashMap.put("logVersion", "4.0");
        linkedHashMap.put("endTrace", this.f11595e);
        int i10 = C2433a.f11614a[this.f11609s.ordinal()];
        if (i10 == 1) {
            linkedHashMap.put("thumbType", String.valueOf(this.f11597g));
            linkedHashMap.put("albumId", this.f11605o);
            linkedHashMap.put(ContentRecord.UNIQUE_ID, this.f11606p);
            linkedHashMap.put("fileUnique", this.f11601k);
            linkedHashMap.put(ContentResource.FILE_NAME, this.f11596f);
            linkedHashMap.put("fileId", this.f11604n);
            linkedHashMap.put("fileIdType", this.f11603m);
            if (!TextUtils.isEmpty(this.f11600j)) {
                linkedHashMap.put("range", this.f11600j);
            }
            if (!TextUtils.isEmpty(this.f11611u)) {
                linkedHashMap.put("priority", this.f11611u);
            }
            if (!TextUtils.isEmpty(this.f11612v)) {
                linkedHashMap.put("galleryNetworkSwitch", this.f11612v);
            }
            if (!TextUtils.isEmpty(this.f11613w)) {
                linkedHashMap.put("isForceDownload", this.f11613w);
            }
            if (!TextUtils.isEmpty(this.f11599i)) {
                linkedHashMap.put("contentLength", this.f11599i);
            }
            if (!TextUtils.isEmpty(this.f11598h)) {
                linkedHashMap.put("videoThumbId", this.f11598h);
            }
        } else if (i10 == 2) {
            linkedHashMap.put("fileUnique", this.f11601k);
            linkedHashMap.put("isFastUpload", this.f11602l);
        } else if (i10 == 3) {
            linkedHashMap.put("totalNeedSize", this.f11607q);
        }
        linkedHashMap.put("galleryVersion", this.f11608r);
        linkedHashMap.put("fileType", this.f11610t);
        return linkedHashMap;
    }

    /* renamed from: c */
    public final void m15224c(Context context, EnumC2434b enumC2434b) {
        this.f11609s = enumC2434b;
        m15244w(C13452e.m80781L().m80971t0());
        m15227f(C1122c.m6701H0());
        m15236o(context);
    }

    /* renamed from: d */
    public void m15225d(String str) {
        this.f11605o = m15222a(str);
    }

    /* renamed from: e */
    public void m15226e(String str) {
        this.f11591a = str;
    }

    /* renamed from: f */
    public void m15227f(String str) {
        this.f11592b = str;
    }

    /* renamed from: g */
    public void m15228g(long j10) {
        this.f11599i = String.valueOf(j10);
    }

    /* renamed from: h */
    public void m15229h(String str) {
        this.f11595e = str;
    }

    /* renamed from: i */
    public void m15230i(String str) {
        this.f11604n = m15222a(str);
    }

    /* renamed from: j */
    public void m15231j(String str) {
        this.f11603m = m15222a(str);
    }

    /* renamed from: k */
    public void m15232k(String str) {
        this.f11596f = m15222a(str);
    }

    /* renamed from: l */
    public void m15233l(String str) {
        this.f11610t = str;
    }

    /* renamed from: m */
    public void m15234m(String str) {
        this.f11601k = m15222a(str);
    }

    /* renamed from: n */
    public void m15235n(String str) {
        this.f11612v = str;
    }

    /* renamed from: o */
    public final void m15236o(Context context) {
        this.f11608r = C1122c.m6833t0(context);
    }

    /* renamed from: p */
    public void m15237p(String str) {
        this.f11613w = str;
    }

    /* renamed from: q */
    public void m15238q(String str) {
        this.f11611u = str;
    }

    /* renamed from: r */
    public void m15239r(String str) {
        this.f11600j = m15222a(str);
    }

    /* renamed from: s */
    public void m15240s(int i10) {
        this.f11597g = i10;
    }

    /* renamed from: t */
    public void m15241t(String str) {
        this.f11607q = str;
    }

    public String toString() {
        return "ExtraData{LOG_VERSION='4.0', businessId='" + this.f11591a + "', businessType='" + this.f11592b + "', traceId='" + this.f11593c + "', userID='" + this.f11594d + "', endTrace='" + this.f11595e + "', fileName='" + this.f11596f + "', thumbType=" + this.f11597g + ", videoThumbId='" + this.f11598h + "', contentLength='" + this.f11599i + "', range='" + this.f11600j + "', fileUnique='" + this.f11601k + "', isFastUpload='" + this.f11602l + "', fileIdType='" + this.f11603m + "', fileId='" + this.f11604n + "', albumId='" + this.f11605o + "', uniqueId='" + this.f11606p + "', galleryVersion='" + this.f11608r + "', extraType=" + this.f11609s + '}';
    }

    /* renamed from: u */
    public void m15242u(String str) {
        this.f11593c = str;
    }

    /* renamed from: v */
    public void m15243v(String str) {
        this.f11606p = m15222a(str);
    }

    /* renamed from: w */
    public void m15244w(String str) {
        this.f11594d = str;
    }

    /* renamed from: x */
    public void m15245x(String str) {
        this.f11598h = m15222a(str);
    }

    public ExtraData(Context context) {
        this.f11595e = "0";
        this.f11596f = "null";
        this.f11598h = "null";
        this.f11604n = "null";
        this.f11605o = "null";
        this.f11606p = "null";
        this.f11607q = "null";
        this.f11608r = "1";
        EnumC2434b enumC2434b = EnumC2434b.COMMON;
        this.f11609s = enumC2434b;
        m15224c(context, enumC2434b);
    }
}
