package com.huawei.android.hicloud.cloudbackup.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.TypefaceSpan;
import android.widget.TextView;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.OnePackegeVouchers;
import com.huawei.cloud.pay.model.RecommendVouchers;
import com.huawei.cloud.pay.model.Voucher;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import p454lj.C11290m;
import p454lj.C11296s;
import p514o9.C11839m;
import p514o9.C11842p;

/* loaded from: classes2.dex */
public class PackageParamUtil {
    private static final int MAX_SYMBOL_CHAR_SIZE = 3;
    private static final int MAX_SYMBOL_MAX_PRICE_CHAR_SIZE = 4;
    private static final int MIN_SYMBOL_MAX_PRICE_CHAR_SIZE = 6;
    private static final String TAG = "PackagePriceUtil";

    public interface VouchersCallBack {
        void onVouchersCallBack(List<Voucher> list);
    }

    private static SpannableStringBuilder buildDiscountsText(Context context, CloudPackage cloudPackage, BigDecimal bigDecimal) {
        int i10;
        String strM67749j = C11290m.m67749j(bigDecimal, cloudPackage.getCurrency(), cloudPackage.getCurrencySymbol());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strM67749j);
        String currency = getCurrency(cloudPackage);
        if (context == null || TextUtils.isEmpty(strM67749j) || TextUtils.isEmpty(currency)) {
            C11839m.m70688i(TAG, "buildPriceDisplayText error, resource is null");
            return spannableStringBuilder;
        }
        try {
            int length = strM67749j.length();
            int iIndexOf = strM67749j.indexOf(currency);
            int length2 = currency.length();
            int iM70840n = C11842p.m70840n(context, 30);
            int iM70840n2 = C11842p.m70840n(context, 16);
            if (iIndexOf >= 0 && length2 >= 0 && length > (i10 = iIndexOf + length2)) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(iM70840n, false), i10, length, 33);
            }
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(iM70840n2, false), 0, iIndexOf + length2, 33);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "buildDiscountsText Exception " + e10.toString());
        }
        return spannableStringBuilder;
    }

    private static SpannableStringBuilder buildPriceDisplayText(CloudPackage cloudPackage, String str, String str2, String str3, Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70688i(TAG, "buildPriceDisplayText error, resource is null");
            return spannableStringBuilder;
        }
        int iIndexOf = str.indexOf(str2);
        int length = str2.length();
        String currencySymbol = cloudPackage.getCurrencySymbol();
        int iIndexOf2 = str.indexOf(currencySymbol, iIndexOf);
        int length2 = currencySymbol.length();
        setRealPriceSpan(spannableStringBuilder, iIndexOf, length, iIndexOf2, length2, context);
        if (!TextUtils.isEmpty(str3)) {
            int iIndexOf3 = str.indexOf(str3, iIndexOf + length);
            setOldPriceSpan(spannableStringBuilder, iIndexOf3, str3.length(), str.indexOf(currencySymbol, iIndexOf3), length2, context);
        }
        return spannableStringBuilder;
    }

    private static String getCurrency(CloudPackage cloudPackage) {
        String currency = cloudPackage.getCurrency();
        return TextUtils.isEmpty(currency) ? cloudPackage.getCurrencySymbol() : "CNY".equalsIgnoreCase(currency) ? "¥" : "";
    }

    public static String getProductName(CloudPackage cloudPackage, GetClientUIConfigResp getClientUIConfigResp) {
        if (getClientUIConfigResp == null) {
            return "";
        }
        int productType = cloudPackage.getProductType();
        return (productType == 5 || productType == 7) ? getClientUIConfigResp.getFixedTimeProductName(cloudPackage.getDurationMonth(), cloudPackage.getDurationUnit()) : (productType == 6 || productType == 8) ? getClientUIConfigResp.getMonthPayProductName(cloudPackage.getDurationMonth(), cloudPackage.getDurationUnit()) : "";
    }

    public static String procWorryFreeDurationText(Context context, CloudPackage cloudPackage) {
        if (cloudPackage == null) {
            C11839m.m70688i(TAG, "procDurationText selectPackage is null.");
            return "";
        }
        int durationMonth = cloudPackage.getDurationMonth();
        return durationMonth == 1 ? context.getResources().getString(R$string.cloudpay_renew_month) : durationMonth == 12 ? context.getResources().getString(R$string.cloudpay_renew_year) : "";
    }

    private static void setOldPriceSpan(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, Context context) {
        if (spannableStringBuilder == null) {
            C11839m.m70687e(TAG, "buildPriceDisplayText error, priceSpan is null");
            return;
        }
        int i14 = i11 + i10;
        spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-regular"), i10, i14, 33);
        int iM70840n = C11842p.m70840n(context, 16);
        spannableStringBuilder.setSpan(new StrikethroughSpan(), i10, i14, 33);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(iM70840n, false), i12, i13 + i12, 33);
    }

    private static void setRealPriceSpan(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, Context context) {
        if (spannableStringBuilder == null) {
            C11839m.m70687e(TAG, "setRealPriceSpan error, priceSpan is null");
            return;
        }
        int iM70840n = C11842p.m70840n(context, 34);
        if (i10 >= 0 && i12 >= 0 && i13 > 0 && i11 > i13) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(iM70840n, false), i10, i11 + i10, 33);
        }
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(C11842p.m70840n(context, 16), false), i12, i13 + i12, 33);
    }

    private static void showDiscountText(Context context, BigDecimal bigDecimal, CloudPackage cloudPackage, TextView textView, List<Voucher> list, VouchersCallBack vouchersCallBack, BigDecimal bigDecimal2) {
        if (bigDecimal == null) {
            C11839m.m70688i(TAG, "showDiscountText discountAmount null");
            return;
        }
        BigDecimal bigDecimalM67833q = C11296s.m67833q(cloudPackage, list, bigDecimal2, bigDecimal);
        if (vouchersCallBack != null) {
            vouchersCallBack.onVouchersCallBack(list);
        }
        textView.setText(buildDiscountsText(context, cloudPackage, bigDecimalM67833q));
    }

    public static void showLabel(TextView textView, String str) {
        if (textView == null) {
            C11839m.m70687e(TAG, "showLabel labelTV is null.");
        } else if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    public static void showPrice(TextView textView, CloudPackage cloudPackage, Context context, BigDecimal bigDecimal) {
        String strM67749j;
        String strM67749j2;
        String string;
        if (textView == null) {
            C11839m.m70687e(TAG, "showPrice tvPrice is null.");
            return;
        }
        if (cloudPackage == null) {
            C11839m.m70687e(TAG, "cloudPackage is null.");
            return;
        }
        String currency = cloudPackage.getCurrency();
        String symbol = cloudPackage.getSymbol();
        BigDecimal spPrice = cloudPackage.getSpPrice();
        BigDecimal price = cloudPackage.getPrice();
        cloudPackage.getProductType();
        if (spPrice == null || spPrice.compareTo(price) >= 0) {
            strM67749j = C11290m.m67749j(C11296s.m67833q(cloudPackage, new ArrayList(), bigDecimal, BigDecimal.ZERO), currency, symbol);
            strM67749j2 = "";
            string = strM67749j;
        } else {
            strM67749j = C11290m.m67749j(C11296s.m67833q(cloudPackage, new ArrayList(), bigDecimal, BigDecimal.ZERO), currency, symbol);
            strM67749j2 = C11290m.m67749j(price, currency, symbol);
            string = context.getString(R$string.cloudpay_package_urse_space_detail, strM67749j, strM67749j2);
        }
        SpannableStringBuilder spannableStringBuilderBuildPriceDisplayText = buildPriceDisplayText(cloudPackage, string, strM67749j, strM67749j2, context);
        textView.setContentDescription(strM67749j);
        textView.setText(spannableStringBuilderBuildPriceDisplayText);
    }

    public static void showReMemark(TextView textView, CloudPackage cloudPackage, GetClientUIConfigResp getClientUIConfigResp) {
        if (textView == null) {
            C11839m.m70687e(TAG, "showRemark tvRemark is null.");
            return;
        }
        int productType = cloudPackage.getProductType();
        String packageTitle = (productType == 8 || productType == 7) ? cloudPackage.getPackageTitle() : (productType != 6 || getClientUIConfigResp == null) ? "" : getClientUIConfigResp.getRecommendBasicPackageRemarak(cloudPackage.getDurationMonth());
        if (TextUtils.isEmpty(packageTitle)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(packageTitle);
        }
    }

    public static void showSelectVouchersPrice(List<Voucher> list, TextView textView, CloudPackage cloudPackage, Context context, VouchersCallBack vouchersCallBack, BigDecimal bigDecimal) {
        if (!C11296s.m67787K() || !C11296s.m67789M(context)) {
            showPrice(textView, cloudPackage, context, bigDecimal);
            return;
        }
        if (list == null || list.size() <= 0 || cloudPackage == null) {
            showPrice(textView, cloudPackage, context, bigDecimal);
            return;
        }
        if (C11296s.m67838v(cloudPackage).compareTo(new BigDecimal(0)) == 0) {
            showPrice(textView, cloudPackage, context, bigDecimal);
            return;
        }
        OnePackegeVouchers onePackegeVouchersM67837u = C11296s.m67837u(list, cloudPackage, bigDecimal);
        if (onePackegeVouchersM67837u == null) {
            showPrice(textView, cloudPackage, context, bigDecimal);
            return;
        }
        RecommendVouchers recommendVouchersM67839w = C11296s.m67839w(cloudPackage, onePackegeVouchersM67837u, bigDecimal);
        List<Voucher> voucherList = recommendVouchersM67839w.getVoucherList();
        if (voucherList == null || voucherList.isEmpty()) {
            showPrice(textView, cloudPackage, context, bigDecimal);
        } else {
            showDiscountText(context, recommendVouchersM67839w.getDiscountAmount(), cloudPackage, textView, voucherList, vouchersCallBack, bigDecimal);
        }
    }
}
