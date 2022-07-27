package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.model.question;




public class QuestionDao implements Dao<question> {

	@Override
	public Set<question> getAll() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + question.getTableName());

			Set<question> questions = new HashSet<question>();

			while (rs.next()) {
				question question = extractquestionFromResultSet(rs);
				questions.add(question);
			}

			return questions;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public question getOne(int id) {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + question.getTableName() + " WHERE id=" + id);

			while (rs.next()) {
				question question = extractquestionFromResultSet(rs);
				return question;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	private question extractquestionFromResultSet(ResultSet rs) throws SQLException {
		com.model.question question = new com.model.question();

		question.setId(rs.getInt("id"));
		question.setQuestion(rs.getString("question"));
		question.setOption1(rs.getString("option1"));
		question.setOption2(rs.getString("option2"));
		question.setOption3(rs.getString("option3"));
		question.setOption4(rs.getString("option4"));
		question.setAnswer(rs.getString("answer"));
		return question;
	}

	@Override
	public boolean insert(question item) {
		try {

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO " + question.getTableName()
						+ " (question, option1, option2, option3, option4, answer) VALUES (?, ?, ?, ?, ?, ?)");
				stmt.setString(1, item.getQuestion());
				stmt.setString(2, item.getOption1());
				stmt.setString(3, item.getOption2());
				stmt.setString(4, item.getOption3());
				stmt.setString(5, item.getOption4());
				stmt.setString(6, item.getAnswer());

				int i = stmt.executeUpdate();
				if (i == 1) {
					return true;
				}
				stmt.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			return false;
	}

	@Override
	public boolean update(int id, question item) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE " + question.getTableName()
					+ " SET question=?, option1=?, option2=?, option3=?, option4=?, answer=? WHERE id=?");
			stmt.setString(1, item.getQuestion());
			stmt.setString(2, item.getOption1());
			stmt.setString(3, item.getOption2());
			stmt.setString(4, item.getOption3());
			stmt.setString(4, item.getOption3());
			stmt.setString(5, item.getOption4());
			stmt.setString(6, item.getAnswer());
			stmt.setInt(7, id);

			int i = stmt.executeUpdate();
			if (i == 1) {
				return true;
			}
			stmt.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM " + question.getTableName() + " WHERE id=" + id);

			if (i == 1) {
				return true;
			}
			stmt.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}



}
