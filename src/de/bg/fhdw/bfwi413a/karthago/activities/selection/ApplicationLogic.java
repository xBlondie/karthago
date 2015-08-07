// Die ApplicationLogic verwaltet, was passiert, wenn man die Buttons benutzt

package de.bg.fhdw.bfwi413a.karthago.activities.selection;

public class ApplicationLogic {
	
	private Gui mGui;
	private Data mData;
	
	public ApplicationLogic(Gui gui, Data data) {
		mGui = gui;
		mData = data;
		initDataToGui();
	}
	
	private void initDataToGui() {
		String text;
		
		// init buttons
		
//		text = challenge.getAnswer1Text();
//		mGui.setTextInButtonAnswer1Text(text);
		
	}


	public void onButtonClicked(int i) {
		switch ( i ) {
		case 1:   // Call CardFile1
			//Navigation.startActivityLMode(CardFileID);
			break;
		case 2:   // Call CardFile2
			//Navigation.startActivityLMode(CardFileID);
			break;
		case 3:   // Call CardFile3
			//Navigation.startActivityLMode(CardFileID);
			break;
		case 4:   // Call CardFile4
			//Navigation.startActivityLMode(CardFileID);
			break;
		case 5:   // Call CardFile5
			//Navigation.startActivityLMode(CardFileID);
			break;
		case 6:   // Call CardFile6
			//Navigation.startActivityLMode(CardFileID);
			break;
		case 7:   // Call CardFile7
			//Navigation.startActivityLMode(CardFileID);
			break;
		case 8:   // Call CardFile8
			//Navigation.startActivityLMode(CardFileID);
			break;
		}
	}

}
