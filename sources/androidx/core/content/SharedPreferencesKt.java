package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.huawei.openalliance.p169ad.constant.Constants;
import p408jw.C10951q;
import p692uw.C13267j;
import tw.InterfaceC13086l;

/* loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences sharedPreferences, boolean z10, InterfaceC13086l<? super SharedPreferences.Editor, C10951q> interfaceC13086l) {
        C13267j.m79677e(sharedPreferences, "<this>");
        C13267j.m79677e(interfaceC13086l, Constants.CONTENT_SERVER_REALM);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        C13267j.m79676d(editorEdit, "editor");
        interfaceC13086l.mo5000c(editorEdit);
        if (z10) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z10, InterfaceC13086l interfaceC13086l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        C13267j.m79677e(sharedPreferences, "<this>");
        C13267j.m79677e(interfaceC13086l, Constants.CONTENT_SERVER_REALM);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        C13267j.m79676d(editorEdit, "editor");
        interfaceC13086l.mo5000c(editorEdit);
        if (z10) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
