package com.example.testtttttttt3;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.testtttttttt3.Fragment.RightFragment;
import com.example.testtttttttt3.Ui.AnimationLoader;
import com.example.testtttttttt3.Util.ToastUtil;

public class AnimationTestActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonTranslate,buttonScale,buttonAlpha,buttonRotate,buttonGroup,buttonListener,buttonActivity,buttonActivity2
            ,buttonFragment,buttonCancel;
    LinearLayout linearLayout;
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
        buttonListener = findViewById(R.id.am_btn_listener);
        buttonListener.setOnClickListener(this);
        buttonActivity = findViewById(R.id.am_btn_activity);
        buttonActivity.setOnClickListener(this);
        buttonActivity2 = findViewById(R.id.am_btn_activity2);
        buttonActivity2.setOnClickListener(this);

        buttonFragment = findViewById(R.id.am_btn_fragment);
        buttonFragment.setOnClickListener(this);
        linearLayout = findViewById(R.id.am_linearLayout);
        buttonCancel = findViewById(R.id.am_fragment_cancel);
        buttonCancel.setOnClickListener(this);
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

//                  AnimationSet groupAnimation = new AnimationSet(true);
//                groupAnimation.setRepeatMode(Animation.RESTART);
//                groupAnimation.setRepeatCount(1);// 设置了循环一次,但无效
//                  Animation setTranslate = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT,-0.5f,
//                          TranslateAnimation.RELATIVE_TO_PARENT,0.5f,
//                          TranslateAnimation.RELATIVE_TO_SELF,0
//                          ,TranslateAnimation.RELATIVE_TO_SELF,0
//
//                          );
//                  setTranslate.setDuration(10000);
//
//                  Animation setAlpha = new AlphaAnimation(1,0);
//                  setAlpha.setDuration(1500);  //持续1.5S
//                  setAlpha.setStartOffset(7000);  //第7S开始
//
//                  Animation setScale = new ScaleAnimation(1,0.5f,1,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                  setScale.setDuration(1000);
//                  setScale.setStartOffset(4000);
//
////                  Animation setRotate = new RotateAnimation(0,360,0.5f,0.5f);
////                  setRotate.setDuration(1000);
////                  setRotate.setRepeatCount(5);
//                Animation setRotate = AnimationUtils.loadAnimation(this,R.anim.view_rotate_animation);
//
//               //  groupAnimation.addAnimation(setTranslate);
//                  groupAnimation.addAnimation(setAlpha);
//                  groupAnimation.addAnimation(setScale);
//                  groupAnimation.addAnimation(setRotate);
//                  view.startAnimation(groupAnimation);
                break;
            case R.id.am_btn_listener:
                Animation groupAnimationListen = AnimationUtils.loadAnimation(this,R.anim.view_group_animation);
                groupAnimationListen.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        ToastUtil.showToast(getApplicationContext(),"onAnimationStart() is execute");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ToastUtil.showToast(getApplicationContext(),"onAnimationEnd() is execute");
                        Intent animationIntent = new Intent(getApplicationContext(),AnimationIntentActivity.class);
                        animationIntent.putExtra("extra_data","监听动画结束后跳转的Activity");
                        startActivity(animationIntent);
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                buttonGroup.startAnimation(groupAnimationListen);
                break;
            case R.id.am_btn_activity:
                Intent intent = new Intent (this,AnimationIntentActivity.class);
                intent.putExtra("extra_data","淡出淡入");
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                break;
            case R.id.am_btn_activity2:
                Intent intent2 = new Intent (this,AnimationIntentActivity.class);
                intent2.putExtra("extra_data","滑动切换");
                startActivity(intent2);
                overridePendingTransition(R.anim.in_from,R.anim.out_to);
                break;
            case R.id.am_btn_fragment:
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout.startAnimation(AnimationLoader.getInAnimation(this));
                break;
            case R.id.am_fragment_cancel:
                linearLayout.setVisibility(View.GONE);
                linearLayout.startAnimation(AnimationLoader.getOutAnimation(this));
                break;
                default:
        }
    }
}
