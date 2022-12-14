package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopping.model.Item;
import com.shopping.util.DBConnection;

public class ItemDAO {
	public List<Item> getItem() throws SQLException, ClassNotFoundException {
		List<Item> itemList = new ArrayList<Item>();

		Connection conn = DBConnection.getConnection();
		String query = "SELECT * FROM \"item\"";
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			Item item = new Item(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getInt(4), rs.getString(5),
					rs.getString(6), rs.getDate(8), rs.getLong(9), rs.getLong(10), rs.getLong(11));
			itemList.add(item);
		}

		return itemList;
	}

	public void insertItem(Item item) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getConnection();
		String query = "INSERT INTO \"item\"(id, name , price , saled , describe , img , releaseDate ,idCategory ,idProducer ,idShop) VALUES(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, item.getId());
		ps.setString(2, item.getName());
		ps.setLong(3, item.getPrice());
		ps.setLong(4, item.getSaled());
		ps.setString(5, item.getDescribe());
		ps.setString(6, item.getImg());
		ps.setDate(7, (Date) item.getReleaseDate());
		ps.setLong(8, item.getIdCategory());
		ps.setLong(9, item.getIdProducer());
		ps.setLong(10, item.getIdShop());

		ps.executeUpdate();
	}

	public void updateItem(Item item) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getConnection();
		String query = "UPDATE \"item\" SET id = ?, name = ?, price = ?, saled = ?, describe = ?, img = ?, releaseDate = ?,idCategory = ?,idProducer = ?,idShop = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, item.getId());
		ps.setString(2, item.getName());
		ps.setLong(3, item.getPrice());
		ps.setLong(4, item.getSaled());
		ps.setString(5, item.getDescribe());
		ps.setString(6, item.getImg());
		ps.setDate(7, (Date) item.getReleaseDate());
		ps.setLong(8, item.getIdCategory());
		ps.setLong(9, item.getIdProducer());
		ps.setLong(10, item.getIdShop());
		ps.setLong(11, item.getId());

		ps.executeUpdate();
	}

	public Boolean deleteItem(long id) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getConnection();
		String query = "DELETE FROM \"item\" WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, id);
		int i = ps.executeUpdate();

		if (i != 0) {
			return true;
		}
		return false;
	}
}
