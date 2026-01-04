package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.constraintlayout.widget.f */
/* loaded from: classes.dex */
public class C0588f {

    /* renamed from: a */
    public int f3232a = -1;

    /* renamed from: b */
    public int f3233b = -1;

    /* renamed from: c */
    public int f3234c = -1;

    /* renamed from: d */
    public SparseArray<a> f3235d = new SparseArray<>();

    /* renamed from: androidx.constraintlayout.widget.f$a */
    public static class a {

        /* renamed from: a */
        public int f3236a;

        /* renamed from: b */
        public ArrayList<b> f3237b = new ArrayList<>();

        /* renamed from: c */
        public int f3238c;

        /* renamed from: d */
        public boolean f3239d;

        public a(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f3238c = -1;
            this.f3239d = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.State_android_id) {
                    this.f3236a = typedArrayObtainStyledAttributes.getResourceId(index, this.f3236a);
                } else if (index == R$styleable.State_constraints) {
                    this.f3238c = typedArrayObtainStyledAttributes.getResourceId(index, this.f3238c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f3238c);
                    context.getResources().getResourceName(this.f3238c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f3239d = true;
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public void m3676a(b bVar) {
            this.f3237b.add(bVar);
        }

        /* renamed from: b */
        public int m3677b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f3237b.size(); i10++) {
                if (this.f3237b.get(i10).m3678a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.f$b */
    public static class b {

        /* renamed from: a */
        public float f3240a;

        /* renamed from: b */
        public float f3241b;

        /* renamed from: c */
        public float f3242c;

        /* renamed from: d */
        public float f3243d;

        /* renamed from: e */
        public int f3244e;

        /* renamed from: f */
        public boolean f3245f;

        public b(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f3240a = Float.NaN;
            this.f3241b = Float.NaN;
            this.f3242c = Float.NaN;
            this.f3243d = Float.NaN;
            this.f3244e = -1;
            this.f3245f = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.Variant_constraints) {
                    this.f3244e = typedArrayObtainStyledAttributes.getResourceId(index, this.f3244e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f3244e);
                    context.getResources().getResourceName(this.f3244e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f3245f = true;
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f3243d = typedArrayObtainStyledAttributes.getDimension(index, this.f3243d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.f3241b = typedArrayObtainStyledAttributes.getDimension(index, this.f3241b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.f3242c = typedArrayObtainStyledAttributes.getDimension(index, this.f3242c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.f3240a = typedArrayObtainStyledAttributes.getDimension(index, this.f3240a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public boolean m3678a(float f10, float f11) {
            if (!Float.isNaN(this.f3240a) && f10 < this.f3240a) {
                return false;
            }
            if (!Float.isNaN(this.f3241b) && f11 < this.f3241b) {
                return false;
            }
            if (Float.isNaN(this.f3242c) || f10 <= this.f3242c) {
                return Float.isNaN(this.f3243d) || f11 <= this.f3243d;
            }
            return false;
        }
    }

    public C0588f(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        m3673b(context, xmlPullParser);
    }

    /* renamed from: a */
    public int m3672a(int i10, int i11, float f10, float f11) {
        a aVar = this.f3235d.get(i11);
        if (aVar == null) {
            return i11;
        }
        if (f10 == -1.0f || f11 == -1.0f) {
            if (aVar.f3238c == i10) {
                return i10;
            }
            Iterator<b> it = aVar.f3237b.iterator();
            while (it.hasNext()) {
                if (i10 == it.next().f3244e) {
                    return i10;
                }
            }
            return aVar.f3238c;
        }
        Iterator<b> it2 = aVar.f3237b.iterator();
        b bVar = null;
        while (it2.hasNext()) {
            b next = it2.next();
            if (next.m3678a(f10, f11)) {
                if (i10 == next.f3244e) {
                    return i10;
                }
                bVar = next;
            }
        }
        return bVar != null ? bVar.f3244e : aVar.f3238c;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007e  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3673b(android.content.Context r11, org.xmlpull.v1.XmlPullParser r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "Error parsing XML resource"
            java.lang.String r1 = "ConstraintLayoutStates"
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r12)
            int[] r3 = androidx.constraintlayout.widget.R$styleable.StateSet
            android.content.res.TypedArray r2 = r11.obtainStyledAttributes(r2, r3)
            int r3 = r2.getIndexCount()
            r4 = 0
            r5 = r4
        L14:
            if (r5 >= r3) goto L29
            int r6 = r2.getIndex(r5)
            int r7 = androidx.constraintlayout.widget.R$styleable.StateSet_defaultState
            if (r6 != r7) goto L26
            int r7 = r10.f3232a
            int r6 = r2.getResourceId(r6, r7)
            r10.f3232a = r6
        L26:
            int r5 = r5 + 1
            goto L14
        L29:
            r2.recycle()
            int r2 = r12.getEventType()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r3 = 0
        L31:
            r5 = 1
            if (r2 == r5) goto La7
            java.lang.String r6 = "StateSet"
            r7 = 3
            r8 = 2
            if (r2 == r8) goto L4d
            if (r2 == r7) goto L3e
            goto L9b
        L3e:
            java.lang.String r2 = r12.getName()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            boolean r2 = r6.equals(r2)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r2 == 0) goto L9b
            return
        L49:
            r10 = move-exception
            goto La0
        L4b:
            r10 = move-exception
            goto La4
        L4d:
            java.lang.String r2 = r12.getName()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            int r9 = r2.hashCode()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            switch(r9) {
                case 80204913: goto L74;
                case 1301459538: goto L6a;
                case 1382829617: goto L63;
                case 1901439077: goto L59;
                default: goto L58;
            }     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
        L58:
            goto L7e
        L59:
            java.lang.String r5 = "Variant"
            boolean r2 = r2.equals(r5)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r2 == 0) goto L7e
            r5 = r7
            goto L7f
        L63:
            boolean r2 = r2.equals(r6)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r2 == 0) goto L7e
            goto L7f
        L6a:
            java.lang.String r5 = "LayoutDescription"
            boolean r2 = r2.equals(r5)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r2 == 0) goto L7e
            r5 = r4
            goto L7f
        L74:
            java.lang.String r5 = "State"
            boolean r2 = r2.equals(r5)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r2 == 0) goto L7e
            r5 = r8
            goto L7f
        L7e:
            r5 = -1
        L7f:
            if (r5 == r8) goto L8f
            if (r5 == r7) goto L84
            goto L9b
        L84:
            androidx.constraintlayout.widget.f$b r2 = new androidx.constraintlayout.widget.f$b     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r2.<init>(r11, r12)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r3 == 0) goto L9b
            r3.m3676a(r2)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            goto L9b
        L8f:
            androidx.constraintlayout.widget.f$a r3 = new androidx.constraintlayout.widget.f$a     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r3.<init>(r11, r12)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            android.util.SparseArray<androidx.constraintlayout.widget.f$a> r2 = r10.f3235d     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            int r5 = r3.f3236a     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r2.put(r5, r3)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
        L9b:
            int r2 = r12.next()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            goto L31
        La0:
            android.util.Log.e(r1, r0, r10)
            goto La7
        La4:
            android.util.Log.e(r1, r0, r10)
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.C0588f.m3673b(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* renamed from: c */
    public int m3674c(int i10, int i11, int i12) {
        return m3675d(-1, i10, i11, i12);
    }

    /* renamed from: d */
    public int m3675d(int i10, int i11, float f10, float f11) {
        int iM3677b;
        if (i10 == i11) {
            a aVarValueAt = i11 == -1 ? this.f3235d.valueAt(0) : this.f3235d.get(this.f3233b);
            if (aVarValueAt == null) {
                return -1;
            }
            return ((this.f3234c == -1 || !aVarValueAt.f3237b.get(i10).m3678a(f10, f11)) && i10 != (iM3677b = aVarValueAt.m3677b(f10, f11))) ? iM3677b == -1 ? aVarValueAt.f3238c : aVarValueAt.f3237b.get(iM3677b).f3244e : i10;
        }
        a aVar = this.f3235d.get(i11);
        if (aVar == null) {
            return -1;
        }
        int iM3677b2 = aVar.m3677b(f10, f11);
        return iM3677b2 == -1 ? aVar.f3238c : aVar.f3237b.get(iM3677b2).f3244e;
    }
}
