package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.C1710b;
import p045c3.C1382a;

/* renamed from: com.google.android.material.circularreveal.c */
/* loaded from: classes.dex */
public interface InterfaceC1711c extends C1710b.a {

    /* renamed from: com.google.android.material.circularreveal.c$b */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b */
        public static final TypeEvaluator<e> f7864b = new b();

        /* renamed from: a */
        public final e f7865a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f10, e eVar, e eVar2) {
            this.f7865a.m10202b(C1382a.m7932d(eVar.f7868a, eVar2.f7868a, f10), C1382a.m7932d(eVar.f7869b, eVar2.f7869b, f10), C1382a.m7932d(eVar.f7870c, eVar2.f7870c, f10));
            return this.f7865a;
        }
    }

    /* renamed from: com.google.android.material.circularreveal.c$c */
    public static class c extends Property<InterfaceC1711c, e> {

        /* renamed from: a */
        public static final Property<InterfaceC1711c, e> f7866a = new c("circularReveal");

        public c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(InterfaceC1711c interfaceC1711c) {
            return interfaceC1711c.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(InterfaceC1711c interfaceC1711c, e eVar) {
            interfaceC1711c.setRevealInfo(eVar);
        }
    }

    /* renamed from: com.google.android.material.circularreveal.c$d */
    public static class d extends Property<InterfaceC1711c, Integer> {

        /* renamed from: a */
        public static final Property<InterfaceC1711c, Integer> f7867a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(InterfaceC1711c interfaceC1711c) {
            return Integer.valueOf(interfaceC1711c.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(InterfaceC1711c interfaceC1711c, Integer num) {
            interfaceC1711c.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* renamed from: com.google.android.material.circularreveal.c$e */
    public static class e {

        /* renamed from: a */
        public float f7868a;

        /* renamed from: b */
        public float f7869b;

        /* renamed from: c */
        public float f7870c;

        /* renamed from: a */
        public boolean m10201a() {
            return this.f7870c == Float.MAX_VALUE;
        }

        /* renamed from: b */
        public void m10202b(float f10, float f11, float f12) {
            this.f7868a = f10;
            this.f7869b = f11;
            this.f7870c = f12;
        }

        /* renamed from: c */
        public void m10203c(e eVar) {
            m10202b(eVar.f7868a, eVar.f7869b, eVar.f7870c);
        }

        public e() {
        }

        public e(float f10, float f11, float f12) {
            this.f7868a = f10;
            this.f7869b = f11;
            this.f7870c = f12;
        }

        public e(e eVar) {
            this(eVar.f7868a, eVar.f7869b, eVar.f7870c);
        }
    }

    /* renamed from: a */
    void mo10174a();

    /* renamed from: b */
    void mo10175b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i10);

    void setRevealInfo(e eVar);
}
