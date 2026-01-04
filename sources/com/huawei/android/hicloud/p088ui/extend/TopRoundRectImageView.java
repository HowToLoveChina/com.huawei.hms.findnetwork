package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

/* loaded from: classes3.dex */
public class TopRoundRectImageView extends HiCloudRoundRectImageView {
    public TopRoundRectImageView(Context context) {
        super(context);
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.HiCloudRoundRectImageView
    public Bitmap getRoundBitmap(Bitmap bitmap, int i10) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        if (this.roundPaint == null) {
            this.roundPaint = new Paint();
        }
        this.roundPaint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        this.roundPaint.setColor(-12434878);
        canvas.drawRect(new Rect(0, i10, width, height), this.roundPaint);
        RectF rectF = new RectF(0.0f, 0.0f, width, i10 * 2);
        float f10 = i10;
        canvas.drawRoundRect(rectF, f10, f10, this.roundPaint);
        this.roundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, this.roundPaint);
        return bitmapCreateBitmap;
    }

    public TopRoundRectImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopRoundRectImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
