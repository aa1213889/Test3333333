package com.example.testtttttttt3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class AnimationTestActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonTranslate,buttonScale,buttonAlpha,buttonRotate,buttonGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);
        init();
    }
    private void init(){
        buttonTranslate = findViewById(R.id.am_btn_translate);
        buttonTranslate.setOnClickListener(this);
        buttonScale = findViewById(R.id.am_btn_scale);
        buttonScale.setOnClickListener(this);
        buttonRotate = findViewById(R.id.am_btn_rotate);
        buttonRotate.setOnClickListener(this);
        buttonAlpha = findViewById(R.id.am_btn_alpha);
        buttonAlpha.setOnClickListener(this);
        buttonGroup = findViewById(R.id.am_btn_group);
        buttonGroup.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.am_btn_translate:
//                Animation translateAnimation = AnimationUtils.loadAnimation(this,R.anim.view_animation);
//                 view.startAnimation(translateAnimation);   //用xml
                Animation translateAnimation = new TranslateAnimation(0,500,0,500);
                translateAnimation.setDuration(3000);
                translateAnimation.setStartOffset(500);
                view.startAnimation(translateAnimation);  //直接用代码
                break;
            case  R.id.am_btn_scale:
//               Animation scaleAnimation = AnimationUtils.loadAnimation(this,R.anim.view_scale_animation);
//               view.startAnimation(scaleAnimation);   //用xml
                Animation scaleAnimation = new ScaleAnimation(0,2,0,2,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                // 参数说明:
// 1. fromX ：动画在水平方向X的起始缩放倍数
// 2. toX ：动画在水平方向X的结束缩放倍数
// 3. fromY ：动画开始前在竖直方向Y的起始缩放倍数
// 4. toY：动画在竖直方向Y的结束缩放倍数
// 5. pivotXType:缩放轴点的x坐标的模式
// 6. pivotXValue:缩放轴点x坐标的相对值
// 7. pivotYType:缩放轴点的y坐标的模式
// 8. pivotYValue:缩放轴点y坐标的相对值

// pivotXType = Animation.ABSOLUTE:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
// pivotXType = Animation.RELATIVE_TO_SELF:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
// pivotXType = Animation.RELATIVE_TO_PARENT:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)
                scaleAnimation.setStartOffset(500);
                scaleAnimation.setDuration(3000);
                view.startAnimation(scaleAnimation);
                break;
            case R.id.am_btn_rotate:
//                Animation rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.view_rotate_animation);
//                view.startAnimation(rotateAnimation);//用xml
                Animation rotateAnimation = new RotateAnimation(-270,270,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(3000);
                view.startAnimation(rotateAnimation);
                break;
            case R.id.am_btn_alpha:
//                Animation alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.view_alpha_animation);
//                view.startAnimation(alphaAnimation); //用xml
                Animation alphaAnimation = new AlphaAnimation(1,-0.5f);
                alphaAnimation.setDuration(3000);
                view.startAnimation(alphaAnimation);
                // 参数说明:
                // 1. fromAlpha:动画开始时视图的透明度(取值范围: -1 ~ 1)
                // 2. toAlpha:动画结束时视图的透明度(取值范围: -1 ~ 1)

                break;
            case R.id.am_btn_group:
                Animation groupAnimation = AnimationUtils.loadAnimation(this,R.anim.view_group_animation);
                view.startAnimation(groupAnimation);//用xml
                break;
                default:
        }
    }
}
