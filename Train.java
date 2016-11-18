package ru.mail.dimapilot;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "train")
public class Train {

	@XmlAttribute
	private Integer id;
	private String from;
	private String to;
	private String departureDate;
	private String departureTime;

	
	public Train() {

	}

	public Train(Integer id, String from, String to, String departureDate, String departureTime) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Train [from=" + from + ", to=" + to + ", departureDate=" + departureDate + ", departureTime="
				+ departureTime + "]";
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public void setFrom(String from) {
		this.from = from;
	}

	@XmlElement
	public void setTo(String to) {
		this.to = to;
	}

	@XmlElement(name = "date")
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	@XmlElement(name = "departure")
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

}
