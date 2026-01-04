package p625rx;

import android.content.Context;
import android.content.Intent;
import java.lang.reflect.InvocationTargetException;
import ohos.ohos.ohos.ohos.ohos.C11891f;

/* renamed from: rx.d */
/* loaded from: classes9.dex */
public class RunnableC12637d implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Intent f58087a;

    /* renamed from: b */
    public final /* synthetic */ Context f58088b;

    /* renamed from: c */
    public final /* synthetic */ int f58089c;

    /* renamed from: d */
    public final /* synthetic */ C11891f f58090d;

    public RunnableC12637d(C11891f c11891f, Intent intent, Context context, int i10) {
        this.f58090d = c11891f;
        this.f58087a = intent;
        this.f58088b = context;
        this.f58089c = i10;
    }

    @Override // java.lang.Runnable
    public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String strM76176d = C12646m.m76176d();
        if (strM76176d == null || "".equals(strM76176d) || strM76176d.equals("1.0")) {
            this.f58090d.m71423r(this.f58087a, this.f58088b, this.f58089c);
        } else {
            this.f58090d.m71415i(this.f58087a, this.f58088b, this.f58089c);
        }
    }
}
