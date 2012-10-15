package com.example.remotetest.client;

import com.example.remotetest.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Remotetest implements EntryPoint {

	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private final CalcServiceAsync calcService = GWT
			.create(CalcService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		HorizontalPanel hp = new HorizontalPanel();
		Button plusButton = new Button("+");
		final TextBox l1 = new TextBox();
		final TextBox l2 = new TextBox();
		final Label wynik = new Label(" czekam na wynik ");
		
		hp.add(l1);
		hp.add(plusButton);
		hp.add(l2);
		hp.add(wynik);
		RootPanel.get("mainContainer").add(hp);
		
		plusButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				calcService.dodaj(Integer.parseInt(l1.getText()), Integer.parseInt(l2.getText()), new AsyncCallback<Integer>() {

					@Override
					public void onFailure(Throwable caught) {
						wynik.setText(SERVER_ERROR);
						
					}

					@Override
					public void onSuccess(Integer result) {
						wynik.setText("" + result);
						
					}
				});
				
			}
		});
	}
}
