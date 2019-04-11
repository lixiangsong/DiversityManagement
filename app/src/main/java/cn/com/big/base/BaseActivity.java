package cn.com.big.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


/**
 * Activity的基类.
 *
 * @author luyh
 * @version 1.0
 * @date 2019/04/11
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected BaseActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        // 设置布局
        setContentView(initLayout());
        ButterKnife.bind(this);
        // 设置初始化视图和数据
        initView();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    /**
     * 初始化布局
     *
     * @return
     */
    protected abstract int initLayout();
    /**
     * 初始化操作(视图或数据)
     */
    protected abstract void initView();

    /**
     * 不带参数的跳转
     *
     * @param clazz 跳转到的目标类
     */
    protected void readyGo(@Nullable Class<?> clazz) {
        Intent intent = new Intent(mActivity, clazz);
        startActivity(intent);
    }

    /**
     * 带参数的跳转
     *
     * @param clazz  跳转到的目标类
     * @param bundle 参数
     */
    protected void readyGo(@Nullable Class<?> clazz, @Nullable Bundle bundle) {
        Intent intent = new Intent(mActivity, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 跳转然后退出当前页
     *
     * @param clazz 跳转到的目标类
     */
    protected void readyGoThenKill(@Nullable Class<?> clazz) {
        Intent intent = new Intent(mActivity, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * 带参数跳转然后退出当前页
     *
     * @param clazz  跳转到的目标类
     * @param bundle 参数
     */
    protected void readyGoThenKill(@Nullable Class<?> clazz, @Nullable Bundle bundle) {
        Intent intent = new Intent(mActivity, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * 跳转且返回结果
     *
     * @param clazz       跳转到的目标类
     * @param requestCode 请求码
     */
    protected void readyGoForResult(@Nullable Class<?> clazz, int requestCode) {
        Intent intent = new Intent(mActivity, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * 带参数跳转且返回结果
     *
     * @param clazz       跳转到的目标类
     * @param requestCode 请求码
     * @param bundle      参数
     */
    protected void readyGoForResult(@Nullable Class<?> clazz, int requestCode, @Nullable Bundle bundle) {
        Intent intent = new Intent(mActivity, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
