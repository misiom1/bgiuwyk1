package com.example.remotetest.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("kalkulator")
public interface CalcService extends RemoteService {
	
	Double dziel(int l1, int l2);
	Double mnoz(int l1, int l2);
	Integer dodaj(int l1, int l2);
}
