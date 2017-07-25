package guuilp.github.com.customviewandroid;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import CustomView.Session;

public class MainActivity extends AppCompatActivity {

    private Session session;
    private Session session2;
    private Session session3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupLayout();

        session3.setTitle(getString(R.string.what_i_will_provide));
        session3.setContent(getString(R.string.medium_text));

        session.setOnSessionExpanded(new Session.OnSessionExpandedListener() {
            @Override
            public void onSessionExpanded() {
                Toast.makeText(MainActivity.this, "Session 1 foi clicada!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupLayout() {
        session = (Session) findViewById(R.id.session);
        session2 = (Session) findViewById(R.id.session2);
        session3 = (Session) findViewById(R.id.session3);

        session.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        session2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        session3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }
}
