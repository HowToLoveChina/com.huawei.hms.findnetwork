package ohos.ohos.ohos.ohos.ohos;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p625rx.C12635b;

/* renamed from: ohos.ohos.ohos.ohos.ohos.k */
/* loaded from: classes9.dex */
public class C11895k implements Parcelable {
    public static final Parcelable.Creator<C11895k> CREATOR = new a();

    /* renamed from: a */
    public String f55072a;

    /* renamed from: b */
    public boolean f55073b;

    /* renamed from: c */
    public boolean f55074c;

    /* renamed from: d */
    public boolean f55075d;

    /* renamed from: e */
    public String f55076e;

    /* renamed from: f */
    public String f55077f;

    /* renamed from: g */
    public String f55078g;

    /* renamed from: h */
    public String f55079h;

    /* renamed from: i */
    public String f55080i;

    /* renamed from: j */
    public int f55081j;

    /* renamed from: k */
    public int f55082k;

    /* renamed from: l */
    public int f55083l;

    /* renamed from: m */
    public int f55084m;

    /* renamed from: n */
    public boolean f55085n;

    /* renamed from: o */
    public List<String> f55086o;

    /* renamed from: p */
    public List<C12635b> f55087p;

    /* renamed from: ohos.ohos.ohos.ohos.ohos.k$a */
    public static class a implements Parcelable.Creator<C11895k> {
        @Override // android.os.Parcelable.Creator
        public C11895k createFromParcel(Parcel parcel) {
            return new C11895k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C11895k[] newArray(int i10) {
            if (i10 >= 0) {
                return new C11895k[i10];
            }
            return null;
        }
    }

    public C11895k() {
        this.f55072a = "";
        this.f55073b = false;
        this.f55074c = true;
        this.f55075d = false;
        this.f55076e = "";
        this.f55077f = "";
        this.f55078g = "";
        this.f55079h = "";
        this.f55080i = "";
        this.f55081j = 0;
        this.f55082k = 0;
        this.f55083l = 0;
        this.f55084m = 0;
        this.f55085n = true;
        this.f55086o = new ArrayList(0);
        this.f55087p = new ArrayList(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f55072a);
        parcel.writeString(this.f55076e);
        parcel.writeString(this.f55077f);
        parcel.writeString(this.f55078g);
        parcel.writeString(this.f55079h);
        parcel.writeString(this.f55080i);
        parcel.writeBoolean(this.f55073b);
        parcel.writeInt(this.f55081j);
        parcel.writeInt(this.f55083l);
        parcel.writeInt(this.f55084m);
        parcel.writeInt(this.f55082k);
        parcel.writeBoolean(this.f55085n);
        parcel.writeInt(this.f55086o.size());
        Iterator<String> it = this.f55086o.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next());
        }
        parcel.writeInt(this.f55087p.size());
        for (C12635b c12635b : this.f55087p) {
            parcel.writeString(c12635b.f58081a);
            parcel.writeString(c12635b.f58082b);
        }
        parcel.writeBoolean(this.f55074c);
        parcel.writeBoolean(this.f55075d);
    }

    public C11895k(Parcel parcel) {
        this.f55072a = "";
        this.f55073b = false;
        this.f55074c = true;
        this.f55075d = false;
        this.f55076e = "";
        this.f55077f = "";
        this.f55078g = "";
        this.f55079h = "";
        this.f55080i = "";
        this.f55081j = 0;
        this.f55082k = 0;
        this.f55083l = 0;
        this.f55084m = 0;
        this.f55085n = true;
        this.f55086o = new ArrayList(0);
        this.f55087p = new ArrayList(0);
        this.f55072a = parcel.readString();
        this.f55076e = parcel.readString();
        this.f55077f = parcel.readString();
        this.f55078g = parcel.readString();
        this.f55079h = parcel.readString();
        this.f55080i = parcel.readString();
        this.f55073b = parcel.readBoolean();
        this.f55081j = parcel.readInt();
        this.f55083l = parcel.readInt();
        this.f55084m = parcel.readInt();
        this.f55082k = parcel.readInt();
        this.f55085n = parcel.readBoolean();
        int i10 = parcel.readInt();
        if (i10 > 1024) {
            return;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            this.f55086o.add(parcel.readString());
        }
        int i12 = parcel.readInt();
        if (i12 > 1024) {
            return;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            this.f55087p.add(new C12635b(parcel.readString(), parcel.readString()));
        }
        this.f55074c = parcel.readBoolean();
        this.f55075d = parcel.readBoolean();
    }
}
