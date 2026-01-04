package com.huawei.openalliance.p169ad.download.p172ag;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.download.InterfaceC7032a;
import java.util.Iterator;

/* renamed from: com.huawei.openalliance.ad.download.ag.a */
/* loaded from: classes2.dex */
public class C7033a<T extends DownloadTask> {

    /* renamed from: a */
    protected Context f32268a;

    /* renamed from: b */
    protected InterfaceC7032a<T> f32269b;

    /* renamed from: c */
    protected C7034b<T> f32270c;

    public C7033a(Context context) {
        this.f32268a = context.getApplicationContext();
    }

    /* renamed from: a */
    public T mo42105a(String str) {
        return (T) this.f32270c.m42114a(str);
    }

    /* renamed from: b */
    public void m42110b() {
        AbstractC7185ho.m43820b("AdapterDownloadManager", "cancelAllDownload");
        Iterator<T> it = this.f32270c.m42115a().iterator();
        while (it.hasNext()) {
            m42108a(it.next(), true);
        }
        this.f32270c.m42117b();
    }

    /* renamed from: c */
    public boolean m42112c(T t10) {
        if (t10 == null) {
            return false;
        }
        boolean zM42118b = this.f32270c.m42118b(t10);
        AbstractC7185ho.m43820b("AdapterDownloadManager", "removeTask, succ:" + zM42118b);
        if (zM42118b) {
            m42108a(t10, true);
        }
        return true;
    }

    /* renamed from: a */
    public void m42106a() {
        if (this.f32270c == null) {
            this.f32270c = new C7034b<>();
        }
    }

    /* renamed from: b */
    public void m42111b(T t10) {
        if (t10 == null) {
            return;
        }
        AbstractC7185ho.m43820b("AdapterDownloadManager", "deleteTask, succ:" + this.f32270c.m42118b(t10));
    }

    /* renamed from: a */
    public void mo42107a(T t10) {
        this.f32270c.m42116a((C7034b<T>) t10);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AdapterDownloadManager", "addTask, task:%s, priority:%d", t10.mo42082n(), Integer.valueOf(t10.m42079k()));
        }
    }

    /* renamed from: a */
    public void m42108a(T t10, boolean z10) {
        if (t10 == null) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("AdapterDownloadManager", "onDownloadDeleted, taskId:%s", t10.mo42082n());
        }
        InterfaceC7032a<T> interfaceC7032a = this.f32269b;
        if (interfaceC7032a != null) {
            interfaceC7032a.mo42100a(t10, z10);
        }
    }

    /* renamed from: a */
    public void m42109a(InterfaceC7032a<T> interfaceC7032a) {
        this.f32269b = interfaceC7032a;
    }
}
