package com.huawei.appgallery.serviceverifykit.p097c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import bi.C1244a;
import bi.C1245b;
import bi.C1246c;
import ci.C1441b;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p844zh.C14301a;

/* renamed from: com.huawei.appgallery.serviceverifykit.c.a */
/* loaded from: classes4.dex */
public class C4583a {

    /* renamed from: a */
    public String f21076a;

    /* renamed from: b */
    public String f21077b;

    /* renamed from: c */
    public String f21078c;

    /* renamed from: g */
    public int f21082g;

    /* renamed from: k */
    public String f21086k;

    /* renamed from: l */
    public String f21087l;

    /* renamed from: m */
    public Intent f21088m;

    /* renamed from: n */
    public ServiceVerifyKit.C4580a.a f21089n;

    /* renamed from: s */
    public Context f21094s;

    /* renamed from: t */
    public String f21095t;

    /* renamed from: u */
    public String f21096u;

    /* renamed from: d */
    public Map<String, String[]> f21079d = new HashMap();

    /* renamed from: e */
    public Map<String, Integer> f21080e = new HashMap();

    /* renamed from: f */
    public Map<String, String> f21081f = new HashMap();

    /* renamed from: h */
    public List<String> f21083h = new ArrayList();

    /* renamed from: i */
    public List<ServiceVerifyKit.C4582c> f21084i = new ArrayList();

    /* renamed from: j */
    public int f21085j = 0;

    /* renamed from: o */
    public int f21090o = 0;

    /* renamed from: p */
    public int f21091p = 0;

    /* renamed from: q */
    public int f21092q = 0;

    /* renamed from: r */
    public int f21093r = 0;

    public C4583a(Context context) {
        this.f21094s = context;
    }

    /* renamed from: f */
    public static String m28101f(String str) {
        C1441b c1441b;
        String str2;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (ClassNotFoundException unused) {
            c1441b = C1441b.f6211b;
            str2 = "getSystemProperties ClassNotFoundException";
            c1441b.m8284a("MatchAppFinder", str2);
            return "";
        } catch (Exception unused2) {
            c1441b = C1441b.f6211b;
            str2 = "getSystemProperties Exception while getting system property";
            c1441b.m8284a("MatchAppFinder", str2);
            return "";
        }
    }

    /* renamed from: a */
    public final int m28102a(Bundle bundle, int i10) {
        if (!bundle.containsKey("ag.application.base_priority")) {
            return i10 + 1000;
        }
        try {
            return i10 + bundle.getInt("ag.application.base_priority");
        } catch (Exception unused) {
            C1441b.f6211b.m8284a("MatchAppFinder", "skip package " + bundle.getString("ag.application.base_priority") + " is not number");
            return i10 + 1000;
        }
    }

    /* renamed from: b */
    public final int m28103b(Bundle bundle, int i10, List<ServiceVerifyKit.C4582c> list) {
        int i11 = 0;
        for (ServiceVerifyKit.C4582c c4582c : list) {
            if (i10 == 1) {
                if (!bundle.containsKey(c4582c.m28099a()) || !bundle.get(c4582c.m28099a()).toString().equals(c4582c.m28100b())) {
                    return 0;
                }
                i11 = 1;
            } else if (i10 != 2) {
                C1441b.f6211b.m8284a("MatchAppFinder", "error input preferred package name");
            } else if (bundle.containsKey(c4582c.m28099a()) && bundle.get(c4582c.m28099a()).toString().equals(c4582c.m28100b())) {
                i11++;
            }
        }
        return i11;
    }

    /* renamed from: c */
    public final int m28104c(Bundle bundle, String str) {
        if (!bundle.containsKey(this.f21086k)) {
            return 0;
        }
        if (!bundle.getString(this.f21086k).equalsIgnoreCase(str)) {
            return -1;
        }
        C1441b.f6211b.m8286c("MatchAppFinder", "matchProp is 1, MetaDataKey is " + str);
        return 1;
    }

