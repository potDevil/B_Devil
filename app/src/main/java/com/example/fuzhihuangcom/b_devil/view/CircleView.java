package com.example.fuzhihuangcom.b_devil.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.fuzhihuangcom.b_devil.R;

/**
 * Created by fuzhihuang on 2017/7/5.
 * 定义圆（静止）
 * 理解onMeasure onDraw Demo
 */

public class CircleView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);// 抗锯齿
    private int mColor = Color.GRAY;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /** 我们为了让自定义控件CircleView更加容易使用，很多情况下我们需要提供自定义属性，
         *  像android:layout_width和android:padding这种以android开头的属性是系统自带
         *  的属性，那么如何添加呢，如下：
         *  1、第一步，在values目录下面创建自定义属性XML，比如attrs.xml，也可以选择类似
         *  于attrs_circle_view.xml等这种以attrs_开头的文件名。
         *  2、在XML文件中声明了一个自定义属性集合"CircleView"，在这个集合里面可以有很多
         *  自定义属性，这里只定义了一个格式为"color"的属性"circle_color"，这里的格式
         *  color指的是颜色。除颜色格式，自定义属性还有其他格式，比如reference是指资源id，
         *  dimension是指尺寸，而像string、integer和boolean这种是指基本数据类型。除了列
         *  举的这些还有其他类型，这里就不一一描述了。
         *  3、在View的构造方法中解析自定义属性的值并做相应的处理。首先加载自定义属性集合
         *  CircleView，接着解析CircleView属性集合中的circle_color这个属性，那么就会选
         *  择红色作为默认的颜色，解析完自定义属性后，通过recycle方法来释放资源，这样CircleView
         *  中所做的工作就完成了。
         *  4、使用自定义属性，必须在布局文件中添加schemas声明：
         *  xmlns:app="http://schemas.android.com/apk/res-auto"
         */
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mColor = ta.getColor(R.styleable.CircleView_circle_color, Color.RED);
        ta.recycle();
        init();
    }

    private void init() {
        mPaint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        /* 1、UNSPECIFIED：父容器不对View有任何限制，EXACTLY对应match_parent，AT_MOST对应wrap_content
         * 2、AT_MOST对应的是wrap_content，我们只有手动设置为一个值（这里是400），如果不设置wrap_content和match_parent效果是一样的
         */
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(400, 400);
        } else if (widthMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(400, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, 400);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();
        final int paddingRight = getPaddingRight();
        final int paddingLeft = getPaddingLeft();
        /* 1、margin值属性是生效的，是因为margin属性是由父容器控制的，所以不需要在CircleView中做特殊处理
         * 2、直接继承View和ViewGroup的控件，padding值是默认无法生效，中心思想就是在绘制的时候考虑到View四周的空白即可，
         *    其中圆心和半径都会考虑到View四周的padding，我们只有减去对应的padding值。
         */
        int width = getWidth() - paddingRight - paddingLeft;
        int height = getHeight() - paddingTop - paddingBottom;
        int radius = Math.min(width, height) / 2;
        canvas.drawCircle(paddingLeft + width / 2, paddingTop + height / 2, radius, mPaint);

       /* mPaint.setStyle(Paint.Style.STROKE);
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;
        RectF oval = new RectF( x, y,
                getWidth() - x, getHeight() - y);
        mPaint.setStrokeWidth(20);                                                                  // 画笔变粗
        canvas.drawArc(oval, -90, 220, false, mPaint);*/
    }
}
