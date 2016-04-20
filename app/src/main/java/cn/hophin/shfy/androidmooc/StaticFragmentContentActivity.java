package cn.hophin.shfy.androidmooc;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/20.
 */
public class StaticFragmentContentActivity extends Fragment {
    public getSex mGetSex;
    public interface getSex{
        public void say(String sex);
    }

//    @Override
//    public void onAttach(Context context) {
//        mGetSex= (getSex) getActivity();
//        super.onAttach(context);
//    }

    @Override
    public void onAttach(Activity activity) {
        if (UseFragmentActivity.class.getSimpleName().equals(activity.getClass().getSimpleName())) {
            mGetSex= (getSex) activity;
        }
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_static_content, container, false);
        TextView textView = (TextView) view.findViewById(R.id.content_text_view);
        if (container != null) {
            //调用getArguments()方法来获取Bundle对象，既而可以获取Bundle中传递过来的数据
            Bundle bundle=getArguments();
            String userName = bundle.getString(UseFragmentActivity.USER_NAME);
            textView.setText(String.format("This is dynamic fragment\n" +
                    "The userName from activity is %s", userName));
            mGetSex.say("This is back from fragment");
        }else{
            textView.setText("This is a static fragment");
        }
        return view;

    }
}
