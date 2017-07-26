package guuilp.github.com.customviewandroid.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import guuilp.github.com.customviewandroid.R;

/**
 * Created by Guilherme on 23/07/2017.
 */

public class ExpandableTextView extends android.support.v7.widget.AppCompatTextView{

    private String originalText;
    private int trimLength;

    private boolean firstCall = true;
    private boolean mBroadcasting = false;

    private OnTextViewExpandedListener mOnTextViewExpandedListener;

    public ExpandableTextView(Context context) {
        super(context);
        initControl(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);
    }

    public ExpandableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl(context, attrs);
    }

    private void initControl(Context context, AttributeSet attrs){
        setupCustomAtributes(context, attrs);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(originalText);

                if (mBroadcasting) {
                    return;
                }

                mBroadcasting = true;

                if (mOnTextViewExpandedListener != null) {
                    mOnTextViewExpandedListener.onTextViewExpanded();
                }

                mBroadcasting = false;

            }
        });
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (text.length() > trimLength) {

            if (firstCall) {
                originalText = text.toString();

                SpannableStringBuilder reducedText = new SpannableStringBuilder();

                reducedText.append(text.toString().substring(0, Math.min(text.length(), trimLength)).trim());
                reducedText.append("... ");

                String blue = getContext().getString(R.string.read_more);
                SpannableString blueSpannable = new SpannableString(blue);
                blueSpannable.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.colorPrimary)), 0, blue.length(), 0);
                reducedText.append(blueSpannable);

                firstCall = false;

                super.setText(reducedText, BufferType.SPANNABLE);
            } else {
                super.setText(text, type);
            }
        } else {
            super.setText(text, type);
        }
    }

    private void setupCustomAtributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.ExpandableTextView,
                    0, 0);
            try {
                trimLength = a.getInt(R.styleable.ExpandableTextView_trimLength, 50);
            } catch (Exception e) {
                Log.e("ExpandableTextView", "There was an error loading attributes.");
            } finally {
                a.recycle();
            }
        }
    }

    public interface OnTextViewExpandedListener {
        void onTextViewExpanded();
    }

    public void setOnTextViewExpandedListener(OnTextViewExpandedListener listener){
        mOnTextViewExpandedListener = listener;
    }

}