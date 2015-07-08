package fragmenttabhost.phlin.demo.fragmenttabhost;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MyFragmentActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;

    private Class fragmentArray[] = {
            FragmentOne.class,
            FragmentTwo.class,
            FragmentThree.class,};
    private int iconArray[] = {
            R.drawable.icon_http,
            R.drawable.icon_database,
            R.drawable.icon_btimap};
    private String titleArray[] = {
            "One",
            "Two",
            "Three"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabHost=(FragmentTabHost)findViewById(R.id.tabhost);
        setupTabView();
    }

    private void setupTabView() {
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null);

        int count = fragmentArray.length;

        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(titleArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_item);
        }

    }

    private View getTabItemView(int index) {

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        /**
         * Obtains the LayoutInflater from the given context.

         public static LayoutInflater from(Context context) {
         LayoutInflater LayoutInflater =
         (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         if (LayoutInflater == null) {
         throw new AssertionError("LayoutInflater not found.");
         }
         return LayoutInflater;
         }*/
        View view = layoutInflater.inflate(R.layout.tab_bottom_nav, null);

        XmlResourceParser parser = this.getResources().getLayout(R.layout.tab_bottom_nav);
        final AttributeSet attrs = Xml.asAttributeSet(parser);
        final String name = parser.getName();
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
        imageView.setImageResource(iconArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.tv_icon);
        textView.setText(titleArray[index]);

        return view;
    }
}
