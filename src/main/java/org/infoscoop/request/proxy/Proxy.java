/* infoScoop OpenSource
 * Copyright (C) 2010 Beacon IT Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0-standalone.html>.
 */

package org.infoscoop.request.proxy;

import java.util.Set;

import org.apache.commons.httpclient.Credentials;


public class Proxy {
	private String url;

	private String host;

	private int port;
	
	private int cacheLifeTime;

	private Credentials proxyCredential;

	private boolean useProxy;
	private boolean proxyAuth;

	private boolean allowAllHeader = false;
	private Set<String> allowedHeaders;
	private Set<String> sendingCookies;
	private boolean isIntranet = false;

	public String getHost() {
		return host;
	}

	void setProxyInfo(String host, int port) {
		this.host = host;
		this.port = port;
		this.useProxy = true;
	}

	/**
	 * Set the information for the certification of the proxy.
	 * @param username An userName for the certification of the proxy.
	 * @param password An password for the certification of the proxy.
	 * @param domain An domain name of the certification of the proxy.
	 * @param dchost A host name of domain controller(the machin name to certify).
	 */
	void setProxyCredentials(Credentials credential){
		this.proxyCredential = credential;
		this.proxyAuth = true;
	}

	public int getPort() {
		return port;
	}

	public String getUrl() {
		return url;
	}

	void setUrl(String url) {
		this.url = url;
	}

	public boolean isUseProxy() {
		return useProxy;
	}

	public boolean needsProxyAuth() {
		return this.proxyAuth;
	}

	public boolean isAllowAllHeader() {
		return ( allowedHeaders == null );
	}

	public Set<String> getAllowedHeaders() {
		return allowedHeaders;
	}
	public Set<String> getSendingCookies() {
		return sendingCookies;
	}
	/**
	 * Whether you use a custom header except RFC.
	 * The default value is "OFF".
	 * @param header
	 */
	public void setAllowedHeaders( Set<String> allowedHeaders ) {
		this.allowedHeaders = allowedHeaders;
	}

	public Credentials getProxyCredentials() {
		return this.proxyCredential;
	}

	public void setIntranet(boolean intranet) {
		this.isIntranet = intranet;
	}

	public boolean isIntranet(){
		return this.isIntranet;
	}

	public void setSendingCookies( Set<String> sendingCookies ) {
		this.sendingCookies = sendingCookies;
	}
	
	public void setCacheLifeTime(int cacheLifeTime){
		this.cacheLifeTime = cacheLifeTime;
	}
	
	public int getCacheLifeTime(){
		return this.cacheLifeTime;
	}
}
