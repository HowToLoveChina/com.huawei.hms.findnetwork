package com.huawei.hms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes8.dex */
public class ActivityConversionRequest implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityConversionRequest> CREATOR = new C5673yn();
    public static final Comparator<ActivityConversionInfo> IS_EQUAL_CONVERSION = new C5672Vw();

    @Packed
    private List<ActivityConversionInfo> activityConversions;

    /* renamed from: com.huawei.hms.location.ActivityConversionRequest$Vw */
    public class C5672Vw implements Comparator<ActivityConversionInfo> {
        /* JADX WARN: Removed duplicated region for block: B:24:0x001f A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0021 A[RETURN, SYNTHETIC] */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int compare(com.huawei.hms.location.ActivityConversionInfo r2, com.huawei.hms.location.ActivityConversionInfo r3) {
            /*
                r1 = this;
                com.huawei.hms.location.ActivityConversionInfo r2 = (com.huawei.hms.location.ActivityConversionInfo) r2
                com.huawei.hms.location.ActivityConversionInfo r3 = (com.huawei.hms.location.ActivityConversionInfo) r3
                int r1 = r2.getActivityType()
                int r0 = r3.getActivityType()
                int r1 = r1 - r0
                if (r1 == 0) goto L12
                if (r1 <= 0) goto L21
                goto L1f
            L12:
                int r1 = r2.getConversionType()
                int r2 = r3.getConversionType()
                int r1 = r1 - r2
                if (r1 == 0) goto L23
                if (r1 <= 0) goto L21
            L1f:
                r1 = 1
                goto L24
            L21:
                r1 = -1
                goto L24
            L23:
                r1 = 0
            L24:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.location.ActivityConversionRequest.C5672Vw.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    /* renamed from: com.huawei.hms.location.ActivityConversionRequest$yn */
    public class C5673yn implements Parcelable.Creator<ActivityConversionRequest> {
        @Override // android.os.Parcelable.Creator
        public final ActivityConversionRequest createFromParcel(Parcel parcel) {
            return new ActivityConversionRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityConversionRequest[] newArray(int i10) {
            return new ActivityConversionRequest[i10];
        }
    }

    public ActivityConversionRequest() {
    }

    public ActivityConversionRequest(Parcel parcel) {
        this.activityConversions = parcel.createTypedArrayList(ActivityConversionInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && (obj instanceof ActivityConversionRequest)) {
            return Objects.equals(this.activityConversions, ((ActivityConversionRequest) obj).getActivityConversions());
        }
        return false;
    }

    public List<ActivityConversionInfo> getActivityConversions() {
        return this.activityConversions;
    }

    public int hashCode() {
        return this.activityConversions.hashCode();
    }

    public void setActivityConversions(List<ActivityConversionInfo> list) {
        this.activityConversions = list;
    }

    public void setDataToIntent(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("ActivityConversionRequest:The parameter is null");
        }
        intent.putExtra("com.huawei.hms.location.internal.EXTRA_ACTIVITY_CONVERSION_REQUEST", this);
    }

    public String toString() {
        return "ActivityConversionRequest{activityConversions=" + this.activityConversions + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.activityConversions);
    }

    public ActivityConversionRequest(List<ActivityConversionInfo> list) {
        this.activityConversions = list;
    }
}
