package com.example.remotetest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CalcServiceAsync {

	void dziel(int l1, int l2, AsyncCallback<Double> callback);
	void mnoz(int l1, int l2, AsyncCallback<Double> callback);
	void dodaj(int l1, int l2, AsyncCallback<Integer> callback);
	void odejmij(int l1, int l2, AsyncCallback<Integer> callback);
	void przelicz10(int parseInt, int parseInt2, AsyncCallback<String> asyncCallback);
	void przeliczto10(String parseInt, int parseInt2, AsyncCallback<Integer> asyncCallback);
}
