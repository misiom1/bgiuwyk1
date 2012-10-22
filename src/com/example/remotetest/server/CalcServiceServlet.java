package com.example.remotetest.server;

import java.io.Console;

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

	@Override
	public Integer odejmij(int l1, int l2) {
		return l1 - l2;
	}
	private static final int MAX_BASE = 36;
	private static final String pattern = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	@Override
	public String przelicz10(int n, int base) {
		String result = "";
		if((base > MAX_BASE) || (base < 2))
			return null;
		if(n == 0)
			return "0";
		while(n > 0) {
			result = pattern.charAt(n % base) + result;
			n /= base;
		}
		return result;
	}
	private static int valueOf(char x, int base) {
		for (int i = 0; i < base; i++) {
			if(x == pattern.charAt(i)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Integer przeliczto10(String n, int base) {
		int i, x;
		int p = 1;
		int result = 0;
		if((base > MAX_BASE) || (base < 2))
			return 0;
		n = n.toUpperCase();
		for(i = n.length()-1; i>=0; i--) {
			x = valueOf(n.charAt(i), base);
			if(x < 0) {
				return 0;
			}
			result += (x * p);
			p *= base;
		}
		return result;
	}

}
