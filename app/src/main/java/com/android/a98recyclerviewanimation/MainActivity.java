package com.android.a98recyclerviewanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.SimpleAdapter;

import com.android.a98recyclerviewanimation.Adapter.SimpleRecyclerAdapter;

public class MainActivity extends AppCompatActivity {

    Button btnFallDown,btnSlideFromBottom,btnSlideFromRight;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFallDown = findViewById(R.id.btnFallDown);
        btnSlideFromBottom = findViewById(R.id.btnBottom);
        btnSlideFromRight = findViewById(R.id.btnRight);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnFallDown.setOnClickListener(view -> runAnimation(recyclerView,0));
        btnSlideFromBottom.setOnClickListener(view -> runAnimation(recyclerView,1));
        btnSlideFromRight.setOnClickListener(view -> runAnimation(recyclerView,2));
    }

    private void runAnimation(RecyclerView recyclerView, int type) {
        Context context = recyclerView.getContext();
        LayoutAnimationController controller = null;

        if (type == 0){
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_fall_down);
        }
        else if (type == 1){
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_bottom);
        }
        else if (type == 2){
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_right);
        }

        SimpleRecyclerAdapter adapter = new SimpleRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        //set anim
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}