package cn.zhxu.bs.operator;

import cn.zhxu.bs.FieldOp;
import cn.zhxu.bs.SqlWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 非空运算符
 * @author Troy.Zhou @ 2022-01-19
 * @since v3.3.0
 */
public class NotEmpty implements FieldOp {

    @Override
    public String name() {
        return "NotEmpty";
    }

    @Override
    public boolean isNamed(String name) {
        return "ny".equals(name) || "NotEmpty".equals(name);
    }

    @Override
    public boolean lonely() {
        return true;
    }

    @Override
    public List<Object> operate(StringBuilder sqlBuilder, OpPara opPara) {
        SqlWrapper<Object> fieldSql = opPara.getFieldSql();
        String sql = fieldSql.getSql();
        List<Object> paras = fieldSql.getParas();
        sqlBuilder.append(sql).append(" is not null");
        sqlBuilder.append(" and ").append(sql).append(" != ''");
        List<Object> params = new ArrayList<>(paras);
        params.addAll(paras);
        return params;
    }

}
