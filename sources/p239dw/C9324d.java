package p239dw;

import android.text.TextUtils;
import p857zv.C14389c;

@Deprecated
/* renamed from: dw.d */
/* loaded from: classes9.dex */
public class C9324d {

    /* renamed from: a */
    public String f46698a;

    /* renamed from: b */
    public String f46699b;

    /* renamed from: c */
    public String f46700c;

    /* renamed from: a */
    public String m58661a() throws C14389c {
        if (TextUtils.isEmpty(this.f46698a) || TextUtils.isEmpty(this.f46699b) || TextUtils.isEmpty(this.f46700c)) {
            throw new C14389c(2001L, "get  AppAuthtication JWS is empty...");
        }
        return m58662b() + "." + this.f46700c;
    }

    /* renamed from: b */
    public String m58662b() throws C14389c {
        if (TextUtils.isEmpty(this.f46698a) || TextUtils.isEmpty(this.f46699b)) {
            throw new C14389c(2001L, "Get AppAuthtication signStr error");
        }
        return this.f46698a + "." + this.f46699b;
    }
}
