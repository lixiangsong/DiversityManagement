package cn.com.big.base;

import android.support.v4.app.Fragment;
import android.view.View;


/**
 * Fragment的基类.
 *
 * @author luyh
 * @version 1.0
 * @date 2019/04/11
 */
public abstract class BaseFragment extends Fragment {

    protected View mRootView;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
