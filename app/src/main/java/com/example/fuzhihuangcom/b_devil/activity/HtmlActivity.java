package com.example.fuzhihuangcom.b_devil.activity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import com.example.fuzhihuangcom.b_devil.R;
import com.example.fuzhihuangcom.b_devil.view.HtmlImageGetter;

/**
 * Created by fzh on 2018/5/8.
 */

public class HtmlActivity extends BaseActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        struct();
        setContentView(R.layout.activity_html);
        tv = (TextView) findViewById(R.id.tv);

        String html = "<p><img src=\"https://oss.get88.cn/a_a60675e9ae974559863c413571a79dda.png\"></p>";
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());// 设置可滚动
        tv.setMovementMethod(LinkMovementMethod.getInstance());//设置超链接可以打开网页
        tv.setText(Html.fromHtml(html, new HtmlImageGetter(this, tv), null));
    }

//    public static void struct() {
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads().detectDiskWrites().detectNetwork() // or
//                // .detectAll()
//                // for
//                // all
//                // detectable
//                // problems
//                .penaltyLog().build());
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                .detectLeakedSqlLiteObjects() // 探测SQLite数据库操作
//                .penaltyLog() // 打印logcat
//                .penaltyDeath().build());
//    }
}
