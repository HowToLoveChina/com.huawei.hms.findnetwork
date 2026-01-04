package p647t4;

/* renamed from: t4.a */
/* loaded from: classes.dex */
public class C12935a {

    /* renamed from: a */
    public int f58968a;

    /* renamed from: b */
    public String f58969b;

    /* renamed from: c */
    public int f58970c;

    /* renamed from: d */
    public long f58971d;

    /* renamed from: a */
    public String m77666a() {
        return this.f58969b;
    }

    /* renamed from: b */
    public long m77667b() {
        return this.f58971d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C12935a) && this.f58968a == ((C12935a) obj).f58968a;
    }

    public int hashCode() {
        return this.f58968a;
    }

    public String toString() {
        return "BaseModule [logicName=" + this.f58969b + ", totalNum=" + this.f58970c + ", realSize=" + this.f58971d + ", type=" + this.f58968a;
    }
}
