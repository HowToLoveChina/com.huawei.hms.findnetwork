package p025b1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import p438l.C11207a;

/* renamed from: b1.b */
/* loaded from: classes.dex */
public class C1097b extends AbstractC1096a {

    /* renamed from: d */
    public final SparseIntArray f5216d;

    /* renamed from: e */
    public final Parcel f5217e;

    /* renamed from: f */
    public final int f5218f;

    /* renamed from: g */
    public final int f5219g;

    /* renamed from: h */
    public final String f5220h;

    /* renamed from: i */
    public int f5221i;

    /* renamed from: j */
    public int f5222j;

    /* renamed from: k */
    public int f5223k;

    public C1097b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C11207a(), new C11207a(), new C11207a());
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: A */
    public void mo6496A(byte[] bArr) {
        if (bArr == null) {
            this.f5217e.writeInt(-1);
        } else {
            this.f5217e.writeInt(bArr.length);
            this.f5217e.writeByteArray(bArr);
        }
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: C */
    public void mo6498C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f5217e, 0);
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: E */
    public void mo6500E(int i10) {
        this.f5217e.writeInt(i10);
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: G */
    public void mo6502G(Parcelable parcelable) {
        this.f5217e.writeParcelable(parcelable, 0);
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: I */
    public void mo6504I(String str) {
        this.f5217e.writeString(str);
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: a */
    public void mo6510a() {
        int i10 = this.f5221i;
        if (i10 >= 0) {
            int i11 = this.f5216d.get(i10);
            int iDataPosition = this.f5217e.dataPosition();
            this.f5217e.setDataPosition(i11);
            this.f5217e.writeInt(iDataPosition - i11);
            this.f5217e.setDataPosition(iDataPosition);
        }
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: b */
    public AbstractC1096a mo6511b() {
        Parcel parcel = this.f5217e;
        int iDataPosition = parcel.dataPosition();
        int i10 = this.f5222j;
        if (i10 == this.f5218f) {
            i10 = this.f5219g;
        }
        return new C1097b(parcel, iDataPosition, i10, this.f5220h + "  ", this.f5213a, this.f5214b, this.f5215c);
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: g */
    public boolean mo6516g() {
        return this.f5217e.readInt() != 0;
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: i */
    public byte[] mo6518i() {
        int i10 = this.f5217e.readInt();
        if (i10 < 0) {
            return null;
        }
        byte[] bArr = new byte[i10];
        this.f5217e.readByteArray(bArr);
        return bArr;
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: k */
    public CharSequence mo6520k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f5217e);
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: m */
    public boolean mo6522m(int i10) {
        while (this.f5222j < this.f5219g) {
            int i11 = this.f5223k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f5217e.setDataPosition(this.f5222j);
            int i12 = this.f5217e.readInt();
            this.f5223k = this.f5217e.readInt();
            this.f5222j += i12;
        }
        return this.f5223k == i10;
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: o */
    public int mo6524o() {
        return this.f5217e.readInt();
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: q */
    public <T extends Parcelable> T mo6526q() {
        return (T) this.f5217e.readParcelable(getClass().getClassLoader());
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: s */
    public String mo6528s() {
        return this.f5217e.readString();
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: w */
    public void mo6532w(int i10) {
        mo6510a();
        this.f5221i = i10;
        this.f5216d.put(i10, this.f5217e.dataPosition());
        mo6500E(0);
        mo6500E(i10);
    }

    @Override // p025b1.AbstractC1096a
    /* renamed from: y */
    public void mo6534y(boolean z10) {
        this.f5217e.writeInt(z10 ? 1 : 0);
    }

    public C1097b(Parcel parcel, int i10, int i11, String str, C11207a<String, Method> c11207a, C11207a<String, Method> c11207a2, C11207a<String, Class> c11207a3) {
        super(c11207a, c11207a2, c11207a3);
        this.f5216d = new SparseIntArray();
        this.f5221i = -1;
        this.f5223k = -1;
        this.f5217e = parcel;
        this.f5218f = i10;
        this.f5219g = i11;
        this.f5222j = i10;
        this.f5220h = str;
    }
}
