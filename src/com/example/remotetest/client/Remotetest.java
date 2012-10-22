package com.example.remotetest.client;

import java.awt.TextField;

import com.example.remotetest.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
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
		TabLayoutPanel tabPanel = new TabLayoutPanel(2.5, Unit.EM);
		FlexTable ft3 = new FlexTable();
		FlexCellFormatter cf3 = ft3.getFlexCellFormatter();
		DecoratorPanel dp3 = new DecoratorPanel();
		HorizontalPanel hp = new HorizontalPanel();
		Button plusButton = new Button("+");
		Button minusButton = new Button("-");
		Button devideButton = new Button("/");
		Button multiplyButton = new Button("*");
		hp.add(plusButton);
		hp.add(minusButton);
		hp.add(devideButton);
		hp.add(multiplyButton);
		final TextBox l1 = new TextBox();
		final TextBox l2 = new TextBox();
		final Label wynik = new Label();
		ft3.setHTML(0,0,"Podaj pierwsza liczbe:");
		ft3.setWidget(0,1, l1);
		ft3.setHTML(1,0, "Podaj druga liczbe:");
		ft3.setWidget(1,1,l2);
		ft3.setHTML(2,0, "Wybierz operacje:");
		ft3.setWidget(2, 1, hp);
		ft3.setHTML(3,0, "Wynik");
		ft3.setWidget(3,1, wynik);
		dp3.add(ft3);
		//RootPanel.get("mainContainer").add(hp);
		//pan1.add(hp);
		tabPanel.add(dp3, new HTML("Prosty kalkulator"));
		final TextBox t1 = new TextBox();
		final ListBox list = new ListBox();
		list.addItem("2");
		list.addItem("4");
		list.addItem("8");
		list.addItem("16");
		final Label wynik10 = new Label();
		FlexTable ft = new FlexTable();
		Button przeliczButton = new Button("Przelicz");
		ft.setHTML(0, 0, "Podaj liczbe w systemie 10:");
		ft.setWidget(0, 1, t1);
		ft.setHTML(1, 0, "Podaj docelowy system liczbowy:");
		ft.setWidget(1, 1, list);
		ft.setHTML(2, 0, "Wynik:");
		ft.setWidget(2, 1, wynik10);
		ft.setWidget(3, 0, przeliczButton);
		FlexCellFormatter cf = ft.getFlexCellFormatter();
		DecoratorPanel dp = new DecoratorPanel();
		cf.setColSpan(3,0,2);
		cf.setHorizontalAlignment(3,0,HasHorizontalAlignment.ALIGN_CENTER);
		dp.setWidget(ft);
		tabPanel.add(dp, new HTML("Przeliczanie z 10 na inne"));
		FlexTable ft2 = new FlexTable();
		FlexCellFormatter cf2 = ft2.getFlexCellFormatter();
		DecoratorPanel dp2 = new DecoratorPanel();
		final TextBox t2 = new TextBox();
		final ListBox list2 = new ListBox();
		list2.addItem("2");
		list2.addItem("4");
		list2.addItem("8");
		list2.addItem("16");
		Button przelicztoButton = new Button("Przelicz");
		final Label wynik20 = new Label();
		ft2.setHTML(0, 0, "Podaj system w jakim zapisana jest liczba:");
		ft2.setWidget(0, 1, list2);
		ft2.setHTML(1, 0, "Podaj liczbe:");
		ft2.setWidget(1, 1, t2);
		ft2.setHTML(2, 0, "Wynik:");
		ft2.setWidget(2, 1, wynik20);
		ft2.setWidget(3, 0, przelicztoButton);
		cf2.setColSpan(3,0,2);
		cf2.setHorizontalAlignment(3,0,HasHorizontalAlignment.ALIGN_CENTER);
		dp2.setWidget(ft2);
		//RootPanel.get("mainContainer").add(tabPanel);
		tabPanel.add(dp2, new HTML("Przeliczanie do systemu 10"));
		RootLayoutPanel.get().add(tabPanel);
		przelicztoButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				calcService.przeliczto10(t2.getText(), Integer.parseInt(list.getItemText(list.getSelectedIndex())), new AsyncCallback<Integer>() {

					@Override
					public void onFailure(Throwable caught) {
						wynik.setText(SERVER_ERROR);
						
					}
					@Override
					public void onSuccess(Integer result) {
						wynik20.setText(" " + result);
						
					}
				});
				
			}
		});
		przeliczButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				calcService.przelicz10(Integer.parseInt(t1.getText()), Integer.parseInt(list.getItemText(list.getSelectedIndex())), new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						wynik.setText(SERVER_ERROR);
						
					}
					@Override
					public void onSuccess(String result) {
						wynik10.setText(" " + result);
						
					}
				});
				
			}
		});
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
		minusButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				calcService.odejmij(Integer.parseInt(l1.getText()), Integer.parseInt(l2.getText()), new AsyncCallback<Integer>() {

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
		devideButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				calcService.dziel(Integer.parseInt(l1.getText()), Integer.parseInt(l2.getText()), new AsyncCallback<Double>() {

					@Override
					public void onFailure(Throwable caught) {
						wynik.setText(SERVER_ERROR);
						
					}

					@Override
					public void onSuccess(Double result) {
						wynik.setText("" + result);
						
					}
				});
				
			}
		});
		multiplyButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				calcService.mnoz(Integer.parseInt(l1.getText()), Integer.parseInt(l2.getText()), new AsyncCallback<Double>() {

					@Override
					public void onFailure(Throwable caught) {
						wynik.setText(SERVER_ERROR);
						
					}

					@Override
					public void onSuccess(Double result) {
						wynik.setText("" + result);
						
					}
				});
				
			}
		});
	}
}
