package guuilp.github.com.customviewandroid;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import CustomView.Session;

public class MainActivity extends AppCompatActivity {

    private Session session;
    private Session session2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = (Session) findViewById(R.id.session);
        session2 = (Session) findViewById(R.id.session2);

        session.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        session2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        session.setOnSessionExpanded(new Session.OnSessionExpandedListener() {
            @Override
            public void onSessionExpanded() {
                Toast.makeText(MainActivity.this, "Session 1 foi clicada!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
