package trueandroid.projecta;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by David
 */
public class AthleteSportCategoryAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String, List<String>> Athletes_category;
    private List<String> Athletes_List;

    public AthleteSportCategoryAdapter(Context ctx, HashMap<String, List<String>> Athletes_category, List<String> Athletes_List )
    {
        this.ctx = ctx;
        this.Athletes_category = Athletes_category;
        this.Athletes_List = Athletes_List;

    }

    @Override
    public Object getChild(int parent, int child) {


        return Athletes_category.get(Athletes_List.get(parent)).get(child);
    }

    @Override
    public long getChildId(int parent, int child) {

        return child;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertView,
                             ViewGroup parentview)
    {
        String child_title =  (String) getChild(parent, child);
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout, parentview,false);
        }
        TextView child_textview = (TextView) convertView.findViewById(R.id.child_txt);
        child_textview.setText(child_title);


        return convertView;
    }

    @Override
    public int getChildrenCount(int arg0) {

        return Athletes_category.get(Athletes_List.get(arg0)).size();
    }

    @Override
    public Object getGroup(int arg0) {

        return Athletes_List.get(arg0);
    }

    @Override
    public int getGroupCount() {

        return Athletes_List.size();
    }

    @Override
    public long getGroupId(int arg0) {

        return arg0;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {

        String group_title = (String) getGroup(parent);
        if(convertview == null)
        {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.parent_layout, parentview,false);
        }
        TextView parent_textview = (TextView) convertview.findViewById(R.id.parent_txt);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);
        return convertview;
    }

    @Override
    public boolean hasStableIds() {

        return true;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {

        return true;
    }
}
