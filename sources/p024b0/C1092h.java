package p024b0;

import android.os.LocaleList;
import java.util.Locale;

/* renamed from: b0.h */
/* loaded from: classes.dex */
public final class C1092h implements InterfaceC1091g {

    /* renamed from: a */
    public final LocaleList f5212a;

    public C1092h(Object obj) {
        this.f5212a = (LocaleList) obj;
    }

    @Override // p024b0.InterfaceC1091g
    /* renamed from: a */
    public String mo6488a() {
        return this.f5212a.toLanguageTags();
    }

    @Override // p024b0.InterfaceC1091g
    /* renamed from: b */
    public Object mo6489b() {
        return this.f5212a;
    }

    public boolean equals(Object obj) {
        return this.f5212a.equals(((InterfaceC1091g) obj).mo6489b());
    }

    @Override // p024b0.InterfaceC1091g
    public Locale get(int i10) {
        return this.f5212a.get(i10);
    }

    public int hashCode() {
        return this.f5212a.hashCode();
    }

    @Override // p024b0.InterfaceC1091g
    public boolean isEmpty() {
        return this.f5212a.isEmpty();
    }

    @Override // p024b0.InterfaceC1091g
    public int size() {
        return this.f5212a.size();
    }

    public String toString() {
        return this.f5212a.toString();
    }
}
