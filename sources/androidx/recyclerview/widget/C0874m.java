package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0862a;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.m */
/* loaded from: classes.dex */
public class C0874m {

    /* renamed from: a */
    public final a f4622a;

    /* renamed from: androidx.recyclerview.widget.m$a */
    public interface a {
        /* renamed from: a */
        void mo5407a(C0862a.b bVar);

        /* renamed from: b */
        C0862a.b mo5408b(int i10, int i11, int i12, Object obj);
    }

    public C0874m(a aVar) {
        this.f4622a = aVar;
    }

    /* renamed from: a */
    public final int m5542a(List<C0862a.b> list) {
        boolean z10 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f4471a != 8) {
                z10 = true;
            } else if (z10) {
                return size;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public void m5543b(List<C0862a.b> list) {
        while (true) {
            int iM5542a = m5542a(list);
            if (iM5542a == -1) {
                return;
            } else {
                m5545d(list, iM5542a, iM5542a + 1);
            }
        }
    }

    /* renamed from: c */
    public final void m5544c(List<C0862a.b> list, int i10, C0862a.b bVar, int i11, C0862a.b bVar2) {
        int i12 = bVar.f4474d;
        int i13 = bVar2.f4472b;
        int i14 = i12 < i13 ? -1 : 0;
        int i15 = bVar.f4472b;
        if (i15 < i13) {
            i14++;
        }
        if (i13 <= i15) {
            bVar.f4472b = i15 + bVar2.f4474d;
        }
        int i16 = bVar2.f4472b;
        if (i16 <= i12) {
            bVar.f4474d = i12 + bVar2.f4474d;
        }
        bVar2.f4472b = i16 + i14;
        list.set(i10, bVar2);
        list.set(i11, bVar);
    }

    /* renamed from: d */
    public final void m5545d(List<C0862a.b> list, int i10, int i11) {
        C0862a.b bVar = list.get(i10);
        C0862a.b bVar2 = list.get(i11);
        int i12 = bVar2.f4471a;
        if (i12 == 1) {
            m5544c(list, i10, bVar, i11, bVar2);
        } else if (i12 == 2) {
            m5546e(list, i10, bVar, i11, bVar2);
        } else {
            if (i12 != 4) {
                return;
            }
            m5547f(list, i10, bVar, i11, bVar2);
        }
    }

    /* renamed from: e */
    public void m5546e(List<C0862a.b> list, int i10, C0862a.b bVar, int i11, C0862a.b bVar2) {
        boolean z10;
        int i12 = bVar.f4472b;
        int i13 = bVar.f4474d;
        boolean z11 = false;
        if (i12 < i13) {
            if (bVar2.f4472b == i12 && bVar2.f4474d == i13 - i12) {
                z10 = false;
                z11 = true;
            } else {
                z10 = false;
            }
        } else if (bVar2.f4472b == i13 + 1 && bVar2.f4474d == i12 - i13) {
            z10 = true;
            z11 = true;
        } else {
            z10 = true;
        }
        int i14 = bVar2.f4472b;
        if (i13 < i14) {
            bVar2.f4472b = i14 - 1;
        } else {
            int i15 = bVar2.f4474d;
            if (i13 < i14 + i15) {
                bVar2.f4474d = i15 - 1;
                bVar.f4471a = 2;
                bVar.f4474d = 1;
                if (bVar2.f4474d == 0) {
                    list.remove(i11);
                    this.f4622a.mo5407a(bVar2);
                    return;
                }
                return;
            }
        }
        int i16 = bVar.f4472b;
        int i17 = bVar2.f4472b;
        C0862a.b bVarMo5408b = null;
        if (i16 <= i17) {
            bVar2.f4472b = i17 + 1;
        } else {
            int i18 = bVar2.f4474d;
            if (i16 < i17 + i18) {
                bVarMo5408b = this.f4622a.mo5408b(2, i16 + 1, (i17 + i18) - i16, null);
                bVar2.f4474d = bVar.f4472b - bVar2.f4472b;
            }
        }
        if (z11) {
            list.set(i10, bVar2);
            list.remove(i11);
            this.f4622a.mo5407a(bVar);
            return;
        }
        if (z10) {
            if (bVarMo5408b != null) {
                int i19 = bVar.f4472b;
                if (i19 > bVarMo5408b.f4472b) {
                    bVar.f4472b = i19 - bVarMo5408b.f4474d;
                }
                int i20 = bVar.f4474d;
                if (i20 > bVarMo5408b.f4472b) {
                    bVar.f4474d = i20 - bVarMo5408b.f4474d;
                }
            }
            int i21 = bVar.f4472b;
            if (i21 > bVar2.f4472b) {
                bVar.f4472b = i21 - bVar2.f4474d;
            }
            int i22 = bVar.f4474d;
            if (i22 > bVar2.f4472b) {
                bVar.f4474d = i22 - bVar2.f4474d;
            }
        } else {
            if (bVarMo5408b != null) {
                int i23 = bVar.f4472b;
                if (i23 >= bVarMo5408b.f4472b) {
                    bVar.f4472b = i23 - bVarMo5408b.f4474d;
                }
                int i24 = bVar.f4474d;
                if (i24 >= bVarMo5408b.f4472b) {
                    bVar.f4474d = i24 - bVarMo5408b.f4474d;
                }
            }
            int i25 = bVar.f4472b;
            if (i25 >= bVar2.f4472b) {
                bVar.f4472b = i25 - bVar2.f4474d;
            }
            int i26 = bVar.f4474d;
            if (i26 >= bVar2.f4472b) {
                bVar.f4474d = i26 - bVar2.f4474d;
            }
        }
        list.set(i10, bVar2);
        if (bVar.f4472b != bVar.f4474d) {
            list.set(i11, bVar);
        } else {
            list.remove(i11);
        }
        if (bVarMo5408b != null) {
            list.add(i10, bVarMo5408b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m5547f(java.util.List<androidx.recyclerview.widget.C0862a.b> r9, int r10, androidx.recyclerview.widget.C0862a.b r11, int r12, androidx.recyclerview.widget.C0862a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f4474d
            int r1 = r13.f4472b
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.f4472b = r1
            goto L20
        Ld:
            int r5 = r13.f4474d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.f4474d = r5
            androidx.recyclerview.widget.m$a r0 = r8.f4622a
            int r1 = r11.f4472b
            java.lang.Object r5 = r13.f4473c
            androidx.recyclerview.widget.a$b r0 = r0.mo5408b(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.f4472b
            int r5 = r13.f4472b
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.f4472b = r5
            goto L41
        L2b:
            int r6 = r13.f4474d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.m$a r4 = r8.f4622a
            int r1 = r1 + r3
            java.lang.Object r3 = r13.f4473c
            androidx.recyclerview.widget.a$b r4 = r4.mo5408b(r2, r1, r5, r3)
            int r1 = r13.f4474d
            int r1 = r1 - r5
            r13.f4474d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f4474d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.m$a r8 = r8.f4622a
            r8.mo5407a(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C0874m.m5547f(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
