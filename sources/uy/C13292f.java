package uy;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/* renamed from: uy.f */
/* loaded from: classes9.dex */
public class C13292f extends Permission {

    /* renamed from: a */
    public final Set<String> f60016a;

    public C13292f(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.f60016a = hashSet;
        hashSet.add(str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C13292f) && this.f60016a.equals(((C13292f) obj).f60016a);
    }

    @Override // java.security.Permission
    public String getActions() {
        return this.f60016a.toString();
    }

    public int hashCode() {
        return this.f60016a.hashCode();
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof C13292f)) {
            return false;
        }
        C13292f c13292f = (C13292f) permission;
        return getName().equals(c13292f.getName()) || this.f60016a.containsAll(c13292f.f60016a);
    }
}
