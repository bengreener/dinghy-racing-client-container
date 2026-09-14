package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel;

import java.time.Duration;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.SignedUpHalDTO;


public class SignedUp extends AbstractMVCEntity implements Comparable<SignedUp> {
	
	private SignedUpHalDTO signedUpHalDTO;
	
	private Entry entry;

	public SignedUp(SignedUpHalDTO signedUpHalDTO, RestClient restClient) {
		super(restClient);
		this.signedUpHalDTO = signedUpHalDTO;
	}
	
	public Duration getCorrectedTime() {
		return signedUpHalDTO.getCorrectedTime();
	}
	
	public Integer getPosition() {
		return signedUpHalDTO.getPosition();
	}
	
	public Entry getEntry() {
		if (entry == null) {
			entry = new Entry(restClient.getEntryByURL(signedUpHalDTO.getLinks().get("entry").getHref()), restClient);
		}
		return entry;
	}

	@Override
	public int compareTo(SignedUp signedUp) {
		return signedUpHalDTO.getPosition().compareTo(signedUp.getPosition());
	}
}
