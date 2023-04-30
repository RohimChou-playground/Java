package com.rohim.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpsRepository {

	private DataSource dataSource;

	public EmpsRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<String> getAll() {
		List<String> emps = new ArrayList<>();

		try (Connection conn = this.dataSource.getConnection();
			 PreparedStatement prepStatement = conn.prepareStatement("select id, name from emps");
			 ResultSet resultSet = prepStatement.executeQuery();) {

			while (resultSet.next()) {
				emps.add(resultSet.getString("NAME"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return emps;
	}
}
