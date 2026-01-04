package p003a2;

/* renamed from: a2.h */
/* loaded from: classes.dex */
public final class C0013h implements InterfaceC0006a<int[]> {
    @Override // p003a2.InterfaceC0006a
    /* renamed from: a */
    public String mo5a() {
        return "IntegerArrayPool";
    }

    @Override // p003a2.InterfaceC0006a
    /* renamed from: b */
    public int mo6b() {
        return 4;
    }

    @Override // p003a2.InterfaceC0006a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int mo7c(int[] iArr) {
        return iArr.length;
    }

    @Override // p003a2.InterfaceC0006a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i10) {
        return new int[i10];
    }
}
