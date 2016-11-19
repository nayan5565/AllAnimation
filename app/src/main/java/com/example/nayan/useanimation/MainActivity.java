package com.example.nayan.useanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.AlphaModifier;
import com.plattysoft.leonids.modifiers.ScaleModifier;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCloack, btnSlide, btnBlink, btnMove, btnZoom, btnFade, oneShot;
    ImageView imageView;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init() {
        imageView = (ImageView) findViewById(R.id.img);
        btnBlink = (Button) findViewById(R.id.btnBlink);
        btnBlink.setOnClickListener(this);
        oneShot = (Button) findViewById(R.id.btnOneShot);
        oneShot.setOnClickListener(this);
        btnCloack = (Button) findViewById(R.id.btnClock);
        btnCloack.setOnClickListener(this);
        btnFade = (Button) findViewById(R.id.btnFade);
        btnFade.setOnClickListener(this);
        btnMove = (Button) findViewById(R.id.btnMove);
        btnMove.setOnClickListener(this);
        btnSlide = (Button) findViewById(R.id.btnSlide);
        btnSlide.setOnClickListener(this);
        btnZoom = (Button) findViewById(R.id.btnZoom);
        btnZoom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBlink) {
            getAnimation(R.anim.blink);
        } else if (v.getId() == R.id.btnClock) {
            getAnimation(R.anim.clock_wise);
        } else if (v.getId() == R.id.btnOneShot) {
            animi();
        } else if (v.getId() == R.id.btnFade) {
            getAnimation(R.anim.fade);
        } else if (v.getId() == R.id.btnMove) {
            getAnimation(R.anim.move);
        } else if (v.getId() == R.id.btnSlide) {
            getAnimation(R.anim.slide);
        } else if (v.getId() == R.id.btnZoom) {
            getAnimation(R.anim.zoom);
        }

    }

    public void getAnimation(int path) {
        animation = AnimationUtils.loadAnimation(this, path);
//        Picasso.with(this)
//                .load("http://www.radhooni.com/content/backend/uploads/menu/thumbnail/chingri_balachao.jpg")
//                .into(imageView);
        imageView.startAnimation(animation);

    }

    public void animi() {
        new ParticleSystem(this, 4, R.drawable.red_img, 3000)
                .setSpeedByComponentsRange(-0.07f, 0.07f, -0.18f, -0.24f)
                .setAcceleration(0.00003f, 30)
                .setInitialRotationRange(0, 360)
                .addModifier(new AlphaModifier(255, 0, 1000, 3000))
                .addModifier(new ScaleModifier(0.5f, 2f, 0, 1000))
                .oneShot(findViewById(R.id.btnOneShot), 4);

    }
    public void moveAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationX", -280, 280);
        animator.setDuration(9000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "translationX", 280, -280);
        animator1.setDuration(9000);
        animator1.setRepeatCount(ValueAnimator.INFINITE);
        animator1.start();

    }
}
