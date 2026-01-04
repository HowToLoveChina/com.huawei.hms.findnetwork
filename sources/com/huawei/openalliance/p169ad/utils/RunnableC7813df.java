package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.InterfaceC7002cs;

/* renamed from: com.huawei.openalliance.ad.utils.df */
/* loaded from: classes2.dex */
public class RunnableC7813df implements Runnable {

    /* renamed from: a */
    private static InterfaceC7002cs f36089a;

    /* renamed from: b */
    private Runnable f36090b;

    public RunnableC7813df(Runnable runnable) {
        this.f36090b = runnable;
    }

    /* renamed from: a */
    public static void m48356a(InterfaceC7002cs interfaceC7002cs) {
        f36089a = interfaceC7002cs;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f36090b;
        if (runnable != null) {
            try {
                runnable.run();
            } finally {
                try {
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
    }
}
