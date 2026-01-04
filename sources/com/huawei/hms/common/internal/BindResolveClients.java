package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* loaded from: classes8.dex */
public class BindResolveClients {

    /* renamed from: b */
    private static final Object f23478b = new Object();

    /* renamed from: a */
    private ArrayList<ResolveClientBean> f23479a;

    /* renamed from: com.huawei.hms.common.internal.BindResolveClients$b */
    public static class C5149b {

        /* renamed from: a */
        private static final BindResolveClients f23480a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return C5149b.f23480a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean zContains;
        synchronized (f23478b) {
            zContains = this.f23479a.contains(resolveClientBean);
        }
        return zContains;
    }

    public void notifyClientReconnect() {
        synchronized (f23478b) {
            try {
                ListIterator<ResolveClientBean> listIterator = this.f23479a.listIterator();
                while (listIterator.hasNext()) {
                    listIterator.next().clientReconnect();
                }
                this.f23479a.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f23478b) {
            try {
                if (!this.f23479a.contains(resolveClientBean)) {
                    this.f23479a.add(resolveClientBean);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f23478b) {
            try {
                if (this.f23479a.contains(resolveClientBean)) {
                    ListIterator<ResolveClientBean> listIterator = this.f23479a.listIterator();
                    while (true) {
                        if (!listIterator.hasNext()) {
                            break;
                        } else if (resolveClientBean.equals(listIterator.next())) {
                            listIterator.remove();
                            break;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void unRegisterAll() {
        synchronized (f23478b) {
            this.f23479a.clear();
        }
    }

    private BindResolveClients() {
        this.f23479a = new ArrayList<>();
    }
}
