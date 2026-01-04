package com.huawei.android.hicloud.connect.progress;

import ck.C1444b;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import gp.C10028c;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class Retry {

    /* renamed from: i */
    public static final int[] f12101i = {400, 408, ErrorCode.ERROR_CODE_OTHER, 500, 502};

    /* renamed from: j */
    public static final int[] f12102j = {ErrorCode.ERROR_CODE_OTHER, 500, 502};

    /* renamed from: k */
    public static final int[] f12103k = {4307, 4312};

    /* renamed from: a */
    public List<Long> f12104a;

    /* renamed from: b */
    public long f12105b;

    /* renamed from: c */
    public int f12106c;

    /* renamed from: d */
    public int f12107d;

    /* renamed from: e */
    public int f12108e;

    /* renamed from: f */
    public int f12109f;

    /* renamed from: g */
    public long f12110g;

    /* renamed from: h */
    public int[] f12111h;

    public interface Action<T> {
    }

    public Retry(int i10) {
        this(i10, 10000L);
        if (!C10028c.m62182c0().m62420y1()) {
            this.f12111h = f12103k;
            return;
        }
        if (i10 == 1) {
            this.f12111h = f12101i;
        }
        if (i10 == 2) {
            this.f12111h = f12102j;
        }
    }

    /* renamed from: a */
    public boolean m16232a() {
        return m16233b(C10028c.m62182c0().m62420y1());
    }

    /* renamed from: b */
    public boolean m16233b(boolean z10) throws InterruptedException {
        C11839m.m70688i("Retry", "isAllowRetry errorCode: " + this.f12108e + " isNoEncryptionProcess:" + z10);
        C11839m.m70687e("Retry", "isAllowRetry continue" + C10028c.m62182c0().m62420y1() + " isDispersedCode: " + (m16234c() ^ true));
        if (z10 && this.f12108e >= 400 && !m16234c()) {
            return false;
        }
        int size = this.f12104a.size();
        int i10 = this.f12106c;
        if (size - i10 >= 1) {
            long jAbs = 0;
            for (int i11 = size - i10; i11 < size; i11++) {
                jAbs += Math.abs(this.f12104a.get(i11).longValue() - this.f12104a.get(i11 - 1).longValue());
            }
            return jAbs > this.f12105b;
        }
        if (z10 || m16235d()) {
            int i12 = size - 1;
            try {
                long j10 = this.f12110g;
                if (i12 < 0) {
                    i12 = 1;
                }
                Thread.sleep(j10 * i12);
            } catch (InterruptedException unused) {
                C11839m.m70687e("Retry", "isAllowRetry InterruptedException");
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public final boolean m16234c() {
        if (!C10028c.m62182c0().m62420y1()) {
            if (this.f12109f == 1) {
                return m16236e(f12103k);
            }
            return false;
        }
        int i10 = this.f12109f;
        if (i10 == 1) {
            return m16236e(f12101i);
        }
        if (i10 == 2) {
            return m16236e(f12102j);
        }
        return false;
    }

    /* renamed from: d */
    public final boolean m16235d() {
        for (int i10 : this.f12111h) {
            if (this.f12108e == i10) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m16236e(int[] iArr) {
        for (int i10 : iArr) {
            if (this.f12108e == i10) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public void m16237f() {
        this.f12104a.add(Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: g */
    public void m16238g(int i10) {
        this.f12108e = i10;
        this.f12104a.add(Long.valueOf(System.currentTimeMillis()));
    }

    public Retry(int[] iArr) {
        this(10000L);
        this.f12111h = iArr;
    }

    public Retry(long j10) {
        this.f12104a = new ArrayList();
        this.f12107d = 0;
        this.f12111h = new int[0];
        this.f12105b = C1444b.m8310p() * 60000;
        this.f12106c = C1444b.m8309o();
        this.f12104a.add(Long.valueOf(System.currentTimeMillis()));
        this.f12110g = j10;
    }

    public Retry(int i10, long j10) {
        this.f12104a = new ArrayList();
        this.f12107d = 0;
        this.f12111h = new int[0];
        this.f12105b = C1444b.m8310p() * 60000;
        this.f12106c = C1444b.m8309o();
        this.f12104a.add(Long.valueOf(System.currentTimeMillis()));
        this.f12110g = j10;
        this.f12109f = i10;
    }
}
