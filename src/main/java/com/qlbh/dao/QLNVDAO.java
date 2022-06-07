
import com.qlbh.dao.QLBHDAO;
import com.qlbh.entity.QLNV;
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
public class QLNVDAO extends QLBHDAO<QLNV, String> {

    String INSERT_SQL = "INSERT INTO QLNV ( MANV,  HOTENNV,  GIOITINH,  SDT, DIACHI, VAITRO,  HINH,  STORY,  LUONG,  MATKHAU) {\n"
            + "        VALUES (?, ?, ?,?,?, ?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE QLNV SET MANV=?, HOTENNV=?, GIOITINH=?, SDT=?, NgTao=?, DIACHI=?,VAITRO=?, HINH=?,STORY=?,LUONG=?,MATKHAU=?, WHERE MANV=?";
    String DELETE_SQL = "DELETE FROM QLNV WHERE MANV=?";
    String SELECT_ALL_SQL = "SELECT * FROM QLNV";
    String SELECT_BY_ID_SQL = "SELECT * FROM QLNV WHERE MANV=?";

    @Override
    public void insert(QLNV entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMANV(), entity.getHOTENNV(), entity.isGIOITINH(), entity.getSDT(), entity.isVAITRO(),
                    entity.getHINH(), entity.getLUONG(), entity.getMATKHAU());
        } catch (SQLException ex) {
            Logger.getLogger(QLNVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(QLNV entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMANV(), entity.getHOTENNV(), entity.isGIOITINH(), entity.getSDT(), entity.isVAITRO(),
                    entity.getHINH(), entity.getLUONG(), entity.getMATKHAU());
        } catch (SQLException ex) {
            Logger.getLogger(QLNVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLNVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public QLNV selectebyID(String id) {
        List<QLNV> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QLNV> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<QLNV> selectbySql(String sql, Object... args) {
        List<QLNV> list = new ArrayList<QLNV>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                QLNV entity = new QLNV();
                entity.setMANV(rs.getString("MANV"));
                entity.setHOTENNV(rs.getString("HOTENNV"));
                entity.setGIOITINH(rs.getBoolean("GioiTinh"));
                entity.setSDT(rs.getString("SDT"));
                entity.setDIACHI(rs.getString("DIACHI"));
                entity.setVAITRO(rs.getBoolean("VAITRO"));
                entity.setHINH(rs.getString("Hinh"));
                entity.setSTORY(rs.getString("STORY"));
                entity.setLUONG(rs.getDouble("Luong"));
                entity.setMATKHAU(rs.getString("MATKHAU"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}
