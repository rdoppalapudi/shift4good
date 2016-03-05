package com.shift4good.interview.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {

	private String logFileName;

	public LogParser(String fileName) {
		this.logFileName = fileName;
	}

	public void computeDateGroups() throws IOException {
		FileReader reader = new FileReader(new File(logFileName));
		BufferedReader br = new BufferedReader(reader);
		String line;
		int count = 0;
		String tmpDate = null;
		while ((line = br.readLine()) != null) {
			String eDate = extractDate(line);
			if (tmpDate == null) {
				tmpDate = eDate;
			}
			if (tmpDate.equals(eDate)) {
				count++;
			} else {
				System.out.println(tmpDate + " " + count);
				tmpDate = eDate;
				count = 1;
			}

		}
		System.out.println(tmpDate + " " + count);
		br.close();
	}

	public String extractDate(String str) {
		String pattern = "([A-Z])\\w+ \\d+ \\d+:\\d+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		if (m.find()) {
			return (m.group(0));
		}
		return "";
	}

	public void printLogFile() throws IOException {
		FileReader reader = new FileReader(new File(logFileName));
		BufferedReader br = new BufferedReader(reader);
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

	public static void main(String args[]) {
		LogParser lp = new LogParser("data/sample.log");
		try {
		    lp.printLogFile();
			lp.computeDateGroups();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
