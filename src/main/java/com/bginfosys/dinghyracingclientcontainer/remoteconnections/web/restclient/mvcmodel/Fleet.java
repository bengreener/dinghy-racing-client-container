package com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.mvcmodel;

import java.util.List;
import java.util.stream.Collectors;

import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.RestClient;
import com.bginfosys.dinghyracingclientcontainer.remoteconnections.web.restclient.halmodel.FleetHalDTO;

public class Fleet extends AbstractMVCEntity {

	private FleetHalDTO fleetHalDTO;
	
	private List<DinghyClass> dinghyClasses;
	
	public Fleet(FleetHalDTO fleetHalDTO, RestClient restClient) {
		super(restClient);
		this.fleetHalDTO = fleetHalDTO;
	}
	
	public String getName() {
		return fleetHalDTO.getName();
	}
	
	public List<DinghyClass> getDinghyClasses() {
		if (dinghyClasses == null) {
			List<DinghyClass> dc = restClient.getDinghyClassesByURL(fleetHalDTO.getLinks().get("dinghyClasses").getHref())
				.stream().map(dinghyClassHalDTO -> new DinghyClass(dinghyClassHalDTO, restClient)).collect(Collectors.toList());
			if (dc.size() < 1) {
				// Race is an open handicap. Get all dinghy classes.
				// Spring Data Rest will return a paged response. Set page size to include all dinghy classes and avoid multiple trips.
				dc = restClient.getDinghyClassesByURL(restClient.getHttpRootURL() + "/dinghyClasses?page=0&size=500")
						.stream().map(dinghyClassHalDTO -> new DinghyClass(dinghyClassHalDTO, restClient)).collect(Collectors.toList());
			}
			dinghyClasses = dc;
		}
		return dinghyClasses;
	}
}
