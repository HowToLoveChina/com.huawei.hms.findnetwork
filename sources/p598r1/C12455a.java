package p598r1;

import java.util.ArrayList;
import java.util.Iterator;
import p541p1.C12070b;
import p541p1.C12073e;
import p541p1.InterfaceC12071c;

/* renamed from: r1.a */
/* loaded from: classes.dex */
public class C12455a implements InterfaceC12071c {

    /* renamed from: a */
    public C12456b f57379a;

    /* renamed from: b */
    public ArrayList<C12457c> f57380b;

    @Override // p541p1.InterfaceC12071c
    /* renamed from: a */
    public int mo72223a() {
        return this.f57379a.f57381a;
    }

    /* renamed from: b */
    public int m74711b(int i10) {
        for (int i11 = 0; i11 < this.f57380b.size(); i11++) {
            try {
                for (int i12 = 0; i12 < this.f57380b.get(i11).f57385b.size(); i12++) {
                    if (this.f57380b.get(i11).f57384a <= i10 && this.f57380b.get(i11).f57384a + this.f57380b.get(i11).f57385b.get(i12).f55891a.f55884b >= i10) {
                        return i11;
                    }
                    if (this.f57380b.get(i11).f57384a > i10) {
                        return i11 - 1;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return Integer.MIN_VALUE;
            }
        }
        return Integer.MIN_VALUE;
    }

    @Override // p541p1.InterfaceC12071c
    public int getDuration() {
        int i10;
        try {
            C12457c c12457c = this.f57380b.get(r6.size() - 1);
            Iterator<C12073e> it = c12457c.f57385b.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                C12073e next = it.next();
                if (next.f55891a.f55883a.equals("continuous")) {
                    C12070b c12070b = next.f55891a;
                    i10 = c12070b.f55884b + c12070b.f55885c;
                } else {
                    i10 = next.f55891a.f55884b + 48;
                }
                if (i10 > i11) {
                    i11 = i10;
                }
            }
            return i11 + c12457c.f57384a;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }
}
