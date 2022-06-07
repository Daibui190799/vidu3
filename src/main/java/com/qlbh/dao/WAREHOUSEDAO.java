
import com.qlbh.dao.QLBHDAO;
import com.qlbh.entity.WAREHOUSE;
import com.qlbh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Acer
 */
public class WAREHOUSEDAO extends QLBHDAO<WAREHOUSE, String> {

    String INSERT_SQL = "INSERT INTO WAREHOUSE ( MASP,  TENSP,  SOLUONG,  DONGIA,  HINH, GHICHU) VALUES (?, ?, ?,?, ?, ?)";
    String UPDATE_SQL = "UPDATE WAREHOUSE SET MASP=?, TENSP=?, SOLUONG=?, DONGIA=?, HINH=?, GHICHU=?  WHERE MASP=?";
    String DELETE_SQL = "DELETE FROM WAREHOUSE WHERE MASP=?";
    String SELECT_ALL_SQL = "SELECT * FROM WAREHOUSE";
    String SELECT_BY_ID_SQL = "SELECT * FROM WAREHOUSE WHERE MASP=?";

    @Override
    public void insert(WAREHOUSE entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMASP(), entity.getTENSP(), entity.getSOLUONG(), entity.getDONGIA(), entity.getHINH(),
                    entity.getGHICHU());
        } catch (SQLException ex) {
            Logger.getLogger(WAREHOUSEDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(WAREHOUSE entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMASP(), entity.getTENSP(), entity.getSOLUONG(), entity.getDONGIA(), entity.getHINH(),
                    entity.getGHICHU());
        } catch (SQLException ex) {
            Logger.getLogger(WAREHOUSEDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(WAREHOUSEDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public WAREHOUSE selectebyID(String id) {
        List<WAREHOUSE> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<WAREHOUSE> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<WAREHOUSE> selectbySql(String sql, Object... args) {
        List<WAREHOUSE> list = new ArrayList<WAREHOUSE>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                WAREHOUSE entity = new WAREHOUSE();
                entity.setMASP(rs.getString("MASP"));
                entity.setTENSP(rs.getString("TENSP"));
                entity.setSOLUONG(rs.getDouble("SOLUONG"));
                entity.setDONGIA(rs.getDouble("DONGIA"));
                entity.setHINH(rs.getString("HINHANH"));
                entity.setGHICHU(rs.getString("GHICHU"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}
