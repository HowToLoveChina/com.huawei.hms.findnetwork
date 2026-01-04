package p356i3;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: i3.a */
/* loaded from: classes.dex */
public final class C10420a implements InterfaceC10422c {

    /* renamed from: a */
    public final float f50253a;

    public C10420a(float f10) {
        this.f50253a = f10;
    }

    @Override // p356i3.InterfaceC10422c
    /* renamed from: a */
    public float mo63966a(RectF rectF) {
        return this.f50253a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C10420a) && this.f50253a == ((C10420a) obj).f50253a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f50253a)});
    }
}
