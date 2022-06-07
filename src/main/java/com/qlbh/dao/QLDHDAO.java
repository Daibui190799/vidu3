
import com.qlbh.dao.QLBHDAO;
import com.qlbh.entity.QLDH;
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
public class QLDHDAO extends QLBHDAO<QLDH, String> {

    String INSERT_SQL = "INSERT INTO QLDH (  MADH,  MANV,  MAKH,  DONGIA,  NgTao, GHICHU) VALUES (?, ?, ?,?, ?, ?)";
    String UPDATE_SQL = "UPDATE QLDH SET MADH=?, MANV=?, MAKH=?, DONGIA=?, NgTao=?, GHICHU=?  WHERE MADH=?";
    String DELETE_SQL = "DELETE FROM QLDH WHERE MADH=?";
    String SELECT_ALL_SQL = "SELECT * FROM QLDH";
    String SELECT_BY_ID_SQL = "SELECT * FROM QLDH WHERE MADH=?";

    @Override
    public void insert(QLDH entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMADH(), entity.getMANV(), entity.getMAKH(), entity.getDONGIA(), entity.getNgTao(),
                    entity.getGHICHU());
        } catch (SQLException ex) {
            Logger.getLogger(QLDHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(QLDH entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMADH(), entity.getMANV(), entity.getMAKH(), entity.getDONGIA(), entity.getNgTao(),
                    entity.getGHICHU());
        } catch (SQLException ex) {
            Logger.getLogger(QLDHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLDHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public QLDH selectebyID(String id) {
        List<QLDH> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QLDH> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<QLDH> selectbySql(String sql, Object... args) {
        List<QLDH> list = new ArrayList<QLDH>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                QLDH entity = new QLDH();
                entity.setMADH(rs.getString("MADH"));
                entity.setMANV(rs.getString("MANV"));
                entity.setMAKH(rs.getString("MAKH"));
                entity.setDONGIA(rs.getDouble("DONGIA"));
                entity.setNgTao(rs.getDate("NgTao"));
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
