package p378iz;

/* renamed from: iz.a */
/* loaded from: classes9.dex */
public abstract class AbstractC10633a {

    /* renamed from: a */
    public final int f51096a;

    /* renamed from: b */
    public final byte[] f51097b = new byte[256];

    /* renamed from: c */
    public int f51098c = 0;

    public AbstractC10633a(int i10) {
        if (i10 < 1 || i10 > 256) {
            throw new IllegalArgumentException();
        }
        this.f51096a = i10;
    }
}
