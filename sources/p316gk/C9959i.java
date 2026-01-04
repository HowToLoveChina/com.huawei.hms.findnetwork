package p316gk;

import java.util.Queue;

/* renamed from: gk.i */
/* loaded from: classes6.dex */
public class C9959i {

    /* renamed from: a */
    public final Queue<String> f48771a;

    /* renamed from: b */
    public String f48772b = null;

    public C9959i(Queue<String> queue) {
        this.f48771a = queue;
    }

    /* renamed from: a */
    public boolean m61783a() {
        return this.f48771a.isEmpty();
    }

    /* renamed from: b */
    public void m61784b(String str) throws C9952b {
        String strM61785c = m61785c();
        if (str.equals(strM61785c)) {
            return;
        }
        throw new C9952b(this.f48772b, "'" + str + "' expected, get '" + strM61785c + "'.");
    }

    /* renamed from: c */
    public String m61785c() throws C9952b {
        if (m61783a()) {
            throw new C9952b(this.f48772b, "no more tokens.");
        }
        String strPoll = this.f48771a.poll();
        this.f48772b = strPoll;
        return strPoll;
    }

    /* renamed from: d */
    public String m61786d() {
        if (m61783a()) {
            throw new C9952b(this.f48772b, "no more tokens.");
        }
        return this.f48771a.peek();
    }
}
