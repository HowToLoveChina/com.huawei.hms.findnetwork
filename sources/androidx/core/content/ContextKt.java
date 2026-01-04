package androidx.core.content;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import p408jw.C10951q;
import p692uw.C13267j;
import tw.InterfaceC13086l;

/* loaded from: classes.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        C13267j.m79677e(context, "<this>");
        C13267j.m79680h(4, CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER);
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(Context context, int i10, int[] iArr, InterfaceC13086l<? super TypedArray, C10951q> interfaceC13086l) throws Resources.NotFoundException {
        C13267j.m79677e(context, "<this>");
        C13267j.m79677e(iArr, "attrs");
        C13267j.m79677e(interfaceC13086l, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, iArr);
        C13267j.m79676d(typedArrayObtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        interfaceC13086l.mo5000c(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, InterfaceC13086l interfaceC13086l, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            attributeSet = null;
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        C13267j.m79677e(context, "<this>");
        C13267j.m79677e(iArr, "attrs");
        C13267j.m79677e(interfaceC13086l, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        C13267j.m79676d(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        interfaceC13086l.mo5000c(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, InterfaceC13086l<? super TypedArray, C10951q> interfaceC13086l) {
        C13267j.m79677e(context, "<this>");
        C13267j.m79677e(iArr, "attrs");
        C13267j.m79677e(interfaceC13086l, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        C13267j.m79676d(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        interfaceC13086l.mo5000c(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }
}
