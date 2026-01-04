package com.baidu.location.provider;

import android.net.wifi.ScanResult;
import com.baidu.location.p065a.C1534f;
import java.util.List;
import java.util.Locale;

/* renamed from: com.baidu.location.provider.g */
/* loaded from: classes.dex */
public class C1544g {

    /* renamed from: f */
    private static final long f6815f = 10;

    /* renamed from: a */
    public List<ScanResult> f6816a;

    /* renamed from: b */
    private long f6817b;

    /* renamed from: c */
    private long f6818c;

    /* renamed from: d */
    private boolean f6819d;

    /* renamed from: e */
    private boolean f6820e;

    public C1544g(C1544g c1544g) {
        this.f6816a = null;
        this.f6817b = 0L;
        this.f6818c = 0L;
        this.f6819d = false;
        if (c1544g != null) {
            this.f6816a = c1544g.f6816a;
            this.f6817b = c1544g.f6817b;
            this.f6818c = c1544g.f6818c;
            this.f6819d = c1544g.f6819d;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* renamed from: k */
    private void m8878k() {
        /*
            r7 = this;
            int r0 = r7.m8882b()
            r1 = 1
            if (r0 >= r1) goto L8
            return
        L8:
            java.util.List<android.net.wifi.ScanResult> r0 = r7.f6816a
            int r0 = r0.size()
            int r0 = r0 - r1
            r2 = r1
        L10:
            if (r0 < r1) goto L5e
            if (r2 == 0) goto L5e
            r2 = 0
            r3 = r2
        L16:
            if (r2 >= r0) goto L5a
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6816a
            java.lang.Object r4 = r4.get(r2)
            if (r4 == 0) goto L57
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6816a
            int r5 = r2 + 1
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L57
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6816a
            java.lang.Object r4 = r4.get(r2)
            android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
            int r4 = r4.level
            java.util.List<android.net.wifi.ScanResult> r6 = r7.f6816a
            java.lang.Object r6 = r6.get(r5)
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            int r6 = r6.level
            if (r4 >= r6) goto L57
            java.util.List<android.net.wifi.ScanResult> r3 = r7.f6816a
            java.lang.Object r3 = r3.get(r5)
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6816a
            java.lang.Object r6 = r4.get(r2)
            r4.set(r5, r6)
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6816a
            r4.set(r2, r3)
            r3 = r1
        L57:
            int r2 = r2 + 1
            goto L16
        L5a:
            int r0 = r0 + (-1)
            r2 = r3
            goto L10
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1544g.m8878k():void");
    }

    /* renamed from: a */
    public String m8879a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("wifi=");
        if (this.f6816a == null) {
            return sb2.toString();
        }
        for (int i10 = 0; i10 < this.f6816a.size(); i10++) {
            int i11 = this.f6816a.get(i10).level;
            String str = this.f6816a.get(i10).BSSID;
            if (str != null) {
                sb2.append(str.replace(":", ""));
                sb2.append(String.format(Locale.CHINA, ",%d;", Integer.valueOf(i11)));
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public int m8882b() {
        List<ScanResult> list = this.f6816a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: c */
    public String m8885c() {
        try {
            return m8880a(C1534f.f6680z);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public long m8887d() {
        return this.f6818c;
    }

    /* renamed from: e */
    public String m8889e() {
        try {
            return m8880a(15);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: f */
    public int m8890f() {
        for (int i10 = 0; i10 < m8882b(); i10++) {
            int i11 = -this.f6816a.get(i10).level;
            if (i11 > 0) {
                return i11;
            }
        }
        return 0;
    }

    /* renamed from: g */
    public boolean m8891g() {
        return this.f6819d;
    }

    /* renamed from: h */
    public boolean m8892h() {
        return System.currentTimeMillis() - this.f6818c > 0 && System.currentTimeMillis() - this.f6818c < 10000;
    }

    /* renamed from: i */
    public boolean m8893i() {
        return System.currentTimeMillis() - this.f6818c > 0 && System.currentTimeMillis() - this.f6818c < 10000;
    }

    /* renamed from: j */
    public boolean m8894j() {
        return System.currentTimeMillis() - this.f6818c > 0 && System.currentTimeMillis() - this.f6817b < 10000;
    }

    public C1544g(List<ScanResult> list, long j10) {
        this.f6818c = 0L;
        this.f6819d = false;
        this.f6817b = j10;
        this.f6816a = list;
        this.f6818c = System.currentTimeMillis();
        m8878k();
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x016e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m8880a(int r22) {
        /*
            Method dump skipped, instructions count: 635
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1544g.m8880a(int):java.lang.String");
    }

    /* renamed from: b */
    public String m8883b(int i10) {
        boolean z10 = true;
        if (m8882b() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = this.f6816a.size();
        if (size <= i10) {
            i10 = size;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f6816a.get(i11).level != 0 && this.f6816a.get(i11).BSSID != null) {
                if (z10) {
                    z10 = false;
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(this.f6816a.get(i11).BSSID.replace(":", ""));
                int i12 = this.f6816a.get(i11).level;
                if (i12 < 0) {
                    i12 = -i12;
                }
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i12)));
            }
        }
        if (z10) {
            return null;
        }
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public boolean m8886c(C1544g c1544g) {
        return WifiMan.m8752a(c1544g, this, C1534f.f6642A);
    }

    /* renamed from: d */
    public boolean m8888d(C1544g c1544g) {
        return WifiMan.m8752a(c1544g, this, 0.5f);
    }

    /* renamed from: a */
    public boolean m8881a(C1544g c1544g) {
        List<ScanResult> list = this.f6816a;
        if (list == null || c1544g == null || c1544g.f6816a == null) {
            return false;
        }
        int size = (list.size() < c1544g.f6816a.size() ? this.f6816a : c1544g.f6816a).size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f6816a.get(i10).BSSID.equals(c1544g.f6816a.get(i10).BSSID)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m8884b(C1544g c1544g) {
        List<ScanResult> list = this.f6816a;
        if (list == null || c1544g == null || c1544g.f6816a == null) {
            return false;
        }
        int size = (list.size() < c1544g.f6816a.size() ? this.f6816a : c1544g.f6816a).size();
        for (int i10 = 0; i10 < size; i10++) {
            String str = this.f6816a.get(i10).BSSID;
            int i11 = this.f6816a.get(i10).level;
            String str2 = c1544g.f6816a.get(i10).BSSID;
            int i12 = c1544g.f6816a.get(i10).level;
            if (!str.equals(str2) || i11 != i12) {
                return false;
            }
        }
        return true;
    }
}
