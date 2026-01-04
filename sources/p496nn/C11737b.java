package p496nn;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import p015ak.C0213f;
import p514o9.C11839m;
import p664u0.C13108a;

/* renamed from: nn.b */
/* loaded from: classes6.dex */
public class C11737b {

    /* renamed from: a */
    public final ArrayList<InterfaceC11736a> f54287a;

    /* renamed from: nn.b$b */
    public static class b {

        /* renamed from: a */
        public static C11737b f54288a = new C11737b();
    }

    /* renamed from: b */
    public static C11737b m70035b() {
        return b.f54288a;
    }

    /* renamed from: a */
    public synchronized void m70036a(InterfaceC11736a interfaceC11736a) {
        if (interfaceC11736a == null) {
            return;
        }
        this.f54287a.add(interfaceC11736a);
    }

    /* renamed from: c */
    public synchronized void m70037c() {
        C11839m.m70688i("AlbumClientObserverManager", "notifyAlbumChanged");
        Iterator<InterfaceC11736a> it = this.f54287a.iterator();
        while (it.hasNext()) {
            it.next().mo13316a();
        }
    }

    /* renamed from: d */
    public synchronized void m70038d() {
        try {
            C11839m.m70688i("AlbumClientObserverManager", "notifyDownloadSyncCompleted");
            Iterator<InterfaceC11736a> it = this.f54287a.iterator();
            while (it.hasNext()) {
                it.next().mo13319d();
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.hidisk.action.ALBUM_CLIENT_DOWNLOAD_SYNC_COMPLETE");
            C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: e */
    public synchronized void m70039e() {
        C11839m.m70688i("AlbumClientObserverManager", "notifyMediaChanged");
        Iterator<InterfaceC11736a> it = this.f54287a.iterator();
        while (it.hasNext()) {
            it.next().mo13318c();
        }
    }

    /* renamed from: f */
    public synchronized void m70040f() {
        try {
            C11839m.m70688i("AlbumClientObserverManager", "notifyShareDownloadSyncCompleted");
            Iterator<InterfaceC11736a> it = this.f54287a.iterator();
            while (it.hasNext()) {
                it.next().mo13317b();
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.hidisk.action.ALBUM_CLIENT_SHARE_DOWNLOAD_SYNC_COMPLETE");
            C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: g */
    public synchronized void m70041g(InterfaceC11736a interfaceC11736a) {
        if (interfaceC11736a == null) {
            return;
        }
        this.f54287a.remove(interfaceC11736a);
    }

    public C11737b() {
        this.f54287a = new ArrayList<>();
    }
}
