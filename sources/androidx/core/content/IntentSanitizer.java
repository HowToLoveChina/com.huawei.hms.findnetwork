package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.content.IntentSanitizer;
import com.huawei.openalliance.p169ad.constant.OsType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p243e0.C9373h;
import p243e0.InterfaceC9366a;
import p243e0.InterfaceC9375j;

/* loaded from: classes.dex */
public class IntentSanitizer {
    private static final String TAG = "IntentSanitizer";
    private boolean mAllowAnyComponent;
    private boolean mAllowClipDataText;
    private boolean mAllowIdentifier;
    private boolean mAllowSelector;
    private boolean mAllowSourceBounds;
    private InterfaceC9375j<String> mAllowedActions;
    private InterfaceC9375j<String> mAllowedCategories;
    private InterfaceC9375j<ClipData> mAllowedClipData;
    private InterfaceC9375j<Uri> mAllowedClipDataUri;
    private InterfaceC9375j<ComponentName> mAllowedComponents;
    private InterfaceC9375j<Uri> mAllowedData;
    private Map<String, InterfaceC9375j<Object>> mAllowedExtras;
    private int mAllowedFlags;
    private InterfaceC9375j<String> mAllowedPackages;
    private InterfaceC9375j<String> mAllowedTypes;

    public static class Api15Impl {
        private Api15Impl() {
        }

        public static Intent getSelector(Intent intent) {
            return intent.getSelector();
        }

        public static void setSelector(Intent intent, Intent intent2) {
            intent.setSelector(intent2);
        }
    }

    public static class Api16Impl {

        public static class Api31Impl {
            private Api31Impl() {
            }

            public static void checkOtherMembers(int i10, ClipData.Item item, InterfaceC9366a<String> interfaceC9366a) {
                if (item.getHtmlText() == null && item.getIntent() == null && item.getTextLinks() == null) {
                    return;
                }
                interfaceC9366a.accept("ClipData item at position " + i10 + " contains htmlText, textLinks or intent: " + item);
            }
        }

        private Api16Impl() {
        }

