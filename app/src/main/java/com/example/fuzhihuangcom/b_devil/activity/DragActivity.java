package com.example.fuzhihuangcom.b_devil.activity;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fuzhihuangcom.b_devil.R;

import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fuzhihuang on 2017/8/7.
 * 平移动画
 */

public class DragActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        final TextView tv_news = (TextView) findViewById(R.id.tv_news);
        final TextView tv_test = (TextView) findViewById(R.id.tv_test);
        final TextView tv_test2 = (TextView) findViewById(R.id.tv_test2);
        Button bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 补间动画
//                TranslateAnimation translateAnimation = new TranslateAnimation(0, 100, 0, 0);
//                translateAnimation.setDuration(1000);
//                translateAnimation.setFillAfter(true);
//                tv_news.startAnimation(translateAnimation);
//                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                        //清除动画
//                        int left = tv_news.getLeft()+ 100;
//                        int top = tv_news.getTop();
//                        int width = tv_news.getWidth();
//                        int height = tv_news.getHeight();
//                        tv_news.clearAnimation();
//                        tv_news.layout(left, top, left+width, top+height);
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//                    }
//                });
                // 属性动画
//                ObjectAnimator animator = ObjectAnimator.ofFloat(tv_news, "translationX", 100);
//                animator.setDuration(1000);
//                animator.start();
                String html = "<p><img src=\\\"https://oss.get88.cn/a_083e26cdf4c84087adf405b471862eff.png\\\"></p><p align=\\\"justify\\\" class=\\\"ql-align-center\\\"><strong>资金低位买入，行情启动在即</strong></p><p align=\\\"justify\\\"><strong>今日指数受到外围市场影响小幅低开，随后低开低走，一度出现较为明显的下跌。但临近午盘，资金出现明显的抄底动作，指数快速拉升，最终两市收出探底回升阳线。截止收盘主板市场上涨0.64%，收于3100.86点。创业板上涨1.4%，收于1826.79点。从趋势上看，主板市场依旧处于底部构建完毕的多头趋势中，创业板指数处于收敛区间震荡。</strong></p>" +
                        "<p align=\\\"justify\\\"><strong>对于主板市场而言，我们对于他的趋势从节前已经确定，底部结构形成，多头趋势开启。这个观点在节后哪怕指数出现明显回调也没有发生改变。并不是说死多头，而是从结构上看一直都是多头的结构没有发生改变。随着今天的上涨，MACD的红脚线开始放大，这是一个比较好的信号。这个位置如果死叉并且创出新低，底部结构就会消失。所以，今天的上涨给结构带来了比较好的助力。</strong></p><p><strong>从个股的表现看，今天券商板块表现不俗，整体出现了较为明显的拉升。券商板块的拉升实际往往都是在行情启动的时候，引领指数的第一波上涨。所以，短期券商上涨能够延续的话对于整体的行情有极大的助力。</strong></p><p><strong>操作上，目前依旧是绩优股的行情。一季度业绩出现大幅度增长的个股开始逐步的发力。像风华高科、江特电机也是早间在圈子中进行提示，一季度业绩大增位置合理的个股，今天表现尚可。目前重点就是寻找业绩大幅增长的白马成长股进行关注。</strong></p><p><img src=\\\"https://oss.get88.cn/a_bf7ef674bc394d0fa4b10ea5074e1035.png\\\"></p><p><strong>对于创业板而言，昨天说过目前是收敛三角，在上方的1875压制位到来前都有较好的买进机会。所以今天回踩支撑位后展开的反弹也在情理之中。但今天的反弹同样不具备趋势改变的作用。目前还是需要重点关注压制位到位后的突破情况，否则创业板智能维持短线操作的策略。</strong></p><p><strong>创业板中，今天软件板块经过持续的回调后展开拉升。说明整体市场稳定的情况下，资金炒作热点的热情较高。所以创业板还是主要关注热点板块的回调机会。芯片、软件等。</strong></p><p><strong> </strong></p><p><strong>投资建议，仅供参考。</strong></p>";
//                Spanned sp = Html.fromHtml(html, new Html.ImageGetter() {
//                    @Override
//                    public Drawable getDrawable(String source) {
//                        Drawable drawable = new Drawable() {
//                            @Override
//                            public void draw(@NonNull Canvas canvas) {
//
//                            }
//
//                            @Override
//                            public void setAlpha(int alpha) {
//
//                            }
//
//                            @Override
//                            public void setColorFilter(@Nullable ColorFilter colorFilter) {
//
//                            }
//
//                            @Override
//                            public int getOpacity() {
//                                return PixelFormat.TRANSPARENT;
//                            }
//                        };
//                        return drawable;
//                    }
//                }, null);
                // 过滤html标签
                Pattern p_html = Pattern.compile(REGEX_HTML, Pattern.CASE_INSENSITIVE);
                Matcher m_html = p_html.matcher(html);

//                tv_test.setText(Html.fromHtml(m2_html.replaceAll("")));
                tv_test.setText(Html.fromHtml(m_html.replaceAll("").replace("<p></p>", "")));

//                tv_test2.setText(Html.fromHtml(html).toString().substring(0,50) + "...");
            }
        });
    }

    private static final String REGEX_HTML = "<img[^>]+>";
}
