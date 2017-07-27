package guuilp.github.com.customviewandroid.activity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import guuilp.github.com.customviewandroid.R;
import guuilp.github.com.customviewandroid.customView.Session;

public class MainActivity extends AppCompatActivity {

    private Session session1;
    private Session session2;
    private Session session3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupLayout();

        session3.setTitle(getString(R.string.what_i_will_provide));
        session3.setContent(getString(R.string.medium_text));

        session1.setOnSessionExpanded(new Session.OnSessionExpandedListener() {
            @Override
            public void onSessionExpanded() {
                Toast.makeText(MainActivity.this, "Session 1 was clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupLayout() {
        session1 = (Session) findViewById(R.id.session);
        session2 = (Session) findViewById(R.id.session2);
        session3 = (Session) findViewById(R.id.session3);

        session1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        session2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        session3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }
}
