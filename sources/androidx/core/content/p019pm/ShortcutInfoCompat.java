package androidx.core.content.p019pm;

import android.annotation.SuppressLint;
import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.app.C0611c;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p001a0.C0001a;
import p243e0.C9373h;

/* loaded from: classes.dex */
public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    int mDisabledReason;
    int mExcludedSurfaces;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled = true;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    CharSequence mLabel;
    long mLastChangedTimestamp;
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    C0611c[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder(Context context, String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = str;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(String str) {
            if (this.mCapabilityBindings == null) {
                this.mCapabilityBindings = new HashSet();
            }
            this.mCapabilityBindings.add(str);
            return this;
        }

        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
            Intent[] intentArr = shortcutInfoCompat.mIntents;
            if (intentArr == null || intentArr.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.mIsConversation) {
                if (shortcutInfoCompat.mLocusId == null) {
                    shortcutInfoCompat.mLocusId = new LocusIdCompat(shortcutInfoCompat.mId);
                }
                this.mInfo.mIsLongLived = true;
            }
            if (this.mCapabilityBindings != null) {
                ShortcutInfoCompat shortcutInfoCompat2 = this.mInfo;
                if (shortcutInfoCompat2.mCategories == null) {
                    shortcutInfoCompat2.mCategories = new HashSet();
                }
                this.mInfo.mCategories.addAll(this.mCapabilityBindings);
            }
            if (this.mCapabilityBindingParams != null) {
                ShortcutInfoCompat shortcutInfoCompat3 = this.mInfo;
                if (shortcutInfoCompat3.mExtras == null) {
                    shortcutInfoCompat3.mExtras = new PersistableBundle();
                }
                for (String str : this.mCapabilityBindingParams.keySet()) {
                    Map<String, List<String>> map = this.mCapabilityBindingParams.get(str);
                    this.mInfo.mExtras.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                    for (String str2 : map.keySet()) {
                        List<String> list = map.get(str2);
                        this.mInfo.mExtras.putStringArray(str + "/" + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                    }
                }
            }
            if (this.mSliceUri != null) {
                ShortcutInfoCompat shortcutInfoCompat4 = this.mInfo;
                if (shortcutInfoCompat4.mExtras == null) {
                    shortcutInfoCompat4.mExtras = new PersistableBundle();
                }
                this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, C0001a.m1a(this.mSliceUri));
            }
            return this.mInfo;
        }

        public Builder setActivity(ComponentName componentName) {
            this.mInfo.mActivity = componentName;
            return this;
        }

        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public Builder setCategories(Set<String> set) {
            this.mInfo.mCategories = set;
            return this;
        }

        public Builder setDisabledMessage(CharSequence charSequence) {
            this.mInfo.mDisabledMessage = charSequence;
            return this;
        }

        public Builder setExcludedFromSurfaces(int i10) {
            this.mInfo.mExcludedSurfaces = i10;
            return this;
        }

        public Builder setExtras(PersistableBundle persistableBundle) {
            this.mInfo.mExtras = persistableBundle;
            return this;
        }

        public Builder setIcon(IconCompat iconCompat) {
            this.mInfo.mIcon = iconCompat;
            return this;
        }

        public Builder setIntent(Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        public Builder setIntents(Intent[] intentArr) {
            this.mInfo.mIntents = intentArr;
            return this;
        }

        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        public Builder setLocusId(LocusIdCompat locusIdCompat) {
            this.mInfo.mLocusId = locusIdCompat;
            return this;
        }

        public Builder setLongLabel(CharSequence charSequence) {
            this.mInfo.mLongLabel = charSequence;
            return this;
        }

        @Deprecated
        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        public Builder setPerson(C0611c c0611c) {
            return setPersons(new C0611c[]{c0611c});
        }

        public Builder setPersons(C0611c[] c0611cArr) {
            this.mInfo.mPersons = c0611cArr;
            return this;
        }

        public Builder setRank(int i10) {
            this.mInfo.mRank = i10;
            return this;
        }

        public Builder setShortLabel(CharSequence charSequence) {
            this.mInfo.mLabel = charSequence;
            return this;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setSliceUri(Uri uri) {
            this.mSliceUri = uri;
            return this;
        }

        public Builder setTransientExtras(Bundle bundle) {
            this.mInfo.mTransientExtras = (Bundle) C9373h.m58745f(bundle);
            return this;
        }

        public Builder setLongLived(boolean z10) {
            this.mInfo.mIsLongLived = z10;
            return this;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(String str, String str2, List<String> list) {
            addCapabilityBinding(str);
            if (!list.isEmpty()) {
                if (this.mCapabilityBindingParams == null) {
                    this.mCapabilityBindingParams = new HashMap();
                }
                if (this.mCapabilityBindingParams.get(str) == null) {
                    this.mCapabilityBindingParams.put(str, new HashMap());
                }
                this.mCapabilityBindingParams.get(str).put(str2, list);
            }
            return this;
        }

        public Builder(ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat2;
            shortcutInfoCompat2.mContext = shortcutInfoCompat.mContext;
            shortcutInfoCompat2.mId = shortcutInfoCompat.mId;
            shortcutInfoCompat2.mPackageName = shortcutInfoCompat.mPackageName;
            Intent[] intentArr = shortcutInfoCompat.mIntents;
            shortcutInfoCompat2.mIntents = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            shortcutInfoCompat2.mActivity = shortcutInfoCompat.mActivity;
            shortcutInfoCompat2.mLabel = shortcutInfoCompat.mLabel;
            shortcutInfoCompat2.mLongLabel = shortcutInfoCompat.mLongLabel;
            shortcutInfoCompat2.mDisabledMessage = shortcutInfoCompat.mDisabledMessage;
            shortcutInfoCompat2.mDisabledReason = shortcutInfoCompat.mDisabledReason;
            shortcutInfoCompat2.mIcon = shortcutInfoCompat.mIcon;
            shortcutInfoCompat2.mIsAlwaysBadged = shortcutInfoCompat.mIsAlwaysBadged;
            shortcutInfoCompat2.mUser = shortcutInfoCompat.mUser;
            shortcutInfoCompat2.mLastChangedTimestamp = shortcutInfoCompat.mLastChangedTimestamp;
            shortcutInfoCompat2.mIsCached = shortcutInfoCompat.mIsCached;
            shortcutInfoCompat2.mIsDynamic = shortcutInfoCompat.mIsDynamic;
            shortcutInfoCompat2.mIsPinned = shortcutInfoCompat.mIsPinned;
            shortcutInfoCompat2.mIsDeclaredInManifest = shortcutInfoCompat.mIsDeclaredInManifest;
            shortcutInfoCompat2.mIsImmutable = shortcutInfoCompat.mIsImmutable;
            shortcutInfoCompat2.mIsEnabled = shortcutInfoCompat.mIsEnabled;
            shortcutInfoCompat2.mLocusId = shortcutInfoCompat.mLocusId;
            shortcutInfoCompat2.mIsLongLived = shortcutInfoCompat.mIsLongLived;
            shortcutInfoCompat2.mHasKeyFieldsOnly = shortcutInfoCompat.mHasKeyFieldsOnly;
            shortcutInfoCompat2.mRank = shortcutInfoCompat.mRank;
            C0611c[] c0611cArr = shortcutInfoCompat.mPersons;
            if (c0611cArr != null) {
                shortcutInfoCompat2.mPersons = (C0611c[]) Arrays.copyOf(c0611cArr, c0611cArr.length);
            }
            if (shortcutInfoCompat.mCategories != null) {
                shortcutInfoCompat2.mCategories = new HashSet(shortcutInfoCompat.mCategories);
            }
            PersistableBundle persistableBundle = shortcutInfoCompat.mExtras;
            if (persistableBundle != null) {
                shortcutInfoCompat2.mExtras = persistableBundle;
            }
            shortcutInfoCompat2.mExcludedSurfaces = shortcutInfoCompat.mExcludedSurfaces;
        }

        public Builder(Context context, ShortcutInfo shortcutInfo) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = shortcutInfo.getId();
            shortcutInfoCompat.mPackageName = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            shortcutInfoCompat.mIntents = (Intent[]) Arrays.copyOf(intents, intents.length);
            shortcutInfoCompat.mActivity = shortcutInfo.getActivity();
            shortcutInfoCompat.mLabel = shortcutInfo.getShortLabel();
            shortcutInfoCompat.mLongLabel = shortcutInfo.getLongLabel();
            shortcutInfoCompat.mDisabledMessage = shortcutInfo.getDisabledMessage();
            int i10 = Build.VERSION.SDK_INT;
            shortcutInfoCompat.mDisabledReason = shortcutInfo.getDisabledReason();
            shortcutInfoCompat.mCategories = shortcutInfo.getCategories();
            shortcutInfoCompat.mPersons = ShortcutInfoCompat.getPersonsFromExtra(shortcutInfo.getExtras());
            shortcutInfoCompat.mUser = shortcutInfo.getUserHandle();
            shortcutInfoCompat.mLastChangedTimestamp = shortcutInfo.getLastChangedTimestamp();
            if (i10 >= 30) {
                shortcutInfoCompat.mIsCached = shortcutInfo.isCached();
            }
            shortcutInfoCompat.mIsDynamic = shortcutInfo.isDynamic();
            shortcutInfoCompat.mIsPinned = shortcutInfo.isPinned();
            shortcutInfoCompat.mIsDeclaredInManifest = shortcutInfo.isDeclaredInManifest();
            shortcutInfoCompat.mIsImmutable = shortcutInfo.isImmutable();
            shortcutInfoCompat.mIsEnabled = shortcutInfo.isEnabled();
            shortcutInfoCompat.mHasKeyFieldsOnly = shortcutInfo.hasKeyFieldsOnly();
            shortcutInfoCompat.mLocusId = ShortcutInfoCompat.getLocusId(shortcutInfo);
            shortcutInfoCompat.mRank = shortcutInfo.getRank();
            shortcutInfoCompat.mExtras = shortcutInfo.getExtras();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Surface {
    }

    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras == null) {
            this.mExtras = new PersistableBundle();
        }
        C0611c[] c0611cArr = this.mPersons;
        if (c0611cArr != null && c0611cArr.length > 0) {
            this.mExtras.putInt(EXTRA_PERSON_COUNT, c0611cArr.length);
            int i10 = 0;
            while (i10 < this.mPersons.length) {
                PersistableBundle persistableBundle = this.mExtras;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(EXTRA_PERSON_);
                int i11 = i10 + 1;
                sb2.append(i11);
                persistableBundle.putPersistableBundle(sb2.toString(), this.mPersons[i10].m3861i());
                i10 = i11;
            }
        }
        LocusIdCompat locusIdCompat = this.mLocusId;
        if (locusIdCompat != null) {
            this.mExtras.putString(EXTRA_LOCUS_ID, locusIdCompat.getId());
        }
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    }

    public static List<ShortcutInfoCompat> fromShortcuts(Context context, List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<ShortcutInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Builder(context, it.next()).build());
        }
        return arrayList;
    }

    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString(EXTRA_LOCUS_ID)) == null) {
            return null;
        }
        return new LocusIdCompat(string);
    }

    public static boolean getLongLivedFromExtra(PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_LONG_LIVED)) {
            return false;
        }
        return persistableBundle.getBoolean(EXTRA_LONG_LIVED);
    }

    public static C0611c[] getPersonsFromExtra(PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_PERSON_COUNT)) {
            return null;
        }
        int i10 = persistableBundle.getInt(EXTRA_PERSON_COUNT);
        C0611c[] c0611cArr = new C0611c[i10];
        int i11 = 0;
        while (i11 < i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(EXTRA_PERSON_);
            int i12 = i11 + 1;
            sb2.append(i12);
            c0611cArr[i11] = C0611c.m3853a(persistableBundle.getPersistableBundle(sb2.toString()));
            i11 = i12;
        }
        return c0611cArr;
    }

    public Intent addToIntent(Intent intent) throws PackageManager.NameNotFoundException {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon != null) {
            Drawable activityIcon = null;
            if (this.mIsAlwaysBadged) {
                PackageManager packageManager = this.mContext.getPackageManager();
                ComponentName componentName = this.mActivity;
                if (componentName != null) {
                    try {
                        activityIcon = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (activityIcon == null) {
                    activityIcon = this.mContext.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.mIcon.m3911a(intent, activityIcon, this.mContext);
        }
        return intent;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public Set<String> getCategories() {
        return this.mCategories;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getId() {
        return this.mId;
    }

    public Intent getIntent() {
        return this.mIntents[r1.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] intentArr = this.mIntents;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isExcludedFromSurfaces(int i10) {
        return (this.mExcludedSurfaces & i10) != 0;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.m3921u(this.mContext));
        }
        if (!TextUtils.isEmpty(this.mLongLabel)) {
            intents.setLongLabel(this.mLongLabel);
        }
        if (!TextUtils.isEmpty(this.mDisabledMessage)) {
            intents.setDisabledMessage(this.mDisabledMessage);
        }
        ComponentName componentName = this.mActivity;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.mCategories;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.mRank);
        PersistableBundle persistableBundle = this.mExtras;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        C0611c[] c0611cArr = this.mPersons;
        if (c0611cArr != null && c0611cArr.length > 0) {
            int length = c0611cArr.length;
            Person[] personArr = new Person[length];
            for (int i10 = 0; i10 < length; i10++) {
                personArr[i10] = this.mPersons[i10].m3860h();
            }
            intents.setPersons(personArr);
        }
        LocusIdCompat locusIdCompat = this.mLocusId;
        if (locusIdCompat != null) {
            intents.setLocusId(locusIdCompat.toLocusId());
        }
        intents.setLongLived(this.mIsLongLived);
        return intents.build();
    }

    public static LocusIdCompat getLocusId(ShortcutInfo shortcutInfo) {
        if (shortcutInfo.getLocusId() == null) {
            return null;
        }
        return LocusIdCompat.toLocusIdCompat(shortcutInfo.getLocusId());
    }
}
