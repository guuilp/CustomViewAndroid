package CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import guuilp.github.com.customviewandroid.R;

/**
 * Created by Guilherme on 23/07/2017.
 */

public class Session extends LinearLayout {

    private TextView title;
    private TextView content;

    private String titleText;
    private String contentText;

    public Session(Context context) {
        super(context);
        setupView(context, null);
    }

    public Session(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupView(context, attrs);
    }

    public Session(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView(context, attrs);
    }

    private void setupView(Context context, AttributeSet attrs){
        setupCustomAtributes(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.layout_session, this);

        title = (TextView) view.findViewById(R.id.title);
        content = (TextView) view.findViewById(R.id.content);

        setTitle(titleText);
        setContent(contentText);
    }

    public void setTitle(String newTitleText){
        titleText = newTitleText;

        title.setText(titleText);
    }

    public void setContent(String newContentText){
        contentText = newContentText;

        content.setText(contentText);
    }

    private void setupCustomAtributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.Session,
                    0, 0);
            try {
                titleText = a.getString(R.styleable.Session_title);
                contentText = a.getString(R.styleable.Session_content);
            } catch (Exception e) {
                Log.e("Session", "There was an error loading attributes.");
            } finally {
                a.recycle();
            }
        }
    }
}
