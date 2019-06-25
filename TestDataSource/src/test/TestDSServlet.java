package test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;

@WebServlet("/TestDSServlet")
public class TestDSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestDSServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlMapClient smc = DbOperationFactory.newInstance().getSqlMapClient();
		String sql = "exec SP_RPT_ICSIW03 1,'2018121300200001000330','IW'";
		try (
			Connection conn = smc.getDataSource().getConnection();
	    		PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				Object o = rs.getObject("FONT IMAGE");
				InputStream is = rs.getBinaryStream("FONT IMAGE");
//				Blob bl = rs.getBlob("FONT IMAGE");
				response.getWriter().append("get Object: ").append(o.getClass().getName())
				.append("<br>").append("get InputStream: ").append(is.getClass().getName())
//				.append("<br>").append("get Blob: ").append(bl.getClass().getName())
				.append("<br>");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
