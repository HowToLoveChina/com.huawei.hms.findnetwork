package com.huawei.remoteLoader.client;

import android.annotation.TargetApi;
import java.util.Objects;

@TargetApi(19)
/* renamed from: com.huawei.remoteLoader.client.a */
/* loaded from: classes5.dex */
public class C8675a {

    /* renamed from: a */
    public final String f40457a;

    /* renamed from: b */
    public final String f40458b;

    public C8675a(String str, String str2) {
        this.f40457a = str;
        this.f40458b = str2;
    }

    /* renamed from: a */
    public String m53563a() {
        return this.f40458b;
    }

    /* renamed from: b */
    public String m53564b() {
        return this.f40457a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C8675a)) {
            return false;
        }
        C8675a c8675a = (C8675a) obj;
        return Objects.equals(this.f40457a, c8675a.f40457a) && Objects.equals(this.f40458b, c8675a.f40458b);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f40457a) * 37) + Objects.hashCode(this.f40458b);
    }

    public String toString() {
        return "[Library name = " + m53563a() + ", Package name = [ " + m53564b() + " ]";
    }
}
