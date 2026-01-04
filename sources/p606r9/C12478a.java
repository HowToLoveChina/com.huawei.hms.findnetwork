package p606r9;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.connect.progress.ICloudAlbumCallback;
import com.huawei.android.hicloud.connect.progress.Retry;
import com.huawei.android.hicloud.p081cs.bean.DownloadReq;
import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hicloud.request.opengw.bean.DownloadAddress;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9720a;
import fk.C9721b;
import gp.C10028c;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mk.C11476b;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p549p9.C12122a;
import p652t9.EnumC12999a;
import p673u9.C13136a;
import p673u9.C13140e;
import p673u9.C13141f;
import p704v9.C13385a;
import p704v9.C13387c;
import p709vj.C13452e;
import p746wn.C13622a;
import p803y9.C13922a;
import p803y9.C13923b;
import p837z9.C14163d;
import pk.C12158a;

/* renamed from: r9.a */
/* loaded from: classes3.dex */
public class C12478a {

    /* renamed from: a */
    public String f57450a;

    /* renamed from: b */
    public EnumC12999a f57451b;

    /* renamed from: c */
    public int f57452c;

    /* renamed from: d */
    public int f57453d;

    public C12478a(EnumC12999a enumC12999a, String str) {
        this.f57450a = str;
        this.f57451b = enumC12999a;
    }

    /* renamed from: o */
    public static Context m74902o() {
        return C0213f.m1377a();
    }

    /* renamed from: t */
    public static boolean m74903t() {
        return C10028c.m62182c0().m62420y1();
    }

