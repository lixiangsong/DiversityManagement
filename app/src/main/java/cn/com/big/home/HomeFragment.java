package cn.com.big.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.big.R;
import cn.com.big.base.BaseFragment;
import cn.com.big.home.photo.PhotoActivity;
import cn.com.big.mvp.MvpMainActivity;

/**
 * 首页.
 *
 * @author luyh
 * @version 1.0
 * @date 2019/04/11
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null != mRootView) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (null != parent) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fragment_home, container, false);
            mRootView.findViewById(R.id.photo_ll).setOnClickListener(this);
            mRootView.findViewById(R.id.mvp_tv).setOnClickListener(this);
            initView();
        }
        return mRootView;
    }

    private void initView() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.photo_ll:
                Intent intent = new Intent(getActivity(), PhotoActivity.class);
                startActivity(intent);
                break;
            case R.id.mvp_tv:
                Intent intent2 = new Intent(getActivity(), MvpMainActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
