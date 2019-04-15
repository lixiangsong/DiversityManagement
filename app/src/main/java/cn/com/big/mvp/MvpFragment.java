package cn.com.big.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.big.R;
import cn.com.big.mvp.interfaces.IMvpContract;

/**
 * @author lxs
 * @Description:
 * @data 2019/4/16 0016 上午 4:36
 */
public class MvpFragment extends Fragment implements IMvpContract.IView {

    private IMvpContract.Presenter presenter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_mvp_fragment, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);

        return root;
    }

    @Override
    public void setPresenter(IMvpContract.Presenter mpresenter) {
        presenter = mpresenter;
    }

    @Override
    public void setData() {

    }
}
