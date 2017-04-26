package com.fincatto.nfe310.transformers;

import java.text.SimpleDateFormat;

import org.joda.time.LocalDateTime;
import org.simpleframework.xml.transform.Transform;

class NFLocalDateTimeTransformer implements Transform<LocalDateTime> {

	private static final SimpleDateFormat DATETIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	String[] formatStrings = { "yyyy-MM-dd'T'HH:mm:ssXXX", "yyyy-MM-dd'T'HH:mm:ss" };

	@Override
	public LocalDateTime read(final String data) throws Exception {

		for (String formatString : formatStrings) {
			try {
				return LocalDateTime.fromDateFields(new SimpleDateFormat(formatString).parse(data));
			} catch (Exception e) {
			}
		}

		return null;

		// return
		// LocalDateTime.fromDateFields(NFLocalDateTimeTransformer.DATETIME_FORMATTER.parse(data));
	}

	@Override
	public String write(final LocalDateTime data) throws Exception {
		return NFLocalDateTimeTransformer.DATETIME_FORMATTER.format(data.toDate());
	}
}