package gy;

import java.util.Objects;

/* renamed from: gy.i */
/* loaded from: classes9.dex */
public final class C10070i {

    /* renamed from: a */
    public final long f49133a;

    /* renamed from: b */
    public final long f49134b;

    public C10070i(long j10, long j11) {
        if (j10 < 0) {
            throw new IllegalArgumentException("offset must not be negative");
        }
        if (j11 < 0) {
            throw new IllegalArgumentException("numbytes must not be negative");
        }
        this.f49133a = j10;
        this.f49134b = j11;
    }

    /* renamed from: a */
    public long m62664a() {
        return this.f49134b;
    }

    /* renamed from: b */
    public long m62665b() {
        return this.f49133a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C10070i.class != obj.getClass()) {
            return false;
        }
        C10070i c10070i = (C10070i) obj;
        return this.f49133a == c10070i.f49133a && this.f49134b == c10070i.f49134b;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f49133a), Long.valueOf(this.f49134b));
    }

    public String toString() {
        return "TarArchiveStructSparse{offset=" + this.f49133a + ", numbytes=" + this.f49134b + '}';
    }
}
