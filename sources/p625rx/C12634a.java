package p625rx;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.LocaleList;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.Window;
import com.huawei.ohos.localability.R$string;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: rx.a */
/* loaded from: classes9.dex */
public class C12634a {

    /* renamed from: a */
    public static final Pattern f58079a = Pattern.compile("%([0-9]+)\\$s");

    /* renamed from: rx.a$a */
    public static class a implements DialogInterface.OnShowListener {

        /* renamed from: a */
        public final /* synthetic */ Window f58080a;

        public a(Window window) {
            this.f58080a = window;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.f58080a.clearFlags(8);
        }
    }

    /* renamed from: a */
    public static SpannableStringBuilder m76166a(Context context, List<String> list, SpannableStringBuilder spannableStringBuilder, TypefaceSpan typefaceSpan, ForegroundColorSpan foregroundColorSpan) {
        int size = list.size();
        if (size > 11) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(it.next());
            spannableStringBuilder2.setSpan(CharacterStyle.wrap(typefaceSpan), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder2.setSpan(CharacterStyle.wrap(foregroundColorSpan), 0, spannableStringBuilder2.length(), 33);
            arrayList.add(spannableStringBuilder2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        switch (size) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                if (size == 7) {
                    break;
                } else if (size == 8) {
                    break;
                } else if (size == 9) {
                    break;
                } else if (size == 10) {
                    break;
                } else if (size == 11) {
                    break;
                }
                break;
        }
        return null;
    }

    /* renamed from: b */
    public static SpannableStringBuilder m76167b(CharSequence charSequence, Object... objArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int length = 0;
        while (length < spannableStringBuilder.length()) {
            Matcher matcher = f58079a.matcher(spannableStringBuilder);
            if (!matcher.find(length)) {
                break;
            }
            int iStart = matcher.start();
            int iEnd = matcher.end();
            Object obj = objArr[Integer.parseInt(matcher.group(1)) - 1];
            CharSequence charSequence2 = obj instanceof SpannableStringBuilder ? (SpannableStringBuilder) obj : (CharSequence) obj;
            spannableStringBuilder.replace(iStart, iEnd, charSequence2);
            length = iStart + charSequence2.length();
        }
        return spannableStringBuilder;
    }

    /* renamed from: c */
    public static String m76168c(Context context, List<String> list) {
        int size = list.size();
        if (size > 5) {
            return null;
        }
        Locale localeM76169d = m76169d(context);
        if (size == 1) {
            return String.format(localeM76169d, context.getResources().getString(R$string.phone_permission_list_1), list.get(0));
        }
        if (size == 2) {
            return String.format(localeM76169d, context.getResources().getString(R$string.phone_permission_list_2), list.get(0), list.get(1));
        }
        if (size == 3) {
            return String.format(localeM76169d, context.getResources().getString(R$string.phone_permission_list_3), list.get(0), list.get(1), list.get(2));
        }
        if (size == 4) {
            return String.format(localeM76169d, context.getResources().getString(R$string.phone_permission_list_4), list.get(0), list.get(1), list.get(2), list.get(3));
        }
        if (size != 5) {
            return null;
        }
        return String.format(localeM76169d, context.getResources().getString(R$string.phone_permission_list_5), list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
    }

    /* renamed from: d */
    public static Locale m76169d(Context context) {
        return context != null ? LocaleList.getDefault().get(0) : Locale.getDefault();
    }

    /* renamed from: e */
    public static void m76170e(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        window.setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        window.addFlags(8);
        dialog.setOnShowListener(new a(window));
    }
}
