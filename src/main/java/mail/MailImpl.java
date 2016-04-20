package mail;

import java.util.Date;

import entity.Report;

public class MailImpl implements Mail {

	private String header;
	private String footer;
	private String systemUrl;

	public MailImpl() {

	}

	@Override
	public String buildSubject(Report report) {
		String name = report.getOwner().getUserShared().getUsername();
		String type = report.getRoute();
		String subject = name + " applied for " + type + " Business trip notice";
		return subject;
	}

	@Override
	public String buildBody(Report report) {
		String name = report.getOwner().getUserShared().getUsername();
		String type = report.getRoute();
		Date start = report.getStartDate();
		Date end = report.getEndDate();
		String reason = report.getReason();

		String body = header + "\n" + name + " applied for " + type + ", please confirm it in the btrs system: "
				+ systemUrl + "\n" + "Start Date : " + start + "\nEnd Date : " + end + " \n" + reason
				+ "\n--------------------------------------------------------------------\n" + footer;
		return body;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getSystemUrl() {
		return systemUrl;
	}

	public void setSystemUrl(String systemUrl) {
		this.systemUrl = systemUrl;
	}

}
