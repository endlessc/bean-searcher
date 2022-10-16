package cn.zhxu.bs.dialect;


import cn.zhxu.bs.SqlWrapper;
import cn.zhxu.bs.param.Paging;

/**
 * PostgreSQL 方言实现
 * @author Troy.Zhou @ 2022-04-19
 * @since v3.6.0
 * */
public class PostgreSqlDialect implements Dialect {
	
	@Override
	public SqlWrapper<Object> forPaginate(String fieldSelectSql, String fromWhereSql, Paging paging) {
		SqlWrapper<Object> wrapper = new SqlWrapper<>();
		StringBuilder ret = new StringBuilder();
		ret.append(fieldSelectSql).append(fromWhereSql);
		if (paging != null) {
			ret.append(" offset ? limit ?");
			wrapper.addPara(paging.getOffset());
			wrapper.addPara(paging.getSize());
		}
		wrapper.setSql(ret.toString());
		return wrapper;
	}

	@Override
	public boolean hasILike() {
		return true;
	}
	
}
