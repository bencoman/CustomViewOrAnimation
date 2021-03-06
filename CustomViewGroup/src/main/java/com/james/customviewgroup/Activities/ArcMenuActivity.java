package com.james.customviewgroup.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.james.customviewgroup.R;
import com.james.customviewgroup.customview.ArcMenu;

public class ArcMenuActivity extends ActionBarActivity {

    private ArcMenu mArcMenuLeftTop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc_menu);
        mArcMenuLeftTop = (ArcMenu) findViewById(R.id.id_arcmenu1);
        //动态添加一个MenuItem
        ImageView people = new ImageView(this);
        people.setImageResource(R.drawable.composer_with);
        people.setTag("People");
        mArcMenuLeftTop.addView(people);


        mArcMenuLeftTop
                .setOnMenuItemClickListener(new ArcMenu.OnMenuItemClickListener()
                {
                    @Override
                    public void onClick(View view, int pos)
                    {
                        Toast.makeText(ArcMenuActivity.this,
                                pos + ":" + view.getTag(), Toast.LENGTH_SHORT)
                                .show();
                    }
                });
    }
}
