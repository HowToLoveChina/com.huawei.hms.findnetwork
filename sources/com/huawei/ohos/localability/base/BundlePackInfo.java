package com.huawei.ohos.localability.base;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class BundlePackInfo implements Parcelable {
    public static final Parcelable.Creator<BundlePackInfo> CREATOR = new C6838a();

    /* renamed from: a */
    public List<PackageConfig> f31465a;

    /* renamed from: b */
    public PackageSummary f31466b;

    public static class AbilityFormInfo implements Parcelable {
        public static final Parcelable.Creator<AbilityFormInfo> CREATOR = new C6829a();

        /* renamed from: a */
        public String f31467a;

        /* renamed from: b */
        public String f31468b;

        /* renamed from: c */
        public boolean f31469c;

        /* renamed from: d */
        public String f31470d;

        /* renamed from: e */
        public int f31471e;

        /* renamed from: f */
        public List<Integer> f31472f;

        /* renamed from: g */
        public int f31473g;

        /* renamed from: com.huawei.ohos.localability.base.BundlePackInfo$AbilityFormInfo$a */
        public class C6829a implements Parcelable.Creator<AbilityFormInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AbilityFormInfo createFromParcel(Parcel parcel) {
                return new AbilityFormInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public AbilityFormInfo[] newArray(int i10) {
                if (i10 >= 0) {
                    return new AbilityFormInfo[i10];
                }
                return null;
            }
        }

        public AbilityFormInfo() {
            this.f31472f = new ArrayList();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f31467a);
            parcel.writeString(this.f31468b);
            parcel.writeBoolean(this.f31469c);
            parcel.writeString(this.f31470d);
            parcel.writeInt(this.f31471e);
            parcel.writeInt(this.f31472f.size());
            Iterator<Integer> it = this.f31472f.iterator();
            while (it.hasNext()) {
                parcel.writeInt(it.next().intValue());
            }
            parcel.writeInt(this.f31473g);
        }

        public AbilityFormInfo(Parcel parcel) {
            this.f31467a = parcel.readString();
            this.f31468b = parcel.readString();
            this.f31469c = parcel.readBoolean();
            this.f31470d = parcel.readString();
            this.f31471e = parcel.readInt();
            int i10 = parcel.readInt();
            if (i10 > 10) {
                return;
            }
            this.f31472f = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.f31472f.add(Integer.valueOf(parcel.readInt()));
            }
            this.f31473g = parcel.readInt();
        }
    }

    public static class ApiVersion implements Parcelable {
        public static final Parcelable.Creator<ApiVersion> CREATOR = new C6830a();

        /* renamed from: a */
        public String f31474a;

        /* renamed from: b */
        public int f31475b;

        /* renamed from: c */
        public int f31476c;

        /* renamed from: com.huawei.ohos.localability.base.BundlePackInfo$ApiVersion$a */
        public class C6830a implements Parcelable.Creator<ApiVersion> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ApiVersion createFromParcel(Parcel parcel) {
                return new ApiVersion(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ApiVersion[] newArray(int i10) {
                if (i10 >= 0) {
                    return new ApiVersion[i10];
                }
                return null;
            }
        }

        public ApiVersion() {
        }

        public ApiVersion(Parcel parcel) {
            this.f31474a = parcel.readString();
            this.f31475b = parcel.readInt();
            this.f31476c = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f31474a);
            parcel.writeInt(this.f31475b);
            parcel.writeInt(this.f31476c);
        }
    }

    public static class BundleConfigInfo implements Parcelable {
        public static final Parcelable.Creator<BundleConfigInfo> CREATOR = new C6831a();

        /* renamed from: a */
        public String f31477a;

        /* renamed from: b */
        public Version f31478b;

        /* renamed from: com.huawei.ohos.localability.base.BundlePackInfo$BundleConfigInfo$a */
        public class C6831a implements Parcelable.Creator<BundleConfigInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public BundleConfigInfo createFromParcel(Parcel parcel) {
                return new BundleConfigInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public BundleConfigInfo[] newArray(int i10) {
                if (i10 >= 0) {
                    return new BundleConfigInfo[i10];
                }
                return null;
            }
        }

        public BundleConfigInfo() {
            this.f31478b = new Version();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f31477a);
            parcel.writeTypedObject(this.f31478b, i10);
        }

        public BundleConfigInfo(Parcel parcel) {
            this.f31477a = parcel.readString();
            this.f31478b = (Version) parcel.readTypedObject(Version.CREATOR);
        }
    }

    public static class ModuleAbilityInfo implements Parcelable {
        public static final Parcelable.Creator<ModuleAbilityInfo> CREATOR = new C6832a();

        /* renamed from: a */
        public String f31479a;

        /* renamed from: b */
        public String f31480b;

        /* renamed from: c */
        public boolean f31481c;

        /* renamed from: d */
        public List<AbilityFormInfo> f31482d;

        /* renamed from: com.huawei.ohos.localability.base.BundlePackInfo$ModuleAbilityInfo$a */
        public class C6832a implements Parcelable.Creator<ModuleAbilityInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ModuleAbilityInfo createFromParcel(Parcel parcel) {
                return new ModuleAbilityInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ModuleAbilityInfo[] newArray(int i10) {
                if (i10 >= 0) {
                    return new ModuleAbilityInfo[i10];
                }
                return null;
            }
        }

        public ModuleAbilityInfo() {
            this.f31482d = new ArrayList();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f31479a);
            parcel.writeString(this.f31480b);
            parcel.writeBoolean(this.f31481c);
            parcel.writeInt(this.f31482d.size());
            Iterator<AbilityFormInfo> it = this.f31482d.iterator();
            while (it.hasNext()) {
                parcel.writeTypedObject(it.next(), i10);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ModuleAbilityInfo(Parcel parcel) {
            this.f31479a = parcel.readString();
            this.f31480b = parcel.readString();
            this.f31481c = parcel.readBoolean();
            int i10 = parcel.readInt();
            if (i10 > 100) {
                return;
            }
            this.f31482d = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.f31482d.add(parcel.readTypedObject(AbilityFormInfo.CREATOR));
            }
        }
    }

    public static class ModuleConfigInfo implements Parcelable {
        public static final Parcelable.Creator<ModuleConfigInfo> CREATOR = new C6833a();

        /* renamed from: a */
        public ApiVersion f31483a;

        /* renamed from: b */
        public List<String> f31484b;

        /* renamed from: c */
        public ModuleDistroInfo f31485c;

        /* renamed from: d */
        public List<ModuleAbilityInfo> f31486d;

        /* renamed from: com.huawei.ohos.localability.base.BundlePackInfo$ModuleConfigInfo$a */
        public class C6833a implements Parcelable.Creator<ModuleConfigInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ModuleConfigInfo createFromParcel(Parcel parcel) {
                return new ModuleConfigInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ModuleConfigInfo[] newArray(int i10) {
                if (i10 >= 0) {
                    return new ModuleConfigInfo[i10];
                }
                return null;
            }
        }

        public ModuleConfigInfo() {
            this.f31483a = new ApiVersion();
            this.f31484b = new ArrayList();
            this.f31485c = new ModuleDistroInfo();
            this.f31486d = new ArrayList();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeTypedObject(this.f31483a, i10);
            parcel.writeInt(this.f31484b.size());
            Iterator<String> it = this.f31484b.iterator();
            while (it.hasNext()) {
                parcel.writeString(it.next());
            }
            parcel.writeTypedObject(this.f31485c, i10);
            parcel.writeInt(this.f31486d.size());
            Iterator<ModuleAbilityInfo> it2 = this.f31486d.iterator();
            while (it2.hasNext()) {
                parcel.writeTypedObject(it2.next(), i10);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ModuleConfigInfo(Parcel parcel) {
            this.f31483a = (ApiVersion) parcel.readTypedObject(ApiVersion.CREATOR);
            int i10 = parcel.readInt();
            if (i10 > 100) {
                return;
            }
            this.f31484b = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.f31484b.add(parcel.readString());
            }
            this.f31485c = (ModuleDistroInfo) parcel.readTypedObject(ModuleDistroInfo.CREATOR);
            int i12 = parcel.readInt();
            if (i12 > 100) {
                return;
            }
            this.f31486d = new ArrayList(i12);
            for (int i13 = 0; i13 < i12; i13++) {
                this.f31486d.add(parcel.readTypedObject(ModuleAbilityInfo.CREATOR));
            }
        }
    }

    public static class ModuleDistroInfo implements Parcelable {
        public static final Parcelable.Creator<ModuleDistroInfo> CREATOR = new C6834a();

        /* renamed from: a */
        public boolean f31487a;

        /* renamed from: b */
        public boolean f31488b;

        /* renamed from: c */
        public String f31489c;

        /* renamed from: d */
        public String f31490d;

        /* renamed from: e */
        public String f31491e;

        /* renamed from: com.huawei.ohos.localability.base.BundlePackInfo$ModuleDistroInfo$a */
        public class C6834a implements Parcelable.Creator<ModuleDistroInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ModuleDistroInfo createFromParcel(Parcel parcel) {
                return new ModuleDistroInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ModuleDistroInfo[] newArray(int i10) {
                if (i10 >= 0) {
                    return new ModuleDistroInfo[i10];
                }
                return null;
            }
        }

        public ModuleDistroInfo() {
        }

        public ModuleDistroInfo(Parcel parcel) {
            this.f31487a = parcel.readBoolean();
            this.f31488b = parcel.readBoolean();
            this.f31489c = parcel.readString();
            this.f31490d = parcel.readString();
            this.f31491e = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeBoolean(this.f31487a);
            parcel.writeBoolean(this.f31488b);
            parcel.writeString(this.f31489c);
            parcel.writeString(this.f31490d);
            parcel.writeString(this.f31491e);
        }
    }

    public static class PackageConfig implements Parcelable {
        public static final Parcelable.Creator<PackageConfig> CREATOR = new C6835a();

        /* renamed from: a */
        public List<String> f31492a;

        /* renamed from: b */
        public String f31493b;

        /* renamed from: c */
        public String f31494c;

        /* renamed from: d */
        public boolean f31495d;

        /* renamed from: com.huawei.ohos.localability.base.BundlePackInfo$PackageConfig$a */
        public class C6835a implements Parcelable.Creator<PackageConfig> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PackageConfig createFromParcel(Parcel parcel) {
                return new PackageConfig(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public PackageConfig[] newArray(int i10) {
                if (i10 >= 0) {
                    return new PackageConfig[i10];
                }
                return null;
            }
        }

        public PackageConfig() {
            this.f31492a = new ArrayList();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f31492a.size());
            Iterator<String> it = this.f31492a.iterator();
            while (it.hasNext()) {
                parcel.writeString(it.next());
            }
            parcel.writeString(this.f31493b);
            parcel.writeString(this.f31494c);
            parcel.writeBoolean(this.f31495d);
        }

        public PackageConfig(Parcel parcel) {
            int i10 = parcel.readInt();
            if (i10 > 50) {
                return;
            }
            this.f31492a = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.f31492a.add(parcel.readString());
            }
            this.f31493b = parcel.readString();
            this.f31494c = parcel.readString();
            this.f31495d = parcel.readBoolean();
        }
    }

    public static class PackageSummary implements Parcelable {
        public static final Parcelable.Creator<PackageSummary> CREATOR = new C6836a();

        /* renamed from: a */
        public BundleConfigInfo f31496a;

        /* renamed from: b */
        public List<ModuleConfigInfo> f31497b;

        /* renamed from: com.huawei.ohos.localability.base.BundlePackInfo$PackageSummary$a */
        public class C6836a implements Parcelable.Creator<PackageSummary> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PackageSummary createFromParcel(Parcel parcel) {
                return new PackageSummary(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public PackageSummary[] newArray(int i10) {
                if (i10 >= 0) {
                    return new PackageSummary[i10];
                }
                return null;
            }
        }

        public PackageSummary() {
            this.f31496a = new BundleConfigInfo();
            this.f31497b = new ArrayList();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeTypedObject(this.f31496a, i10);
            parcel.writeInt(this.f31497b.size());
            Iterator<ModuleConfigInfo> it = this.f31497b.iterator();
            while (it.hasNext()) {
                parcel.writeTypedObject(it.next(), i10);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PackageSummary(Parcel parcel) {
            this.f31496a = (BundleConfigInfo) parcel.readTypedObject(BundleConfigInfo.CREATOR);
            int i10 = parcel.readInt();
            if (i10 > 100) {
                return;
            }
            this.f31497b = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.f31497b.add(parcel.readTypedObject(ModuleConfigInfo.CREATOR));
            }
        }
    }

    public static class Version implements Parcelable {
        public static final Parcelable.Creator<Version> CREATOR = new C6837a();

        /* renamed from: a */
        public int f31498a;

        /* renamed from: b */
        public String f31499b;

        /* renamed from: c */
        public int f31500c;

        /* renamed from: com.huawei.ohos.localability.base.BundlePackInfo$Version$a */
        public class C6837a implements Parcelable.Creator<Version> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Version createFromParcel(Parcel parcel) {
                return new Version(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Version[] newArray(int i10) {
                if (i10 >= 0) {
                    return new Version[i10];
                }
                return null;
            }
        }

        public Version() {
        }

        public Version(Parcel parcel) {
            this.f31498a = parcel.readInt();
            this.f31499b = parcel.readString();
            this.f31500c = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f31498a);
            parcel.writeString(this.f31499b);
            parcel.writeInt(this.f31500c);
        }
    }

    /* renamed from: com.huawei.ohos.localability.base.BundlePackInfo$a */
    public class C6838a implements Parcelable.Creator<BundlePackInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BundlePackInfo createFromParcel(Parcel parcel) {
            return new BundlePackInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BundlePackInfo[] newArray(int i10) {
            if (i10 >= 0) {
                return new BundlePackInfo[i10];
            }
            return null;
        }
    }

    public BundlePackInfo() {
        this.f31465a = new ArrayList();
        this.f31466b = new PackageSummary();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f31465a.size());
        Iterator<PackageConfig> it = this.f31465a.iterator();
        while (it.hasNext()) {
            parcel.writeTypedObject(it.next(), i10);
        }
        parcel.writeTypedObject(this.f31466b, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BundlePackInfo(Parcel parcel) {
        int i10 = parcel.readInt();
        if (i10 > 100) {
            return;
        }
        this.f31465a = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            this.f31465a.add(parcel.readTypedObject(PackageConfig.CREATOR));
        }
        this.f31466b = (PackageSummary) parcel.readTypedObject(PackageSummary.CREATOR);
    }
}
