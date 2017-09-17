package com.hencoder.hencoderpracticedraw6.practice;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hencoder.hencoderpracticedraw6.R;
import com.hencoder.hencoderpracticedraw6.Utils;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;
    private int currentStatus = 0;
    private int statusCount = 2;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentStatus) {
                    case 0:
                        ObjectAnimator.ofFloat(imageView, "translationX", Utils.dpToPixel(200)).start();
                        ObjectAnimator.ofFloat(imageView, "scaleX", 1).start();
                        ObjectAnimator.ofFloat(imageView, "scaleY", 1).start();
                        ObjectAnimator.ofFloat(imageView, "rotation", 360).start();
                        ObjectAnimator.ofFloat(imageView, "alpha", 1).start();
                        break;
                    case 1:
                        ObjectAnimator.ofFloat(imageView, "translationX", 0).start();
                        ObjectAnimator.ofFloat(imageView, "scaleX", 0).start();
                        ObjectAnimator.ofFloat(imageView, "scaleY", 0).start();
                        ObjectAnimator.ofFloat(imageView, "rotation", 0).start();
                        ObjectAnimator.ofFloat(imageView, "alpha", 0).start();
                        break;
                }
                currentStatus++;
                if (currentStatus == statusCount) {
                    currentStatus = 0;
                }
            }
        });
    }
}
