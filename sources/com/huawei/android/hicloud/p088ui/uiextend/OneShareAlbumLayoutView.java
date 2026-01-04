package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.router.data.ShareAlbumInfo;
import com.huawei.hicloud.router.data.SmallPictureInfo;
import java.util.LinkedHashMap;
import java.util.List;
import ne.C11667a;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0224k0;
import p035bk.C1248a;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OneShareAlbumLayoutView extends RelativeLayout implements View.OnClickListener {
    private static final int DEFAULT_POSITON = 0;
    private static final int FIFTH_SHARE_ALBUM_PIC = 4;
    private static final int FIRST_SHARE_ALBUM_PIC = 0;
    private static final int FOURTH_SHARE_ALBUM_PIC = 3;
    private static final int MAX_SHARE_ALBUM_PICS = 7;
    private static final int SECOND_SHARE_ALBUM_PIC = 1;
    private static final int SEVENTH_SHARE_ALBUM_PIC = 6;
    private static final long SEVEN_DAY = 604800000;
    private static final String SHARE_ALBUM_COUNT = "1";
    private static final int SIXTH_SHARE_ALBUM_PIC = 5;
    private static final String TAG = "OneShareAlbumLayoutView";
    private static final int THIRD_SHARE_ALBUM_PIC = 2;
    private ImageView fifthShareAlbumPic;
    private ImageView firstShareAlbumPic;
    private ImageView fourthShareAlbumPic;
    private Context mContext;
    private ShareAlbumInfo mShareAlbumInfo;
    private RelativeLayout oneAlbumShowSomePicContainer;
    private ImageView onePicIV;
    private ImageView onePicIVBg;
    private RelativeLayout oneShareAlbumArea;
    private ImageView secondShareAlbumPic;
    private ImageView seventhShareAlbumPic;
    private TextView shareAlbumEndEditorTimeTv;
    private TextView shareAlbumNameTv;
    private ImageView sixthShareAlbumPic;
    private ImageView thirdShareAlbumPic;

    public OneShareAlbumLayoutView(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    private Bitmap getValidBitmap(String str, int i10, int i11) {
        Bitmap bitmapM1311u = !TextUtils.isEmpty(str) ? C0209d.m1311u(str) : null;
        if (bitmapM1311u == null) {
            bitmapM1311u = C1248a.m7477h(getResources(), i10);
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        return interfaceC9282a != null ? interfaceC9282a.mo58412b0(bitmapM1311u, i11) : bitmapM1311u;
    }

    private void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.one_share_album_layout, (ViewGroup) null);
        addView(viewInflate);
        this.oneShareAlbumArea = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.one_share_album_area);
        this.firstShareAlbumPic = (ImageView) C12809f.m76831d(viewInflate, R$id.first_share_album_pic);
        this.secondShareAlbumPic = (ImageView) C12809f.m76831d(viewInflate, R$id.second_share_album_pic);
        this.thirdShareAlbumPic = (ImageView) C12809f.m76831d(viewInflate, R$id.third_share_album_pic);
        this.fourthShareAlbumPic = (ImageView) C12809f.m76831d(viewInflate, R$id.fourth_share_album_pic);
        this.fifthShareAlbumPic = (ImageView) C12809f.m76831d(viewInflate, R$id.fifth_share_album_pic);
        this.sixthShareAlbumPic = (ImageView) C12809f.m76831d(viewInflate, R$id.sixth_share_album_pic);
        this.seventhShareAlbumPic = (ImageView) C12809f.m76831d(viewInflate, R$id.seventh_share_album_pic);
        this.shareAlbumEndEditorTimeTv = (TextView) C12809f.m76831d(viewInflate, R$id.share_album_end_editor_time_tv);
        this.shareAlbumNameTv = (TextView) C12809f.m76831d(viewInflate, R$id.share_album_name_tv);
        this.oneAlbumShowSomePicContainer = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.one_album_show_some_pic_container);
        this.onePicIV = (ImageView) C12809f.m76831d(viewInflate, R$id.one_album_show_one_pic);
        this.onePicIVBg = (ImageView) C12809f.m76831d(viewInflate, R$id.one_album_show_one_pic_bg);
    }

    private void showImageView(ImageView imageView, Bitmap bitmap) {
        if (imageView == null) {
            C11839m.m70687e(TAG, "showImageView imgView is null.");
        } else if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w(TAG, "click too fast");
            return;
        }
        int id2 = view.getId();
        if ((id2 == R$id.one_album_show_some_pic_container || id2 == R$id.one_album_show_one_pic) && this.mShareAlbumInfo != null) {
            Intent intent = new Intent();
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.setAction("com.huawei.android.cg.activity.ShareAlbumHomePageActivity");
            intent.putExtra("param_album_id", this.mShareAlbumInfo.getAlbumId());
            C0224k0.m1542L(this.mContext, intent);
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("album_count", "1");
            C13225d.m79490f1().m79594r0("CLICK_MAIN_SHARE_CARD", linkedHashMapM79497A);
        }
    }

    public void refreshData(ShareAlbumInfo shareAlbumInfo) {
        String smallPicPath;
        this.mShareAlbumInfo = shareAlbumInfo;
        RelativeLayout relativeLayout = this.oneShareAlbumArea;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            long endEditorTime = shareAlbumInfo.getEndEditorTime();
            List<SmallPictureInfo> smallPicInfos = shareAlbumInfo.getSmallPicInfos();
            if (System.currentTimeMillis() - endEditorTime <= 604800000 || smallPicInfos == null || smallPicInfos.size() < 7) {
                this.oneAlbumShowSomePicContainer.setVisibility(8);
                this.onePicIV.setVisibility(0);
                this.onePicIV.setOnClickListener(this);
                if (smallPicInfos == null || smallPicInfos.isEmpty()) {
                    this.onePicIV.setImageResource(R$drawable.share_album_cover_default);
                    this.onePicIV.setBackgroundResource(R$drawable.share_album_iv_bg);
                    this.onePicIV.setScaleType(ImageView.ScaleType.CENTER);
                    this.onePicIVBg.setVisibility(8);
                } else {
                    SmallPictureInfo smallPictureInfo = smallPicInfos.get(0);
                    showImageView(this.onePicIV, getValidBitmap(smallPictureInfo.getSmallPicPath(), R$drawable.album_cover_default, smallPictureInfo.getRotationId()));
                    this.onePicIVBg.setVisibility(0);
                }
            } else {
                this.oneAlbumShowSomePicContainer.setVisibility(0);
                this.oneAlbumShowSomePicContainer.setOnClickListener(this);
                this.onePicIV.setVisibility(8);
                this.onePicIVBg.setVisibility(8);
                int rotationId = 1;
                for (int i10 = 0; i10 < 7; i10++) {
                    if (i10 < smallPicInfos.size()) {
                        SmallPictureInfo smallPictureInfo2 = smallPicInfos.get(i10);
                        smallPicPath = smallPictureInfo2.getSmallPicPath();
                        rotationId = smallPictureInfo2.getRotationId();
                    } else {
                        smallPicPath = "";
                    }
                    switch (i10) {
                        case 0:
                            showImageView(this.firstShareAlbumPic, getValidBitmap(smallPicPath, R$drawable.album_cover_default, rotationId));
                            break;
                        case 1:
                            Bitmap validBitmap = getValidBitmap(smallPicPath, R$drawable.album_cover_default, rotationId);
                            int width = validBitmap.getWidth();
                            int height = validBitmap.getHeight();
                            int i11 = width / 2;
                            showImageView(this.secondShareAlbumPic, C11842p.m70820i(validBitmap, i11, height / 3, i11, (height * 2) / 3));
                            break;
                        case 2:
                            Bitmap validBitmap2 = getValidBitmap(smallPicPath, R$drawable.album_cover_default, rotationId);
                            int width2 = validBitmap2.getWidth();
                            int height2 = validBitmap2.getHeight();
                            showImageView(this.thirdShareAlbumPic, C11842p.m70820i(validBitmap2, 0, (height2 * 4) / 5, width2, height2 / 5));
                            break;
                        case 3:
                            Bitmap validBitmap3 = getValidBitmap(smallPicPath, R$drawable.album_cover_default, rotationId);
                            int width3 = validBitmap3.getWidth();
                            int height3 = validBitmap3.getHeight();
                            showImageView(this.fourthShareAlbumPic, C11842p.m70820i(validBitmap3, 0, height3 / 3, width3 / 2, (height3 * 2) / 3));
                            break;
                        case 4:
                            Bitmap validBitmap4 = getValidBitmap(smallPicPath, R$drawable.album_cover_default, rotationId);
                            showImageView(this.fifthShareAlbumPic, C11842p.m70820i(validBitmap4, 0, 0, validBitmap4.getWidth() / 2, (validBitmap4.getHeight() * 2) / 3));
                            break;
                        case 5:
                            Bitmap validBitmap5 = getValidBitmap(smallPicPath, R$drawable.album_cover_default, rotationId);
                            showImageView(this.sixthShareAlbumPic, C11842p.m70820i(validBitmap5, 0, 0, validBitmap5.getWidth(), validBitmap5.getHeight() / 5));
                            break;
                        case 6:
                            Bitmap validBitmap6 = getValidBitmap(smallPicPath, R$drawable.album_cover_default, rotationId);
                            int width4 = validBitmap6.getWidth() / 2;
                            showImageView(this.seventhShareAlbumPic, C11842p.m70820i(validBitmap6, width4, 0, width4, (validBitmap6.getHeight() * 2) / 3));
                            break;
                        default:
                            C11839m.m70687e(TAG, "showOneShareAlbumArea err index = " + i10);
                            break;
                    }
                }
            }
            TextView textView = this.shareAlbumEndEditorTimeTv;
            if (textView != null) {
                textView.setText(C11667a.m69662d(C0213f.m1377a(), shareAlbumInfo.getEndEditorTime()));
            }
            TextView textView2 = this.shareAlbumNameTv;
            if (textView2 != null) {
                textView2.setText(shareAlbumInfo.getAlbumName());
            }
        }
    }

    public OneShareAlbumLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView(context);
    }
}
