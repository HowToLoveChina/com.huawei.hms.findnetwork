package p509o4;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p417k4.AbstractC10982a;

/* renamed from: o4.a */
/* loaded from: classes.dex */
public class C11814a extends AbstractC10982a {

    /* renamed from: b */
    public static final List<AbstractC10982a.a> f54708b = new CopyOnWriteArrayList();

    /* renamed from: a */
    public static void m70374a() {
        Iterator<AbstractC10982a.a> it = f54708b.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }
}
