package p802y8;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.android.p073ds.R$string;
import p015ak.C0213f;

/* renamed from: y8.a */
/* loaded from: classes2.dex */
public class C13917a implements InputFilter {
    /* renamed from: a */
    public final boolean m83424a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (m83425b(str.codePointAt(i10))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final boolean m83425b(int i10) {
        if ((i10 != 0 && i10 != 9 && i10 != 10 && i10 != 13 && ((i10 < 32 || i10 > 55295) && ((i10 < 57344 || i10 > 65533) && i10 < 65536))) || i10 == 169 || i10 == 174 || i10 == 8419 || i10 == 8482 || i10 == 8986 || i10 == 9000 || i10 == 12336 || i10 == 65039) {
            return true;
        }
        if (i10 >= 9193 && i10 <= 9210) {
            return true;
        }
        if (i10 < 9654 || i10 > 10175) {
            return i10 >= 126976 && i10 <= 131071;
        }
        return true;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        if (charSequence == null || !m83424a(charSequence.toString())) {
            return null;
        }
        Toast.makeText(C0213f.m1377a(), C0213f.m1377a().getString(R$string.wish_list_input_tips_emo), 0).show();
        return "";
    }
}
