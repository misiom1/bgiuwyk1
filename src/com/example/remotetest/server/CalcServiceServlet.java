package com.example.remotetest.server;

import com.example.remotetest.client.CalcService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CalcServiceServlet extends RemoteServiceServlet implements
		CalcService {

	private static final long serialVersionUID = 1L;

	@Override
	public Double dziel(int l1, int l2) {
		return l1 * 1.0 / l2;
	}
	
	@Override
	public Double mnoz(int l1, int l2) {
		return l1 * l2 * 1.0;
	}

	@Override
	public Integer dodaj(int l1, int l2) {
		return l1 + l2;
	}

}
