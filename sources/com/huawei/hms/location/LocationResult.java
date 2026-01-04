package com.huawei.hms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class LocationResult implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<LocationResult> CREATOR = new C5682yn();
    private static final String EXTRA_KEY = "com.huawei.hms.location.EXTRA_LOCATION_RESULT";
    private static final String TAG = "LocationResult";

    @Packed
    private List<HWLocation> locations;

    /* renamed from: com.huawei.hms.location.LocationResult$yn */
    public class C5682yn implements Parcelable.Creator<LocationResult> {
        @Override // android.os.Parcelable.Creator
        public final LocationResult createFromParcel(Parcel parcel) {
            return new LocationResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final LocationResult[] newArray(int i10) {
            return new LocationResult[i10];
        }
    }

    public LocationResult(Parcel parcel) {
        this.locations = parcel.createTypedArrayList(HWLocation.CREATOR);
    }

    public static LocationResult create(List<HWLocation> list) {
        return new LocationResult(list);
    }

    public static LocationResult extractResult(Intent intent) {
        LocationResult locationResult = null;
        if (intent == null) {
            return null;
        }
        try {
            if (!intent.hasExtra(EXTRA_KEY)) {
                return null;
            }
            Parcelable parcelableExtra = intent.getParcelableExtra(EXTRA_KEY);
            if (!(parcelableExtra instanceof LocationResult)) {
                if (!(parcelableExtra instanceof Bundle)) {
                    return null;
                }
                Bundle bundle = (Bundle) parcelableExtra;
                if (bundle.getParcelable(EXTRA_KEY) == null) {
                    return null;
                }
                parcelableExtra = bundle.getParcelable(EXTRA_KEY);
            }
            locationResult = (LocationResult) parcelableExtra;
            return locationResult;
        } catch (Exception unused) {
            return locationResult;
        }
    }

    public static boolean hasResult(Intent intent) {
        if (intent != null) {
            try {
                if (intent.hasExtra(EXTRA_KEY)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.locations, ((LocationResult) obj).locations);
    }

    public final List<HWLocation> getHWLocationList() {
        return this.locations;
    }

    public final HWLocation getLastHWLocation() {
        int size = this.locations.size();
        if (size == 0) {
            return null;
        }
        return this.locations.get(size - 1);
    }

    public final Location getLastLocation() {
        int size = this.locations.size();
        if (size == 0) {
            return null;
        }
        return LocationJsonUtil.convertLocation(this.locations.get(size - 1));
    }

    public final List<Location> getLocations() throws JSONException {
        ArrayList arrayList = new ArrayList();
        Iterator<HWLocation> it = this.locations.iterator();
        while (it.hasNext()) {
            Location locationConvertLocation = LocationJsonUtil.convertLocation(it.next());
            if (locationConvertLocation != null) {
                arrayList.add(locationConvertLocation);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        return Objects.hash(this.locations);
    }

    public String toString() {
        return "LocationResult{locations=" + this.locations + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.locations);
    }

    public LocationResult(List<HWLocation> list) {
        this.locations = list;
    }
}
