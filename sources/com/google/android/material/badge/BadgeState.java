package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.R$dimen;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;
import p276f3.C9649c;
import p276f3.C9650d;
import p830z2.C14088a;

/* loaded from: classes.dex */
public final class BadgeState {

    /* renamed from: a */
    public final State f7456a;

    /* renamed from: b */
    public final State f7457b;

    /* renamed from: c */
    public final float f7458c;

    /* renamed from: d */
    public final float f7459d;

    /* renamed from: e */
    public final float f7460e;

    public BadgeState(Context context, int i10, int i11, int i12, State state) throws XmlPullParserException, Resources.NotFoundException, IOException {
        State state2 = new State();
        this.f7457b = state2;
        state = state == null ? new State() : state;
        if (i10 != 0) {
            state.f7461a = i10;
        }
        TypedArray typedArrayM9610a = m9610a(context, state.f7461a, i11, i12);
        Resources resources = context.getResources();
        this.f7458c = typedArrayM9610a.getDimensionPixelSize(R$styleable.Badge_badgeRadius, resources.getDimensionPixelSize(R$dimen.mtrl_badge_radius));
        this.f7460e = typedArrayM9610a.getDimensionPixelSize(R$styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding));
        this.f7459d = typedArrayM9610a.getDimensionPixelSize(R$styleable.Badge_badgeWithTextRadius, resources.getDimensionPixelSize(R$dimen.mtrl_badge_with_text_radius));
        state2.f7464d = state.f7464d == -2 ? HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA : state.f7464d;
        state2.f7468h = state.f7468h == null ? context.getString(R$string.mtrl_badge_numberless_content_description) : state.f7468h;
        state2.f7469i = state.f7469i == 0 ? R$plurals.mtrl_badge_content_description : state.f7469i;
        state2.f7470j = state.f7470j == 0 ? R$string.mtrl_exceed_max_badge_number_content_description : state.f7470j;
        state2.f7472l = Boolean.valueOf(state.f7472l == null || state.f7472l.booleanValue());
        state2.f7466f = state.f7466f == -2 ? typedArrayM9610a.getInt(R$styleable.Badge_maxCharacterCount, 4) : state.f7466f;
        if (state.f7465e != -2) {
            state2.f7465e = state.f7465e;
        } else {
            int i13 = R$styleable.Badge_number;
            if (typedArrayM9610a.hasValue(i13)) {
                state2.f7465e = typedArrayM9610a.getInt(i13, 0);
            } else {
                state2.f7465e = -1;
            }
        }
        state2.f7462b = Integer.valueOf(state.f7462b == null ? m9609u(context, typedArrayM9610a, R$styleable.Badge_backgroundColor) : state.f7462b.intValue());
        if (state.f7463c != null) {
            state2.f7463c = state.f7463c;
        } else {
            int i14 = R$styleable.Badge_badgeTextColor;
            if (typedArrayM9610a.hasValue(i14)) {
                state2.f7463c = Integer.valueOf(m9609u(context, typedArrayM9610a, i14));
            } else {
                state2.f7463c = Integer.valueOf(new C9650d(context, R$style.TextAppearance_MaterialComponents_Badge).m60283i().getDefaultColor());
            }
        }
        state2.f7471k = Integer.valueOf(state.f7471k == null ? typedArrayM9610a.getInt(R$styleable.Badge_badgeGravity, 8388661) : state.f7471k.intValue());
        state2.f7473m = Integer.valueOf(state.f7473m == null ? typedArrayM9610a.getDimensionPixelOffset(R$styleable.Badge_horizontalOffset, 0) : state.f7473m.intValue());
        state2.f7474n = Integer.valueOf(state.f7473m == null ? typedArrayM9610a.getDimensionPixelOffset(R$styleable.Badge_verticalOffset, 0) : state.f7474n.intValue());
        state2.f7475o = Integer.valueOf(state.f7475o == null ? typedArrayM9610a.getDimensionPixelOffset(R$styleable.Badge_horizontalOffsetWithText, state2.f7473m.intValue()) : state.f7475o.intValue());
        state2.f7476p = Integer.valueOf(state.f7476p == null ? typedArrayM9610a.getDimensionPixelOffset(R$styleable.Badge_verticalOffsetWithText, state2.f7474n.intValue()) : state.f7476p.intValue());
        state2.f7477q = Integer.valueOf(state.f7477q == null ? 0 : state.f7477q.intValue());
        state2.f7478r = Integer.valueOf(state.f7478r != null ? state.f7478r.intValue() : 0);
        typedArrayM9610a.recycle();
        if (state.f7467g == null) {
            state2.f7467g = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            state2.f7467g = state.f7467g;
        }
        this.f7456a = state;
    }

    /* renamed from: u */
    public static int m9609u(Context context, TypedArray typedArray, int i10) {
        return C9649c.m60265a(context, typedArray, i10).getDefaultColor();
    }

    /* renamed from: a */
    public final TypedArray m9610a(Context context, int i10, int i11, int i12) throws XmlPullParserException, Resources.NotFoundException, IOException {
        AttributeSet attributeSetM84430a;
        int styleAttribute;
        if (i10 != 0) {
            attributeSetM84430a = C14088a.m84430a(context, i10, "badge");
            styleAttribute = attributeSetM84430a.getStyleAttribute();
        } else {
            attributeSetM84430a = null;
            styleAttribute = 0;
        }
        return C1784o.m10770h(context, attributeSetM84430a, R$styleable.Badge, i11, styleAttribute == 0 ? i12 : styleAttribute, new int[0]);
    }

    /* renamed from: b */
    public int m9611b() {
        return this.f7457b.f7477q.intValue();
    }

    /* renamed from: c */
    public int m9612c() {
        return this.f7457b.f7478r.intValue();
    }

    /* renamed from: d */
    public int m9613d() {
        return this.f7457b.f7464d;
    }

    /* renamed from: e */
    public int m9614e() {
        return this.f7457b.f7462b.intValue();
    }

    /* renamed from: f */
    public int m9615f() {
        return this.f7457b.f7471k.intValue();
    }

    /* renamed from: g */
    public int m9616g() {
        return this.f7457b.f7463c.intValue();
    }

    /* renamed from: h */
    public int m9617h() {
        return this.f7457b.f7470j;
    }

    /* renamed from: i */
    public CharSequence m9618i() {
        return this.f7457b.f7468h;
    }

    /* renamed from: j */
    public int m9619j() {
        return this.f7457b.f7469i;
    }

    /* renamed from: k */
    public int m9620k() {
        return this.f7457b.f7475o.intValue();
    }

    /* renamed from: l */
    public int m9621l() {
        return this.f7457b.f7473m.intValue();
    }

    /* renamed from: m */
    public int m9622m() {
        return this.f7457b.f7466f;
    }

    /* renamed from: n */
    public int m9623n() {
        return this.f7457b.f7465e;
    }

    /* renamed from: o */
    public Locale m9624o() {
        return this.f7457b.f7467g;
    }

    /* renamed from: p */
    public State m9625p() {
        return this.f7456a;
    }

    /* renamed from: q */
    public int m9626q() {
        return this.f7457b.f7476p.intValue();
    }

    /* renamed from: r */
    public int m9627r() {
        return this.f7457b.f7474n.intValue();
    }

    /* renamed from: s */
    public boolean m9628s() {
        return this.f7457b.f7465e != -1;
    }

    /* renamed from: t */
    public boolean m9629t() {
        return this.f7457b.f7472l.booleanValue();
    }

    /* renamed from: v */
    public void m9630v(int i10) {
        this.f7456a.f7464d = i10;
        this.f7457b.f7464d = i10;
    }

    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new C1651a();

        /* renamed from: a */
        public int f7461a;

        /* renamed from: b */
        public Integer f7462b;

        /* renamed from: c */
        public Integer f7463c;

        /* renamed from: d */
        public int f7464d;

        /* renamed from: e */
        public int f7465e;

        /* renamed from: f */
        public int f7466f;

        /* renamed from: g */
        public Locale f7467g;

        /* renamed from: h */
        public CharSequence f7468h;

        /* renamed from: i */
        public int f7469i;

        /* renamed from: j */
        public int f7470j;

        /* renamed from: k */
        public Integer f7471k;

        /* renamed from: l */
        public Boolean f7472l;

        /* renamed from: m */
        public Integer f7473m;

        /* renamed from: n */
        public Integer f7474n;

        /* renamed from: o */
        public Integer f7475o;

        /* renamed from: p */
        public Integer f7476p;

        /* renamed from: q */
        public Integer f7477q;

        /* renamed from: r */
        public Integer f7478r;

        /* renamed from: com.google.android.material.badge.BadgeState$State$a */
        public class C1651a implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public State[] newArray(int i10) {
                return new State[i10];
            }
        }

        public State() {
            this.f7464d = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
            this.f7465e = -2;
            this.f7466f = -2;
            this.f7472l = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f7461a);
            parcel.writeSerializable(this.f7462b);
            parcel.writeSerializable(this.f7463c);
            parcel.writeInt(this.f7464d);
            parcel.writeInt(this.f7465e);
            parcel.writeInt(this.f7466f);
            CharSequence charSequence = this.f7468h;
            parcel.writeString(charSequence == null ? null : charSequence.toString());
            parcel.writeInt(this.f7469i);
            parcel.writeSerializable(this.f7471k);
            parcel.writeSerializable(this.f7473m);
            parcel.writeSerializable(this.f7474n);
            parcel.writeSerializable(this.f7475o);
            parcel.writeSerializable(this.f7476p);
            parcel.writeSerializable(this.f7477q);
            parcel.writeSerializable(this.f7478r);
            parcel.writeSerializable(this.f7472l);
            parcel.writeSerializable(this.f7467g);
        }

        public State(Parcel parcel) {
            this.f7464d = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
            this.f7465e = -2;
            this.f7466f = -2;
            this.f7472l = Boolean.TRUE;
            this.f7461a = parcel.readInt();
            this.f7462b = (Integer) parcel.readSerializable();
            this.f7463c = (Integer) parcel.readSerializable();
            this.f7464d = parcel.readInt();
            this.f7465e = parcel.readInt();
            this.f7466f = parcel.readInt();
            this.f7468h = parcel.readString();
            this.f7469i = parcel.readInt();
            this.f7471k = (Integer) parcel.readSerializable();
            this.f7473m = (Integer) parcel.readSerializable();
            this.f7474n = (Integer) parcel.readSerializable();
            this.f7475o = (Integer) parcel.readSerializable();
            this.f7476p = (Integer) parcel.readSerializable();
            this.f7477q = (Integer) parcel.readSerializable();
            this.f7478r = (Integer) parcel.readSerializable();
            this.f7472l = (Boolean) parcel.readSerializable();
            this.f7467g = (Locale) parcel.readSerializable();
        }
    }
}
