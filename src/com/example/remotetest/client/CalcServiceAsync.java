package com.example.remotetest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CalcServiceAsync {

	void dziel(int l1, int l2, AsyncCallback<Double> callback);
	void mnoz(int l1, int l2, AsyncCallback<Double> callback);
	void dodaj(int l1, int l2, AsyncCallback<Integer> callback);
}
