package com.huawei.phoneservice.faq.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.huawei.phoneservice.faq.R$color;
import com.huawei.phoneservice.faq.response.FaqKnowSearchDetail;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.phoneservice.faq.utils.a */
/* loaded from: classes4.dex */
public class C8411a {
    /* renamed from: a */
    public static FaqKnowSearchDetail m52362a(Context context, FaqKnowSearchDetail faqKnowSearchDetail, List[] listArr) {
        int i10;
        SpannableString spannableString = new SpannableString(faqKnowSearchDetail.m51965a());
        if (m52365d(listArr)) {
            List list = listArr[0];
            List list2 = listArr[1];
            int size = list.size();
            i10 = -1;
            for (int i11 = 0; i11 < size; i11++) {
                int iIntValue = ((Integer) list.get(i11)).intValue();
                if (i10 == -1) {
                    i10 = iIntValue;
                }
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R$color.faq_sdk_label_highlight_text_color_normal)), iIntValue, ((Integer) list2.get(i11)).intValue(), 33);
            }
        } else {
            i10 = -1;
        }
        if (i10 == -1) {
            i10 = Integer.MAX_VALUE;
        }
        faqKnowSearchDetail.m51966c(i10);
        faqKnowSearchDetail.m51967d(spannableString);
        return faqKnowSearchDetail;
    }

    /* renamed from: b */
    public static FaqKnowSearchDetail m52363b(Context context, FaqKnowSearchDetail faqKnowSearchDetail, List[] listArr, boolean z10) {
        int i10;
        SpannableString spannableString = z10 ? new SpannableString(faqKnowSearchDetail.m51976n()) : new SpannableString(faqKnowSearchDetail.m51965a());
        if (m52365d(listArr)) {
            List list = listArr[0];
            List list2 = listArr[1];
            int size = list.size();
            i10 = -1;
            for (int i11 = 0; i11 < size; i11++) {
                int iIntValue = ((Integer) list.get(i11)).intValue();
                if (i10 == -1) {
                    i10 = iIntValue;
                }
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R$color.faq_sdk_label_highlight_text_color_normal)), iIntValue, ((Integer) list2.get(i11)).intValue(), 33);
            }
        } else {
            i10 = -1;
        }
        if (i10 == -1) {
            i10 = Integer.MAX_VALUE;
        }
        faqKnowSearchDetail.m51966c(i10);
        faqKnowSearchDetail.m51970g(spannableString);
        return faqKnowSearchDetail;
    }

    /* renamed from: c */
    public static String m52364c(String str, int i10) {
        if (str.length() <= i10) {
            return str;
        }
        return str.substring(0, i10) + "...";
    }

    /* renamed from: d */
    public static boolean m52365d(List[] listArr) {
        if (listArr != null && listArr.length == 2) {
            List list = listArr[0];
            List list2 = listArr[1];
            if (list != null && list2 != null && !list.isEmpty() && !list2.isEmpty() && list.size() == list2.size()) {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (((Integer) list.get(i10)).intValue() < ((Integer) list2.get(i10)).intValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public static List[] m52366e(String str) {
        List[] listArr = new List[2];
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length && str.contains("<em>") && str.contains("</em>")) {
            int iIndexOf = str.indexOf("<em>", i10);
            int iIndexOf2 = str.indexOf("</em>", i10);
            if (iIndexOf == -1 || iIndexOf2 == -1) {
                break;
            }
            int i12 = iIndexOf2 + 1;
            arrayList.add(Integer.valueOf(iIndexOf - (i11 * 9)));
            int i13 = iIndexOf2 - (i11 * 5);
            i11++;
            arrayList2.add(Integer.valueOf(i13 - (i11 * 4)));
            i10 = i12;
        }
        listArr[0] = arrayList;
        listArr[1] = arrayList2;
        return listArr;
    }
}
