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
		// if both positions are null values are equal
		if (this.getPosition() == null && signedUp.getPosition() == null) {
			return 0;
		}
		// if this.position is null - this entry came after any entry with a position
		if (this.getPosition() == null) {
			return 1;
		}
		// if signedUp position is null - this entry came before any entry without a position
		if (signedUp.getPosition() == null) {
			return -1;
		}
		return signedUpHalDTO.getPosition().compareTo(signedUp.getPosition());
	}
}
