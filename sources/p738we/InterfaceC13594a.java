package p738we;

import p677ue.C13168a;
import p809yg.C13981a;

/* renamed from: we.a */
/* loaded from: classes4.dex */
public interface InterfaceC13594a {
    /* renamed from: c */
    boolean mo26024c();

    /* renamed from: f */
    boolean mo26025f();

    /* renamed from: g */
    boolean mo26026g();

    /* renamed from: h */
    default boolean m81752h(String str) {
        C13981a.m83989i("AncillaryDeviceOperate", "perDeviceType = " + str);
        if (C13168a.m79181j(str)) {
            return mo26026g();
        }
        if (C13168a.m79186o(str)) {
            return mo26025f();
        }
        if (C13168a.m79183l(str)) {
            return mo26024c();
        }
        C13981a.m83988e("AncillaryDeviceOperate", "device type is not define");
        return false;
    }
}
