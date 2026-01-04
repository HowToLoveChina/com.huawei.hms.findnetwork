package ws;

import java.io.IOException;
import p786xs.C13855b;
import p786xs.C13856c;

/* renamed from: ws.f */
/* loaded from: classes8.dex */
public final class RunnableC13632f implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ String f61304a;

    /* renamed from: b */
    public final /* synthetic */ String f61305b;

    /* renamed from: c */
    public final /* synthetic */ String f61306c;

    /* renamed from: d */
    public final /* synthetic */ String f61307d;

    public RunnableC13632f(String str, String str2, String str3, String str4) {
        this.f61304a = str;
        this.f61305b = str2;
        this.f61306c = str3;
        this.f61307d = str4;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Thread.currentThread().setName("SDM-TileStoreManager-" + hashCode());
        if (C13856c.m83166b(this.f61304a, this.f61305b, this.f61306c, this.f61307d)) {
            return;
        }
        C13855b.m83162a();
    }
}
