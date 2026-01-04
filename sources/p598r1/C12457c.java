package p598r1;

import java.util.ArrayList;
import java.util.Iterator;
import p541p1.C12070b;
import p541p1.C12073e;

/* renamed from: r1.c */
/* loaded from: classes.dex */
public class C12457c {

    /* renamed from: a */
    public int f57384a;

    /* renamed from: b */
    public ArrayList<C12073e> f57385b;

    /* renamed from: a */
    public int m74712a() {
        int i10;
        try {
            Iterator<C12073e> it = this.f57385b.iterator();
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
            return i11;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }
}
