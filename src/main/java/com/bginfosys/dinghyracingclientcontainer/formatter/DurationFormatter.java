package com.bginfosys.dinghyracingclientcontainer.formatter;

import java.time.Duration;

import org.springframework.stereotype.Component;

@Component("durationFormatter")
public class DurationFormatter {

	public String format(Duration duration) {
	    Long hours = duration.getSeconds() / 3600;
        Long minutes = duration.getSeconds() / 60;
        Long seconds = duration.getSeconds() % 60;
	    if (hours > 0) {
	    		return String.format("%02d:%02d:%02d", hours, minutes, seconds);	
	    }
	    return String.format("%02d:%02d", minutes, seconds);
	}	
	
}