    /* renamed from: A */
    public final void m74904A(C11060c c11060c, C9721b c9721b) {
        if (TextUtils.isEmpty(c11060c.m66647c())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m74903t() ? "113_" : "117_");
            sb2.append(c9721b.m60659c());
            sb2.append(EnumC12999a.CLOUD_ALBUM.equals(this.f57451b) ? ":1" : "");
            c11060c.m66665u(sb2.toString());
            c11060c.m66635A(c9721b.getMessage());
        }
    }

    /* renamed from: a */
    public Object[] m74905a(File file, String str, String str2, int i10, ICallback iCallback) throws C9721b {
        Retry retry;
        boolean z10;
        String strM83502p;
        ICallback iCallback2 = iCallback;
        C9720a.m60657f(file, "upload file is invalid.");
        C9720a.m60653b(str, "upload app packageName is invalid.");
        C9720a.m60653b(str2, "upload app versionCode is invalid.");
        C9720a.m60657f(iCallback2, "upload app callback is invalid.");
        m74926x();
        m74928z();
        if (!file.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "file is not exist.", file.getName());
        }
        Md5AndHash md5AndHashM68622d = C11476b.m68622d(file);
        C13387c c13387c = new C13387c(this.f57451b.m78143b());
        c13387c.m80439x(md5AndHashM68622d.getMD5());
        c13387c.m80440y(md5AndHashM68622d.getHash());
        c13387c.m80409C(file.length());
        c13387c.m80435t(str);
        c13387c.m80436u(str2);
        String str3 = "/" + str + "/" + str2 + "/" + str;
        boolean z11 = true;
        Retry retry2 = new Retry(1);
        while (true) {
            try {
                C12122a c12122a = new C12122a(iCallback2);
                c12122a.mo17785g(file.length());
                int iM83519a = 3;
                if (m74903t()) {
                    try {
                        C13923b c13923b = new C13923b(this.f57451b, this.f57450a, this.f57452c, this.f57453d);
                        if (i10 == 0) {
                            c13387c.m80437v(str3 + ".apk_" + md5AndHashM68622d.getMD5());
                            iM83519a = c13923b.m83519a(file, c13387c, c12122a);
                        } else {
                            if (i10 != 1) {
                                throw new C9721b(4002, "type is invalid.", "appUpload");
                            }
                            c13387c.m80437v(str3 + ".icon_" + md5AndHashM68622d.getMD5());
                            c13923b.m83530l(file, c13387c, c12122a);
                        }
                        return new Object[]{c13387c.m80419d(), Integer.valueOf(iM83519a)};
                    } catch (C9721b e10) {
                        e = e10;
                        retry = retry2;
                    }
                } else {
                    try {
                        retry = retry2;
                        C13922a c13922a = new C13922a(this.f57451b, this.f57450a);
                        if (i10 == 0) {
                            c13387c.m80437v(str3 + ".apk_" + md5AndHashM68622d.getMD5() + "_" + md5AndHashM68622d.getHash());
                            strM83502p = c13922a.m83502p(file, c13387c, c12122a);
                        } else {
                            if (i10 != 1) {
                                throw new C9721b(4002, "type is invalid.", "appUpload");
                            }
                            c13387c.m80437v(str3 + ".icon_" + md5AndHashM68622d.getMD5() + "_" + md5AndHashM68622d.getHash());
                            strM83502p = c13922a.m83494S(file, c13387c, c12122a);
                        }
                        Object[] objArr = new Object[2];
                        objArr[0] = strM83502p;
                        z10 = true;
                        try {
                            objArr[1] = 3;
                            return objArr;
                        } catch (C9721b e11) {
                            e = e11;
                        }
                    } catch (C9721b e12) {
                        e = e12;
                    }
                }
                z10 = true;
            } catch (C9721b e13) {
                e = e13;
                retry = retry2;
                z10 = z11;
            }
            retry.m16237f();
            if (!retry.m16232a() || iCallback.onStop() || !m74903t()) {
                break;
            }
            iCallback2 = iCallback;
            z11 = z10;
            retry2 = retry;
        }
        throw e;
    }

    /* renamed from: b */
    public final void m74906b(UploadReq uploadReq) throws C9721b {
        File file = uploadReq.getFile();
        C9720a.m60657f(uploadReq, "upload request is invalid.");
        C9720a.m60657f(file, "upload file is invalid.");
        C9720a.m60653b(uploadReq.getServer(), "upload path is invalid.");
        C9720a.m60657f(uploadReq.getCallback(), "upload callback is invalid.");
        if (!file.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "file is not exist.", C10279b.m63452a(file));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x012d A[LOOP:0: B:140:0x009a->B:119:0x012d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x013a A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m74907c(com.huawei.android.hicloud.p081cs.bean.UploadReq r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p606r9.C12478a.m74907c(com.huawei.android.hicloud.cs.bean.UploadReq):void");
    }

    /* renamed from: d */
    public void m74908d(UploadReq uploadReq) throws C9721b {
        m74912h(uploadReq, true);
    }

    /* renamed from: e */
    public void m74909e(UploadReq uploadReq) throws C9721b {
        m74912h(uploadReq, false);
    }

    /* renamed from: f */
    public final void m74910f(EnumC12999a enumC12999a, String str) throws SQLException {
        C13141f c13141f = new C13141f();
        C13136a c13136a = new C13136a();
        C13140e c13140e = new C13140e();
        try {
            c13141f.m79041h(enumC12999a.m78143b(), str);
            c13136a.m79013h(enumC12999a.m78143b(), str);
            c13140e.m79035h(enumC12999a.m78143b(), str);
            C11839m.m70686d("CSService", "deleteFileInfoInDb hash1:" + str);
        } catch (C9721b e10) {
            C11839m.m70687e("CSService", "deleteFileInfoInDb error:" + e10.toString());
        }
    }

    /* renamed from: g */
    public final void m74911g(UploadReq uploadReq, C11060c c11060c) {
        ICallback callback = uploadReq.getCallback();
        if (callback.onStop()) {
            StringBuilder sb2 = new StringBuilder();
            if (EnumC12999a.CLOUD_ALBUM.equals(this.f57451b)) {
                sb2.append(((ICloudAlbumCallback) callback).onStopCancelCode());
                sb2.append(":1");
            } else {
                sb2.append(m74903t() ? "113_" : "117_");
                sb2.append(1001);
            }
            c11060c.m66665u(sb2.toString());
            c11060c.m66635A(callback instanceof ICloudAlbumCallback ? ((ICloudAlbumCallback) callback).onStopReason() : "upload abort");
        }
        if (uploadReq.getSyncPackageName() != null) {
            c11060c.m66637C(uploadReq.getSyncPackageName());
        }
        C13622a.m81969o(m74902o(), c11060c, uploadReq.getExtraStatKeyValues());
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017b A[LOOP:0: B:104:0x007c->B:99:0x017b, LOOP_END] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m74912h(com.huawei.android.hicloud.p081cs.bean.UploadReq r20, boolean r21) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p606r9.C12478a.m74912h(com.huawei.android.hicloud.cs.bean.UploadReq, boolean):void");
    }

    /* renamed from: i */
    public void m74913i(String str, String str2, ICallback iCallback) throws C9721b {
        m74914j(str, str2, iCallback, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x014b A[SYNTHETIC] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m74914j(java.lang.String r22, java.lang.String r23, com.huawei.android.hicloud.connect.progress.ICallback r24, java.util.Map<java.lang.String, java.lang.String> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p606r9.C12478a.m74914j(java.lang.String, java.lang.String, com.huawei.android.hicloud.connect.progress.ICallback, java.util.Map):void");
    }

    /* renamed from: k */
    public void m74915k(String str, String str2, String str3, long j10, ICallback iCallback) throws C9721b {
        String strM72864a;
        String str4;
        String str5;
        C11060c c11060c;
        Retry retry;
        String str6;
        String str7 = "";
        String str8 = ":1";
        C9720a.m60653b(str, "download file server path is invalid.");
        C9720a.m60653b(str3, "download file local path is invalid.");
        C9720a.m60657f(iCallback, "download file callback is invalid.");
        m74926x();
        m74922s(str3);
        try {
            strM72864a = C12158a.m72864a(str, Constants.UTF_8);
        } catch (Exception e10) {
            C11839m.m70687e("CSService", "URLDecoder decode exception:" + e10.toString());
            strM72864a = str;
        }
        String str9 = this.f57450a;
        String strM66627b = (str9 == null || str9.isEmpty()) ? C11058a.m66627b("00000") : this.f57450a;
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "download", C13452e.m80781L().m80971t0());
        Object obj = null;
        char c10 = 1001;
        try {
            Retry retry2 = new Retry(2);
            while (true) {
                try {
                    retry = retry2;
                    str4 = str7;
                    c11060c = c11060cM66626a;
                    str5 = str8;
                    str6 = strM66627b;
                    try {
                        DownloadReq downloadReq = new DownloadReq(strM72864a, str3, str2, j10, iCallback);
                        if (m74903t()) {
                            new C13923b(this.f57451b, str6, this.f57452c, this.f57453d).m83525g(downloadReq, c11060c);
                        } else {
                            new C13922a(this.f57451b, str6).m83479C(downloadReq, c11060c);
                        }
                        if (iCallback.onStop()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(m74903t() ? "113_" : "117_");
                            sb2.append(1001);
                            sb2.append(EnumC12999a.CLOUD_ALBUM.equals(this.f57451b) ? str5 : str4);
                            c11060c.m66665u(sb2.toString());
                            c11060c.m66635A("download abort");
                        }
                        C13622a.m81969o(m74902o(), c11060c, null);
                        return;
                    } catch (C9721b e11) {
                        e = e11;
                        try {
                            int iM60659c = e.m60659c();
                            if (iM60659c != 1002) {
                                switch (iM60659c) {
                                    case 1104:
                                    case 1105:
                                    case 1106:
                                    case NotifyErr.NET_DISABLE_HMS_ERROR /* 1107 */:
                                        break;
                                    default:
                                        retry.m16238g(e.m60663g());
                                        if (!retry.m16232a() || iCallback.onStop()) {
                                            throw e;
                                        }
                                        retry2 = retry;
                                        c11060cM66626a = c11060c;
                                        strM66627b = str6;
                                        str7 = str4;
                                        str8 = str5;
                                        c10 = 1001;
                                        obj = null;
                                        break;
                                }
                            }
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                            if (iCallback.onStop()) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(m74903t() ? "113_" : "117_");
                                sb3.append(1001);
                                sb3.append(EnumC12999a.CLOUD_ALBUM.equals(this.f57451b) ? str5 : str4);
                                c11060c.m66665u(sb3.toString());
                                c11060c.m66635A("download abort");
                            }
                            C13622a.m81969o(m74902o(), c11060c, null);
                            throw th;
                        }
                    }
                } catch (C9721b e12) {
                    e = e12;
                    retry = retry2;
                    str4 = str7;
                    str5 = str8;
                    c11060c = c11060cM66626a;
                    str6 = strM66627b;
                }
                retry2 = retry;
                c11060cM66626a = c11060c;
                strM66627b = str6;
                str7 = str4;
                str8 = str5;
                c10 = 1001;
                obj = null;
            }
            throw e;
        } catch (Throwable th3) {
            th = th3;
            str4 = str7;
            str5 = str8;
            c11060c = c11060cM66626a;
        }
    }

    /* renamed from: l */
    public void m74916l(String str, ICallback iCallback, DownloadAddress downloadAddress, Map<String, String> map) throws C9721b {
        C9720a.m60652a(!m74903t(), "only support encrypt data download.");
        C9720a.m60657f(iCallback, "callback is null.");
        m74926x();
        m74922s(str);
        new C13922a(this.f57451b, this.f57450a).m83483G(str, iCallback, downloadAddress, map);
    }

    /* renamed from: m */
    public void m74917m(String str, String str2, String str3, ICallback iCallback, Map<String, String> map) throws C9721b {
        C9720a.m60652a(!m74903t(), "only support encrypt data download.");
        C9720a.m60653b(str2, "download thumbnail name is invalid.");
        C9720a.m60653b(str3, "download thumbnail local path is invalid.");
        m74926x();
        HashMap map2 = new HashMap();
        map2.put(str2, str3);
        m74918n(str, map2, iCallback, map);
    }

    /* renamed from: n */
    public final void m74918n(String str, Map<String, String> map, ICallback iCallback, Map<String, String> map2) throws C9721b {
        C9720a.m60652a(!m74903t(), "only support encrypt data download.");
        String[] strArr = (String[]) map.keySet().toArray(new String[map.size()]);
        HashMap map3 = new HashMap();
        map3.put(str, strArr);
        Map<String, Map<String, DownloadAddress>> mapM74919p = m74919p(map3);
        for (String str2 : strArr) {
            m74916l(map.get(str2), iCallback, mapM74919p.get(str).get(str2), map2);
        }
    }

    /* renamed from: p */
    public Map<String, Map<String, DownloadAddress>> m74919p(Map<String, String[]> map) throws C9721b {
        C9720a.m60652a(!m74903t(), "only support encrypt data download.");
        m74926x();
        return new C13922a(this.f57451b, this.f57450a).m83490N(map);
    }

    /* renamed from: q */
    public final C13387c m74920q(String str) throws Throwable {
        C13387c c13387cM79043j = new C13141f().m79043j(this.f57451b.m78143b(), str);
        return c13387cM79043j == null ? new C13387c(this.f57451b.m78143b()) : c13387cM79043j;
    }

    /* renamed from: r */
    public final String m74921r() {
        String str = this.f57450a;
        return (str == null || str.isEmpty()) ? C11058a.m66627b("00000") : this.f57450a;
    }

    /* renamed from: s */
    public final void m74922s(String str) {
        File fileM63437c = C10278a.m63437c(C10278a.m63442h(str));
        if (fileM63437c == null || fileM63437c.exists() || !fileM63437c.mkdirs()) {
            return;
        }
        C11839m.m70686d("CSService", "parent create success.");
    }

    /* renamed from: u */
    public final boolean m74923u(ICallback iCallback, Retry retry) {
        return (!iCallback.onStop() && retry.m16232a() && m74903t()) ? false : true;
    }

    /* renamed from: v */
    public final boolean m74924v(String str, String str2, String str3) {
        return (!TextUtils.isEmpty(str3) && str3.contains("404")) || (!TextUtils.isEmpty(str) && str.contains("404") && str2.contains("_OBS"));
    }

    /* renamed from: w */
    public final boolean m74925w(int i10, C9721b c9721b) {
        if (c9721b == null || c9721b.m60659c() != 3310) {
            return !(c9721b == null || c9721b.m60659c() == 3306 || c9721b.m60659c() == 3308) || i10 == 3;
        }
        return false;
    }

    /* renamed from: x */
    public final void m74926x() throws C9721b {
        if (C14163d.m84990g().m85009o()) {
            throw new C9721b(4009, "data migration error.", "onMigrateCheck");
        }
    }

    /* renamed from: y */
    public Map<String, String> m74927y(String str) throws Throwable {
        C9720a.m60652a(m74903t(), "used incorrect query mkfile params.");
        C9720a.m60653b(str, "hash is invalid.");
        HashMap map = new HashMap();
        C13385a c13385aM79015j = new C13136a().m79015j(this.f57451b.m78143b(), str);
        map.put("sig", c13385aM79015j.m80373h());
        map.put("ts", c13385aM79015j.m80374i());
        map.put("url", c13385aM79015j.m80372g());
        return map;
    }

    /* renamed from: z */
    public final void m74928z() throws C9721b {
        if (C10028c.m62182c0().m62206E1()) {
            throw new C9721b(4010, "migration update error.", "onIncrementDataMigration");
        }
    }

    public C12478a(EnumC12999a enumC12999a, String str, int i10) {
        this.f57450a = str;
        this.f57451b = enumC12999a;
        this.f57452c = i10;
    }
}