        private static void checkOtherMembers(int i10, ClipData.Item item, InterfaceC9366a<String> interfaceC9366a) {
            if (item.getHtmlText() == null && item.getIntent() == null) {
                return;
            }
            interfaceC9366a.accept("ClipData item at position " + i10 + " contains htmlText, textLinks or intent: " + item);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void sanitizeClipData(android.content.Intent r7, android.content.Intent r8, p243e0.InterfaceC9375j<android.content.ClipData> r9, boolean r10, p243e0.InterfaceC9375j<android.net.Uri> r11, p243e0.InterfaceC9366a<java.lang.String> r12) {
            /*
                android.content.ClipData r7 = r7.getClipData()
                if (r7 != 0) goto L7
                return
            L7:
                if (r9 == 0) goto L14
                boolean r9 = r9.test(r7)
                if (r9 == 0) goto L14
                r8.setClipData(r7)
                goto Lde
            L14:
                r9 = 0
                r0 = 0
                r1 = r9
            L17:
                int r2 = r7.getItemCount()
                if (r0 >= r2) goto Ld9
                android.content.ClipData$Item r2 = r7.getItemAt(r0)
                int r3 = android.os.Build.VERSION.SDK_INT
                r4 = 31
                if (r3 < r4) goto L2b
                androidx.core.content.IntentSanitizer.Api16Impl.Api31Impl.checkOtherMembers(r0, r2, r12)
                goto L2e
            L2b:
                checkOtherMembers(r0, r2, r12)
            L2e:
                if (r10 == 0) goto L35
                java.lang.CharSequence r3 = r2.getText()
                goto L5c
            L35:
                java.lang.CharSequence r3 = r2.getText()
                if (r3 == 0) goto L5b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Item text cannot contain value. Item position: "
                r3.append(r4)
                r3.append(r0)
                java.lang.String r4 = ". Text: "
                r3.append(r4)
                java.lang.CharSequence r4 = r2.getText()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r12.accept(r3)
            L5b:
                r3 = r9
            L5c:
                java.lang.String r4 = ". URI: "
                java.lang.String r5 = "Item URI is not allowed. Item position: "
                if (r11 != 0) goto L85
                android.net.Uri r6 = r2.getUri()
                if (r6 == 0) goto Lb2
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r5)
                r6.append(r0)
                r6.append(r4)
                android.net.Uri r2 = r2.getUri()
                r6.append(r2)
                java.lang.String r2 = r6.toString()
                r12.accept(r2)
                goto Lb2
            L85:
                android.net.Uri r6 = r2.getUri()
                if (r6 == 0) goto Lb4
                android.net.Uri r6 = r2.getUri()
                boolean r6 = r11.test(r6)
                if (r6 == 0) goto L96
                goto Lb4
            L96:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r5)
                r6.append(r0)
                r6.append(r4)
                android.net.Uri r2 = r2.getUri()
                r6.append(r2)
                java.lang.String r2 = r6.toString()
                r12.accept(r2)
            Lb2:
                r2 = r9
                goto Lb8
            Lb4:
                android.net.Uri r2 = r2.getUri()
            Lb8:
                if (r3 != 0) goto Lbc
                if (r2 == 0) goto Ld5
            Lbc:
                if (r1 != 0) goto Lcd
                android.content.ClipData r1 = new android.content.ClipData
                android.content.ClipDescription r4 = r7.getDescription()
                android.content.ClipData$Item r5 = new android.content.ClipData$Item
                r5.<init>(r3, r9, r2)
                r1.<init>(r4, r5)
                goto Ld5
            Lcd:
                android.content.ClipData$Item r4 = new android.content.ClipData$Item
                r4.<init>(r3, r9, r2)
                r1.addItem(r4)
            Ld5:
                int r0 = r0 + 1
                goto L17
            Ld9:
                if (r1 == 0) goto Lde
                r8.setClipData(r1)
            Lde:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.IntentSanitizer.Api16Impl.sanitizeClipData(android.content.Intent, android.content.Intent, e0.j, boolean, e0.j, e0.a):void");
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static String getIdentifier(Intent intent) {
            return intent.getIdentifier();
        }

        public static Intent setIdentifier(Intent intent, String str) {
            return intent.setIdentifier(str);
        }
    }

    public static final class Builder {
        private static final int HISTORY_STACK_FLAGS = 2112614400;
        private static final int RECEIVER_FLAGS = 2015363072;
        private boolean mAllowAnyComponent;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private int mAllowedFlags;
        private InterfaceC9375j<String> mAllowedActions = new InterfaceC9375j() { // from class: androidx.core.content.n
            @Override // p243e0.InterfaceC9375j
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.lambda$new$0((String) obj);
            }
        };
        private InterfaceC9375j<Uri> mAllowedData = new InterfaceC9375j() { // from class: androidx.core.content.o
            @Override // p243e0.InterfaceC9375j
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.lambda$new$1((Uri) obj);
            }
        };
        private InterfaceC9375j<String> mAllowedTypes = new InterfaceC9375j() { // from class: androidx.core.content.p
            @Override // p243e0.InterfaceC9375j
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.lambda$new$2((String) obj);
            }
        };
        private InterfaceC9375j<String> mAllowedCategories = new InterfaceC9375j() { // from class: androidx.core.content.q
            @Override // p243e0.InterfaceC9375j
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.lambda$new$3((String) obj);
            }
        };
        private InterfaceC9375j<String> mAllowedPackages = new InterfaceC9375j() { // from class: androidx.core.content.r
            @Override // p243e0.InterfaceC9375j
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.lambda$new$4((String) obj);
            }
        };
        private InterfaceC9375j<ComponentName> mAllowedComponents = new InterfaceC9375j() { // from class: androidx.core.content.s
            @Override // p243e0.InterfaceC9375j
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.lambda$new$5((ComponentName) obj);
            }
        };
        private Map<String, InterfaceC9375j<Object>> mAllowedExtras = new HashMap();
        private boolean mAllowClipDataText = false;
        private InterfaceC9375j<Uri> mAllowedClipDataUri = new InterfaceC9375j() { // from class: androidx.core.content.t
            @Override // p243e0.InterfaceC9375j
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.lambda$new$6((Uri) obj);
            }
        };
        private InterfaceC9375j<ClipData> mAllowedClipData = new InterfaceC9375j() { // from class: androidx.core.content.u
            @Override // p243e0.InterfaceC9375j
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.lambda$new$7((ClipData) obj);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowAnyComponent$10(ComponentName componentName) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowClipDataUriWithAuthority$11(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowComponentWithPackage$9(String str, ComponentName componentName) {
            return str.equals(componentName.getPackageName());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowDataWithAuthority$8(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtra$12(Object obj) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtra$13(Class cls, InterfaceC9375j interfaceC9375j, Object obj) {
            return cls.isInstance(obj) && interfaceC9375j.test(cls.cast(obj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtra$14(Object obj) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtraOutput$16(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtraStreamUriWithAuthority$15(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$0(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$1(Uri uri) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$2(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$3(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$4(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$5(ComponentName componentName) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$6(Uri uri) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$7(ClipData clipData) {
            return false;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(String str) {
            C9373h.m58745f(str);
            Objects.requireNonNull(str);
            allowAction(new C0621e(str));
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = new InterfaceC9375j() { // from class: androidx.core.content.j
                @Override // p243e0.InterfaceC9375j
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.lambda$allowAnyComponent$10((ComponentName) obj);
                }
            };
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(String str) {
            C9373h.m58745f(str);
            Objects.requireNonNull(str);
            return allowCategory(new C0621e(str));
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipData(InterfaceC9375j<ClipData> interfaceC9375j) {
            C9373h.m58745f(interfaceC9375j);
            this.mAllowedClipData = this.mAllowedClipData.m58751c(interfaceC9375j);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUri(InterfaceC9375j<Uri> interfaceC9375j) {
            C9373h.m58745f(interfaceC9375j);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.m58751c(interfaceC9375j);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUriWithAuthority(final String str) {
            C9373h.m58745f(str);
            return allowClipDataUri(new InterfaceC9375j() { // from class: androidx.core.content.k
                @Override // p243e0.InterfaceC9375j
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.lambda$allowClipDataUriWithAuthority$11(str, (Uri) obj);
                }
            });
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(final ComponentName componentName) {
            C9373h.m58745f(componentName);
            Objects.requireNonNull(componentName);
            return allowComponent(new InterfaceC9375j() { // from class: androidx.core.content.i
                @Override // p243e0.InterfaceC9375j
                public final boolean test(Object obj) {
                    return componentName.equals((ComponentName) obj);
                }
            });
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponentWithPackage(final String str) {
            C9373h.m58745f(str);
            return allowComponent(new InterfaceC9375j() { // from class: androidx.core.content.f
                @Override // p243e0.InterfaceC9375j
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.lambda$allowComponentWithPackage$9(str, (ComponentName) obj);
                }
            });
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowData(InterfaceC9375j<Uri> interfaceC9375j) {
            C9373h.m58745f(interfaceC9375j);
            this.mAllowedData = this.mAllowedData.m58751c(interfaceC9375j);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowDataWithAuthority(final String str) {
            C9373h.m58745f(str);
            allowData(new InterfaceC9375j() { // from class: androidx.core.content.g
                @Override // p243e0.InterfaceC9375j
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.lambda$allowDataWithAuthority$8(str, (Uri) obj);
                }
            });
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(String str, Class<?> cls) {
            return allowExtra(str, cls, new InterfaceC9375j() { // from class: androidx.core.content.v
                @Override // p243e0.InterfaceC9375j
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.lambda$allowExtra$12(obj);
                }
            });
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(final String str) {
            allowExtra("output", Uri.class, new InterfaceC9375j() { // from class: androidx.core.content.d
                @Override // p243e0.InterfaceC9375j
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.lambda$allowExtraOutput$16(str, (Uri) obj);
                }
            });
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStream(InterfaceC9375j<Uri> interfaceC9375j) {
            allowExtra("android.intent.extra.STREAM", Uri.class, interfaceC9375j);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStreamUriWithAuthority(final String str) {
            C9373h.m58745f(str);
            allowExtra("android.intent.extra.STREAM", Uri.class, new InterfaceC9375j() { // from class: androidx.core.content.m
                @Override // p243e0.InterfaceC9375j
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.lambda$allowExtraStreamUriWithAuthority$15(str, (Uri) obj);
                }
            });
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowFlags(int i10) {
            this.mAllowedFlags = i10 | this.mAllowedFlags;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= HISTORY_STACK_FLAGS;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(String str) {
            C9373h.m58745f(str);
            Objects.requireNonNull(str);
            return allowPackage(new C0621e(str));
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= RECEIVER_FLAGS;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(String str) {
            C9373h.m58745f(str);
            Objects.requireNonNull(str);
            return allowType(new C0621e(str));
        }

        @SuppressLint({"SyntheticAccessor"})
        public IntentSanitizer build() {
            boolean z10 = this.mAllowAnyComponent;
            if ((z10 && this.mAllowSomeComponents) || (!z10 && !this.mAllowSomeComponents)) {
                throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
            }
            IntentSanitizer intentSanitizer = new IntentSanitizer();
            intentSanitizer.mAllowedFlags = this.mAllowedFlags;
            intentSanitizer.mAllowedActions = this.mAllowedActions;
            intentSanitizer.mAllowedData = this.mAllowedData;
            intentSanitizer.mAllowedTypes = this.mAllowedTypes;
            intentSanitizer.mAllowedCategories = this.mAllowedCategories;
            intentSanitizer.mAllowedPackages = this.mAllowedPackages;
            intentSanitizer.mAllowAnyComponent = this.mAllowAnyComponent;
            intentSanitizer.mAllowedComponents = this.mAllowedComponents;
            intentSanitizer.mAllowedExtras = this.mAllowedExtras;
            intentSanitizer.mAllowClipDataText = this.mAllowClipDataText;
            intentSanitizer.mAllowedClipDataUri = this.mAllowedClipDataUri;
            intentSanitizer.mAllowedClipData = this.mAllowedClipData;
            intentSanitizer.mAllowIdentifier = this.mAllowIdentifier;
            intentSanitizer.mAllowSelector = this.mAllowSelector;
            intentSanitizer.mAllowSourceBounds = this.mAllowSourceBounds;
            return intentSanitizer;
        }

        @SuppressLint({"BuilderSetStyle"})
        public <T> Builder allowExtra(String str, final Class<T> cls, final InterfaceC9375j<T> interfaceC9375j) {
            C9373h.m58745f(str);
            C9373h.m58745f(cls);
            C9373h.m58745f(interfaceC9375j);
            return allowExtra(str, new InterfaceC9375j() { // from class: androidx.core.content.h
                @Override // p243e0.InterfaceC9375j
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.lambda$allowExtra$13(cls, interfaceC9375j, obj);
                }
            });
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(InterfaceC9375j<Uri> interfaceC9375j) {
            allowExtra("output", Uri.class, interfaceC9375j);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(InterfaceC9375j<String> interfaceC9375j) {
            C9373h.m58745f(interfaceC9375j);
            this.mAllowedActions = this.mAllowedActions.m58751c(interfaceC9375j);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(InterfaceC9375j<String> interfaceC9375j) {
            C9373h.m58745f(interfaceC9375j);
            this.mAllowedCategories = this.mAllowedCategories.m58751c(interfaceC9375j);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(InterfaceC9375j<ComponentName> interfaceC9375j) {
            C9373h.m58745f(interfaceC9375j);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.m58751c(interfaceC9375j);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(InterfaceC9375j<String> interfaceC9375j) {
            C9373h.m58745f(interfaceC9375j);
            this.mAllowedPackages = this.mAllowedPackages.m58751c(interfaceC9375j);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(InterfaceC9375j<String> interfaceC9375j) {
            C9373h.m58745f(interfaceC9375j);
            this.mAllowedTypes = this.mAllowedTypes.m58751c(interfaceC9375j);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(String str, InterfaceC9375j<Object> interfaceC9375j) {
            C9373h.m58745f(str);
            C9373h.m58745f(interfaceC9375j);
            InterfaceC9375j<Object> interfaceC9375j2 = this.mAllowedExtras.get(str);
            if (interfaceC9375j2 == null) {
                interfaceC9375j2 = new InterfaceC9375j() { // from class: androidx.core.content.l
                    @Override // p243e0.InterfaceC9375j
                    public final boolean test(Object obj) {
                        return IntentSanitizer.Builder.lambda$allowExtra$14(obj);
                    }
                };
            }
            this.mAllowedExtras.put(str, interfaceC9375j2.m58751c(interfaceC9375j));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sanitizeByFiltering$0(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sanitizeByThrowing$1(String str) {
        throw new SecurityException(str);
    }

    private void putExtra(Intent intent, String str, Object obj) {
        if (obj == null) {
            intent.getExtras().putString(str, null);
            return;
        }
        if (obj instanceof Parcelable) {
            intent.putExtra(str, (Parcelable) obj);
            return;
        }
        if (obj instanceof Parcelable[]) {
            intent.putExtra(str, (Parcelable[]) obj);
        } else {
            if (obj instanceof Serializable) {
                intent.putExtra(str, (Serializable) obj);
                return;
            }
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    public Intent sanitize(Intent intent, InterfaceC9366a<String> interfaceC9366a) {
        Intent intent2 = new Intent();
        ComponentName component = intent.getComponent();
        if ((this.mAllowAnyComponent && component == null) || this.mAllowedComponents.test(component)) {
            intent2.setComponent(component);
        } else {
            interfaceC9366a.accept("Component is not allowed: " + component);
            intent2.setComponent(new ComponentName(OsType.ANDROID, "java.lang.Void"));
        }
        String str = intent.getPackage();
        if (str == null || this.mAllowedPackages.test(str)) {
            intent2.setPackage(str);
        } else {
            interfaceC9366a.accept("Package is not allowed: " + str);
        }
        int flags = this.mAllowedFlags | intent.getFlags();
        int i10 = this.mAllowedFlags;
        if (flags == i10) {
            intent2.setFlags(intent.getFlags());
        } else {
            intent2.setFlags(intent.getFlags() & i10);
            interfaceC9366a.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(intent.getFlags() & (~this.mAllowedFlags)));
        }
        String action = intent.getAction();
        if (action == null || this.mAllowedActions.test(action)) {
            intent2.setAction(action);
        } else {
            interfaceC9366a.accept("Action is not allowed: " + action);
        }
        Uri data = intent.getData();
        if (data == null || this.mAllowedData.test(data)) {
            intent2.setData(data);
        } else {
            interfaceC9366a.accept("Data is not allowed: " + data);
        }
        String type = intent.getType();
        if (type == null || this.mAllowedTypes.test(type)) {
            intent2.setDataAndType(intent2.getData(), type);
        } else {
            interfaceC9366a.accept("Type is not allowed: " + type);
        }
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            for (String str2 : categories) {
                if (this.mAllowedCategories.test(str2)) {
                    intent2.addCategory(str2);
                } else {
                    interfaceC9366a.accept("Category is not allowed: " + str2);
                }
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str3 : extras.keySet()) {
                if (str3.equals("android.intent.extra.STREAM") && (this.mAllowedFlags & 1) == 0) {
                    interfaceC9366a.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
                } else if (!str3.equals("output") || ((~this.mAllowedFlags) & 3) == 0) {
                    Object obj = extras.get(str3);
                    InterfaceC9375j<Object> interfaceC9375j = this.mAllowedExtras.get(str3);
                    if (interfaceC9375j == null || !interfaceC9375j.test(obj)) {
                        interfaceC9366a.accept("Extra is not allowed. Key: " + str3 + ". Value: " + obj);
                    } else {
                        putExtra(intent2, str3, obj);
                    }
                } else {
                    interfaceC9366a.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
                }
            }
        }
        Api16Impl.sanitizeClipData(intent, intent2, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, interfaceC9366a);
        if (this.mAllowIdentifier) {
            Api29Impl.setIdentifier(intent2, Api29Impl.getIdentifier(intent));
        } else if (Api29Impl.getIdentifier(intent) != null) {
            interfaceC9366a.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(intent));
        }
        if (this.mAllowSelector) {
            Api15Impl.setSelector(intent2, Api15Impl.getSelector(intent));
        } else if (Api15Impl.getSelector(intent) != null) {
            interfaceC9366a.accept("Selector is not allowed: " + Api15Impl.getSelector(intent));
        }
        if (this.mAllowSourceBounds) {
            intent2.setSourceBounds(intent.getSourceBounds());
        } else if (intent.getSourceBounds() != null) {
            interfaceC9366a.accept("SourceBounds is not allowed: " + intent.getSourceBounds());
        }
        return intent2;
    }

    public Intent sanitizeByFiltering(Intent intent) {
        return sanitize(intent, new InterfaceC9366a() { // from class: androidx.core.content.b
            @Override // p243e0.InterfaceC9366a
            public final void accept(Object obj) {
                IntentSanitizer.lambda$sanitizeByFiltering$0((String) obj);
            }
        });
    }

    public Intent sanitizeByThrowing(Intent intent) {
        return sanitize(intent, new InterfaceC9366a() { // from class: androidx.core.content.a
            @Override // p243e0.InterfaceC9366a
            public final void accept(Object obj) {
                IntentSanitizer.lambda$sanitizeByThrowing$1((String) obj);
            }
        });
    }

    private IntentSanitizer() {
    }
}
