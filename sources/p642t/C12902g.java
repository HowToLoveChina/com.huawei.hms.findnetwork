package p642t;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: t.g */
/* loaded from: classes.dex */
public class C12902g {

    /* renamed from: b */
    public static HashMap<String, Constructor<? extends AbstractC12899d>> f58733b;

    /* renamed from: a */
    public HashMap<Integer, ArrayList<AbstractC12899d>> f58734a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends AbstractC12899d>> map = new HashMap<>();
        f58733b = map;
        try {
            map.put("KeyAttribute", C12900e.class.getConstructor(new Class[0]));
            f58733b.put("KeyPosition", C12903h.class.getConstructor(new Class[0]));
            f58733b.put("KeyCycle", C12901f.class.getConstructor(new Class[0]));
            f58733b.put("KeyTimeCycle", C12905j.class.getConstructor(new Class[0]));
            f58733b.put("KeyTrigger", C12906k.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e10) {
            Log.e("KeyFrames", "unable to load", e10);
        }
    }

    public C12902g() {
    }

    /* renamed from: a */
    public void m77409a(C12908m c12908m) {
        ArrayList<AbstractC12899d> arrayList = this.f58734a.get(-1);
        if (arrayList != null) {
            c12908m.m77492b(arrayList);
        }
    }

    /* renamed from: b */
    public void m77410b(C12908m c12908m) {
        ArrayList<AbstractC12899d> arrayList = this.f58734a.get(Integer.valueOf(c12908m.f58834c));
        if (arrayList != null) {
            c12908m.m77492b(arrayList);
        }
        ArrayList<AbstractC12899d> arrayList2 = this.f58734a.get(-1);
        if (arrayList2 != null) {
            Iterator<AbstractC12899d> it = arrayList2.iterator();
            while (it.hasNext()) {
                AbstractC12899d next = it.next();
                if (next.m77327f(((ConstraintLayout.LayoutParams) c12908m.f58833b.getLayoutParams()).f2981c0)) {
                    c12908m.m77491a(next);
                }
            }
        }
    }

    /* renamed from: c */
    public void m77411c(AbstractC12899d abstractC12899d) {
        if (!this.f58734a.containsKey(Integer.valueOf(abstractC12899d.f58690b))) {
            this.f58734a.put(Integer.valueOf(abstractC12899d.f58690b), new ArrayList<>());
        }
        ArrayList<AbstractC12899d> arrayList = this.f58734a.get(Integer.valueOf(abstractC12899d.f58690b));
        if (arrayList != null) {
            arrayList.add(abstractC12899d);
        }
    }

    /* renamed from: d */
    public ArrayList<AbstractC12899d> m77412d(int i10) {
        return this.f58734a.get(Integer.valueOf(i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C12902g(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p642t.C12902g.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
