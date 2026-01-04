package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public final class SystemManager {

    /* renamed from: a */
    private static SystemManager f23127a = new SystemManager();

    /* renamed from: b */
    private static final Object f23128b = new Object();

    /* renamed from: c */
    private static SystemNotifier f23129c = new C5059a();

    private SystemManager() {
    }

    public static SystemManager getInstance() {
        return f23127a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f23129c;
    }

    public void notifyNoticeResult(int i10) {
        f23129c.notifyNoticeObservers(i10);
    }

    public void notifyResolutionResult(Intent intent, String str) {
        f23129c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i10) {
        f23129c.notifyObservers(i10);
    }

    /* renamed from: com.huawei.hms.adapter.sysobs.SystemManager$a */
    public class C5059a implements SystemNotifier {

        /* renamed from: a */
        private final List<SystemObserver> f23130a = new ArrayList();

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int i10) {
            synchronized (SystemManager.f23128b) {
                try {
                    Iterator<SystemObserver> it = this.f23130a.iterator();
                    while (it.hasNext()) {
                        if (it.next().onNoticeResult(i10)) {
                            it.remove();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.f23128b) {
                try {
                    Iterator<SystemObserver> it = this.f23130a.iterator();
                    while (it.hasNext()) {
                        if (it.next().onSolutionResult(intent, str)) {
                            it.remove();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver == null || this.f23130a.contains(systemObserver)) {
                return;
            }
            synchronized (SystemManager.f23128b) {
                this.f23130a.add(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.f23128b) {
                this.f23130a.remove(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i10) {
            synchronized (SystemManager.f23128b) {
                try {
                    Iterator<SystemObserver> it = this.f23130a.iterator();
                    while (it.hasNext()) {
                        if (it.next().onUpdateResult(i10)) {
                            it.remove();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
