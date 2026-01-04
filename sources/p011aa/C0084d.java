package p011aa;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12369f;

/* renamed from: aa.d */
/* loaded from: classes3.dex */
public class C0084d extends AbstractC12369f {
    public C0084d(long j10, long j11) {
        super(j10, j11);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> clsLoadClass;
        Object objInvoke;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            if (classLoader == null || (clsLoadClass = classLoader.loadClass("com.huawei.hidisk.cloud.presenter.manager.HiDiskPowerKitManager")) == null || (objInvoke = clsLoadClass.getMethod("getInstance", Context.class).invoke(clsLoadClass, C0213f.m1377a())) == null) {
                return;
            }
            objInvoke.getClass().getMethod("apply", String.class).invoke(objInvoke, "com.huawei.hidisk");
            C11839m.m70688i("KeepPowerKitTimer", "acquire powerKit success");
        } catch (Exception e10) {
            C11839m.m70687e("KeepPowerKitTimer", "acquire powerKitFail, " + e10.getMessage());
        }
    }
}
