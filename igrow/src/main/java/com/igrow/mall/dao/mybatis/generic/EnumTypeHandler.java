/**
* @FileName EnumTypeHandler.java
* @Package com.homeinns.dao.mybatis.generic
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-9-13 下午4:57:45
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.generic;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumSet;

import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * @ClassName EnumTypeHandler
 * @Description TODO【枚举类型控制器】
 * @Author Brights
 * @Date 2013-9-13 下午4:57:45
 */
@SuppressWarnings("rawtypes")
@Alias("myEnumTypeHandler")
public class EnumTypeHandler extends BaseTypeHandler<Enum> implements TypeHandler<Enum> {

	private Class<Enum> clazz;
	
	public EnumTypeHandler(Class<Enum> clazz) {
		this.clazz = clazz;
	}

	public void setNonNullParameter(PreparedStatement ps, int i,
			Enum parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.ordinal());
	}

	public Enum getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		final int val = rs.getInt(columnName);
		Enum obj = null;
        if (!rs.wasNull() ) {
            @SuppressWarnings("unchecked")
            EnumSet enumSet = EnumSet.allOf(clazz);
            for (Object object : enumSet) {
                if (object instanceof Enum) {
                    Enum e = (Enum) object;
                    if (e.ordinal() == val) {
                        obj = e;
                    }
                }
            }
        }
        return obj;
	}
	
	
	public Enum getNullableResult(ResultSet rs, int index)
			throws SQLException {
		final int val = rs.getInt(index);
		Enum obj = null;
        if (!rs.wasNull() ) {
            @SuppressWarnings("unchecked")
            EnumSet enumSet = EnumSet.allOf(clazz);
            for (Object object : enumSet) {
                if (object instanceof Enum) {
                    Enum e = (Enum) object;
                    if (e.ordinal() == val) {
                        obj = e;
                    }
                }
            }
        }
        return obj;
	}

	public Enum getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		final int val = cs.getInt(columnIndex);
		Enum obj = null;
        if (!cs.wasNull() ) {
            @SuppressWarnings("unchecked")
            EnumSet enumSet = EnumSet.allOf(clazz);
            for (Object object : enumSet) {
                if (object instanceof Enum) {
                    Enum e = (Enum) object;
                    if (e.ordinal() == val) {
                        obj = e;
                    }
                }
            }
        }
        return obj;
	}
}
