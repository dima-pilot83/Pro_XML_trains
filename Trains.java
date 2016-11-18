package ru.mail.dimapilot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trains")
public class Trains {

	@XmlElement(name = "train")
	protected static List<Train> listtrain = new ArrayList<Train>();

	public List<Train> getListtrain() {
		return listtrain;
	}

	public void setListtrain(List<Train> listtrain) {
		this.listtrain = listtrain;
	}

	public static void add(Train train) {
		listtrain.add(train);
	}

	@Override
	public String toString() {
		return Arrays.deepToString(listtrain.toArray());
	}

}
