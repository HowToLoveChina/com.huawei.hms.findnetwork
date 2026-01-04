package p356i3;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: i3.b */
/* loaded from: classes.dex */
public final class C10421b implements InterfaceC10422c {

    /* renamed from: a */
    public final InterfaceC10422c f50254a;

    /* renamed from: b */
    public final float f50255b;

    public C10421b(float f10, InterfaceC10422c interfaceC10422c) {
        while (interfaceC10422c instanceof C10421b) {
            interfaceC10422c = ((C10421b) interfaceC10422c).f50254a;
            f10 += ((C10421b) interfaceC10422c).f50255b;
        }
        this.f50254a = interfaceC10422c;
        this.f50255b = f10;
    }

    @Override // p356i3.InterfaceC10422c
    /* renamed from: a */
    public float mo63966a(RectF rectF) {
        return Math.max(0.0f, this.f50254a.mo63966a(rectF) + this.f50255b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10421b)) {
            return false;
        }
        C10421b c10421b = (C10421b) obj;
        return this.f50254a.equals(c10421b.f50254a) && this.f50255b == c10421b.f50255b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f50254a, Float.valueOf(this.f50255b)});
    }
}
