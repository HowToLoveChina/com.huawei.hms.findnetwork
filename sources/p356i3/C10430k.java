package p356i3;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: i3.k */
/* loaded from: classes.dex */
public final class C10430k implements InterfaceC10422c {

    /* renamed from: a */
    public final float f50310a;

    public C10430k(float f10) {
        this.f50310a = f10;
    }

    @Override // p356i3.InterfaceC10422c
    /* renamed from: a */
    public float mo63966a(RectF rectF) {
        return this.f50310a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C10430k) && this.f50310a == ((C10430k) obj).f50310a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f50310a)});
    }
}
