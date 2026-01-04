package p415k2;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import p630s2.C12666a;
import p759x1.C13684i;
import p759x1.EnumC13678c;
import p759x1.InterfaceC13687l;
import p829z1.InterfaceC14083v;

/* renamed from: k2.c */
/* loaded from: classes.dex */
public class C10974c implements InterfaceC13687l<C10973b> {
    @Override // p759x1.InterfaceC13687l
    /* renamed from: a */
    public EnumC13678c mo61223a(C13684i c13684i) {
        return EnumC13678c.SOURCE;
    }

    @Override // p759x1.InterfaceC13679d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean mo56815b(InterfaceC14083v<C10973b> interfaceC14083v, File file, C13684i c13684i) throws Throwable {
        try {
            C12666a.m76251f(interfaceC14083v.get().m66305c(), file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e10);
            }
            return false;
        }
    }
}
