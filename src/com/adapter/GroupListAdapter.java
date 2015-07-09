package com.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anks.expandables.R;
import com.model.ChildModel;
import com.model.ParentModel;
import com.squareup.picasso.Picasso;
import com.utils.CircleTransform;
import com.utils.Utils;

public class GroupListAdapter extends BaseExpandableListAdapter {

	private Activity activity;
	private LayoutInflater inflater;
	private ArrayList<ParentModel> parentItems;

	public GroupListAdapter(ArrayList<ParentModel> parents) {

		this.parentItems = parents;

	}

	public void setInflater(LayoutInflater inflater, Activity activity) {

		this.inflater = inflater;
		this.activity = activity;

	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return parentItems.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return (parentItems.get(groupPosition)).getChildmodel().size();

	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	private static class ViewHolderParent {
		ImageView group_image;
		TextView group_name, group_score;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ParentModel model = parentItems.get(groupPosition);

		// Check if an existing view is being reused, otherwise inflate the view
		ViewHolderParent viewHolder; // view lookup cache stored in tag

		if (convertView == null) {

			viewHolder = new ViewHolderParent();
			convertView = inflater.inflate(R.layout.group, null);

			viewHolder.group_image = (ImageView) convertView
					.findViewById(R.id.group_image);

			viewHolder.group_image.requestLayout();

			viewHolder.group_image.getLayoutParams().height = Utils
					.getImageHeight(activity) / 4;

			viewHolder.group_name = (TextView) convertView
					.findViewById(R.id.group_name);
			viewHolder.group_score = (TextView) convertView
					.findViewById(R.id.group_score);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolderParent) convertView.getTag();
		}

		viewHolder.group_name.setText(Html.fromHtml(model.getOrgName()));

		viewHolder.group_score
				.setText(Html.fromHtml("" + model.getTotalScore()));

		try {

			String image_url = model.getImageUrl();
			image_url = image_url.replace(" ", "%20");

			Picasso.with(activity).load(image_url)
					.transform(new CircleTransform()).fit()
					.into(viewHolder.group_image);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return convertView;

	}

	private static class ViewHolderChild {
		ImageView child_image;
		TextView child_name, child_score;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ChildModel model = (parentItems.get(groupPosition)).getChildmodel()
				.get(childPosition);

		// Check if an existing view is being reused, otherwise inflate the view
		ViewHolderChild viewHolder; // view lookup cache stored in tag

		if (convertView == null) {

			viewHolder = new ViewHolderChild();
			convertView = inflater.inflate(R.layout.child, null);

			viewHolder.child_image = (ImageView) convertView
					.findViewById(R.id.child_image);

			viewHolder.child_image.requestLayout();

			viewHolder.child_image.getLayoutParams().height = Utils
					.getImageHeight(activity) / 4;

			viewHolder.child_name = (TextView) convertView
					.findViewById(R.id.child_name);
			viewHolder.child_score = (TextView) convertView
					.findViewById(R.id.child_score);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolderChild) convertView.getTag();
		}

		viewHolder.child_name.setText(Html.fromHtml(model.getName()));

		viewHolder.child_score.setText(Html.fromHtml("" + model.getScore()));

		try {

			String image_url = model.getImageUrl();
			image_url = image_url.replace(" ", "%20");

			Picasso.with(activity).load(image_url)
					.transform(new CircleTransform()).fit()
					.into(viewHolder.child_image);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return convertView;

	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
