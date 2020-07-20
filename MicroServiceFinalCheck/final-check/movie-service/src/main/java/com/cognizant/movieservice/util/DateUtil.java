package com.cognizant.movieservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.java.Log;

@Log
public class DateUtil {

	public static Date convertToDate(String date) {
		log.info("START");
		Date dateFormatter = null;
		try {
			dateFormatter = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		log.info("END");
		return dateFormatter;
	}
}
