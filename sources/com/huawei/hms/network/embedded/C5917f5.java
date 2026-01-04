package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.f5 */
/* loaded from: classes8.dex */
public class C5917f5 implements InterfaceC5930g5 {

    /* renamed from: a */
    public boolean f26743a;

    /* renamed from: b */
    public boolean f26744b;

    /* renamed from: c */
    public boolean f26745c;

    /* renamed from: d */
    public int f26746d;

    /* renamed from: e */
    public int f26747e;

    /* renamed from: f */
    public long f26748f;

    /* renamed from: g */
    public int f26749g = 0;

    /* renamed from: h */
    public int f26750h = 0;

    /* renamed from: i */
    public int f26751i = 0;

    /* renamed from: j */
    public boolean f26752j;

    @Override // com.huawei.hms.network.embedded.InterfaceC5930g5
    /* renamed from: a */
    public int mo34215a() {
        if (this.f26752j) {
            this.f26751i = 1;
        }
        return this.f26751i;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5930g5
    /* renamed from: b */
    public int mo34219b() {
        int i10;
        int i11 = this.f26746d;
        if (i11 == 1) {
            int i12 = this.f26747e;
            if (i12 == 1) {
                this.f26750h = 1;
            } else if (i12 == 2) {
                this.f26750h = 2;
            } else if (i12 == 3) {
                this.f26750h = 3;
            } else if (i12 == 0) {
                i10 = 10;
                this.f26750h = i10;
            }
        } else if (i11 == 4) {
            int i13 = this.f26747e;
            if (i13 == 1) {
                this.f26750h = 4;
            } else if (i13 == 2) {
                this.f26750h = 5;
            } else {
                if (i13 == 3) {
                    i10 = 6;
                } else if (i13 == 0) {
                    i10 = 11;
                }
                this.f26750h = i10;
            }
        } else if (i11 == 5) {
            int i14 = this.f26747e;
            if (i14 == 1) {
                i10 = 7;
            } else if (i14 == 2) {
                i10 = 8;
            } else if (i14 == 3) {
                i10 = 9;
            } else if (i14 == 0) {
                i10 = 12;
            }
            this.f26750h = i10;
        } else if (i11 == 0) {
            int i15 = this.f26747e;
            if (i15 == 1) {
                i10 = 13;
            } else if (i15 == 2) {
                i10 = 14;
            } else if (i15 == 3) {
                i10 = 15;
            } else if (i15 == 0) {
                i10 = 16;
            }
            this.f26750h = i10;
        }
        return this.f26750h;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5930g5
    /* renamed from: c */
    public int mo34222c() {
        int i10;
        if (this.f26745c) {
            boolean z10 = this.f26743a;
            if (z10 && this.f26744b) {
                this.f26749g = 1;
            }
            if (z10 && !this.f26744b) {
                this.f26749g = 2;
            }
            if (!z10 && this.f26744b) {
                this.f26749g = 3;
            }
            if (!z10 && !this.f26744b) {
                i10 = 4;
                this.f26749g = i10;
            }
        } else {
            boolean z11 = this.f26743a;
            if (z11 && this.f26744b) {
                this.f26749g = 5;
            }
            if (z11 && !this.f26744b) {
                this.f26749g = 6;
            }
            if (!z11 && this.f26744b) {
                this.f26749g = 7;
            }
            if (!z11 && !this.f26744b) {
                i10 = 8;
                this.f26749g = i10;
            }
        }
        return this.f26749g;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5930g5
    /* renamed from: d */
    public long mo34224d() {
        return this.f26748f;
    }

    public String toString() {
        return "SystemControlImpl{isDozeIdleMode=" + this.f26743a + ", isAppIdleMode=" + this.f26744b + ", isAllowList=" + this.f26745c + ", isPowerSaverMode=" + this.f26746d + ", isDataSaverMode=" + this.f26747e + ", sysControlTimeStamp=" + this.f26748f + ", sysControlMode=" + this.f26749g + ", controlPolicyMode=" + this.f26750h + ", hwControlMode=" + this.f26751i + ", isFreeze=" + this.f26752j + '}';
    }

    /* renamed from: a */
    public void m34216a(int i10) {
        this.f26747e = i10;
    }

    /* renamed from: b */
    public void m34220b(int i10) {
        this.f26746d = i10;
    }

    /* renamed from: c */
    public void m34223c(boolean z10) {
        this.f26743a = z10;
    }

    /* renamed from: d */
    public void m34225d(boolean z10) {
        this.f26752j = z10;
    }

    /* renamed from: a */
    public void m34217a(long j10) {
        this.f26748f = j10;
    }

    /* renamed from: b */
    public void m34221b(boolean z10) {
        this.f26744b = z10;
    }

    /* renamed from: a */
    public void m34218a(boolean z10) {
        this.f26745c = z10;
    }
}
