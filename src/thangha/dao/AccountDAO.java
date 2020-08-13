package thangha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import thangha.dto.AccountDTO;
import thangha.util.DBUtils;

public class AccountDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	private void closeConnection() throws SQLException {
		if (rs != null) {
			rs.close();
		}

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

	public AccountDTO checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
		AccountDTO result = null;
		try {
			conn = DBUtils.getConnection();
			if (conn != null) {
				String sql = "SELECT Fullname FROM Account WHERE Username = ? AND Password = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);

				rs = ps.executeQuery();

				if (rs.next()) {
					String fullname = rs.getNString("Fullname");
					result = new AccountDTO(username, fullname);
				}
			}
		} finally {
			closeConnection();
		}
		return result;
	}

	public boolean insertNewAccount(AccountDTO dto) throws ClassNotFoundException, SQLException {
		boolean result = false;
		try {
			conn = DBUtils.getConnection();
			if (conn != null) {
				String sql = "INSERT INTO Account(Username, Password, Fullname) VALUES(?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getUsername());
				ps.setString(2, dto.getPassword());
				ps.setString(3, dto.getFullname());

				result = (ps.executeUpdate() > 0);
			}
		} finally {
			closeConnection();
		}
		return result;
	}

	public List<AccountDTO> searchAccount(String search) throws ClassNotFoundException, SQLException {
		List<AccountDTO> result = null;
		try {
			conn = DBUtils.getConnection();
			if (conn != null) {
				String sql = "SELECT Username, Fullname FROM Account WHERE Fullname LIKE ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%" + search + "%");
				rs = ps.executeQuery();

				while (rs.next()) {
					String username = rs.getString("Username");
					String fullname = rs.getString("Fullname");
					AccountDTO dto = new AccountDTO(username, fullname);
					if (result == null) {
						result = new ArrayList<AccountDTO>();
					}
					result.add(dto);
				}
			}
		} finally {
			closeConnection();
		}
		return result;
	}

	public boolean updateAccount(AccountDTO dto) throws ClassNotFoundException, SQLException {
		boolean result = false;
		try {
			conn = DBUtils.getConnection();
			if (conn != null) {
				String sql = "UPDATE Account SET Password = ?, Fullname = ? WHERE Username = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getPassword());
				ps.setString(2, dto.getFullname());
				ps.setString(3, dto.getUsername());
				
				result = (ps.executeUpdate() > 0);
			}
		} finally {
			closeConnection();
		}
		return result;
	}

	public boolean deleteAccount(String username) throws ClassNotFoundException, SQLException {
		boolean result = false;
		try {
			conn = DBUtils.getConnection();
			if (conn != null) {
				String sql = "DELETE FROM Account WHERE Username = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				
				result = (ps.executeUpdate() > 0);
			}
		} finally {
			closeConnection();
		}
		return result;
	}
}
