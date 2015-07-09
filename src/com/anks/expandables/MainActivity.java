package com.anks.expandables;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.adapter.GroupListAdapter;
import com.model.ChildModel;
import com.model.ParentModel;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ArrayList<ParentModel> mainmodel = new ArrayList<ParentModel>();

		for (int i = 0; i < 10; i++) {

			ParentModel model = new ParentModel();

			model.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/4/4e/Washington_Square_Arch_by_David_Shankbone.jpg");
			model.setOrgName("www.stpauls-delhi.com");
			model.setTotalScore(500);

			ArrayList<ChildModel> cmainmodel = new ArrayList<ChildModel>();

			for (int j = 0; j < 5; j++) {

				ChildModel cmodel = new ChildModel();
				cmodel.setImageUrl("https://stepupandlive.files.wordpress.com/2014/09/3d-animated-frog-image.jpg");
				cmodel.setName("Jonny Mr .X BABA Rocks");
				cmodel.setScore(100);

				cmainmodel.add(cmodel);
			}

			model.setChildmodel(cmainmodel);

			mainmodel.add(model);
		}

		ExpandableListView list = (ExpandableListView) findViewById(R.id.list);

		GroupListAdapter adapter = new GroupListAdapter(mainmodel);

		adapter.setInflater(
				(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),
				this);

		list.setAdapter(adapter);

		Button share_button = (Button) findViewById(R.id.share_button);

		share_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				shareThing("This is dummy share");

			}
		});

	}

	private void shareThing(String sharetext) {

		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, sharetext);
		sendIntent.setType("text/plain");
		startActivity(sendIntent);

	}

}
