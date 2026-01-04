package com.huawei.android.hicloud.cloudbackup.process.clone;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import p015ak.C0213f;
import p015ak.C0241z;
import p047c5.C1386a;
import p292fn.C9733f;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class ClonePowerKit {
    private static final int DEFAULT_KEEP_ALIVE_TIME = 1800000;
    private static final String TAG = "ClonePowerKit";
    private final List<ILiveKeeper> keepers = Collections.synchronizedList(new ArrayList(3));
    private static final Object POWER_KIT_LOCK = new Object();
    private static final ClonePowerKit INSTANCE = new ClonePowerKit();

    private ClonePowerKit() {
    }

    public static ClonePowerKit getInstance() {
        return INSTANCE;
    }

    private static long getKeepAliveTime() {
        String strM60762u = C9733f.m60705z().m60762u("backupDisableApplySysAppsResourceEx");
        long jM1688f = (TextUtils.isEmpty(strM60762u) || C0241z.m1688f(strM60762u) <= 0) ? 1800000L : C0241z.m1688f(strM60762u) * 1000;
        C11839m.m70686d(TAG, "getKeepAliveTime: " + jM1688f);
        return jM1688f;
    }

    private void keepOrReleaseAll(Consumer<ILiveKeeper> consumer) {
        synchronized (POWER_KIT_LOCK) {
            try {
                if (this.keepers.isEmpty()) {
                    return;
                }
                this.keepers.forEach(consumer);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void keepOrReleaseModule(final String str, Consumer<ILiveKeeper> consumer) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70686d(TAG, "moduleName is empty.");
            return;
        }
        synchronized (POWER_KIT_LOCK) {
            try {
                if (this.keepers.isEmpty()) {
                    return;
                }
                this.keepers.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.clone.c
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return ClonePowerKit.lambda$keepOrReleaseModule$2(str, (ILiveKeeper) obj);
                    }
                }).forEach(consumer);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$keepOrReleaseModule$2(String str, ILiveKeeper iLiveKeeper) {
        return iLiveKeeper.isMatched(str);
    }

    public void init() {
        this.keepers.clear();
        if (C9733f.m60705z().m60720O("backupDisableApplySysAppsResourceEx")) {
            return;
        }
        C11839m.m70688i(TAG, "init");
        C1386a.m7942b(C0213f.m1377a());
        this.keepers.add(new DefaultLiveKeeper(getKeepAliveTime()));
    }

    public void keepAlive(final String str) {
        keepOrReleaseModule(str, new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.clone.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((ILiveKeeper) obj).keepAlive(str);
            }
        });
    }

    public void keepAllAlive() {
        keepOrReleaseAll(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.clone.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((ILiveKeeper) obj).keepAllAlive();
            }
        });
    }

    public void release() {
        synchronized (POWER_KIT_LOCK) {
            try {
                if (this.keepers.isEmpty()) {
                    return;
                }
                C11839m.m70688i(TAG, "release");
                unKeepAliveAll();
                this.keepers.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void unKeepAlive(final String str) {
        keepOrReleaseModule(str, new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.clone.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((ILiveKeeper) obj).release(str);
            }
        });
    }

    public void unKeepAliveAll() {
        keepOrReleaseAll(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.clone.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((ILiveKeeper) obj).releaseAll();
            }
        });
    }
}
