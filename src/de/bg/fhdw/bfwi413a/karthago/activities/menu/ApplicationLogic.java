package de.bg.fhdw.bfwi413a.karthago.activities.menu;

import de.bg.fhdw.bfwi413a.karthago.Navigation;

public class ApplicationLogic {
	
	private Gui mGui;
	private Data mData;
	
	public ApplicationLogic(Gui gui){
		mGui = gui;
		initGui();
	}
	
	private void initGui(){
		
	}

	public void onButtonClicked(int i) {
		switch ( i ) {
		case 1:   // Call CardFile1
			Navigation.startActivitySelection(mData.getmActivity());
			break;
		case 2:   // Call CardFile2
			Navigation.startActivityConfig(mData.getmActivity());
			break;
		case 3:   // Call CardFile3
			Navigation.startActivityStatistics(mData.getmActivity());
			break;
		case 4:   // Call CardFile4
			Navigation.startActivityLogin(mData.getmActivity());;
			break;
		}
	}
}
