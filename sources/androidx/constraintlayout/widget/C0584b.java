package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.constraintlayout.widget.b */
/* loaded from: classes.dex */
public class C0584b {

    /* renamed from: a */
    public final ConstraintLayout f3078a;

    /* renamed from: b */
    public C0585c f3079b;

    /* renamed from: c */
    public int f3080c = -1;

    /* renamed from: d */
    public int f3081d = -1;

    /* renamed from: e */
    public SparseArray<a> f3082e = new SparseArray<>();

    /* renamed from: f */
    public SparseArray<C0585c> f3083f = new SparseArray<>();

    /* renamed from: androidx.constraintlayout.widget.b$a */
    public static class a {

        /* renamed from: a */
        public int f3084a;

        /* renamed from: b */
        public ArrayList<b> f3085b = new ArrayList<>();

        /* renamed from: c */
        public int f3086c;

        /* renamed from: d */
        public C0585c f3087d;

        public a(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f3086c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.State_android_id) {
                    this.f3084a = typedArrayObtainStyledAttributes.getResourceId(index, this.f3084a);
                } else if (index == R$styleable.State_constraints) {
                    this.f3086c = typedArrayObtainStyledAttributes.getResourceId(index, this.f3086c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f3086c);
                    context.getResources().getResourceName(this.f3086c);
                    if ("layout".equals(resourceTypeName)) {
                        C0585c c0585c = new C0585c();
                        this.f3087d = c0585c;
                        c0585c.m3636o(context, this.f3086c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public void m3599a(b bVar) {
            this.f3085b.add(bVar);
        }

        /* renamed from: b */
        public int m3600b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f3085b.size(); i10++) {
                if (this.f3085b.get(i10).m3601a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.b$b */
    public static class b {

        /* renamed from: a */
        public float f3088a;

        /* renamed from: b */
        public float f3089b;

        /* renamed from: c */
        public float f3090c;

        /* renamed from: d */
        public float f3091d;

        /* renamed from: e */
        public int f3092e;

        /* renamed from: f */
        public C0585c f3093f;

        public b(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f3088a = Float.NaN;
            this.f3089b = Float.NaN;
            this.f3090c = Float.NaN;
            this.f3091d = Float.NaN;
            this.f3092e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.Variant_constraints) {
                    this.f3092e = typedArrayObtainStyledAttributes.getResourceId(index, this.f3092e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f3092e);
                    context.getResources().getResourceName(this.f3092e);
                    if ("layout".equals(resourceTypeName)) {
                        C0585c c0585c = new C0585c();
                        this.f3093f = c0585c;
                        c0585c.m3636o(context, this.f3092e);
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f3091d = typedArrayObtainStyledAttributes.getDimension(index, this.f3091d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.f3089b = typedArrayObtainStyledAttributes.getDimension(index, this.f3089b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.f3090c = typedArrayObtainStyledAttributes.getDimension(index, this.f3090c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.f3088a = typedArrayObtainStyledAttributes.getDimension(index, this.f3088a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public boolean m3601a(float f10, float f11) {
            if (!Float.isNaN(this.f3088a) && f10 < this.f3088a) {
                return false;
            }
            if (!Float.isNaN(this.f3089b) && f11 < this.f3089b) {
                return false;
            }
            if (Float.isNaN(this.f3090c) || f10 <= this.f3090c) {
                return Float.isNaN(this.f3091d) || f11 <= this.f3091d;
            }
            return false;
        }
    }

    public C0584b(Context context, ConstraintLayout constraintLayout, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        this.f3078a = constraintLayout;
        m3595a(context, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x005d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3595a(android.content.Context r11, int r12) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            r10 = this;
            java.lang.String r0 = "Error parsing resource: "
            java.lang.String r1 = "ConstraintLayoutStates"
            android.content.res.Resources r2 = r11.getResources()
            android.content.res.XmlResourceParser r2 = r2.getXml(r12)
            int r3 = r2.getEventType()     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r4 = 0
        L11:
            r5 = 1
            if (r3 == r5) goto Lab
            r6 = 2
            if (r3 == r6) goto L19
            goto L81
        L19:
            java.lang.String r3 = r2.getName()     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            int r7 = r3.hashCode()     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r8 = 4
            r9 = 3
            switch(r7) {
                case -1349929691: goto L53;
                case 80204913: goto L49;
                case 1382829617: goto L40;
                case 1657696882: goto L36;
                case 1901439077: goto L27;
                default: goto L26;
            }     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
        L26:
            goto L5d
        L27:
            java.lang.String r5 = "Variant"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r3 == 0) goto L5d
            r5 = r9
            goto L5e
        L31:
            r10 = move-exception
            goto L86
        L33:
            r10 = move-exception
            goto L99
        L36:
            java.lang.String r5 = "layoutDescription"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r3 == 0) goto L5d
            r5 = 0
            goto L5e
        L40:
            java.lang.String r7 = "StateSet"
            boolean r3 = r3.equals(r7)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r3 == 0) goto L5d
            goto L5e
        L49:
            java.lang.String r5 = "State"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r3 == 0) goto L5d
            r5 = r6
            goto L5e
        L53:
            java.lang.String r5 = "ConstraintSet"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r3 == 0) goto L5d
            r5 = r8
            goto L5e
        L5d:
            r5 = -1
        L5e:
            if (r5 == r6) goto L74
            if (r5 == r9) goto L69
            if (r5 == r8) goto L65
            goto L81
        L65:
            r10.m3596b(r11, r2)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            goto L81
        L69:
            androidx.constraintlayout.widget.b$b r3 = new androidx.constraintlayout.widget.b$b     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r3.<init>(r11, r2)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r4 == 0) goto L81
            r4.m3599a(r3)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            goto L81
        L74:
            androidx.constraintlayout.widget.b$a r3 = new androidx.constraintlayout.widget.b$a     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r3.<init>(r11, r2)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            android.util.SparseArray<androidx.constraintlayout.widget.b$a> r4 = r10.f3082e     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            int r5 = r3.f3084a     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r4.put(r5, r3)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r4 = r3
        L81:
            int r3 = r2.next()     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            goto L11
        L86:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            android.util.Log.e(r1, r11, r10)
            goto Lab
        L99:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            android.util.Log.e(r1, r11, r10)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.C0584b.m3595a(android.content.Context, int):void");
    }

    /* renamed from: b */
    public final void m3596b(Context context, XmlPullParser xmlPullParser) throws NumberFormatException {
        C0585c c0585c = new C0585c();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            String attributeValue = xmlPullParser.getAttributeValue(i10);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                c0585c.m3622E(context, xmlPullParser);
                this.f3083f.put(identifier, c0585c);
                return;
            }
        }
    }

    /* renamed from: c */
    public void m3597c(AbstractC0586d abstractC0586d) {
    }

    /* renamed from: d */
    public void m3598d(int i10, float f10, float f11) {
        int iM3600b;
        int i11 = this.f3080c;
        if (i11 == i10) {
            a aVarValueAt = i10 == -1 ? this.f3082e.valueAt(0) : this.f3082e.get(i11);
            int i12 = this.f3081d;
            if ((i12 == -1 || !aVarValueAt.f3085b.get(i12).m3601a(f10, f11)) && this.f3081d != (iM3600b = aVarValueAt.m3600b(f10, f11))) {
                C0585c c0585c = iM3600b == -1 ? this.f3079b : aVarValueAt.f3085b.get(iM3600b).f3093f;
                if (iM3600b != -1) {
                    int i13 = aVarValueAt.f3085b.get(iM3600b).f3092e;
                }
                if (c0585c == null) {
                    return;
                }
                this.f3081d = iM3600b;
                c0585c.m3631i(this.f3078a);
                return;
            }
            return;
        }
        this.f3080c = i10;
        a aVar = this.f3082e.get(i10);
        int iM3600b2 = aVar.m3600b(f10, f11);
        C0585c c0585c2 = iM3600b2 == -1 ? aVar.f3087d : aVar.f3085b.get(iM3600b2).f3093f;
        if (iM3600b2 != -1) {
            int i14 = aVar.f3085b.get(iM3600b2).f3092e;
        }
        if (c0585c2 != null) {
            this.f3081d = iM3600b2;
            c0585c2.m3631i(this.f3078a);
            return;
        }
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i10 + ", dim =" + f10 + ", " + f11);
    }
}
