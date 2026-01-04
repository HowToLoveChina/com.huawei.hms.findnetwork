package hn;

import com.huawei.hicloud.notificationv2.bean.C4972b;
import gn.InterfaceC10020c;
import gn.InterfaceC10021d;
import java.util.function.Consumer;
import p780xm.C13836h;

/* renamed from: hn.c */
/* loaded from: classes6.dex */
public class C10324c implements InterfaceC10020c {

    /* renamed from: a */
    public static final C13836h f49997a = new C13836h(1, 1, 200, "backup_event_executor");

    /* renamed from: g */
    public static /* synthetic */ void m63590g(final C4972b c4972b) {
        InterfaceC10021d.get().forEach(new Consumer() { // from class: hn.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((InterfaceC10021d) obj).mo62166a(c4972b);
            }
        });
    }

    @Override // gn.InterfaceC10020c
    /* renamed from: b */
    public void mo62163b(final C4972b c4972b) {
        f49997a.submit(new Runnable() { // from class: hn.a
            @Override // java.lang.Runnable
            public final void run() {
                C10324c.m63590g(c4972b);
            }
        });
    }
}