    /* renamed from: d */
    public final int m28105d(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                i10 = 1;
            }
        }
        return i10;
    }

    /* renamed from: e */
    public final String m28106e(ResolveInfo resolveInfo) {
        ServiceVerifyKit.C4580a.a aVar = this.f21089n;
        return ((aVar == ServiceVerifyKit.C4580a.a.ACTIVITY || aVar == ServiceVerifyKit.C4580a.a.BROADCAST) ? resolveInfo.activityInfo.applicationInfo : resolveInfo.serviceInfo.applicationInfo).packageName;
    }

    /* renamed from: g */
    public List<C14301a> m28107g() {
        PackageManager packageManager = this.f21094s.getPackageManager();
        List<ResolveInfo> listM28108h = m28108h(packageManager);
        if (listM28108h.size() == 0) {
            return null;
        }
        this.f21095t = TextUtils.isEmpty(this.f21087l) ? Build.MANUFACTURER : m28101f(this.f21087l);
        return m28109i(listM28108h, packageManager, this.f21082g | 192);
    }

    /* renamed from: h */
    public final List<ResolveInfo> m28108h(PackageManager packageManager) {
        Intent intent;
        ServiceVerifyKit.C4580a.a aVar = this.f21089n;
        if (aVar == null) {
            intent = new Intent(this.f21076a);
        } else {
            if (aVar == ServiceVerifyKit.C4580a.a.ACTIVITY) {
                return packageManager.queryIntentActivities(this.f21088m, this.f21082g);
            }
            if (aVar == ServiceVerifyKit.C4580a.a.BROADCAST) {
                return packageManager.queryBroadcastReceivers(this.f21088m, this.f21082g);
            }
            intent = this.f21088m;
        }
        return packageManager.queryIntentServices(intent, this.f21082g);
    }

    /* renamed from: i */
    public final List<C14301a> m28109i(List<ResolveInfo> list, PackageManager packageManager, int i10) throws PackageManager.NameNotFoundException {
        C1441b c1441b;
        StringBuilder sb2;
        String str;
        PackageInfo packageInfo;
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            String strM28106e = m28106e(resolveInfo);
            try {
                packageInfo = packageManager.getPackageInfo(strM28106e, i10);
            } catch (PackageManager.NameNotFoundException unused) {
                c1441b = C1441b.f6211b;
                sb2 = new StringBuilder();
                sb2.append("skip package ");
                sb2.append(strM28106e);
                str = " for PackageInfo is null with NameNotFoundException";
            } catch (Exception unused2) {
                c1441b = C1441b.f6211b;
                sb2 = new StringBuilder();
                sb2.append("skip package ");
                sb2.append(strM28106e);
                str = " for PackageInfo is null with Exception";
            }
            if (packageInfo.applicationInfo == null) {
                c1441b = C1441b.f6211b;
                sb2 = new StringBuilder();
                sb2.append("skip package ");
                sb2.append(strM28106e);
                str = " for ApplicationInfo is null";
            } else {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr == null || signatureArr.length <= 0) {
                    c1441b = C1441b.f6211b;
                    sb2 = new StringBuilder();
                    sb2.append("skip package ");
                    sb2.append(strM28106e);
                    str = " for no sign";
                } else {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    if (byteArray.length == 0) {
                        c1441b = C1441b.f6211b;
                        sb2 = new StringBuilder();
                        sb2.append("skip package ");
                        sb2.append(strM28106e);
                        str = " for sign is empty";
                    } else {
                        try {
                            C14301a c14301aM28110j = m28110j(packageInfo, C1245b.m7449c(MessageDigest.getInstance("SHA-256").digest(byteArray), true), strM28106e, resolveInfo.priority);
                            if (c14301aM28110j != null) {
                                arrayList.add(c14301aM28110j);
                            }
                        } catch (NoSuchAlgorithmException unused3) {
                            c1441b = C1441b.f6211b;
                            sb2 = new StringBuilder();
                            sb2.append("skip package ");
                            sb2.append(strM28106e);
                            str = " for AlgorithmException";
                        }
                    }
                }
            }
            sb2.append(str);
            c1441b.m8284a("MatchAppFinder", sb2.toString());
        }
        return arrayList;
    }

    /* renamed from: j */
    public final C14301a m28110j(PackageInfo packageInfo, String str, String str2, int i10) {
        Bundle bundle = packageInfo.applicationInfo.metaData;
        if (bundle == null) {
            return null;
        }
        int iM28104c = m28104c(bundle, this.f21095t);
        if (!m28112l(bundle, str, str2, i10)) {
            return null;
        }
        if (!this.f21083h.isEmpty()) {
            this.f21092q = m28105d(str2, this.f21083h);
        }
        if (!this.f21084i.isEmpty()) {
            this.f21093r = m28103b(bundle, this.f21085j, this.f21084i);
            C1441b.f6211b.m8286c("MatchAppFinder", "match conditions success, packageName is " + str2 + " condition type is " + this.f21085j + " condition number is " + this.f21093r);
        }
        return new C14301a(str2, m28102a(bundle, this.f21090o), this.f21091p, iM28104c, this.f21092q, this.f21093r);
    }

    /* renamed from: k */
    public void m28111k(String str, String str2, String str3, Map<String, String[]> map, Map<String, Integer> map2, int i10, List<String> list, List<ServiceVerifyKit.C4582c> list2, int i11, String str4, String str5, Intent intent, ServiceVerifyKit.C4580a.a aVar, Map<String, String> map3, String str6) {
        this.f21076a = str;
        this.f21077b = str2;
        this.f21078c = str3;
        this.f21079d = map;
        this.f21080e = map2;
        this.f21082g = i10;
        this.f21083h = list;
        this.f21084i = list2;
        this.f21085j = i11;
        this.f21086k = str4;
        this.f21087l = str5;
        this.f21088m = intent;
        this.f21089n = aVar;
        this.f21081f = map3;
        this.f21096u = str6;
    }

    /* renamed from: l */
    public final boolean m28112l(Bundle bundle, String str, String str2, int i10) {
        for (Map.Entry<String, String> entry : this.f21081f.entrySet()) {
            if (bundle.containsKey(entry.getKey()) || bundle.containsKey(entry.getValue())) {
                if (m28115o(bundle, str2, str, entry.getKey(), entry.getValue())) {
                    this.f21091p = 0;
                    this.f21090o = i10;
                    return true;
                }
                C1441b.f6211b.m8284a("MatchAppFinder", "checkSinger failed, packageName is " + str2);
            }
        }
        if (!m28113m(str2, str)) {
            return false;
        }
        this.f21091p = 1;
        this.f21090o = this.f21080e.get(str2).intValue();
        C1441b.f6211b.m8286c("MatchAppFinder", "Legacy is success, packageName is " + str2);
        return true;
    }

    /* renamed from: m */
    public boolean m28113m(String str, String str2) {
        String[] strArr;
        if (this.f21079d.containsKey(str) && (strArr = this.f21079d.get(str)) != null) {
            for (String str3 : strArr) {
                if (str2.equals(str3)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: n */
    public final boolean m28114n(String str, String str2, String str3) throws UnsupportedEncodingException {
        C1441b c1441b;
        String str4;
        byte[] bytes;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            c1441b = C1441b.f6211b;
            str4 = "args is invalid";
        } else {
            List<X509Certificate> listM7460k = C1246c.m7460k(str3);
            if (listM7460k.size() == 0) {
                c1441b = C1441b.f6211b;
                str4 = "certChain is empty";
            } else if (C1246c.m7457h(C1246c.m7451b(this.f21094s), listM7460k)) {
                X509Certificate x509Certificate = listM7460k.get(0);
                if (!C1246c.m7455f(x509Certificate, this.f21077b)) {
                    c1441b = C1441b.f6211b;
                    str4 = "CN is invalid";
                } else if (C1246c.m7462m(x509Certificate, this.f21078c)) {
                    try {
                        bytes = str.getBytes(Constants.UTF_8);
                    } catch (UnsupportedEncodingException e10) {
                        C1441b.f6211b.m8285b("MatchAppFinder", "checkCertChain UnsupportedEncodingException:", e10);
                        bytes = null;
                    }
                    if (C1246c.m7458i(x509Certificate, bytes, C1244a.m7445a(str2))) {
                        return true;
                    }
                    c1441b = C1441b.f6211b;
                    str4 = "signature is invalid";
                } else {
                    c1441b = C1441b.f6211b;
                    str4 = "OU is invalid";
                }
            } else {
                c1441b = C1441b.f6211b;
                str4 = "failed to verify cert chain";
            }
        }
        c1441b.m8284a("MatchAppFinder", str4);
        return false;
    }

    /* renamed from: o */
    public final boolean m28115o(Bundle bundle, String str, String str2, String str3, String str4) {
        C1441b c1441b;
        String str5;
        StringBuilder sb2;
        if (bundle.containsKey(str3) && bundle.containsKey(str4)) {
            if (TextUtils.isEmpty(this.f21096u)) {
                sb2 = new StringBuilder();
            } else {
                sb2 = new StringBuilder();
                sb2.append(this.f21096u);
                sb2.append("&");
            }
            sb2.append(str);
            sb2.append("&");
            sb2.append(str2);
            if (m28114n(sb2.toString(), bundle.getString(str3), bundle.getString(str4))) {
                return true;
            }
            c1441b = C1441b.f6211b;
            str5 = "checkSinger failed";
        } else {
            c1441b = C1441b.f6211b;
            str5 = "skip package " + str + " for no signer or no certChain";
        }
        c1441b.m8284a("MatchAppFinder", str5);
        return false;
    }
}
