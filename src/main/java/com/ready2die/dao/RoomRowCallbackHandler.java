package com.ready2die.dao;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.util.StringUtils;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomRowCallbackHandler implements RowCallbackHandler {
    @Override
    public void processRow(ResultSet rs) throws SQLException {

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(File.createTempFile("room_", ".csv")), "UTF-8"
        ))) {

            while (rs.next()) {
                Object[] array = new Object[]{
                        rs.getString("room_id"),
                        rs.getString("room_name"),
                        rs.getInt("capacity")
                };
                String reportRow = StringUtils.arrayToCommaDelimitedString(array);
                writer.write(reportRow);
                writer.newLine();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
