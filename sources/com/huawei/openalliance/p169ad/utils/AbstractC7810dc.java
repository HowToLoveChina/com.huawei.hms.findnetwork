package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.openalliance.ad.utils.dc */
/* loaded from: classes2.dex */
public abstract class AbstractC7810dc {

    /* renamed from: a */
    private static final String f36082a = "dc";

    /* renamed from: a */
    public static <RESULT> RESULT m48268a(Callable<RESULT> callable, long j10, RESULT result) {
        return (RESULT) m48270a(callable, result, j10, TimeUnit.MILLISECONDS);
    }

    /* renamed from: b */
    public static <RESULT> RESULT m48272b(Callable<RESULT> callable) {
        return (RESULT) m48270a(callable, null, 1L, TimeUnit.SECONDS);
    }

    /* renamed from: c */
    public static <RESULT> RESULT m48273c(Callable<RESULT> callable) {
        return (RESULT) m48270a(new CallableC7839r(callable), null, 1L, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public static <RESULT> RESULT m48269a(Callable<RESULT> callable, RESULT result) {
        return (RESULT) m48270a(callable, result, 1L, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public static <RESULT> RESULT m48270a(Callable<RESULT> callable, RESULT result, long j10, TimeUnit timeUnit) {
        String str;
        String str2;
        if (callable == null) {
            return result;
        }
        try {
            return (RESULT) AbstractC7834m.m48477a(callable, AbstractC7834m.a.SYNC_CALL).get(j10, timeUnit);
        } catch (InterruptedException unused) {
            str = f36082a;
            str2 = "call InterruptedException";
            AbstractC7185ho.m43823c(str, str2);
            return result;
        } catch (ExecutionException unused2) {
            str = f36082a;
            str2 = "call ExecutionException";
            AbstractC7185ho.m43823c(str, str2);
            return result;
        } catch (TimeoutException unused3) {
            str = f36082a;
            str2 = "call TimeoutException";
            AbstractC7185ho.m43823c(str, str2);
            return result;
        }
    }

    /* renamed from: a */
    public static <RESULT> Future<RESULT> m48271a(Callable<RESULT> callable) {
        if (callable == null) {
            return null;
        }
        return AbstractC7834m.m48477a(callable, AbstractC7834m.a.SYNC_CALL);
    }
}
