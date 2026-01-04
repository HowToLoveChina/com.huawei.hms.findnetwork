package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import p015ak.C0209d;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class GifImageView extends ImageView {
    private static final String TAG = "GifImageView";
    private PaintFlagsDrawFilter drawFilter;
    private int imageHeight;
    private int imageWidth;
    private boolean mCanStartGif;
    private int mFlag;
    private Handler mHandler;
    private long moveBegin;
    private Movie movie;
    private boolean needStopWhenGifFinished;

    public GifImageView(Context context) {
        super(context);
        this.needStopWhenGifFinished = false;
        this.mFlag = 0;
        this.mCanStartGif = true;
    }

    private boolean playGif(Canvas canvas, boolean z10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.moveBegin == 0) {
            this.moveBegin = jUptimeMillis;
        }
        int iDuration = this.movie.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        long j10 = jUptimeMillis - this.moveBegin;
        if (z10 && j10 >= iDuration) {
            j10 = iDuration - 1;
        }
        this.movie.setTime((int) (j10 % iDuration));
        drawMovie(canvas, this.movie);
        if (j10 < iDuration - 1) {
            return false;
        }
        this.moveBegin = 0L;
        return true;
    }

    private void sendGifFinishMsg() {
        Handler handler = this.mHandler;
        if (handler != null) {
            Message messageObtain = Message.obtain(handler);
            messageObtain.what = 10;
            messageObtain.arg1 = this.mFlag;
            this.mHandler.sendMessage(messageObtain);
        }
    }

    public void drawMovie(Canvas canvas, Movie movie) {
        if (this.imageWidth <= 0 || this.imageHeight <= 0) {
            return;
        }
        float width = getWidth();
        float height = getHeight();
        float f10 = width / this.imageWidth;
        float f11 = height / this.imageHeight;
        if (f10 > f11) {
            f10 = f11;
        }
        canvas.scale(f10, f10);
        movie.draw(canvas, ((width - (this.imageWidth * f10)) / 2.0f) / f10, ((height - (this.imageHeight * f10)) / 2.0f) / f10);
    }

    public boolean getCanStartGif() {
        return this.mCanStartGif;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.drawFilter == null) {
            this.drawFilter = new PaintFlagsDrawFilter(0, 3);
        }
        canvas.setDrawFilter(this.drawFilter);
        Movie movie = this.movie;
        if (movie == null) {
            super.onDraw(canvas);
            return;
        }
        if (!this.mCanStartGif) {
            drawMovie(canvas, movie);
        } else if (playGif(canvas, this.needStopWhenGifFinished) && this.needStopWhenGifFinished) {
            sendGifFinishMsg();
        } else {
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void registerHandler(Handler handler, int i10) {
        this.mHandler = handler;
        this.mFlag = i10;
    }

    public void resetGif() {
        setCanStartGif(false);
        Movie movie = this.movie;
        if (movie != null) {
            this.moveBegin = 0L;
            movie.setTime(0);
            invalidate();
        }
    }

    public boolean restartGif() {
        if (!this.needStopWhenGifFinished) {
            C11839m.m70689w(TAG, "loop gif play, no need restart");
            return false;
        }
        Movie movie = this.movie;
        if (movie == null) {
            return false;
        }
        this.moveBegin = 0L;
        movie.setTime(0);
        invalidate();
        return true;
    }

    public void setCanStartGif(boolean z10) {
        this.mCanStartGif = z10;
    }

    public void setImageResource(Movie movie, int i10) throws IOException {
        Movie movie2;
        InputStream inputStreamOpenRawResource = null;
        try {
            try {
                if (movie == null) {
                    Resources resources = getResources();
                    if (resources == null) {
                        C11839m.m70687e(TAG, "resources is null");
                        super.setImageResource(i10);
                        return;
                    } else {
                        inputStreamOpenRawResource = resources.openRawResource(i10);
                        this.movie = Movie.decodeStream(inputStreamOpenRawResource);
                    }
                } else {
                    this.movie = movie;
                }
                movie2 = this.movie;
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "setImageResource exceptiom:" + e10.toString());
            }
            if (movie2 == null) {
                super.setImageResource(i10);
            } else {
                this.imageWidth = movie2.width();
                this.imageHeight = this.movie.height();
            }
        } finally {
            C0209d.m1263i(null);
        }
    }

    public void setImageResourceAndStart(Movie movie, int i10) throws IOException {
        setImageResource(movie, i10);
        invalidate();
    }

    public void setNeedStopWhenGifFinish(boolean z10) {
        this.needStopWhenGifFinished = z10;
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.needStopWhenGifFinished = false;
        this.mFlag = 0;
        this.mCanStartGif = true;
    }
}
