package it.polito.tdp.poweroutages.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.Outages;

public class PowerOutageDAO {

	public List<Nerc> getNercList() {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}

	public List<Outages> getOutagesList(Nerc nerc) {

		int id = nerc.getId();

		String sql = "SELECT * FROM PowerOutages WHERE nerc_id = ?";
		List<Outages> outagesList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				LocalDateTime dataInizio = res.getTimestamp("date_event_began").toLocalDateTime();
				int anno = dataInizio.getYear();
				LocalDateTime dataFine = res.getTimestamp("date_event_finished").toLocalDateTime();
				int tag_id = res.getInt("tag_id");
				int persone = res.getInt("customers_affected");
				Outages o = new Outages(anno, dataInizio, dataFine, tag_id, persone);
				outagesList.add(o);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return outagesList;

	}
}
