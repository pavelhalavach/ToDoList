package dbStuff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DBMethods {
//    private final static String INSERT_NEW = "INSERT INTO list (title, desc, attach, dueDate, createdAt) VALUES(?,?,?,?,?)";
    private final static String INSERT_NEW = "INSERT INTO list (title, description, attach, dueDate, createdAt) VALUES(?,?,?,?,?)";
    private final static String GET_ALL = "SELECT * FROM list";
    private final static String UPDATE = "UPDATE list SET title=?, description=?, attach=?, dueDate=? WHERE id=?";
    private final static String GET_ONE = "SELECT * FROM list WHERE title=?";
    private static final String DELETE = "DELETE FROM list WHERE title=?";
    private static final String CREATE_DB = "CREATE DATABASE IF NOT EXISTS `todolist`";
    private static final String USE_DB = "USE `todolist`";
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS `list` ( `id` int NOT NULL AUTO_INCREMENT, `title` varchar(100) NOT NULL," +
            " `description` varchar(300) DEFAULT NULL, `attach` longblob, `dueDate` date NOT NULL, `createdAt` date NOT NULL,  PRIMARY KEY (`id`)," +
            "  UNIQUE KEY `id_UNIQUE` (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
    private final DBConnection worker = new DBConnection();
//    Создаю в конструкторе to do list таблицу
    public DBMethods(){
        try (Statement statement = worker.getConnection().createStatement()){
            statement.addBatch(CREATE_DB);
            statement.addBatch(USE_DB);
            statement.addBatch(CREATE);
            statement.executeBatch();
            statement.clearBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    Вывод всех рядов таблицы
    public ArrayList<DBList> getAll(){
        try (Statement statement = worker.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            ArrayList<DBList> items = new ArrayList<DBList>();
            while (resultSet.next()){
                DBList list = new DBList();
//                list.setId(resultSet.getInt("id"));
                list.setTitle(resultSet.getString("title"));
//                list.setDesc(resultSet.getString("desc"));
//                list.setAttach(resultSet.getBytes("attach"));
//                list.setDueDate(resultSet.getDate("dueDate"));
//                list.setCreatedAt(resultSet.getDate("createdAt"));
                items.add(list);
            }
            return items;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
// Вывод одной строки из таблицы по названию
    public DBList getOne(String title){
        try (PreparedStatement preparedStatement = worker.getConnection().prepareStatement(GET_ONE)){
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            DBList list = new DBList();
            if(resultSet.next()){
                list.setId(resultSet.getInt("id"));
                list.setTitle(resultSet.getString("title"));
                list.setDesc(resultSet.getString("description"));
                InputStream attach = resultSet.getBinaryStream("attach");

                list.setAttach(attach);
                list.setDueDate(resultSet.getDate("dueDate"));
                list.setCreatedAt(resultSet.getDate("createdAt"));
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    Добавление новой строки в таблицу
    public void insertNew(String title, String desc, InputStream attach, String dueDate){
        try (PreparedStatement preparedStatement = worker.getConnection().prepareStatement(INSERT_NEW)){
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, desc);
            preparedStatement.setBlob(3, attach);
            preparedStatement.setDate(4, Date.valueOf(dueDate));
            preparedStatement.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
// Изменение строки из таблицы по id
    public void update(int id, String title, String desc, InputStream attach, String dueDate){
        try (PreparedStatement preparedStatement = worker.getConnection().prepareStatement(UPDATE)){
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, desc);
            preparedStatement.setBlob(3, attach);
            preparedStatement.setDate(4, Date.valueOf(dueDate));
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
// Удаление строки из таблицы
    public void delete(String title){
        try (PreparedStatement preparedStatement = worker.getConnection().prepareStatement(DELETE)){
            preparedStatement.setString(1, title);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
