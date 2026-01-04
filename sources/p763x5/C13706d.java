package p763x5;

import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pe.C12132a;

/* renamed from: x5.d */
/* loaded from: classes.dex */
public class C13706d implements InterfaceC13705c {

    /* renamed from: a */
    public List<InterfaceC13705c> f61702a = new ArrayList();

    @Override // p763x5.InterfaceC13705c
    /* renamed from: a */
    public void mo82451a(C12132a c12132a, String str, int i10, long j10, String str2) throws RemoteException {
        if (c12132a == null) {
            return;
        }
        Iterator<InterfaceC13705c> it = this.f61702a.iterator();
        while (it.hasNext()) {
            it.next().mo82451a(c12132a, str, i10, j10, str2);
        }
    }

    /* renamed from: b */
    public C13706d m82452b(InterfaceC13705c interfaceC13705c) {
        this.f61702a.add(interfaceC13705c);
        return this;
    }
}
