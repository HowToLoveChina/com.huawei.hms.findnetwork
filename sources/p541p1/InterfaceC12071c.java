package p541p1;

import java.util.ArrayList;
import p563q1.C12272a;
import p598r1.C12455a;
import p598r1.C12457c;

/* renamed from: p1.c */
/* loaded from: classes.dex */
public interface InterfaceC12071c {
    /* renamed from: a */
    static boolean m72222a(InterfaceC12071c interfaceC12071c) {
        C12455a c12455a;
        ArrayList<C12457c> arrayList;
        if (interfaceC12071c == null) {
            return false;
        }
        if (1 != interfaceC12071c.mo72223a()) {
            return 2 == interfaceC12071c.mo72223a() && (arrayList = (c12455a = (C12455a) interfaceC12071c).f57380b) != null && arrayList.size() >= 1 && c12455a.f57380b.get(0).f57385b != null && c12455a.f57380b.get(0).f57385b.size() >= 1 && c12455a.f57380b.get(0).f57385b.get(0).f55891a != null;
        }
        C12272a c12272a = (C12272a) interfaceC12071c;
        ArrayList<C12073e> arrayList2 = c12272a.f56911b;
        return (arrayList2 == null || arrayList2.size() < 1 || c12272a.f56911b.get(0).f55891a == null) ? false : true;
    }

    /* renamed from: a */
    int mo72223a();

    int getDuration();
}
