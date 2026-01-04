package p770xc;

import android.content.SharedPreferences;
import android.os.Message;
import md.C11439b;
import p015ak.C0214f0;

/* renamed from: xc.k */
/* loaded from: classes3.dex */
public abstract class AbstractC13748k extends C11439b<Boolean> {

    /* renamed from: p */
    public SharedPreferences f61810p;

    /* renamed from: q */
    public String f61811q;

    @Override // md.AbstractC11438a
    /* renamed from: h */
    public void mo66491h() {
        super.mo66491h();
        this.f61810p = C0214f0.m1382b(this.f53282a, "sync_contact_spfile", 0);
    }

    @Override // md.C11439b
    /* renamed from: r */
    public boolean mo66493r(Message message) {
        super.mo66493r(message);
        return false;
    }
}
