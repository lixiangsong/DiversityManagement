package cn.com.big.home.photo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.big.R;
import cn.com.big.base.BaseActivity;
import cn.com.big.utils.PhotoSelectUtils;

/**
 * @author lxs
 * @Description: 图片选择
 * @data 2019/4/11 0011 下午 2:22
 */
public class PhotoActivity extends BaseActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.iamgeview)
    ImageView iamgeview;
    @BindView(R.id.back)
    LinearLayout back;
    @BindView(R.id.title_name)
    TextView titleName;

    @Override
    protected int initLayout() {
        return R.layout.activity_photo;
    }

    @Override
    protected void initView() {
        titleName.setText("图片显示");
    }

    @OnClick({R.id.back, R.id.button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.button:
                PhotoSelectUtils.moreSelect(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    Glide.with(PhotoActivity.this).load(selectList.get(0).getPath()).into(iamgeview);
                    break;
            }
        }
    }
}
